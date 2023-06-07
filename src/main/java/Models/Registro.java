package Models;

public class Registro {
    private Double temp;
    private String DNI;
    private Integer numeroTesteo;
    private String barrio;

    public Registro() {
    }

    public Registro(Double temp, String DNI, Integer numeroTesteo, String barrio) {
        this.temp = temp;
        this.DNI = DNI;
        this.numeroTesteo=numeroTesteo;
        this.barrio = barrio;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Integer getNumeroTesteo() {
        return numeroTesteo;
    }

    public void setNumeroTesteo(Integer numeroTesteo) {
        this.numeroTesteo = numeroTesteo;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "temp=" + temp +
                ", DNI='" + DNI + '\'' +
                ", numeroTesteo=" + numeroTesteo +
                ", barrio='" + barrio + '\'' +
                '}';
    }
}
