/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraslineales;
import CalculadoraPolaca.ValidadorParentesis;
import CalculadoraPolaca.PilaCalculadora;
import Pilas.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ivancadena
 */
public class ValidarPerentesis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ValidadorParentesis validador = new ValidadorParentesis();
        validador.capturarExp();
        JOptionPane.showMessageDialog(null, validador);
        validador.revisarExp();
        PilaCalculadora polaca = new PilaCalculadora();
        polaca.calcularExpresion();
    }
}
