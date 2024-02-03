#curso23_24 #PSP [estado:: Done] 

# OBJETIVO:
Crear un proyecto que integre el desarrollo completo del módulo formativo (en adelante MF) para verificar la adquisición de aquellas capacidades y resultados de aprendizaje esperables para el mismo.


# Requisitos:
Por lo anterior, es obligatorio el cumplimiento de **TODOS** los requisitos siguientes:
+ Estudio de especificaciones y *backlog* del proyecto. **Entrega 22 de enero**.
+ Planificación (temporal) de actuaciones del *backlog* del proyecto. **Entrega 22 de enero**.
+ “Reunión” semanal para revisión de la planificación. (La mitad del alumnado los viernes, la otra los lunes).
+ Debe solucionar algún problema real propuesto por el alumnado y negociado con el docente. A priori se ofrece la creación del chat de grupo.
+ NO debe contener ningún parámetro “harcodeado”, por lo que se configurará con archivos `properties`.
+ Debe distribuirse de forma sencilla y documentarse el procedimiento de despliegue e implantación.

*Esta lista cubrirá, además de lo anterior, todo lo tratado en el MF hasta el momento. Se requerirá al alumnado la subsanación de las deficiencias detectadas en el trascurso del desarrollo y las “reuniones”.*


# FORMA:
+ Los avances serán entregados y documentados en el github **oficial** del MF.
+ Cualquier incumplimiento de plazos lleva consigo el bloque de uso de equipos informáticos en el aula.


# DESARROLLO:
En vista de los problemas generales observados, realizaremos el desarrollo siguiendo la siguientes fases.

## FASE 1: Realización de un echo cliente servidor [2 puntos]
Esta fase se dividirá en 3 partes:

1. **Servidor** (servlet) que recibe una petición get con los argumentos `usuario` y `texto`, y devolverá `El usr {NOMBRE} dice: {TEXTO}`. Deberéis aportar:
   + Un proyecto IntelliJ con las fuentes necesarias y ningún archivo complilado (.class).
   + El servlet deberá llamarse `Servidor`.
   + archivo README.md con la documentación que estiméis oportuna.
   + Todo irá en la carpeta `REPO/UT7/FASE1`
   + Recuerda, para probarlo harás una petición de tipo: `http://localhost:8080/{PROYECTO}_war_exploded/Servidor?usuario=Luis&texto=Hola`.
    
2. **Cliente** que realiza petición get mandando un parámetro `usuario` y `texto` al servidor (servlet) del profesor.\
   Deberá capturar la respuesta e insertarla en una caja (div) de la página de forma **asíncrona** (AJAX). \
   Deberéis aportar:
   + archivo index.html que contendrá el formulario con el nombre a enviar y la dirección del servidor con el valor por defecto `https://tc.luiscastelar.duckdns.org/fase1/echo`.
   + archivo peticion.js
   + archivo disenho.css
   + Los archivos anteriores irán en la carpeta `webapp`.
   + archivo README.md con la documentación que estiméis oportuna.
   + Todo irá en la carpeta `REPO/UT7/FASE1`
   + *La recepción de los datos es texto plano o html* 

**Importante**: respetar los nombres y rutas pues las verificaciones serán automáticas.



## FASE 2: Almacenamiento de mensajes [1-2 puntos]
Almacenamiento temporal -> 1 punto.

Almacenamiento persistente (bbdd) -> 2 puntos. *Para evitar pérdidas de control de tiempos, sólo se podrá acceder a este punto extra tras haber completado la fase 5. No será valorable en ningún otro caso.*


## FASE 3: Transferencias en JSON [1 punto]
Repetir la fase 1 con transferencias de datos en JSON en ambos sentidos.

El servidor espera 1 objeto por Mensaje con las propiedades `emisor` y `texto`, ambos del tipo cadena.

Podéis generar y trabajar los json manualmente (como cadena de texto) o a través de cualquier librería.


## FASE 4: Actualización de clientes [1-2 puntos]
Los clientes deberán actualizar su registro de mensajes de forma asíncrona.

Si se realiza mediante peticiones periódicas desde el cliente -> 1 punto.

Si se realiza mediante websocket -> 2 puntos. *Para evitar pérdidas de control de tiempos, sólo se podrá acceder a este punto extra tras haber completado la fase 5. No será valorable en ningún otro caso.*


## FASE 5: Despliegue [TUTORIZADO]
Esta fase consistirá en realizar el despliegue de servidor y cliente en un servidor de producción de forma que cualquiera pueda acceder de forma pública desde **internet**.

*Calificable como apto si se realiza y no apto si no se realiza*.


## FASE 6 Mejoras [OPCIONAL]
Esta fase subirá vuestra nota de 7 a 10.




*Los alumnos que NO estáis desarrollando un chat podréis adaptar las 6 fases anteriores a la causística de vuestros proyectos, pero deben cumplir en esencia dichas características. En caso de dudas consultar.*



# EVALUACIÓN:
Esta proyecto tendrá un peso de un 30% sobre cada uno de las UT y por tanto de los resultados de aprendizaje esperables.

Para la evaluación del mismo, se tendrá en cuenta el cumplimiento del 100% de los requisitos con la ponderación de:
+ 50 % desarrollo.
+ 30 % presentación.
+ 20 % documentación.