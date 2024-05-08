package com.iescastelar;

import java.util.Stack;

/**
 * Interface para una Calculadora de Pila
 * @author Luis Ferreira
 * @version 0.1
 * @since 8 mayo de 2024
 */
public interface CalculadoraDePila {

    /** Leer expresión de entrada
     * @param calculo Recibe un String con la expresión
     * @return Stack con el resultado/s de las operaciones
     */
    public abstract Stack leerCalculo(String calculo);
    
    /** Multiplicar 2 valores de la pila y retornar el resultado a la misma
     * @param pila Recibe un Stack de Floats con al menos 2 valores
     */
    public abstract void multiplicar(Stack<Float> pila);
    
    /** Sumar 2 valores de la pila y retornar el resultado a la misma
     * @param pila Recibe un Stack de Floats con al menos 2 valores
     */
    public abstract void sumar(Stack<Float> pila);
    
    /** Totalizar recibe la expresión y devuelve el resultado final
     * @param calculo Recibe un String con la expresión
     * @return Float con el resultado (top de la pila)
     */
     public abstract Float total(String calculo);
}
