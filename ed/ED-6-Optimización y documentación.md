#curso23_24 #ED [estado:: ToDo] 

# Documentación:
## Javadoc
[Paso a paso](https://www.baeldung.com/javadoc) y con *maven*.

## Doc JS

Instalación y ejecución en Debian/Ubuntu:
```bash
npm install -g jsdoc
jsdoc ejemplo.js

# En Markdown
sudo npm install -g --save-dev jsdoc-to-markdown
jsdoc2md ejemplo.js
```

Fuente
```js
/**
 * Prueba de API
 * @module API
 * @author Luis Fe <luisferreira@iescastelar.com>
 */

/** API Class description */
class API {
    /**
     * Constructor de clase
     * @param {Objeto} config ejemplo de descripción
     */
     constructor( config ){
         /** @private */
         this.uno = config;
         /** @public */
         this.dos = "ejemplo";
     }
}
module.exports = MiClase;
```

Como siempre, podemos tirar de docker cli para hacer evitar instalar: `docker run --rm -u1000 --name jsdoc -i -w /jsdoc -v ./:/jsdoc cm0x4d/jsdoc jsdoc ejemplo.js`

*Recuarda:*
+ -v para conectar el directorio actual `./` con el `/jsdoc` del contenedor.
+ -w para que el comando `jsdoc` tras la imagen `cm0x4d/jsdoc` se ejecute desde el directorio del contenedor que hemos conectado con el volumen, esto es, `/jsdoc`.
+ -u1000 para que se ejecute con el id del usuario actual (en mi caso id 1000).
+ -rm para que borre el contenedor al finalizar.
+ --name para darle nombre

## Screencast:
1. [Generación de documentación JS](https://ascii.luiscastelar.duckdns.org/a/2)
2. [Generación y sincronización con servidor](https://ascii.luiscastelar.duckdns.org/a/3)


# Optimización

## Hook pre-commit
Para verificar la calidad de código o el estilo.

## Hook pre-push
[Ver repositorio](https://github.com/luiscastelar/ed_hooks)

## Git BARE
El comando `git --init bare` genera un repositorio básico. 

Un repositorio git bare está diseñado para usarse como un **repositorio remoto donde el código se comparte entre los miembros del equipo**. El repositorio de Git básico no está destinado al desarrollo local.

Después de emitir un comando git init bare, **no** podrá escribir código en ese repositorio, lo que también significa que no necesitará limpiar los árboles de trabajo o espacios de trabajo de Git.

Este repositorio tiene distintos hooks que serán ejecutados y pueden ser utilizados para realizar otros trabajos automáticos sobre el código recibido tras un push.

## Hook post-receive
Vamos a utilizar este hook para desplegar nuestro código a un servidor de producción, esto es, hacer públicos los cambios.

**Fuente:** [Despliegue de aplicaciones con git - Hardfloat](https://hardfloat.es/blog/2021/03/23/desplegar-aplicaciones-con-git.html)

*Leer con atención. Las rutas debéis adaptarlas a **vuestro** caso de uso*.

## Fuentes:
+ [Hooks - Atlassian](https://www.atlassian.com/es/git/tutorials/git-hooks)
+ [Hooks - Git Oficial](https://git-scm.com/book/es/v2/Personalizaci%C3%B3n-de-Git-Puntos-de-enganche-en-Git)
+ [Ejemplos hooks - Hostinger](https://www.hostinger.es/tutoriales/como-usar-git-hooks)


# Práctica:
Crearemos una librería matemática sencilla con apenas un par de métodos (sumar y factorial), pero **bien** documentada.

Buscamos automatizar el proceso lo máximo posible, por lo que utilizaremos los **hooks** vistos para generar la documentación (pre-push), y desplegar los cambios realizados (post-receive) sobre un servidor “remoto” ubicado en el mismo host que nuestro repositorio BARE de producción.

Deberemos añadir un archivo índice (index.html) de forma que los visitantes puedan consultar la información básica de nuestro proyecto.

El contenido de index.html:
```html
<html>
  <body>
    <h1>Librería matemática (Práctica UT6)</h1>
    <div>Esto es un ejemplo de uso de nuestra librería js</div>
    <div><b>Nombre:</b><i>Aquí vuestros datos</i></div>
    <h2>Métodos</h2>
    <div>... aquí iría el contenido real</div>
  </body>
</html>
```
