package modelo;

public class Enfermera extends User{

    private String especialidad;
    public Enfermera( String name,String email, String telefono) {
        super( name,email, telefono);
    }

    @Override
    public void showDataUser() {
        System.out.println("nurse abstract metod");
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
