public abstract class Material implements Catalogable { //abstract quiere decir que no se va a crear directamente un objeto llamado Material
    protected String codigo;
    protected String titulo;
    protected int anio;
    protected boolean disponible;

    public Material(String codigo, String titulo, int anio, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public abstract String getTipo(); //aqui es poliformismo porque aunque esta declarado aqui en material, java utiliza el getTipo de la clase Libro

    public void mostrarInfo() {
        String estado = disponible ? "disponible" : "prestado";

        System.out.println(
                "[" + getTipo() + "] " +
                        titulo + " (" + anio + ") — " +
                        estado
        );
    }
}