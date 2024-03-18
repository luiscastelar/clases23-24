#curso23_24 #PAR [estado::ToDo]



# Tema 6:Configuración y administración de protocolos dinámicos

## Configuración remota (SSH)

```ios
conf t
!
! creamos usuario
username {{USUARIO}} secret 7 {{PASS}}
!
! conf ssh
hostname {{R1}}
ip domain-name {{ASIR1.CASTELAR.ES}}
crypto key generate rsa 2048
ip ssh version 2
line vty 0 4
transport input ssh
password {{PASS}}
login
```

Ahora podremos acceder al equipo por ssh.

```ios
!
! habilitar enable
enable secret {{PASS}}
```

Ahora podremos acceder al equipo y tomar el control del mismo.

## Protocolos enrutables y protocolos de enrutamiento.
Fuente: [Configuración y administración de protocolos dinámicos - Óscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t6_enrutamiento_dinamico/apuntes_t6.html)

## Protocolos de enrutamiento interior y exterior.
Fuente: [cont - Óscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t6_enrutamiento_dinamico/apuntes_t6.html#protocolos-de-enrutamiento-interior-y-exterior)

## El enrutamiento sin clase.
Fuente: [cont - Óscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t6_enrutamiento_dinamico/apuntes_t6.html#el-enrutamiento-sin-clase)

## La subdivisión de redes y el uso de máscaras de longitud variable (VLMs).
Fuente: [cont - Óscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t6_enrutamiento_dinamico/apuntes_t6.html#la-subdivision-de-redes-y-el-uso-de-mascaras-de-longitud-variable-vlsm)

## El protocolo RIPv2

### Configuración y administración de RIPv1.
¿Porqué empezamos por v2 y no por v1? ... porque RIPv1 es un protocolo con clases y por tanto no permite el uso de prefijos de red (CIDR), y por tanto no lo utilizaremos.

### Configuración y administración de RIPv2.
Vector distancia: conteo de los saltos realizados. 

Sólo tiene en cuenta el número de saltos para calcular la ruta más adecuada.

Valor por defecto: 120

#### Uso
```ios
  conf t
    router rip
      version 2
      network 10.0.0.0
      network 172.16.0.0
      network 192.168.10.0
```
*No se pueden añadir máscaras, las deduce de la ip asignada a la interfaz*


#### Otros comandos:
*   `passive-interface <interfaz>` -> por donde **NO propagar** rutas por seguridad y eficiencia
*   `redistribute static` -> ¿debemos propagar rutas estáticas?
*   `ip router 0.0.0.0 0.0.0.0 IP_del_DG` o, en enlaces punto a punto `ip router 0.0.0.0 0.0.0.0 <interfaz>`


#### Ver tabla de rutas:
Ejemplo de tabla:
```ios
Router#sh ip route 
Codes: L - local, C - connected, S - static, R - RIP, M - mobile, B - BGP
       D - EIGRP, EX - EIGRP external, O - OSPF, IA - OSPF inter area
       N1 - OSPF NSSA external type 1, N2 - OSPF NSSA external type 2
       E1 - OSPF external type 1, E2 - OSPF external type 2, E - EGP
       i - IS-IS, L1 - IS-IS level-1, L2 - IS-IS level-2, ia - IS-IS inter area
       * - candidate default, U - per-user static route, o - ODR
       P - periodic downloaded static route

Gateway of last resort is 10.0.0.2 to network 0.0.0.0

     10.0.0.0/8 is variably subnetted, 6 subnets, 2 masks
C       10.0.0.0/30 is directly connected, Serial0/3/0
L       10.0.0.1/32 is directly connected, Serial0/3/0
R       10.0.0.4/30 [120/1] via 10.0.0.10, 00:00:19, Serial0/3/1
C       10.0.0.8/30 is directly connected, Serial0/3/1
L       10.0.0.9/32 is directly connected, Serial0/3/1
R       10.0.0.12/30 [120/1] via 10.0.0.2, 00:00:21, Serial0/3/0
     192.168.0.0/24 is variably subnetted, 2 subnets, 2 masks
C       192.168.0.0/24 is directly connected, GigabitEthernet0/0
L       192.168.0.1/32 is directly connected, GigabitEthernet0/0
R    192.168.1.0/24 [120/2] via 10.0.0.10, 00:00:19, Serial0/3/1
                    [120/2] via 10.0.0.2, 00:00:21, Serial0/3/0
R*   0.0.0.0/0 [120/1] via 10.0.0.2, 00:00:21, Serial0/3/0
```

#### RIPng
```ios
conf t
  ! Habilitamos ipv6
  ipv6 unicast-routing
  !
  ! Habilitamos RIP y le asignamos el nombre del proceso NG.
  ipv6 router rip NG
  !
  ! En cada interfaz que queramos añadir a RIP
  interface Loopback10
  no ip address
  ipv6 address 1111::1/128
  ipv6 rip NG enable
  no shutdown
  !
  interface GigabitEthernet0/0/0
  no ip address
  ipv6 address 2001:DB8::1/64
  ipv6 rip NG enable
  no shutdown
  !
  ! ¿Qué significan los prefijos /128 y /64?
  !
  end
!
! Para verificar
show ipv6 route
show ipv6 route rip
```

Fuente: [RIP para IPv6](https://networklessons.com/ipv6/how-to-configure-ripng-on-cisco-ios-router)


## OSPF - Open Shortest Path First.
> Interior gateway protocols can be split into two main types:
> + Distance Vector routing protocols
> + Link State routing protocols
>
> In Distance Vector protocols, each router sends its directly connected neighbours a list of all its known networks along with its own distance to each of those networks. Distance vector routing protocols do not advertise the entire network topology - a router only knows its directly connected neighbours and the lists of networks those neighbours have advertised. It doesn’t have detailed topology information beyond its directly connected neighbours. Because of this, Distance Vector routing protocols are sometimes called ‘Routing by rumour’.
>
> In Link State routing protocols, each router describes itself and its interfaces to its directly connected neighbours (information is directly exchanged only between directly connected neighbours in both Distance Vector and Link State protocols). This information is passed unchanged from one router to another. Every router learns the full picture of the network area including every router, its interfaces and what they connect to.
>
> Fuente: study-ccna.com

Fuente: 
+ [OSPF - Óscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t6_enrutamiento_dinamico/apuntes_t6.html#configuracion-y-administracion-en-ospf)
+ https://eclassvirtual.com/que-es-un-protocolo-de-enrutamiento-y-como-funciona/
+ https://www.ccnablog.com/ospf-part-1/


#### Config
https://ccnadesdecero.com/curso/como-configurar-ospf/

> For neighbour relationship to work:
> + Interfaces must be up/up
> + ACL must not filter routing protocol messages
> + Interfaces must be in same IP subnet
> + Interfaces must be authenticated, if authentication is used
> + Hello/Dead timers must match
> + RIDs must be unique
> + Interfaces must be in the same area
> + OSPF process must not be shutdown
> + Matching MTU setting
> + Matching network type


### OSPFv3 Adress Families
OSPF para IP versión 6

[Tutorial](https://www.youtube.com/watch?v=AMTMtCVISJY)

### OSPF multiárea
El funcionamiento es igual, pero sectorizaremos por áreas los grupos de routers.

**Tipos de áreas:**
| Área  | 	Restricción |
| --- | --- |
| Normal |	Ninguno |
| Fragmentada | 	No se permiten LSA externos AS de tipo 4 o 5. |
|Totalmente Stub | 	No se permiten LSA de tipo 3, 4 o 5, excepto la ruta de resumen predeterminada. |
|NSSA | 	No se permite ningún LSA externo AS de tipo 5, pero los LSA de tipo 7 que se convierten al tipo 5 en el ABR NSSA pueden atravesar. |
| NSSA totalmente stub | 	No hay ningún LSA de tipo 3, 4 o 5 excepto la ruta de resumen predeterminada, pero se permiten los LSA de tipo 7 que se convierten al tipo 5 en la ABR NSSA. |

Consulte la sección Tipos de Áreas OSPF de Cómo OSPF Genera Rutas Predeterminadas para obtener más información sobre los diferentes tipos de áreas.
Fuente: [Cisco](https://www.cisco.com/c/es_mx/support/docs/ip/open-shortest-path-first-ospf/13703-8.html)

    There are four stub area types:
    *   Stub Area – Filters Type-5 LSAs.
    *   Totally Stubby Area – Filters Type-3 and Type-5 LSAs. These LSAs are summarized into a single Type-3 LSA which is the default route.
    *   Not-So-Stubby Area (NSSA) – Filter Type-5 LSAs. Allows local redistribution in the area. The router doing redistribution in the NSSA area generates LSA Type-7 for the redistributed prefixes. The ABR translates the Type-7 LSA into Type-5 LSA when advertised to the backbone Area.  In NSSA, the ABR does not automatically originate a default route.
    *   Totally-Not-So-Stubby-Area – Like Totally Stubby Area, filters Type-3, Type-4, and Type-5 LSAs and also allows local redistribution. It is, in essence, a combination of the Totally Stubby Area and NSSA.  It also generates Type-7 LSAs for the redistributed prefixes, the ABR translate this Type-7 into Type-5 LSAs when entering the backbone area. In Totally-Not-So-Stubby-Area, the ABR automatically originates the default route.
Fuente: [R&S Journey](https://lpmazariegos.com/2016/02/10/ospf-stub-areas/)

**Tipos de LSAs**
![](https://1.bp.blogspot.com/-iaLVmWJWf6Y/XWFl2665MpI/AAAAAAAAok0/O251beTEmdEYY3vFxpjVSacTlTmlol5kgCLcBGAs/s1600/Captura581.png)Fuente: [libros networking](https://librosnetworking.blogspot.com/2019/08/tipos-de-lsa-en-ospfv2.html)

**Aislamiento parcial**:
Nos centraremos en la configuración *Totally Stubby Area* en la disponemos de una topología de zonas en árbol, que deseamos que todas las zonas tengan salida a internet, pero no recibir resumen de rutas entre áreas. Para ello sólo deberemos añadir `area 10 stub no-summary` a cada router, esto es, el de dentro de la zona y el de borde **ABR**


### links virtuales
Todas las áreas en un sistema autónomo OSPF deben estar físicamente conectadas al área troncal (área 0). En algunos casos donde esta conexión física no es posible, puede usar un link virtual para conectar la estructura básica a través de un área sin estructura básica. Tal como se mencionó anteriormente, también puede utilizar enlaces virtuales para conectar dos partes de una estructura básica particionadas a través de un área de estructura no básica. El área, conocida como área de tránsito, a través de la cual se configura el link virtual debe contar con la información completa de ruteo. La zona de tránsito no puede ser una zona fragmentada.

Use el comando `area area-id virtual-link router-id` para configurar un link virtual, donde *area-id* es el ID de área asignado al área de tránsito (puede ser una dirección IP válida o un valor decimal), y donde router-id es el ID de router asociado con el vecino de link virtual. En este ejemplo, el link virtual conecta el área 7 a la estructura básica por el área 5.

En este ejemplo, se crea un link virtual entre los routers con ID de router 10.1.1.1 y con ID de router 10.2.2.2. Para crear el link virtual, configure el `area 5 virtual-link 2.2.2.2` subcomando en el router 10.1.1.1 y el `area 5 virtual-link 1.1.1.1` en el router 10.2.2.2. Consulte [Configuración de la autenticación OSPF en un enlace virtual](https://www.cisco.com/c/es_mx/support/docs/ip/open-shortest-path-first-ospf/8313-27.html) para obtener más información.
![](https://imgs.search.brave.com/L9o8E9hrGF-rCiVN6P8xhKhfjJlKeUll3VGQAEZCJZQ/rs:fit:500:0:0/g:ce/aHR0cHM6Ly93d3cu/Y2lzY28uY29tL2Mv/ZGFtL2VuL3VzL3N1/cHBvcnQvZG9jcy9p/cC9vcGVuLXNob3J0/ZXN0LXBhdGgtZmly/c3Qtb3NwZi8xMzcw/My04LTAyLmdpZg.jpeg)
Fuente: [Cisco](https://www.cisco.com/c/es_mx/support/docs/ip/open-shortest-path-first-ospf/13703-8.html)


# Enrutamiento externo -> BGP
BGP - Border Gateway Protocol.

iBGP y **eBGP**.

https://ccnadesdecero.es/bgp-border-gateway-protocol/

https://www.cisco.com/c/es_mx/support/docs/ip/border-gateway-protocol-bgp/26634-bgp-toc.html

https://eclassvirtual.com/que-es-un-protocolo-de-enrutamiento-y-como-funciona/


## BGP y OSPF
Uniéndolo todo:
1. En los procesos OSPF debemos activar la redistribución BGP `redistribute bgp 20 subnets` (donde 20 es el número del AS)
2. En los procesos BGP debemos activar la redistribución OSPF `redistribute ospf 1 match internal` (donde 1 es el número del proceso OSPF)

En ocasiones desde BGP querremos redistribuir las redes conectadas, para eso: `redistribute connected`.

Existen formas más complejas de realizarlo, consiguiendo que los routers externos (los conectados por BGP) no obtengan tengan información de las rutas internas. Ver los vídeos [1](https://www.youtube.com/watch?v=7d7IMTEAFLI) y [2](https://www.youtube.com/watch?v=n-AaEOUNPMA).
