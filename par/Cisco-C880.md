#curso23_24 #PAR [estado:: Working] 

# Reset a fábrica

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


## Cisco IOS
+ [Comandos show](https://www.solvetic.com/tutoriales/article/170-comandos-cisco-show/)
+ [documentación de red](https://ccnadesdecero.es/documentacion-red/)
+ 

## Referencias:
+ [Configuración inicial - Cisco.com](https://www.cisco.com/c/en/us/td/docs/routers/access/800/hardware/installation/guide/800HIG/initalconfig.html)
+ [Guia básica de config](https://www.cisco.com/c/en/us/td/docs/routers/access/800/software/configuration/guide/SCG800Guide/SCG800_Guide_BookMap_chapter_010.pdf)