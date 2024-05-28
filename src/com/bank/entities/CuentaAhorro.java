
package com.bank.entities;

//import com.bank.abstracts.Cuenta;

import java.util.InputMismatchException;



public class CuentaAhorro extends Cuenta {
  private int limiteGiros = 4;
  private double interesDeposito = 0.01;
  
  public CuentaAhorro(){
     super("Cuenta de Ahorro", 0);
  }
  
  @Override
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
          double depositoConInteres = montoDeposito + (montoDeposito * interesDeposito);
          double nuevoSaldo = this.getSaldo() + depositoConInteres;
          this.setSaldo((int) nuevoSaldo);
          System.out.println("**** ¡Depósito realizado de manera exitosa!  ****");
          System.out.println("       Tu nuevo saldo es de $" + this.getSaldo() + "\n");
        }
      } 
      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoDeposito = 0;
      }
    } while(montoDeposito <= 0);
  }
  
  @Override
  public void girarDinero(){
    int montoGiro = 0;
    do{
      try{
        if(this.limiteGiros == 0){
          System.out.println("Ya alcanzaste el límite de giros disponibles para este tipo de cuenta");
          System.out.println("Tu saldo actual es de: $" + this.getSaldo());
        } 
        else{
          if(this.getSaldo() == 0){
            System.out.println("Tu saldo actual es de $0. No puedes realizar ningún giro");  
          } 
          else{
            System.out.println("¿Qué monto deseas girar desde tu cuenta?");
            montoGiro = inputUsuario.nextInt();
            if(montoGiro > this.getSaldo()){
              System.out.println("El monto a girar debe ser menor o igual que tu saldo");
              System.out.println("Tu saldo actual es de: $" + this.getSaldo());
            } 
            else {

              int nuevoSaldo = this.getSaldo() - montoGiro;
              this.setSaldo(nuevoSaldo );
              montoGiro = 0;
              this.limiteGiros --;
              System.out.println("**** ¡Giro realizado de manera exitosa! ****");
              System.out.println("       Tu nuevo saldo es de $" + this.getSaldo() + "\n");
              System.out.println("     Quedan diponibles " + limiteGiros + " giros" );

            }
          }
        }
        
      }  

      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoGiro = 0;
      }
    } while(montoGiro > 0 && montoGiro > this.getSaldo());
   }
   
}
