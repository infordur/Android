package rafa.edu.eltiempo;

/**
 * Created by zaladriel on 29/02/16.
 */
public class Ciudad {
    private String nombre;
    private String pais;
    private String temp;
    private String humedad;
    private String estadoTiempo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getEstadoTiempo() {
        return estadoTiempo;
    }

    public void setEstadoTiempo(String estadoTiempo) {
        this.estadoTiempo = estadoTiempo;
    }
}
