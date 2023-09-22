#curso23_24 #PSP [estado:: Working] 
{[Page: New]} {[Editor: Toggle Dark Mode]} {[Editor: Toggle Vim Mode]}

# Herramientas
## Control de versiones (GIT)
El módulo se basará fundamentalmente en código, por lo que realizaremos uso intensivo de control de versiones ([GIT]([https://git-scm.com](https://git-scm.com/))) y virtualización.

> Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente.

+ FC: [TodoCode - Git](https://www.youtube.com/watch?v=mCVQgSyjCkI&list=PLQxX2eiEaqby-qh4raiKfYyb4T7WyHsfW) -> [1,25h]
+ FC: [Fazt Code - Markdown](https://www.youtube.com/watch?v=oxaH9CFpeEE) -> [0,5h]
+ Clase: Crear un repo con README.md conectado con GitHub. Añadir colaborador (profe `@luiscastelar`). Postear cambios de captura (`tee`) de un clone -> [2h]
  + El `README.md` contendrá vuestro nombre y email coorporativo.
+ [GitFiend](https://gitfiend.com/) o [GitG](https://wiki.gnome.org/Apps/Gitg) como apoyo visual a *git bash*
+ .gitignore *.env y otros archivos binarios*. \
  Crearemos en la raíz del repo un archivo denominado `.gitignore` con el contenido:
  ```
  *.env
  ```

+ *Referencias*:
  + Documentación OFICIAL -> [Git reference manual](https://git-scm.com/docs)
  + Vídeos aclarativos -> [PildorasInformáticas 1-5, 10-11](https://www.youtube.com/watch?v=ANF1X42_ae4&list=PLU8oAlHdN5BlyaPFiNQcV0xDqy0eR35aU)
     

## Servicios
Para verificar algunos aspectos de la programación multiproceso necesitaremos tener una idea clara sobre la situación actual de nuestro equipo. 

Para esto obtendremos información de los procesos:

### GNU/Linux
Con el comando ps:
+ Unix like: `ps -f` o `ps -AF`
+ BSD like: `ps axjf`

Cuando sean muchos ... `ps axjf | grep "java"` 

Y ya que estamos `kill PID` o cuando la cosa está difícil `kill -9 PID`

### Windows
`tasklist`

Y para eliminar `taskkill /F /PID PID_PROCESO`


# Procesos y multiprocesos
## Procesos
En los siguientes minutos vamos a intentar responder y definir los puntos:
1. ¿Que es un proceso?
2. Bloque de Control de Procesos - PCB
3. Programación concurrente:
  + cooperativa: Mac OS Clásico y Windows 3.x
  + preventiva: UNIX - GNU/Linux, Mac OS X y Windows 95 y NT

4. Programación paralela.
5. Programación distribuida.

   
+ Conceptos básicos:
  + [Vídeo - David Pérez](https://youtu.be/3JlLl5sdepc?si=ct-DV5IDrZLBP7Hy)
  + [Escuela Universitaria de Segovia](https://www.infor.uva.es/~fjgonzalez/apuntes/Tema4.pdf) o [Universidad Carlos III](https://media.uc3m.es/uploads2/material/5b3012c28f420863d08b7f9f/Apuntes_14_10.pdf)
+ Teoría -> [Vicente Martínez - IES Doctor Balmis](https://psp2dam.github.io/psp_pages/es/unit1/)


## Multiprocesos

***OFF-TOPIC***: Ejecución concurrente mediante la API `stream` (programación funcional): stream() vs parallelStream() -> [vídeo](https://www.youtube.com/watch?v=cTGPgMMKxZk)

  
+ [Runtime](https://psp2dam.github.io/psp_pages/es/unit2/runtime.html)
+ [ProcessBuilder](https://psp2dam.github.io/psp_pages/es/unit2/processbuilder.html)


## Referencias:
+ 