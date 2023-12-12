#curso23_24 #PAR [estado::Working]



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


# Definición de enlaces troncales en los conmutadores y “routers”. El protocolo IEEE802.1Q.

## Calidad de servicio (QoS - IEEE802.1P)

Priorización de tráfico de control, voz y vídeo (entre otros).

+ [Wikipedia](https://es.wikipedia.org/wiki/IEEE_802.1p)

**Ejercicio**: crear la configuración necesaria para tener un servicio de [voz](https://www.packettracernetwork.com/tutorials/voipconfiguration.html) y [datos](https://community.cisco.com/t5/networking-knowledge-base/sample-configuration-for-voice-and-data-deployment-on-a-switch/ta-p/3123513) [2](https://www.cisco.com/c/es_mx/support/docs/ip/dynamic-address-allocation-resolution/19580-dhcp-multintwk.pdf)

## VLANs de provedores (Q en Q - IEEE802.1ad)

Juntos pero no revueltos... o cuando un proveedor de internet mueve nuestro tráfico y claro, él usa una VLANs para cada cliente y nosotros una para cada departamento.

+ [Wikipedia](https://en.wikipedia.org/wiki/IEEE_802.1ad)


# Switching & bridging en GNU/Linux
+ [bridge](https://www.ithands-on.com/2020/12/networking-101-linux-tap-interface-and.html)


# Ejercicios OBLIGATORIOS
1. Creación de una conexión:
   `pc <-- (vlan 10) --> sw <-- (trunk) --> sw <-- (vlan 10) --> pc` ... y otros PCs de cada lado en la vlan 20.
2. Repetir por grupos de 4 alumnos con 2 C8880 físicos (documentar y defender).
3. STP.
4. VTP y DTP.
5. Link-Aggregation