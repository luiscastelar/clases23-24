#curso23_24 #ED [estado:: ToDo] 


## Planificación de Pruebas
[Planificación de Pruebas](https://www.guru99.com/es/test-planning.html).


## Tipos de pruebas: Funcionales, estructurales y regresión, entre otras.

| Tipo | Descripción |
| --- | --- |
| Test Unitarios | Verificación de funciones de forma aislada |
| [Test de integración](https://qalified.com/es/blog/pruebas-de-integracion-que-son/) | Prueba de comportamiento de objetos y relación entre éstos |
| API Test | Pruebas de cada “caso de prueba” del backend |
| Test de sistema | Pruebas completas de funcionalidades del sistema completo (front + back) |

También tendremos las pruebas de instalación/desinstalación, actualización y de metodología *Agile*.


## Procedimientos y casos de prueba.
 + [ ] Pruebas de Código:
   + [ ] Cubrimiento: indica el porcentaje de código que se ejecutó dado un conjunto de pruebas y de casos de prueba.
   + [ ] valores límite
   + [ ] [clases de equivalencia](https://sarreplec.caib.es/pluginfile.php/11333/mod_resource/content/8/ED03_Contenidos/a1_determinar_las_clases_de_equivalencia.html)
   
### TDD - Test-Driven Development (desarrollo dirigido por tests)
1. **Fase ROJA**: Primero hacemos los test -> ergo falla ya que no tenemos la funcionalidad.
2. **Fase VERDE**: Realizamos la implementación que permita que pase el test -> pasa el test?
3. **Refactorización**: Ahora reescribimos el código de forma limpia -> [**CLEAN CODE**](https://www.ivoox.com/importancia-clean-code-script-time-audios-mp3_rf_123494197_1.html).

       
## Pruebas unitarias y herramientas de automatización.
+ [ ] ¿Anotaciones? (en JAVA)
+ [ ] Pruebas parametrizadas
+ [ ] [Medición de cobertura](https://www.guru99.com/es/code-coverage.html) / [en intellij](https://es.helpr.me/8679-how-do-i-see-code-coverage-in-intellij)


## TAP - Test Anything Protocol
https://testanything.org/


### Bash_unit      
[Repositorio Oficial](https://github.com/pgrange/bash_unit)

### JUnit
[Tema](https://rcasalla.gitbooks.io/libro-desarrollo-de-software/content/libro/temas/t_pruebas/prue_junit.html)

### DBUnit
+ MYSQL / MariaDB:
  + https://hepabolu.github.io/mytap/tests/
  + https://datacharmer.blogspot.com/2006/01/mysql-5-general-purpose-routine_27.html
  + .
  + Hazlas pruebas tú:
    1. Para cada consulta, función o procedimiento crea un procedimiento que lo testee.
    2. Comienza cada procedimiento con un inicio de transacción (**start transaction**) y finaliza con un **rollback**.
    3. Comprueba que retorna lo que esperas que retorne.
    4. Captura las excepciones.
    5. Reporta el resultado en **TAP**.
         
## Documentación de las incidencias.


## Dobles de prueba. Tipos. Características.


## Integración y desarrollo continuos:
+ [Gitlab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/)
+ [Tutorial Jenkins](https://codingpotions.com/jenkins-integracion-continua/)
+ [Jenkins - YT:Cultura DevOps](https://m.youtube.com/playlist?list=PLdOotbFwzDIiU4Hs8ySZr-phOeGMBY_3D)