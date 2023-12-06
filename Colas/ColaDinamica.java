/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Colas;

/**
 *@version 1.0
 * @author ivancadena
 * @date 28/09
 */
public class ColaDinamica <G>{
    //******* Variables de atributo *******//
    private NodoCola inicio;
    private NodoCola fin;
    private int tamaño;
    //******* Metodo constructor *******//
    public ColaDinamica(){
        inicio = fin = null;
        tamaño = 0;
    }//fin constructor
    //******* Metodos de instancia *******//
    //metodo para insertar datos por la parte derecha
    public void Insert(G dato){
        //instancia de nodo
        NodoCola nodo = new NodoCola(dato);
        ColaDinamica.this.Insert(nodo);//adicion a cola
    }//fin push
    
    //sobrecara de push
    public void Insert(NodoCola nodo){
        //validacion de lista existente o no
        if(inicio == null){
           //enlace de nodo
           inicio = fin = nodo;
           tamaño++;
        }else{
            //enlace de nodo
            fin.der = nodo;
            nodo.izq = fin;
            fin = fin.der;
            tamaño++;
        }//fin validacion
    }//fin push sobrecargado
    
    //metodo para sacar datos por la parte izquierda
    public NodoCola Delete(){
        NodoCola temporal = null;
        //condicion de lista existente
        if(inicio==fin){
           temporal = fin;
           inicio = fin = null;
           tamaño = 0;
        }else if(inicio != null){
            temporal = inicio;
            inicio = inicio.der;
            temporal.der = inicio.izq = null;
            tamaño--;
        }//fin validacion
        return temporal;
    }//fin desencolar
    
    //metodo que retorna el frente
    public G front(){
        return (G) inicio.getDato();
    }//fin getFrente
    
    //metodo que valida si la cola esta vacia
    public boolean isEmpty(){
        return tamaño>0?false:true;
    }//fin cola vacia
    
    //metodo que retorna el tamaño de cola
    public int size(){
        return tamaño;
    }//fin size
    //******* Metodo toString *******//
    @Override
    public String toString() {
        String cadena = "ColaDinamica ("+tamaño+"): [";
        NodoCola cursor = inicio;
        while(cursor != null){
            cadena += cursor+", ";
            cursor = cursor.der;
        }
        cadena += "\b\b";
        cadena += "]";
        return cadena;
    }//fin toString
}
