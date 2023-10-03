#curso23_24 #PSP [estado:: Working] 

A menudo se les conoce como procesos ligeros.

Pueden crearse mediante la herencia de la clase `Thread` o la implementación de la interfaz `Runnable`.


# Hilos (de plataforma)
## Extendiendo `Thread`

Se recomienda revisar la [doc oficial](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html) para tener una idea de los métodos y usos. Esta clase tiene métodos para el control de hilos y algunos otros estáticos de gran utilidad.

```java
/**
 * Hilo mediante la extensión de `Thread`
 *
 * DEBE: implementar el método abstracto `void run()`
 * Puede: tener constructores y otros métodos
 * Tiene: los métodos de su padre
 */
 class Saluda extends Thread {
   @Override
   public void run(){
     for( int i = 0 ; i < 10 ; i++ ){
       // Esperamos para dar realidad el hilo
       //try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
       System.out.println(i+1 + " Soy el hilo " 
                           + Thread.currentThread().getName()
                           + " de la clase " 
                           + this.getClass().getName() );
     }
  }
}
```

Y ahora lo invocamos:
```java
public class Hilos1e {
  public static void main(String[] args){
    Saluda uno = new Saluda();
    Thread otro = new Saluda();
    
    uno.start();
    otro.start();
    System.out.println("Esto es de la rama principal");
  }
} 
```

*Nota: Como recordarás, al ser la clase `Saluda` hija de `Thread`, los objetos de la misma “cabran” dentro de las “cajas” de tipo `Thread`*.

¿Recuerdas porqué ponemos `@Override`?

A todos nos gusta que nos llamen por nuestro nombre... a los hilos también:
```java
        ...
        Thread otro = new Saluda();
        otro.setName("Hilo_Otro");
        ...
```

Recordad de los `streams` que en java moderno podemos utilizar sintaxis funcional. Esto es:
```java
        ...
        Thread uno = new Saluda().start();
        ...
        // incluso si no necesitamos controlar al hilo...
        new Saluda().start();
        ...
```


## Implementando `Runnable`

De forma análoga podemos implementar la interfaz.
```java
/**                                                                                                         * Hilo mediante la implementación de la `interface` Runnable                                            
 *                                                                                                          * DEBE: implementar el método abstracto `void run()`                                                     
 * Puede: tener constructores y otros métodos                                                               */                                                                                                        class Saluda implements Runnable {                                                                         
  @Override
  public void run(){                                                                                       
     for( int i = 0 ; i < 10 ; i++ ){
       // Esperamos para dar realidad el hilo
       //try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }  
       
       System.out.println("Soy un hilo independiente de la clase " + Thread.currentThread().getName() );        }                                                                                                        } // método run()
} // clase Saluda
```


```java
public class Hilos0a {                                                                                       public static void main(String[] args){                                                                      
    Runnable r1 = new Saluda();
    Thread h1 = new Thread( r1 );                                                                    
    // o de forma más compacta
    Thread h2 = new Thread( new Saluda() );                                                                         
    h1.start();                                                                                                h2.start();
    System.out.println("Esto es de la rama principal");                                                    
  }                                                                                                        }                
```

Podría parecer que tenemos más verbosidad, pero ya veremos más adelante que en realidad no es tan así.

## Pasando datos al hilo
Podemos crear un constructor que reciba lo que queramos...
```java
class Saluda implements Runnable {                                                                             private String nombre;                                                          

    // Constructor
    Saluda(String nombre){ this.nombre = nombre; }                                                         
    
    // Ejecutor
    @Override
    public void run(){                                                                                             for( int i = 0 ; i < 10 ; i++ ){                                                                               System.out.println("Soy un hilo independiente de la clase " + Thread.currentThread().getName() + " a " \
+ nombre);                                                                                                         }                                                                                                     } // método run()
} // clase Saluda

```

Y en la clase principal:
```java
    ...
    new Thread( new Saluda("Juan") );
    ...
```

## Con Lambdas

Podemos hacer todo algo menos verboso gracias a las `lambda`s ya que ahora no necesitamos recurrir a la implementación externa de la interfaz y el código se simplifica, se hace más fácil de leer.
```java
    String nombre = "Juan";

    ...
    Runnable despedida = () -> {
	    for( int i = 0 ; i < 10 ; i++ )
		System.out.println("Hasta luego " + nombre + " -" + Thread.currentThread().getName());
	};
    ...
    new Thread( despedida ).start();
```

¿Te sientes tentado a hacer?:
```java
    ...
    Runnable despedida = (nombre) -> {
	    for( int i = 0 ; i < 10 ; i++ )
		  System.out.println("Hasta luego " + nombre + " -" + Thread.currentThread().getName());
	};
    ...
    Tread h1 = new Thread ( despedida("Juan") );
    ...
```

¿Porqué falla? **¿Qué estamos haciendo mal?** NADA(*)

Pero sí podemos hacerlo aún menos verboso, llegando incluso a:
```java
public class Hilos2b {                                                                                         public static void main(String[] args){                                                                         
        new Thread( ()->{ 
          for( int i = 0 ; i < 10 ; i++ )
            System.out.println("Esto es un hilo");
        }).start();
        System.out.println("Esto es de la rama principal");                                                         
    } // método main()
} // clase Hilos2b    
```

