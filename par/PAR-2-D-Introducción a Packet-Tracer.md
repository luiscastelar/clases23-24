#curso23_24 #PAR [estado::Working]

> **Packet Tracer** de Cisco es un programa de simulación de redes que permite a los estudiantes experimentar con el comportamiento de la red y resolver preguntas del tipo «¿qué pasaría si...?».
> 
> Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Packet_Tracer)

[Packet-tracer - *Presentación* oficial](https://learningnetwork.cisco.com/s/article/el-software-de-simulacion-cisco-packet-tracer)

**Descargas**: Sólo desde la dirección anterior o desde [ccna desde cero](https://ccnadesdecero.es/descargar-packet-tracer/) verificando el checksum.

## Primera comunicación:

1. En primer lugar, deberemos tener una cuenta de la *Cisco Network Academy* para poder acceder.
2. Después crearemos una conexión punto a punto con par de cobre cruzado entre los host `PC0` y `PC1` (ver parte izquierda de la imagen).
   
![1](https://luiscastelar.duckdns.org/2023/assets/PAR/Packet-Tracer/pt-1.png)

3. Configuraremos los equipos de forma que se encuentren en la misma red, y por tanto puedan hablar entre ellos de forma directa. \
   La IP que le asignaremos a los equipos será `192.168.X.Y`, siendo `X` nuestro número de clase e `Y` dos números cualesquiera (diferentes del de red y el de broadcast).
   
![2](https://luiscastelar.duckdns.org/2023/assets/PAR/Packet-Tracer/pt-2.png)

4. Ahora añadiremos una `Simple PDU` que Packet Tracer convertirá en un mensaje `echo request` - `echo reply`, o como muchos conoceréis como un `ping`-`pong`.\
   Esta comunicación la podremos analizar mediante la imagen inferior.


   
![1](https://luiscastelar.duckdns.org/2023/assets/PAR/Packet-Tracer/pt-1.png)

![3](https://luiscastelar.duckdns.org/2023/assets/PAR/Packet-Tracer/pt-3.png)