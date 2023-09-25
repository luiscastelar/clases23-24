#curso23_24 #PSP [estado:: Working] 
{[Page: New]} {[Editor: Toggle Dark Mode]} {[Editor: Toggle Vim Mode]}

# Herramientas
## Control de versiones (GIT)
El módulo se basará fundamentalmente en código, por lo que realizaremos uso intensivo de control de versiones ([GIT]([https://git-scm.com](https://git-scm.com/))) y virtualización.

> Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente.

+ FC: [TodoCode - Git](https://www.youtube.com/watch?v=mCVQgSyjCkI&list=PLQxX2eiEaqby-qh4raiKfYyb4T7WyHsfW) -> [1,25h]
+ FC: [Fazt Code - Markdown](https://www.youtube.com/watch?v=oxaH9CFpeEE) -> [0,5h]
+ Clase: Crear un repo con README.md conectado con GitHub. Añadir colaborador (profe `@luiscastelar`). Postear cambios de captura (`tee`) de un clone -> [2h]
  + El `README.md` contendrá vuestro nombre y email coorporativo.
+ [GitFiend](https://gitfiend.com/) o [GitG](https://wiki.gnome.org/Apps/Gitg) como apoyo visual a *git bash*
+ .gitignore *.env y otros archivos binarios*. \
  Crearemos en la raíz del repo un archivo denominado `.gitignore` con el contenido:
  ```
  *.env
  ```

*Recuerda mirar bien la fecha **y hora** de entrega*. Está marcada para el 28 de septiembre a las 00:00. Eso significa que el 28 a las 00:01 minutos no podréis subirla.

+ *Referencias*:
  + Documentación OFICIAL -> [Git reference manual](https://git-scm.com/docs)
  + Vídeos aclarativos -> [PildorasInformáticas 1-5, 10-11](https://www.youtube.com/watch?v=ANF1X42_ae4&list=PLU8oAlHdN5BlyaPFiNQcV0xDqy0eR35aU)
     

## Servicios
Para verificar algunos aspectos de la programación multiproceso necesitaremos tener una idea clara sobre la situación actual de nuestro equipo. 

Para esto obtendremos información de los procesos:

### GNU/Linux
Con el comando ps:
+ Unix like: `ps -f` o `ps -AF`
+ BSD like: `ps axjf`

Cuando sean muchos ... `ps axjf | grep "java"` 

Y ya que estamos `kill PID` o cuando la cosa está difícil `kill -9 PID`

Si lo que buscamos es información sobre recursos bloqueados:
+ Descriptores de archivo: `lsof` o `lsof PATH/TO/FILE` \
+ Ocupación de puertos `netstat -pa` o `lsof -i :PUERTO`

> Recuerda: en la web `cheat.sh` o a través de `curl chear.sh/lsof` podrás obtener información de los usos típicos del comando*

#### Ejercicio:
Vamos a ocupar un puerto y realizar la investigación oportuna. 

Para ellos vamos a requerir 1 máquina virtual donde abriremos un servidor de escucha y nos conectaremos desde otra máquina, el `HOST` (el *hierro*).

Para lanzar el servidor utilizaremos netcat: `nc -l -p 8082` y nos conectaremos desde el navegador web o `curl`.

Para el primero necesitaremos responder de forma adecuada:
```
HTTP/1.1 200 Everything Is Just Fine
Server: netcat!
Content-Type: text/html; charset=UTF-8

<!doctype html>
<html>
<body>
<h1>Mi primer servidor con netcat</h1>
</body>
</html>

```

Posteriormente, abriremos otra terminal, nos conectaremos a la máquina `A`, localizaremos el proceso que ocupa el puerto deseado `8082` y lo mataremos.


### Windows

#### CMD
+ `tasklist`
+ Y para eliminar `taskkill /F /PID PID_PROCESO`
+ Más información `tasklist /FI "pid eq NUM\_PID\_DEL\_PROCESO" /V /FO List`
+ Para ver puertos: `netstat -ano` o `netstat -abno`.

#### PowerShell:
+ Para eliminar `taskkill /F /PID PID_PROCESO`
+ Información de puestos y conexiones: `Test-NetConnection IP -Port PUERTO`
+ Localizar puertos `Get-NetTCPConnection -LocalPort PUERTO`


## Brevísimo resumen de IPv4 e IPv6
   | IPv4               | IPv6            | Nombre / Significado                          |
   | ------------------ | --------------- | --------------------------------------------- |
   | 0.0.0.0/32         | ::/0            | wildcard (comodín)                            |
   |                    | ::/128          | sin especificar                               |
   | 127.X.X.X/8        | ::1/128         | loopback (el propio host )                    |
   | 10.X.X.X/8         | fc00::/7        | Redes priv (con *hasta* 2^24 - 2 host IPv4)   |
   | 172.16.X.X/12      |                 | Redes priv (con *hasta* 2^20 - 2 host IPv4)   |
   | 192.168.X.X/16     |                 | Redes priv (con *hasta* 2^24 - 2 host IPv4)   |
   | 255.255.255.255/32 | -No existe-     | Difusión                                      |
   |                    | ff01::1/128     | All nodes (similar a difusión)                |
   |                    | 2001::/32       | Túnel Teredo (conexión 6to4)                  |
   |                    | ::/96           | IPv4 compatible *NO usar*.                    |
   |                    | ::ffff:0:0/96   | IPv4 mapeada                                  |
   |                    | ::ffff:0:0:0/96 | IPv4 traducida                                |
   |                    | 64:ff9b::/96    | prefijo Well-know (IPv4 traducida automática) |
   | 192.88.99.0/24     | 2002::/16       | red 6to4                                      |
   |  |  |  |
   | PÚBLICAS           | 2000::/3        | Rango público direccionable desde el mundo    |
   |  |  |  |
   | 169.254.X.X/16     | fe80::/10       | link-local -> no hay DHCP y hay conf dinámica |
   | 192.168.122.X/24   |                 | Red NAT de Virtual Box                        |


# Procesos y multiprocesos
## Procesos
En los siguientes minutos vamos a intentar responder y definir los puntos:
1. ¿Que es un proceso?
2. Bloque de Control de Procesos - PCB
3. Programación concurrente:
  + cooperativa: Mac OS Clásico y Windows 3.x
  + preventiva: UNIX - GNU/Linux, Mac OS X y Windows 95 y NT

4. Programación paralela.
5. Programación distribuida.

   
+ Conceptos básicos:
  + [Vídeo - David Pérez](https://youtu.be/3JlLl5sdepc?si=ct-DV5IDrZLBP7Hy)
  + [Escuela Universitaria de Segovia](https://www.infor.uva.es/~fjgonzalez/apuntes/Tema4.pdf) o [Universidad Carlos III](https://media.uc3m.es/uploads2/material/5b3012c28f420863d08b7f9f/Apuntes_14_10.pdf)
+ Teoría -> [Vicente Martínez - IES Doctor Balmis](https://psp2dam.github.io/psp_pages/es/unit1/)


## Procesos vs Hilos
![procesos vs hilos](https://psp2dam.github.io/psp_pages/assets/threads_vs_process-22c153e6.jpg)
| Procesos                         | Hilos                                               |
| -------------------------------- | --------------------------------------------------- |
| Un PCB por proceso               | Un PCB puede contener varios hilos                  |
| Constan de uno o más hilos       | Un hilo siempre existe dentro de un proceso         |
| Son independientes unos de otros | Comparten los recursos del proceso de forma directa |
| Son gestionados por el SO        | Son gestionados por el proceso                      |
| Se comunican a través del SO     | La comunicación la controla el proceso              |

¿Cuándo usaremos cada uno?


## Multiprocesos

***OFF-TOPIC***: Ejecución concurrente mediante la API `stream` (programación funcional): stream() vs parallelStream() -> [vídeo](https://www.youtube.com/watch?v=cTGPgMMKxZk)

Para crear procesos independientes en Java:  
+ [Process](https://docs.oracle.com/javase/8/docs/api/java/lang/Process.html)
+ [Runtime](https://psp2dam.github.io/psp_pages/es/unit2/runtime.html)
+ [ProcessBuilder](https://psp2dam.github.io/psp_pages/es/unit2/processbuilder.html)

### Ejercicio:
```java
import java.util.concurrent.TimeUnit;

public class ElRuntime {
  public static void main(String[] args)  {
    final int ESPERA = 10;
    
    // Launch notepad app
    try {
      Runtime.getRuntime().exec("notepad.exe");
    } catch (Exception e) { 
        //e.printStackTrace(); 
        System.out.println("Estamos en linux o el notepad.exe no se encuentra instalado");
    } 
    try {
      // Creamos y esperamos 10s
      System.out.println("Abrimos Kate y esperamos " + ESPERA + " segundos o a que el usuario lo cierre");
      Process p = Runtime.getRuntime().exec("/bin/kate");
      System.out.println("PID:" + p.pid() );
      p.waitFor(ESPERA, TimeUnit.SECONDS);
      p.destroy();
      
      // Creamos y esperamos al cierre
      System.out.println("Abrimos Kate y a que el usuario lo cierre");
      p = Runtime.getRuntime().exec("/bin/kate");
      System.out.println("PID:" + p.pid() );
      p.waitFor();
      p.destroy();
      
      // Creamos y dejamos libre (no capturamos el puntero)
      System.out.println("Abrimos un proceso independiente (una terminal).");
      p = Runtime.getRuntime().exec("/bin/konsole");
      System.out.println("PID:" + p.pid() );
      
      System.out.println("Finaliza el proceso padre, pero la terminal se queda");
    } catch (Exception e) { e.printStackTrace(); } 

    // This way always works
    // Runtime.getRuntime()
    //    .exec("c:"+separator+"windows"+separator+"notepad.exe");

    // This way used to work (UNIX style paths)
    // Runtime.getRuntime().exec("c:/windows/notepad.exe");
  }
}
```

### Ejercicio 2:
Repite el ejercicio con `ProcessBuilder`.

***Recuerda: Deberás tener en cuenta:***
 + `String separator = System.getProperty("file.separator");`
 + Sistema Operativo:
   ```
   // Primero obtenemos la carpeta del usuario
    String homeDirectory = System.getProperty("user.home");
    boolean isWindows = System.getProperty("os.name")
      .toLowerCase().startsWith("windows");

    if (isWindows) {
      Runtime.getRuntime()
        .exec(String.format("cmd.exe /c dir %s", homeDirectory));
    } else {
      Runtime.getRuntime()
        .exec(String.format("sh -c ls %s", homeDirectory));
    }
   ```

### Práctica:
Crear un programa que:
1. Lanza el proceso independiente `esperarNsegundos.sh`
2. Escriba por consola [letras random](https://www.baeldung.com/java-random-string) hasta que el proceso independiente haya finalizado.

El script `esperarNsegundos.sh` recibe como argumento un entero, el número de segundos a esperar antes de morir.


### Práctica 2:
En esta práctica deberéis ejecutar 4 tareas simples, en procesos externos. Realizarla de forma que sea lo más rápida posible gracias a la programación multiproceso. \
Operaciones:
1. Hacer una lista de 100.000 primeros números -> `Lista1`.
2. Obtener esos números multiplicados por 10 -> `Lista2`.
3. Obtener los números de la `Lista1` divididos por 10 -> `Lista3`
4. Verificar que todos los elementos de `Lista2` son 10 veces mayores que su correspondiente de `Lista1`.

## Referencias:
+ [Doc oficial de Process](https://docs.oracle.com/en/java/javase/21/core/process-api1.html#GUID-6FAB2491-FD4E-42B4-A883-DCD181A1CE3E)