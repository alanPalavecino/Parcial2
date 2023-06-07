package Excepciones;

public class SinReactivos extends Exception {

    public SinReactivos (){

    }
    public SinReactivos (String mensaje){
        super(mensaje);
    }
}
