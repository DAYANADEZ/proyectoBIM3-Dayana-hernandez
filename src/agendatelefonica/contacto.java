package agendatelefonica;

public class contacto {

    private String telefono, nombre, domicilio;

    public contacto(String telefono, String nombre, String domicilio) {
        this.nombre = telefono;
        this.telefono = nombre;
        this.domicilio = domicilio;
        
    }public String verNombre() {
        return this.nombre;
        
    }public String verNumero() {
        return this.telefono;
        
    }public String verDomicilio() {
        return this.domicilio;
        
    }public void SetNumero(String telefono) {
        this.telefono = telefono;
        
    }public void SetNombre(String nombre) {
        this.nombre = nombre;
        
    }public void SetDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}



