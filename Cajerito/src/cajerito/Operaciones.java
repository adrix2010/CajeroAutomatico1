/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajerito;

/**
 *
 * @author Alumno
 */
public class Operaciones {
    private String nombre;
    private String password;
    private float saldo;
    private float cant;

       

    Operaciones() {
       this.nombre = nombre;
        this.password = password;
        this.saldo = saldo;
        this.cant = cant;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getCant() {
        return cant;
    }

    public void setCant(float cant) {
        this.cant = cant;
    }


    }
