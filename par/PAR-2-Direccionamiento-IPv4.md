#curso23_24 #PAR [estado::Working]


## Mapa conceptual de la unidad
![mapa conceptual](https://luiscastelar.duckdns.org/2023/assets/PAR/UT2_MapaConceptual_IPv4.jpg)

# Direccionamiento IPv4

## Introducción. 

> El **protocolo de internet** (en inglés: *Internet Protocol*; cuya sigla es **IP**) es un [protocolo de comunicación](https://es.wikipedia.org/wiki/Protocolo_de_comunicaciones "Protocolo de comunicaciones") de datos digitales clasificado funcionalmente en la [capa de red](https://es.wikipedia.org/wiki/Capa_de_red "Capa de red") según el modelo internacional [OSI](https://es.wikipedia.org/wiki/Modelo_OSI "Modelo OSI").
>
> Su función principal es el uso bidireccional en origen o destino de comunicación para transmitir datos mediante [un protocolo no orientado a conexión](https://es.wikipedia.org/wiki/Protocolo_no_orientado_a_la_conexi%C3%B3n "Protocolo no orientado a la conexión") que transfiere [paquetes conmutados](https://es.wikipedia.org/wiki/Conmutaci%C3%B3n_de_paquetes "Conmutación de paquetes") a través de distintas redes físicas previamente enlazadas según la [norma OSI de enlace de datos](https://es.wikipedia.org/wiki/Capa_de_enlace_de_datos "Capa de enlace de datos").
>
> Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Protocolo_de_internet)


# ==VAMOS POR AQUÍ==

## Características del protocolo IPv4 (versión 4).
Como ya veíamos, este protocolo se enmarca en la capa 3 o capa de red y
nos proporciona el direccionamiento lógico de equipos. Con él podemos
direccionar "todos" los dispositivos que se conectan a internet...
hasta el máximo práctico de dicho protocolo.

El protocolo IPv4 es un protocolo que utiliza para el direccionamiento
32 bits ("1"s y "0"s), los cuales se dividen en grupos de 8 bits
para su jerarquización y simplicidad de uso.\
Teóricamente, con 32 bits podríamos direccionar hasta 4.294.967.296...
esto es, algo más de 4.200 millones de dispositivos.\
En la práctica, el número de dispositivos direccionables es bastante
inferior, por lo que a día de hoy ya tenemos un serio problema de
direccionamiento y por ello se encuentra en plena fase de expansión el
protocolo IPv6 que ~~cuenta con la capacidad de 128 bits~~ solventa varios de
los problemas que han llevado al agotamiento de direcciones.\
Pese a lo anterior, en redes locales el uso de la versión IPv4 es válida, 
así como el sistema más implantado en nuestro país, **España**, en la actualidad.

*Vamos a realizar un estudio con aproximaciones sucesivas, como así ha 
ocurrido en el tiempo.* \
*Estas aproximaciones son retrocompatibles. Salvo algunas licencias que nos
tomaremos para simplificar el proceso de aprendizaje, todo será válido en la 
actualidad, aunque poco frecuente*.

## Máscara de red:

Nos indica que bits pertenecen a la red y cuales al host:

-   255 -> 1111 1111 - Todo son bits de red
-   0 -> 0000 0000 - Todo son bits de host

[Vídeo aclaratorio 1 (UPV)](https://youtu.be/ZdWYe4PB0Qk)

No leer aún:
> Otro - Habrá que pasar a binario para conocer cuantos bits son de
  red y cuantos de host, dentro de una dirección IP. \
  P.e: 224 -> 1110 0000 -> 3 bits de red y 5 de host -> 2³ redes y 2⁵ direcciones
  de `host` -> 8 redes y 64 direcciones de `host`
> 


## IPv4 con CLASES

El direccionamiento IPv4:
-   Consta de 4 grupos de 8 bits y se clasifican en 5 clases según se
    distribuyan dichos bits.
-   Identifican a:
    -   Host: PC, móvil, router, etc...
    -   Red o subred: grupo de equipos
    -   Broadcast (difusión): todos los equipos de una red o subred.
-   La IP es un identificador **LÓGICO** y no físico como la MAC.

![direcciones con clases](https://static.spiceworks.com/attachments/cms/0000/1255/subnetting.png)

**Redes de clase A:**
+ Su primer 0 se encuentra en la posición *primera* (letra A), lo que hace que sus direcciones (en decimal) vayan de la 0.0.0.0 a la 127.255.255.255.
- Le corresponde una máscara de red con *un* byte a 1 y el resto a 0, esto es, 8 bits de `red` (2\^8 redes) y 24 bits de `host` (2\^24 direcciones).
- La dirección más baja queda reservada como dirección de red, como conjunto.
- La dirección más alta queda reservada como dirección de difusión o **broadcast**.
- El número total de dispositivos en la red es 2^24 - 2 `host`.
*No todas las redes están disponibles*.

**Redes de clase B:**
+ Su primer 0 se encuentra en la posición *segunda* (letra B), lo que hace que sus direcciones (en decimal) vayan de la 128.0.0.0 a la 191.255.255.255.
- Le corresponde una máscara de red con *dos* bytes a 1 y el resto a 0, esto es, 16 bits de `red` (2^16 redes) y otros 16 bits de `host` (2^16 direccciones).
- La dirección más baja queda reservada como dirección de red, como conjunto.
- La dirección más alta queda reservada como dirección de difusión o **broadcast**.
- El número total de dispositivos en la red es 2^16 - 2 `host`.
*No todas las redes están disponibles*.

**Redes de clase C:**
+ Su primer 0 se encuentra en la posición *tercera* (letra C), lo que hace que sus direcciones (en decimal) vayan de la 192.0.0.0 a la 223.255.255.254
- Le corresponde una máscara de red con *tres* bytes a 1 y el resto a 0, esto es, 24 bits de `red` (2^24 redes) y otros 8 bits de `host` (2^8 direccciones).
- La dirección más baja queda reservada como dirección de red, como conjunto.
- La dirección más alta queda reservada como dirección de difusión o **broadcast**.
- El número total de dispositivos en la red es 2^8 - 2 `host` = 254 dispositivos.
*No todas las redes están disponibles*.

**Direcciones de clase D:**
+ Son direcciones de tipo **multicast**, utilizadas para grupos de difusión.
+ Su primer 0 se encuentra en la posición *cuarta* (letra D), lo que hace que sus direcciones (en decimal) vayan de la 224.0.0.0 a la 239.255.255.255.
+ Todos los equipos que deseen tener un “chat grupal” informan a la red que desean vincularse al grupo.
+ A partir de ese momento, recibirán todos los mensajes dirigidos al grupo, y todos los mensajes con dirección destino el grupo será reenviada a todos los miembros del grupo.
+ Pueden enviar mensaje para desvincularse del grupo, y dejarán de recibir los mensajes del grupo.


*Otras direcciones*:
+ Las direcciones de clase E, del 240.0.0.0 - 255.255.255.254. Fueron reservadas para experimentación. No deberíamos encontrarnoslas y menos usarlas.
+ La dirección 255.255.255.255 significa **todos los nodos**.


**Ejercicio**: Streaming por multicast

    How to use VLC Media player to stream multicast video By ane \| 12
    Dec, \'12 \| Posts, Technology, Tips

    When testing networks and routing, it is sometimes useful to be able
    to send a number of multicast streams across the network. VLC media
    player can do this, but getting it working is not as trivial as I
    expected. Here's how to do it:

    In the Media menu, choose "Stream" In the Open Media dialog file
    tab, click "add" and choose the file you want to stream and click
    "Open" At the bottom, click the "Stream" button This opens the
    "Stream Output" dialog showing the source file you have chosen.
    Click Next to set destination. In "Destinations", choose "RTP /MPEG
    Transport Stream" and click the "Add" button In the "Address" box,
    enter the required multicast address (eg 239.255.0.1) and set the
    port (or leave default at 5004) In transcoding options, choose the
    appropriate settings for your video and PC's codecs. I chose "Video
    H.264 + MP3 (MP4)". I had to set the options by clicking the options
    (screwdriver and spanner) button immediately to the right of the
    dropdown. In encapsulation, I chose MPEG-TS. In video codec, I set
    the bitrate to 4000kb/s Once the options are set, click "Save". Then
    click Next for "Option Setup" and select "Stream all elementary
    streams" then click stream.

    To view the stream, open another instance of VLC media player (try
    it on the same PC before trying it over the network)

    Choose Media/Open Network Stream In address, enter
    rtp://@239.255.0.1:5004 -- choose the correct address and port you
    entered when setting up the stream. Don't forget to enter the "@"
    symbol after "rtp://" and before the multicast ip address! Click
    "Play"

    If you want to stream multiple videos, remember to choose an
    different multicast address and/or port


## Rango de IPs: públicas, privadas y otras

-   **IPs PÚBLICAS**: Clases de IPv4:
  
      | Clase  | Rango |
      |-------| -----------------------------|
      |A  |     1.0.0.0 - 127.255.255.255|
      |B  |     128.0.0.0 - 191.255.255.255|
      |C  |     192.0.0.0 - 223.255.255.255|
          

    (*) En binario, se atiende a donde nos encontramos el primer cero y la posición corresponde a la clase.
    
    La **IP `0.0.0.0`** veremos que es una IP especial que el HOST interpreta como *no especificado*, esto es, según suposición significa que no tiene ip aún o que atiende en todas las interfaces (un “comodin”).

-   **IPs PRIVADAS**: Los siguientes rangos son de uso en redes privadas.

      | Clase |   Rango |                           Máscara RED |
      |-------| -------------------------------|  ------------- |
      | A |       10.0.0.0 - 10.255.255.255 |       255.0.0.0 |
      | B |      172.16.0.0 - 172.31.255.255 |    255.240.0.0 |
      | C |      192.168.0.0 - 192.168.255.255 |  255.255.0.0 |


-   **IPs RESERVADAS**:

    -   **IP no VÁLIDA**: La IP `0.0.0.0` no es una dirección válida ya que es utilizada como dirección `COMODÍN`. Esto es, cuando un equipo escucha en `0.0.0.0` lo que hace es escuchar en **TODAS** sus intarfaces de red.
    -   **IPs de BUCLE**: De las anteriores, debemos quitar la `127.x.x.x` ya que es la dirección de LOOPBACK, que también podemos invocar con `localhost`.
    -   **IPs INTERNAS DE ENRUTAMIENTO**: Las direcciones de `0.0.0.1` a `0.255.255.255` son utilizadas sólo por software para comunicaciones internas. Nosotros no le prestaremos atención.

-   **IPs locales de enlace**: Cuando un HOST no puede establecer comunicación con ningún DHCP y no está configurado estático (a mano), comienza un proceso de autoconfiguración y se asigna a sí mismo una IP aleatoria dentro del rango `169.254.0.0` - `169.254.255.255`.

    > **Importante**: si nos encontramos que un HOST está en dicho rango es **síntoma** de que no pudo establecer comunicación con ningún DHCP.

+   **IPs para CGNAT**: El rango `100.64.0.0` a `100.127.255.255` es utilizado hacer NAT a nivel de operadora. Permite “multiplexar” una IP pública por 2^22 abonados (4 millones de direcciones aprox.).


### Ejercicio IP

Nos dicen que nuestro equipo está en la dirección 31.4.149.59. ¿Qué
sabemos de él?

1.  ¿A que clase pertenece?
2.  ¿Cuantos bits de RED y de HOST tiene?
3.  ¿Cuántas redes existen en esa clase?
4.  ¿Cuántos HOST puede haber en esa RED?
5.  ¿Qué máscara de RED le pertenece?
6.  IP de la RED a la que pertenece
7.  Dirección de difusión o BROADCAST
8.  Dirección del primer host de la RED
9.  Dirección del último host de la RED

[**Otros ejercicios**](https://www.educatica.es/redes/ejercicios-de-redes)


### Referencias:
+ [Vídeo resumen](https://www.youtube.com/watch?v=TldkSiygpPY) (versión larga 48 min)
+ [Vídeo corto](https://youtu.be/xyXQjZ7w_No) (versión corta 5 min)
+ [Vídeo corto 2](https://www.youtube.com/watch?v=EdhPwqWXZpI) (versión extra corta 4 min)
+ [Vídeo aclaratorio 1 (UPV)](https://youtu.be/ZdWYe4PB0Qk)


## IPv4 con CIDR

Vamos a estudiar las normas RFC950 y RFC1812 que realizan 2 mejoras sobre el uso del direccionamiento IPv4.

**CIDR** o Enrutamiento entre dominios sin clase (Classless Inter-Domain Routing) es un una mejora que nos permite dividir redes en subredes.

Por ejemplo, la red 8.0.0.0, red de clase A tiene 2^24 direcciones, o 16.777.216 direcciones. Es fácil pensar que hay pocas entidades con necesidad de tener algo más de 16 millones de equipos visibles desde internet. 

¿Entonces? Pues si a una empresa se le asigna una `clase A` se desperdicia muchas direcciones.

Pues, ¿y si le asignamos únicamente la mitad? ¿Cómo podríamos hacerlo? Con el **CIDR**.

Al principio hablamos de la `máscara de red` que nos indicaba que bits eran de dirección de red y que bits eran de host, pero esta máscara tenía 3 opciones: 8, 16, o 24 bits. 

Ahora con el CIDR eso deja de estar bloqueado, por lo que podríamos poner una máscara de 9 bits que partiría en 2 la red de clase A  `8.0.0.0`, concretamente tendríamos la red `8.0.0.0/9` y `8.128.0.0/9`

### Ejercicios IP

Nos dicen que nuestro equipo está en la dirección `31.4.149.59/8`, `31.4.149.59/9`, `31.4.149.59/15`, `31.4.149.59/16`. ¿Qué sabemos de él?

1.  ¿A que clase pertenece?
2.  ¿Cuantos bits de RED y de HOST tiene?
3.  ¿Cuántas redes existen en esa clase?
4.  ¿Cuántos HOST puede haber en esa RED?
5.  ¿Qué máscara de RED le pertenece?
6.  IP de la RED a la que pertenece
7.  Dirección del primer host de la RED
8.  Dirección del último host de la RED
9.  ¿Qué máscara de SUBRED tiene?
10.  ¿Cuántas SUBREDES tiene la RED?
11.  ¿Qué ip de SUBRED tiene?
12.  ¿Qué dirección de difusión o BROADCAST tiene?
13.  Dirección del primer host de la SUBRED
14.  Dirección del último host de la SUBRED
15.  [*opcional*] Dirección de la primera SUBRED
16.  [*opcional*] Dirección de la última SUBRED


### El error de la RFC950

Reserva la primera y ultima subred => Gran desperdicio cuando no es necesario.


### Sumarización

En ocasiones el proceso se realiza en el camino opuesto, esto es, unimos 2 redes contiguas por necesidad de mayor número de direcciones. 

*Se verá con más detenimiento más adelante*.


### Las excepciones
+ `/0`: Aparece a menudo la dirección `0.0.0.0/0` en las tablas de rutas. Hará las veces de *ruta por defecto* o **default gateway** o simplemente **gateway**.
+ `/31`: la [RFC3021](https://www.rfc-editor.org/rfc/rfc3021) establece que las comunicaciones punto a punto podrán utilizar este CIDR, ya que no tienen sentido hablar de dirección de red y de difusión con sólo 2 equipos.
+ `/32`: algunos sistemas indicarán esto como una obligación para que el equipo deba comunicarse de forma única con el gateway.


### Referencias:
+ [Vídeo resúmen](https://youtu.be/6SMdDOlnqsw) (25 min)
+ [Vídeo resúmen 2](https://www.youtube.com/watch?v=t-rtwD0-QMc&t=240s) (24 min)
+ [Subnetting](https://youtu.be/sbpuez96vpo): dividir una red para tener una subred donde podamos tener 12 equipos (16 min)


 # ==revisar==


## IPv4 VLSM

