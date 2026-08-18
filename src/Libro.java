public class Libro extends Material { //con extends hereda de Material, osea Libro es un tipo de Material
    private String autor;  //estas dos caracteristicas solo las tiene Libro
    private String isbn;

    public Libro(String codigo, String titulo, int anio, boolean disponible, String autor, String isbn) {
        super(codigo, titulo, anio, disponible);  //aqui se llama al constructor del padre, padre es Material
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override // con @Override se esta reemplazando el metodo que heredo del padre
    public String getTipo() {  //Libro debe implmentar getTipo()
        return "Libro";
    }
}
