/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalculadoraPolaca;

import java.awt.*;
import static java.awt.Font.BOLD;
import static java.awt.Font.DIALOG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ivancadena
 */
public class Interfaz extends JFrame{
    //******* Elementos *******//
    private final JPanel panel = new JPanel();
    private final JLabel titulo = new JLabel();
    private final JLabel texto = new JLabel();
    private final JLabel textoResultado = new JLabel();
    private final JTextField campo1 = new JTextField();
    private final JButton btnCalcular = new JButton();
    private final JButton btnLimpiar = new JButton();
    //******* Constructor *******//
    public Interfaz(){
        this.setTitle("Calculadora Polaca");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        InicializarComponentes();
    }//fin constructor
    
    //******* Metodo para inicializar componentes *******//
    private void InicializarComponentes(){
        this.getContentPane().add(panel);
        panel.setLayout(null);//desactivamos el diseño
        panel.setBackground(Color.cyan);
        
        //agregar texto de titulo
        titulo.setBounds(140, 20,150, 20);
        titulo.setText("Calculadora");
        Font fuente = new Font(DIALOG, BOLD, 20);
        titulo.setFont(fuente);
        panel.add(titulo);
        
        //agregar etiqueta de indicacion
        texto.setBounds(10,70,350,20);
        texto.setText("Ingrese la expresion a calcular (Separada por espacios):");
        panel.add(texto);
        
        //agregartexto de resultado
        textoResultado.setBounds(220, 120, 120, 20);
        textoResultado.setText("Resultado: ");
        panel.add(textoResultado);
        
        //agregar campo de texto
        campo1.setBounds(10, 90, 200, 20);
        campo1.setText("( a + b )");
        panel.add(campo1);
        
        //agregar boton para calcular
        btnCalcular.setBounds(10, 120, 90, 20);
        btnCalcular.setText("Calcular");
        panel.add(btnCalcular);
        eventoCalcular();
        
        //agregar boton para limpiar
        btnLimpiar.setBounds(110,120, 80, 20);
        btnLimpiar.setText("Limpiar");
        panel.add(btnLimpiar);
        eventoLimpiar();
    }
    
    //******* Metodos de botones *******//
    private void eventoLimpiar(){
        //objeto evento
        ActionListener evento = new ActionListener() {
            //metodo de clickeado
            @Override
            public void actionPerformed(ActionEvent ae) {
                campo1.setText("");
                textoResultado.setText("Resultado: ");
            }//fin clickeado
        };
        btnLimpiar.addActionListener(evento);
    }//fin eventoLimpiar
    
    private void eventoCalcular(){
        //objeto de evento
        ActionListener evento = new ActionListener(){
            //metodo de clickeado
            @Override
            public void actionPerformed(ActionEvent ae){
                //validacion de texto diferente de la plantilla
                if(!campo1.getText().equals("( a + b )") && !campo1.getText().equals("")){
                    //se valida si la expresion esta balanceada y correcta
                    ValidadorParentesis vld = new ValidadorParentesis();
                    vld.capturarExp("( "+campo1.getText()+" )");
                    vld.revisarExp();
                    //si esta correcta la transformara a posfija
                    if(vld.isCorrect()){
                      Transformador trf = new Transformador();
                      //se pasa a la calculadora polaca
                      String transformada = trf.Transformar(campo1.getText());
                      PilaCalculadora pila = new PilaCalculadora(transformada);
                      pila.calcularExpresion();
                      textoResultado.setText("Resultado: "+pila.getResultado());
                    }
                }
            }//fin clickeado
        };
        btnCalcular.addActionListener(evento);
    }//fin eventoCalcular
    //******* Metodo main *******//
    public static void main(String[] args) {
        Interfaz ventana = new Interfaz();
        ventana.setVisible(true);
    }
}
