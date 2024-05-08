package com.iescastelar;

import com.iescastelar.CalculadoraDePila;
import com.iescastelar.verde.CalculadoraDePilaImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MainCalculadoraDePila {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        CalculadoraDePila calculadora = new CalculadoraDePilaImpl();

        System.out.println("----> CalculadoraDePila (introduce experesión RPN):");
        StringBuffer sb = new StringBuffer();
        String entrada;
        Stack<Float> pila;

        // Capturamos expresión (puede contener enter)
        do {
            entrada = keyboard.next();
            if( entrada.equals("=") ){
                break;
            } else {
                sb.append( " " + entrada );
            }
        } while (true);
        
        // Lanzamos el cálculo de la expresión y mostramos resultado
        //pila = calculadora.leerCalculo( sb.toString().trim() );
        //System.out.println("El resultado es: "+ pila.pop());
        
        System.out.println("El resultado es: " + calculadora.total( sb.toString().trim() ) );
    } // main()
} // class
