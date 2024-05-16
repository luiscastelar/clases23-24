#curso23_24 #PAR [estado::done] 

# Cambiar PASSWORD de entrada
1. Ingresar en el modo ROMMON.
2. Cambiar el registro de configuración.
3. Copiar el startup-config en la running-config.
4. **Cambiar la contraseña**.
5. Guardar el running-config como el nuevo startup-config.
6. Recargar el dispositivo.

# RESET Router series 800, 2600 y 2800

### Por software
Reset a Cisco 2800 (y 2600) series router to factory default without the enable password.

So you have a router you want to reset, but don't know the enable password. Here's what to do:
1. Connect to the serial console.
2. Power off the router and then power on.
3. Send the router a **BREAK**. This should bring you to the **rommon** prompt
    > *Para enviar el BREAK desde PuTTY deberemos hacer click en el botón derecho en el título y seleccionar `Special Command>BREAK`*
    >
    > *Para enviar el BREAK desde screen (GNU/Linux) deberemos utilizar la combinación (C-a b, C-a C-b).*
4. Type this command at the rommon prompt in order to boot from Flash.
```ios
  rommon 1 > **confreg 0x2142**
```
5. Reset the router.
```ios
  rommon 2 > **reset**
```
6. The router should now boot into the Initial config dialogue:
```ios
  Would you like to enter the initial configuration dialog? \[yes/no\]: yes
```
7. Follow the prompts, to set a basic config.
8. Enter enable mode and set the router to boot from the right place
```ios
 Router>**enable**
 Router>**conf t**
 Router(config)>**config-register 0x2102**
 Router(config)>**end**
 Router>**wr mem**
```
9. Reload the router to check it worked properly


### Con botón de reset
1. Pulsar el botón de reset trasero.
2. Enchufar el router.
3. Esperar 5-7 segundos y soltar el reset.
4. Esperar el arranque


## Terminal

1. Una vez conectado \
> router <--- cable de consola -> terminal RJ45-to-rs232 <---> cable rs232-to-usb ---> pc

### Desde Linux:
Abrir el software de gestión de la consola (putty o `screen /dev/ttyUSB0`).
```bash
sudo dmesg | tail
screen /dev/ttyUSB0 9600
# también con minicom -s
```


#### Config desde Alpine (live)
1. Acceso como `root` sin password.
2. Configurar `setup-alpine` . **Importante:** No guardar la configuración sobre el disco duro, puede haber pérdida de datos.
3. Actualizar lista de paquetes: `apk update`
4. Instalar screen: `apk add screen`
5. Conectar cable.
6. Ver puerto de conexión: `dmesg | tail` -> mostrará algo como `ttyUSB0` por lo que nos conectaremos a `/dev/ttyUSB0`.
7. Aplicación: `screen /dev/ttyUSB0 9600`
8. Programar dispositivo.
9. Desconectar cable para cerrar.

### Desde Windows 
Con [PuTTY](https://teklager.se/en/knowledge-base/serial-connection-putty-windows/), seleccionando conexión serial. 

Configurar la captura a archivo de logs para análisis posterior y recopilación de evidencias.



## Primer acceso

Por defecto, el usuario es ‘cisco’ y el password es ‘cisco’.

# Práctica con dispositivos físicos serie C880
## Apartado 1: VLANs
![http://par/assets/cisco-fisico-vlan.png](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/cisco-fisico-vlan.png)
## Apartado 2: Enrutamiento ESTÁTICO
![](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/cisco-fisico-static-route.png)
![](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/cisco-fisico-static-route-result.png)

## Apartado 3: Monitorización de equipos

![](https://raw.githubusercontent.com/luiscastelar/clases23-24/main/par/assets/cisco-fisico-static-route.png)
Configura los equipos R1, R2 y PC4 (windows) para ser monitorizados por Zabbix en PC2 (linux).


# Referencias:
+ [Configuración C880](https://www.networkstraining.com/basic-cisco-800-router-configuration-for-internet-access/)
+ [Configuración inicial - Cisco.com](https://www.cisco.com/c/en/us/td/docs/routers/access/800/hardware/installation/guide/800HIG/initalconfig.html)
+ [Guia básica de config](https://www.cisco.com/c/en/us/td/docs/routers/access/800/software/configuration/guide/SCG800Guide/SCG800_Guide_BookMap_chapter_010.pdf)

+ [Comandos show](https://www.solvetic.com/tutoriales/article/170-comandos-cisco-show/)
+ [documentación de red](https://ccnadesdecero.es/documentacion-red/)
