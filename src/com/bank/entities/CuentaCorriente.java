
package com.bank.entities;

import java.util.InputMismatchException;

public class CuentaCorriente extends Cuenta {
 
  public CuentaCorriente() {
     this.setTipoCuenta("Cuenta Corriente");
     
  }
  
  @Override
  public void girarDinero(){
    int montoGiro = 0;
    do{
      try{
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
            //this.saldo -= montoGiro;
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
    } while(montoGiro > 0 && montoGiro > this.getSaldo());
   }


}
