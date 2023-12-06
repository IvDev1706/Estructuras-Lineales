/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pilas;

/**
 *
 * @author ivancadena
 */
public class PilaDinamica <G>{
    //******* Variables de atributo *******//
     private NodoPila inicio;
     private NodoPila fin;
     private int tamaño;
    //******* Metodo constructor *******//
    public PilaDinamica(){
        tamaño = 0;
        inicio = fin = null;
    }//fin constructor
    //******* Metodos de instancia *******//
    //metodo parainsertar un elemento en la cima de la pila
    public void push(G dato){
        //instancia de nodo
        NodoPila nodo = new NodoPila(dato);
        //metodo sobrecargado
        push(nodo);
    }//fin push
    
    //sobrecarga de metodo push
    public void push(NodoPila nodo){
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
    
    //metodo que devuelve el ultimo elemento de la lista
    public NodoPila pop(){
        //instancia de nodo temporal
        NodoPila temporal = null;
        //validacion de lista vacia
        if(inicio==fin){
           temporal = fin;
           inicio = fin = null;
           tamaño = 0;
        }else if(inicio!=null){
           temporal = fin; 
           fin = fin.izq;
           fin.der = temporal.izq = null;
           tamaño--;
        }//fin validacion
        return temporal;
    }//fin pop
    
    //metodo que valida si la pila esta vacia
    public boolean isEmpty(){
        return tamaño>0?false:true;
    }//fin isEmpty
    
    //metodo que retorna  el elemento tope de la pila
    public G peak(){
        NodoPila cima = pop();
        push(cima);
        return (G) cima.getDato();
    }//fin peak
    
    //metodo que saca el penultimo elemento
    public NodoPila penultimo(){
        //validacion de mas de 2 elementos
        if(tamaño>=2){
            NodoPila ultimo = pop();
            NodoPila penultimo = pop();
            push(ultimo);
            return penultimo;
        }else{
            System.out.println("No hay penultimo");
        }
        return null;
    }//fin penultimo
    
    //mettodoque retorna el antepenultimo elemento
    public NodoPila antepenultimo(){
        NodoPila nodos[] = new NodoPila[2];
        NodoPila Antepenultimo = null;
        if(tamaño>=3){
            nodos[0] = pop();
            nodos[1] = pop();
            Antepenultimo = pop();
            push(nodos[1]);
            push(nodos[0]);
            return Antepenultimo;
        }else{
            System.out.println("No existe antepenultimo");
        }
        return Antepenultimo;
    }//fin antepenultimo
    
    //metodo que invierte los datos de la pila
    public PilaDinamica invertir(){
        if(tamaño>0){
            //arreglo de nodos
            PilaDinamica nodos = new PilaDinamica();
            //constante de tamaño
            final int tamaño = this.tamaño;
            //ciclo de extraccion
            for(int i=1; i<=tamaño; i++){
                nodos.push(pop());
            }//fin ciclo de extraccion
            return nodos;
        }//fin validacion
        return null;
    }//fin invertir
    
    //metodo que devuelve el fondo de la pila
    public NodoPila fondo(){
        NodoPila fondo;
        if(isEmpty()){
            fondo=null;
        }else{
            //pila copia
            PilaDinamica copia = new PilaDinamica();
            //ciclo de extraccion
            int tamaño = this.tamaño;
            for (int i = 1; i <= tamaño-1; i++) {
                copia.push(pop());
            }
            fondo = pop();
            for(int j = 1; j<=tamaño-1; j++){
                push(copia.pop());
            }
        }
        return fondo;
    }//fin fondo
    
    //metodo que retorna el tamaño de la pila
    public int size(){
        return tamaño;
    }//fin size
    //******* Metodo toString *******//
    @Override
    public String toString() {
        String cadena = "PilaDinamica ("+tamaño+"): [";
        NodoPila cursor = inicio;
        while(cursor != null){
            cadena += cursor+", ";
            cursor = cursor.der;
        }
        cadena += "\b\b";
        cadena += "]";
        return cadena;
    }//fin toString
    
}
