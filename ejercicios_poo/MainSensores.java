// Ejercicio 3: Lectura de un Sensor de Temperatura
import java.util.Scanner;

public class MainSensores {

    public static void main(String[] args) {
        String id, unidad;
        double valor, minimo;
        int opc, cantidad, unidadOpc, pos;

        final int MAX = 5;
        SensorTemperatura sensores[] = new SensorTemperatura[MAX];
        Scanner sc = new Scanner(System.in);
        int indice = 0;

        do {
            System.out.println("\n===== SENSORES (" + indice + " de " + MAX + ") =====");
            System.out.println("1. Ingresar una cantidad de sensores");
            System.out.println("2. Ver la lectura de un sensor");
            System.out.println("3. Actualizar la lectura de un sensor");
            System.out.println("4. Corregir la unidad de un sensor");
            System.out.println("5. Mostrar los sensores ingresados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Cuántos sensores desea ingresar: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    if (cantidad > 0 && (indice + cantidad) <= MAX) {
                        int contador = 0;
                        while (contador < cantidad) {
                            System.out.print("Ingrese el identificador del sensor: ");
                            id = sc.nextLine();
                            do {
                                System.out.print("Unidad (1. C / 2. F / 3. K): ");
                                unidadOpc = Integer.parseInt(sc.nextLine());
                            } while (unidadOpc < 1 || unidadOpc > 3);
                            if (unidadOpc == 1) {
                                unidad = "C";
                            } else if (unidadOpc == 2) {
                                unidad = "F";
                            } else {
                                unidad = "K";
                            }
                            minimo = (unidad.equals("C")) ? -273.15 : (unidad.equals("F")) ? -459.67 : 0;
                            do {
                                System.out.print("Ingrese la lectura actual (mínimo " + minimo + "): ");
                                valor = Double.parseDouble(sc.nextLine());
                                if (valor < minimo) {
                                    System.out.println("El valor está por debajo del cero absoluto.");
                                }
                            } while (valor < minimo);
                            sensores[indice++] = new SensorTemperatura(id, valor, unidad);
                            contador++;
                        }
                    } else {
                        System.out.println("No hay espacio");
                    }
                    break;
                case 2:
                    if (indice == 0) {
                        System.out.println("No hay sensores ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            sensores[pos].mostrarLectura();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 3:
                    if (indice == 0) {
                        System.out.println("No hay sensores ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            minimo = sensores[pos].getMinimoPermitido();
                            do {
                                System.out.print("Ingrese la nueva lectura (mínimo " + minimo + "): ");
                                valor = Double.parseDouble(sc.nextLine());
                                if (valor < minimo) {
                                    System.out.println("El valor está por debajo del cero absoluto.");
                                }
                            } while (valor < minimo);
                            sensores[pos].setValorActual(valor);
                            sensores[pos].mostrarLectura();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 4:
                    if (indice == 0) {
                        System.out.println("No hay sensores ingresados.");
                    } else {
                        System.out.print("Ingrese el índice (0 a " + (indice - 1) + "): ");
                        pos = Integer.parseInt(sc.nextLine());
                        if (pos >= 0 && pos < indice) {
                            do {
                                System.out.print("Unidad (1. C / 2. F / 3. K): ");
                                unidadOpc = Integer.parseInt(sc.nextLine());
                            } while (unidadOpc < 1 || unidadOpc > 3);
                            if (unidadOpc == 1) {
                                unidad = "C";
                            } else if (unidadOpc == 2) {
                                unidad = "F";
                            } else {
                                unidad = "K";
                            }
                            sensores[pos].convertirUnidad(unidad);
                            sensores[pos].mostrarLectura();
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    }
                    break;
                case 5:
                    if (indice == 0) {
                        System.out.println("No hay sensores ingresados.");
                    }
                    for (int i = 0; i < indice; i++) {
                        System.out.print("[" + i + "] ");
                        sensores[i].mostrarLectura();
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