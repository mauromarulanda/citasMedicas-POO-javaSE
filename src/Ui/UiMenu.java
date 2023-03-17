package Ui;

import modelo.Doctor;
import modelo.Paciente;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UiMenu {
    public static final String[] months = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
    public static Doctor docLogged;
    public static Paciente pacLogged;

    public static void showMenu() {
        System.out.println("BIENVENIDO A MIS CITAS");
        System.out.println("SELECCIONA UNA OPCION");
        int respuesta = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextInt();
            switch (respuesta) {
                case 1:
                    System.out.println("doctor");
                    respuesta = 0;
                    autenticador(1);
                    break;
                case 2:
                    respuesta = 0;
                    // showPatientMenu();
                    autenticador(2);
                    break;
                case 0:
                    System.out.println("gracias por su visita");
                    break;
                default:
                    System.out.println("seleccione una opcion correcta");
                    break;
            }
        } while (respuesta != 0);
    }

    private static void autenticador(int tipoUsuario) {
        //usurio tipo 1 = doctor
        //usuario tipo 2 = paciente.
        ArrayList<Doctor> doc = new ArrayList<>();
        doc.add(new Doctor("mauro", "mauro@email.com", "123"));
        doc.add(new Doctor("pepito", "pepito@email.com", "456"));
        doc.add(new Doctor("pepita", "pepita@email.com", "789"));

        ArrayList<Paciente> pat = new ArrayList<>();
        pat.add(new Paciente("jose", "jose@email.com", "111"));
        pat.add(new Paciente("gonzalo", "gonzalo@email.com", "56"));
        pat.add(new Paciente("sapo perro", "sapoperro@email.com", "17711"));

        boolean emm = false;
        do {
            System.out.println("ingresa tu email: example: a@email.com ");
            Scanner sc = new Scanner(System.in);
            String entrada = sc.nextLine();
            if (tipoUsuario == 1) {
                for (Doctor dc : doc) {
                    if (dc.getEmail().equals(entrada)) {
                        emm = true;
                        docLogged = dc;
                        UiDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (tipoUsuario == 2) {
                for (Paciente p : pat) {
                    if (p.getEmail().equals(entrada)) {
                        emm = true;
                        pacLogged = p;
                        UiPacienteMenu.showPatientMenu();
                    }
                }
            }
        } while (!emm);
    }


}
