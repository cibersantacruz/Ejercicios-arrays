// Ejercicio 2: Cálculo de Descuento para Clientes
import java.util.Scanner;

public class MainClientes {

    public static void main(String[] args) {
        String nombre, tipo;
        double total;
        int opc, tipoOpc, pos;

        final int MAX = 3;
        Cliente clientes[] = new Cliente[MAX];
        Scanner sc = new Scanner(System.in);
        int indice = 0;

        do {
            System.out.println("\n===== CLIENTES (" + indice + " de " + MAX + ") =====");
            System.out.println("1. Ingresar un cliente");
            System.out.println("2. Ver resumen de un cliente");
            System.out.println("3. Modificar el total de compra de un cliente");
            System.out.println("4. Cambiar el tipo de un cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    if (indice < MAX) {
                        System.out.print("Ingrese el nombre: ");
                        nombre = sc.nextLine();
                        do {
                            System.out.print("Tipo de cliente (1. premium / 2. estándar): ");
                            tipoOpc = Integer.parseInt(sc.nextLine());
                        } while (tipoOpc != 1 && tipoOpc != 2);
                        tipo = (tipoOpc == 1) ? "premium" : "estándar";
                        do {
                            System.out.print("Ingrese el total de la compra: ");
                            total = Double.parseDouble(sc.nextLine());
                            if (total < 0) {
                                System.out.println("El total no puede ser negativo.");
                            }
                        } while (total < 0);
                        clientes[indice++] = new Cliente(nombre, tipo, total);
                    } else {
                        System.out.println("No hay más memoria");
                    }
                    break;
                case 2:
                    if (indice == 0) {
                        System.out.println("No hay clientes ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            clientes[pos].mostrarResumen();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 3:
                    if (indice == 0) {
                        System.out.println("No hay clientes ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            System.out.print("Ingrese el nuevo total de la compra: ");
                            total = Double.parseDouble(sc.nextLine());
                            clientes[pos].setTotalCompra(total);
                            clientes[pos].mostrarResumen();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 4:
                    if (indice == 0) {
                        System.out.println("No hay clientes ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            do {
                                System.out.print("Tipo de cliente (1. premium / 2. estándar): ");
                                tipoOpc = Integer.parseInt(sc.nextLine());
                            } while (tipoOpc != 1 && tipoOpc != 2);
                            tipo = (tipoOpc == 1) ? "premium" : "estándar";
                            clientes[pos].setTipoCliente(tipo);
                            clientes[pos].mostrarResumen();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("No existe la opción.");
                    break;
            }
        } while (opc != 5);
    }
}
