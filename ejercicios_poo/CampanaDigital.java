// Ejercicio 4: Seguimiento de Campañas Digitales
public class CampanaDigital {

    private String nombreCampana;
    private int clics;
    private int conversiones;

    public CampanaDigital(String nombreCampana, int clics, int conversiones) {
        this.nombreCampana = nombreCampana;
        setClics(clics);
        setConversiones(conversiones);
    }

    public String getNombreCampana() {
        return nombreCampana;
    }

    public void setNombreCampana(String nombreCampana) {
        this.nombreCampana = nombreCampana;
    }

    public int getClics() {
        return clics;
    }

    public void setClics(int clics) {
        if (clics > 0) {
            this.clics = clics;
        } else {
            System.out.println("Advertencia: los clics deben ser mayores que 0. No se modificó.");
        }
    }

    public int getConversiones() {
        return conversiones;
    }

    public void setConversiones(int conversiones) {
        if (conversiones >= 0 && conversiones <= clics) {
            this.conversiones = conversiones;
        } else {
            System.out.println("Advertencia: las conversiones deben estar entre 0 y el total de clics. No se modificó.");
        }
    }

    public double tasaConversion() {
        if (clics <= 0) {
            return 0;
        }
        return (double) conversiones / clics * 100;
    }

    public void mostrarReporte() {
        System.out.println("Campaña: " + nombreCampana + " | Clics: " + clics
                + " | Conversiones: " + conversiones
                + " | Tasa de conversión: " + String.format("%.2f", tasaConversion()) + "%");
    }
}
