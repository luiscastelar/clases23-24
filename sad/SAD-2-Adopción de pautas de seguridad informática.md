#curso23_24 #SAD [estado:: Done] 

## =={casa}== 
1. Revisar ***[Apuntes de Oscar Maestre](https://oscarmaestre.github.io/apuntes_sad/tema_pautas_seguridad_informatica/tema_pautas_seguridad_informatica.html)***
2. Plantear la solución de todos los ejercicios propuestos en esta unidad.


## Clase:
### Disponibilidad:
**Ejercicio**: Si un año tiene 365 días, calcular cuanto tiempo podría estar como "no disponible" cada uno de los sistemas con disponibilidad:
  * 99 %
  * 99,9 %
  * 99,99 %
  * 99,999 %


### Amenazas:
* [Ejemplo CVE W11 SE](https://support.microsoft.com/es-es/topic/kb5028407-c%C3%B3mo-administrar-la-vulnerabilidad-asociada-con-cve-2023-32019-bd6ed35f-48b1-41f6-bd19-d2d97270f080)
+ [Amenazas TEMPEST](https://armada.defensa.gob.es/archivo/rgm/2016/12/rgmdic2016cap11.pdf)
+ **SQL Injection**:
  + [Escaner](https://pentest-tools.com/website-vulnerability-scanning/sql-injection-scanner-online)
  + [Simulador de SQL injection](https://www.hacksplaining.com/exercises/sql-injection)
  + [Otro simulador](https://www.codingame.com/playgrounds/154/sql-injection-demo/sql-injection)
+ JS Injection: modificación de la web del lado de cliente.

En líneas generales, ningún programa web debe confiar en lo que escriben sus usuarios.


### Amenazas lógicas.
* Ataques a nivel de red IP. P.ej ataques de tipo:
  * Spoofing + Phishing
  * MITM.
* A nivel de SO. Buffer overflow (*poco probable*). **Errores humanos** o **malas intenciones**.
* A nivel de aplicación. Un problema muy común es el SQL/HTML/JS injection y/o los errores humanos que provoquen fugas de datos.
* Malware:
  * spyware
  * ransomware
  * virus
  * DoS y DDoS.


## SAI
Los equipos informáticos y sólo éstos deben ir conectados al enchufe **rojo**, el resto al blanco.
![base enchufes](https://static-blogs.lasprovincias.es/wp-content/uploads/sites/47/2015/09/Foto-enchufes5-300x180.jpg)
*Asegurarse que **NADIE** conecte radiadores o calefactores a él*.

**Ejercicio**: Calcula los requisitos que ha de cumplir el SAI que proteja:
  * Tu puesto de trabajo.
  * El del aula.


## CRIPTOGRAFÍA
* Simétrica:
  * Mensaje + clave = Mensaje cifrado
  * Mensaje encriptado + clave = Mensaje original
 
* Asimétrica:
  * Mensaje + clave pública = Mensaje cifrado
  * Mensaje encriptado + clave privada = Mensaje descifrado
  * Mensaje + clave privada = Mensaje firmado
  * Mensaje firmado + clave pública = Autenticación
 
**Ejemplo de uso asimétrico:** autenticación con parejas de llaves:

![public key](https://www.foxpass.com/hubfs/SSHkeydiagram.png)

**Ejercicio gpg**:  
Por parejas deberéis:
1. Generar llaves.
2. Intercambiar llaves **públicas**.
3. Cifrar, con GPG, un archivo de texto sencillo.
4. Enviar a tu compañero.
5. Tu compañero deberá descifrarlo con su llave privada.

## ACL - Listas de Control de Acceso
Realizar los ejercicios guiados de los apuntes de *Maestre*.

Referencias: [David 8 bits](https://www.ochobitshacenunbyte.com/2019/02/07/listas-de-control-de-acceso-acl-en-linux/) y [Linux training](https://linux-training.be/funhtml/ch34.html).

## Políticas de contraseñas
Ejercicio: Establecer una política de contraseñas de 8 caracteres con, al menos, una mayúscula, una minúscula, un dígito y un carácter especial. Además no puede contener la palabra `pass` ni `Pass`.

Referencias: [David 8 bits](https://www.ochobitshacenunbyte.com/2019/03/26/crear-politicas-de-contrasenas-en-linux/)

## ~~Políticas de almacenamiento~~ => NO

## Copias de seguridad e imágenes de respaldo
+ TAR + rsync + cron => Sin encriptar. 
+ [restic](https://restic.readthedocs.io/en/stable/) => Múltiples repositorios y respaldo encriptados, incrementales y sin duplicados.


## Prácticas:
Define el `Vagrantfile` y todos los scripts que veas necesario de forma que se cumplan las siguientes premisas:
1. Dentro el `home` del usuario `luis` del `host A` deberás crear el directorio `clientes` que deberá ser accesible para lectura por el usuario `pedro` y para lectura y escritura por el usuario `juan`.
2. Copias de seguridad:
   + Realiza un sistema automático que realice copias de seguridad diarias de un `host A` con **tar + rsync + cron** sobre un `host B`. Debe guardar el directorio `/home` y `/etc`.
   + Repite las copias con **restic + cron** sobre un `host C`.
  
*Nota: asegúrate que TODO funciona según las especificaciones.*