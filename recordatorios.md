#curso23_24 #PAR #SAD #ED #PSP

Todos los recordatorios son válidos para todo el módulo formativo, salvo cuando se indique expresamente lo contrario. 

El incumplimiento podrá ser motivo de penalizaciones o dar por no entregado, así como apercibimientos oficiales.

**17 de febrero**
+ Sobre la documentación de las prácticas (parte II): La documentación de vuestras prácticas debe permitir que otro técnico reproduzca **exactamente** lo configurado/implementado/desarrollado. Esto es, tan exactamente que debería tener los mismos “aciertos” y errores con el fin de que este otro técnico pueda investigar/mejorar el sistema “fuera de línea” (entorno de laboratorio).
+ Para lograr el objetivo, deberá adjuntarse todos los archivos necesarios (con comentarios si procede), así como un pequeño documento que explique todo lo necesario para utilizar dichos archivos.

**22 de noviembre**
+ Sobre la documentación de las prácticas: cuando en una práctica se os solicita una enumeración de funcionalidades, deberás crear un apartado específico en la documentación para cada una de ellas. Cualquier ausencia de dicho apartado se tomará como no documentado, y por tanto no podrá ser corregido.

**8 de noviembre**
+ Respecto a las correcciones encuentro que debemos recordar algunos términos que a algunos se les olvida:
  1. Si no existe documentación no continúa la corrección ya que “el cliente” no sabe como comenzar.
  2. Si la documentación no refleja algún requisito se entenderá que no ha sido realizado (o no de forma *original)
  3. Si la práctica/examen/tarea arroja errores no gestionados y rompe, el corrector (automático o humano) para ya que no puede evaluar más.
  4. La práctica/examen/tarea debe cumplir con TODAS los requisitos de “el cliente”. Excepcionalmente, “el cliente” puede quedar temporalmente satisfecho si algunos requisitos auxiliares no se cumplen. Ante la duda, consultar a “el cliente”.

**2 de noviembre**
+ Las capturas de salida estándar se realizarán con `tee` o `Tee-Object` como así se indicó el primer día de clase.
+ Únicamente cuando no sea posible se realizarán con el método de realizar captura y subir (siempre con GIT) y asegurándoos de que funcionan mediante ruta relativa al README y no a rutas absolutas respecto a github.

**26 de octubre**
+ No se admitirán [variables ninja](https://es.javascript.info/ninja-code) bajo ninguna circunstancia. Del nombre de las mismas deberá poder inferirse su contenido u utilidad.

**17 de octubre**
+ Todos los días se abre espacio para preguntar dudas y solicitar orientación sobre teoría, ejercicios y prácticas. Si está trabajado, y la pregunta cumple con los [requisitos mínimos de trabajo previo](https://github.com/luiscastelar/clases23-24/blob/main/Como-hacer-preguntas-de-manera-inteligente.png?raw=true) hazla, o se dará por hecho que lo has trabajado y entendido.
    
**2 de octubre**
+ Todos los emails deben llevar un asunto. De otra forma serán automáticamente eliminados (mi gestor de correo lo hace así).

**1 de octubre**
* Estructura del repositorio (_salvo para el módulo de PAR_):
  * Como sabes las correcciones se realizaran sobre el **primer** repositorio del que recibí invitación a colaborar. El resto de repositorios serán completamente ignorados.
  * Dentro del repositorio deberás tener un README.md con tu nombre, email y el nombre del módulo formativo (ED, SAD o PSP).
  * Además crearás una carpeta por cada Unidad de Trabajo y se llamarán UT1, UT2, ... (Si ya las tienes, pero con otros nombres, puedes renombrarlas con p.e. `git mv tema1_tal UT1`).
  * Dentro de cada carpeta de unidad colocarás una carpeta por trabajo entregable (`Practica1`, `Practica2`, ...) o exámen (`EXAMEN`), y otra para `EJERCICIOS`. \
    *No utilices tildes ni `ñ` en los nombres de archivos o directorios, git desde windows la lia parda con ellas*.
  * Dentro de cada carpeta irá un `README.md` con la documentación del trabajo/práctica/exámen, o simplemente informando del contenido de la carpeta.
  * Sólo se corregirá aquellos trabajos donde haya una copia **ZIP** del directorio subida al MOODLE en tiempo y forma. Si además la acompañas con el README correspondiente podremos ambos (tú y yo) saber que contiene el zip sin descargarlo y abrirlo.
* Recuerda que el git de clase así como cualquier documento de entrega obligatorio son documentos **OFICIALES** que serán incluidos a tu expediente académico, usa por tanto lenguaje formal, adecuado y técnico. *No estás en el parque con los amigos*.
![lenguaje no formal](https://luiscastelar.duckdns.org/2023/assets/ED/formas_inadecuadas.png)

**29 de septiembre**
+ RAR es un formato propietario. No se admiten entregas en dicho formato. Utiliza `tar` o `zip` en su lugar


**28 de septiembre**
+ Las capturas de pantalla se realizarán **siempre** con fondo blanco y letras en negro. De otra manera no se visualizarán correctamente en proyecciones ni impresiones en papel. *Cualquier captura sobre fondo negro será ignorada, esto es, no será dada por válida*.
+ Los documentos de texto serán subidos **siempre** en formato de texto plano (markdown, orgmode o txt), salvo que se indique otra cosa (pdf, odt, ...). *Recuerda que GIT sólo puede rastrear archivos de texto plano*.
+ Sobre las versiones de software a utilizar, **siempre** utilizaremos:
  + Por defecto, la versión actual -> P.e: Ubuntu 22.04 LTS o JDK21 LTS.
  + Si estamos probando cosas nuevas, la versión en desarrollo -> P.e.: Ubuntu 23.04 al momento de escribir estas líneas.
  + Si ya está montado (lo que sea), la versión montada si tiene soporte -> P.e: Ubuntu 20.04 LTS o JDK17 LTS.
  + **NUNCA** versiones obsoletas (*deprecated*) -> P.e: Ubuntu 22.10 o JDK 19.
+ Cuando pasas una práctica que “rompe”, es que no te has molestado ni en comprobar “tus fuentes”.
+ No se debe utilizar **root** salvo cuando necesitamos a root. El uso innecesario de root será penalizado con 2 puntos en cada práctica.

