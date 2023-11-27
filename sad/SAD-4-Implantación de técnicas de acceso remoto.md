  #curso23_24 #SAD [estado:: ToDo] 
{[Page: New]} {[Editor: Toggle Dark Mode]} {[Editor: Toggle Vim Mode]}

# SSH
1. [Aprendiendo SSH parte 1](https://www.youtube.com/watch?v=RMS5zBYQIqA&pp=ygUPc3NoIHBlbGFkbyBuZXJk)
2. [Aprendiendo SSH parte 2](https://www.youtube.com/watch?v=IDDmqlN-hF0&pp=ygUPc3NoIHBlbGFkbyBuZXJk)
3. [Aprendiendo SSH parte 3](https://www.youtube.com/watch?v=ZHSGGG_WwUs&pp=ygUPc3NoIHBlbGFkbyBuZXJk)

### Tarea:
1. Montar un servidor ssh (openssh) y securizarlo...:
    1. Impidiendo el acceso root
    2. Impidiendo el acceso con password

> Off-topic: Docker
       
2. Montar un servidor ssh (openssh) y bastionarlo con:
    1. [2FA](https://www.maquinasvirtuales.eu/bastionado-ssh-con-2fa-y-telegram/)
    2. [Fail2ban](https://www.digitalocean.com/community/tutorials/how-to-protect-ssh-with-fail2ban-on-ubuntu-20-04)

3. Montar un servidor de VPN (Wireguard ~~/ OpenVPN~~)

4. Utilizar clientes de redes `overlay` mediante conexiones mayadas VPN:  Tailscale / Zerotier

5. Montar servidores de redes `overlay` con Headscale / Zerotier-controler


# Docker
En menos de 2 minutos:
1. `curl get.docker.com > get_docker.sh`
2. `bash get_docker.sh`
3. `sudo usermod -aG docker $USER` y `newgrp docker`
4. `docker run hello-world`

## Formato: 
servicio comando [argumentos] imagen [comando [argumentos_de_comando] ]

## Comandos
+ docker pull -> descarga imagen (no necesario salvo para actualizar)
+ docker run -> crea contenedor y lo corre
+ docker rm -> borra contenedor
+ docker exec -> ejecuta comando dentro de contenedor

Ejemplo: \
Sevidor Wireguard con GUI web. *Hacer antes **mapa de red***
```bash
version: "3.3"
services:
 wg-easy:
  container_name: wg-easy
  environment:
   - PUID=1000
   - PGID=1000
   - WG_HOST: 'subdominio.duckdns.org' # también válida la ip pública de vuestro equipo '192.168.40.101' 
   - PASSWORD: '${passwd}' # argumento en archivo '.env'
   - WG_PORT: '${port}' # el puerto del endpoint, no del contenedor
  volumes:
   - ./config:/etc/wireguard
  ports:
   - ${port}:51820/udp # puerto del endpoint. El contenedor SIEMPRE escucha en 51820
   - ${port_web}:51821/tcp # puerto de la interfaz web
  cap_add:
   - NET_ADMIN
   - SYS_MODULE
  sysctls:
   - net.ipv4.conf.all.src_valid_mark=1
   - net.ipv4.ip_forward=1
  restart: unless-stopped
  image: weejewel/wg-easy
```

Archivo de secretos:
```.env
passwd=laQueSeaLargaQueTengaSimbolosNumerosLetras
port=12345
port_web=8080
```



