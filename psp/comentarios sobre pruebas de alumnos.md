  #curso23_24 #PSP


# UT1 - Programación multiproceso 

1. Runtime.getRuntime().exec(String) está marcado como **deprecated**, no así Runtime.getRuntime().exec(String[] cmdarray), ni otras variantes. \
  *La traducción más correcta a deprecated probablemente sea **discontinuado** u obsoleto.

2. Que no estemos en un sistemas Windows no implica necesariamente que estemos en un sistema Linux, y mucho menos que tengas disponible un **bash**. \
   Para su verificación se recomienda mejor verificar la existencia del binario correspondiente. Desde un shell podríamos verificarlo con `ls /bin | egrep -q "^bash$"` que retornará 0 si existe y 1 en caso contrario. \
   Si vas a verificar que existe `bash`, luego usa `bash`. Si por el contrario vas a utilizar `sh`, usa `sh`. Comprende que no son el mismo shell y no otorgan las mismas funcionalidades.

3. Muy correcto tener en el README.md un apartado de requisitos para su utilización, p.e. Debian, bash, ...
  
4. Puede ser **muy interesante** que en lo sucesivo me dejéis en el README el código exacto que debo copiar y pegar para ejecutar correctamente vuestro programa. P.e.:
   ```bash
   cd RUTA_BASE
   java RUTA_MAIN/Main
   ```

   Con ello me ayudaréis a localizar vuestros ejercicios y os evitaréis sustos o lamentos si no se encuentran donde deberían 

5. No debemos perder el foco de lo que queremos conseguir con el multiproceso / multihilo, esto es, que aquellos procesos que puedan ejecutarse de forma paralela, se independicen del proceso principal.


---
# UT2 - Programación multihilo 
...


# UT3 Comunicaciones de red - Sockets 
...


# UT4 Servicios de red 
...


---
**2ª EVALUACIÓN**

---
# UT5 Java Fx 
...


# UT6 Técnicas de programación segura
...


# UT7 Proyecto integrador 20 22/01/2024 01/03/2024 2ª
...