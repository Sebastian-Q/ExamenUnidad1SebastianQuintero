public class DaoArchivo {
    private int id;
    private String nombre;
    private String primerApellido;
    private String segudnoApellido;
    private String curp;
    private String fecha;
    private String rfc;

    public DaoArchivo(){
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPrimerApellido() { return primerApellido; }

    public void setPrimerApellido(String primerApellido) { this.primerApellido = primerApellido; }

    public String getSegudnoApellido() { return segudnoApellido; }

    public void setSegudnoApellido(String segudnoApellido) { this.segudnoApellido = segudnoApellido; }

    public String getCurp() { return curp; }

    public void setCurp(String curp) { this.curp = curp; }

    public String getFecha() { return fecha; }

    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getRfc() { return rfc; }

    public void setRfc(String rfc) { this.rfc = rfc; }
}

