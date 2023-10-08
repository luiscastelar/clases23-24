#curso23_24 #PSP [estado:: DONE] 

## Comunicación entre Hilos

**Fuente:** *[Agustín Froufe - Universidad de Murcia](https://dis.um.es/~bmoros/Tutorial/parte10/cap10-6.html)*

Otra clave para el éxito y la ventaja de la utilización de múltiples hilos de ejecución en una aplicación, o aplicación *multithreaded*, es que pueden comunicarse entre sí. Se pueden diseñar hilos para utilizar objetos comunes, que cada hilo puede manipular independientemente de los otros hilos de ejecución.

El ejemplo clásico de comunicación de hilos de ejecución es un modelo productor/consumidor. Un hilo produce una salida, que otro hilo usa (consume), sea lo que sea esa salida. Entonces se crea un *productor*, que será un hilo que irá sacando caracteres por su salida; y se crea también un *consumidor* que irá recogiendo los caracteres que vaya sacando el productor y un *monitor* que controlará el proceso de sincronización entre los hilos de ejecución. Funcionará como una tubería, insertando el productor caracteres en un extremo y leyéndolos el consumidor en el otro, con el monitor siendo la propia tubería.

![](https://dis.um.es/~bmoros/Tutorial/parte10/cap10-3.gif)

### Productor

El productor extenderá la clase **Thread**, y su código es el siguiente:

```java
    class Productor extends Thread {
      private Tuberia tuberia;
      private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      public Productor( Tuberia t ) {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
      }

      public void run() {
        char c;

        // Mete 10 letras en la tubería
        for( int i=0; i < 10; i++ )
            {
            c = alfabeto.charAt( (int)(Math.random()\*26 ) );
            tuberia.lanzar( c );
            // Imprime un registro con lo añadido
            System.out.println( "Lanzado "+c+" a la tuberia." );
            // Espera un poco antes de añadir más letras
            try {
                sleep( (int)(Math.random() \* 100 ) );
            } catch( InterruptedException e ) {;}
            }
      }
    }
```

Notar que se crea una instancia de la clase **`Tuberia`**, y que se utiliza el método *tuberia.lanzar()* para que se vaya construyendo la tubería, en principio de 10 caracteres.

### Consumidor

Ahora se reproduce el código del consumidor, que también extenderá la clase **Thread**:

```java
    class Consumidor extends Thread {
      private Tuberia tuberia;

      public Consumidor( Tuberia t ) {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
      }

      public void run() {
        char c;

        // Consume 10 letras de la tubería
        for( int i=0; i < 10; i++ )
            {
            c = tuberia.recoger();
            // Imprime las letras retiradas
            System.out.println( "Recogido el caracter "+c );
            // Espera un poco antes de coger más letras
            try {
                sleep( (int)(Math.random() \* 2000 ) );
            } catch( InterruptedException e ) {;}
            }
      }
    }
```

En este caso, como en el del productor, se cuenta con un método en la clase **Tuberia**, *tuberia.recoger()*, para manejar la información.

### Monitor

Una vez vistos el productor de la información y el consumidor, solamente queda por ver qué es lo que hace la clase **Tuberia**.

Lo que realiza la clase **Tuberia**, es una función de supervisión de las transacciones entre los dos hilos de ejecución, el productor y el consumidor. Los monitores, en general, son piezas muy importantes de las aplicaciones multihilo, porque mantienen el flujo de comunicación entre los hilos.

```java
    class Tuberia {
      private char buffer\[\] = new char\[6\];
      private int siguiente = 0;
      // Flags para saber el estado del buffer
      private boolean estaLlena = false;
      private boolean estaVacia = true;

      // Método para retirar letras del buffer
      public synchronized char recoger() {
        // No se puede consumir si el buffer está vacío
        while( estaVacia == true )
            {
            try {
                wait(); // Se sale cuando estaVacia cambia a false
            } catch( InterruptedException e ) {
                ;
                }
            }
        // Decrementa la cuenta, ya que va a consumir una letra
        siguiente--;
        // Comprueba si se retiró la última letra
        if( siguiente == 0 )
            estaVacia = true;
        // El buffer no puede estar lleno, porque acabamos
        // de consumir
        estaLlena = false;
        notify();

        // Devuelve la letra al thread consumidor
        return( buffer\[siguiente\] );
      }

      // Método para añadir letras al buffer
      public synchronized void lanzar( char c ) {
        // Espera hasta que haya sitio para otra letra
        while( estaLlena == true )
            {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch( InterruptedException e ) {
                ;
                }
            }
        // Añade una letra en el primer lugar disponible
        buffer\[siguiente\] = c;
        // Cambia al siguiente lugar disponible
        siguiente++;
        // Comprueba si el buffer está lleno
        if( siguiente == 6 )
            estaLlena = true;
        estaVacia = false;
        notify();
      }
    }
```

En la clase **Tuberia** se pueden observar dos características importantes: los miembros dato (buffer\[\]) son privados, y los métodos de acceso (*lanzar()* y *recoger()*) son sincronizados.

Aquí se observa que la variable estaVacia es un semáforo, como los de toda la vida. La naturaleza privada de los datos evita que el productor y el consumidor accedan directamente a éstos. Si se permitiese el acceso directo de ambos hilos de ejecución a los datos, se podrían producir problemas; por ejemplo, si el consumidor intenta retirar datos de un buffer vacío, obtendrá excepciones innecesarias, o se bloqueará el proceso.

Los métodos sincronizados de acceso impiden que los productores y consumidores corrompan un objeto compartido. Mientras el productor está añadiendo una letra a la tubería, el consumidor no la puede retirar y viceversa. Esta sincronización es vital para mantener la integridad de cualquier objeto compartido. No sería lo mismo sincronizar la clase en vez de los métodos, porque esto significaría que nadie puede acceder a las variables de la clase en paralelo, mientras que al sincronizar los métodos, sí pueden acceder a todas las variables que están fuera de los métodos que pertenecen a la clase.

Se pueden sincronizar incluso variables, para realizar alguna acción determinada sobre ellas, por ejemplo:

```java
    sincronized( p ) {
      // aquí se colocaría el código
      // los threads que estén intentando acceder a p se pararán
      // y generarán una InterruptedException
    }
```

El método *notify()* al final de cada método de acceso avisa a cualquier proceso que esté esperando por el objeto, entonces el proceso que ha estado esperando intentará acceder de nuevo al objeto. En el método *wait()* se hace que el hilo se quede a la espera de que le llegue un *notify()*, ya sea enviado por el hilo de ejecución o por el sistema.

Ahora que ya se dispone de un productor, un consumidor y un objeto compartido, se necesita una aplicación que arranque los hilos y que consiga que todos hablen con el mismo objeto que están compartiendo. Esto es lo que hace el siguiente trozo de código, del fuente [java1007.java](https://dis.um.es/~bmoros/Tutorial/fuentes/java1007.java):

```java
    class java1007 {
      public static void main( String args\[\] ) {
        Tuberia t = new Tuberia();
        Productor p = new Productor( t );
        Consumidor c = new Consumidor( t );

        p.start();
        c.start();
      }
    }
```

Compilando y ejecutando esta aplicación, se podrá observar en modelo que se ha diseñado en pleno funcionamiento.

### Monitorización del Productor

Los programas productor/consumidor a menudo emplean monitorización remota, que permite al consumidor observar el hilo del productor interaccionando con un usuario o con otra parte del sistema. Por ejemplo, en una red, un grupo de hilos de ejecución productores podrían trabajar cada uno en una workstation. Los productores imprimirían documentos, almacenando una entrada en un registro (*log*). Un consumidor (o múltiples consumidores) podría procesar el registro y realizar durante la noche un informe de la actividad de impresión del día anterior.

Otro ejemplo, a pequeña escala podría ser el uso de varias ventanas en una workstation. Una ventana se puede usar para la entrada de información (el productor), y otra ventana reaccionaría a esa información (el consumidor).