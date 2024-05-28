
package com.bank.entities;


import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Cuenta {
  
  Scanner inputUsuario = new Scanner(System.in);
  
  // ATRIBUTOS
  private String tipoCuenta;
  private int saldo;
  
  // CONSTRUCTOR
  public Cuenta(){}
  
  public Cuenta(String tipoCuenta, int saldo){
    setTipoCuenta(tipoCuenta);
    setSaldo(saldo);
  }
  
  // GETERS
  public String getTipoCuenta(){
    return this.tipoCuenta;
  }
  public int getSaldo(){
    return this.saldo;
  }
  // SETTERS
  public void setTipoCuenta(String tipoCuenta){
    this.tipoCuenta = tipoCuenta;
  }
  public void setSaldo(int saldo){
    this.saldo = saldo;
  }
 
  
  public void depositarDinero(){
    int montoDeposito;
    do{
      try{
        System.out.println("¿Qué monto deseas depositar en tu cuenta?");
        montoDeposito = inputUsuario.nextInt();
        if(montoDeposito <= 0){
          System.out.println("El monto a depositar debe ser mayor a cero");
        }
        else{
           this.saldo += montoDeposito;
           System.out.println("**** ¡Depósito realizado de manera exitosa!  ****");
           System.out.println("       Tu nuevo saldo es de $" + this.saldo + "\n");
        }
      } 
      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoDeposito = 0;
      }
    } while(montoDeposito <= 0);
  }
  
  public abstract void girarDinero();

  //METODOS ADICIONALES 
  public String cuentaValida(String cadena) {
    String regex = "^[0-9]{9}$";
    while(!cadena.matches(regex)){
      System.out.println("+**** ERROR **** El número de cuenta debe contener 9 dígitos");
      cadena = inputUsuario.next();
    }
    
    
    return cadena;
  }
  
  @Override
  public String toString() {
    return "Cuenta{" + "saldo=" + saldo + '}';
  }


  
  
  
}

