#curso23_24 #SAD


# UT6 - Implantación de soluciones de alta disponibilidad. 
19h - 9,5 sesiones - 22/01/2024 26/02/2024 2ª

+ 19e: Kubernetes
  + [x] Instalación 
+ 22e: K2
  + [ ] Introducción.
+ ~~26e: día de la docencia~~
+ 29e: K2
  + [ ] Funcionamiento ininterrumpido.
  - [ ] Integridad de datos y recuperación de servicio.
  - [ ] Servidores redundantes.
+ 2f: K3
  - [ ] Sistemas de “clusters”.
+ 5f: K4
  - [ ] Balanceadores de carga.
+ 10f: K5
  + [ ] Desarrollo de práctica
+ ~~12f: carnavales~~
+ 17f: K6
  + [ ] Desarrollo de práctica
+ 20f:
  + [ ] **PRESENTACIÓN y Defensa UT6**
+ 24f:
  + [ ] **PRESENTACIÓN y Defensa UT6**

---
# UT7 - Legislación y normas sobre seguridad 
2h 27/02/2024 01/03/2024 2ª

+ 26f:
  - [ ] Legislación sobre protección de datos.
  - [ ] Legislación sobre los servicios de la sociedad de la información y correo electrónico.
  - [ ] Normas ISO sobre gestión de seguridad de la información.
  - [ ] Organismos de gestión de incidencias.
---

# Evaluación ORDINARIA

+ Lunes 4 marzo: **EXÁMEN eva ORDINARIA**

---
==**YA VISTO**==

---

# UT1 - Capacitación 
8h - 4 sesiones - Del 15s a 25s

1. 15s:
  * [x] Presentación/Evaluación-calificación
  * [x] FC sobre [[pub23/sad/SAD-1-Capacitación y herramientas| GIT y MD]]
  * [x] Tareas sesión 2 - GIT
  
2. 18s:
  * [x] Presentación de Vagrant
  * [x] FC Vagrant - Documentar
  * [x] Tareas sesión 3 - Vagrant
  * [x] Ejecución de tareas GIT

3. 22s:
  * [x] Ejecución de tareas Vagrant
  * [x] Presentación de virtualización tipo 1, 2 y contenedores. ~~Evolución a orquestación.~~

4. 29s:
  + [x] **Examen UT1**

**Evaluación de la unidad:**
+ Exámen de 29 de septiembre (50%).
+ Tareas (40%):
  + Git de 26 septiembre (50%).
  + Vagrant de 28 de septiembre (50%).
+ Participación en clase (10%).


# UT2 - Adopción de pautas
8h - 4 sesiones - Del 29s al 9o

1. 25s:
  * [x] FC Ver apuntes de *Oscar Maestre*.
  * [x] Ejecución de tareas (entrega 2 oct):
    * [x] disponibilidad
    * [x] SAI
    * [x] Cifrado

2. 2o:
  + [x] Revisión de [[pub23/recordatorios]]
  + [x] Desarrollo de la actividad *en clase* sobre ACL (David 8 bits) sobre máquina en Vagrant.

3. 6o:
  + [x] Desarrollo de la actividad de realización de copias de seguridad de una máquina sobre otra:
    + [x] rsync + tar + cron
    + [ ] ~~restic~~ (*No encajaba*)

4. 23o:
  + [x] Resolución de dudas

5. 27o: 
  + [x]  **Examen UT2**
  + [ ]  restic

**Evaluación de la unidad:**
+ Exámen de 9 de octubre (50%).
+ Tareas (40%):
  + Iniciales (disponibilidad, SAI y cifrado) (20%).
  + ACL (40%).
  + Copias de segurida entre máquinas (virtuales) (40%).
+ Participación en clase (10%).


# UT3 - Instalación y config firewall 
16h - 8 sesiones - 10o-10n

1. 9o:
   + [x] Presentación de firewall de perimetral `pfsense` y local `iptables`
   + [x] Diseño de infraestructura para firewall perimetral (`pfsense`-vm + `vagrant`)
   + [x] Redes:
     + [x] Wan (red pública)
     + [x] Lan (zona-controlada)
     + [x] solo anfitrión

2. 16o:
   + [x] Trabajo sobre esquema de red
3. 20o:
   + [x] Exposición de práctica.
   + [x] Cómo realizar preguntas inteligentes
 
4. 27o:
  + [x] Inicio de práctica

5. 30o:
  + [x] Continuación de la práctica
  + [x] Resolución de dudas UT3, UT2 y UT1

6. 3n:
  + [x] Continuación de la práctica
  + [x] Resolución de dudas UT3, UT2 y UT1

7. 6n:
  + [x] [Postmorten Cloudflare 4nov23](https://twitter.com/weareDMNTRs/status/1720726674495472120)
  + [x] Continuación de la práctica
  + [x] Resolución de dudas UT3, UT2 y UT1

8. 10n:
  + [x] iptables
  + [x] resolución dudas
   
9. 13n:
 + [x] **Entrega/Defensa PRÁCTICA UT3**

**Evaluación de la unidad:**
+ ~~Exámen~~.
+ Práctica (90%):
  + Estructura completa de VM (pfsense + cliente-desktop + 2 clientes-cli) así como la correcta configuración de las distintas redes.
  + DHCP en pfsense
  + Servidor web en cliente-5
  + Acceso desde cliente-6 a cliente-5 y al exterior.
  + Tunel L2TP con credenciales profesor (y manual de configuración de usuario)
  + Tunel Wireguard con credenciales profesor (y manual de configuración de usuario)
  + pfsense - Bloqueo de Youtube a toda la red interna
  + pfsense - Bloqueo de luiscastelar.duckdns.org a toda la red interna excepto al cliente-6 y Permiso de acceso a marca.com a todo la red interna excepto a cliente-4
  + iptables - cliente-5 debe impedir el acceso a cliente-4
    
+ Participación en clase (10%).


# UT4 - Implantación técnicas acceso remoto
16h - 7 sesiones - 13n-11d

+ ~~13n: Defensa UT3~~
+ ~~17n: Examen rec 1ª Evaluación~~
+ 20n:
  + [x] SSH
  + [x] Hardening SSH
+ 24n:
  + [x] Docker
  + [x] Continuación Hardening SSH
+ 27n:
  + [x] Wireguard / OpenVPN
+ 1d:
  + [x] Clientes Tailscale / Zerotier
+ 4d:
  + [x] Docker
+ 11d:
  + [x] Servidores Headscale / Zerotier-controler
+ 15d:
  + [x] Defensa práctica / **Examen UT4**
 
  **Evaluación de la unidad**: ejecución y defensa de la práctica.

  
# UT5 - Instalación y configuración de servidores proxy 
13h - 4,5 sesiones - 12/12/2023 19/01/2024 2ª

+ 18d:
  + [x] Proxy inverso
  + [x] Jornadas Informática castelar (evaluable asistencia y participación)
+ 8e:
  + [x] Proxy inverso
  + [x] Post-mortem caída de Orange
+ 12e:
  + [x] Demostrativo de Proxy socks
  + [x] Continuación proxy inverso
+ 15e:
  + [x] Refuerzo rezagados
+ 19e:
  + [x] **Defensa UT5** 

 **Evaluación de la unidad**: ejecución y defensa de la práctica.