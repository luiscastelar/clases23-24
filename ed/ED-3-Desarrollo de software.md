#curso23_24 #ED [estado::done] 

## Licencias de software

En Derecho, una licencia es un contrato mediante el cual una persona recibe de otra el derecho de uso, de copia, de distribución, de estudio y de modificación (en el caso del Software Libre) de varios de sus bienes, normalmente de carácter no tangible o intelectual, pudiendo darse a cambio del pago de un monto determinado por el uso de los mismos. Estos activos son propiedad del otorgante, y pueden ser bienes de propiedad intelectual como una marca, patentes o tecnologías. También pueden ser objeto de licencia otros bienes de carácter intangible como la distribución de obras intelectuales.

En la práctica, si un software carece de licencia el receptor del mismo no tiene derecho ni si quiera a ejecutarlo, ya que no tiene otorgado el permiso para ello.

Por ejemplo, MacOs se distribuye con una licencia que impide su instalación y ejecución en cualquier equipo que no sea directamente hardware de Apple Inc, por lo que su virtualización está implícitamente prohibida.

Entrando en tipos de licencias nos encontramos los distintos palabros: Copyright, Freeware, Open Source, GPL, MIT, Apache, BSL, entre muchas otras.

Vamos a definir a grandes rasgos las mismas:
+ Copyright: sólo lo otorgado expresamente. Windows, MacOs o Office son un ejemplo.
+ Freeware: puedes ejecutarlo gratuitamente, pero tendrá limitaciones temporales o de funcionalidades.
+ Open Source: se distribuye el código fuente, pero su modificación o ejecución sigue siendo de pago.
+ Software libre: aquel que respeta las 4 libertades:
  1.  La libertad de ejecutar el software como te plazca y con cualquier objetivo.
  2.  La libertad de estudiar como funciona el programa y cambiarlo a tu gusto. Esto implica el poder acceder a su código fuente.
  3.  La libertad de poder redistribuir copies del programa a los demás.
  4.  La libertad de poder distribuir también tus mejoras al programa original.
+ GPL (General Public License) (ver referencia). Obliga que el software derivado se distribuya también con la misma licencia, no así las modificaciones.
+ BSD: El software derivado no requiere ser liberado bajo la misma licencia.
+ MIT: *casi* de dominio público.
+ Apache: ...
+ BSL (Business Source License): es gratis y abierto mientras no le hagas la competencia al creador... aceptan tus mejoras y se las quedan 😠.

