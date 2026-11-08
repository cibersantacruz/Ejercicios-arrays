// Ejercicio 4: Seguimiento de Campañas Digitales
import java.util.Scanner;

public class MainCampanas {

    public static void main(String[] args) {
        String nombre;
        int clics, conversiones, extra, mejor, opc;
        double suma;
        boolean lleno = false;

        final int MAX = 3;
        CampanaDigital campanas[] = new CampanaDigital[MAX];
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n===== CAMPAÑAS DIGITALES =====");
            System.out.println("1. Ingresar todas las campañas");
            System.out.println("2. Mostrar el reporte de todas");
            System.out.println("3. Tasa de conversión promedio");
            System.out.println("4. Campaña con mejor tasa de conversión");
            System.out.println("5. Sumar clics a todas las campañas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    for (int i = 0; i < campanas.length; i++) {
                        System.out.println("--- Campaña " + (i + 1) + " de " + campanas.length + " ---");
                        System.out.print("Ingrese el nombre de la campaña: ");
                        nombre = sc.nextLine();
                        do {
                            System.out.print("Ingrese los clics: ");
                            clics = Integer.parseInt(sc.nextLine());
                            if (clics <= 0) {
                                System.out.println("Los clics deben ser mayores que 0.");
                            }
                        } while (clics <= 0);
                        do {
                            System.out.print("Ingrese las conversiones (0 a " + clics + "): ");
                            conversiones = Integer.parseInt(sc.nextLine());
                        } while (conversiones < 0 || conversiones > clics);
                        campanas[i] = new CampanaDigital(nombre, clics, conversiones);
                    }
                    lleno = true;
                    break;
                case 2:
                    if (lleno) {
                        for (int i = 0; i < campanas.length; i++) {
                            campanas[i].mostrarReporte();
                        }
                    } else {
                        System.out.println("Primero debe ingresar las campañas.");
                    }
                    break;
                case 3:
                    if (lleno) {
                        suma = 0;
                        for (int i = 0; i < campanas.length; i++) {
                            suma += campanas[i].tasaConversion();
                        }
                        System.out.println("Tasa de conversión promedio: "
                                + String.format("%.2f", suma / campanas.length) + "%");
                    } else {
                        System.out.println("Primero debe ingresar las campañas.");
                    }
                    break;
                case 4:
                    if (lleno) {
                        mejor = 0;
                        for (int i = 1; i < campanas.length; i++) {
                            if (campanas[i].tasaConversion() > campanas[mejor].tasaConversion()) {
                                mejor = i;
                            }
                        }
                        campanas[mejor].mostrarReporte();
                    } else {
                        System.out.println("Primero debe ingresar las campañas.");
                    }
                    break;
                case 5:
                    if (lleno) {
                        do {
                            System.out.print("Clics a sumar a cada campaña: ");
                            extra = Integer.parseInt(sc.nextLine());
                        } while (extra <= 0);
                        for (int i = 0; i < campanas.length; i++) {
                            campanas[i].setClics(campanas[i].getClics() + extra);
                        }
                        for (int i = 0; i < campanas.length; i++) {
                            campanas[i].mostrarReporte();
                        }
                    } else {
                        System.out.println("Primero debe ingresar las campañas.");
                    }
                    break;
                case 6:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("No existe la opción.");
                    break;
            }
        } while (opc != 6);
    }
}
