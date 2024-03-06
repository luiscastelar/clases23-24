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
RIP para IPv6


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


#### OSPFv3 Adress Families
OSPF para IP versión 6

# Enrutamiento externo -> BGP
BGP - Border Gateway Protocol.

iBGP y **eBGP**.

https://ccnadesdecero.es/bgp-border-gateway-protocol/

https://www.cisco.com/c/es_mx/support/docs/ip/border-gateway-protocol-bgp/26634-bgp-toc.html

https://eclassvirtual.com/que-es-un-protocolo-de-enrutamiento-y-como-funciona/