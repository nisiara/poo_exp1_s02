package com.bank.entities;

import com.bank.interfaces.VerDatos;
import java.util.Scanner;

public class Cliente implements VerDatos{
  
  Scanner inputUsuario = new Scanner(System.in);
  
  // ATRIBUTOS
  private String rut;
  private String nombre;
  private String apellidoPaterno;
  private String apellidoMaterno;
  private String domicilio;
  private String comuna;
  private String telefono;
  private String numeroCuenta;
  private CuentaCorriente cuentaCorriente;
  private LineaCredito lineaCredito;
  private CuentaAhorro cuentaAhorro;
  private String laCuenta;
  

  // CONSTRUCTOR
  public Cliente(){}
  
  // GETTERS
  public String getLaCuenta(){
    return this.laCuenta;
  }
  public String getNombre(){
    return this.nombre;
  }
  public CuentaCorriente getCuentaCorriente(){
    return this.cuentaCorriente;
  }
  public LineaCredito getLineaCredito(){
    return this.lineaCredito;
  }
  public CuentaAhorro getCuentaAhorro(){
    return this.cuentaAhorro;
  }

  public void nuevaCuenta(String tipo){
    switch(tipo){
      case "CUENTA_CORRIENTE":
        this.cuentaCorriente = new CuentaCorriente();
        break;
      case "CREDITO":
        this.lineaCredito = new LineaCredito();
        break;
      case "AHORRO":
        this.cuentaAhorro = new CuentaAhorro();
        break;
    }
  }
  
  // SETTERS    
  public void setRut(String rut) {
    while(rut.length() != 11 && rut.length() != 12 ){
      System.out.println("**** ENTRADA INVÁLIDA **** El RUT debe contener entre 11 y 12 digitos, incluyendo guión y puntos." );
      rut = inputUsuario.next();
    }
    this.rut = rut; 
  }
  public void setNombre(String nombre) {
    this.nombre = validacionString(nombre);
  }
  public void setApellidoPaterno(String apellido){
    this.apellidoPaterno = validacionString(apellido);
  }
  public void setApellidoMaterno(String apellido){
    this.apellidoMaterno = validacionString(apellido);
  }
  public void setDomicilio(String direccion){
    this.domicilio = direccion;
  }
  public void setComuna(String comuna){
    this.comuna = validacionString(comuna);
  }
  public void setTelefono(String telefono){
    this.telefono = validacionNumero(telefono);
  }
  public void setNumeroCuenta(String numeroCuenta){
    this.numeroCuenta = validacionNumero(numeroCuenta);
  }
  public void setCuenta(String tipoCuenta){
    this.laCuenta = tipoCuenta;
  }
  
  
  @Override 
  public void mostrarDatosCliente(){
    System.out.println("Rut: " + this.rut);
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Apellido Paterno: " + this.apellidoPaterno);
    System.out.println("Apellido Materno: " + this.apellidoMaterno);
    System.out.println("Domicilio: " + this.domicilio);
    System.out.println("Comuna: " + this.comuna);
    System.out.println("Teléfono: " + this.telefono);
  }

  @Override
  public void mostrarDatosCuenta(){
    System.out.println("Número de Cuenta: " + this.numeroCuenta);
    if(this.cuentaCorriente != null){
      System.out.println(this.cuentaCorriente.getTipoCuenta());
      System.out.println("Saldo: $" + this.cuentaCorriente.getSaldo());
    }
    if(this.lineaCredito != null){
      System.out.println(this.lineaCredito.getTipoCuenta());
      System.out.println("Saldo: $" + this.lineaCredito.getSaldo());
    }
    if(this.cuentaAhorro != null){
      System.out.println(this.cuentaAhorro.getTipoCuenta());
      System.out.println("Saldo: $" + this.cuentaAhorro.getSaldo());
    }
  }
  
  
  //METODOS ADICIONALES
  private boolean sonCaracteres(String validarString) {
    return validarString.matches("^[a-zA-Z]+$");
  }
  private boolean sonNumeros(String validarNumero) {
    return validarNumero.matches("^[0-9]{9}$");
  }
  private String validacionString(String entrada){
    while(!sonCaracteres(entrada) ){
      System.out.println("**** ENTRADA INVÁLIDA ****. Este campo solo debe contener caracteres.");
      entrada = inputUsuario.next();
    }
    return entrada;
  }
  private String validacionNumero(String entrada){
    while(!sonNumeros(entrada) ){
      System.out.println("**** ENTRADA INVÁLIDA ****. Este campo solo debe contener 9 digitos.");
      entrada = inputUsuario.next();
    }
    return entrada;
  }
}
