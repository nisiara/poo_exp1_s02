
package com.bank.app;
import com.bank.entities.Banco;
import com.bank.entities.Cliente;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
  public static void main(String[] args){
    Banco banco = new Banco("bank boston");
    
    Scanner inputUsuario = new Scanner(System.in);
    
    //MENU BANK BOSTON
    Cliente elCliente = null;
    int opcionMenu = 0;
    while(opcionMenu != 6){
      try{
        System.out.println("\n+++++++++++++++++++++++++++++++");
        System.out.println("      MENU " + banco.getNombre().toUpperCase() );
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("[1] Registrar Cliente");
        System.out.println("[2] Ver Datos Cliente");
        System.out.println("[3] Depositar");
        System.out.println("[4] Girar");
        System.out.println("[5] Consultar Saldo");
        System.out.println("[6] Salir");
        opcionMenu = 0;
          
        opcionMenu = inputUsuario.nextInt();
        
        if(opcionMenu < 1 || opcionMenu > 6){
          System.out.println("\n+**** ENTRADA INVÁLIDA **** Debes ingresar un número válido para poder continuar." );
        }
      }
      catch(InputMismatchException error){
        System.out.println("**** ENTRADA INVÁLIDA **** Debes ingresar un número." );
        inputUsuario.next();
        opcionMenu = 0;
      }
      
     
      switch (opcionMenu) {
        // REGISTRAR CLIENTE
        case 1:
          System.out.println("\n**** PROCESO DE REGISTRO CLIENTE ****");
          banco.registrarCliente();
          break;

        // VER DATOS CLIENTE
        case 2:
          System.out.println("\n**** DATOS CLIENTE ****");
          System.out.println("Elige al cliente que deseas revisar sus datos");
         
            
          if(banco.cantidadClientes()){
            System.out.println("No hay clientes registrados");  
          } 
          else {
            banco.clienteElegido().mostrarDatosCliente();
          }
         
          break;

        // DEPOSITAR  
        case 3:
          System.out.println("\n**** DEPOSITO ****");
          System.out.println("Elige al cliente al que deseas depositar");
          if(banco.cantidadClientes()){
            System.out.println("No hay clientes registrados");  
          } else {
            elCliente = banco.clienteElegido();
            if(elCliente.getLaCuenta() != null && !elCliente.getLaCuenta().isEmpty()){
              switch(elCliente.getLaCuenta()){
                case "CUENTA_CORRIENTE":
                  elCliente.getCuentaCorriente().depositarDinero();
                  break;
                case "CREDITO":
                  elCliente.getLineaCredito().depositarDinero();
                  break;
                case "AHORRO":
                  elCliente.getCuentaAhorro().depositarDinero();
                  break;
              }
            }
          }
          
          break;

        // GIRAR  
        case 4:
          System.out.println("\n**** GIRAR DINERO ****");
          System.out.println("Elige al cliente al que deseas girar");
          if(banco.cantidadClientes()){
            System.out.println("No hay clientes registrados");  
          } 
          else {
            elCliente = banco.clienteElegido();
            if(elCliente.getLaCuenta() != null && !elCliente.getLaCuenta().isEmpty()){
              switch(elCliente.getLaCuenta()){
                case "CUENTA_CORRIENTE":
                  elCliente.getCuentaCorriente().girarDinero();
                  break;
                case "CREDITO":
                  elCliente.getLineaCredito().girarDinero();
                  break;
                case "AHORRO":
                  elCliente.getCuentaAhorro().girarDinero();
                  break;
              }
            }
          }
          
          break;

        // CONSULTAR SALDO  
        case 5:
          System.out.println("\n**** CONSULTA DE SALDO ****");
          System.out.println("Elige al cliente que deseas consultar su saldo");
          if(banco.cantidadClientes()){
            System.out.println("No hay clientes registrados");  
          } else {
             banco.clienteElegido().mostrarDatosCuenta();
          }
          
          break;
          
      } 
      
    }
    System.out.println("**** HAS SALIDO DE LA APLICACIÓN | " + banco.getNombre().toUpperCase() + " ****");

  }
    
    


    
  
}
