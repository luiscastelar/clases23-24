#curso23_24 #PSP [estado:: ToDo] 

---

# Java Fx
[Visionar](https://www.youtube.com/watch?v=aIAzHzoC2XI&list=PLaxZkGlLWHGUWZxuadN3J7KKaICRlhz5-&index=1)

## Ejercicio completo:
[Ejercicio completo - oracle](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/javafx_con_javaee_tutorial/javafx_javaee7.html)

## Enlaces de interés:
- [Scene Builder](https://gluonhq.com/products/javafx/)
+ [curso JavaFx](https://www.youtube.com/@aulaenlanube/videos)


# Java EE y Jakarta EE

## Introducción

La Fundación Eclipse asumió en 2017 el proceso de desarrollo y estandarización de Java EE. A partir de ese momento y por motivos de derechos de nombres, Java EE pasa a denominarse Jakarta EE.

Jakarta EE se asienta sobre Java SE y lo desarrolla hacia la web, el ámbito empresarial y el acceso a datos (bases de datos).

De Java EE a Jakarta EE:
+ Oracle cede EE a la Fundación Eclipse, pero se queda con el nombre Java por lo que la fundación debe cambiarle el nombre.
+ Todas las librerías pasan de `javaee` a `jakartaee`.

**Importante**: 
+ Apache **Tomcat 9**.0 implements the Servlet 4.0 and JavaServer Pages 2.3 (especificación de **Java EE9**).
+ Apache **Tomcat 10**.1 implements the Servlet 6.0 and JavaServer Pages 3.1 [specifications](https://cwiki.apache.org/confluence/display/TOMCAT/Specifications) from [**Jakarta EE**](https://jakarta.ee/)

## Referencias:
+ [Jakarta EE Tutorial OFICIAL](https://eclipse-ee4j.github.io/jakartaee-tutorial/)
+ [Jakarta EE 10 - Presentación OFICIAL](https://docs.google.com/presentation/d/1LBjjJg64j0HjmFu6m3EApN--mkavemyPFMUobIbGZds/edit#slide=id.g14a74e03a56_1_512)
+ [Java EE 5 - Tutorial Oficial](https://docs.oracle.com/javaee/5/tutorial/doc/bnaay.html)

## Overview (sumario)

Tecnologías que incluye:

![overview](https://i.stack.imgur.com/nhqhL.png)

+ Modelo 2 capas: cliente - datos

![2 capas](https://www.oracle.com/a/tech/img/jsp-model1-architecture.gif)

+ Modelo 3 capas: cliente - servidor - datos

![3capas](https://1.bp.blogspot.com/-3R59o3dfKUo/YUaymO4CqeI/AAAAAAAAJGI/v67X9I_U0YciAvjXbC_DlG9AHDOGKVcjgCLcBGAsYHQ/s16000/jsp-servlet-mvc-diagram.png)
![modelo-vista-controlador](https://www.oracle.com/a/tech/img/jsp-model2-architecture.gif)
  
+ Modelo 4 capas: cliente - contenedor web - lógica de negocio - datos.

![Simplified layers](https://i.stack.imgur.com/OpWgt.png)

Nosotros vamos a utilizar MVC:
+ VISTA: Capa cliente con Java SE o Web Browser (html + js).
+ CONTROLADOR: `Servlet` para la gestión y la llamadas a clases y objetos.
+ MODELO: clases y objetos de acceso a BBDD.
  
![Tutorial-mvc.png](https://www.zkoss.org/_w/images/7/75/Tutorial-mvc.png)

**Notas:**
* <a name=”fn1”></a>La tecnología JSP está marcada como obsoleta y se desaconseja su uso para nuevas aplicaciones frente a JSF. Pese a ésto, el número de aplicaciones en funcionamiento y su simplicidad se hace ideal para introducirnos en el mundo de Jakarta EE.

# VISTA:
La vamos a crear con HTML + jQuery.

## La estructura - HTML:
```html
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Aquí más cabezeras 
    [1]
    [2]
    -->
</head>
<body>
    <!-- Aquí el contenido de la web
    [3]
    -->
</body>
</html>
```

Responde a estas preguntas:
1. ¿Para qué el !DOCTYPE?
2. ¿Porqué el charset?

## *Un poco de estilo - CSS - [1]*
Cargamos la hora de estilo con `<link rel="stylesheet" href="mystyle.css" \>`.

Donde mystyle.css:
```css
        .div-center {
            position: absolute;
            left: 50%;
            top: 40%;
            transform: translate(-50%, -50%);
        }
		form { 
			border: solid .3px black;
			padding: .5em;
		}
		#pie {
			border: solid .8px black;
			padding: 1em;
            margin-button: 5em;
		}
```

## El contenido - HTML - [3]:
```html
<div class="div-center" id="calculadora">
	<h1>Obtener datos:</h1>
    <form>
        <label for="texto">Texto a enviar:</label><br />
        <input type="text" id="expresion" value="Quiero un saludo"/>
    </form>
	<button id="borrar">Borrar</button>
	<button id="txt">En html</button>
	<button id="json">En json</button>
    <div id="pie">&nbsp;</div>
</div>
```

Creamos un bloque (id=”*calculadora*“) que centramos con css. 

Este bloque contiene:
1. Un título (sólo texto).
2. Un formulario con datos para enviar.
3. 3 botones que le daremos “vida” con js.
4. Un bloque (id=”*pie*“) vacío que utilizaremos para insertar datos con js.

## La lógica de control - jQuery (js) - [2]:
Primero debemos cargar la librería con `<script src="https://code.jquery.com/jquery-latest.js"></script>`

Posteriormente pasamos a utilizarla con un archivo js `<script src="myScript.js">`, donde myScript.js es:
```js
$(document).ready(function() {
    // Que hacer cuando esté lista la página
    // [2a]
    // [2b]
    // [2c]
}); // document ready
```

### Borrar datos - [2a]:
Dentro del `ready(function() {..});`:
```js
    $('#borrar').click(function(event) {
        $('#pie').html('');
    });
```

Capturamos el botón *borrar* y llamamos a una función anónima realiza la función que le hemos pedido, eliminar el contenido del bloque *pie*.

### get() - Obtener - [2b]:
Dentro del `ready(function() {..});`, además de [2a] también añadiremos procesamiento para el botón *txt*:
```js
    $('#txt').click(function(event) {
        let varExpresion = $('#expresion').val();
        $.get('https://luiscastelar.duckdns.org/holaMundo.txt', 
                { datos : varExpresion }, 
                function(responseText){
            $('#pie').html(responseText);
        });
    });
```

1. Capturamos el texto que queremos mandar al servidor.
2. Invocamos al método `get()` al que le pasamos:
   + [URL destino](https://i.pinimg.com/originals/97/8a/27/978a2735735348c2e5fbbe01f836fdbd.png)
   + string, objeto plano (js), también llamado [JSON](https://es.wikipedia.org/wiki/JSON) [opcional]
   + success function [opcional]: función cuando ha acabado el evento asíncrono.\
      Nosotros la aprobechamos para capturar la respuesta e insertarla en el bloque *pie*.
   + dataType (Type: String) [opcional]: xml, json, script, text, html. \
      No lo usamos ya que si utilizamos cualquiera de los anteriores el método lo inferirá.

### get() - Obtener de una API - [2c]:
```js
    $('#json').click(function(event) {
        // Capturamos valor
        let varExpresion = $('#expresion').val();
        
        // Generamos json para transmitir datos [es opcional]. Podríamos pasarlo en el search de la URL
        let jsonExpresion = { expresion: varExpresion }
        
        // Generamos la URL [opcional]. Podríamos pasar directamente el string con la URL
        const PROTO = "https";
        const FQDN = "luiscastelar.duckdns.org";
        const PORT = ""; // [:8080]
        const PATHNAME = "/holaMundo.json";
        const SEARCH = ""; // [?exp=2+2++]
        const HASH = ""; // [#hash] -> Típicamente para ayudar a ajax a ubicar la peticion
        const url = new URL(PROTO + "://" + FQDN + PORT + PATHNAME + SEARCH + HASH);
        
        // Hacemos la llamada. Si no vamos a enviar datos podemos omitir [, jsonExpresion]
        $.getJSON(url, jsonExpresion, function( data ) {
        
            // Recorremos todos los datos obtenidos y los asignamos al array items
            let items = [];
            $.each( data, function( key, val ) {
            items.push( "<li id='" + key + "'>[" + key + "]=> " + val + "</li>" );
            });
            
            // Serializamos el array items y lo insertamos en nuestro bloque pie
            $("#pie").html("<ul>" + items.join("") + "</ul>");
            
        }); // $.getJson
    }); // $.json
```


# CONTROLADOR:
Servlet HolaMundo:
```java
package com.ejemplo;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "com.ejemplo.MiServlet", value = "/miRuta")
public class MiServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<h1>Hello World</h1>");
    }
}
```

Debemos crear un proyecto de tipo Jakarta EE por lo que requeriremos IDEs que integren las APIs de Jakarta.

### Métodos principales:
+ `init()`: es llamado una sola vez, al iniciar el servlet.
+ service():
  + `doGet()`:
  + `doPost()`:
  + Otros: `doPut()` o `doDelete`.
+ `destroy()`: es llamado una sola vez, al apagar el servlet.

### Referencias:
+ [tutorial servlets](https://codegym.cc/es/groups/posts/es.255.tu-primera-aplicacion-usando-servlets-de-java)
+ [API - tomcat](https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpServlet.html)

## Despliegue:
Para el despliegue con docker, tras obtener un `war` con nuestro servlet y TODAS las librerías requeridas, deberemos ubicarlo en el directorio `./aplicaciones` y el CONTENEDOR DE APLICACIONES `tomcat`, que realizará el despliegue correspondiente.

Si nuestro `war` se llama `app.war` podremos acceder a nuestra aplicación en `localhost:8888/app/misRuta`

**compose.yml**:
```yaml
version: '3.3'
services:
  tomcat:
    image: tomcat:10
    ports:
      - 8888:8080
    container_name: tomcat
    volumes:
      - ./aplicaciones:/usr/local/tomcat/webapps
```

# MODELO:
En módulo formativo == ACCESO A DATOS ==.