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
public class PilaCalculadora {
    //******* Variables de atributo *******//
    private PilaDinamica pila;
    private StringTokenizer entrada;
    private String expresion;
    private String token;
    private double resultado;
    //******* Metodo constructor *******//
    public PilaCalculadora(){
        pila = new PilaDinamica();
        expresion = JOptionPane.showInputDialog("Ingrese la expresion posfija a calcular:");
        entrada = new StringTokenizer(expresion);
        token = "";
        resultado = 0;
    }//fin constructor
    
    //constructor sobrecargado
    public PilaCalculadora(String expresion){
        pila = new PilaDinamica();
        entrada = new StringTokenizer(expresion);
        token = "";
        resultado = 0;
    }//fin constructor sobrecargado
    //******* Metodos de instancia *******//
    //metodo para calcular el resultado de la epxresion dada
    public void calcularExpresion(){
        //ciclo de barrido de expresion
        while(entrada.hasMoreTokens()){
            //captura de letra
            token = entrada.nextToken();
            //excepcion de number format
            try{
                pila.push(Double.parseDouble(token));
            //captura de excepcion
            }catch(NumberFormatException ex){
                //condicion de tamaño de pila
                if(pila.size()>=2){
                    //switch de operaciones
                    switch (token) {
                        case "+":
                            resultado = (Double) pila.pop().getDato()+ (Double) pila.pop().getDato();
                            pila.push(resultado);
                            break;
                        case "*":
                            resultado = (Double) pila.pop().getDato() * (Double) pila.pop().getDato();
                            pila.push(resultado);
                            break;
                        case "-":
                            {
                                double segundo = (Double) pila.pop().getDato();
                                double primero = (Double) pila.pop().getDato();
                                resultado = primero-segundo;
                                pila.push(resultado);
                                break;
                            }
                        case "/":
                            {
                                double segundo = (Double) pila.pop().getDato();
                                double primero = (Double) pila.pop().getDato();
                                resultado = primero/segundo;
                                pila.push(resultado);
                                break;
                            }
                        default:
                            break;
                    }
                //mostrar resultado
                }else if(token.equals("=")){
                    JOptionPane.showMessageDialog(null,"Resultado: "+"\n"+pila.peak());
                //mensaje de sino
                }else{
                    JOptionPane.showMessageDialog(null,"Elementos insuficientes");
                    break;
                }//fin cocndicion de tamaño de pila
            }//fin tratamiento de excepcion
        }//fin ciclo de barrido
    }//fin calcularExpresion
    
    /**
     * Metodo que nos retorna el resultado de la operacion
     * @return el resultado de la expresion dada en forma posfija
     */
    public double getResultado(){
        return resultado;
    }//fin getResultado
}
