/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaSensilla;
/**
 *
 * @author ivancadena
 */
public class Lista <G>{
    //******* Variables de atributo *******//
    private Nodo inicio, fin;
    private int tamaño;
    //******* Metodos constructores *******//
    public Lista(){
        tamaño = 0;
    }
    //******* Metodos de instancia *******//
    //metodo para agregar elemento
    public void add(String nombre){
        Nodo nuevoNodo = new Nodo(nombre);
        add(nuevoNodo);
    }//fin add
    //metodo sobrecargado de nodo
    public void add(Nodo nodo){
        //validacion de objeto nulo
        if(nodo != null){
            //validacion de existencia de lista
            if(inicio == null){
                inicio = nodo;//creacion de elemento
                fin = inicio;//creacion de elemento
                tamaño++;
            }else{//conecta nodos
                fin.der = nodo;
                fin = fin.der;
                tamaño++;
            }//fin validacion
        }//fin validacion de objeto nulo
    }//fin add
    //metodo para añadir nuevo elemento primero
    public void addFirst(G dato){
        Nodo nuevoInicio = new Nodo(dato);
        addFirst(nuevoInicio);
    }//fin add first
    //metodo sobrecargado de addfirst
    public void addFirst(Nodo nodo){
        Nodo nuevoInicio = nodo;
        //validacion de lista vacia o existente
        if(inicio==null){
            inicio = fin = nuevoInicio;//se inserta en la lista vacia
            tamaño++;
        }else{
            nuevoInicio.der = inicio;
            inicio = nuevoInicio;
            tamaño++;
        }//fin validacion
    }//fin add first
    
    //metodo para obtener el tamaño de la lista
    public int size(){
        return tamaño;//retorno de tamaño
    }//fin size
    //metodo para remover el primer elemento de la lista
    public Nodo remove(){
        Nodo copia = null;
        //validacionnde lista no vacia
        if(inicio != null){
            //copia del inicio
            copia = inicio;
            //recorremos el inicio
            inicio = inicio.der;
            //desconectar nodo
            copia.der = null;
            //decrementmos el tamaño
            tamaño--;
            return copia;
        }else{
            copia = null;
        }//fin validacion de lsita no vacia
        return copia;
    }//fin remove
    //metodo para remover el ultimo elemento de la lista
    public Nodo removeLast(){
        Nodo eliminado = null;//variable auxiliar
        //no existe lista
        if(inicio != null){
            //solo un elemento en la lista
            if(tamaño==1){
                eliminado = inicio;
                inicio = fin = null;
                tamaño=0;
            }//finvalidacion de un solo nodo
            //existen 2 elementos en la lista
            if(tamaño==2){
                eliminado = fin;
                inicio.der = null;
                fin = inicio;
                tamaño--;
            }//fin validacion de 2 elementos en lista
            //existen multiples elementos en la lista
            if(tamaño>2){
                Nodo cursor = inicio.der;//posicion en segundo elemento
                while(cursor.der != fin){
                    cursor = cursor.der;
                }
                eliminado = fin;
                fin = cursor;
                fin.der = null;
                tamaño--;
            }//fin validacion de multiples elementos
        }//fin validacion de lista
        return eliminado;//retorno de valor
    }//fin removeLast
    //******* Metodo toString *******//
    @Override
    public String toString() {
        String cadena = "Lista: [ ";
        Nodo cursor = inicio;
        while(cursor != null){
            cadena += cursor+", ";
            cursor = cursor.der;
        }
        cadena += "]";
        return cadena;
    }//fin toString  
}
