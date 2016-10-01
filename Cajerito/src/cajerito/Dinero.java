/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajerito;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Alumno
 */
public class Dinero extends JFrame implements ActionListener {
    JPanel pantalla;
 JTextField contrasena,name,saldoF,cantidad;
       JLabel text;
       JButton CuentaN,deposito,retiro,fin,continuar;
       ArrayList <Operaciones> registro;
       
       
        public Dinero(){
           super();
           pantalla = new JPanel();
           pantalla.setLocation(100, 100);
           pantalla.setBackground(Color.cyan);
           pantalla.setBorder(BorderFactory.createLineBorder(Color.black));
           pantalla.setSize(800,800);
           setResizable(false);
           
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           //Campos de texto para informacion
            contrasena = new JTextField("");//campo vacio
            contrasena.setBounds(100, 100, 90, 30);
            add(contrasena);
            contrasena.setEnabled(true);//habilitar boton
            contrasena.addActionListener(this);
           
           //**
           
            name = new JTextField("");
            name.setBounds(100, 50, 90, 40);
             add(name);
            name.setEnabled(true);//habilitar boton
            name.addActionListener(this);
            
            //**
            saldoF = new JTextField("");
            saldoF.setBounds(100, 150, 90, 40);
             add(saldoF);
            saldoF.setEnabled(false);//deshabilitar boton
            saldoF.addActionListener(this);
            
            //**
            cantidad = new JTextField("");
            cantidad.setBounds(100, 200, 90, 40);
             add(cantidad);
            cantidad.setEnabled(true);//habilitar boton
            cantidad.addActionListener(this);
            
            //Botones
            CuentaN = new JButton("Cuenta nueva"); 
            CuentaN.setBounds(50, 100, 100, 20);
            add(CuentaN);
            CuentaN.addActionListener(this);
            //continuar
            continuar = new JButton("Continuar"); 
            continuar.setBounds(600, 100, 100, 20);
            add(continuar);
            continuar.addActionListener(this);
            
            //deposito
            
            deposito =  new JButton("Depositar");
            deposito.setBounds(200, 400, 100, 20);
            add(deposito); //agrego al panel
            deposito.addActionListener(this);
            
            
            //retiro
            retiro = new JButton("Retirar");
            retiro.setBounds(300, 400, 100, 20);
            add(retiro);
            retiro.addActionListener(this);
            
            //finalizar
            fin = new JButton("Finalizar");
            fin.setBounds(400, 400, 100, 20);
            add(fin);
            retiro.addActionListener(this);
            
            //textos
        text = new JLabel("Ingrese la cantidad que desee retirar/depositar: ");
        text.setBounds(50, 200, 300, 10);
        add(text);
        text = new JLabel("Saldo $ ");
        text.setBounds(50,150, 70, 9);
        add(text);
        text = new JLabel("Contraseña: ");
        text.setBounds(50, 100, 70, 9);
        add(text);
        text = new JLabel("Nombre: ");
        text.setBounds(50, 50, 70, 9);
        add(text);
        
        //arraylist(forma para guardar datos)
        registro = new ArrayList();
        setVisible(true);

       }
    @Override
    public void actionPerformed(ActionEvent e) {
      String click = e.getActionCommand();
      if(click.equals("Cuenta nueva")){
          name.setEnabled(true);
          contrasena.setEnabled(true);
          saldoF.setEnabled(true);
          cantidad.setEnabled(false);
          fin.setEnabled(true);
          deposito.setEnabled(false);
          retiro.setEnabled(false);   
          CuentaN.setText("siguiente");
      }
      if(click.equals("siguiente")){
         Operaciones usuario = new Operaciones();
         usuario.setPassword(contrasena.getText());
         usuario.setNombre(name.getText());
         usuario.setSaldo(Float.parseFloat(saldoF.getText()));
         JOptionPane.showMessageDialog(null, "Nuevo usuario registrado satisfactoriamente");
         registro.add(usuario);
         contrasena.setText("");
         name.setText("");
         saldoF.setText("");
        
         fin.setEnabled(true);
      }
       if(click.contentEquals("Continuar")){
           int total;
           String pass;
           int regresa =0;
           Operaciones usuario = new Operaciones();
           total = registro.size();
           pass = this.contrasena.getText();
              for(int i=0; i < total; i++){
                  usuario = registro.get(i);
                if(pass.equals(usuario.getPassword())){
                   name.setText(usuario.getNombre());
                   saldoF.setText(String.valueOf(usuario.getSaldo()));
                   deposito.setEnabled(true);
                   retiro.setEnabled(true);
                   cantidad.setEnabled(true);
                   fin.setEnabled(true);
                   CuentaN.setEnabled(false);
                   continuar.setEnabled(false);
                   regresa = 1;
                   break;
                }
              }
               if (regresa == 0) {
                JOptionPane.showMessageDialog(null, "Persona NO Encontrada");
                name.setEnabled(true);
                }
               this.contrasena.setEnabled(true);
       }
        if (click.equals("Retirar")) {
                    float resultado;
                    float inicial = new Float(saldoF.getText()); 
                    float retiro = new Float(cantidad.getText());  
                      //calculo del saldo despues del retiro   
                    resultado = inicial - retiro;
                    saldoF.setText(String.valueOf(resultado));
                    //insertamos al arraylist
                    Operaciones persona = new Operaciones();
                    int total = registro.size();
                    String clave = this.contrasena.getText();
                    for (int i = 0; i < total; i++) {
                    persona = registro.get(i);
                    if (clave.equals(persona.getPassword())) {
                    persona.setSaldo(Float.parseFloat(saldoF.getText()));
                    break;
                    
                } 
            }
                    }
                    if (click.equals("Depositar")) {
                    float Resultado;
                    float Inicial = new Float(saldoF.getText()); 
                    float Deposito = new Float(cantidad.getText());  
                       //calculo del saldo despues del deposito
                    Resultado = Deposito + Inicial;
                    saldoF.setText(String.valueOf(Resultado));
                    Operaciones persona = new Operaciones();
                    int total = registro.size();
                    String clave = this.contrasena.getText();
                    for (int i = 0; i < total; i++) {
                    persona = registro.get(i);
                    if (clave.equals(persona.getPassword())) {
                    persona.setSaldo(Float.parseFloat(saldoF.getText()));
                    break;
                    
                } 
            }
        }  
                        if (click.equals("Finalizar")) { 
                       contrasena.setText("");
                       name.setText("");
                       saldoF.setText("");
                       cantidad.setText("");
                       deposito.setEnabled(false);
                       retiro.setEnabled(false);
                       fin.setEnabled(false);
                       cantidad.setEnabled(false);
                       CuentaN.setEnabled(true);
                       continuar.setEnabled(true);
                    
       
      
    }
    }  
}
    
