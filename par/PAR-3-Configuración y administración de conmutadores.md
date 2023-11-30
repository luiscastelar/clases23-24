#curso23_24 #PAR [estado::ToDo]



# {[Fold: Fold]} Dispositivos de interconexión de redes.

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





# {[Fold: Fold]} ARP y NDP

## ARP

+ [Explicación del protocolo ARP](https://youtu.be/Z9cS22l38-U?t=120) o [Funcionamiento - YT:ProfeSantiago](https://youtu.be/NemUKjAsVY4?si=KE9WH2NCyzd-X_dJ&t=224)

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

Ver funcionamiento en packet tracer:

<details>

        Parte 1: Red local de descubrimiento de vecinos IPv6
    
        En la Parte 1 de esta actividad, obtendrá la dirección MAC de un dispositivo de destino en la misma red.
        Paso 1: Compruebe el router para ver si hay algún vecino que haya descubierto.
    
        a. Haga clic en el Router RTA. Seleccione la pestaña CLI y ejecute el comando show ipv6 neighbors desde el modo ejecutivo privilegiado. Si se muestran entradas, elimínelas con el comando clear ipv6 neighbors.
    
        b. Haga clic en PCA1, seleccione la pestaña Escritorio y haga clic en el icono Símbolo del sistema.
        Paso 2: Cambie al modo de simulación para capturar eventos.
    
        c. Haga clic en el botón de Simulación en la esquina inferior derecha de la ventana Topología de Packet Tracer.
    
        d. Haga clic en el botón de Mostrar todo/Ninguno en la parte inferior izquierda del panel de Simulación. Hacer ciertos Filtros de lista de eventos – Eventos visibles muestran Ningunos.
    
        e. Desde el símbolo del sistema en PCA1, ejecute el comando ping —n 1 2001:db8:acad:1: :b. Esto iniciará el proceso de hacer ping PCA2.
    
        f. Haga clic en el botón Reproducir captura hacia delante , que se muestra como una flecha que apunta a la derecha con una barra vertical dentro del cuadro Controles de reproducción. La barra de estado sobre los controles de reproducción debería leer Capturada a 150. (El número exacto puede variar).
    
        g. Haga clic en el botón Editar filtros. Seleccione la pestaña IPv6 en la parte superior y marque las casillas para ICMPv6 y NDP . Haga clic en la X roja en la parte superior derecha de la ventana Editar filtros ACL. Los eventos capturados ahora deberían estar listados. Debe tener aproximadamente 12 entradas en la ventana.
    
        ¿Por qué están presentes PDU ND?
        Para enviar paquetes ping ICMPv6 a PCA2, PCA1 necesita conocer la dirección MAC del destino. IPv6 ND solicita esta información en la red.
    
        h. Haga clic en el cuadrado de la columna Tipo para el primer evento, que debería ser ICMPv6.
    
        Debido a que el mensaje comienza con este evento, solo hay una PDU de salida. Debajo de la pestaña Modelo OSI, ¿cuál es el tipo de mensaje listado para ICMPv6?
        Tipo de mensaje de eco ICMPv6: 128
    
        Observe que no hay direccionamiento de capa 2. Haga clic en el botón Next Layer >> para obtener una explicación sobre el proceso ND (Neighbor Discovery).
    
        i. Haga clic en el cuadrado situado junto al siguiente evento en el Panel de simulación. Debe estar en el dispositivo PCA1 y el tipo debe ser NDP.
    
        ¿Qué cambió en el direccionamiento de Capa 3?
        La dirección de destino ahora es una dirección de multidifusión IPv6 de FF02: :1:FF00:B
    
        ¿Qué direcciones de capa 2 se muestran?
        La dirección de origen es PCA1 MAC – 0001.427E.E8ED y la dirección de destino MAC es 3333.FF00.000B
    
        Cuando un host no conoce la dirección MAC del destino, la detacción de vecinos IPv6 utiliza una dirección MAC de multidifusión especial como la dirección de destino de la capa 2.
    
        j. Seleccione el primer evento NDP en el SwitchA.
    
        ¿Hay alguna diferencia entre las capas de entrada y salida para la capa 2?
        No. El interruptor no altera la información de la capa 2, solo reenvía la trama.
    
        k. Seleccione el primer evento NDP en PCA2 . Haga clic en la ficha de Detalles de la PDU saliente.
    
        ¿Qué direcciones se muestran para lo siguiente?
    
        Nota: Las direcciones en los campos pueden estar ajustadas, ajuste el tamaño de la ventana de la PDU para que la información de la dirección sea más fácil de leer.
    
        Ethernet II DEST ADDR:
        0001.427E.E8ED
    
        Ethernet II SRC ADDR:
        0040.0B02:.243E
    
        IPv6 SRC IP:
        2001:db8:acad:1::b
    
        IP de horario de verano de IPv6:
        2001:db8:acad:1::a
    
        l. Seleccione el primer evento NDP en RTA . ¿Por qué no hay capas de salida?
        La dirección IPv6 no coincide con la dirección del enrutador, por lo que descarta el paquete.
    
        m. Haga clic en el botón Next Layer >> (siguiente capa) hasta el final y lea los pasos del 4 hasta el 7 para obtener más información.
    
        n. Haga clic en el siguiente evento ICMPv6 en PCA1 .
    
        ¿PCA1 ahora tiene toda la información necesaria para comunicarse con PCA2?Sí, ahora conoce tanto la dirección IPv6 de destino como la dirección MAC de destino de PCA2.
    
        o. Haga clic en el último evento ICMPv6 en PCA1 . Observe que esta es la última comunicación listada.
    
        ¿Cuál es el tipo de mensaje de eco ICMPv6?
        El tipo de mensaje de eco ICMPv6 es 129, una respuesta de eco.
    
        p. Haga clic en Reset Simulation (Restablecer simulación) en el panel de simulación. Desde el símbolo del sistema de PCA1, repita el ping a PCA2. (Sugerencia: debería poder presionar la flecha hacia arriba para devolver el comando anterior.)
    
        q. Haga clic en el botón Capture Forward 5 veces para completar el proceso de ping.
    
        ¿Por qué no hubo ningún evento de NDP?
        PCA1 ya conoce la dirección MAC de PCA2, por lo que no necesita usar Detección de Vecinos.
        Parte 2: Red remota de Detección de Vecinos IPv6
    
        En la Parte 2 de esta actividad, realizará pasos similares a los de la Parte 1, excepto en este caso, el host de destino está en otra LAN. Observe cómo el proceso de Detección de Vecinos difiere del proceso observado en la Parte 1. Preste mucha atención a algunos de los pasos de direccionamiento adicionales que tienen lugar cuando un dispositivo se comunica con un dispositivo que está en una red diferente.
    
        Asegúrese de hacer clic en el botón Reset Simulation (Restablecer simulación) para borrar los eventos anteriores.
        Paso 1: Capturar eventos para comunicación remota.
    
        a. Mostrar y borrar las entradas de la tabla de dispositivos vecinos IPv6 como se hizo en la parte I.
    
        b. Cambiar al modo de simulación. Haga clic en el botón de Show All/None (Mostrar todo/Ninguno) en la parte inferior izquierda del panel de Simulación. Asegúrese de que Filtros de lista de eventos — Eventos visibles muestra
    
        c. Desde el símbolo del sistema en PCA1, ejecute el comando ping —n 1 2001:db8:acad:2: :a para hacer ping al host PCB1.
    
        d. Haga clic en el botón Play Capture Forward
        , que se muestra como una flecha que apunta a la derecha con una barra vertical dentro del cuadro Controles de reproducción. La barra de estado sobre los controles de reproducción debería leer Capturada a 150. (El número exacto puede variar).
    
        e. Haga clic en el botón Edit Filters (Editar filtros). Seleccione la pestaña IPv6 en la parte superior y marque las casillas para ICMPv6 y NDP . Haga clic en la X roja en la parte superior derecha de la ventana Editar filtros ACL. Todos los eventos anteriores deben aparecer ahora en la lista. Debe notar que hay muchas más entradas listadas esta vez.
    
        f. Haga clic en el cuadrado de la columna «Tipo» para el primer evento, que debería ser ICMPv6. Dado que el mensaje comienza con este evento, sólo hay una PDU saliente. Observe que le falta la información de Capa 2 como en el escenario anterior.
    
        g. Haga clic en el primer evento NDP en el dispositivo PCA1 .
    
        ¿Qué dirección se utiliza para la IP Src en la PDU entrante?
        La dirección local del enlace para PCA1 — fe80:: 201:42 ff:fe7e:e8ed
    
        La detección de vecinos IPv6 determinará el próximo destino para reenviar el mensaje ICMPv6.
    
        h. Haga clic en el segundo evento ICMPv6 para PCA1. PCA1 ahora tiene suficiente información para crear una solicitud de eco ICMPv6.
    
        ¿Qué dirección MAC se utiliza para el MAC de destino?
        0001.961d.6301, la dirección MAC de G0/0/0 de RTA
    
        i. Haga clic en el siguiente evento ICMPv6 en el dispositivo RTA. Observe que la PDU saliente de RTA carece de la dirección de capa 2 de destino. Esto significa que RTA tiene que realizar de nuevo una detección de vecinos para la interfaz que tiene la red 2001:db8:acad:2:: porque no conoce las direcciones MAC de los dispositivos en la LAN G0/0/1.
    
        j. Vaya al primer evento ICMPv6 para el dispositivo PCB1.
    
        ¿Qué falta en la información saliente de Capa 2?
        La dirección MAC de destino debe determinarse para la dirección de destino IPv6.
    
        k. Los siguientes eventos NDP están asociando las direcciones IPv6 restantes hacia las direcciones MAC. Los eventos NDP anteriores asociaron direcciones MAC con direcciones locales de enlace.
    
        l. Vaya al último conjunto de eventos ICMPv6 y observe que todas las direcciones han sido aprendidas. Ahora se conoce la información requerida, por lo que PCB1 puede enviar mensajes de respuesta de eco a PCA1.
    
        m. Haga clic en el botón Reset Simulation (Restablecer simulación) en el Panel de simulación. Desde el símbolo del sistema de PCA1, repita el comando para hacer ping a PCB1.
    
        n. Haga clic en el botón Capture Forward nueve veces para completar el proceso de ping.
    
        ¿Hubo algún evento de NDP?
        No.
    
        o. Haga clic en el único evento PCB1 en la nueva lista.
    
        ¿A qué corresponde la dirección MAC de destino?
        La interfaz del router G0/0/1 en RTA
    
        ¿Por qué PCB1 utiliza la dirección MAC de la interfaz del router para crear sus PDU ICMP?
        Dado que el dispositivo de destino está en otra red, PCB1 dirige la PDU a la interfaz de puerta de enlace predeterminada MAC. RTA determinará cómo abordar la PDU en la Capa 2 para enviarla a su destino.
        Paso 2: Examine las salidas del router.
    
        a. Vuelva al modo Realtime.
    
        b. Haga clic en RTA y seleccione la pestaña CLI. En la consola del router, ingrese el comando show ipv6 neighbors.
    
        ¿Cuántas direcciones aparecen en la lista?
        4 — Unidifusión global IPv6 y enlace direcciones locales y direcciones MAC para PCA1 y PCB1
    
        ¿Con qué dispositivos están asociadas estas direcciones?
        PCA1 y PCB1
    
        ¿Hay alguna entrada para PCA2 en la lista (por qué o por qué no)?
        PCA2 aún no se ha comunicado a través de la red.
    
        c. Ping PCA2 desde el router.
    
        d. Emita el comando show ipv6 neighbors.
    
        ¿Hay entradas para PCA2?
        Sí, la dirección IPv6 y la dirección MAC para PCA2.
        Preguntas de reflexión
    
        1. ¿Cuándo un dispositivo requiere el proceso de detección de vecinos IPv6?
        Cuando no se conoce la dirección MAC de destino. Este proceso es similar a ARP con IPv4.
    
        2. ¿Cómo ayuda un router a minimizar la cantidad de tráfico de detección de vecinos IPv6 en una red?
        El router mantiene las tablas vecinas para que no tenga que iniciar ND para cada host de destino.
    
        3. ¿Cómo minimiza IPv6 el impacto del proceso ND en los hosts de red?
        Utiliza una dirección de multidifusión para que sólo un puñado de direcciones estén escuchando los mensajes de detección de vecinos. IPv6 crea una dirección MAC de destino de multidifusión especialmente diseñada que incluye una parte de la dirección del nodo.
    
        4. ¿En qué difiere el proceso de detección de vecinos cuando un host de destino está en la misma LAN y cuando está en una LAN remota?
        Cuando un host de destino está en el mismo segmento LAN, solo responde el dispositivo que coincide con la dirección IPv6 y los otros dispositivos descartan el paquete. Cuando el dispositivo es remoto, el dispositivo de puerta de enlace (normalmente un router) proporciona la dirección MAC de la interfaz en la interfaz local para el MAC de destino y, a continuación, busca la dirección MAC en la red remota. A continuación, el router colocará el par de direcciones IPv6/Mac que responde en la tabla de vecinos IPv6. (similar a una solicitud de ARP en IPv4)

**Fuente**: [ccna en español](https://examenredes.com/9-3-4-packet-tracer-deteccion-de-vecinos-ipv6-respuestas/)

</details>

En concreto, miraremos la dirección MAC del mensaje NDP que no conoce la destino, pero en esta ocasión no utiliza la dirección de difusión, si no que utiliza los 32 bits menos significativos de la dirección IPv6 (los 2 últimos hextetos) con el prefijo **33:33**. 

En concreto, partiendo de la dirección capa 3 destino FE80::2D0:D3FF:*FE79:4634*, la MAC utilizada para el destino será **33:33**:*FE:79:46:34*.

Más info sobre [multidifusión](https://en.wikipedia.org/wiki/Multicast_address#Ethernet).





# {[Fold: Fold]} Segmentación de la red. Ventajas que presenta.

## Conmutadores y dominios de colisión y “broadcast”.

Primero tenemos que ver los dominios para apreciar el problema y buscar una solución:

+ [Dominios, segmentos y broadcast](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#dominios)

Vamos a replicar en `packet tracer` la figura siguiente y verificar la problemática de broadcast: \
![segmentos](https://planificacionadministracionredes.readthedocs.io/es/latest/_images/tema06-116.png)

**Nota:** *Las líneas que comunican equipos deberán ser implementadas mediante un concentrador (hub)*.



## Segmentación de redes.

### En capa 2:

**Reduciendo dominios de colisión:**  realizaremos un cambio de los `hub` por `switch`.

### En capa 3:

+ **Reduciendo dominios de difusión:**  realizaremos un cambio del `switch` central por un `router` y ver que pasa.

+ **Organizando subredes**: partiendo de un esquema similar al presentado en clase, 9 equipos unidos por un `switich`, queremos partir en equipos de trabajo de 3 alumnos cada equipo. \
  
  Partiendo de la red 192.168.1/24, separa los equipos en subredes mínimas que permitan aislar a cada equipo.\
  
  1. Deberemos determinar el CIDR necesario para cubrir las necesidades de todos los equipos y obtener la dirección de subred adecuada para cada uno de los equipos.
  
  2. Deberemos asignar a cada equipo una ip de la subred que define al equipo.
  
  3. Deberemos realizar pruebas de conexión entre dispositivos del mismo equipo y entre dispositivos de equipos diferentes.



¿Qué ocurre si un usuario malicioso utiliza **wireshark?**



# Formas de conexión al conmutador para su configuración.

Cada equipo de red tiene software según el fabricante a través de WEB, APP propia o TELNET (muy obsoleto), pero todos los dispositivos suelen llevar **SSH**.

El motivo por el que todos los dispositivos gestionables son configurables por SSH es porque la misma se puede realizar desde cualquier parte del mundo (LAN o WAN) y sobre dispositivos con interfaz gráfica y sin ella.

+ [funcionamiento Cisco-C880](https://github.com/luiscastelar/clases23-24/blob/main/par/Cisco-C880.md)
+ [descripción](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#puertos)

## Configuración del conmutador.

+ [IOS Cisco](https://oscarmaestre.github.io/apuntes_redes/t3_conmutadores/apuntes_t3.html#configuracion-del-conmutador)
+ [Auto-MDIX](https://www.cisco.com/c/en/us/td/docs/switches/lan/catalyst9300/software/release/16-10/configuration_guide/int_hw/b_1610_int_and_hw_9300_cg/configuring_auto_mdix.pdf): protocolo que permite la interconexión de `switch`es utilizando cables directos o cruzados indistintamente.

## Configuración estática y dinámica de la tabla de direcciones MAC.

Como hemos visto la tabla ARP puede “aprenderse” de forma dinámica o también podremos añadir o eliminar entradas de forma manual:

+ En [CISCO IOS](https://www.cisco.com/c/en/us/td/docs/ios-xml/ios/ipaddr_arp/configuration/15-mt/arp-15-mt-book/arp-config-arp.html#GUID-C88E1ED1-4D42-41E3-85CC-0635857C1F6A)

+ En GNU/Linux:
  
  ```bash
  - Show the current ARP table:
   arp -a
  
  - Delete a specific entry:
   arp -d {{address}}
  
  - Create an entry in the ARP table:
   arp -s {{address}} {{mac_address}}
  ```

+ En Windows sustituiremos los “-” por “/“

# STP - Protocolo Spanning Tree.

+ [Qué es y para qué sirve STP - CCNA desde Cero](https://ccnadesdecero.com/curso/stp/)
+ [STP - PAR.readthedocs.io](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#stp)
+ [Qué es STP - YT:Kalerolinex](https://www.youtube.com/watch?v=bZGLcdRZYXs&pp=ygUDc3Rw)
+ [Cómo trabaja STP - Kalero](https://www.youtube.com/watch?v=6208ZC7avhE)

# El diseño de redes locales a tres capas (núcleo, distribución y acceso).

+ [redes por capas](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema06/Teoria.html#distribucion)

# Implantación y configuración de redes virtuales.

+ [Teoría VLANs - PAR.readthedocs.io](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema09/Teoria.html)
+ [Teoría + ejercicios - JM Huertas](https://juanmhalegre.wordpress.com/2012/01/08/ccnp-switch-642-813-official-certification-guide-part-ii-chapter-4-1-virtual-vlans/)
+ [Troncales - JM Huertas](https://juanmhalegre.wordpress.com/2012/01/12/ccnp-switch-642-813-official-certification-guide-part-ii-chapter-4-2-vlan-trunks/)
+ [Otro de teoría - wikibooks](https://es.wikibooks.org/wiki/Planificaci%C3%B3n_y_Administraci%C3%B3n_de_Redes/Tema_9/Texto_completo)
+ [Configuración de VLANs en CISCO](https://oscarmaestre.github.io/apuntes_redes/t5_vlans/apuntes_t5.html)
+ [VLAN - CCNA desde Cero](https://ccnadesdecero.com/curso/vlan/)  

# Definición de enlaces troncales en los conmutadores y “routers”. El protocolo IEEE802.1Q.

## Calidad de servicio (QoS - IEEE802.1P)

Priorización de tráfico de control, voz y vídeo (entre otros).

+ [Wikipedia](https://es.wikipedia.org/wiki/IEEE_802.1p)

## VLANs de provedores (Q en Q - IEEE802.1ad)

Juntos pero no revueltos... o cuando un proveedor de internet mueve nuestro tráfico y claro, él usa una VLANs para cada cliente y nosotros una para cada departamento.

+ [Wikipedia](https://en.wikipedia.org/wiki/IEEE_802.1ad)


# Switching & bridging en GNU/Linux
+ [bridge](https://www.ithands-on.com/2020/12/networking-101-linux-tap-interface-and.html)


# Diagnóstico de incidencias.

+ [Diagnóstico - ProgamoWeb.com]