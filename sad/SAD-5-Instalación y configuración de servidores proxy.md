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

# Configuración de filtros.
Squid

# Métodos de autenticación en un “proxy”.
