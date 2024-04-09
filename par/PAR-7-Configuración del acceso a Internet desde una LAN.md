#curso23_24 #PAR [estado::ToDo]


# Conexión de un equipo a INTERNET

+ [x] [DHCP](https://github.com/luiscastelar/clases23-24/blob/main/par/PAR-5-Configuraci%C3%B3n%20y%20administraci%C3%B3n%20de%20routers.md) {UT5}
+ [x] [ARP](https://github.com/luiscastelar/clases23-24/blob/main/par/PAR-3-Configuraci%C3%B3n%20y%20administraci%C3%B3n%20de%20conmutadores.md#arp) y [NDP](https://github.com/luiscastelar/clases23-24/blob/main/par/PAR-3-Configuraci%C3%B3n%20y%20administraci%C3%B3n%20de%20conmutadores.md#ndp) {UT3}
+ [x] DNS
+ [ ] NAT (estático, dinámico y sobrecargado)
+ [ ] ACL Extendidas y Reflexivas
+ [ ] Sin cables -> Wifi y Wimax
+ [ ] PPPoE
+ [ ] SDN (Redes Definidas por Software)
+ [ ] Otras tecnologías (Frame Relay, RDSI, ADSL, UMTS, HSDPA)
  
## Breve inciso sobre DNS
[wikipedia](https://es.wikipedia.org/wiki/Sistema_de_nombres_de_dominio)

![recursivo](https://cf-assets.www.cloudflare.com/slt3lc6tev37/3NOmAzkfPG8FTA8zLc7Li8/8efda230b212c0de2d3bbcb408507b1e/dns_record_request_sequence_recursive_resolver.png)![Definición de DNS - Significado y definición de DNS](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%3Fid%3DOIP.NSYza4PayfcZJA5w1-IImwHaDy%26pid%3DApi&f=1&ipt=d35e57f3b7ad14fdf7d72e9f11d50344bf34d9f41c3ccda948847babbd732bef&ipo=images)

## NAT
Tipos de NAT:
+ NAT estático: IP pública a IP privada (1 a 1).
+ NAT dinámico: IPs públicas a IPs privadas (N a M).
+ NAT sobrecargado o **PAT** (port address translate): 1 IP pública a N IPs privadas.

*Referencias*: [ccna desde cero](https://ccnadesdecero.es/nat-tipos-ventajas-desventajas/)

### Los routers en las LAN y en las WAN.

En las redes LAN el router toma decisiones sencillas. En líneas
generales solo deciden "¿se envía este paquete al otro lado o no?".

En redes WAN, los routers tienen conexión con muchas otras redes. Al
tener muchas redes, estos routers tienen que "intentar averiguar todas
las conexiones y decidir cuales son los mejores caminos".


### El proceso de NAT paso a paso
**AVISO:** la conexión entre los routers de todas las imágenes siguientes deberían reflejar que es realizada mediante la conexión pública a través de internet (una "nubecita"). **NO** existe conexión directa entre ambos routers, aunque podemos representarlo simbólicamente así.

Paso 1: un usuario quiere iniciar una conexión y conectarse a un
servidor en otro lugar remoto.

![1](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat01.png)

Paso 2: el usuario pide al servidor la IP pública de su router y usando
su programa intenta conectarse a la IP pública del otro router y al
puerto del juego o servicio. El puerto de origen se elige al azar.

![2](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat02.png)Paso 3: el paquete llega al router. El router observa que el paquete va
al exterior. Como no se pueden usar IPs privadas en el exterior, el
router **CAMBIA LA IP DE ORIGEN Y TOMA NOTA DE ESA TRADUCCIÓN POR SI EN
EL FUTURO SE NECESITA ESA INFORMACIÓN**.

![3](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat03.png)

Paso 4: el paquete (con la IP de origen cambiada) viaja por la red y
llega al router de destino. Como los router **por defecto no aceptan
conexiones entrantes, en principio el paquete no entraría** Es necesario
que primero el router derecho tenga *el puerto 6003 abierto.* Abrir un
puerto consiste en poner una regla que indique que si llega una conexión
entrante iniciada en el exterior se va a dejar pasar enviando el paquete
a una cierta IP.

![4](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat04.png)
Paso 5: si hubiera la regla correcta,el paquete entrará pero con la IP
de destino modificada.

![5](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat05.png)
Paso 6: el paquete que intentaba iniciar la conexión **llega
correctamente a su destino**.

![6](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat06.png)

Paso 7: el servidor va a responder y genera un paquete de respuesta.

![7](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat07.png)Paso 8: el paquete llega al router **que vuelve a modificar la IP de
origen porque no se aceptan IPs privadas en Internet.** Por supuesto, el
router vuelve a apuntar esa traducción.

![8](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat08.png)

Paso 9: el paquete intenta entrar. Lo primero que podríamos pensar es
que el paquete no entrará, sin embargo **SÍ VA A CONSEGUIR ENTRAR**

![9](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat09.png)

Paso 10: el router observa que el paquete **coincide perfectamente** con
la información de una traducción que se hizo en el pasado. Es decir **el
paquete puede pasar**. De nuevo, se vuelve a cambiar la IP de destino y
el paquete se inyecta en la red izquierda.

![10](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat10.png)

Paso 10b: se modifica la IP y se envía al interior.

![10b](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat11.png)

Paso 11: el paquete **llega a su destino**

![12](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/nat12.png)


### Activar NAT en un router

![NAT](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/NAT.png)

En los router de gama alta, hay que dar varios pasos:

En primer lugar hay que identificar qué tarjeta va conectada a la red
interna y qué tarjeta va a la red externa.

- La tarjeta interna (*Gi0/3/0*) debe recibir el comando `ip nat inside`.
- La tarjeta externa (*Gi0/2/0*) el comando `ip nat outside`.
- Si tenemos *subinterfaces*, se deben definir los `ip nat` en los
  subinterfaces correspondientes (probablemente en todos)

En segundo lugar hay que crear una lista de control de acceso que
permita la entrada de tráfico en el router cuando el tráfico provenga de
la red interna. Si suponemos que nuestra red es algo como
`10.9.0.0/255.255.0.0` tendremos que lanzar esto:

    access-list 100 permit ip 10.9.0.0 0.0.255.255 any

*Nota: hemos cogido la primera de las ACL-EXTENDED. Si ésta coincide pasará.*

En tercer lugar hay que indicar al router que haga la sobrecarga de
puertos indicándole la interfaz en la que se va a hacer la sobrecarga.
Si por ejemplo, la tarjeta de salida de un router es la `GigabitEthernet 0/1` pondremos esto:
```ios
    ip nat pool EXTERNA 80.0.1.1 80.0.1.1 netmask 255.255.255.252
    ip nat inside source list 100 pool EXTERNA overload
```

Una vez dados estos tres pasos, el router comenzará a modificar las IP
de origen.

Petición de PC0 a Internet:
![Petición](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/NAT-peticion.png)
Respuesta desde Internet a PC0:
![Petición](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/NAT-respuesta.png)


> **Note**: En realidad, técnicamente lo que se realiza no es NAT sino **PAT** o
> Port Address Translation. Cisco llama "overload" a este proceso de "traducción de puertos".

**Fuentes**:
+ [NAT - Cisco.com](https://www.cisco.com/c/en/us/support/docs/ip/network-address-translation-nat/13772-12.html)


# ACL Extendidas y ACL Reflexivas
+  [CCNA desde Cero](https://ccnadesdecero.es/configurar-acl-extendidas/)
+  [CISCO](https://www.cisco.com/c/es_mx/support/docs/security/ios-firewall/23602-confaccesslists.html)


# Conversión IPv6 a IPv4 y viceversa
### Túnel 6to4:
[Túneles automáticos](https://community.cisco.com/t5/blogs-general/t%C3%BAneles-autom%C3%A1ticos-6to4/ba-p/4822594)

### NAT64 y NAT46:
+ [NAT64 y NAT46](https://www.cisco.com/c/es_mx/support/docs/ip/network-address-translation-nat/217208-understanding-nat64-and-its-configuratio.html)
+ [Túnel 6-4-6](https://pseudoco.cisco.com/c/es_mx/support/docs/ip/ip-version-6/25156-ipv6tunnel.pdf)
+ [otro 6-4-6](https://community.cisco.com/kxiwq67737/attachments/kxiwq67737/5551-docs-routing-and-switching/2/1/52470-Tuneles%20Automaticos%20para%20IPv6.pdf)

+ [NAT64 en vídeo](https://www.youtube.com/watch?v=baXd9oDibAk)


# PPPoE
https://learningnetwork.cisco.com/s/article/pppoe-concepts-amp-configuration
https://ccnadesdecero.es/pppoe-definicion-y-configuracion/


# SDN - Redes Definidas por Software
[Introduction to Linux interfaces for virtual networking](https://developers.redhat.com/blog/2018/10/22/introduction-to-linux-interfaces-for-virtual-networking#netdevsim_interface)


# Wifi y Wimax
## Wifi
[Wifi](https://es.wikipedia.org/wiki/Wifi) es el nombre comercial del estándar [IEEE 802.11](https://es.wikipedia.org/wiki/IEEE_802.11), esto es, WLAN (Wireless LAN)

Existen muchos apellidos al estándar (802.11b, 802.11g, 802.11n ...) con distintas capacidades, pero desde 2015 tenemos una nomenclatura por números que es bastante más intuitiva Wifi-5 (802.11ac), Wifi-6 (802.11ax), Wi-Fi 7 (802.11be).

Hasta el Wifi-5 todas las conexiones se realizaban con portadora de 2,4GHz. Desde el Wifi-5 tenemos además la portadora de 5GHz y desde el Wifi-7 además la de 6GHz.

Cuanto mayor es la portadora, mayor puede ser el ancho de la ventana de transmisión y por tanto la capacidad, pero la capacidad de difusión pasa a reducirse drásticamente.

=====> SEGURIDAD <=====
**Protocolos ROTOS**: WEP, WPA, WPA2.

Protocolos seguros (hoy): WPA3

## Wimax
[Wimax](https://es.wikipedia.org/wiki/WiMAX) es el nombre comercial del estándar [IEEE 802.16](https://es.wikipedia.org/wiki/IEEE_802.16), esto es, WWAN (Wireless WAN)

## Otras: 
### Bluetooth
Implementación del estándar IEEE 802.15.1 -> WPAN

#### Zigbee
Implementación del estándar IEEE 802.15.4 -> WPAN

# Otras tecnologías
## X.25 (PSTN / RTB / RTC)
*1976* -> [El comienzo](https://es.wikipedia.org/wiki/Norma_X.25) -> conmutación de circuitos -> red telefónica conmutada.


## ATM
*1980* -> [Primer paso](https://es.wikipedia.org/wiki/Modo_de_transferencia_as%C3%ADncrona)


## Frame Relay
*1988* -> [Primera red premanente](https://es.wikipedia.org/wiki/Frame_Relay) hacia una red específica -> conmutación de paquetes sobre redes conmutadas o **permanentes**.

### RDSI (ISDN)
*1988* -> [La evolución de lo más básico](https://es.wikipedia.org/wiki/Red_digital_de_servicios_integrados).

## Familia DSL’s (ADSL)
*1998* -> [Primer enlace permanente para el no profesional](https://es.wikipedia.org/wiki/L%C3%ADnea_de_abonado_digital_asim%C3%A9trica).


## Móviles
+ 1G: AMPS (tecnología analógica).
+ 2G: GSM (digital): voz y sms.
+ 2.5G - 3G: GPRS: voz y www desde 9,6kbit/s
+ 3.5G: UMTS y HSDPA
+ 4G: LTE
+ 5G
+ 6G (para 2035)

## 