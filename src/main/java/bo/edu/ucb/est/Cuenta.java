
package bo.edu.ucb.est;


public class Cuenta extends Cliente{
    int numero;
    String moneda;
    String tipo;
    double saldo;
    
    public Cuenta(){
        super("","",0);
    }
       
    public Cuenta(String nombre, String codigo, int pin, int numero, String moneda, String tipo, double saldo) {
        super(nombre, codigo, pin);
        this.numero = numero;
        this.moneda = moneda;
        this.tipo = tipo;
        this.saldo = saldo;
    }
    
    public void retiro(double r)throws Excepcion{
        if(r>this.saldo) {
            throw new Excepcion("Su saldo es insuficiente");
	}else if(r<=0){
            throw new Excepcion("El monto ingresado no es válido");
        }
	this.saldo-=r;
    }
    
    public void deposito(double d)throws Excepcion{
        if(d<=0){
            throw new Excepcion("El monto ingresado no es válido");
        }
        this.saldo+=d;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getMoneda(){
        return this.moneda;
    }
    
    @Override
    public String toString(){
        return "Cuenta: "+numero+
               "\nMoneda: "+moneda+
               "\nTipo: "+tipo+
               "\nSaldo actual: "+saldo;
    }
    
}
