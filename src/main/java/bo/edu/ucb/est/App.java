package bo.edu.ucb.est;

import java.util.ArrayList;

public class App 
{
    static ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
    static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>(); 
    
    public static void main( String[] args ){
        Cuenta c1 = new Cuenta("Juan Perez", "jperez",3333,111122,"Bolivianos","Caja de Ahorros",12000);
        Cuenta c2 = new Cuenta("Juan Perez", "jperez",3333,112211,"USD","Cuenta Corriente",100);
        Cuenta c21 = new Cuenta("Maria Gomez", "mgomez",4444,221122,"Bolivianos","Caja de Ahorros",0);
        Cuenta c31 = new Cuenta("Carlos Gomez", "cgomez",3333,331122,"Bolivianos","Caja de Ahorros",100);
        Cuenta c32 = new Cuenta("Carlos Gomez", "cgomez",3333,332211,"USD","Cuenta Corriente",1000);
        Cuenta c33 = new Cuenta("Carlos Gomez", "cgomez",3333,332233,"Bolivianos","Caja de Ahorros",100000);
        cuenta.add(c1);
        cuenta.add(c2);
        cuenta.add(c21);
        cuenta.add(c31);
        cuenta.add(c32);
        cuenta.add(c33);
        Menu m = new Menu(cuenta,cuentas);
        m.menuAcceso();
    }    
}