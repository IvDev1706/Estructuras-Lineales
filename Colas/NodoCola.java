/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *
 * @author ivancadena
 */
public class NodoCola <G> implements Cloneable{
    //******* Variables de atributo *******//
    private G dato;
    public NodoCola der;
    public NodoCola izq;
    //******* Metodo constructor *******//
    //metodo constructor de clase
    public NodoCola(G dato){
        this.dato = dato;
    }//fin constructor
    //******* Metodos de isntancia *******//
    public NodoCola copia(){
        NodoCola nuevo = null;
        try{
            nuevo = (NodoCola) this.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible clonar");
        }
        return nuevo;
    }
    //******* Metodos de atributo *******//
    //metodo get para dato
    public G getDato() {
        return dato;
    }//fin getDato
    //******* Metodo toString *******//
    @Override
    public String toString() {
        return dato + "";
    }//fin del metodo toString
}
