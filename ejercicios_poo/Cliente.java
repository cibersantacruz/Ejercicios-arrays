// Ejercicio 2: Cálculo de Descuento para Clientes
public class Cliente {

    private String nombre;
    private String tipoCliente = "estándar";
    private double totalCompra;

    public Cliente(String nombre, String tipoCliente, double totalCompra) {
        this.nombre = nombre;
        setTipoCliente(tipoCliente);
        setTotalCompra(totalCompra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        String t = tipoCliente.toLowerCase().replace('á', 'a');
        if (t.equals("premium")) {
            this.tipoCliente = "premium";
        } else if (t.equals("estandar")) {
            this.tipoCliente = "estándar";
        } else {
            System.out.println("Advertencia: el tipo debe ser premium o estándar. No se modificó.");
        }
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        if (totalCompra >= 0) {
            this.totalCompra = totalCompra;
        } else {
            System.out.println("Advertencia: el total de compra no puede ser negativo. No se modificó.");
        }
    }

    public double calcularDescuento() {
        double porcentaje = tipoCliente.equals("premium") ? 0.20 : 0.10;
        return totalCompra * porcentaje;
    }

    public void mostrarResumen() {
        double descuento = calcularDescuento();
        double montoFinal = totalCompra - descuento;
        System.out.println("Cliente: " + nombre + " | Tipo: " + tipoCliente);
        System.out.println("  Total de compra: $" + String.format("%.2f", totalCompra));
        System.out.println("  Descuento:       $" + String.format("%.2f", descuento));
        System.out.println("  Monto final:     $" + String.format("%.2f", montoFinal));
    }
}
