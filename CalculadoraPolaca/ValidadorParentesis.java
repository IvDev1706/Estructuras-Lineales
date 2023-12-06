/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraPolaca;
import Pilas.PilaDinamica;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
/**
 *
 * @author ivancadena
 */
public class ValidadorParentesis {
    //******* Variables de atributo *******//
    private PilaDinamica <String>pila;
    private String expresion;
    private StringTokenizer separador;
    private String token;
    private boolean correcta;
    //******* Metodo constructor *******//
    public ValidadorParentesis(){
        pila = new PilaDinamica();
        expresion = "";
        correcta = true;
    }//fin constructor
    //******* Metodos de instancia *******//
    /**
     * Metodo para capturar una expresion dada por el usuario
     */
    public void capturarExp(){
        expresion = JOptionPane.showInputDialog("Ingrese su expresion separada por espacios:");
        separador = new StringTokenizer(expresion);
    }//fin capturarExp
    
    /**
     * Metodo para capturar una expresion dada por el usuario
     * @param expresion
     */
    public void capturarExp(String expresion){
        separador = new StringTokenizer(expresion);
    }//fin capturarExp
    
    /**
     * Metodo que revisa si los anidadores estan valanceados
     */
    public void revisarExp(){
        boolean continuar = true;
        //ciclo de recorrido
        while(separador.hasMoreTokens() && continuar){
            token = separador.nextToken();
            //switch de apertura
            switch(token){
                //casos de llaves de apertura
                case "(":
                    pila.push(token);
                    break;
                case"[":
                    pila.push(token);
                    break;
                case "{":
                    pila.push(token);
                    break;
                case "\"":
                    pila.push(token);
                    break;
                case "\'":
                    pila.push(token);
                    break;
                case "<":
                    pila.push(token);
                    break;
                default:
                    break;
            }//fin switch
            
            //validacion de si existen  llaves de apertura
            if(!pila.isEmpty()){
                //switch de cierre
                switch(token){
                    //casos de llaves de cierre
                    case ")":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("(")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    case"]":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("[")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    case "}":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("{")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    case "\"":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("\"")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    case "\'":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("\'")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    case ">":
                        //validacion de que sea la apertura correcta
                        if(pila.peak().equals("<")){
                            pila.pop();
                        //mensaje de error
                        }else{
                            continuar = false;
                        }//fin validacion de apertura existente
                        break;
                    default:
                        break;
                }//fin switch
            //mensaje de error
            }else{
                pila.push(token);
            }//fin validacion de llaves de apertura
        }//fin ciclo de recorrido
        
        //validacion de pila vacia
        if(pila.isEmpty()){
            correcta = true;
        }else if(continuar==false){
            JOptionPane.showMessageDialog(null,"expresion incorrectamente anidada");
            correcta = false;
        }else{
            JOptionPane.showMessageDialog(null, "Exprecion no Balanceada");
            correcta = false;
        }//fin validacion de pila vacia
    }//fin revisarExp
    
    /**
     * Metodo que nos cide si la expresion esta correcta 
     * @return true si esta correctamente anidada y balancada, false si no lo esta
     */
    public boolean isCorrect(){
        return correcta;
    }//fin isCorrect
    //******* Metodo toString *******//
    @Override
    public String toString() {
        return "expresion dada: " + expresion;
    }//fin toString
}
