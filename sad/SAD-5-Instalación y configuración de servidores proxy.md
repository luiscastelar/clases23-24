  #curso23_24 #SAD [estado:: Working] 

# Tipos de “proxy”. Características y funciones.
1. Directo (o de reenvío): En la actualidad se utiliza a menudo un proxy dns (resolver, [Pi-hole](https://github.com/pi-hole/docker-pi-hole/) o [adward](https://github.com/AdguardTeam/AdGuardHome/wiki/Docker)) y en situaciones especiales un [servidor de paquetes](https://hub.docker.com/r/soulteary/apt-proxy)
2. Abierto: Es un proxy directo anónimo.
3. **Reverse proxy**: [personalizable](https://github.com/NginxProxyManager/nginx-proxy-manager) o [auto-mágico](https://github.com/lucaslorentz/caddy-docker-proxy)
4. Transparente: es un proxy combinado con la puerta de enlace para hacer pasar por él.


# Instalación de servidores “proxy”.
Vamos a utilizar el reverse proxy [personalizable](https://github.com/NginxProxyManager/nginx-proxy-manager). 

Requeriremos un dominio / subdominio para lo que utilizaremos el servicio [duckdns.org](https://www.duckdns.org/)

# Instalación y configuración de clientes “proxy”.
Proxy socks: 
Operan a nivel de circuito (o red) creando una pasarela entre dos puntos.

1. En la terminal del cliente: `ssh -ND 9999 usr@server`
2. En el configuración del sistema activar el servidor proxy socks en `localhost:9999`

# Proxy socks
Conexión a través de proxy socks. Concretamente queremos conectarnos desde una máquina local como si estuviéramos en remoto.

1. Crear en la máquina local un sock dinámico a la máquina remota: `ssh -ND 9999 usr_remoto@ip_remota`
2. Exportar el proxy sock al sistema: `export http_proxy=socks5://localhost:9999`
3. Utilizar proxy. P.e.: `curl ifconfig.me`
4. Desconectar proxy del sistema: `export http_proxy=`
5. Cerrar túnel ssh (`^c`)

*Nota: Para afianzarlo, lo podemos añadir `.bashrc` para el usuario o a `/etc/environment` para todo el sistema.*

*Nota 2: Si vamos a usarlo esporádicamente... http_proxy=socks5://localhost:9999 curl ifconfig.me`*.

Debemos tener en cuenta el funcinamiento de los navegadores ya que Firefox va independiente de la configuración del sistema de proxy, por lo que deberemos configurarlo a parte o utilizar alguna extensión (p.e. FoxyProxy).


## SSHuttle - VPN over SSH
[DOC oficial](https://sshuttle.readthedocs.io/en/stable/index.html)

`sshuttle \-r username@sshserver 0.0.0.0/0`

# ~~Configuración de filtros.~~
Squid

# ~~Métodos de autenticación en un “proxy”.~~
