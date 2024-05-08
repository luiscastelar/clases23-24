#curso23_24 #ED [estado::done] 

# Desarrollo con contenedores

## 0. PREPARACIÓN:
Instalar *Docker Desktop* en aquellos equipos que lo permitan.

Para los que **NO**, o para los que quieran control total de su sistema docker (incluida la red):
+ Vagrantfile:
```ruby
Vagrant.configure("2") do |config|
  config.vm.box = "generic/debian12"
   config.vm.network "public_network"
   config.vm.synced_folder "./", "/vagrant"
   config.vm.provision "shell", path: "provision.sh"
  # config.vm.network "forwarded_port", guest: 80, host: 8080
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"
  # config.vm.provider "virtualbox" do |vb|
  #   vb.memory = "1024"
  # end
end
```

+ provision.sh:
```bash
apt-get update && apt-get install -y curl

sudo -u vagrant docker --version
if [[ ! $? -eq 0 ]]; then
	sudo -u vagrant curl -fsSL https://get.docker.com -o install-docker.sh
	sh install-docker.sh

	groupadd docker
	usermod -aG docker vagrant
fi
sudo -u vagrant docker --version

ip a | grep "inet "
```

## 1. DEFINIENDO la imagen:
Comenzamos con un ejemplo sencillo para ver los pasos de construcción de la imagen e instanciación del contenedor.
+ Dockerfile:
```Dockerfile
FROM debian:latest
RUN apt-get update && apt-get upgrade -y && apt-get install -y git

CMD ping google.es > /test.txt

ENV minombre Luis

COPY archivo.txt /home/$minombre/archiv.txt

ENTRYPOINT echo "Hola $minombre"
```

Para construir la imagen: `docker build -t luistest:version001 .`

Luego la instanciamos y corremos con `docker run --rm luistest:version001`

Para hacer las cosas algo más cómodas podemos crear un alias del tag a *latest* `docker tag luistest:version001 luistest:latest`, con lo que ahora podremos correrla con un simple `docker run --rm luistest`.

¿Pero y si queremos mostrar el contenido de archiv.txt? ` docker run --rm luistest cat /home/luis/archiv.txt`

