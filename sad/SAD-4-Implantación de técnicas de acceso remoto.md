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

3. Montar un servidor de VPN (Wireguard / OpenVPN)

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

Ejemplo: 
```bash
docker run --rm \
  --cap-add sys_module \
  --cap-add net_admin \
  -e PUBLIC_IP=1.2.3.4 \
  -e PORT=55555 \
  -e DNS=8.8.8.8 \
  -e SUBNET=10.88 \
  -e SUBNET_PREFIX=16 \
  -e SUBNET_IP=10.88.0.1/16 \
  -v ./wireguard:/etc/wireguard \
  -p 55555:55555/udp \
  denisix/wireguard
```

Puff que pereza... ¿pero no hay una forma más sencilla? Pues sí con [`docker compose`](https://hub.docker.com/r/denisix/wireguard)


