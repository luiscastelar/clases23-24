#curso23_24 #PAR [estado::Working]


## Mapa conceptual de la unidad
![mapa conceptual](https://luiscastelar.duckdns.org/2023/assets/PAR/UT2_MapaConceptual.jpg)


# {[Fold: Fold]} ==PDTE DE REVISIÓN==

## Medios físicos

### Inalámbricos

## Cableado

### UTP, FTP, STP

### LSZH ó LS0H

Estas siglas indican varias cosas LOW SMOKE + 0 (Zero) HALOGENS:

+ LOW SMOKE o Bajos Humos. Hace referencia a las siguientes normativas UNE-EN 61034: Medida de la densidad de humos emitidos por cables en combustión bajo condiciones definidas. También IEC 61034. Por lo que Low Smoke quiere decir baja opacidad de los humos emitidos.

+ 0 HALOGENS o Cero Halógenos. Hace referencia a las siguientes normativas: UNE-EN 50267: Método de ensayos comunes para cables sometidos al fuego. Ensayo de los gases desprendidos durante la combustión de materiales procedentes de los cables. Determinación de la cantidad de gases halógenos ácidos. También IEC 60754. Por lo que estás siglas significarían cero gases halógenos desprendidos en la combustión.

**Ventajas de LSZH Cables**
1. Libre de halógenos: Los cables de baja emisión de humos y sin halógenos están fabricados con aislamiento ecológico, revestimiento y materiales especiales. Esto hace que no sólo tenga buenas propiedades eléctricas y físico-mecánicas, sino que también evite la contaminación secundaria por los gases tóxicos de la combustión.
2. Baja emisión de humos y baja toxicidad: Este tipo de cable utiliza nuevos materiales de revestimiento especiales. Entonces, no se producen gases tóxicos durante su producción y uso y no contamina el medio ambiente. El uso de cables de baja emisión de humos y libres de halógenos es esencial en zonas con necesidades especiales y en las que hay una gran concentración de personas.
3. Respetuoso con el medio ambiente: El aislamiento y la cubierta del cable LSZH no contienen metales pesados perjudiciales para el ser humano, como el plomo y el cadmio. Y el cable se desecha sin contaminar el suelo ni el agua. Es más respetuoso con el medio ambiente que los cables convencionales. Entonces, también conocido como cable ecológico.
4. Alta retardancia de la llama: Los cables ecológicos pueden cumplir los elevados requisitos contra el fuego de los edificios. Los LSZH alambres y cables no son fácilmente combustibles y evitan la propagación del fuego y la expansión de los desastres. Especialmente en los edificios de gran altura, el uso de LSZH cables puede aumentar el tiempo de rescate y reducir el peligro de los gases nocivos para las personas.


## Direccionamiento

Antes de comenzar con el direccionamiento debemos repasar algunos conceptos sobre sistemas de numeración ya que los utilizaremos intensivamente en esta unidad.

### Sistemas de Numeración

**Sistema Decimal**

Si decimos que tenemos el número 194... ¿qué significa?

> 1 x 10^2 + 9 x 10^1 + 4 x 10^0 = 194 *en base 10*

**Sistema Binario**

¿Y si tenemos el número **binario** 1011?

> En binario => 1 x 2^3 + 0 x 2^2 + 1 x 2^1 + 1 x 2^0 = 1011 *en base 2*
> En decimal =>       8 +       0 +       2 +       1 = 11 *en base 10*

- [Conversión decimal a binario](https://www.youtube.com/watch?v=fGu0tM5u4b4)
- [Conversión binario a decimal](https://www.youtube.com/watch?v=Efj5vWxFcao)

#### Ejercicios:

| Decimal |   Binario |
| ------- | --------- |
| 23      |           |        
| 56      |           |      
|     45  |           |
|     98  |           |
|      7  |           |
|         | 1001 0110 |
|         | 0001 1110 |
|         | 101       |
|         | 10        |
|         | 1011      |

**Sistema Hexadecimal**

El sistema hexadecimal es un sistema en base 16.

Puesto que nosotros sólo tenemos los dígitos de 0 a 9, ¿cómo podemos solveltarlo?

Para representar el sistema hexadecimal debemos añadir 6 _caracteres_ extra a nuestro sistema de numeración, quedando por tanto de la siguiente forma: `0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E y F`, tomando:
+ A el valor de 10,
+ B el valor 11,
+ y así hasta la F el valor 15.

Éste sistema de numeración se utiliza fundamentalmente para “compactar” el binaro y que el número de dígitos a utilizar sea inferior. Ejemplos:

  | Binario                       |   Hexadecimal |
  |------------------------------ | ------------- |
  | 1001 0110                     |   96          |
  | 0001 1110                     |   1E          |
  | 1001 0110 1100 0111           |   96 C7       |
  | 0001 1110 1001 0110 1100 0111 |   1E 96 C7    | 

Como podemos ver, es mucho más práctico representar en hexadecimal que
en binario, y uno y otro encajan perfectamente en bloques de 4 dígitos binarios (nibble) a 1 dígito hexadecimal.

### Direcciones capa 1:
No existen

### Direcciones capa 2:

### Direcciones capa 3:

### Direcciones capa 4:

### Sockets
Es la unión de la dirección capa 3 y capa 4. Se representa separadas por “:“ y son muy utilizadas para localizar de forma única _en el mundo(*)_ un servicio.

Ejemplos:
+ 192.168.0.12:8080
+ 8.8.8.8:53
+ 0.0.0.0:22
+ fe80::b83c:865b:98a2:6153:80
+ :::53
+ http://[::1]:8081


## Adaptadores para red cableada. Tipos y características.
![](https://luiscastelar.duckdns.org/2023/assets/PAR/RL03_CONT_R09_PartesNIC_miniatura.jpg)
Un adaptador de red o una tarjeta de red es un dispositivo que permite
hacer la conexión de un equipo a una red.

La tarjeta de red realiza la función de intermediario entre el ordenador
y la red de comunicación. En ella se encuentran grabados los protocolos
de comunicación de la red, en los niveles físico y enlace. Pueden
incluso estar integradas en la placa base. A las tarjetas de red también
se las conoce como NIC (Network Interface Card).

Las tarjetas de red disponen de una identificación en formato
hexadecimal (48 bits expresados como 12 dígitos hexadecimales) de modo
que al enviarse tramas de datos de unos a otros se envían también la
dirección de la tarjeta. Esta dirección se denomina dirección MAC y
viene asignada por el fabricante. No existen dos tarjetas de red con la
misma dirección MAC. Si queremos averiguar la dirección MAC de una
tarjeta de red lo haremos:

-   En GNU/Linux, con el comando `ip add` o `ifconfig` desde la terminal
    o desde el NetworkManager instalado en el entorno gráfico.
-   En Windows, con el commando `ipconfig /all` desde el cmd o el
    PowerShell.

### Tipos y características:

Las tarjetas hoy en día se diferencia fundamentalmente en internas
(PCI/PCIe), externas (USB) o integradas en portátiles (M2)

![WIFI-PCIe](https://luiscastelar.duckdns.org/2023/assets/PAR/wifi-pcie.jpg)

![](https://luiscastelar.duckdns.org/2023/assets/PAR/wifi-usb.jpeg){width="200px"}

![WIFI-M2](https://luiscastelar.duckdns.org/2023/assets/PAR/wifi-m2.jpg)

**Características:**

    Las características principales son ancho de banda y número de
    bandas. Normalmente viene definida en el estándar al que se acoge,
    del tipo 802.11x, donde x será una letra y nos definirá banda (2,4 o
    5 GHz), ancho de banda (Mhz) y distancia (m).

**Ejercicios:**
    1.  Busca información sobre los distintos estándares wifi (802.11x),
        explícalo con tus palabras y compáralo con la nueva y
        simplificada normativa del tipo "wifi6".
    2.  Razona el posible uso de cada uno de los tipos de dispositivos,
        las ventajas y los inconvenientes.

