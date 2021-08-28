package bo.edu.ucb.est;


public class Cliente {
    String nombre;
    String codigo;
    int pin;
    
    public Cliente(String nombre, String codigo, int pin){
        this.nombre = nombre;
        this.codigo = codigo;
        this.pin = pin;
    }
    
    public boolean login(int pin)throws Excepcion{
        boolean flag = false;
        if(this.pin==pin){
            flag = true;
        }else{
            throw new Excepcion("La contraseña es incorrecta");
        }
        return flag;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public int getPin(){
        return this.pin;
    }

}