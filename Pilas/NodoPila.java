/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author ivancadena
 */
public class NodoPila <G>{
    //******* Variables de atributo *******//
    private G dato;
    public NodoPila der;
    public NodoPila izq;
    //******* Metodo constructor *******//
    //metodo constructor de clase
    public NodoPila(G valor){
        this.dato = valor;
    }//fin constructor
    //******* Metodos de isntancia *******//
    public NodoPila copia(){
        NodoPila nuevo = null;
        try{
            nuevo = (NodoPila) this.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible clonar");
        }
        return nuevo;
    }
    
    //metodo para obtenr el dato
    public G getDato(){
        return dato;
    }//fin getDato
    //******* Metodo toString *******//
    @Override
    public String toString() {
        return dato + "";
    }//fin del metodo toString
    
}
