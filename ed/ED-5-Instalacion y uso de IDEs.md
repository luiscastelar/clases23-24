#curso23_24 #ED [estado:: ToDo] 


# Con IDE
Instalación y uso de entornos de desarrollo:
+ [x] Funciones de un entorno de desarrollo.     
    + [x] **Automatización de la edición de código**: Los lenguajes de programación tienen reglas sobre cómo estructurar instrucciones. Dado que un IDE conoce estas reglas, contiene muchas funciones inteligentes para escribir o editar automáticamente el código fuente. *P.e.: inicio automático de proyecto => generación de clases y main()*.
    + [x] **Resaltado de sintaxis**: Un IDE puede dar formato al texto escrito haciendo que algunas palabras aparezcan en negritas o itálicas, o utilizando diferentes colores de fuente. Estas pistas visuales hacen que el código fuente sea más legible y dan retroalimentación instantánea sobre errores sintácticos accidentales.
    + [x] **Finalización de código inteligente**:    Varios términos de búsqueda aparecen cuando comienza a escribir palabras en un motor de búsqueda. De manera similar, un IDE puede proponer sugerencias para completar una instrucción de código cuando el desarrollador comienza a escribir. *E incluso desarrollo de código mediante IA, p.e. GH Copilot*.
    + [x] **Refactorización del soporte**: La refactorización de código es el proceso de reestructuración del código fuente para hacerlo más eficiente y legible sin tener que cambiar su funcionalidad central. Los IDE pueden autorefactorizarse hasta cierto punto, lo que permite a los desarrolladores mejorar su código de forma fácil y rápida. Otros miembros del equipo entienden el código legible con mayor rapidez, lo que respalda la colaboración dentro del equipo. *Obteniendo **GREEN CODE**.*
    + [ ] **Automatización de la creación local**: Los IDE aumentan la productividad de los programadores, pues realizan tareas de desarrollo recurrentes que por lo general son parte de todos los cambios de código. Estos son algunos ejemplos de tareas de codificación regulares que lleva a cabo un IDE.
    + [ ] **Compilación**: Un IDE compila o convierte el código en un lenguaje simplificado que el sistema operativo puede entender. Algunos lenguajes de programación implementan la compilación “justo a tiempo”, donde el IDE convierte código legible para los humanos en código para máquinas desde el interior de la aplicación.
    + [ ] **Pruebas**: El IDE permite a los desarrolladores automatizar pruebas de unidades localmente antes de integrar el software con el código de otros desarrolladores; también se llevan a cabo pruebas de integración más complejas. *Lo trataremos en la Unidad 6*
    + [ ] **Depuración**: La depuración es el proceso de corregir todos los errores o fallas revelados en las pruebas. Uno de los aspectos más valiosos e importantes de un IDE para fines de depuración es el hecho de poder seguir el código, línea por línea, conforme se pone en marcha e inspeccionar el comportamiento del código. Los IDE también integran varias herramientas de depuración que destacan las fallas provocadas por errores humanos en tiempo real, incluso mientras el desarrollador está escribiendo. *Algunos TIPs*.
