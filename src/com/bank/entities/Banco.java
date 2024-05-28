
package com.bank.entities;
import java.util.ArrayList;

import java.util.Scanner;

public class Banco {
  
  Scanner inputUsuario = new Scanner(System.in);
  
  // ATRIBUTOS
  private String nombre;
  private Cliente cliente;
  private ArrayList<Cliente> listaClientes;
 
  // CONSTRUCTOR
  public Banco(String nombre){
    this.nombre = nombre; 
    this.listaClientes = new ArrayList<>();
  }
  
  // GETTERS
  public String getNombre(){
    return this.nombre;
  }
  public Cliente getCliente(){
    return this.cliente;
  }
  public boolean cantidadClientes(){
    return this.listaClientes.isEmpty();
  }
  
  /*
  TELL, DON'T ASK
  Se elimina el getter del atributo listaClientes, ya que desde la clase App, desde donde
  solose ejecuta la aplicación, tendría acceso a la referencia de toda la lista pudiendo
  agregar o elimnar elementos, lo cual no cumpliría con el principio de Encapsulamiento.
  Por eso se cambio por el método sin retorno mostrarClientes. Así el objeto no expone sus 
  datos al exterior y es este mismo el que con sus propios datos aplica la lógica necesaria.
  */
  
  
  // SETTERS
  public void setNombre(String nombre){
    if(nombre != null){
      this.nombre = nombre;
    }
  }
  
  // METODOS
  public void registrarCliente(){
    String rutRegistro;
    String nombreRegistro;
    String apellidoPaternoRegistro;
    String apellidoMaternoRegistro;
    String domicilioRegistro;
    String comunaRegistro;
    String telefonoRegistro;
    int tipoCuenta;
    String numeroCuentaRegistro;
    
    cliente = new Cliente();
    
    System.out.println("Ingresa el RUT del cliente. (Con puntos y guión)");
    rutRegistro = inputUsuario.next();
    cliente.setRut(rutRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el nombre del cliente");
    nombreRegistro = inputUsuario.next();
    cliente.setNombre(nombreRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el apellido paterno del cliente");
    apellidoPaternoRegistro = inputUsuario.next();
    cliente.setApellidoPaterno(apellidoPaternoRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el apellido materno del cliente");
    apellidoMaternoRegistro = inputUsuario.next();
    cliente.setApellidoMaterno(apellidoMaternoRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el domicilio del cliente");
    domicilioRegistro = inputUsuario.next();
    cliente.setDomicilio(domicilioRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa la comuna a la que pertenece la dirección");
    comunaRegistro = inputUsuario.next();
    cliente.setComuna(comunaRegistro);
    inputUsuario.nextLine();

    System.out.println("Ingresa el teléfono del cliente (Número con 9 dígitos)");
    telefonoRegistro = inputUsuario.next();
    cliente.setTelefono(telefonoRegistro);
    inputUsuario.nextLine();
    
    System.out.println("Elige el tipo de cuenta para el cliente");
    System.out.println("[1] Cuenta Corriente");
    System.out.println("[2] Línea de Crédito (Con crédito de $200.000 y comisión por cada giro)");
    System.out.println("[3] Cuenta de Ahorro (Depósito con intereses y con límite de 4 giros)");
    tipoCuenta = inputUsuario.nextInt();
    
    switch(tipoCuenta){
      case 1:
        cliente.setCuenta("CUENTA_CORRIENTE");
        cliente.nuevaCuenta("CUENTA_CORRIENTE");
        break;
      case 2:
        cliente.setCuenta("CREDITO");
        cliente.nuevaCuenta("CREDITO");
        break;
      case 3:
        cliente.setCuenta("AHORRO");
        cliente.nuevaCuenta("AHORRO");
        
        break;
    }

    System.out.println("Asígnale un número de cuenta al cliente (Número de 9 dígitos)");
    numeroCuentaRegistro = inputUsuario.next();
    cliente.setNumeroCuenta(numeroCuentaRegistro);
    inputUsuario.nextLine();

    listaClientes.add(this.cliente);
    
    System.out.println("\n**** ¡Cliente creado exitosamente! ****");
  }
  
  
  public int listaClientesGuardados(){
   
    int indice = 1;
    for( Cliente cliente : listaClientes){
      System.out.println("[" + indice + "] " + cliente.getNombre());
      indice++;
    }
    
    return inputUsuario.nextInt() - 1;
  }
 
   
  public Cliente clienteElegido(){
    Cliente objetoClienteElegido = listaClientes.get(listaClientesGuardados());
    return objetoClienteElegido;
    
    
  }
  
}
