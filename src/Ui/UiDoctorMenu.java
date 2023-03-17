package Ui;

import modelo.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UiDoctorMenu {
    public static ArrayList<Doctor> doctorsCitasDisponibles = new ArrayList<>();

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Bienvenido " + UiMenu.docLogged.getName());
            System.out.println("1. agregar citas disponibles");
            System.out.println("2. mis citas agendadas");
            System.out.println("0. Salir");
            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();
            switch (response) {
                case 1:
                    showAddCitasDisponibles();
                    break;
                case 2:
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
                default:
                    break;
            }

        } while (response != 0);
    }

    private static void showAddCitasDisponibles() {
        int response = 0;
        do {
            System.out.println(":: agregar cita disponible");
            System.out.println(":: selecciona un mes");
            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UiMenu.months[i]);
            }
            System.out.println("0. regresar");
            Scanner sc = new Scanner(System.in);
            response = sc.nextInt();
            if (response > 0 && response < 4) {
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UiMenu.months[monthSelected-1]);
                System.out.println("ingrese la fecha de la cita: [dd/mm/yy]");
                String fecha = sc.nextLine();
                System.out.println("la fecha es: " + fecha + "\n1.correcto\n2.incorrecto");
                int valor = sc.nextInt();
                if (valor == 2) continue;
                int resTime = 0;
                String time = "";
                do {
                    System.out.println("ingrese el la hora disponible para la cita: " + fecha + "@EX: [00:00]");
                    time = sc.nextLine();
                    System.out.println("el tiempo es: " + time + "\n1. 6correcto\n2.incorrecto");
                    resTime = sc.nextInt();
                } while (resTime == 2);
                UiMenu.docLogged.addCitasMedicas(fecha, time);
                validarCitasDoctor(UiMenu.docLogged);
            } else if (response == 0) {
                showDoctorMenu();
            }

        } while (response != 0);
    }

    private static void validarCitasDoctor(Doctor doctor) {
        if (doctor.getCitaDisponible().size() > 0 && !doctorsCitasDisponibles.contains(doctor)) {
            doctorsCitasDisponibles.add(doctor);
        }
    }
}
