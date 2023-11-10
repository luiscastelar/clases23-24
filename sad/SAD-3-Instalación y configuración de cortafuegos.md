#curso23_24 #SAD [estado:: Working] 


## pfSense e ipTables

![diagrama de red](https://luiscastelar.duckdns.org/2023/assets/SAD/UT3-pfsense-practica.png)
Dado el diagrama deberás montar la infraestructura que nos permita jugar con él.

1. [ ] Para ello crearemos una máquina virtual con recursos limitados donde instalaremos pfsense.
2. [ ] Además, crearemos un `Vagrantfile` que añada 3 máquinas en una red interna (`zona_controlada`), una con entrono gráfico para la configuración de pfsense y otra no.
3. [ ] Recuerda que deberás modificar la red de dichas máquinas una vez levantadas de NAT a `host_only` de forma que las máquinas del Vagrantfile puedan comunicarse entre sí y con el firewall a través de la red `zona_controlada` y con el HOST a través de la red `host_only`, pero no con el exterior.
4. [ ] La máquina `Cliente-4` será la que tenga entorno gráfico y le deberéis asignar una ip de forma estática para comenzar la configuración de pfsense.
5. [ ] La máquina `Cliente-5` deberá tomar la ip por dhcp de que lo activemos en el pfsense. En esta máquina nos aseguraremos que tiene instalado `iptable`s, ya que le crearemos filtros posteriormente. Así mismo, instalaremos un `nginx` a través de `docker`, por lo que este último también deberá estar instalado.
6. [ ] En `Cliente-5` crearéis un index.html con vuestro nombre y apellidos. Éste será accesible desde todas las máquinas de la LAN.
7. [ ] La máquina `Cliente-6` deberá tener las herramientas `ping`, `curl` y `wget`, que utilizaremos para sondear a `Cliente-5` y sitios en el exterior.
8. [ ] En pfsense levantaremos un túnel VPN por L2TP. Generaréis las credenciales necesarias para que el profesor pueda acceder (desde el aula) y visualizar el `index.html`
9. [ ] También levantaremos un túnel VPN por Wireguard. Igual que el anterior.
10. [ ] Documenta el sistema

*Recuerda:* Si lo hacemos y defendemos con tiempo nos ahorramos el examen... 

Dado que el sistema es complejo, la defensa se realizará vía presentación a los compañeros, por lo que deberéis preparar una presentación, diapositivas, pruebas y memoria.

## iptables

Ejemplo de script para banear acceso a ciertos dominios: 
<details>

```bash
#!/bin/bash
#
# 	MOSTRAR REGLAS:
# sudo iptables -L -v -n --line-numbers
# sudo iptables --line-numbers -n -L OUTPUT
#
#	BLOQUEAR:
# sudo iptables -A OUTPUT -d 34.147.120.111 -j DROP
# sudo iptables -A OUTPUT -d marca.com -j DROP
#
# 	BORRAR REGLA:
# sudo iptables -D OUTPUT 1
#
# Dialog: https://linuxcommand.org/lc3_adv_dialog.php
#---------------------------------------------------------------------------------------

declare -a banearSalida=(marca.com as.com)

while true; do
	echo "MENÚ"
	echo "  Pulsa 1 para banear webs"
	echo "  Pulsa 2 para borrar filtros"
	echo "  Pulsa 3 para mostrar filtros"
	echo "  Pulsa cualquier otra tecla para salir"
	read selection

  case $selection in
    1 )
	for i in "${!banearSalida[@]}"; do
		IP="${banearSalida[$i]}"
		echo "Se banea a [$i] que tiene la IP: $IP"
		sudo iptables -A OUTPUT -d $IP -j DROP
	done
	;;
    2 )
	n=$(sudo iptables --line-numbers -n -L OUTPUT | wc -l )
	for(( i=2; i<$n; i++)) do
		#sudo iptables --line-numbers -n -L OUTPUT
		sudo iptables -D OUTPUT 1
	done
	;;
    3 )
	sudo iptables -L OUTPUT -v -n --line-numbers
	;;
    * )
	echo "Adios"
	exit 0
	;;
  esac
done
```

</details>

Podremos jugar con las cadenas (INPUT - OUTPUT) y las direcciones fuente/destino (-s / -d), así como las políticas (ACCEPT / DROP).

Se recomienda comenzar estableciendo las políticas por defecto, p.e.:
```bash
# Set default chain policies
iptables -P INPUT DROP
iptables -P FORWARD DROP
iptables -P OUTPUT ACCEPT
```

Por último, también podremos filtrar por puertos, p.e.: `iptables -I INPUT -p tcp --dport 22 -j ACCEPT`

## Referencias
**pfsense**
+ [Curso pfsense - youtube Wilmer Almazan](https://www.youtube.com/playlist?list=PLuMd8fg3qBxflEQOl0N2QKlYaUgD26Jvs)
+ [Doc oficial](https://docs.netgate.com/pfsense/en/latest/nat/index.html)
+ [Configuración L2TP/IPsec](https://www.redeszone.net/tutoriales/vpn/pfsense-configurar-servidor-vpn-l2tp-ipsec/)
+ [Configuración Wireguard](https://www.redeszone.net/tutoriales/vpn/configuracion-servidor-vpn-wireguard-pfsense/)

**iptables**
+ [firewall sencillo - Jose Domingo](https://fp.josedomingo.org/seguridadgs/u03/iptables.html)
+ [FireWall con IpTables - Manuales LuCAS](http://es.tldp.org/Manuales-LuCAS/doc-iptables-firewall/doc-iptables-firewall.pdf)
+ [NAT con iptables - Alberto Molina](https://albertomolina.wordpress.com/2009/01/09/nat-con-iptables/)
+ [Cortafuegos con iptables - Alberto Molina](https://albertomolina.wordpress.com/2011/12/08/cortafuegos-con-iptables/)

**redes virtualBox**
+ [Todo sobre redes - NAKIVO](https://www.nakivo.com/blog/virtualbox-network-setting-guide/)
