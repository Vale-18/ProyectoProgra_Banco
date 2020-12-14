package proyecto;
public class Clientes {

    OperacionesGenerales operacion = new OperacionesGenerales();

    private String cedula;
    private String nombre;
    private String numTelefono;
    private int edad;
    private double saldo = 0;
    private int idCuenta;

    public Clientes(String cedula, String nombre, String numTelefono, int edad, int idCuenta) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
        this.edad = edad;
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
