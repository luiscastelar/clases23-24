#curso23_24 #SAD


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
 + [ ] **Entrega/Defensa PRÁCTICA UT3**

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

---

**Exámen recuperación 1ª evaluación**

  
---
**2ª EVALUACIÓN**

---
# UT4 - Implantación técnicas acceso remoto
16h - 8 sesiones - 13n-11d


---
# UT5 - Instalación y configuración de servidores proxy 
12h - 6 sesiones - 12/12/2023 19/01/2024 2ª

---
# UT6 - Implantación de soluciones de alta disponibilidad. 
18h - 9 sesiones - 22/01/2024 26/02/2024 2ª

---
# UT7 - Legislación y normas sobre seguridad 
2h 27/02/2024 01/03/2024 2ª

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


---
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

