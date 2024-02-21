#curso23_24 #PAR [estado::ToDo]

# Configuración y administración básica de ROUTERs

## Introducción:
Recordemos la arquitectura de las redes:

![Modelo OSI - Wikipedia, la enciclopedia libre](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fcommons%2Fthumb%2F8%2F8d%2FOSI_Model_v1.svg%2F1920px-OSI_Model_v1.svg.png&f=1&nofb=1&ipt=42a35b36f6840d20498cccb15d5e5b726e8477304a200510b9914cdaaad1f742&ipo=images)
En el dibujo vemos las distintas capas y sabemos que:

- Las direcciones Ethernet son fijas. Hay una dirección por tarjeta de
  red.
- Las direcciones IP son configurables. Por cada tarjeta puede haber
  una IP (o más).

Tradicionalmente pensamos en el movimiento de datos como si fuera una
transacción entre dos máquinas y habrá un paquete que tiene una IP de
origen y una de destino.

## Recordatorio Direccionamiento IP:
### IPv4:
1. Direcciones IPv4. Tacha las direcciones IP inválidas.
   + 0.0.0.0
   + 1.1.1.1
   + 2.2.2.200
   + 200.260.0.3
   + 4.4.4.4.4
   + 5.0.0.300
   + 256.244.244.4
   + 255.255.255.255
   + 700.1000.100

3. Dadas las direcciones anteriores, indica las direcciones IP inválidas para host.

4. ¿Qué puedes decir de las siguientes direcciones?
   + 127.0.0.1
   + 127.1.1.0
   + 127.127.127.127
   + 127.3.3.4
   + 11.0.1.0
   + 0.0.0.0
   + 255.255.255.255
   + 129.0.1.0
   + 10.255.255.255
   + 100.69.1.1
   + 192.168.1.255
   + 192.0.1.0
   + 172.23.255.255
   + 10.0.0.0
   + 172.16.0.0
   + 192.168.0.0

5. Direcciones IP reservadas. Máscaras. Para las siguientes direcciones indicar máscara y si son o no reservadas para redes privadas.
   + 127.0.0.1
   + 8.8.8.8
   + 10.2.2.2
   + 169.254.254.254
   + 169.254.3.2
   + 192.168.1.254
   + 172.16.55.55
   + 10.0.0.1
   + 2.2.3.0
   + 2.1.0.0
   + 172.16.1.0
   + 192.168.0.1
   + 198.164.2.3
   + 1.0.0.1

6. ¿Cuántas redes privadas de clase A tenemos? ¿Cuántos equipos tiene cada una?
7. ¿Cuántas redes privadas de clase B tenemos? ¿Cuántos equipos tiene cada una?
8. ¿Cuántas redes privadas de clase C tenemos? ¿Cuántos equipos tiene cada una?


