#curso23_24 #PSP [estado:: Done] 

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
/**
* Hilo mediante la implementación de la `interface` Runnable
*
* DEBE: implementar el método abstracto `void run()`
* Puede: tener constructores y otros métodos
*/
class Saluda implements Runnable {
  @Override
  public void run(){
    for( int i = 0 ; i < 10 ; i++ ){
      // Esperamos para dar realidad el hilo
      //try { Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); }
      System.out.println("Soy un hilo independiente de la clase " + Thread.currentThread().getName() );
    }
  } // método run()
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
public class Saluda implements Runnable {
    private String nombre;
    
    // Constructor
    Saluda(String nombre){ this.nombre = nombre; }
    
    // Ejecutor
    @Override
    public void run(){
	  for( int i = 0 ; i < 10 ; i++ ){
	    System.out.println("Soy un hilo independiente de la clase " + Thread.currentThread().getName()
			       + " a " + nombre);
	  }
    } // método run()
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

### ~~Runtime.exit(int) o~~ Getters

~~Si sólo queremos conocer el código de finalización lo tenemos sencillo `Runtime.exit(int)` pero, ¿y si queremos que nos retorne una Lista o un objeto cualquiera? **getter**s.~~

Para retornar valores deberemos realizarlo mediante `getter`s.

~~En este segundo caso, deberíamos~~ deberemos asegurarnos que el dato ya está preparado, y que no está “sucio”, por ejemplo con `hilo.join()`.

## Jugando con hilos

### Parada de un Thread

**¡OJO!**: Los métodos `hilo.stop()` y `hilo.suspend()` se encuentran marcados como obsoletos (`@Deprecated`) desde la versión 1.2 de java. 

¿Cómo podemos parar un hilo (infinito) en java? Pues haciendo que deje de ser infinito.

```java
volatile boolean ejecutar = true;

@Override
public void run() {
    while(ejecutar) {
        //tarea infinita que nunca va a terminar...
    }
}

public synchronized void detener() {
    ejecutar = false;
}
```

Si se necesita, se puede comprobar si un hilo está vivo o no; considerando vivo un hilo que ha comenzado y no ha sido detenido.

