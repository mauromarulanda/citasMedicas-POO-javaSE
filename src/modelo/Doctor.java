package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {
    public ArrayList<CitasDisponibles> citaDisponible = new ArrayList<>();

    public ArrayList<CitasDisponibles> getCitaDisponible() {
        return citaDisponible;
    }

    private String especialidad;


    public Doctor(String name, String email, String telefono) {
        super(name, email, telefono);
    }


    public void addCitasMedicas(String fecha, String hora) {
        citaDisponible.add(new CitasDisponibles(fecha, hora));
    }


    @Override
    public String toString() {
        return super.toString() + " Especialidad: " + especialidad + " Disponibilidad: " + citaDisponible.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("doctor abstract metod");
    }

    public static class CitasDisponibles {
        private int id;
        private Date fecha;
        private String hora;

        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");


        public CitasDisponibles(String fecha, String hora) {
            try {
                this.fecha = format.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.hora = hora;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getFecha() {
            return fecha;
        }

        public String getFecha(String FECHA) {

            return format.format(fecha);
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        @Override
        public String toString() {
            return "CitasDisponibles{" +
                    ", fecha=" + fecha +
                    ", hora='" + hora + '\'' +
                    '}';
        }
    }

}
