/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasDobles;

/**
 *
 * @author ivancadena
 */
public class NodoDobleG <G> implements Cloneable{
    //******* Variables de atributo *******//
    private G dato;
    public NodoDobleG der;
    public NodoDobleG izq;
    //******* Metodo constructor *******//
    //metodo constructor de clase
    public NodoDobleG(G valor){
        this.dato = valor;
    }//fin constructor
    //******* Metodos de isntancia *******//
    public NodoDobleG copia(){
        NodoDobleG nuevo = null;
        try{
            nuevo = (NodoDobleG) this.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible clonar");
        }
        return nuevo;
    }
    //******* Metodos de atributo *******//
    public G getDato(){
        return dato;
    }
    //******* Metodo toString *******//
    @Override
    public String toString() {
        return dato + "";
    }//fin del metodo toString
    
}
