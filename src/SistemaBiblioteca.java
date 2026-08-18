import java.util.HashMap; //HashMap coleccion
import java.util.Map;

public class SistemaBiblioteca {
    private Map<String, Material> catalogo = new HashMap<>();
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }
}
