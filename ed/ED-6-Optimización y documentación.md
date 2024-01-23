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

### Screencast:
[asciinema](https://asciinema.org/a/rQFbPKOmp8VaReHKRj2hG3WHc) (sólo visible los próximos 7 días)

# Optimización

## Hook pre-push
[Ver repositorio](https://github.com/luiscastelar/ed_hooks)


## Fuentes:
+ [Hooks - Atlassian](https://www.atlassian.com/es/git/tutorials/git-hooks)
+ [Hooks - Git Oficial](https://git-scm.com/book/es/v2/Personalizaci%C3%B3n-de-Git-Puntos-de-enganche-en-Git)
+ [Ejemplos hooks - Hostinger](https://www.hostinger.es/tutoriales/como-usar-git-hooks)


