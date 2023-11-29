#curso23_24 #ED [estado:: ToDo] 

## Revisión de la historia

+ Detallado: `git log`
+ Resumido en una línea: `git log --pretty=oneline`
  + Con más datos: `git log --pretty=format:"%h - %an, %ar : %s"`
+ En árbol: `git log --graph`

Y por supuesto combinados: `git log --pretty=oneline --graph`


## Creación y fusión de ramas

+ [Doc OFICIAL](https://git-scm.com/book/es/v2/Ramificaciones-en-Git-Procedimientos-B%C3%A1sicos-para-Ramificar-y-Fusionar)
+ [Ramas - YT:TodoCode](https://www.youtube.com/watch?v=gjKKtQVVCZU)

## Gestión de ramas

+ [Doc OFICIAL](https://git-scm.com/book/es/v2/Ramificaciones-en-Git-Gesti%C3%B3n-de-Ramas)

## Traer commits a la rama `RAMA`

Cuando en la rama `dev` hemos realizado commits interesantes puede ser de gran relevancia poder traérnoslos a la rama `main`. 

Para ello sólo necesitamos conocer su `hash` (1) y, desde la rama `main`  (a la que lo queremos llevar) deberemos escribir `git cherry-pick HASH`.

(1) Para capturar su `hash`, nos ubicaremos en la rama `dev` con `git checkout dev` y veremos el historial de commits con `git log`. Ésto nos arrojará el `hash` de cada commit, además de la descripción, autor y marca temporal.

## Jugando con ramas
+ [learnGitBranching](https://learngitbranching.js.org/?locale=es_ES)

## Ejercicios
[Git ramas](https://raul-profesor.github.io/DEAW/P5.1/)

# Forks
+ [forks](https://aprendegit.com/fork-de-repositorios-para-que-sirve/)

# Hooks
+ [Hooks - Jeremy Holcombe](https://kinsta.com/es/blog/git-hooks/)