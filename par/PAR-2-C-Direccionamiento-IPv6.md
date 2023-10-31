#curso23_24 #PAR [estado::Working]


## Mapa conceptual de la unidad
![mapa conceptual](https://luiscastelar.duckdns.org/2023/assets/PAR/UT2_MapaConceptual.jpg)

# {[Fold: Fold]} Direccionamiento IPv6

## Notación de direcciones IPv6

Se representa en “hextetos”, esto es, en bloques de 4 dígitos hexadecimales, concretamente 8 bloques:  `2001:0db8:85a3:08d3:1319:8a2e:0370:7334`, lo cual hacen 128 bits binarios.

Evidentemente la complejidad para escribir y leer direcciones es exponencial, por lo que se ha implementado métodos de compresión de direcciones.

Se podrán comprimir aquellos bloques que comiencen por un 0. Por ejemplo:\ `2001:0df8:00f2:0000:0000:0000:0000:0f11` \
`2001:df8:f2:0:0:0:0:f11`

Esta primera aproximación mejora la situación, pero se permite además sustituir un único (el más grande) grupo de ceros por `::`, esto es, la dirección anterior quedaría `2001:df8:f2::f11`

Si hubiera más de un grupo de ceros, se cogería el más grande y en caso de iguales, el primero. Esto es, la dirección `2001:0000:0000:0000:0af0:0000:0000:0000` pasaría a ser `2001::0af0:0000:0000:0000`.

Esta regla de compresión y eliminación de ceros (a la izquierda) lleva a direcciones tan pintorescas como `::` o `::1` por ejemplo.

### Longitud del prefijo
`2000::/3` nos indica que sólo debemos atender a los 3 primeros bits de la dirección indicada.

`fe80::/10` es un prefijo típico de red que nos encontraremos en las *link-local*.

El prefijo podrá ir desde 0 hasta 64. **NUNCA (*)** podrá ser mayor, salvo /128

(*) En realidad podremos encontrarlo pero con significados especiales.


*Referencias: [Nociones básicas sobre IPv6](HTTPS://community.cisco.com/t5/blogs-routing-y-switching/direccionamiento-ipv6-bases-y-fundamentos/ba-p/3103703)*

## Autoconfiguración de direcciones libres de estado (SLAAC)

No necesitan DHCPv6 (a priori)

Los nodos IPv6 pueden configurarse a sí mismos automáticamente cuando
son conectados a una red ruteada en IPv6 usando los mensajes de
descubrimiento de routers de ICMPv6. La primera vez que son conectados a
una red, el nodo envía una "solicitud de router" (RS: Router
Solicitation) de link-local usando multicast pidiendo los parámetros de
configuración; y si los routers están configurados para esto,
responderán este requerimiento con un "anuncio de router" (RA: router
advertisement) que contiene los parámetros de configuración de capa de
red.

Si la autoconfiguración de direcciones libres de estado no es adecuada
para una aplicación, es posible utilizar Dynamic Host Configuration
Protocol para IPv6 (DHCPv6) o bien los nodos pueden ser configurados en
forma estática.

+ [Autoconfiguración de IP sin estado](https://www.networkacademy.io/ccna/ipv6/stateless-address-autoconfiguration-slaac)


## Identificación de los tipos de direcciones

Los tipos de direcciones IPv6 pueden identificarse tomando en cuenta los
rangos definidos por los primeros bits de cada dirección.

-   ::/128 -> La dirección con todo ceros se utiliza para indicar la
    ausencia de dirección, y no se asigna ningún nodo.
-   ::1/128 -> La dirección de loopback es una dirección que puede usar
    un nodo para enviarse paquetes a sí mismo (corresponde con 127.0.0.1
    de IPv4). No puede asignarse a ninguna interfaz física.
-   ~~::1.2.3.4/96~~ -> La dirección IPv4 compatible ~~se usa~~ como un
    mecanismo de transición en las redes duales IPv4/IPv6. Es un
    mecanismo que **NO** SE USA.
-   ::ffff:0:0/96 -> La "dirección IPv4 mapeada" se usa como
    mecanismo de transición en terminales duales. Los dos últimos 0\'s
    son los 32 bits de IPv4.
+   **2000::/3** -> global unicast addresses -> dirección global enrutable.
-   **fe80::/10** -> El prefijo de enlace local (link local, en inglés)
    específica que la dirección solamente es válida en el enlace físico
    local (no enrutable).
-   ~~fec0::~~ -> El "prefijo de emplazamiento local" (en inglés,
    site-local prefix) específica que la dirección únicamente es válida
    dentro de una organización local. La RFC 3879 lo declaró
    **obsoleto**, estableciendo que los sistemas futuros no deben
    implementar ningún soporte para este tipo de dirección especial. Se
    deben sustituir por direcciones Local IPv6 Unicast.
-   fc00::/7 -> El prefijo de dirección local universal (en inglés, universal
    local address). Está definido por la RFC 4193. Se usa en
    substitución de las direcciones site-local... sería el equivalente a
    direcciones privadas IPv4 (192.168/24 ó 10/8).
-   ff00::/8 -> El prefijo de multicast. Se usa para las direcciones
    multicast.
-   Hay que resaltar que **NO EXISTEN** las direcciones de difusión (en
    inglés, **BROADCAST**) en IPv6, aunque la funcionalidad que prestan
    _puede emularse_ utilizando la dirección multicast
    FF01::1/128, denominada "todos los nodos" (en inglés, all nodes).


## Subnetting

![](https://luiscastelar.duckdns.org/2023/assets/PAR/ipv6-subnetting-www.ipcisco.com_.jpg)

-   /32 es el prefijo del provedor ISP (los primeros 32 bits identifican
    un proveedor único de internet).
-   Según tipo de cliente, la *recomendación* es:
    -   Comercial:
        -   /48 prefijo de red
        -   Desde /48 a /64 (16 bits) para subredes (65.536 subredes)
    -   Personal:
        -   /56 prefijo de red
        -   Desde /56 a /64 (8 bits) para subredes (256 subredes)
-   Desde /64 (siguientes 64 bits) para HOSTs. SIEMPRE es constante el
    número de HOSTs.

(*) La longitud de los prefijos de red son recomendados no
obligatorios. El ISP **NUNCA** debería aplicar una /64 como prefijo de red.


## Máscaras de red especiales
  ------ --------------------- ---------------------------------------------
  /128   1 IPv6 address        A network interface
  /64    1 IPv6 subnet         18,446,744,073,709,551,616 IPv6 addresses
  /56    256 LAN segments      Popular prefix size for one subscriber site
  /48    65,536 LAN segments   Popular prefix size for one subscriber site



## Diferencias IPv4 - IPv6
https://www.networkacademy.io/ccna/ipv6/ipv4-vs-ipv6
