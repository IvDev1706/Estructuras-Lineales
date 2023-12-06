/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSensilla;

/**
 *
 * @author ivancadena
 */
public class Nodo <G> implements Cloneable{
    //******* Variables de atributo *******//
    private G dato;
    public Nodo der;
    //******* Metodo constructor *******//
    public Nodo(G dato){
        this.dato = dato;
    }//fin constructor
    //******* Metodos de instancia *******//
    public Nodo copia(){
        Nodo nuevo = null;
        try{
            nuevo = (Nodo) this.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible clonar");
        }
        return nuevo;
    }
    //******* Metodo toString *******//
    @Override
    public String toString() {
        return dato+"";
    }//fin toString
    
}