![BSL](https://luiscastelar.duckdns.org/2023/assets/ED/UT3-licencia-bsl.jpg)


**Referencias:** [licencias - picodotdev](https://picodotdev.github.io/blog-bitix/2021/02/licencias-de-software-libre-y-diferencias-con-software-privativo-y-de-codigo-abierto/)

## Ciclo de vida
[evotic](https://evotic.es/software-a-medida/ciclo-de-vida-del-software/)

### Modelelos de desarrollo:

+ En cascada: \
![en cascada](https://www.ionos.mx/digitalguide/fileadmin/_processed_/0/8/csm_wasserfallmodell-ES-1_f6eb5b1dc6.webp)
+ En V: \
![en v](https://www.datocms-assets.com/17507/1616761097-captura-de-pantalla-2021-03-25-a-las-10-43-22.png?fit=max&fm=webp&q=60&w=736)
+ En espiral: \
  ![espiral](https://3.bp.blogspot.com/-uEYkRrdS0cI/W9nbKU0XxCI/AAAAAAAAABo/0_pqo68Sn-kuBGcnOgSaa4ZB4TNYrYKWQCLcBGAs/s1600/iaaaarasrsat.png)
+ Incremental (métodos `Agile`): Scrum y Kanban

## Continuación:
+ [Desarrollo de software - fases](https://github.com/jamj2000/DAW1-ED-Apuntes/blob/master/1.ELEMENTOS.md#desarrollo-de-software)
+ [Lenguajes de programación](https://github.com/jamj2000/DAW1-ED-Apuntes/blob/master/1.ELEMENTOS.md#lenguajes-de-programaci%C3%B3n)

### KANBAN


![kanban board](https://www.ionos.es/digitalguide/fileadmin/_processed_/1/a/csm_kanban_a62fb56a0a.webp)

1. [Qué es - ionos](https://www.ionos.es/digitalguide/paginas-web/desarrollo-web/que-es-kanban/)
2. [Gestion de proyectos con KANBAN - YT: Marta Falcón](https://www.youtube.com/watch?v=WP6Nt5XV980)
3. [kanboard](https://kanboard.luiscastelar.duckdns.org/board/1) o [WeKan](https://github.com/wekan/wekan)
4. [Kanban en Github](https://libliboom.medium.com/how-to-use-automated-kanban-in-github-cf073f18a6c8)

Ejemplo de Kanboard para desarrollo:

![kan](https://luiscastelar.duckdns.org/2023/assets/ED/UT3-kanboard.jpg)

#### Tarea 1: 
Crea un repositorio NUEVO y conviértelo en un KanBoard siguiendo los pasos indicados en el enlace 4.


### Scrum

![scrum](https://luiscastelar.duckdns.org/2023/assets/ED/UT3-srum.jpeg)
![scrum](https://luiscastelar.duckdns.org/2023/assets/ED/UT3-ScrumBoard.jpeg)
**Referencias:**
+ [Scrum en 10 minutos - YT:Juan Carlos Marin](https://www.youtube.com/watch?v=PlLHc60egiQ)
+ [Qué es SCRUM - YT: EDTeam](https://www.youtube.com/watch?v=sLexw-z13Fo)


#### Tarea 2: 
~~Crea un repositorio NUEVO y conviértelo en un Scrum Board~~ (ver [ejemplo](https://github.com/users/itzrick620/projects/4/views/1))


## PoC, Prototipo y PMV

1. Prueba de Concepto (PoC): es algo mínimo que nos indica la posibilidad o no de realizar algo. Por ejemplo, el “Hola mundo” que realizamos los programadores es una PoC sobre la viabilidad de utilizar ese lenguaje o FrameWork.
2. Prototipos: Más habitual en otras industrias, por ejemplo automoción o aviación.
3. Proyecto Mínimo Viable: es la cantidad mínima de funcionalidades o “Historias de Usuario” que necesitamos implementar para poner en el mercado nuestro producto.


## Códigos fuente, objeto y ejecutable
 + [ ] Código fuente, código objeto y código ejecutable; tecnologías de virtualización.

+ Nuestro lenguaje de alto nivel (C) `hola.c`

  Cojamos un un `HolaMundo.java` que conocemos (*o casi*):
  ```java
  void main(){
    System.out.println( "Hola mundo" );
  }
  ```
  *Para ejecutar el código anterior: `java --enable-preview --source 21 hola.java`*.

  Y veamos las similitudes con su homólogo en C:
  ```C
  #include <stdio.h>

  int main(){
    printf( "Hola mundo." );
    return 0;
  }
  ```


  
+ Código ensamblador <- `gcc -S hola.c` => `hola.s`

+ Código máquina
  + Desde código fuente: `gcc -c hola.c` 
  + Desde ensamblador: `as hola.s -o hola.o`
  
+ Código máquina enlazado (creación de proceso) <- `gcc hola.c -o hola.exe`
  
![multiproceso](https://luiscastelar.duckdns.org/2023/assets/ED/UT3/pcb.png)  
  ![multiproceso](https://luiscastelar.duckdns.org/2023/assets/ED/UT3/memoria_ppal.png)

También desde el código no enlazado `ld /usr/lib/x86\_64-linux-gnu/crti.o /usr/lib/x86\_64-linux-gnu/crtn.o /usr/lib/x86\_64-linux-gnu/crt1.o -lc hola.o -dynamic-linker /l  
ib64/ld-linux-x86-64.so.2 -o hola.exe`.

***Truco:*** *imposible acordarse de todo... man, comando --help y cheat.sh son vuestros amigos*.


## Paradigmas de la programación:
+ Paradigma imperativo:
  + Diseño estructurado: Diseño de datos, diseño arquitectónico, diseño de interfaz y diseño procedimental (secuencial, condicional, repetitiva).
  + Diseño modular:
  > La programación modular es un paradigma de programación que consiste en dividir un programa en módulos o subprogramas con el fin de hacerlo más legible y manejable.
  > Se presenta históricamente como una evolución de la programación estructurada para solucionar problemas de programación más grandes y complejos de lo que esta puede resolver. 

    [Ejemplo en python](https://docs.python.org/es/3/tutorial/modules.html). *En Java no existe programación modular*.

    Es muy muy utilizado en el frontend moderno, esto es, Javascript (ECMA Script 6).
  
  + Diseño orientado a objetos: agregación y composición.
+ Programación funcional \
  > En informática, la programación funcional es un paradigma de programación declarativa basado en el uso de verdaderas funciones matemáticas. En este estilo de programación las funciones son ciudadanas de primera clase, porque sus expresiones pueden ser asignadas a variables como se haría con cualquier otro valor; además de que pueden crearse funciones de orden superior.
  > Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Programaci%C3%B3n_funcional).
  + Características:
    + sólo funciones (sin repetitividad)
    + sin variables
  + *Repetitividad* vs *Recursividad*
  + [Su presencia en `Java`](https://blog.codmind.com/que-es-la-programacion-funcional-en-java/)


# Compilación/Interpretación y ejecución

## Java: 
   Bueno, en Java ya sabéis, `javac Main.java` para compilar, `java paquete.Main` para ejecutar.

 
 
 ## PHP:
 Vía docker: `docker run -it --rm --name my-running-script -v "$PWD":/usr/src/myapp -w /usr/src/myapp php:8.2-cli php holaMundo.php`

> Donde:
  	docker: invocamos al servicio \
  	run: el comando a ejecutar \
  	-i: interactivo \
  	-t: terminal (podemos unirlos como -it o -ti) \
  	--rm: borrar al finalizar \
  	--name *mi_contenedor*: nombre del contenedor \
  	-v: un volúmen. Es la conexión entre un directorio del `HOST` y uno del interior del contenedor. También válido para conectar archivos. \
   	"$PWD" o $(pwd): directorio actual. Las rutas deben ser **absolutas**. \
  	-w: directorio de trabajo de DENTRO del contenedor. \
  	php:version => imagen a instanciar(*) \
>
    > Tras la imagen podrá añadirse el comando a ejecutar DENTRO del contenedor, así como los argumentos que se estímen necesarios. Si no se facilitan tomarán el comando por defecto indicado por el creador de la imagen (lo más habitual). \
> 
    >	php: llamamos al comando `php` de DENTRO del contenedor. \
  	--version: argumento \
  	holaMundo: otro argumento \
	
El ejemplo anterior es muy completo, pero faltaría añadirle un `-p 8080:80` que nos permitiría que el **puerto 80 del HOST** exponga el **puerto 8080 del CONTENEDOR**.

Cabe subrayar que el puerto del CONTENEDOR, así como los volúmenes expuestos del mismo son decididos por creador de la imagen, por lo que NO podéis cambiarlos. Vosotros expondréis los que queráis (o podáis) del HOST.

### Y algo más real...
Servidor nginx con intérprete php: `docker run -it --rm --name nginx -v $(pwd)/config_nginx:/config -p 8080:80 lscr.io/linuxserver/nginx`. -> Los archivos servidos deben encontrarse en `config_nginx/www`


## Python
Vía docker: \
`docker run -it --rm --name my-running-script -v "$PWD":/usr/src/myapp -w /usr/src/myapp python:3 python holaMundo.py`

Donde:
	Lo único que hemos cambiado ha sido la imagen `python:3`, el comando y el script a ejecutar.


## C:
`docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp gcc:4.9 gcc -o myapp myapp.c`


## JDK's:
`docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp openjdk:11 javac Main.java`

`docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp openjdk:11 java Main`

Vamos a ver que pasa si ejecutamos un binario compilado en vuestro JDK actual (supongo que OpenJdk 21) y lo queremos ejecutar con el jdk 11.

### Java default:
...y otros jdk disponibles en el sistema.

```bash
profesor@servidor ~ :/$whereis java 
java: /usr/bin/java /etc/java /usr/share/java /usr/share/man/man1/java.1
profesor@servidor ~ :/$ls -la /usr/bin/java
lrwxrwxrwx 1 root root 22 ene 14  2023 /usr/bin/java -> /etc/alternatives/java
profesor@servidor ~ :/$ls -la /etc/alternatives/java
lrwxrwxrwx 1 root root 39 oct 18 17:14 /etc/alternatives/java -> /usr/lib/jvm/jdk-21-oracle-x64/bin/java
profesor@servidor ~ :/$ls -la /usr/lib/jvm/
default-java/                     .java-1.11.0-openjdk-amd64.jinfo  jdk-21-oracle-x64/                openjdk-11/                       
java-1.11.0-openjdk-amd64/        java-11-openjdk-amd64/            .jdk-21-oracle-x64.jinfo          
profesor@servidor ~ :/$java --version
java 21 2023-09-19 LTS
Java(TM) SE Runtime Environment (build 21+35-LTS-2513)
Java HotSpot(TM) 64-Bit Server VM (build 21+35-LTS-2513, mixed mode, sharing)
profesor@servidor ~ :/$/usr/lib/jvm/java-11-openjdk-amd64/bin/java --version
openjdk 11.0.21 2023-10-17
OpenJDK Runtime Environment (build 11.0.21+9-post-Debian-1deb11u1)
OpenJDK 64-Bit Server VM (build 11.0.21+9-post-Debian-1deb11u1, mixed mode, sharing)
```

Y ésto, ¿qué quiere decir? 

Pues que el path de mi sistema contiene el directorio `/usr/bin`, por lo que primeramente buscará y ejecutará la versión ahí indicada. 

Ahora bien, si nosotros requerimos ejecutarla con otra versión, sólo tendremos que ejecutar el binario `java` que se encuentra dentro del JRE que deseamos utilizar.


## C++:
`docker run --rm -v "$PWD":/tmp  -w /tmp gcc:4.9 g++ -o HelloWorld ejercicio01.cpp`

En este caso, me parece de especial relevancia dejaros los siguientes enlaces para un desarrollo más tradicional: [C++ en VS Code](https://code.visualstudio.com/docs/cpp/config-mingw) y [C++ con MinGW](https://es.wikihow.com/compilar-un-programa-en-C-usando-el-compilador-GNU-%28GCC%29)

Más información sobre el [desarrollo en C++ mediante docker](https://www.codeguru.com/cplusplus/using-c-with-docker-engine/)

## javascript
Como en muchos lenguajes, javascrit puede ejecutarse del lado del cliente y del servidor. 

No nos detengamos ahora en qué significa, si no en que del lado del cliente podremos ejecutarlo en cualquier navegador web *moderno* con solo abrir la consola de desarrollo. 

Una vez allí, `console.log("hola mundo")` y tendremos nuestra prueba.
En el navegador abrimos 


## C-Sharp (C#)
`docker run --rm -v "$PWD":/code:ro esolang/csharp-dotnet csharp-dotnet /code/hello.cs`

Desarrollo básico en [C-Sharp (C#)](https://desarrolloweb.com/articulos/primer-programa-csharp)


## No es lo ideal
En ocasiones nos encontramos algunas cosas muy bestias, no ideales, pero siempre útiles: `docker run -it --rm -e password='YOUR_VNC_PASSWORD' -p 5901:5901 labeg/devpc`

¿Y porqué no son ideales? Pues porque aunque es muy rápido y cómodo, va en contra de la filosofía de los contenedores, la cual intenta qeu cada contenedor sea un entorno de desarrollo/producción independiente que ofrezca un **único** servicio. 

¿Y ésto para qué? Pues si tenemos cada uno de los servicios en un contendor podremos desarrollar de forma independiente y aislada la funcionalidad, flexibilizando la adaptación y modificación y maximizando las posiblidades de testear de forma única dicho servicio.


# Tarea
Para la evaluación de esta unidad, además del ejercicio ya realizado de kanban vamos a realizar una batería de ensayos o PoC (pruebas de concepto) donde haremos un “hola mundo” en C, C++, C#, Java 11, Java 21, python y php.

Deberéis elegir 1 de los lenguajes anteriores y realizaréis y documentaréis la instalación del entorno completo para la realización del “hola mundo”, y todos los demás vía `docker-cli`. 