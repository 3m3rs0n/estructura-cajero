package bo.edu.ucb.est;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    String codigo;
    ArrayList<Cuenta> cuenta,cuentas;
    
    public Menu(){
    }
    
    public Menu(ArrayList<Cuenta> cuenta, ArrayList<Cuenta> cuentas){
        this.cuenta=cuenta;
        this.cuentas=cuentas;
    }
    
    public void menuAcceso(){
        boolean flag=false;
        int aux=0;
        while(true){
            System.out.println("Ingrese código de usuario:");
            Scanner entrada = new Scanner(System.in);
            codigo = entrada.nextLine();
            for(int i=0;i<cuenta.size();i++){
                if(cuenta.get(i).getCodigo().equals(codigo)) {
                    flag = true;
                    aux = i;
                    break;
		}else if(i==cuenta.size()-1 && !flag){
                    System.out.println("El usuario no existe");
                }
            }
            if(flag){
                try{
                    System.out.println("Ingrese su pin de seguridad:");
                    Scanner es = new Scanner(System.in);
                    int pin = es.nextInt();
                    try {
                        cuenta.get(aux).login(pin);
                        System.out.println("Bienvenido "+cuenta.get(aux).getNombre());
                        menu(codigo);
                        this.actualizarCuentas(codigo);
                        break;
                    } catch (Excepcion e) {
                        flag = false;
                        System.err.println(e);
                    }
                }catch (Exception e){
                    System.out.println("El pin solo puede tener números");
                }

            }
        }
    }
    
     public void menu(String codigo){
        boolean flag=true;
        actualizarCuentas(codigo);
        while(flag){
            System.out.println("MENÚ DE OPCIONES"+
                    "\n======================"+
                    "\n1. Ver Saldo"+
                    "\n2. Retirar"+
                    "\n3. Depositar"+
                    "\n4. Salír"+
                    "\n======================");
            try{
                System.out.println("Elija una opción:");
                Scanner entrada = new Scanner(System.in);
                int opc = entrada.nextInt();
                switch(opc){
                    case 1:
                        menuSaldo();
                        break;
                    case 2:
                        retiro();
                        break;
                    case 3:
                        deposito();
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.out.println("La opción ingresada es inválida");
                        break;
                }
            }catch (Exception e) {
                System.out.println("La opción ingresada es inválida");
            }
        }  
    }
     
    public void menuSaldo(){
        boolean flag=true;
        while(flag){        
            mostrarCuentas();
            try{
                Scanner entrada = new Scanner(System.in);
                int opc = entrada.nextInt();
                if(opc==0){
                    flag = false;
                }else if(opc>cuentas.size()+1){
                    System.out.println("La opción ingresada es inválida");
                }else{
                    System.out.println(cuentas.get(opc-1).toString());
                    flag = false;
                }  
            }catch (Exception e) {
                System.err.println("La opción ingresada es inválida");
            }  
        }     
    }
    
     public void mostrarCuentas(){
        System.out.println("CUENTAS"+"\n==================");
            for(int i=0;i<cuentas.size();i++){ 
                System.out.println((i+1)+". Cuenta "+(i+1)+": "+ cuentas.get(i).getTipo());
            }
        System.out.println("0. Volver"+"\n==================");
        System.out.println("Elija una opción:");
    }
    
    public Cuenta obtenerCuenta(int opc){
        Cuenta c = new Cuenta();
        for(int i=0;i<cuenta.size();i++){
            if(cuentas.get(opc-1).equals(cuenta.get(i))){
                c = cuenta.get(i);
            }
        }
        return c;
    }
    
    public void actualizarCuentas(String codigo){
        cuentas.clear();
        for(int i=0;i<cuenta.size();i++){
            if(cuenta.get(i).getCodigo().equals(codigo)) {
                cuentas.add(cuenta.get(i));
            }
        }
        
    }
    
    public void retiro(){
        boolean flag = true;
        while(flag){      
            System.out.println("MENÚ DE RETIRO");
            mostrarCuentas();
            try {
                Scanner entrada = new Scanner(System.in);
                int opc = entrada.nextInt();
                if(opc==0){
                    flag = false;
                }else if(opc>cuentas.size()+1 || opc<0){
                    System.out.println("La opción ingresada es inválida");
                }else{
                    Cuenta c = obtenerCuenta(opc);
                    try {
                        System.out.println(c.toString());
                        System.out.println("Ingrese monto a retirar: "+"("+c.getMoneda()+")");
                        double ret = entrada.nextDouble(); 
                        try {
                            c.deposito(ret);
                            System.out.println("Depósito realizado con éxito");
                            flag = false;
                        } catch (Excepcion e) {
                            System.err.println(e);
                        }   
                    } catch (Exception e) {
                        System.err.println("El monto ingresado es inválido");
                    }
                }
            } catch (Exception e) {
                System.err.println("La opción ingresada es inválida");
            }
        }   
    }
    
    public void deposito(){
        boolean flag = true;
        int opc;
        while(flag){      
            System.out.println("MENÚ DE DEPÓSITO");
            mostrarCuentas();
            try {
                Scanner entrada = new Scanner(System.in);
                opc = entrada.nextInt();
                if(opc==0){
                    flag = false;
                }else if(opc>cuentas.size()+1 || opc<0){
                    System.out.println("La opción ingresada es inválida");
                }else{
                    Cuenta c = obtenerCuenta(opc);
                    try {
                        System.out.println(c.toString());
                        System.out.println("Ingrese monto a depositar: "+"("+c.getMoneda()+")");
                        double ret = entrada.nextDouble(); 
                        try {
                            c.deposito(ret);
                            System.out.println("Depósito realizado con éxito");
                            flag = false;
                        } catch (Excepcion e) {
                            System.err.println(e);
                        }   
                    } catch (Exception e) {
                        System.err.println("El monto ingresado es inválido");
                    }
                }
            } catch (Exception e) {
                System.err.println("La opción ingresada es inválida");
            }
        }   
    }  
}
