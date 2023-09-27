#curso23_24 #PAR [estado::Working]

# {[Fold: Fold]} UT1 - Caracterización de redes. Modelo de capas y normas.
![boceto de red](https://luiscastelar.duckdns.org/2023/assets/PAR/boceto_red.png)
## Introducción

A principios de los 70 con la popularización de equipos informáticos en las empresas y universidades aparece la necesidad de compartir
información más allá de las rudimentarias conexiones punto a punto entre
dos `HOST` por `RS232`, `RS485` o incluso `RTB`.\
Para ello comienzan las primeras pruebas de creación de redes multipunto
que permitan compartir recursos, archivos e impresoras
fundamentalmente).\
Posteriormente, el número de servicios a compartir ha ido
incrementándose poco a poco hasta encontrarnos en algún caso equipos de
personas que trabajan enteramente en remoto, quedando sus equipos
locales como terminales de acceso intercambiables.


## Mapa conceptual de la unidad
![mapa conceptual](https://luiscastelar.duckdns.org/2023/assets/PAR/UT1-esquema.png)

## Características de Redes Locales. Ventajas e inconvenientes.

Una red local se caracteriza fundamentalmente en su velocidad y
distancia de transmisión, capacidad de nodos y compatibilidad con el
medio y con redes \"vecinas\" a las que conectarse.\
| Tipo | Ventajas | Inconvenientes |
| --- |  --- | --- |
| Conexión PP | Simplicidad | Complejidad |
|     | conex pto a pto | conex múltiples |
|     | Seguridad y coste | Seguridad, velocidad y |
|     |     | coste múltiples saltos |
| Red local | Flexibilidad | Seguridad |
|     | Admin centralizada |     |
|     | Escalabilidad |     |
|     | Tolerancia a fallos |     |
|     | **ORGANIZACIÓN** |     |

## Tipos. Clasificación de las redes.

Las redes pueden clasificarse según múltiples características. Veremos
las más relevantes.


### Clasificación por su distribución espacial:

La distribución espacial marca en gran medida el tipo de red a utilizar
e incluso la tecnología ya que no es lo mismo querer conectar nodos a
escasos metros que a miles de kilómetros.

-   PAN (Personal Area Network): Un ejemplo típico es las conexiones
    bluetooth entre auriculares y móviles.
-   **LAN** (Local Area Network): P.e. red de equipos de una clase o de
    un hogar.
-   CAN (Campus): P.e. red de un campus universitario donde existen
    distintos edificios con distintas LAN.\
    Nuestro centro por proximidad de unos edificios a otros funcionan
    como una única red local (172.18.118.0 con máscara 255.255.254.0).
-   MAN (Metropolitan): habitual en pequeños municipios que proporcionan
    wifi a sus ciudadanos.
-   **WAN** (Wide): es una red de área extensa. Normalmente es una red
    heterogénea de redes. ¿Cuál es el ejemplo más conocido?

> Nota: en este módulo (asignatura) nos centraremos fundamentalmente en
> LAN y WAN ya que son las más importantes a nivel empresarial y por
> tanto las que más trabajo y dinero nos van a reportar 🤑.


### Clasificación por titularidad:

-   Redes públicas: internet.
-   Redes privadas: red wifi de casa o conexión punto a punto de sedes
    de un banco.


### Componentes de una red.

En toda red tenemos diversos componentes hardware y software que entran en juego.

De forma resumida:

| Hardware de red | Software de red |
| --- | --- |
| Topología (física) | Topología lógica |
| Servidor/res | Servicio |
| Cliente/tes | Protocolo |
| Medios (cables) y conectores | Interpretación de señales (drivers) |
| Tarjetas de red | Drivers del S.O. |

Descripción de la terminología:

-   DTE (Equipo terminal de datos): equipos informáticos. Es el equipo
    emisor y/o receptor de los datos.
-   DCT (Terminal circuito de datos): tarjetas de red y modems. Es el
    dispositivo de adaptación del bus de datos interno al canal de
    transmisión.
-   Canal o línea de transmisión: es el medio por el cual viajan los
    datos del equipo A al B y viceversa. Puede ser con conductores
    eléctricos, fibra o aire. Se compone de:
    -   Conectores. P.e. en coaxial bnc, en pares trenzados rj45, en
        fibra los conectores SC, LC, FC y ST, y en wifi las propias
        antenas
    -   Medio: P.e. cable coaxial, pares trenzados (UTP, STP, ...),
        fibras monomodo y multimodo, y aire. \
        *Existe bibliografía donde a ésto lo denominan capa 0*.

> Existen bastantes experimentos de conexiones ópticas por el aire con
> enlaces punto a punto con láser.\
> Tienen grandes ventajas económicas, pero los enlaces deben tener
> visión directa (sin edificios) y son sensibles a las condiciones
> metereológicas (lluvia y nieblas).

![dte-dce](https://luiscastelar.duckdns.org/2023/assets/PAR/DTE-DCE-medio.png)

## Topologías de red.

### Topología (física):

La topología de la red es el camino físico que une los distintos `HOST` de una red. A día de hoy, la habitual es la topología en estrella, pero por motivos históricos nos podemos encontrar aún:

-   Bus
-   Anillo
-   Estrella
-   Malla
-   Árbol
-   Mixta: normalmente estrella-bus o estrella-anillo.

    ![topologías](https://luiscastelar.duckdns.org/2023/assets/PAR/Topologia_de_red.png)

### Topologías lógicas de red:

Una vez establecido el medio en el apartado de topología de red, la
topología lógica de red consiste en la forma de acceso al medio de cada `HOST`. Puede ser:

-   Broadcast: cada `HOST` envía la información a todos `HOST` de la red
    y no existe orden alguno para realizarlo. La red `ethernet` utiliza
    esta topología.
-   Transmisión de token: los `HOST` sólo pueden transmitir cuando
    tienen el `token` en su poder, y al finalizar (por tiempo o por
    necesidad) pasan el `token` al siguiente nodo de la red.\
    Ejemplos con esta topología tenemos `Token ring` (clásica en las
    primeras redes de bus y anillo) y la `FDDI` moderna de transmisión
    de datos por fibra óptica.

## Arquitecturas de red:

![arquitectura de red](https://upload.wikimedia.org/wikipedia/commons/9/92/Arq_de_una_red.png)
> La **arquitectura de red** es el diseño de una [red de comunicaciones](https://es.wikipedia.org/wiki/Red_de_comunicaciones "Red de comunicaciones"). Es un marco para la especificación de los componentes físicos de una red y de su organización funcional y configuración, sus procedimientos y principios operacionales, así como los protocolos de comunicación utilizados en su funcionamiento.
>
> Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Arquitectura_de_red)


## Protocolos de comunicación.

Un protocolo es el conjunto de reglas que se establecen para la
comunicación entre dos elementos, p.e. comunicación alumno-alumno,
alumno-profesor o profesor-director. En informática, las comunicaciones establecen unos protocolos en forma de escalera, proporcionando las capas inferiores servicios de abstracción a los superiores, o dicho de otro modo, cada capa resuelve un problema distinto.

Es importante recordar que las capas sólo se comunican con capas de su
mismo nivel. 

![capa a capa](https://luiscastelar.duckdns.org/2023/assets/PAR/capa_a_capa.jpeg)
### Familia de protocolos:

Pese a que todos los protocolos que hemos visto hasta ahora son estructurados en las pilas de protocolos, la realidad es que históricamente las distintas compañias de software realizaban implementaciones **propietarias** en forma de familias.

Las más conocidad históricamente son NetWare de Novell con gran peso
desde los 70 hasta mediados de los 90 cuando fue desplazado poco a poco por la familia TCP/IP de origen UNIX.\

Todavía resisten algunos servicios de las familias AppleTalk (de Apple
Computer) y NetBeui (de IBM/Microsoft). El más reseñable es el protocolo SMB de compartición de carpetas para Windows dada la extensa difusión de dicho S.O. y no por méritos reseñables frente a NFS.


## Modelo de capas
![capas ISO](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi0.wp.com%2Fwww.elingesor.com%2Fwp-content%2Fuploads%2F2019%2F05%2Fosi.jpg%3Ffit%3D768%252C576%26ssl%3D1&f=1&nofb=1&ipt=7fb9890fd4ef6fcb20574cda551a9ca6e1d0589026a523c313ce66803fc46a57&ipo=images)
### Descripción de capas:
![concreto ISO](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.platzi.com%2Fmedia%2Fuser_upload%2FCaptura%2520de%2520Pantalla%25202022-01-26%2520a%2520la(s)%25207.18.25%2520p.m.-c9668c1c-6cea-4114-a78f-a37d97f00bea.jpg&f=1&nofb=1&ipt=d639d71b020b56e0193d84d4df6dd7adc249a86a7c3b3b16950385862a665556&ipo=images)
*Analogía del modelo de capas:*
![osi](https://pplware.sapo.pt/wp-content/uploads/2010/09/Osi_parallel_port_thumb.jpg)
*Otra analogía*:
|   Capa   |  ISO            |  TCP/IP               |  Analogía     |
|----------|-----------------|-----------------------|---------------|
| 7        |  Aplicación     |  Aplicación           |  Texto (idea) |
| 6        |  Presentación   |                       |  Papel o Msg de Whatsapp o foto o vídeo |
| 5        |  Sesión         |                       |  Sobre o chat o video llamada  |
| 4        |  Transporte     |  UDP, TCP             |  Carta o Carta certificada o doble check de whatsapp   |
| 3        |  Red            |  IP                   |  Apartado de correos o nickname de Telegram            |
| 2        |  Enlace         |  Ethernet, Wifi,      |  Dirección real del apartado o nº tlf real             |
| 1        |  Física         |  Fibra,...            |  Calle y edificio o Phone o Huawei                     |

> ¿Cómo recordar los nombre de todas la capas? Fácil:
    Please | Physical Layer
    Do | Data Link Layer
    Not | Network Layer
    Tell (the) | Transport Layer
    Secret | Session Layer
    Password (to) | Presentation Layer
    Anyone | Application Layer


## Otras capas
En la actualidad, fuera del modelo OSI nos encontramos que abundante bibliografía hace referencia a las siguientes capas:
+ Capa 0: Medio físico. Tratado especialmente en bibliografía que analiza las calidades de fibras para la transmisión de la luz.
+ **Capa 8**: muy a menudo se hace referencia a *errores de capa 8*, haciendo alusión a aquellos errores de comunicaciones provocados por el usuario de la misma.
+ Capa 9: Es una referencia a los “jefes” o la “empresa” u “organización” donde se encuentra la red de comunicaciones. A menudo son referidos los errores de capa 9 a las malas decisiones tomadas en contra de toda lógica y recomendación técnica (p.e. utilizar la IP 1.1.1.1 para comunicación interna con los routers de `Movistar` o `Vodafone`).
+ Capa 10: Es una referencia a las decisiones políticas y normativas que condicionan la estructura de la red. P.e. recientemente ha salido a la luz un borrador de norma europea donde se estudia impedir normativamente las comunicaciones cifradas extremo a extremo... ***Gran Hermano** se acerca a nosotros*.

## Encapsulamiento de la información:
...y los servicios.
![encapsulamiento](https://luiscastelar.duckdns.org/2023/assets/PAR/ut1_encapsulamiento.png)
Visto de otra forma:
![Ejemplo de encapsulación de
información.](https://luiscastelar.duckdns.org/2023/assets/PAR//Encapsulamiento-de-datos.png)


### Interoperatividad 
Dado que cada capa empaqueta se da la circunstancia que las capas de un dispositivo se comunican horizontalmente con las de su homólogo, esto es:
![topologías](https://luiscastelar.duckdns.org/2023/assets/PAR/ipencap.png)*Nota: Esto es parcialmente falso. Más adelante veremos porque.*



### Pila teórica ISO frente a la pila real TCP-IP:
![topologías](https://luiscastelar.duckdns.org/2023/assets/PAR/pila_tcp-ip-recortao.png)
> Nota: El modelo TCP/IP no define las capas 1 y 2, dejándoselas por
> completo a la implementación física de cada red, p.e. ethernet, FDDI,
> 802.11 (WLAN o Wifi), 802.15 (WPAN o bluetooth, entre otros) o 802.16 (WMan o WiMax).


## Normas
![huevo o gallina](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fg3xZSZPqMrE%2Fmaxresdefault.jpg&f=1&nofb=1&ipt=374618e18d6d1ecac967ea70dea6288296a5981d6c712b7c065dd0d9190c233f&ipo=images)

**IEEE 802.x** y **ANSI/TIA-xxx**


# {[Fold: Fold]} ==VOY POR AQUÍ==

**Ejercicio**: Investiga y responde sobre las normas IEEE 802.x y ANSI/TIA-xxx:
1. ¿Que significan las siglas?
2. ¿Cómo se organizan las normas IEEE 802.x?
3. ¿Cuáles son las tecnologías que conoces sobre las normas IEEE 802.x y para que las utilizas?
4. Sobre las ANSI/TIA-568... ¿qué hacen? ¿qué variantes hay? ¿en qué se diferencian?
5. Qué me puedes decir sobre las normas ANSI/TIA:
  + 569-A
  + 570-A
  + 606

6. Sobre las normas anteriores... ¿Existe relación con normas IEEE?

**Ejercicio capa 1**: ¿Creación de latiguillos de red ANSI/TIA 568A-A... o B-B? [referencia](https://www.forodvd.com/tema/137653-fabricar-tus-cables-de-red/)

**Voluntarios**: 
+ Creación de latiguillo **cruzado** => A-B
+ Creación de latiguillo consola => [¿rolled?](https://www.cisco.com/c/es_mx/support/docs/routers/7000-series-routers/12223-14.pdf)
  


## Las tecnologías “Ethernet”. FDDI.

+ Ethernet -> [802.3](https://es.wikipedia.org/wiki/IEEE_802) -> Ethernet, Fast, Giga, ... sobre par de cobre o fibra.
+ FDDI -> Anillos de fibra -> tecnología **obsoleta**.

Echando un vistazo al interior de una trama ethernet...
![trama ethernet](https://luiscastelar.duckdns.org/2023/assets/PAR/trama_ethernet.png)

Y revisando la estructura general de sobrecarga de paquetes:
![encabezado](https://luiscastelar.duckdns.org/2023/assets/PAR/formatos_de_cabeceras.png)

## El modelo OSI y “Ethernet”

¿Qué relación hay entre el modelo TCP/IP y Ethernet?

¿Y entre Ethernet y el modelo OSI? -> [ethernet](https://es.wikipedia.org/wiki/Ethernet)

## Acceso al medio CSMA/CD
Carrier Sense Multiple Access  with Collision Detection o CSMA/CD es en español, acceso múltiple con escucha de portadora y detección de colisiones.

[csma/cd](https://es.wikipedia.org/wiki/Carrier_sense_multiple_access_with_collision_detection) -> [youtube csma/cd](https://www.youtube.com/watch?time_continue=48&v=n6yNNNTSmYk&embeds_referring_euri=https%3A%2F%2Fduckduckgo.com%2F&feature=emb_title)


# {[Fold: Fold]} LA INSTALACIÓN FÍSICA DE UNA RED
Enfocándonos en la capa 1, la capa física, vamos a estudiar y analizar la organización del cableado (Ethernet y fibra) para obtener un sistema de **CABLEADO ESTRUCTURADO**.

## Espacios.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/structured_cabling.png)

El cableado estructurado es el tendido de cables en el interior de un
edificio (o campus) para la creación de una LAN (Red de Áreal Local).

A dia de hoy tratarse de cable de par trenzado de cobre UTP/STP (sin o con envolvente metálica), para redes de tipo Ethernet (norma IEEE
802.3). No obstante, también puede tratarse de fibra óptica en algún
punto de interconexión de switches, ~~y algún remanente obsoledo de cable coaxial~~.

El estándar EIA/TIA 568 sobre cableado de comunicaciones (voz, imagen,
LAN, WAN) que define los parámetros que permiten establecer el cableado de un edificio. Se entiende el cableado como un servicio más del edificio (luz, agua, gas y datos).

Podemos diferenciar los siguientes espacios y subsistemas:

1.  Equipo de usuario.
2.  Latiguillo de red: conecta el equipo de usuario a la toma fija de la     pared.
3.  Toma o roseta: es el punto de terminación de red. El último punto
    fijo de la instalación.
4.  Subsistema horizontal o de planta: es el conjunto de cables que van desde el armario de distribución de planta hasta los distintos
    puntos de terminación de red.\
    En ocasiones, especialmente cuando la distancia es elevada, podemos encontrarnos armarios intermedios de distribución, de forma que desde el armario de planta a una sala concreta se tiende sólo un cable por el consecuente ahorro en mano de obra o para evitar las pérdidas siendo cable de fibra.
5.  Subsistema distribuidor (armarios de planta): son los racks
    (armarios) que interconectan el subsistema vertical con el cableado de planta. En él se encuentran los switchs/hubs y los equipos de terminación del cableado (paneles de parcheo).
6.  Subsistema vertical, dorsal o de edificio: es el cableado que
    interconecta el distribuidor de edificio con cada una de los
    armarios de planta. Su necesidad de ancho de banda es elevado por lo que suele implementarse mediante conexiones ATM, FDDI o Gigabit
    Ethernet.
7.  Subsistema distribuidor de edificio: realizan la misma función que
    los distribuidores de planta.
8.  Sala de servidores: En algunas empresas existe una zona donde se
    encuentran los servidores físicos que sostienen todo o parte de los servicios que necesita la empresa, como servicios de Active
    Directory o servicios de archivos.
9.  Gateway o equipo de salida: es el equipo que realiza las funciones
    de puerta de enlace o puerta de salida al exterior, adaptando las
    direcciones privadas en públicas y uniendo la red exterior a la red privada.
10. Fibra de salida.

En realidad, como ya veíamos en clase, el equipo de usuario y el
latiguillo de red no son parte del cableado estructurado ya que son
partes móviles y podrán existir o no en tiempo.

## Cuartos de comunicaciones.
![](https://luiscastelar.duckdns.org/2023/assets/PAR/telecom_room.jpg)
Son las salas que debe disponer todo edificio donde ser recoge la
entrada de los suministros de comunicaciones, líneas telefónicas y fibra fundamentalmente, aunque también recepción de televisión por cable o aire y satélite. 

En ellos se ubican los equipos informáticos de entrada como GATEWAY y
ROUTER, y en la mayoría de los casos también es el subsistema
distribuidor de edificio y punto de partida del subsistema vertical.

Leer [Información importante sobre cuartos de
comunicaciones](http://pedrovallejo.blogspot.com/2016/04/un-cuarto-de-telecomunicaciones-optimo.html)


## Armarios de comunicaciones. Paneles de parcheo.

Los armarios de comunicaciones pueden albergar múltiples elementos como podemos ver en la figura.

Las dimensiones habituales del mismo es de unos 600 mm, pero el
interior, la zona útil, es siempre estandar de 19 pulgadas. Podremos
encontrar algunos armarios de 800 mm de ancho, pero las sujeciones
interiores continuarán a 19 pulgadas, por lo que el trabajo en ellos
será más cómodo.

El alto se mide en unidades, siendo las más habituales de 12 U, 24 U o
42 U, siendo U unos 44,45 mm.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/rack_2m.png)

La organización y orden en ellos es fundamental...
![](https://luiscastelar.duckdns.org/2023/assets/PAR/rack_mal.jpg)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/rack_bueno.jpg)

## [Patch Panels](https://duckduckgo.com/?q=patch+panel&t=newext&atb=v388-1&iax=images&ia=images&iai=https%3A%2F%2Fordenadores-y-portatiles.com%2Fwp-content%2Fuploads%2F2020%2F05%2FPatch-Panel-746x420.jpg)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/panel_parcheo.jpg)
Instalación de [paneles de
parcheo](https://www.youtube.com/watch?v=5PLrhc4I8m8).

### Temperatura de armarios
Otro aspecto fundamental en los armarios es la gestión de la temperatura ya que los dispositivos que contienen suelen producir bastante calor y por tanto el armario debe estar pensado para la evacuación de calor. 

Adecuándonos al tamaño de nuestro rack o instalación deberemos tener en cuenta:
+ Flujos de aire.
  ![espacios](https://luiscastelar.duckdns.org/2023/assets/PAR/UT1_temperatura_rack_1.png)
  
+ Altura de colocación de elementos.
+ Pasillos fríos y calientes.
+ Temperatura de trabajo máxima soportada por los equipos.
+ ...

Algunas ideas:
+ [AA/CC profesional](https://www.youtube.com/watch?v=r0WqZHD1Kyw)
+ [Análisis completo](https://www.youtube.com/watch?v=cJX1fZ1nvBs)


## Canalizaciones: Tipos. Procedimientos de montaje. Elementos de fijación.

Existen multitud de soluciones para canalizar el cableado, pero según
por donde discurran las dividiremos en canalización de: suelo (técnico),
techo, pared y superficie.

Veremos algunos ejemplos de canalizaciones en los siguientes enlaces:

-   [fpbredeschannel](https://fpbredeschannel.wordpress.com/2016/04/10/canalizaciones-para-redes/)
-   [Cableado Estructurado](https://cableadoestructurado1102.weebly.com/tipos-de-canalizaciones.html)
-   [Elias Cavero](https://cableadoestructuradofpb2.wordpress.com/tag/canalizaciones/)


## Medios de Comunicación. Cable convencional. Cables de Fibra óptica. Medios inalámbricos.

Hoy en día conviven el par trenzado de cobre, la fibra óptica y las
redes inalámbricas en la implementación de redes locales.

Pasemos a ver las principales carácterísticas.

### Cable convencional (par trenzado):

Los cables de par trenzado transmiten las señales de forma diferencial y, al estar trenzados, hacen que las interferencias eléctricas que le lleguen afecten por igual a ambos conductores, y por tanto el
diferencial se mantenga inalterado.

La transmisión diferencial implica que la tensión aplicada a uno de los conductores también se aplica al otro con signo contrario.

El mínimo válido para ethernet es la transmisión a través de 2 pares, aunque lo habitual es el uso de 4 pares.

**Tipos:**
-   UTP: cable trenzado sin apantallar. Es el más básico, económico y de fácil instalación, pero son los más propensos a errores por distancia y ruidos.    ![](https://luiscastelar.duckdns.org/2023/assets/PAR/utp.jpg)
-   STP: cable trenzado apantallado. Es algo más caro y difícil de manejar, pero su apantallamiento lo hace más inmune al ruido. El uso de estos cables está asociado con los conectores RJ49, equivalente a los RJ45 con toma de tierra.
    ![](https://luiscastelar.duckdns.org/2023/assets/PAR/stp.jpg)
-   FTP: pares trenzados con apantallamiento global. Mejora la protección frente a interferencias.
    ![](https://luiscastelar.duckdns.org/2023/assets/PAR/ftp.jpg)

### Fibra óptica

Son filamentos de vidrio de distinta densidad que provocan la refracción de las ondas de luz en el interfase de ambas densidades de forma que "atrapan" las ondas de un determinada longitud de onda.
![](https://luiscastelar.duckdns.org/2023/assets/PAR/fibra_optica.jpg)
![](https://luiscastelar.duckdns.org/2023/assets/PAR/fibra_monomodo.jpg)

## Conectores, tomas de red y herramientas.

Como ya hemos ido mencionando, los conectores más habituales son el
RJ45, y en redes de alta calidad con STP o FTP se suelen utilizar RJ49
que ponen a tierra las envolventes metálicas de los cables aportando un
extra de inmunidad al ruido.\
\#+CAPTION: Terminales RJ45 y RJ49

![terminal rj45](https://luiscastelar.duckdns.org/2023/assets/PAR/rj45.jpeg)

![crimpadora rj45](https://luiscastelar.duckdns.org/2023/assets/PAR/cimpadora.jpeg)

También hemos visto como se instala una toma de red en su conector
hembra gracias a la herramienta de impacto.\

![Detalle de toma con esquema T568 A y B](https://luiscastelar.duckdns.org/2023/assets/PAR/toma_red.jpeg)

![herramienta de impacto](https://luiscastelar.duckdns.org/2023/assets/PAR/herramienta_de_impacto.jpeg)

## Conexión de tomas y paneles de parcheo.

También hemos visto las realización de la conexión de una toma y un detalle de un panel de parcheo.

![detalle del parcheo](https://luiscastelar.duckdns.org/2023/assets/PAR/conexion_toma.jpeg)

![trasera del patch panel](https://luiscastelar.duckdns.org/2023/assets/PAR/panel_parcheo2.jpeg)

## Creación de cables. Certificación de cableado. Pruebas.

Existen 2 tipos de cable para la conexión entre equipos, el directo y el
cruzado. El primero lo utilizaremos para conectar `HOST` a equipos de
red `SWITCH`, `HUB` o `ROUTER`.

Los segundos, los cables cruzados, los utilizaremos para conectar dos
equipos iguales, esto es, `HOST` con `HOST`, o equipo de red con equipo
de red.

Algunas figuras para la confección y uso de cables cruzados:

![](https://luiscastelar.duckdns.org/2023/assets/PAR/cable_cruzado.png)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/pc_cable_cruzado_pc.png)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/pc_switch_pc.png)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/PC-Switch-Cable_cruzado-Switch-PC.png)


Ejemplo de construcción de [cable PoE cruzado](https://www.taringa.net/+hazlo_tu_mismo/como-armar-cable-de-alimentacion-y-datos-poe_hifrm) casero.

*En la actualidad, gracias a la norma Auto-MDIX no es necesario utilizar cables cruzados.*

![](https://luiscastelar.duckdns.org/2023/assets/PAR/T568A_y_T568B.png)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/TIA568.png)

En instalaciones **nuevas** se preferirá el **T568**, y en antiguas con sistemas T568B presente, se preferirá ésta.

Para la certificación de cableado existen herramientas similares a los tester mostrados en el aula, pero que nos indican la calidad del cable, la longitud y las pérdidas.

### Tipos de cables según su certificación:

  | Categoría |   Apantallamiento  | Máx Tasa (a 100 metros) |  Ancho de banda |
  | --------- | -----------------  | ----------------------- | ----------------|
  | Cat 3     |  NO                | 10 Mbps                 |   16 MHz        |
  | Cat 5     |  NO                | 10/100 Mbps             |  100 MHz        |
  | Cat 5e    |  NO                | 1000 Mbps / 1 Gbps      |  100 MHz        |
  | Cat 6     |  SÍ o NO           | 1000 Mbps / 1 Gbps      |  250 MHz        |
  | Cat 6a    |  Sí                | 10000 Mbps / 10 Gbps    |  500 MHz        |
  | Cat 7     |  Sí                | 10000 Mbps / 10 Gbps    |  600 MHz        |
  | Cat 8     |  Sí                | 25 Gbps or 40Gbps       | 2000 MHz        |

Podemos ver que a día de hoy la categoría 6a nos ofrece la mejor relación calidad precio con prespectivas de futuro a medio plazo.

Ya existen cables `CAT 6a` sin apantallamiento metálico, con la reducción de costes y simplicidad de manipulación.


### Estándard PoE (Power over Ethernet)

El estándar PoE fija las normas que deben de cumplir los dispositivos para recibir la alimentación a través del cableado estándar Ethernet existente en la empresa.

El estándard PoE nos permite conectar y alimentar puntos de acceso (AP), cámaras IP, routers, etc. a la red ethernet y evita la necesidad de tender un cableadlo eléctrico hasta donde se ubican dichos dispositivos, cargándose a través de `SWITCH PoE`, normalmente.


# {[Fold: Fold]} ==PENDIENTE DE REVISIÓN==

## EJERCICIOS:


1.  Realizar un esquema de los elementos del cableado estructurado.
2.  Buscaremos en la red manuales con recomendaciones de instalación de
    cableado.
3.  ¿Qué es una colisión Ethernet? ¿Y un dominio de colisión?
4.  Cita los elementos que organizan una instalación construida con
    cableado estructurado.
5.  ¿Qué instrumentos tiene a su disposición el instalador de red para
    hacer la certificación del cable?
6.  Declara como verdaderas o falsas las afirmaciones siguientes:
    -   El cableado vertical o de backbone siempre se tiende desde las
        plantas superiores a las inferiores o viceversa.
    -   Los latiguillos de red pertenecen al cableado estructurado.
    -   Los armarios de comunicaciones no pertenecen al cableado
        estructurado.
    -   Un cable UTP no puede superar los 100 metros de extremos a
        extremo.
    -   La máxima distancia permitida para un cable UTP es de 90 m sin
        contar los latiguillos de conexión en los extremos.


## EL PROYECTO DE INSTALACIÓN

La instalación consiste en la ejecución ordenada, según las directrices
del proyecto de instalación de un conjunto de tareas que revierten en
proporcionar el servicio que necesitaba el cliente que solicitó la
instalación.

Algunas de estas tareas se pueden superponer en el tiempo y habrá que
tener esto en cuenta al confeccionar el calendario de instalación. A
continuación describimos algunas de estas tareas:

-   **Diseño del cableado estructurado**. Plasmar en papel el diseño que
    queremos implementar posteriormente de forma física.
-   **Presupuestar**. Una vez que tenemos el diseño podemos realizar el
    presupuesto de materiales y mano de obra.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/flujo_de_trabajo.png)

-   **Instalación de las tomas de corriente**. Esta tarea suele
    realizarla un electricista, pero desde el punto de vista del
    proyecto debemos asegurarnos de que hay suficientes tomas de
    corriente para alimentar todos los equipos de comunicaciones.
-   **Instalación de rosetas y jacks**. Es la instalación de los puntos
    de red finales desde los que se conectarán los equipos de
    comunicaciones sirviéndose de latiguillos. La mayor parte de estas
    conexiones residirán en canaletas o en armarios de cableado.
-   **Tendido de los cables**. Se trata de medir la distancia que debe
    recorrer cada cable y añadirle una longitud prudente que nos permita
    trabajar cómodamente con él antes de cortarlo.\
    Debemos asegurarnos de que el cable que utilizaremos tenga la
    certificación necesaria.
-   **Conectorización de los cables** en los patch panels y en las
    rosetas utilizando las herramientas de crimpado apropiadas. A esto
    se le denomina cross-connect.
-   **Probado de los cables instalados**. Cada cable construido y
    conectorizado debe ser inmediatamente probado para asegurarse de que
    cumplirá correctamente su función.
-   **Etiquetado y documentación del cable y conectores**. Todo cable
    debe ser etiquetado en ambos extremos, así como los conectores de
    patch panels y rosetas, de modo que queden identificados
    unívocamente.
-   **Instalación de los adaptadores de red**. Gran parte de los equipos
    informáticos vienen ya con la tarjeta de red instalada, pero esto no
    es así necesariamente.
-   **Instalación de los dispositivos de red**. Se trata de instalar los
    concentradores, conmutadores, puentes y encaminadores. Algunos de
    estos dispositivos deben ser configurados antes de prestar sus
    servicios.
-   **Configuración del software** de red en clientes y servidores de la
    red.


## Referencias
+ [José Antonio Muñoz](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema04/Teoria.html)