#curso23_24 #ED

# Introducción
Habiendo realizado la última semana bastantes ejercicios de ~AceptaElReto.com~ para prepararnos para el concurso ~ProgramaMe.com~ hemos visto (y sufrido) el sistema automatizado de corrección de soluciones.

Concretamente, en nuestras carnes ya habíamos probado lo dura que es la informática cuando ejecutas y te arroja errores por comas, nombres de variables e incluso la confusión de escribir ALG0 con un 0 en vez de una O (demonios quien los pondría tan próximos). Pero es que cuando todo parece ir bien, llega un /robo-juez/ y nos dice que la respuesta es incorrecta ~Wrong Answer~... pero ¿ésto de que va? ¿porqué es tan duro dicho juez? ...

... las pruebas unitarias son así.

# Pasos
1. Crear nuestra clase a testear (la que nos piden desarrollar).
2. Crear la clase de test.
3. Rezar.

# Al lío
Crear las pruebas para una ~Calculadora~ básica que implemente los métodos estáticos ~int suma(int a, int b)~, ~int resta(int m, int s)~, e ~float division(float dividendo, float divisor)~.


## **Fuentes:**
+ [[https://junit.org/junit5/docs/current/user-guide/][Doc OFICIAL de JUnit]]
+ [[https://www.youtube.com/watch?v=EOkoVm3rtNQ&list=PLTd5ehIj0goML37B7s9I9iN2zhJCfxJBC][Makigas JUnit]]
+ [[https://www.jetbrains.com/help/idea/junit.html][Implementación en IntelliJ]] [[https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/][más]]
+ [[http://www.java2s.com/Tutorials/Java/JUnit/index.htm][Tutorial muy completo]]
+ [[http://www.java2s.com/Tutorials/Java/JUnit/0100__JUnit_Annotation.htm][Anotaciones]]
+ [[https://www.javatpoint.com/junit-tutorial][Tutorial javaTpoint]]

## Anotaciones
| Annotation   | Description                                                  |
|--------------+--------------------------------------------------------------|
| @Test        | marks the public void method as a test case.                 |
| @Before      | causes that method to be run before each Test method.        |
| @After       | causes that method to be run after the Test method.          |
| @BeforeClass | causes it to be run once before any of the test methods      |
| @AfterClass  | call the method after all tests have finished.               |
| @Ignore      | marks to ignore the test and that test will not be executed. |

## Test sencillos
## Test múltiples 
## Test parametrizados
[test parametrizados](http://www.java2s.com/Tutorials/Java/JUnit/0140__JUnit_Parameterized_Test.htm)
