#curso23_24 #ED [estado:: ToDo] 


# Con IDE
Instalación y uso de entornos de desarrollo:
+ [ ] Funciones de un entorno de desarrollo.
    **Automatización de la edición de código**:
    Los lenguajes de programación tienen reglas sobre cómo estructurar instrucciones. Dado que un IDE conoce estas reglas, contiene muchas funciones inteligentes para escribir o editar automáticamente el código fuente. *P.e.: inicio automático de proyecto => generación de clases y main()*.

    **Resaltado de sintaxis**:    
    Un IDE puede dar formato al texto escrito haciendo que algunas palabras aparezcan en negritas o itálicas, o utilizando diferentes colores de fuente. Estas pistas visuales hacen que el código fuente sea más legible y dan retroalimentación instantánea sobre errores sintácticos accidentales.

    **Finalización de código inteligente**:    
    Varios términos de búsqueda aparecen cuando comienza a escribir palabras en un motor de búsqueda. De manera similar, un IDE puede proponer sugerencias para completar una instrucción de código cuando el desarrollador comienza a escribir. *E incluso desarrollo de código mediante IA, p.e. GH Copilot*.

    **Refactorización del soporte**:
    La refactorización de código es el proceso de reestructuración del código fuente para hacerlo más eficiente y legible sin tener que cambiar su funcionalidad central. Los IDE pueden autorefactorizarse hasta cierto punto, lo que permite a los desarrolladores mejorar su código de forma fácil y rápida. Otros miembros del equipo entienden el código legible con mayor rapidez, lo que respalda la colaboración dentro del equipo. *Obteniendo **GREEN CODE**.*

    **Automatización de la creación local**:    
    Los IDE aumentan la productividad de los programadores, pues realizan tareas de desarrollo recurrentes que por lo general son parte de todos los cambios de código. Estos son algunos ejemplos de tareas de codificación regulares que lleva a cabo un IDE.

    **Compilación**:
    Un IDE compila o convierte el código en un lenguaje simplificado que el sistema operativo puede entender. Algunos lenguajes de programación implementan la compilación “justo a tiempo”, donde el IDE convierte código legible para los humanos en código para máquinas desde el interior de la aplicación.
    
    **Pruebas**:    
    El IDE permite a los desarrolladores automatizar pruebas de unidades localmente antes de integrar el software con el código de otros desarrolladores; también se llevan a cabo pruebas de integración más complejas. *Lo trataremos en la Unidad 6*

    **Depuración**:    
    La depuración es el proceso de corregir todos los errores o fallas revelados en las pruebas. Uno de los aspectos más valiosos e importantes de un IDE para fines de depuración es el hecho de poder seguir el código, línea por línea, conforme se pone en marcha e inspeccionar el comportamiento del código. Los IDE también integran varias herramientas de depuración que destacan las fallas provocadas por errores humanos en tiempo real, incluso mientras el desarrollador está escribiendo. *Algunos TIPs*.

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
3. [ ] `package` -> `javac -d ./ ArchivoClase.java && java package.ArchivoClase`
4. [ ] creación de `jar`‘s
5. [ ] ejecución de `jar`
6. [ ] [importación de jar](https://stackoverflow.com/questions/25730098/java-code-to-import-jar-file). P.e.: log4j
7. [ ] firmado de `jar`
8. [ ] creación de `war`‘s
9. [ ] ejecución de `war`


## Con Maven
+ [curso YT: MitoCode](https://www.youtube.com/watch?v=91DamlXb7bE&list=PLvimn1Ins-40atMWQkxD8r8pRyPLAU0iQ)
+ [Curso básico de Junta de Andalucía](https://www.juntadeandalucia.es/servicios/madeja/node/737/download/CursoDeIntroduccionMaven.pdf)
+ [Despliegue con maven](https://raul-profesor.github.io/DEAW/P3.1-Tomcat/#despliegue-con-maven)