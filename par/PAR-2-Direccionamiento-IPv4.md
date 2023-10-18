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


> **Ejercicio**: Streaming por multicast
> 
> How to use VLC Media player to stream multicast video By ane | 12 Dec, '12 | Posts, Technology, Tips
>
> When testing networks and routing, it is sometimes useful to be able to send a number of multicast streams across the network. VLC media player can do this, but getting it working is not as trivial as I expected.
>
> Here's how to do it:
> 
> In the Media menu, choose "Stream" In the Open Media dialog file
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
>
> To view the stream, open another instance of VLC media player (try
    it on the same PC before trying it over the network)
>
> Choose Media/Open Network Stream In address, enter
    rtp://@239.255.0.1:5004 -- choose the correct address and port you
    entered when setting up the stream. Don't forget to enter the "@"
    symbol after "rtp://" and before the multicast ip address! Click
    "Play"
>
> If you want to stream multiple videos, remember to choose an
    different multicast address and/or port

**Servidor**: 
```bash
vlc -vvv ~/Descargas/pelicula.mp4 --sout '#rtp{access=udp,mux=ts,dst=224.255.1.1,port=1234,sap,group="Video",name=Olas de mar"}' :sout-all
```

**Clientes**:
```bash
vlc -vvv rtp://224.255.1.1:1234
```


**Otras direcciones**:
+ Las direcciones de clase E, del 240.0.0.0 - 255.255.255.254. Fueron reservadas para experimentación. No deberíamos encontrarnoslas y menos usarlas.
+ La dirección 255.255.255.255 significa **todos los nodos**.