¿Problema de las `lambda`s? ¡¡No podemos reutilizarlas!! Recuerda que se “inventaron” para simplificar aquel código que no requeríamos reutilizar.


## Retornando objetos

¿Y si después de la ejecución queremos que nos devuelva el resultado?

### Runtime.exit(int) o Getters

Si sólo queremos conocer el código de finalización lo tenemos sencillo `Runtime.exit(int)` pero, ¿y si queremos que nos retorne una Lista o un objeto cualquiera? **getter**s.

En este segundo caso, deberíamos asegurarnos que el dato ya está preparado, y que no está “sucio”

### Callable vs Runnable

![callabe vs runnable](https://javagoal.com/wp-content/uploads/2020/10/3.png)
Si necesitamos ir más allá, deberemos recurrir a implementar al interfaz `Callable`. ¿Problema? Pues que la clase `Thread` sólo admite `Runnable`. 

Debemos por tanto recurrir a promesas con la interfaz `Future` y la ejecución con `ExecutorService` o  `FutureTask`, para una o varias tareas a ejecutar.
![future](https://javagoal.com/wp-content/uploads/2020/10/2.png)

## Jugando con hilos

### Suspensión de un Thread

Puede resultar útil suspender la ejecución de un hilo sin marcar un límite de tiempo. Si, por ejemplo, está construyendo un applet con un hilo de animación, seguramente se querrá permitir al usuario la opción de detener la animación hasta que quiera continuar. No se trata de terminar la animación, sino desactivarla. Para este tipo de control de los hilos de ejecución se puede utilizar el método *suspend()*.

    t1.suspend();

Este método no detiene la ejecución permanentemente. El hilo es suspendido indefinidamente y para volver a activarlo de nuevo se necesita realizar una invocación al método *resume()*:

    t1.resume();

### Parada de un Thread

El último elemento de control que se necesita sobre los hilos de ejecución es el método *stop()*. Se utiliza para terminar la ejecución de un hilo:

    t1.stop();

Esta llamada no destruye el hilo, sino que detiene su ejecución. La ejecución no se puede reanudar ya con *t1.start()*. Cuando se desasignen las variables que se usan en el hilo, el objeto *Thread* (creado con new) quedará marcado para eliminarlo y el *garbage collector* se encargará de liberar la memoria que utilizaba.

En el ejemplo, no se necesita detener explícitamente el hilo de ejecución. Simplemente se le deja terminar. Los programas más complejos necesitarán un control sobre cada uno de los hilos que lancen, el método *stop()* puede utilizarse en esas situaciones.

Si se necesita, se puede comprobar si un hilo está vivo o no; considerando vivo un hilo que ha comenzado y no ha sido detenido.

    t1.isAlive();

Este método devolverá *true* en caso de que el hilo t1 esté vivo, es decir, ya se haya llamado a su método *run()* y no haya sido parado con un *stop()* ni haya terminado el método *run()* en su ejecución.

En el ejemplo no hay problemas de realizar una parada incondicional, al estar todos los hilos vivos. Pero si a un hilo de ejecución, que puede no estar vivo, se le invoca su método *stop()*, se generará una excepción. En este caso, en los que el estado del hilo no puede conocerse de antemano es donde se requiere el uso del método *isAlive()*.

## EJERCICIOS:
1. Lanzar 3 hilos con `Thread.sleep(x)` con distintos tiempos. Desde la rama principal verifica los estados de cada hilo. Cuando estén todos muertos despídete y acaba.
2. Lanzar 3 hilos que saluden 100 veces, cada uno con una prioridad diferente.
3. Repite la práctica de 1 invirtiendo los papeles. Esto es:
  1. Crea un hilo `hImprimir` que imprima por pantalla letras aleatorias.
  2. Crea un menú que capture el teclado realizand.o:
     + Si recibe una `i` lanza el hilo `hImprimir`.
     + Si recibe una `s` detiene el hilo `hImprimir`.
     + Si recibe una `q` sale del programa.

## Referencias:
+ [Hilos y Multihilo - netradio.net](https://dis.um.es/~bmoros/Tutorial/parte10/cap10-1.html)
+ [[pub23/psp/PSP-2-Programación multihilo2 |Comunicación entre hilos]]



---

# ==Pendiente de REVISIÓN==

# Hilos virtuales

JDK21 anunciado el 19 de septiembre de 2023 con soporte para, al menos, 8 años. 

En esta versión se consolidan los hilos virtuales o “hilos ligeros”.

+ Hilos de plataforma [SACAViX Tech](https://www.youtube.com/watch?v=BsJnXKpOVMw)
+ Hilos virtuales [SACAViX Tech](https://www.youtube.com/watch?v=j0RO-LX9rLA)
+ [Guia de hilos virtuales - Adam Gamboa](https://blog.adamgamboa.dev/es/guia-para-virtual-threads-hilos-livianos-en-java/)
+ [Doc Oficial de Concurrencia en Java21](https://docs.oracle.com/en/java/javase/21/core/concurrency.html#GUID-59C16A2D-57CE-4C83-9D6F-91A48E01E3C6)
+ [Dev.Java - Nuevas características](https://dev.java/learn/new-features/virtual-threads/)
+ [JEP444 Virtual Threats](https://openjdk.org/jeps/444)
+ [Programación concurrente - Empieza a programar](https://www.youtube.com/playlist?list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728)

