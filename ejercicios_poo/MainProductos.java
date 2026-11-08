// Ejercicio 1: Gestión de un Producto en Tienda Online
import java.util.Scanner;

public class MainProductos {

    public static void main(String[] args) {
        String nombre;
        double precio, porcentaje, total;
        int stock, opc;
        boolean lleno = false;

        final int MAX = 3;
        ProductoDigital productos[] = new ProductoDigital[MAX];
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n===== PRODUCTOS DIGITALES =====");
            System.out.println("1. Ingresar todos los productos");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Cambiar el precio de todos (%)");
            System.out.println("4. Valor total del inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    for (int i = 0; i < productos.length; i++) {
                        System.out.println("--- Producto " + (i + 1) + " de " + productos.length + " ---");
                        System.out.print("Ingrese el nombre: ");
                        nombre = sc.nextLine();
                        do {
                            System.out.print("Ingrese el precio: ");
                            precio = Double.parseDouble(sc.nextLine());
                            if (precio <= 0) {
                                System.out.println("El precio debe ser positivo.");
                            }
                        } while (precio <= 0);
                        do {
                            System.out.print("Ingrese el stock: ");
                            stock = Integer.parseInt(sc.nextLine());
                            if (stock <= 0) {
                                System.out.println("El stock debe ser positivo.");
                            }
                        } while (stock <= 0);
                        productos[i] = new ProductoDigital(nombre, precio, stock);
                    }
                    lleno = true;
                    break;
                case 2:
                    if (lleno) {
                        for (int i = 0; i < productos.length; i++) {
                            productos[i].mostrarInfo();
                        }
                    } else {
                        System.out.println("Primero debe ingresar los productos.");
                    }
                    break;
                case 3:
                    if (lleno) {
                        System.out.print("Porcentaje de cambio (ej. 10 sube, -10 baja): ");
                        porcentaje = Double.parseDouble(sc.nextLine());
                        for (int i = 0; i < productos.length; i++) {
                            productos[i].setPrecio(productos[i].getPrecio() * (1 + porcentaje / 100));
                        }
                        for (int i = 0; i < productos.length; i++) {
                            productos[i].mostrarInfo();
                        }
                    } else {
                        System.out.println("Primero debe ingresar los productos.");
                    }
                    break;
                case 4:
                    if (lleno) {
                        total = 0;
                        for (int i = 0; i < productos.length; i++) {
                            total += productos[i].getPrecio() * productos[i].getStock();
                        }
                        System.out.println("Valor total del inventario: $" + String.format("%.2f", total));
                    } else {
                        System.out.println("Primero debe ingresar los productos.");
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