### Tipos de direcciones:
+ Unicast: comunicaciones 1 a 1.
+ Anycast: comunicaciones 1 a 1, donde varios servidores comparten una misma IP para formar CDN’s
  ![anycast](https://luiscastelar.duckdns.org/2023/assets/PAR/anycast-unicast-botnet-attack.webp)
+ Multicast: comunicaciones en grupos. Entre todos los equipos asociados a una IP de clase D.
+ Broadcast: comunicaciones de difusión 1 a todos.


## Rango de IPs: públicas, privadas y otras

Hasta ahora hemos visto algunos conceptos que no es necesario saber de memoria. Este punto por el contrario **deberéis MEMORIZAR** ya que es necesario.

-   **IPs PÚBLICAS**: Clases de IPv4:
  
      | Clase  | Rango |
      |-------| -----------------------------|
      |A  |     1.0.0.0 - 127.255.255.255|
      |B  |     128.0.0.0 - 191.255.255.255|
      |C  |     192.0.0.0 - 223.255.255.255|
          

    (*) En binario, se atiende a donde nos encontramos el primer cero y la posición corresponde a la clase.
    
    La **IP `0.0.0.0`** veremos que es una IP especial que el HOST interpreta como *no especificado*, esto es, según su posición significa que no tiene ip aún o que atiende en todas las interfaces (un “comodin”).

-   **IPs PRIVADAS**: Los siguientes rangos son de uso en redes privadas.

      | Clase |   Rango |                           Máscara RED |
      |-------| -------------------------------|  ------------- |
      | A |       10.0.0.0 - 10.255.255.255 |       255.0.0.0 |
      | B |      172.16.0.0 - 172.31.255.255 |    255.240.0.0 |
      | C |      192.168.0.0 - 192.168.255.255 |  255.255.0.0 |


-   **IPs RESERVADAS**:

    -   **IP no VÁLIDA**: La IP `0.0.0.0` no es una dirección válida ya que es utilizada como dirección `COMODÍN`. Esto es, cuando un equipo escucha en `0.0.0.0` lo que hace es escuchar en **TODAS** sus intarfaces de red.
    -   **IPs de BUCLE**: De las anteriores, debemos quitar la `127.x.x.x` ya que es la dirección de LOOPBACK, que también podemos invocar con `localhost`.
    -   *IPs INTERNAS DE ENRUTAMIENTO*: Las direcciones de `0.0.0.1` a `0.255.255.255` son utilizadas sólo por software para comunicaciones internas. Nosotros no le prestaremos atención.

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


## Evolución 1: Enrutamiento entre dominios sin clases (CIDR por sus siglas inglesas)

Su introducción permitió una mayor flexibilidad al dividir rangos de
direcciones IP en redes separadas. De esta manera permitió:

-   Un uso más eficiente de las direcciones IPv4 (Se acaban!!!!).
-   Un mayor uso de la jerarquía de direcciones (agregación de prefijos
    de red).

De IPv4 192.168.0.6 pasamos a 192.168.0.6/24. El CIDR, 24 en este caso,
indica el número de bits de red, con lo que ya no tenemos que pasar de
254 a 16.000 equipos. 

Ahora con el CIDR eso deja de estar bloqueado, por lo que podríamos poner
una máscara de 23 bits que partiría en 2 la red de clase C `192.168.0.0`, 
concretamente tendríamos la red `192.168.0.0/23` que va de `192.168.0.0` a 
`192.168.1.255` y una máscara de red `255.255.254.0`.


**Subredes:**

Una subred toma prestados bits de la parte de host para formar una
agrupación intermedia. P.e. la dirección 192.168.0.6/30 está creando una
subred, donde tenemos entonces: 24 bits de red + 6 bits de subred + 2
bits de host = 32 bits (eso **SIEMPRE** constante).

El CIDR es **siempre** la suma de los bits de red y de subred.

Análisis de la red con CIDR

Nos dicen que nuestro equipo está en la dirección 192.168.0.6/30. ¿Qué
sabemos de él?

1.  IPs comprendidas entre >=192 y <224 => Red de clase C.

2.  30 bits CIDR = 24 bits de red + 6 bits de subred.

3.  32 bits totales IPv4 - 30 bits CIDR = 2 bits de host

4.  Máscara de red:

    255.255.255.252 => 11111111.11111111.11111111.11111100

5.  Dir de subred:

    111111 => 6 bits => 2^6 = 64 subredes[^3]

6.  Bits de host:

    00 => 2 bits => 2^2-2 = 2 host

7.  Dirección de subred: Operación IP **&** Mascara de red

    192.168.0.6.......11100000.10101000.00000000.00000110

    255.255.255.252 - 11111111.11111111.11111111.11111100

    Subred........... 11100000.10101000.00000000.00000100 ->
    192.168.0.4

8.  Dirección de broadcast de subred:

    11100000.10101000.00000000.00000111 -> 192.168.0.7

9.  Primer host de la red (la siguiente a la de la subred): 192.168.0.5

10. Dirección del último host (la anterior a la de broadcast):
    192.168.0.6

### RFC 950 y RFC 1812:

En la RFC 950 hay que reservar la primera subred y la última sin
utilizar (similar a los host), por lo que el número de estas es 2^N-2.

En la RFC 1812 no hay que reservar nada. Entonces hay 2^N redes. Éste
es el estandar actual, por lo que si no se indica lo contrario, será el
utilizado.

*Nota: No necesitáis recorar los nombre de los estándares, sólo que si os lo
indican sepáis que lo tenéis que tener en cuenta ya que os encontráis
ante un equipo antiguo.*

[Ejercicios](https://www.educatica.es/redes/ejercicios-de-redes/)

Se pide determinar:

1.  Clase
2.  nº de bits de red y nº de redes
3.  nº de bits subred y nº de subredes
4.  nº de bits de host y nº de host
5.  Máscara de red (decimal y binario)
6.  Dirección de subred
7.  Dirección de broadcast de subred
8.  Primer host de la subred
9.  Último host de la subred
10. Primera subred de la red
11. Última subred de la red

De las direcciones IP:

-   192.168.20.154/27
-   192.168.20.154/28
-   192.168.20.154/29
-   192.168.20.154/30
-   172.25.184.253/19
-   172.25.184.253/20
-   172.25.184.253/21

### Referencias:
+ [Vídeo resúmen](https://youtu.be/6SMdDOlnqsw) (25 min) 
+ [Vídeo resúmen 2](https://www.youtube.com/watch?v=t-rtwD0-QMc&t=240s) (24 min)
+ [Subnetting](https://youtu.be/sbpuez96vpo): dividir una red para tener una subred donde podamos tener 12 equipos (16 min).


## Ejercicio de enrutamiento entre dominios sin clases (CIDR por sus siglas inglesas)

Dada la IPv4 172.54.12.26/26 podemos decir de ella:

-   Es una IP pública de la clase B, por lo que tiene 16 bits de RED. Ésto
    hace un total de 2^16 redes (65536 redes).
-   Nos indica además que tiene un CIDR de 26, por lo que el número de
    subredes disponibles serán 26 bits CIDR - 16 bits RED => 10 bits
    SUBREDES, 2^10 subredes (1024 subredes).
-   Nos deja por tanto 32 - 26 bits para HOST, esto es 2^6-2 HOST (62
    host), ya que sabemos que la 00 0000 y la 11 1111 son las
    direcciones de la subred concreta y de difusión (BROADCAST) de dicha
    subred.\
    **IMPORTANTE:** tenemos una subred cada 2^6 (64) direcciones.
-   Otros datos de interés:


| . | IP (dec) | . | IP (bin) |
|---|----------|---|-------|
|  IP             | 172.54.12.26/26 |   -> |    1010 1100.0011 0110.0000 1100.0001 1010 |
|  Másc. red      | 255.255.255.192 |  <- |    1111 1111.1111 1111.1111 1111.1100 0000 |
|  & => IP red    | 172.54.12.0     |  <- |    1010 1100.0011 0110.0000 1100.0000 0000 |
|  difusión       | 172.54.12.63    |  <- |    1010 1100.0011 0110.0000 1100.0011 1111 |
|                 |                 |     |      |
|  1er host       | 172.54.12.1     |     |     (En decimal -> IP de la red + 1) |
|  último host    | 172.54.12.62    |     |     (En decimal -> IP de difusión - 1) |
|                 |                 |     |      |
|  1ª subred      | 172.54.0.0      |  (1)|   1010 1100.0011 0110.0000 0000.0000 0000 |
|  Última subred  | 172.54.255.192  |  (2)|   1010 1100.0011 0110.1111 1111.1100 0000 |

(1) Todos los bits de subred a 0 (no de la máscara).\
(2) Todos los bits de subred a 1.

### Referencias:
+ [redes - educatica.es](https://www.educatica.es/redes/ejercicios-de-redes)
+ [Vídeo resúmen](https://youtu.be/6SMdDOlnqsw) (25 min)
+ [Vídeo resúmen 2](https://www.youtube.com/watch?v=t-rtwD0-QMc&t=240s) (24 min)
+ [Subnetting](https://youtu.be/sbpuez96vpo): dividir una red para tener una subred donde podamos tener 12 equipos (16 min)

## Evolución 2: Máscara de Subred de Logitud Variable - VLSM

La siguiente vuelta de tuerca el direccionamiento IP es no usar subredes
de tamaño fijo, con lo que se aprovecha mejor el tamaño.

Esto es, si partimos por ejemplo de la subred 192.168.20.128/25 de 126
host, podemos a su vez segmentarla en las subredes 192.168.20.0/26 de 62
host, y 192.168.20.128/27 y 192.168.20.160/27, de 30 host cada una.

## Máscaras de red especiales:

+ `/0`: Aparece a menudo la dirección `0.0.0.0/0` en las tablas de rutas. Hará las veces de *ruta por defecto* o **default gateway** o simplemente **gateway**.
- */24 is the Subnet Mask that is usually used in the local networks by
    default*.
- /30 is also widely used in Service Provider Networks for point-to-point connections.
+ **`/31`: la [RFC3021](https://www.rfc-editor.org/rfc/rfc3021) establece que las comunicaciones punto a punto podrán utilizar este CIDR**. No tiene sentido hablar de dirección de red y de difusión con sólo 2 equipos.
- /32 is the Subnet Mask used generally on Loopback and System interfaces.

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


