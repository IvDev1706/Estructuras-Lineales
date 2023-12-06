/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;
import ListasDobles.*;
/**
 *
 * @author ivancadena
 */
public class ExamenListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDobleG<Integer> A = new ListaDobleG();
        ListaDobleG<Integer> B = new ListaDobleG();
        A.add(1);
        A.add(3);
        A.add(5);
        A.add(7);
        A.add(18);
        B.add(2);
        B.add(6);
        ListaDobleG Mezclada = Mezclar(A,B);
        System.out.println(Mezclada);
    }
    
    public static ListaDobleG Mezclar(ListaDobleG A, ListaDobleG B){
        NodoDobleG nodoA, nodoB;
        ListaDobleG Nueva = new ListaDobleG();
        while(A.size()!=0&&B.size()!=0){
            nodoA = A.remove();
            nodoB = B.remove();
            if((int)(nodoA.getDato())<=(int)(nodoB.getDato())){
                Nueva.add(nodoA);
                B.addFirst(nodoB.getDato());
            }else{
                Nueva.add(nodoB);
                A.addFirst(nodoA.getDato());
            }
        }
        
        while(A.size()!=0){
            nodoA = A.remove();
            Nueva.add(nodoA);
        }
        
        while(B.size()!=0){
            nodoB = B.remove();
            Nueva.add(nodoB);
        }
        return Nueva;
    }
    
}
