
#curso23_24 #PSP [estado:: Working] 

## Teoría básica de sockets
[apuntes - Luis Del Moral](https://github.com/ldmoral1987/temario-psp-dam/blob/main/UA3-Programacion%20comunicaciones%20en%20red.pdf) (páginas 3 a 5)

## Herramientas
Como herramienta básica utilizaremos `netcat` o `nc` , herramienta para la apertura de `sockets` *TCP* o *UDP*.

Para abrir una conexión TCP en modo `listen` en el `puerto` 1234, o crear un “servidor” escribiremos `nc -l -p 1234`.

Para abrir una conexión en modo “cliente” escribiremos `nc HOST PUERTO`, donde HOST será un `FQDN` o `IP`

+ [referencia para windows](https://www.configserverfirewall.com/windows-10/netcat-windows/)

### Ejercicios:
Crea un cliente-servidor TCP y otro UDP.

1. Primero comenzaremos programando el servidor y lo atacaremos con nuestro cliente `nc localhost 5000`
+ **Servidor**:
```java
import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String argv[]) {

        // Definimos los Sockets:
        // ----------------------
        //
        // Socket de escucha del servidor
        ServerSocket servidor; 
        // Socket para atender a un cliente
        Socket cliente; 
        
        int numCliente = 0; // Contador de clientes 
        int PUERTO = 5000; // Puerto para esuchar
        System.out.println("Soy el servidor y empiezo a escuchar peticiones por el puerto: " + PUERTO);

        try {
            // Apertura de socket para escuhar a través de un puerto
            servidor = new ServerSocket(PUERTO);
            
            // Atendemos a los clientes
            //     + En la realidad por cada cliente lanzaríamos un hilo 
            do {
                System.out.println("\t Llega el cliente: " + ++numCliente);
                                
                // Aceptamos la conexión
                cliente = servidor.accept();
                
                // Creamos la salida hacia el cliente y la usamos
                DataOutputStream ps = new DataOutputStream(cliente.getOutputStream());
                ps.writeUTF("Usted es mi cliente: "+numCliente);
                
                // Y cerramos la conexión porque ya no vamos a operar más con él
                cliente.close();
                
                System.out.println("\t Se ha cerrado la conexión con el cliente: " +numCliente);
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
```

2. Ahora modificaremos el servidor para que reciba un datos y los muestre hasta que el cliente envíe el comando `QUIT`.

3. Y lo modificaremos para que muera después de recibir `SHUTDOWN`.

4. Ahora programaremos el cliente:
+  **Cliente**:
```java
import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String argv[]) {
        // Definimos los parámetros de conexión
        InetAddress direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 5000;  // Puerto de conexión
        
        System.out.println("Soy el cliente e intento conectarme");
        
        try {
            // Vamos a indicar la dirección de conexión
            //     dirección local (localhost)
            // direccion = InetAddress.getLocalHost(); 
            //     por String url o por IP como sigue
            byte addr[] = { (byte)192, (byte)168, (byte)0, (byte)37 };
            direccion = InetAddress.getByAddress( addr );
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO); 
            // Operamos con la conexión. En este caso recibimos los datos que nos mandan
            System.out.println("Conexión realizada con éxito");
            
            // Es inputStream porque los recibimos
            DataInputStream datos = new DataInputStream(servidor.getInputStream());
            // Si queremos leer normal
            //System.out.println(datos.readLine());
            // Si leemos con formato
            System.out.println(datos.readUTF());
            // Cerramos la conexión
            servidor.close();
            System.out.println("Soy el cliente y cierro la conexión");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

```

5. **PrinterWriter:** a menudo los alumnos se siente más cómodos utilizando PrinterWriter ya que con lo que queremos trabajar es con cadenas de caracteres. En este caso, debemos recordar activar la *autoflush* ya que de otra forma deberemos controlarlo “a mano”. \

   Esto es, sustituiremos `DataOutputStream` por `PrinterWriter`, con lo que luego podremos sustituir el método `writerUTF` por el reconocido `println`.

## Chat 1 a 1:
Deberemos crear un servidor de chat al que se conectarán 2 clientes. El servidor se encargará de recibir los mensajes de ambos y reenviarlos al otro cliente.

El cliente:
1. pedirá host
2. mostrará a la derecha (`\t\t\t`) los mensajes recibidos y a la izquierda los enviados (al contrario que whatsapp).

El servidor:
1. aceptará peticiones en puerto por defecto (1234).
2. cuando reciba la primera generará la conexión y enviará un mensaje indicando “... esperando segundo cliente...”
3. cuando reciba el segundo cliente comenzará a gestionar los mensajes
4. si recibe un “EXIT” de cualquiera de los dos clientes enviará un “ SE HA CERRADO LA SALA ” y desconectará a los clientes.

**Mejoras:**
+ Gestión del doble check

## Chat 1 a muchos:
Se aceptarán más de 2 clientes. \
Las conversaciones comenzarán con el nombre del emisor.

[*Patrón Observador*](https://es.wikipedia.org/wiki/Observer_(patr%C3%B3n_de_dise%C3%B1o))



## Desarrollo
[apuntes - codeandcoke.com](https://psp.codeandcoke.com/apuntes:sockets)

# Referencias
+ [Doc Oficial de Red en Java21](https://docs.oracle.com/en/java/javase/21/core/java-networking.html#GUID-82A738CB-2A1C-4AC8-B9DA-C4543D398B51)
+ https://github.com/joseluisgs/ProgServiciosProcesos-00-2022-2023
+ https://oscarmaestre.github.io/servicios/index.html
+ https://github.com/ldmoral1987/temario-psp-dam 
+ https://psp.codeandcoke.com
+ https://github.com/socketio/chat-example
+ [Java T point](https://www.javatpoint.com/socket-programming)
+ [Programador Ya](https://www.programarya.com/Cursos-Avanzados/Java/Sockets)
+ [Geeks for Geeks](https://www.geeksforgeeks.org/socket-programming-in-java/)
+ [**Websockets - Arquitectura Java](https://www.arquitecturajava.com/java-websockets/)