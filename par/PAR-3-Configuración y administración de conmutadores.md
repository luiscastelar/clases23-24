#curso23_24 #PAR [estado::ToDo]


# Dispositivos de interconexión de redes.

Como ya hemos comentado, dada la flexibilidad aportada, la topología en
estrella se ha impuesto ampliamente en las redes cableadas, por lo que
para el conexionado de los distintos HOST, que llegan a través del
subsistema horizontal, se realizará por alguno de los equipos que
pasamos a describir.

### Simbología de red: hub, switch, bridge y router.

![](https://luiscastelar.duckdns.org/2023/assets/PAR/simbolos_de_red.jpeg)

> Nota: la simbología tiene origen en la empresa CISCO, pero es
> ampliamente utilizada y se toma como estándar de facto.


### HUB (capa 1)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/pila-hub-pila.png)

Unen físicamente (capa 1) en estrella los HOST de una red.

Sólo adaptan los niveles eléctricos. Las tramas son difundidas por todos
sus puertos.

*También funcionan así los `repetidores`. Son un caso especial de HUB con sólo 2 puertos.*


### SWITCH (capa 2)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/pila-switch-pila.png)

Unen en estrella los HOST de una red analizando las tramas (dir MAC) de
forma que sólo transmiten las tramas por aquella "boca" que coincide
con la MAC destino, salvo que no la tenga aún en su tabla de
enrutamiento.

Existen 2 tipos de SWITCH: gestionables y no gestionables. Mientras que los primeros permiten la gestión de paquetes de capa 2, los segundos únicamente reenvían los paquetes por los puertos adecuados.

> **Nota**: Existen switch de capa 3 que proporcionan ciertos servicios
> de dicha capa.

Todos los SWITCHs tienen una tabla de direccionamiento MAC para vincular puertos con direcciones correspondientes.

![arp](https://luiscastelar.duckdns.org/2023/assets/PAR/UT3/arp.jpg)
### ROUTER (capa 3)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/pila-router-pila.png)

Unen de forma lógica 2 o más redes, iguales o distintas, modificando los
paquetes para adaptar direcciones IP del rango correcto para cada red.

### BRIDGE (capa 3)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/EjemploBridgesPuenteRemoto.jpeg)

Un bridge o un puente opera en la capa de enlace de datos. Es un repetidor con funcionalidad adicional de filtrado al leer las direcciones MAC de origen y destino. También se usa para interconectar dos LAN que funcionan en el mismo protocolo. Tiene un puerto de entrada y salida único, lo que lo convierte en un dispositivo de 2 puertos.



# ARP y NDP

## ARP

[Explicación del protocolo ARP](https://youtu.be/Z9cS22l38-U?t=120) o [Funcionamiento - YT:ProfeSantiago](https://youtu.be/NemUKjAsVY4?si=KE9WH2NCyzd-X_dJ&t=224)

Formato de la capa 3 del protocolo ARP:
![protocolo arp](https://forum.huawei.com/enterprise/api/file/v1/small/thread/667214380544167936.png?appid=esc_es)
Recuerda que en la capa 2:
+ la petición será con orígen MAC del Switch A y destino de broadcast (FF:FF:FF:FF:FF:FF).
+ la respuesta será con orígen MAC del Switch C y destino del Switch A.


```bash
profesor@servidor ~ :/$sudo arp | grep -v incomplete
Address                  HWtype  HWaddress           Flags Mask            Iface
192.168.10.202           ether   23:f2:c7:da:53:80   C                     ztr-xxxxx
www.wifilowi.es          ether   71:92:cd:40:5f:61   C                     wlan0
192.168.0.44             ether   71:14:df:99:76:c9   C                     wlan0
172.19.0.2               ether   f2:83:ae:11:85:c9   C                     br-xxxxxx
```

Descripción del comando `usr@maquina ~ :/$ arp -n`

> Nota: descripción `usr@maquina:~$ arp -a` \
> usr: nombre de usuario del sistema \
> @: significa en (at en ingles) \
> maquina: nombre de la máquina \
> ~ : directorio actual... y más concretamente la tilde ' ~ ' indica que nos encontramos en el HOME del sistema (directorio de usuario). Puede escribirse con `Alt Gr + ñ` o `Alt Gr + 4`
> $: indica que los comando se ejecutarán sin privilegios. Si apareciera la almohadilla '#' estaríamos ejecutando con privilegios de `root` (administrador).


## NDP
~~Tarea: sabiendo que el funcionamiento es similar al ARP, que no tenemos Broadcast y que se realiza mediante grupos ... explica que hace y como lo hace.~~
+ [Explicación detallada](https://www.omnisecu.com/tcpip/ipv6/ndp-neighbour-discovery-protocol-functions-of-ndp.php?expand_article=1)
+ [Explicación sencilla](https://ipcisco.com/lesson/ipv6-ndp-neighbour-discovery-protocol/)



# Segmentación de la red. Ventajas que presenta.


## Conmutadores y dominios de colisión y “broadcast”.
Primero tenemos que ver los dominios para apreciar el problema y buscar una solución:
+ [Dominios, segmentos y broadcast](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#dominios)

Vamos a replicar en `packet tracer` la figura siguiente y verificar la problemática de broadcast: \
![segmentos](https://planificacionadministracionredes.readthedocs.io/es/latest/_images/tema06-116.png)

## Segmentación de redes.
1. Cambiar los `hub` por `switch` y ver que pasa.
2. Cambiar el `switch` central por un `router` y ver que pasa.


# Formas de conexión al conmutador para su configuración.
Cada equipo de red tiene software según el fabricante a través de WEB, APP propia o TELNET (muy obsoleto), pero todos los dispositivos suelen llevar **SSH**.

El motivo por el que todos los dispositivos gestionables son configurables por SSH es porque la misma se puede realizar desde cualquier parte del mundo (LAN o WAN) y sobre dispositivos con interfaz gráfica y sin ella.
+ [[pub23/par/Cisco-C880|funcionamiento Cisco-C880]]
+ [descripción](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#puertos)

## Configuración del conmutador.
[IOS Cisco](https://oscarmaestre.github.io/apuntes_redes/t3_conmutadores/apuntes_t3.html#configuracion-del-conmutador)


## Configuración estática y dinámica de la tabla de direcciones MAC.


# STP - Protocolo Spanning Tree.
+ [STP](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#stp)


# El diseño de redes locales a tres capas (núcleo, distribución y acceso).
+ [redes por capas](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#distribucion)


# Implantación y configuración de redes virtuales.


# Definición de enlaces troncales en los conmutadores y “routers”. El protocolo IEEE802.1Q.
# Diagnóstico de incidencias.