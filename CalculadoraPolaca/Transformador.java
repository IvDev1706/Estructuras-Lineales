/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraPolaca;

import Pilas.PilaDinamica;
import java.util.StringTokenizer;

/**
 *
 * @author ivancadena
 */
public class Transformador {
    //******* Variables de atributo *******//
    private PilaDinamica <String>pila;
    private String expresion;
    private StringTokenizer separador;
    private String token;
    //******* Metodo Constructor de clase *******//
    public Transformador(){
        pila = new PilaDinamica();
        expresion = "";
    }//fin constructor
    //******* Metodos de instancia *******//
    /**
     * Metodo que convierte una exprecion infija a posfija
     * @param expresion
     * @return la expresion transformada
     */
    public String Transformar(String expresion){
        //mandamos la expresion al tokenizer para que la fragmente
        separador = new StringTokenizer(expresion);
        //ciclo de barrido de la expresion
        while(separador.hasMoreTokens()){
            token = separador.nextToken();//se guarda el fragmento
            //validacion de parentesis
            if(token.equals("(")){
                pila.push(token);
            //validacion de parentesis de cierre
            }else if(token.equals(")")){
                //ciclo de extraccion
                while(!pila.peak().equals("(")){
                    this.expresion += (String) (pila.pop().getDato())+" ";
                }//fin ciclo de extraccion
                pila.pop();//se extrae el parentesis de cierre
            }else{
                //identificamos los datos que puedan ser numeros
                try{
                    Double.parseDouble(token);
                    this.expresion += token+" ";
                }catch(NumberFormatException ex){
                    //mientras la pila no este vacia (ciclo de operadores)
                    while(!pila.isEmpty() && PEMDAS(token)<=PEMDAS(pila.peak())){
                        this.expresion += (String) (pila.pop().getDato())+" ";
                    }//fin ciclo de operadores
                    pila.push(token);
                }//fin try-catch
            }//fin validaciones
        }//fin ciclo de barrido
        while(!pila.isEmpty()){
            this.expresion += (String) (pila.pop().getDato())+" ";
        }
        return this.expresion+"\b";
    }//fin Transformar
    
    //metodo para definir prioridades de operaciones
    private int PEMDAS(String simbolo){
        int prioridad = -1;
        switch(simbolo){
            case "\u005E": prioridad = 1; break;//caso 1
            case "\u221A": prioridad = 1; break;//caso 2
            case "*": prioridad = 2; break;//caso 3
            case "/": prioridad = 2; break;//caso 4
            case "+": prioridad = 3; break;//caso 5
            case "-": prioridad = 3; break;//caso 5
            default: break;//caso default
        }
        return prioridad;
    }
}
