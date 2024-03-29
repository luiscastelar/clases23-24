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
+ [Doc OFICIAL de JUnit](https://junit.org/junit5/docs/current/user-guide/)
+ [Makigas JUnit](https://www.youtube.com/watch?v=EOkoVm3rtNQ&list=PLTd5ehIj0goML37B7s9I9iN2zhJCfxJBC)
+ [Implementación en IntelliJ](https://www.jetbrains.com/help/idea/junit.html) y [mas](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/)
+ [Tutorial muy completo](http://www.java2s.com/Tutorials/Java/JUnit/index.htm)
+ [Anotaciones](http://www.java2s.com/Tutorials/Java/JUnit/0100__JUnit_Annotation.htm)
+ [Tutorial javaTpoint](https://www.javatpoint.com/junit-tutorial)

## Anotaciones
| Annotation   | Description        |
| --- | --- |
| @Test | marks the public void method as a test case. |
| @Before | causes that method to be run before each Test method. |
| @After | causes that method to be run after the Test method. |
| @BeforeClass | causes it to be run once before any of the test methods |
| @AfterClass | call the method after all tests have finished. |
| @Ignore | marks to ignore the test and that test will not be executed. |


## Test sencillos
```java
@Test
@DisplayName("Probando suma")
public void testPrintMessage() {  
   assertEquals(1, 1+1);     
}
```

Métodos **Assert** más utilizados:
| Método | Descripción |
| --- | --- |
| void assertArrayEquals(expectedArray, resultArray); | Compara si 2 arrays son iguales |
| void assertEquals(boolean expected, boolean actual) | Compara si 2 objetos (o tipo primitivos) son iguales |
| void assertFalse(boolean condition) | Verifica si es falso |
| void assertNotNull(Object object) | Verifica si no es null |
| void assertNull(Object object) | Verifica si es null |
| void assertNotSame(Object ref1, Object ref2) | Verifica si las dos referencias no son al mismo objeto |
| void assertSame(Object ref1, Object ref2) | Verifica si son 2 referencias al mismo objeto |
| void assertTrue(boolean condition)| Verifica si es verdadero |
| void fail() | Siempre falla |


## Test múltiples 
```java
@org.junit.jupiter.api.Test
@DisplayName("Probando resta")
void resta() {
    assertAll(
            () -> assertEquals(0, Calculadora.resta(2, 2)),
            () -> assertEquals(4, Calculadora.resta(2, -2)),
            () -> assertEquals(0, Calculadora.resta(-2, -2)),
            () -> assertEquals(1, Calculadora.resta(1, 0))
    );
}
```

## Test parametrizados
```java
@ParameterizedTest
@DisplayName("Probando resta")
@CsvSource({
        "1, 3, 2",
        "-5, -3, 2",
        "5, 3, -2",
        "-1, -3, -2",
        "-2, 0, 2"
})
void restaCSV(int diferencia, int minuendo, int sustraendo) {
    assertEquals( diferencia, Calculadora.resta( minuendo, sustraendo ));
}
```

También desde csv externo

