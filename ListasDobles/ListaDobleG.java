/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasDobles;


/**
 *
 * @author ivancadena
 */
public class ListaDobleG <G>{
    //******* variables de atributo *******//
    private NodoDobleG inicio;
    private NodoDobleG fin;
    private int tamaño;
    //******* metodo constructor *******//
    //metodo constructor
    public ListaDobleG(){
        inicio = fin = null;
        tamaño = 0;
    }//fin constructor
    //******* metodos deinstancia *******//
    //metodo para añadir elementos
    public void add(G valor){
        //instancia de nodo
        NodoDobleG nodo = new NodoDobleG(valor);
        //metodo sobrecargado
        add(nodo);
    }//fin metodo add
    
    //add sobrecargado
    public void add(NodoDobleG nodo){
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
    }//fin add sobrecargado
    
    //metodo para añador elemento al primer espacio
    public void addFirst(G valor){
        NodoDobleG nuevo = new NodoDobleG(valor);
        //validacion de lista existente
        if(inicio!=null){
            nuevo.der=inicio;
            inicio.izq=nuevo;
            inicio = inicio.izq;
            tamaño++;
        }else{
            add(valor);
        }//fin validacion de existencia d elista
    }//fin addFirst
    
    //metodo para añadir una lista
    public void addAll(ListaDobleG coleccion){
        NodoDobleG cursor = coleccion.inicio; 
        NodoDobleG copia = null;
        final int tamaño = coleccion.size();
        for (int i = 1; i <= tamaño; i++) {
            copia = cursor.copia();
            copia.der = copia.izq = null;
            add(copia);
            cursor = cursor.der;
        }
    }
    
    //metodo para añador un nodo en una posicion especifica
    public boolean addX(G valor, int posicion){
        //variable de estatus
        boolean realizado = true;
        //validacion de rango
        if(posicion>=1 && posicion<=tamaño+1){
            //validacion de posiciones medias
            if(posicion <= tamaño && posicion > 1){
                //nodo temporal
                NodoDobleG temporal = new NodoDobleG(valor);
                //cursor iterativo
                NodoDobleG cursor = inicio;
                //ciclo de movimiento
                for(int i = 1; i<posicion-1; i++){
                    cursor = cursor.der;
                }//fin ciclo de movimiento
                //insercion de nodo
                temporal.izq = cursor;
                temporal.der = cursor.der;
                cursor.der.izq = temporal;
                cursor.der = temporal;
                tamaño++;
            //validacion de extremo derecho
            }else if(posicion==tamaño+1){
                add(valor);
            //validacion de extremo izquierdo
            }else if(posicion==1){
                addFirst(valor);
            }//fin validaciones
        }else{
            return realizado;//accion no completada
        }
        return realizado;//retorno final
    }//fin addX
    
    //metodo para remover nodo
    public NodoDobleG remove(){
        //vatiable de apoyo
        NodoDobleG temporal = null;
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
        return temporal;//retorno de valor
    }//fin remove
    
    //metodo para remover el ultimo elemento
    public NodoDobleG removeLast(){
        NodoDobleG temporal = null;
        if(inicio==fin){
           temporal = fin;
           inicio = fin = null;
           tamaño = 0;
        }else if(inicio!=null){
           temporal = fin; 
           fin = fin.izq;
           fin.der = temporal.izq = null;
           tamaño--;
        }
        return temporal;
    }//fin removeLast
    
     //metodo que remueve un nodo en una posicion espeficica
    public NodoDobleG removeX(int posicion){
        //variable de apoyo temporal
        NodoDobleG temporal = null;
        //validacion de rango de posicion
        if(posicion>=1 && posicion <= tamaño){
            //caso 1 entre rango
            if(posicion < tamaño && posicion > 1){
                NodoDobleG cursor = inicio;
               //ciclo de brinco
                for (int i = 2; i <= posicion; i++) {
                    cursor = cursor.der;
                }//fin ciclo de brinco
                cursor.izq.der = cursor.der;
                cursor.der.izq = cursor.izq;
                cursor.der = cursor.izq = null;
                temporal = cursor;
                tamaño--;
            //caso 2 primera posicion
            }else if(posicion == 1){
                temporal = remove();
            //caso 3 ultima posicion
            }else if(posicion == tamaño){
                temporal = removeLast();
            }//fin validacion
        }//fin validacion
        return temporal;
    }//fin removeX
    
    /**
     * Metodo que verifica que un elemento ya esta en la lista
     * @param dato
     * @return true si ya esta, false sino
     */
    public boolean isInList(G dato){
        if(isInList(dato, inicio)){
            return true;
        }else{
            return false;
        }
    }//fin isInList
    
    //metodo privado que verifica si el dato ya esta en la lista
    private boolean isInList(G dato, NodoDobleG cursor){
        if(cursor!=null){
            if(cursor.getDato() == dato){
                return true;
            }else if(cursor.der != null){
                return isInList(dato, cursor.der);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }//fin isInList
    
    //metodo para retornar el tamaño
    public int size(){
        return tamaño;//retorno de tamaño
    }//fin size
    //******* metodo toString *******//
    @Override
    public String toString(){
        String cadena = Derecha() + "\n" + Reversa();
        return cadena;
    }//fin toString
    private String Derecha(){
        String cadena = "Lista ("+size()+") : [";
        NodoDobleG cursor = inicio;
        while(cursor != null){
            cadena += cursor+", ";
            cursor = cursor.der;
        }
        cadena += "\b\b";
        cadena += "]";
        return cadena;
    }
    private String Reversa() {
        String cadena = "Lista ("+size()+") : [";
        NodoDobleG cursor = fin;
        while(cursor != null){
            cadena += cursor+", ";
            cursor = cursor.izq;
        }
        cadena += "\b\b";
        cadena += "]";
        return cadena;
    }//fin toString
}