    t1.isAlive();

Este método devolverá *true* en caso de que el hilo t1 esté vivo y no haya terminado su ejecución.

### Suspensión de ejecución

De forma análoga a deneter mediante otra variable:
```java
volatile boolean ejecutar = true;
volatile boolean suspender = false;

@Override
public void run() {
    while(ejecutar) {
        //tarea infinita que nunca va a terminar...
	    
	    if( !suspender ){
		// Sólo se ejecuta si no está suspendido
		System.out.println( "Ejecutado " + (++i) + " veces." );
	    }
	            
    }
}


public synchronized void suspend() {
	suspender = true;
}

public synchronized void reactivar() {
	suspender = false;
}

public synchronized void detener() {
    ejecutar = false;
}
```


## EJERCICIOS:
1. Lanzar 3 hilos con `Thread.sleep(x)` con distintos tiempos. Desde la rama principal verifica los estados de cada hilo. Cuando estén todos muertos despídete y acaba.
2. Lanzar 3 hilos que saluden 100 veces, cada uno con una prioridad diferente.
3. Repite la práctica de 1 invirtiendo los papeles. Esto es:
   + Crea un hilo `hiloImprimir` que imprima por pantalla letras aleatorias.
   + Crea un menú que capture el teclado realizando:
     1. Si recibe una `i` lanza el hilo `hiloImprimir`.
     2. Si recibe una `s` detiene el hilo `hiloImprimir`.
     3. Si recibe una `q` sale del programa.
    

### Referencias:
+ [Hilos y Multihilo - netradio.net](https://dis.um.es/~bmoros/Tutorial/parte10/cap10-1.html)


## Callable vs Runnable

![callabe vs runnable](https://javagoal.com/wp-content/uploads/2020/10/3.png)

Si necesitamos ir más allá, deberemos recurrir a implementar al interfaz `Callable`. ¿Problema? Pues que la clase `Thread` sólo admite `Runnable`. 

Debemos por tanto recurrir a promesas con la interfaz `Future` y la ejecución con `ExecutorService` o  `FutureTask`, para una o varias tareas a ejecutar.

![future](https://javagoal.com/wp-content/uploads/2020/10/2.png)

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjecutorServicioBis {
   public static void main(String[] args) throws InterruptedException, ExecutionException 
   {
      ExecutorService servicio = Executors.newSingleThreadExecutor();
      TareaLlamable tarea = new TareaLlamable(3, 5);
      Future<Integer> promesa = servicio.submit( tarea );
      Integer valor = promesa.get();
      System.out.println( valor );
      servicio.shutdown();
   }
}

class TareaLlamable implements Callable<Integer> {
    private int a, b, c;
    
    public TareaLlamable( int _a, int _b ){
        this.a = _a;
        this.b = _b;
    }
    
    @Override
    public Integer call() throws Exception {
      return ( a + b );
   }
}   
```

*Pasos*:
1. Se crea un servicio ejecutable... hace la función de `Thread`.
2. Se crea una tarea que implementa `Callable` declarando que retornará un entero.
3. Se crea una “promesa” de retorno de un entero con la llamada al servicio al que le pasamos `submit` la tarea.
4. Se espera a obtener `get()` el valor de la “promesa”.
5. Se “solicita el apagado” del servicio. Los servicios activos acabarán, pero no se aceptarán más servicios.

> Se simplifica la implementación de la tarea y la captura de valores es más obvia, pero evidentemente se complica la bifurcación de ejecución (creación de hilo).
> 
> Entonces, ¿porqué usarlo?
>
> Porque nos permite generar un “pool” de hilos que realmente podrán [ejecutarse en paralelo](https://www.baeldung.com/java-executor-service-tutorial). 


## EJERCICIOS:
4. Repite el ejercicio 3 con `Callable`. Esto es:
   + Crea un hilo `hiloImprimir` que imprima por pantalla letras aleatorias.
   + Crea un menú que capture el teclado realizando:
     1. Si recibe una `i` lanza el hilo `hiloImprimir`.
     2. Si recibe una `s` detiene el hilo `hiloImprimir`.
     3. Si recibe una `q` sale del programa.
     4. Lanzar hilo que sume dos números enteros que reciba como argumentos `Integer callableSumaEnteros()`. Deberá crear un hilo que retorne dichos argumentos `Integer callableCapturaEntero()`.
    
# [Comunicación entre hilos -> PSP-2-Programación multihilo 2](https://github.com/luiscastelar/clases23-24/blob/main/psp/PSP-2-Programaci%C3%B3n%20multihilo2.md)


# Fuera de evaluación:

## Synchronized
¿Qué hace `synchronized`?
[Fuente: jachguate - StackOverflow](https://es.stackoverflow.com/posts/265860/timeline)

> La sincronización en *java* funciona a nivel de objeto. Lo que un método *sincronizado* te garantiza es que no habrá dos hilos ejecutando un mismo método de un mismo objeto a la vez. Si hay varios hilos intentando ejecutar el mismo método del mismo objeto a la misma vez, uno logrará su ejecución y los otros deberán esperar a que este concluya para obtener su turno.
>
> El problema que estamos teniendo, en tu caso, es que tenemos 10 objetos diferentes, y por tanto, cada objeto está tratando de sincronizarse únicamente consigo mismo, con lo cual no hay ninguna sincronización en efecto.
>
> Lo que debemos hacer es lograr que esa sincronización funcione de manera global.
>
> Una manera de hacerlo, es declarar tu método `Imprimir` también estático. Al ser estático, en realidad todos los hilos competirán por ese único método a nivel de clase, con lo cual se ven obligados a sincronizarse. En cada llamada, deberás pasarle por parámetro los datos del hilo que lo llama.


## Hilos virtuales

JDK21 publicado el 19 de septiembre de 2023 con soporte para, al menos, 8 años soporta los denominados hilos virtuales o *hilos ligeros*.

Para un acercamiento a la característica podéis revisar los siguientes enlaces:
+ Hilos de plataforma [SACAViX Tech](https://www.youtube.com/watch?v=BsJnXKpOVMw)
+ Hilos virtuales [SACAViX Tech](https://www.youtube.com/watch?v=j0RO-LX9rLA)
+ [Guia de hilos virtuales - Adam Gamboa](https://blog.adamgamboa.dev/es/guia-para-virtual-threads-hilos-livianos-en-java/)
+ [Doc Oficial de Concurrencia en Java21](https://docs.oracle.com/en/java/javase/21/core/concurrency.html#GUID-59C16A2D-57CE-4C83-9D6F-91A48E01E3C6)
+ [Dev.Java - Nuevas características](https://dev.java/learn/new-features/virtual-threads/)
+ [JEP444 Virtual Threats](https://openjdk.org/jeps/444)
+ [Programación concurrente - Empieza a programar](https://www.youtube.com/playlist?list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728)
+ [Java multihilos - Todo lo que necesitas saber](https://medium.com/excited-developers/java-multithreading-all-you-need-to-know-33d7e0ff4622)

