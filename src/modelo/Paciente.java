package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends User {
    private String tipoSangre;
    private Double altura, peso;
    private ArrayList<CitasDoctor> citasDoctors = new ArrayList<>();
    private ArrayList<CitaEnfermera> citasEnfermeras = new ArrayList<>();

    public ArrayList<CitasDoctor> getCitasDoctors() {
        return citasDoctors;
    }

    public void addCitasDoctors(Doctor doctor, Date fecha, String hora) {
        CitasDoctor cd = new CitasDoctor(this, doctor);
        cd.schedule(fecha, hora);
        citasDoctors.add(cd);
    }

    public ArrayList<CitaEnfermera> getCitasEnfermeras() {
        return citasEnfermeras;
    }

    public void setCitasEnfermeras(ArrayList<CitaEnfermera> citasEnfermeras) {
        this.citasEnfermeras = citasEnfermeras;
    }

    public Paciente(String name, String email, String telefono) {
        super(name, email, telefono);
    }


    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("patient abstract metod");
    }
}