Fuente: [aws](https://aws.amazon.com/es/what-is/ide/)

+ [x] Instalación de un entorno de desarrollo.
+ [x] Uso básico de un entorno de desarrollo.
+ [ ] Personalización del entorno de desarrollo: temas, estilos de codificación, módulos y extensiones, entre otras.
+ [x] Edición de programas.
+ [x] Generación de ejecutables en distintos entornos.
+ [ ] Herramientas y automatización.

## Sin IDE (A mano)
1. [x] ejecutando scripts con `java`
2. [x] javac + java
3. [x] `package` -> `javac -d ./ ArchivoClase.java && java package.ArchivoClase`
4. [x] creación de `jar`‘s: `jar cfve Main.jar org.example.Main org/example/\*.class` 
5. [x] ejecución de `jar`: `java -jar Main.jar`
6. [ ] importación de clases: `java -cp "A.jar:B.jar:bin-folder" your.main.class.Here` (sustituir “:“ por “;“ en windows).
7. [x] firmado de `jar`: 
    ```bash
    # Generar auto-certificado
    keytool -genkey -alias firmacontrato -keystore AlmacenClaves -keyalg rsa -storepass 1234567

    # Firmar archivo
    jarsigner -keystore AlmacenClaves -signedjar ArchivoFirmado.jar Main.jar firmacontrato

    # Verificarlo
    jarsigner -verify -verbose Main.jar 
    jarsigner -verify -verbose ArchivoFirmado.jar 
    jarsigner -verify -verbose -certs ArchivoFirmado.jar 

    # Ejecutarlo
    java -jar ArchivoFirmado.jar 

    ```

8. [x] creación de jar con lib externa(jdbc) mediante IDE.
9. [ ] creación de `war`‘s -> se puede... pero no merece. Lo habitual es hacerlo con IDE, Maven o Gradle.
10. [ ] ejecución de `war` -> dentro del directorio `aplicacion` de tomcat


## Jar con jdbc - Paso a paso

La idea es que lo intentéis ejecutar paso a paso para ver que errores nos va dado.
1. **Nos arroja que no tiene driver:** \
Dentro del archivo `pom.xml` de un proyecto maven, justo antes del `</project>`:
```xml
    <dependencies>
        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>

    </dependencies>
```

Después se hace click sobre el icono de recargar maven y ya podremos utilizar el driver sin problemas.

2. **Nos dice que no tienen conexión** \
Los datos de conexión a la bbdd son:
+ host: `luiscastelar.duckdns.org`
+ puerto: `45682`
+ socket: `luiscastelar.duckdns.org:45682`
+ user: `alumno`
+ pass: `alumno`

También podéis levantar vuestro propio servidor...mediante docker compose. Archivo `compose.yml`:
```yaml
version: '3.3'
services:
  mysql:
    ports:
      - 3306:3306
    volumes:
      - ./datos:/var/lib/mysql
    environment:
      - MYSQL_ROOT_PASSWORD=${R_PASS}
      - MYSQL_USER=${USER}
      - MYSQL_PASSWORD=${PASS}
      - MYSQL_DATABASE=dbDefault
    image: mysql:latest

```

Con el archivo de secretos `.env`:
```.env
R_PASS=1234
USER=usr
PASS=pass
```
 
4. **Nos dice que no hay tabla**: \
>
>  **Sólo para los que la tenéis en local**: Debemos importar el archivo donde inicializamos los datos.
> 
> Para ello deberemos cargar el archivo. Existen muchas formas de realizarlo, pero la más sencilla será mediante la ejecución del siquiente comando: `cat datos.sql | docker exec -i NOMBRE_CONTENEDOR mysql -uusr -ppass --`
>
> Donde deberemos poner el nombre del contenedor generado, normalmente DIRECTORIO-MYSQL-1.
> No debéis dejar espacio entre el -p y el password ya que daría error.
> Los dos guiones “--” indican que debe tomar la entrada de la salida del comando anterior (cat datos.sql).
>

Donde `datos.sql`:
```sql
#-- seleccionamos db
USE dbDefault;
#-- creamos tabla personas
CREATE TABLE personas(id SERIAL,
                      nombre VARCHAR(20),
                      edad INT(11),
                      PRIMARY KEY( id )
);

#-- insertamos datos de ejemplo
INSERT INTO personas (nombre, edad) VALUES ('Pedro', 25), ('Juani', 30);
```

5. Proyecto Java:

  - Main.java:
```java
package org.example;

public class Main {
  public static void main(String[] args) {
    Conexion conn = new Conexion();
    String sql = "SELECT * FROM personas;";
    conn.select( sql );
  }
}
```

  - Conexion.java:
```java
package org.example;

import java.sql.*;

public class Conexion {
  private static String usr, pass, FQDN, dbName;
  private static int port;
  public static String URI;

  Conexion(String usr, String pass , String FQDN, String port, String dbName){
    this.usr = usr;
    this.pass = pass;
    this.FQDN = FQDN;
    this.port = Integer.parseInt( port );
    this.dbName = dbName;
    this.URI="jdbc:mysql://" +
            usr + ":" +
            pass + "@" +
            FQDN + ":" +
            this.port + "/" +
            dbName +
            "?useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid";
  }
  Conexion(){
    this("alumno","alumno","luiscastelar.duckdns.org","45682","dbDefault");
  }

  public void select(String sql){
    try (Connection conn = DriverManager.getConnection( this.URI );
      //Connection conn = DriverManager.getConnection(url, user, password);
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql) ){

      ResultSetMetaData rsmd = rs.getMetaData();
      int numberOfColumns = rsmd.getColumnCount();
      for ( int i = 1 ; i <= numberOfColumns ; i++ ) {
        System.out.print( rsmd.getColumnName(i) + "\t");
      } // for
      System.out.println("");


      // loop through the result set
      while (rs.next()) {
        System.out.println(rs.getString("id") + "\t" +
                rs.getString("nombre") + "\t" +
                rs.getString("edad"));
      } // while

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) { e.printStackTrace(); }

  } // select()
} // class Conexion

```

## War: echo
El siguiente programa realiza un echo de lo recibido. Servlet `Echo.java`:
```java
package com.ejemplo.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.PrintWriter;
import java.io.IOException;

@WebServlet(name = "com.ejemplo.servlets.Echo", value = "/echo")
public class Echo  extends HttpServlet {

  // Peticiones GET
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Tipo de respuesta ofrecida (texto, imagen, etc)
    response.setContentType("text/html");

    // Declaraciones
    PrintWriter pw = response.getWriter();

    // Obtengo los datos de la peticion
    String operacion = request.getParameter("texto");

    // Verificamos que hemos recibido algo
    if( null == operacion ){
      pw.print("No has mandado ningún argumento.\nDebes mandar un \"texto=algun texto\"");
    } else if( 0 == operacion.length() ){
      pw.print("Debes mandar algún \"texto\"");
    } else {
      pw.print( operacion );
    } // if
  } // doGet()
} // class Echo
```


## Con Maven
+ [curso YT: MitoCode](https://www.youtube.com/watch?v=91DamlXb7bE&list=PLvimn1Ins-40atMWQkxD8r8pRyPLAU0iQ)
+ [Curso básico de Junta de Andalucía](https://www.juntadeandalucia.es/servicios/madeja/node/737/download/CursoDeIntroduccionMaven.pdf)
+ [Generar war con maven](https://www.baeldung.com/maven-generate-war-file)
+ [Despliegue con maven](https://raul-profesor.github.io/DEAW/P3.1-Tomcat/#despliegue-con-maven)