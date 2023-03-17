package Ui;

import modelo.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UiPacienteMenu {

    public static void showPatientMenu() {
        int respuesta;
        do {
            System.out.println("\n\n");
            System.out.println("Bienvenido paciente" + UiMenu.pacLogged.getName());
            System.out.println("1. toma una cita");
            System.out.println("2. mis citas");
            System.out.println("0. regresar");

            Scanner SC = new Scanner(System.in);
            respuesta = SC.nextInt();
            switch (respuesta) {
                case 1:
                    AgendaCitas();
                    break;
                case 2:
                    verCitasPaciente();
                    break;
                case 0:
                    System.out.println("vuelve pronto");
                    UiMenu.showMenu();
                    break;
                default:
                    System.out.println("seleccione una opcion correcta");
            }
        } while (respuesta != 0);


    }

    private static void AgendaCitas() {
        int request = 0;
        do {
            System.out.println("::busca una cita");
            System.out.println("::selecciona la fecha");
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UiDoctorMenu.doctorsCitasDisponibles.size(); i++) {
                ArrayList<Doctor.CitasDisponibles> dcc = UiDoctorMenu.doctorsCitasDisponibles.get(i).getCitaDisponible();
                Map<Integer, Doctor> docDates = new TreeMap<>();
                for (int j = 0; j < dcc.size(); j++) {
                    k++;
                    System.out.println(k + ". " + dcc.get(j).getFecha());
                    docDates.put(Integer.valueOf(j), UiDoctorMenu.doctorsCitasDisponibles.get(i));
                    doctors.put(Integer.valueOf(k), docDates);
                }
            }
            Scanner sc = new Scanner(System.in);
            int res = sc.nextInt();
            Map<Integer, Doctor> doctorSeleccionadoDisponible = doctors.get(res);
            Integer indicefecha = 0;
            Doctor doctorSeleccionado = new Doctor("", "", "");
            for (Map.Entry<Integer, Doctor> doc : doctorSeleccionadoDisponible.entrySet()) {
                indicefecha = doc.getKey();
                doctorSeleccionado = doc.getValue();
            }
            System.out.println(doctorSeleccionado.getName() +
                    "Fecha: " + doctorSeleccionado.getCitaDisponible().get(indicefecha).getFecha() +
                    "Hora: " + doctorSeleccionado.getCitaDisponible().get(indicefecha).getHora());
            System.out.println("confirma tu cita: \n1.correcto.\n 2.modificar.");
            request = sc.nextInt();
            if (request == 1) {
                UiMenu.pacLogged.addCitasDoctors(doctorSeleccionado,
                        doctorSeleccionado.getCitaDisponible().get(indicefecha).getFecha(),
                        doctorSeleccionado.getCitaDisponible().get(indicefecha).getHora());
                showPatientMenu();
            }

        } while (request != 0);
    }

    private static void verCitasPaciente() {
        int respuesta = 0;
        do {
            System.out.println(":: Mis citas");
            if (UiMenu.pacLogged.getCitasDoctors().size() == 0) {
                System.out.println("No tienes citas");
                break;
            }
            for (int i = 0; i < UiMenu.pacLogged.getCitasDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " + "Fecha: " + UiMenu.pacLogged.getCitasDoctors().get(i).getDate()
                        + "hora: " + UiMenu.pacLogged.getCitasDoctors().get(i).getTime()
                        + "\n Doctor: " + UiMenu.pacLogged.getCitasDoctors().get(i).getDoctor().getName());
            }
            System.out.println("0. regresar");
        } while (respuesta != 0);
    }

}
