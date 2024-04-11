#curso23_24 #PAR [estado:: Working] 

# Router series 800, 2600 y 2800
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


# Router se-C880

## Reset a fábrica

1. Una vez conectado \
> router <--- cable de consola -> terminal RJ45-to-rs232 <---> cable rs232-to-usb ---> pc

2. Abrir el software de gestión de la consola (putty o `screen /dev/ttyUSB0`).
```bash
sudo dmesg
screen /dev/ttyUSB0 9600
# también con minicom -s
```

Desde Windows con [PuTTY](https://teklager.se/en/knowledge-base/serial-connection-putty-windows/)

    
4. Pulsar el botón de reset trasero.
5. Enchufar el router.
6. Esperar 5-7 segundos y soltar el reset.
7. Esperar el arranque

## Primer acceso

Por defecto, el usuario es ‘cisco’ y el password es ‘cisco’.

## Referencias:
+ [configuración C880](https://www.networkstraining.com/basic-cisco-800-router-configuration-for-internet-access/)


# Cisco IOS
+ [Comandos show](https://www.solvetic.com/tutoriales/article/170-comandos-cisco-show/)
+ [documentación de red](https://ccnadesdecero.es/documentacion-red/)

# Referencias:
+ [Configuración inicial - Cisco.com](https://www.cisco.com/c/en/us/td/docs/routers/access/800/hardware/installation/guide/800HIG/initalconfig.html)
+ [Guia básica de config](https://www.cisco.com/c/en/us/td/docs/routers/access/800/software/configuration/guide/SCG800Guide/SCG800_Guide_BookMap_chapter_010.pdf)