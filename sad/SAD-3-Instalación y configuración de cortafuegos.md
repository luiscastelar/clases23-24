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

*Recuerda:* Si lo hacemos y defendemos con tiempo nos ahorramos el exámen... 

Dado que el sistema es complejo, la defensa se realizará vía presentación a los compañeros, por lo que deberéis preparar una presentación, diapositivas, pruebas y memoria.


## Referencias
**pfsense**
+ [Curso pfsense - youtube Wilmer Almazan](https://www.youtube.com/playlist?list=PLuMd8fg3qBxflEQOl0N2QKlYaUgD26Jvs)
+ [Doc oficial](https://docs.netgate.com/pfsense/en/latest/nat/index.html)

**iptables**
+ [firewall sencillo - Jose Domingo](https://fp.josedomingo.org/seguridadgs/u03/iptables.html)
+ [FireWall con IpTables - Manuales LuCAS](http://es.tldp.org/Manuales-LuCAS/doc-iptables-firewall/doc-iptables-firewall.pdf)
+ [NAT con iptables - Alberto Molina](https://albertomolina.wordpress.com/2009/01/09/nat-con-iptables/)
+ [Cortafuegos con iptables - Alberto Molina](https://albertomolina.wordpress.com/2011/12/08/cortafuegos-con-iptables/)