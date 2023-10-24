
#curso23_24 #PSP [estado:: Working] 

## Teoría básica de sockets
[apuntes - Luis Del Moral](https://github.com/ldmoral1987/temario-psp-dam/blob/main/UA3-Programacion%20comunicaciones%20en%20red.pdf) (páginas 3 a 5)

## Herramientas
Como herramienta básica utilizaremos `netcat` o `nc` , herramienta para la apertura de `sockets` *TCP* o *UDP*.

Para abrir una conexión TCP en modo `listen` en el `puerto` 1234, o crear un “servidor” escribiremos `nc -l -p 1234`.

Para abrir una conexión en modo “cliente” escribiremos `nc HOST PUERTO`, donde HOST será un `FQDN` o `IP`

+ [referencia para windows](https://www.configserverfirewall.com/windows-10/netcat-windows/)

### Ejercicios:
Crea un cliente-servidor TCP y otro UDP.

## Desarrollo
[apuntes - codeandcoke.com](https://psp.codeandcoke.com/apuntes:sockets)

# Referencias
+ [Doc Oficial de Red en Java21](https://docs.oracle.com/en/java/javase/21/core/java-networking.html#GUID-82A738CB-2A1C-4AC8-B9DA-C4543D398B51)
+ https://github.com/joseluisgs/ProgServiciosProcesos-00-2022-2023
+ https://oscarmaestre.github.io/servicios/index.html
+ https://github.com/ldmoral1987/temario-psp-dam 
+ https://psp.codeandcoke.com
+ https://github.com/socketio/chat-example
  