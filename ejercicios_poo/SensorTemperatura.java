// Ejercicio 3: Lectura de un Sensor de Temperatura
public class SensorTemperatura {

    private String idSensor;
    private double valorActual;
    private String unidad = "C";

    public SensorTemperatura(String idSensor, double valorActual, String unidad) {
        this.idSensor = idSensor;
        setUnidad(unidad);
        setValorActual(valorActual);
    }

    public String getIdSensor() {
        return idSensor;
    }

    public double getValorActual() {
        return valorActual;
    }

    public double getMinimoPermitido() {
        if (unidad.equals("C")) {
            return -273.15;
        } else if (unidad.equals("F")) {
            return -459.67;
        } else {
            return 0;
        }
    }

    public void setValorActual(double valorActual) {
        if (valorActual >= getMinimoPermitido()) {
            this.valorActual = valorActual;
        } else {
            System.out.println("Advertencia: valor por debajo del cero absoluto. No se modificó.");
        }
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        String u = unidad.toUpperCase();
        if (u.equals("C") || u.equals("F") || u.equals("K")) {
            this.unidad = u;
        } else {
            System.out.println("Advertencia: la unidad debe ser C, F o K. No se modificó.");
        }
    }

    // Cambia la unidad y convierte la lectura para que siga siendo la misma temperatura
    public void convertirUnidad(String nuevaUnidad) {
        String u = nuevaUnidad.toUpperCase();
        if (!(u.equals("C") || u.equals("F") || u.equals("K"))) {
            System.out.println("Advertencia: la unidad debe ser C, F o K. No se modificó.");
            return;
        }
        double celsius;
        if (unidad.equals("C")) {
            celsius = valorActual;
        } else if (unidad.equals("F")) {
            celsius = (valorActual - 32) * 5 / 9;
        } else {
            celsius = valorActual - 273.15;
        }
        if (u.equals("C")) {
            valorActual = celsius;
        } else if (u.equals("F")) {
            valorActual = celsius * 9 / 5 + 32;
        } else {
            valorActual = celsius + 273.15;
        }
        unidad = u;
    }

    public void mostrarLectura() {
        System.out.println("Sensor " + idSensor + ": " + String.format("%.2f", valorActual) + " °" + unidad);
    }
}