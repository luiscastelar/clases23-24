#curso23_24 #PAR [estado::Working]


# Configuración CISCO (OFF-TOPIC)
+ Modos CISCO

![Modos de Acceso y Configuración en Cisco - CCNA Desde Cero](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi0.wp.com%2Fccnadesdecero.com%2Fwp-content%2Fuploads%2F2018%2F12%2Fcli-modo-acceso-configuracion-cisco.png%3Fresize%3D768%252C288%26ssl%3D1&f=1&nofb=1&ipt=2d7ed659183f4c1df9c6e2e28b2f232c3a46a490d63c0064d2369abfc2cf5969&ipo=images)

+ Modos de configuración:

![Modos de Acceso y Configuración en Cisco - CCNA Desde Cero](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi0.wp.com%2Fccnadesdecero.com%2Fwp-content%2Fuploads%2F2018%2F12%2Fcli-modos-de-configuracion-en-cisco.png%3Fresize%3D800%252C600%26ssl%3D1&f=1&nofb=1&ipt=57873fe7895b92caec700e3fa6796ad1e0067588c88258be08f2688497cff4c0&ipo=images)
Para que el usuario sepa en todo momento en que modo se encuentra deberá mirar la línea de estado del equipo:

![Modos de funcionamiento de Cisco IOS - CCNA desde Cero](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fccnadesdecero.es%2Fwp-content%2Fuploads%2F2017%2F11%2FEstructura-jer%25C3%25A1rquica-de-los-modos-Cisco-IOS.png&f=1&nofb=1&ipt=de9629e5a061fb93d2ede6fc626cbef2f90193eb8f25b3dea84e754017b3a317&ipo=images)
## Cisco Reference Manual:
[RF - Cisco IOS](https://www.cisco.com/c/en/us/td/docs/ios/fundamentals/command/reference/cf_book.pdf)


## Primeros pasos (de nuevo):
+ [Configurar](https://oscarmaestre.github.io/apuntes_redes/t3_conmutadores/apuntes_t3.html#configuracion-del-conmutador) switch / router:
  + asignando una IP
  + creando un usr/pass para cada puerto de configuración (consola/aux/ssh)

*Nota: la configuración de IP se realiza de forma distinta para `router`s que para `switch`es*.

>
> **IMPORTANTE**:
>
> + Al finalizar el curso todos los equipos **deben** quedar con el password de root en blanco. De cualquier otra forma se considerará como unidad **NO** SUPERADA.
> + Así mismo, la pérdida de credenciales por parte del alumno supondrá considerar la unidad como **NO** SUPERADA.
>


### Guardar / Descartar configuración
```bash
! Guarda configuración para próximo arranque
copy running-config startup-config

! Descarta configuración
copy startup-config running-config

! Programar reinicio en 10 minutos
reload in 10 

! Cancelar reinicio programado
reload cancel

````

# Implantación y configuración de redes virtuales.

+ [Teoría VLANs - PAR.readthedocs.io](https://planificacionadministracionredes.readthedocs.io/es/latest/Tema09/Teoria.html)
+ [Teoría + ejercicios - JM Huertas](https://juanmhalegre.wordpress.com/2012/01/08/ccnp-switch-642-813-official-certification-guide-part-ii-chapter-4-1-virtual-vlans/)
+ [Troncales - JM Huertas](https://juanmhalegre.wordpress.com/2012/01/12/ccnp-switch-642-813-official-certification-guide-part-ii-chapter-4-2-vlan-trunks/)
+ [Otro de teoría - wikibooks](https://es.wikibooks.org/wiki/Planificaci%C3%B3n_y_Administraci%C3%B3n_de_Redes/Tema_9/Texto_completo)
+ [Configuración de VLANs en CISCO](https://oscarmaestre.github.io/apuntes_redes/t5_vlans/apuntes_t5.html)
+ [VLAN - CCNA desde Cero](https://ccnadesdecero.com/curso/vlan/)  


## Administración centralizada de VLANs.
[VLAN - Oscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t5_vlans/apuntes_t5.html#implantacion-y-configuracion-de-redes-virtuales)


### VTP - Virtual Trunk Protocol
+ [VTP - YT:Kalero](https://www.youtube.com/watch?v=DvhtEHUF9Wc)
+ [Oscar Maestre](https://oscarmaestre.github.io/apuntes_redes/t5_vlans/apuntes_t5.html#protocolos-para-la-administracion-centralizada-de-redes-virtuales-el-protocolo-vtp)


# Definición de enlaces troncales en los conmutadores y “routers”. El protocolo IEEE802.1Q.

## Calidad de servicio (QoS - IEEE802.1P)
Priorización de tráfico de control, voz y vídeo (entre otros).
+ [Voice VLAN - Óscar Gerometta](https://librosnetworking.blogspot.com/2019/02/voice-vlan.html?m=1)
+ [Wikipedia](https://es.wikipedia.org/wiki/IEEE_802.1p)

**Ejercicio**: crear la configuración necesaria para tener un servicio de [voz y datos](https://ccnadesdecero.com/curso/vlan-voz/).


### ~~DHCP VoIP~~
[voz](https://www.packettracernetwork.com/tutorials/voipconfiguration.html) y [datos](https://community.cisco.com/t5/networking-knowledge-base/sample-configuration-for-voice-and-data-deployment-on-a-switch/ta-p/3123513) [DHCP - Cisco](https://www.cisco.com/c/es_mx/support/docs/ip/dynamic-address-allocation-resolution/19580-dhcp-multintwk.pdf)


## VLANs de provedores (Q en Q - IEEE802.1ad)
Juntos pero no revueltos... o cuando un proveedor de internet mueve nuestro tráfico y claro, él usa una VLANs para cada cliente y nosotros una para cada departamento.
+ [Wikipedia](https://en.wikipedia.org/wiki/IEEE_802.1ad)
+ [Q in Q - Cisco](https://www.cisco.com/c/en/us/td/docs/switches/datacenter/nexus5600/sw/interfaces/7x/b_5600_Interfaces_Config_Guide_Release_7x/configuring_q_in_q___vlan_tunnels.pdf) y [**2** - Cisco](https://www.cisco.com/c/en/us/td/docs/switches/lan/catalyst4500/12-2/15-02SG/configuration/guide/config/tunnel.html)


# Agregación de enlaces
[LAPD](https://ipwithease.com/understanding-link-aggregation-with-lacp/) y [Etherchannel](https://oscarmaestre.github.io/apuntes_redes/t5_vlans/apuntes_t5.html#etherchannel) (propietario Cisco) 

**Ejercicio:**
Siguiendo el vídeo de Kalero, realizar las adaptaciones necesarias para crear la agregación de los puertos Gi 0/1 y Gi 0/2 de los switch 1 y 2.
+ [Vídeo tutorial](https://www.youtube.com/watch?v=Cgj0nlCys8s)

## Comandos a utilizar:
1. enable
2. conf t
3. int range
4. channel-protocol lacp
5. channel-group 1 mode active *(para el sw1 y pasive para el sw2)*
6. end
7. show etherchannel summary 
8. show etherchannel 
9. show interface etherchannel


# Switching & bridging en GNU/Linux
+ [bridge](https://www.ithands-on.com/2020/12/networking-101-linux-tap-interface-and.html)


# Ejercicios OBLIGATORIOS
1. Creación de una conexión:
   `pc <-- (vlan 10) --> sw <-- (trunk) --> sw <-- (vlan 10) --> pc` ... y otros PCs de cada lado en la vlan 20.
2. Repetir por grupos de 4 alumnos con 2 C880 físicos (documentar y defender).
3. STP.
4. VTP y DTP.
5. Link-Aggregation