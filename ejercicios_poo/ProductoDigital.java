// Ejercicio 1: Gestión de un Producto en Tienda Online
public class ProductoDigital {

    private String nombre;
    private double precio;
    private int stock;

    public ProductoDigital(String nombre, double precio, int stock) {
        this.nombre = nombre;
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("Advertencia: el precio debe ser positivo. No se modificó.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        } else {
            System.out.println("Advertencia: el stock debe ser positivo. No se modificó.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + " | Precio: $" + String.format("%.2f", precio)
                + " | Stock: " + stock);
    }
}
