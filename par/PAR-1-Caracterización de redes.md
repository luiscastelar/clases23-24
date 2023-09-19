#curso23_24 #PAR [estado::Working]

# UT1 - Caracterización de redes. Modelo de capas y normas.
![boceto de red](https://luiscastelar.duckdns.org/2023/assets/ED/boceto_red.png)

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

En toda red tenemos diversos componentes hardware y software que entran
en juego.\
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

![dte-dce](https://luiscastelar.duckdns.org/2023/assets/ED/DTE-DCE-medio.png)

## Topologías de red.

### Topología (física):

La topología de la red es el camino físico que une los distintos `HOST`
de una red. A día de hoy, la habitual es la topología en estrella, pero
por motivos históricos nos podemos encontrar aún:

-   Bus

-   Anillo

-   Estrella

-   Malla

-   Árbol

-   Mixta: normalmente estrella-bus o estrella-anillo.

    ![topologías](https://luiscastelar.duckdns.org/2023/assets/ED/Topologia_de_red.png)

### Topologías lógicas de red:

Una vez establecido el medio en el apartado de topología de red, la
topología lógica de red consiste en la forma de acceso al medio de cada
`HOST`. Puede ser:

-   Broadcast: cada `HOST` envía la información a todos `HOST` de la red
    y no existe orden alguno para realizarlo. La red `ethernet` utiliza
    esta topología.
-   Transmisión de token: los `HOST` sólo pueden transmitir cuando
    tienen el `token` en su poder, y al finalizar (por tiempo o por
    necesidad) pasan el `token` al siguiente nodo de la red.\
    Ejemplos con esta topología tenemos `Token ring` (clásica en las
    primeras redes de bus y anillo) y la `FDDI` moderna de transmisión
    de datos por fibra óptica.

## Protocolos de comunicación.

Un protocolo es el conjunto de reglas que se establecen para la
comunicación entre dos elementos, p.e. comunicación alumno-alumno,
alumno-profesor o profesor-director. En informática, las comunicaciones
establecen unos protocolos en forma de escalera, proporcionando las
capas inferiores servicios de abstracción a los superiores, o dicho de
otro modo, cada capa resuelve un problema distinto.\
Es importante recordar que las capas sólo se comunican con capas de su
mismo nivel. 

![capa a capa](https://luiscastelar.duckdns.org/2023/assets/ED/capa_a_capa.jpeg)
## Modelo de capas

![capas ISO](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi0.wp.com%2Fwww.elingesor.com%2Fwp-content%2Fuploads%2F2019%2F05%2Fosi.jpg%3Ffit%3D768%252C576%26ssl%3D1&f=1&nofb=1&ipt=7fb9890fd4ef6fcb20574cda551a9ca6e1d0589026a523c313ce66803fc46a57&ipo=images)

![concreto ISO](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fstatic.platzi.com%2Fmedia%2Fuser_upload%2FCaptura%2520de%2520Pantalla%25202022-01-26%2520a%2520la(s)%25207.18.25%2520p.m.-c9668c1c-6cea-4114-a78f-a37d97f00bea.jpg&f=1&nofb=1&ipt=d639d71b020b56e0193d84d4df6dd7adc249a86a7c3b3b16950385862a665556&ipo=images)

Pila teórica ISO frente a la pila real TCP-IP:

![topologías](https://luiscastelar.duckdns.org/2023/assets/ED/pila_tcp-ip-recortao.png)
# ==VOY  POR AQUÍ==

## Normas

![huevo o gallina](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fg3xZSZPqMrE%2Fmaxresdefault.jpg&f=1&nofb=1&ipt=374618e18d6d1ecac967ea70dea6288296a5981d6c712b7c065dd0d9190c233f&ipo=images)

**IEEE802.x** y **ANSI/TIA-xxx**