### Fuentes: 
+ [Lo básico](https://luisiblogdeinformatica.com/crear-dockerfile/)
+ [Creando mi primera imagen](https://www.freecodecamp.org/espanol/news/guia-de-docker-para-principiantes-como-crear-tu-primera-aplicacion-docker/)


## 2. FLEXIBILIZANDO la imagen:
Comenzamos viendo la diferencia entre [cmd y entrypoint](https://programacionymas.com/blog/docker-diferencia-entrypoint-cmd)

Sustituiremos por tanto el *ENTRYPOINT* por:
```Dockerfile
...
ENTRYPOINT ["/bin/sh", "-c"]
CMD ["echo $minombre"]
```

Y ahora ejecutaremos ` docker run --rm luistest cat /home/luis/archiv.txt`

Para construir la imagen: `docker build -t luistest:version002 .`

*EL `ENTRYPOINT ["/bin/sh", "-c"]` es en realidad el valor por defecto, por lo que podremos omitirlo en realidad*.

## 3. Una imagen con aplicación Java stand-alone:
Vamos a realizar una base sobre la que podremos en realidad ejecutar aplicaciones Java (versión < 22) incluso con las *preview features*.

+ Dockerfile:
```Dockerfile
FROM eclipse-temurin:21
RUN mkdir -p /opt/app && mkdir /opt/app/src

COPY Main.java conf.properties /opt/app/src/

WORKDIR /opt/app/src
RUN javac --enable-preview --source 21 Main.java

CMD ["java", "--enable-preview", "Main"]
```

+ Main.java:
```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

void main(){
    Properties properties= new Properties();
    
    try {
      properties.load(new FileInputStream(new File("conf.properties")));
      
      System.out.println(properties.get("DRIVER"));
      System.out.println(properties.get("URL"));
      System.out.println(properties.get("USUARIO"));
      System.out.println(properties.get("CLAVE"));
    } catch (FileNotFoundException e) {
      // Gestión de excepción por no existir archivo
      e.printStackTrace();
    } catch (IOException e) {
      // Gestión de excepción genérica
      e.printStackTrace();
    }
} // main()
```

+ Archivo de configuración (*properties*):
```properties
DRIVER=mysql
URL=mi.servidor.en.mi.dominio.es
USUARIO=3l.Pr0f3
CLAVE=4.Ti.T3.10.v0y.4.c0nt4r
```

Para construir la imagen: `docker build -t luistest:version003 .`

## 4. FLEXIBILIZANDO la ejecución
Podemos querer modificar los parámetros del archivo de configuración o incluso distribuir la imagen y que cada usuario pueda personalizarlo. 

Para ello, tan sólo tendremos que instanciar la imagen vinculando el archivo de `conf.properties` con otro externo `docker run --rm -v ./conf-per.properties:/opt/app/src/conf.properties luistest:version003` 


## 5. OPTIMIZANDO la imagen (2 pasos)
A veces, necesitamos algunos o muchos recursos para construir una imagen, pero no tantos para ejecutarla por lo que podemos recurrir a la utilización de 2 etapas con [imágenes base diferentes](https://hub.docker.com/_/eclipse-temurin/tags).

```Dockerfile
# -----------------------------------------------
# Etapa 1: COMPILACIÓN
# -----------------------------------------------
FROM eclipse-temurin:21 AS builder
RUN mkdir -p /opt/app && mkdir /opt/app/src

COPY Main.java conf.properties /opt/app/src/

WORKDIR /opt/app/src
RUN javac --enable-preview --source 21 Main.java

# -----------------------------------------------
# Etapa 2: EJECUCIÓN
# -----------------------------------------------
FROM eclipse-temurin:21-alpine
WORKDIR /root/
COPY --from=builder /opt/app/src/Main.class /opt/app/src/conf.properties .
CMD ["java", "--enable-preview", "Main"]
```

Para construir la imagen: `docker build -t luistest:version005 .`

Podemos ver la obvia diferencia con `docker system df -v | head`, aun habiendo realizado apenas un simple cambio de imagen.

**Ejercicio:** Reduce la imagen por debajo de los 200 MB (version006).

## 6. COMPARTIENDO la imagen
Subiéndola a [docker hub](https://hub.docker.com/):
1. creando un repositorio `luisfe02/java_hola_mundo`
2. Subiendo la imágen con:
```bash
docker login
docker tag local-image:tagname new-repo:tagname
docker push new-repo:tagname
#Make sure to replace `tagname` with your desired image repository tag.
```

O, incluso a [repositorios privados](https://www.baeldung.com/ops/docker-push-image-self-hosted-registry).


# Docker COMPOSE vs Docker CLI

> ***IMPORTANTE***: *Docker COMPOSE v1 (comando docker-compose) es obsoleto por lo que **NO** deberá utilizarse. Para utilizar la versión 2 eliminaremos el guión/dash, esto es, utilizaremos el comando docker con el modificador compose, **docker compose**.*

Docker COMPOSE es una herramienta para definir y correr aplicaciones multicontenedor, permitiendo la configuración de los contenedores vía ficheros yamel (yml).

El “lenguaje” de marcado **yml** puede ser difícil de entender en principio, pero afortunadamente tenemos la herramienta on-line [**composerize**](https://www.composerize.com/) que traduce de docker CLI a docker COMPOSE.

Vamos a repetir los apartados anteriores vía COMPOSE, abriendo una puerta nueva para el trabajo con contenedores.

Los ficheros yml además nos proporcionan un plus, poder integrarlos en nuestro flujo de trabajo **GIT**, realizando seguimiento de cambios y compartir dichas recetas con facilidad.


## Securizando COMPOSE

Para guardar nuestros *secretos* y no compartirlos con GIT tenemos los ficheros “.env” donde podremos definir variables de entorno en nuestros yamel que dejaremos fuera del repositorio GIT mediante la inclusión del patrón correspondiente en el fichero “.gitignore”.