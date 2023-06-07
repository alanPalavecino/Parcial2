package Excepciones;

public class ExcepcionFiebre extends Exception{
    public Integer test;
    public String barrio;
    public ExcepcionFiebre(Integer tes, String barrio){
        this.test = tes;
        this.barrio = barrio;
    }
}
