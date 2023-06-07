package Models;

public class Persona {
    /// Nombre y Apellido, edad, barrio, DNI y ocupación serán
    //los datos a pedir

    private String nombre;
    private String apellido;
    private Integer edad;
    private String barrio;
    private String DNI;
    private String ocupación;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, String barrio, String DNI, String ocupación) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.DNI = DNI;
        this.ocupación = ocupación;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getOcupación() {
        return ocupación;
    }

    public void setOcupación(String ocupación) {
        this.ocupación = ocupación;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", DNI='" + DNI + '\'' +
                ", ocupación='" + ocupación + '\'' +
                '}';
    }
}
