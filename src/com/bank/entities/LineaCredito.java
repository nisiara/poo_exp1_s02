
package com.bank.entities;

import java.util.InputMismatchException;


public class LineaCredito extends Cuenta {
  private int comisionGiro = 100;
  private int limiteSaldo = 200000;
  public LineaCredito(){
    super("Línea de Crédito", 200000);
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
        if( (montoDeposito + this.getSaldo()) <= limiteSaldo){
          int nuevoSaldo = this.getSaldo() + montoDeposito;
          this.setSaldo(nuevoSaldo);
          System.out.println("**** ¡Depósito realizado de manera exitosa!  ****");
          System.out.println("       Tu nuevo saldo es de $" + this.getSaldo() + "\n");  
        }
        else{
           System.out.println("No se puede exceder el límite de la cuenta - $" + limiteSaldo);
        }
      } 
      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoDeposito = 0;
      }
    } while(montoDeposito <= 0 || montoDeposito > this.limiteSaldo );
  }
  
  @Override
  public void girarDinero(){
    int montoGiro = 0;
    do{
      try{
        if(this.getSaldo() == 0){
          System.out.println("Tu saldo actual es de $0. No puedes realizar ningún giro $" + comisionGiro );  
        } 
        else{
          System.out.println("¿Qué monto deseas girar desde tu cuenta?");
          montoGiro = inputUsuario.nextInt();
          if(montoGiro > (this.getSaldo() - comisionGiro)){
            System.out.println("El monto a girar debe ser menor a tu saldo, incluyendo la comisión por giro");
            System.out.println("Tu saldo actual es de: $" + this.getSaldo());
          } 

          else {
            int nuevoSaldo = (this.getSaldo() - montoGiro) - comisionGiro;
            this.setSaldo(nuevoSaldo );
            montoGiro = 0;

            System.out.println("**** ¡Giro realizado de manera exitosa! ****");
            System.out.println("       Tu nuevo saldo es de $" + this.getSaldo() + "\n");   
          }
        }
      }  

      catch (InputMismatchException error){
        System.out.println("+++ ERROR: Debes ingresar un monto válido." );
        inputUsuario.next();
        montoGiro = 0;
      }
    } while(montoGiro > 0 && montoGiro > this.getSaldo() - comisionGiro);
   }
}