### VLSM:
![mapa de red](https://planificacionadministracionredes.readthedocs.io/es/latest/_images/tema08-228.png)
Dado el mapa anterior, crea las redes con el mínimo desperdicio de IPs.

![pregunta ccna](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/vlsm-ccna.jpg)




### IPv6
8. Direcciones IPv6. Tacha las direcciones IP inválidas para Unicast global.
   + 2001:0db8:85a3:0000:0000:8a2e:0370:7334
   + 2001:db8:85a3:8d3:1319:8a2e:370:7348
   + 2001::1
   + 2001:af:3::1
   + 2001:0:0:0:0:0:0:1
   + 2001::12a6::1
   + 2002::3:abcd:2
   + 3333:ffff::1
   + 3777:ada:fea::34

9. Comprime y/o descomprime las direcciones anteriores.

10. Busca información acerca de qué es el EUI-64 y el EUI-64 modificado. Para la siguiente MAC (00:11:22:33:44:55) ¿cómo quedaría su EUI-64 y su EUI-64 modificado?
11. EUI-64 modificado. ¿Cuál es la MAC de tu tarjeta de red? Basándote en la dirección MAC de tu tarjeta calcula la dirección IPv6 automática de enlace local (fe80:1111:2222:3333::/10).
12. EUI-64 modificado. ¿Cuál es la MAC de tu tarjeta de red? Basándote en la dirección MAC de tu tarjeta calcula la dirección IPv6 automática global unicast (2001::/32).


*Fuente: [Planificación y administración de redes](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema08/Actividades.html)*

*Nota: EUI-64 modificado*

![eui-64 modificado](https://1.bp.blogspot.com/-DbDiVevyrbw/WZCxBEOdwdI/AAAAAAAAfrg/0VrKD7S-r0MGbFWXPf_cWh1lyGfRngnHwCEwYBhgL/s1600/1.jpg)


## Sockets
Supongamos que en un ordenador hay dos servicios. Un servidor Web y un
servidor de bases de datos por ejemplo Oracle. Supongamos ahora que otro
ordenador quiere conectarse y ver la página web. Supongamos que el
cliente tiene la IP 192.168.1.1 y que el servidor tiene la IP
192.168.1.10.

¿Qué ocurre cuando la conexión del 192.168.1.1 (cliente) llega al
servidor 192.168.1.10? Con lo que sabemos hasta ahora ¿quien recibe la
conexión? ¿El proceso Oracle o el proceso Apache web?

Como en un ordenador puede haber muchos programas enviando y recibiendo
datos, ocurre que a cada programa se le asigna un número llamado
**PUERTO**. Esto significa que cuando un cliente quiere conectar con un
servidor **DEBE PROPORCIONAR UN NÚMERO DE PUERTO**. Los números de
puerto y la gestión de esas múltiples conexiones se hace en la capa de
transporte.

Ocurre por tanto, que cualquier bloque de trama que envíamos tiene en
realidad *al menos* cuatro elementos:

1. IP de origen
2. Puerto de origen
3. IP de destino.
4. Puerto de destino

Tenemos que tener presente que a partir de ahora, la estructura de
cualquier paquete es algo como esto:

(ORIGEN) 192.168.1.11:49813  < === > 45.83.110.91:80 (DESTINO)


Un puerto, en realidad es un número. El sistema operativo usa ese número
para saber a qué programa tiene que darle un paquete entrante. Cuando un
programa servidor (como Apache) arranca intenta que el sistema operativo
le dé un puerto fijo. Si ningún otro programa lo usa, el sistema
operativo se lo dará y a partir de ese momento, los paquetes entrantes
cuyo puerto de destino sea ese se entregarán al software de Apache.

- Los servidores que aceptan conexiones **siempre escuchan en el mismo
  puerto**. De hecho hay algunos números de puerto estandarizados. Por
  ejemplo el 80 TCP es de HTTP y el 443 TCP es de HTTPS.
- Los clientes no siempre usan el mismo número. De hecho los eligen al
  azar con valores entre 49152 y 65535.

¿Qué es eso de TCP? Resulta que en realidad hay dos protocolos de
transporte bastante conocidos (en realidad más pero no los
mencionaremos)

- TCP es un protocolo fiable. Para conseguir fiabilidad envia
  confirmaciones de recepción de mensajes. El problema es que TCP es
  más lento que su alternativa.
- UDP es no confiable. Algunas aplicaciones (como video conferencia)
  necesitan la velocidad extra a toda costa y no importa si se pierden
  algunos datos.

Se debe tener también presente algunas cosas sobre los protocolos:

- Cada programador elige el protocolo de su programa: **no lo podemos
  cambiar**
- Aparte de las IP, los puertos y los orígenes y destino, **el sentido
  del tráfico importa**.
- En las redes, los estándares son públicos, abiertos y gratuitos.
  Estos estándares se denominan RFCs (Request For Comments)

## Componentes del router.

Los router modernos son verdaderos ordenadores en sí mismos:

- Microprocesador: Tradicionalmente, la familia más habitual de procesadores es de la rama MIPS, aunque están tomando bastante fuerza los routers de la familia ARM dado los avances de la tecnología.
- Sistema operativo: En este aspecto el abanico es muy amplio, pero podemos listar los más conocidos:
  - En Cisco está IOS. 
  - En Mikrotik está RouterOS
  - En routers domésticos tenemos OpenWRT
  - Las operadoras suelen ofrecernos routers con GUI WEB personalizado (por la operadora) pero que funcionan sobre GNU/Linux, normalmente.
  - En ocasiones también podremos encontrarnos soft-routers sobre GNU/Linux mediante las extensiones FFRouting o Quaga (anterior).
  - A veces, también veremos soft-routers sobre FreeBSD con FRRouting y Bird.
- RAM: los router deben almacenar las tablas de rutas, que a menudo pueden llegar a ser listados superiores a 100 K entradas en IPv4.
- ROM: en realidad hoy en día suelen ser FLASH NAND. Alojan un programa
  llamado comúnmente el firmware (el sistema operativo). Suele estar particionado en zonas permitiendo almacenar: cargador, core del SO, resto del SO, memoria de trabajo (similar al startup-config de CISCO)
- NVRAM: en ella se almacena la información relativa a la configuración global del SO, así como específica del router, como la VLANs. Solo en dispositivos de gama media/alta debido a que aunque es mucho más rápida que la FLASH NAND, su precio es también mucho más elevado.
- E/S: normalmente solo a través de los puertos de red.

En la figura siguiente podemos ver un router doméstico Mikrotik:
![MK](https://openwrt.org/_media/media/mikrotik/mikrotik_rb750gr3_pcb_top.jpg?h=225&tok=9a1a32)
O un Sercomm h500 habitual de Vodafone/Lowi:

![](https://openwrt.org/_media/media/sercomm/h500s/h500s-board_top.jpg?w=400&tok=890c38)



El diagrama de bloques sería más o menos así:
![diagrama](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/04-descomposicion.png)
O así en el h-500:

![](https://openwrt.org/_media/media/sercomm/h500s/h500s-switch_diagram.png?w=600&tok=294239)

Los router domésticos a nivel interno no solamente tienen un sistema
operativo sino también algunos parámetros configurables:

- IP y máscara. Por defecto, en muchos hogares es la 192.168.1.1 con
  máscara 255.255.255.0
- Rango de direcciones DHCP. DHCP se explicará en profundidad en
  segundo curso, en el módulo "Servicios de red".


## Formas de conexión al router para su configuración inicial.

### Routers domésticos
Los routers domésticos (también se encuentran en PYMES y pequeñas
instituciones) se configuran mediante un interfaz web. Basta con abrir
el navegador y conectarse a su IP de gestión, que en la mayoría de casos
es la <http://192.168.1.1>

### Routers de gama alta
![Conectarse a router CISCO 4321 — Modo consola — Windows | by Cristian ...](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmiro.medium.com%2Fmax%2F6528%2F1*pn8Vbjyyo0npl5z2VcQU9w.jpeg&f=1&nofb=1&ipt=0fde03b78b4bb2b7a0d01c48723676f6f53d15804d69271e70f38e34e8ff26f6&ipo=images)

El proceso es el mismo que en los switches:

- Cable de consola.
- Conexión Telnet (insegura).
- Conexión SSH (segura pero requiere algunos pasos más).

## Comandos para configuración del router.

### Poner clave al modo administrador

Para poner una clave:

    Router>enable
    Router#configure terminal
    Router(config)#enable secret admin1234
    Router(config)#exit
    Router#exit
    Router>enable
    Password:

### Poner clave al acceso por telnet / ssh

El proceso era:

    Router>enable
    Router#configure terminal
    Router(config)#line vty 0 4
    Router(config-line)#password telnet1234
    Router(config-line)#login

### Poner clave al acceso por cable de consola

El proceso era el siguiente:

    Router>enable
    Router#configure terminal
    Router(config)#line console 0
    Router(config-line)#password consola1234
    Router(config-line)#login

### Poner clave al puerto auxiliar
    ...
    Router(config)# line aux ?
    <0-0> ...
    Router(config)# line aux 0
    ...
    
Diferencias entre el [puerto de consola y el auxiliar](http://www.networkchatter.com/configure-an-aux-port-cisco-router/)

Puerto ¿MGMT?

### Quitar una clave o valor de configuración

Supongamos que queremos quitar la clave del modo administrador. Lo único
que se necesita es ir al modo correcto y escribir **no** y despues el
comando que ejecutaba la operación. Por ejemplo, para quitar la clave
`admin1234` que hemos puesto antes haríamos esto:

    Router>enable
    Password:****
    Router#configure terminal
    Router(config)#no enable secret 


## Comandos para administración del router.

### Poner una IP a una interfaz

Para poner una IP se debe entrar en el interfaz correspondiente y luego
usar el comando `ip address <IP> <máscara>`. Por ejemplo, para poner la
IP 192.168.1.1 con máscara 255.255.255.0 al interfaz
`GigabitEthernet 0/0` hacemos esto:

    Router>enable
    Router#configure terminal
    Router(config)#interface GigabitEthernet 0/0
    Router(config-if)#ip address 192.168.1.1 255.255.255.0
    Router(config-if)#no shutdown


### Poner IP a TODO el ROUTER.

Con el sistema anterior se asigna una IP a una de las interfaces por lo que si esta cae, el dispositivo no será accesible con esa IP.

Por el contrario, si le asignamos una IP a una **interface de loopback**, al ser software no caerá y tendremos acceso al mismo por esa IP desde cualquier interfaz.

    cisco# conf[igure] t[erminal]
    cisco(config)# interface loopback<número de la interfaz>
    cisco(config-if)# ip address <dirección IP> <máscara>
    
Podemos tener varias interfaces de loopback en un equipo.


### Configurar DHCP

DHCP (Dynamic Host Configuration Protocol) es un protocolo que permite
que los host de una red se configuren automáticamente. Solo se necesita
definir una serie de parámetros en alguna máquina que hará de *servidor
DHCP* y que escuchará peticiones. Cuando un ordenador se encienda y esté
configurado en modo DHCP **difundirá una petición** y si esa petición la
recibe el servidor le contestará indicando la IP, máscara y otros datos
que puede usar.

Los parámetros que se necesitan son estos:

- Dirección IP y máscara. Absolutamente imprescindibles.
- Gateway (dirección del router que nos permite salir a otras redes).
- Otros parámetros, dirección de servidores DNS.

Los comandos son estos:

    Router>enable
    Router#configure terminal
    Router(config)#ip dhcp pool pool_contables
    Router(dhcp-config)#network 192.168.1.0 255.255.255.0
    Router(dhcp-config)#default-router 192.168.1.1
    Router(dhcp-config)#dns-server 8.8.8.8

El parámetro *default-router* será el que los clientes utilicen como *default gateway* o ‘puerta al mundo por defecto’.


### Excluir direcciones de la asignación DHCP

Una vez estemos en un DHCP, como teníamos antes, podemos *excluir
direcciones.* Se puede excluir solo una o excluir un rango de
direcciones:

    Router>enable
    Router#configure terminal
    Router(config)#ip dhcp pool pool_contables
    Router(dhcp-config)#network 192.168.1.0 255.255.255.0
    Router(dhcp-config)#exit
    Router(config)#ip dhcp excluded-address 192.168.1.1
    Router(config)#ip dhcp excluded-address 192.168.1.20 192.168.1.30



## Configuración del enrutamiento estático.

Se debe empezar por ir al modo de configuración global. En líneas
generales el comando tiene estas partes:

1. En primer lugar se escribe `ip route`.
2. Despues se escribe **la dirección IP de red** de la red a la cual
   queremos que el router pueda enviar paquetas.
3. Despues se escribe **la máscara de dicha red**.
4. Después se escribe **la IP del siguiente router** al que vamos a
   enviar el paquete.

Así, para enseñarle a un router que si necesita enviar paquetes a la red
10.0.0.0/16 debe enviarlo al router con la IP 80.26.118.200 escribiremos
`ip router 10.0.0.0 255.255.0.0 80.26.118.200`

Examina la figura siguiente:

![](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/05.png)

En ella hay cuatro redes, que son respectivamente:

- La 10.0.0.0, arriba a la izquierda. Tiene un solo nodo, un PC con la
  IP 10.0.0.10.
- La 20.0.0.0, arriba a la derecha. Tiene un solo nodo, un PC con la
  IP 20.0.0.20.
- La 30.0.0.0, abajo a la izquierda. Tiene un solo nodo, un PC con la
  IP 30.0.0.30.
- La 40.0.0.0, abajo a la derecha. Tiene un solo nodo, un PC con la IP
  40.0.0.40.

Configura todo lo necesario para que todos los equipos puedan conectar
con todos los demás.

En los siguientes párrafos se desglosa la solución.

### Boceto general de la solución al enrutamiento

En primer lugar se debe tener presente que *si no definimos un conjunto
claro de rutas podemos hacer que sin querer los paquetes se enruten mal
y den vueltas dentro de la red sin llegar nunca a nuestro destino.*

Por ello, adoptaremos esta política.

- Si podemos entregar un paquete justo al router responsable de esa
  red lo haremos usando la ruta directa y más corta.
- Si hay que enviar un paquete a través de varios router definiremos
  un "sentido de giro". Por ejemplo, cuando tengamos dudas tomaremos
  la decisión de enviar los paquetes de forma que recorran la red en
  sentido horario, es decir, el sentido en que giran las agujas del
  reloj.

Con esto, la configuración de las rutas sería algo como lo que mostramos
en los párrafos siguientes.

### Redes en Router 1
Comandos necesarios:

    enable
    configure terminal
    ip route 20.0.0.0 255.0.0.0 1.1.1.2
    ip route 30.0.0.0 255.0.0.0 2.2.2.2
    ip route 40.0.0.0 255.0.0.0 1.1.1.2
    exit

### Redes en Router 2
Comandos necesarios:

    enable
    configure terminal
    ip route 10.0.0.0 255.0.0.0 1.1.1.1
    ip route 40.0.0.0 255.0.0.0 4.4.4.2
    ip route 30.0.0.0 255.0.0.0 4.4.4.2

### Redes en Router 3
Comandos necesarios:

    enable
    configure terminal
    ip route 10.0.0.0 255.0.0.0 2.2.2.1
    ip route 20.0.0.0 255.0.0.0 2.2.2.1
    ip route 40.0.0.0 255.0.0.0 3.3.3.2

### Redes en Router 4
Comandos necesarios:

    enable
    configure terminal
    ip route 20.0.0.0 255.0.0.0 4.4.4.1
    ip route 30.0.0.0 255.0.0.0 3.3.3.1
    ip route 10.0.0.0 255.0.0.0 3.3.3.1


### Rutas como firewall de salida
En la empresa tenemos un problema de competitividad ya que nuestros trabajadores están muy enganchados a leer el “marca”. 

Para solucionarlo, hemos pensado que podemos crear una ruta en el router de borde que capture las peticiones al marca y las descarte. 

Para la implementación:
```bash
# Dominio a capturar
FQDN="marca.com"

# IP del dominio
IP=$(dig $FQDN | egrep "^$FQDN" | cut -f6)

# Captura de ruta
sudo ip route add $IP via 127.0.0.1 
```

Para liberarla, tan fácil como eliminar dicha ruta `sudo ip r del $IP via 127.0.0.1`


## Ejercicio completo de configuración de routers

Observa la figura siguiente. En ella hay tres router que interconectan
tres redes. En ellas ocurre lo siguiente:

- Todas las redes usan direccionamiento con IPs privadas del tipo
  192.168.1.0/255.255.255.0.

- Todos los equipos "PC" se configuran mediante direccionamiento
  dinámico con DHCP en los respectivos router. Se desea que estos
  equipos adopten una IP al azar, que usen siempre como router por
  defecto a su router (que tendrá la IP 192.168.1.1) y que usen como
  servidor DNS a la IP 8.8.8.8.

- Todos los "Server" tienen la dirección 192.168.1.25/255.255.255.0.
  Su router y su DNS serán los mismos valores que en los PC pero en
  los "Server" todos los parámetros son estáticos, se deben
  configurar a mano.

- Todos los router tienen una tarjeta llamada "GigabitEthernet 0/0"
  que les conectan con las redes internas. Esta tarjeta **siempre**
  tiene la IP 192.168.1.1/255.255.255.0

- Todos los router tienen tarjetas "Serial" que les conecta con
  otros router. En concreto:
  
  > - El router "Router0" tiene una tarjeta "Serial 0/3/0" que
  >   le conecta con una tarjeta "Serial 0/3/0" de "Router1".
  > - El router "Router0" tiene una tarjeta "Serial 0/3/1" que
  >   le conecta con una tarjeta "Serial 0/3/0" de "Router2".
  > - El router "Router1" tiene una tarjeta "Serial 0/3/1" que
  >   le conecta con una tarjeta "Serial 0/3/1" de "Router2"

- Los router están interconectados entre sí usando direcciones
  públicas. En concreto:
  
  > - "Router0" y "Router1" están conectados por la red
  >   1.0.0.0/8. "Router0" tendrá la 1.1.1.1 y "Router1" la
  >   1.1.1.2
  > - "Router0" y "Router2" están conectados por la red
  >   2.0.0.0/8. "Router0" tendrá la 2.2.2.1 y "Router2" la
  >   2.2.2.2
  > - "Router1" y "Router2" están conectados por la red
  >   3.0.0.0/8. "Router1" tendrá la 3.3.3.1 y "Router2" la
  >   3.3.3.2

### Direccionamiento, DHCP y NAT interno

Todos los routers están configurados exactamente igual:

    enable
    configure terminal
    ip dhcp pool pool_direcciones
    network 192.168.1.0 255.255.255.0
    default-router 192.168.1.1
    dns-server 8.8.8.8
    exit
    ip dhcp excluded-address 192.168.1.1
    ip dhcp excluded-address 192.168.1.10 192.168.1.20
    interface gigabitethernet 0/0 
    ip address 192.168.1.1 255.255.255.0
    ip nat inside
    no shutdown
    exit
    exit
    copy running-config startup-config

### NAT Externo y direcciones públicas

Habrá que entrar en las distintas tarjetas y activar el NAT correcto.
Para Router0 sería así:

    enable
    configure terminal
    interface serial 0/3/0
    ip address 1.1.1.1 255.0.0.0
    ip nat outside
    no shutdown
    interface serial 0/3/1
    ip address 2.2.2.1 255.0.0.0
    ip nat outside
    no shutdown

Para Router1 sería muy parecido:

    enable
    configure terminal
    interface serial 0/3/0
    ip address 1.1.1.2 255.0.0.0
    ip nat outside
    no shutdown
    interface serial 0/3/1
    ip address 3.3.3.1 255.0.0.0
    ip nat outside
    no shutdown

Y para Router2 también muy similar:

    enable
    configure terminal
    interface serial 0/3/0
    ip address 3.3.3.2 255.0.0.0
    ip nat outside
    no shutdown
    interface serial 0/3/1
    ip address 2.2.2.2 255.0.0.0
    ip nat outside
    no shutdown


## ACL (Listas de Control de Acceso)

### Definición y ubicación de listas de control de acceso (ACLs).

Cisco define las listas de control de acceso como *una herramienta para
hacer definir perfiles en el tráfico de red que luego puedan utilizarse
para operaciones como filtrado de paquetes u ordenación del tráfico.*

Para realizar operaciones de filtrado necesitaremos hacer lo siguiente:

1. Definir la lista de control de acceso y añadir alguna acción. Se
   debe hacer en el modo de configuración global.
2. Añadir todas las acciones que queramos.
3. Entrar en un interfaz.
4. Aplicar la lista indicando si es para el tráfico de entrada (in) o
   de salida (out)

### Tipos de ACLs
+ [CCNA desde Cero](https://ccnadesdecero.es/listas-control-acceso-acl-router-cisco/)

### Wildcard
El wildcard es la inversión bit a bit de la máscara de red.

Ejemplos de wildcard:
| CIDR | Máscara | Wildcard | Significado |
| --- | --- | --- | --- |
| /0 | 0.0.0.0 | 255.255.255.255 | todo INTERNET |
| /8 | 255.0.0.0 | 0.255.255.255 | clase A |
| /23 | 255.255.254.0 | 0.0.1.255 | 512 IPs |
| /24 | 255.255.255.0 | 0.0.0.255 | clase C |
| /25 | 255.255.255.128 | 0.0.0.127 | 128 IPs |
| /26 | 255.255.255.196 | 0.0.0.63 | 64 IPs |
| /30 | 255.255.255.252 | 0.0.0.3 | 4 IPs |
| /31 | 255.255.255.254 | 0.0.0.1 | 2 IPs |
| /32 | 255.255.255.255 | 0.0.0.0 | un HOST |



### Definiendo ACLs STANDARD y añadiendo acciones

El comando básico tiene esta estructura:

    access-list <numero_de_lista> permit/deny <origen> <destino>

Si por ejemplo queremos crear una lista con el número 100 y poner en
ella tres condiciones haríamos esto:

    access-list 100 permit <condicion 1>
    access-list 100 deny <condicion 2>
    access-list 100 permit <condicion 3>

Si luego queremos poner otras condiciones en otra lista haríamos esto:

    access-list 101 permit <condicion 4>
    access-list 101 deny <condicion 5>
    access-list 101 permit <condicion 6>

Cuando llegue la hora de examinar el tráfico IOS irá primero a la lista
100 e irá examinando lo que hay que hacer. Si no hay nada examinará
despues la lista 101. Esto implica lo siguiente: **¿Qué ocurre si la
condición 1 permite cierto tipo de tráfico y resulta que en la condición
5 queríamos denegar justo ese tráfico?** Pasará que sin querer lo hemos
autorizado por lo que se debe revisar con cuidado el orden de las
condiciones.

#### Ejercicio:
Queremos bloquear todos las comunicaciones a 192.168.10.0/24 desde 192.168.1.0/24, con excepción del servidor TFTP (IP .2) del siguiente mapa de red:
![inspeccion ACL](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/ACL-standard-mapa.png)

Resultado:
![inspeccion ACL](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/ACL-standard-inspeccion.png)

==POR REVISAR==

### Definición de condiciones

Se pueden definir condiciones con estos parámetros

- Se puede indicar como IP origen tanto un host como una red entera
  como la palabra `any` Para indicar una red entera se debe indicar la
  máscara en formato *wildcard* que es como la máscara pero con los
  bits invertidos: una IP como 192.168.1.0 con máscara 255.255.255.0
  se pone en formato *wildcard* como 192.168.1.0 0.0.0.255. Para
  indicar un host exacto se usa `host 192.168.1.23`

- Se debe indicar el protocolo (tcp, udp\...)

- Se puede indicar como puerto de origen tanto un número exacto como
  condiciones:
  
  > - `eq 80` significa "exactamente el puerto 80".
  > - `neq 443` significa "distinto del puerto 443"
  > - `gt 49151` significa "puertos mayores que el 49151". Es
  >   decir, 49152 o más.
  > - `lt 49153` significa "puertos menores que 49153". Es decir,
  >   49152 o menos.

### Aplicación de reglas

En realidad es tan sencillo como hacer esto:

    interface fastethernet 0/0
    ip access-group 100 in

Esto entra en la tarjeta 0/0 y aplica la lista de acceso 100 al tráfico
de entrada.

> **Danger**: Esto que es aparentemente fácil se puede volver muy confuso si no
> tenemos claro como se definió la regla **en relación con el sentido del
> tráfico.** Si definimos la regla bien, pero nos equivocamos y lo
> aplicamos en la tarjeta incorrecta o confundiendo "in" con "out"
> veremos que nuestras reglas no funcionan.

En los apartados siguientes veremos de manera práctica como crear
algunas reglas para restringir el tráfico. Se debe recordar que una vez
construidas las reglas *la política por defecto es denegar el tráfico.*
Por tanto para estos ejercicios añadiremos reglas extras que autoricen
el resto del tráfico.

### Ejercicios ACLs

Dadas dos redes (puedes ver la topología abajo) con las direcciones
10.0.0.0/8 y 20.0.0.0/8 ocurre lo siguiente:

- En la red 10 hay un servidor con la IP 10.0.0.200 que sirve webs y
  FTP
- En la red 20 hay un servidor con la IP 20.0.0.200 que sirve webs y
  FTP

![](https://luiscastelar.duckdns.org/2023/assets/PAR/UT5/06-ej-acls.png)

Se nos pide poner en marcha los escenarios siguientes (cada escenario es
independiente, reinicia los routers o borra las reglas antes de pasar de
un escenario a otro):

Escenario 1
-----------

Suponiendo que administramos la red 20.0.0.0/8, prohibir que el host
10.0.0.100 acceda al servidor HTTP 20.0.0.200

Solución:

- Forzaremos la prohibición tan pronto como los datos lleguen al
  router 1, su tarjeta de red es la Fa0/0 que es la que le conecta con
  el router 0.
- ¿Quien es el origen? Es un host y tiene la IP 10.0.0.100
- ¿Qué puerto de origen usará? Uno dinámico pero a partir de TCP 49152
- ¿Quien es el destino? La regla se aplicará a otro host y en concreto
  es el host 20.0.0.200
- ¿Qué puerto es el destino? El TCP 80
- ¿Qué acción se va a tomar? "Deny"

Los comandos serán como sigue:

    enable
    configure terminal
    access-list 100 deny tcp host 10.0.0.100 gt 1 host 20.0.0.200 eq 80
    access-list 100 permit tcp any any
    interface fastethernet 0/0
    ip access-group 100 in

Escenario 2
-----------

Suponiendo que administramos la red 20.0.0.0/8, prohibir que el host
10.0.0.100 acceda al servidor FTP 20.0.0.200

Nos aseguramos de borrar todo lo anterior y ejecutamos esto:

    enable
    reload
    enable
    configure terminal
    access-list 100 deny tcp host 10.0.0.100 gt 1 host 20.0.0.200 eq 20 
    access-list 100 deny tcp host 10.0.0.100 gt 1 host 20.0.0.200 eq 21
    access-list 100 permit tcp any any
    access-list 100 permit icmp any any
    interface fastethernet 0/0
    ip access-group 100 in
    exit
    exit
    exit

Escenario 3
-----------

Prohibir el acceso al HTTP de 20.0.0.200 para cualquier máquina de la
red 10.0.0.0/8 (no vale escribir una regla para cada host, debe haber
una sola regla para toda la red 10)

Pista: Cisco no entiende cosas como 10.0.0.0/8 ni cosas como 10.0.0.0
255.0.0.0. Cisco usa un concepto denominado "wildcards"

Una wildcard es como una máscara pero cambiando los bits 0 por bits 1 y
los bits 1 por bits 0. Es decir, es una especie de "máscara inversa"
(no "máscara al revés")

Si la máscara IP es: `11111111.00000000.00000000.00000000 => 255.0.0.0`

La wildcard Cisco es así: `00000000.11111111.11111111.11111111 => 0.255.255.255`

Solución al escenario 3:

    enable
    configure terminal
    access-list 100 deny tcp 10.0.0.0 0.255.255.255 gt 1 host 20.0.0.200 eq 80
    access-list 100 permit tcp any any
    access-list 100 permit udp any any
    access-list 100 permit icmp any any
    interface fastethernet 0/0
    ip access-group 100 in

Escenario 4
-----------

Suponiendo que administramos el router 1 (derecha):

- Se desea permitir el tráfico HTTP a cualquiera que provenga de la
  red 10.0.0.0.
- Se desea permitir el FTP al host 10.0.0.100
- Se desea prohibir el FTP solo al host 10.0.0.101
- Permitir el resto de casos.

Solución:

    enable
    reload
    enable
    configure terminal
    access-list 100 permit tcp 10.0.0.0 0.255.255.255 gt 0 host 20.0.0.200 eq 80
    access-list 101 permit tcp host 10.0.0.100 gt 0 host 20.0.0.200 eq 20
    access-list 102 permit tcp host 10.0.0.100 gt 0 host 20.0.0.200 eq 21
    access-list 103 deny tcp host 10.0.0.101 gt 0 host 20.0.0.200 eq 20
    access-list 104 deny tcp host 10.0.0.101 gt 0 host 20.0.0.200 eq 21
    access-list 105 permit tcp any any
    access-list 106 permit udp any any
    access-list 107 permit icmp any any
    interface fastethernet 0/0
    ip access-group 100 in
    ip access-group 101 in
    ip access-group 102 in
    ip access-group 103 in
    ip access-group 104 in
    ip access-group 105 in
    ip access-group 106 in
    ip access-group 107 in
    exit
    exit
    exit

Escenario 5
-----------

Ahora administramos el router 0 (izquierda) y se desea conseguir lo
siguiente:

- Permitir el tráfico de salida HTTP destinado a la derecha.
- Denegar el resto de casos.

Por cuestiones de rendimiento se desean tomar las decisiones tan pronto
como se pueda y cortar el tráfico tan pronto como lo descubramos:

    enable
    reload
    enable
    configure terminal
    access-list 100 permit tcp 10.0.0.0 0.255.255.255 gt 0 host 20.0.0.200 eq 80
    interface fastethernet 0/0
    ip access-group 100 out
    exit
    exit
    exit

Escenario 7
-----------

Siendo los administradores del router 0 (izquierda) se desea permitir la
entrada de tráfico HTTP del ordenador 20.0.0.101 y denegar todos los
demás casos.

No nos dicen donde "tomar la decisión", haremos los dos.

### Caso 1: decidir en la tarjeta 0/0

Para la tarjeta 0/0 este requisito es una REGLA DE ENTRADA, es decir,
que usaremos "in":

    enable
    reload
    enable
    configure terminal
    access-list 100 permit tcp host 20.0.0.101 gt 0 host 10.0.0.200 eq 80 
    interface fastethernet 0/0
    ip access-group 100 in
    exit
    exit
    exit

### Caso 2: decidir en la tarjeta 0/1

Aunque el tráfico es ENTRANTE, desde el punto de vista de la tarjeta 0/1
el tráfico es SALIENTE, así que habrá que usar "out":

    enable
    reload
    enable
    configure terminal
    access-list 100 permit tcp host 20.0.0.101 gt 0 host 10.0.0.200 eq 80 
    interface fastethernet 0/1
    ip access-group 100 out
    exit
    exit
    exit

Escenario 8
-----------

Administramos el router izquierdo y deseamos permitir el tráfico HTTPS
que viene de la red derecha. También se desea permitir el tráfico HTTP
que viene del 20.0.0.100. Denegar el resto de casos.

### Caso 1: decidir en tarjeta 0/0

Los comandos serían:

    enable
    configure terminal
    access-list 100 permit tcp 20.0.0.0 0.255.255.255 gt 0 host 10.0.0.200 eq 443
    access-list 100 permit tcp host 20.0.0.100 gt 0 host 10.0.0.200 eq 80
    interface fastethernet 0/0
    ip access-group 100 in
    exit
    exit
    exit

### Caso 2: decidir en la otra tarjeta

Se queda como ejercicio, ¡inténtalo!


### Fuentes:
+ [ACL standard - Kalero](https://www.youtube.com/watch?v=hliq-UZ1Heo&t=782s&pp=ygUSa2FsZXJvIGFjY2VzcyBsaXN0) y [ACL extended - Kalero](https://www.youtube.com/watch?v=xI065U7JFpc&t=16s&pp=ygUSa2FsZXJvIGFjY2VzcyBsaXN0)
+ [ConfiguKarar ACL de IP de uso general - Cisco.com](https://www.cisco.com/c/es_mx/support/docs/ip/access-lists/26448-ACLsamples.html)
+ [Configuración y filtrado de listas de acceso - Cisco.com](https://www.cisco.com/c/es_mx/support/docs/security/ios-firewall/23602-confaccesslists.html)
+ [CCNA desde 0](https://ccnadesdecero.es/?s=acl)

## Enrutamiento estático con backup

    ! Ruta principal
    ip route 172.16.3.0 255.255.255.0 S0/0/1
    !
    ! Ruta backup (le añadimos métrica)
    ip route 172.16.3.0 255.255.255.0 S0/0/2 10


## Enrutamiento entre VLANs
Históricamente se realizaban mediante enrutado entre interfaces, por lo que debíamos duplicar el conexionado router-switch.

Posteriormente, gracias a las *subinterface*s realizaremos el mismo procedimiento, pero reduciendo el hardware (cableado y puertos) necesario.

En la actualidad, se suele recurrir a switchs de capa 3 que permiten dicho enrutado por hardware, acelerando el proceso y descargando a los routers de dicha tarea.

Dado un switch de capa 3, vamos a describir los pasos:
1. Crear VLANs en el switch y asignar a los puertos.
2. Crear las subinterfaces (SVI) en el switch y asignarles IPs. *Normalmente, comenzaríamos por ahí y serán éstas las que ofrezcan un  pool dhcp a los clientes*.
3. Habilitar el enrutamiento con el comando `ip routing` (ojo i.
4. Activar filtros ACL que deseemos para limitar el routing entre VLANs.


Fuente:
+ [CCNA desde cero](https://ccnadesdecero.es/funcionamiento-enrutamiento-entre-vlan/)
 

## Práctica:
![enrutamiento estático](https://luiscastelar.duckdns.org/2023/practicas/par/ut5-static-routing.png)

Dada la figura:\
1. Obtén el archivo **11-config.pkt**
   + Configura todos los dispositivos (securizar e ip).
2. Obten el archivo **12-rutas-principales.pkt**
   + Crea el camino desde el PC0 al PC1 por la ruta principal (triángulos verdes).
   + Crea el camino opuesto por la ruta secundaria (triángulos rojos).
3. Obtén el archivo **13-rutas-backup.pkt**
   + Crea la ruta backup (triángulos rojos) del camino de ida.
   + Crea la ruta backup (triángulos verdes) del camino de vuelta.
4. Una excavadora ha roto la línea 10.0.0.0 ¿que ocurre?.
5. Obtén el archivo **15-acl-standar.pkt**
   + Crea una ACL standard que bloquee el acceso del equipo 192.168.0.3 a la red 192.168.1/24
   + Crea una ACL standard que bloquee el acceso a la subred 192.168.0.128/25 a la red 192.168.1/24
6. Obtén el archivo **14-dhcp.pkt**
   + Elimina las ips estáticas de los equipos y haz que sigan comunicando.
   + 
<!--
7. Obtén el archivo **16-acl-extended.pkt**
   + Añade los equipos 192.168.0.3 y 192.168.0.132
   + Crea una ACL extended que bloquee el acceso del equipo 192.168.0.3 a la red 192.168.1/24
   + Crea una ACL extended que bloquee el acceso a la subred 192.168.0.128/25 a la red 192.168.1/24
   -->
   
8. Obtén el archivo **17-rutas-en-ipv6.pkt**
   + Borra la configuración IPv4 de TODOS los dispositivos
   + Asigna IPv6 a los dispositivos y crea una ruta de comunicación en IPv6
9. Obtén el archivo **18-acl-en-ipv6.pkt**
   + Crea una ACL extended que bloquee el acceso a la subred 192.168.0.128/25 a la red 192.168.1/24

**NOTA**: Debéis cambiar la red 192.168.1/24 por vuestro “reino”, esto es, la red 192.168.X/24, donde X es el número de vuestro puesto de trabajo.

**NOTA 2:** Guarda la configuración de los dispostivos en un fichero de texto copiando desde la consola la configuración que nos muestra el comando `show startup-config`. Estos archivos los necesitaremos más adelante.


## Fuente:
+ [Oscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t4_routers/apuntes_t4.html)
