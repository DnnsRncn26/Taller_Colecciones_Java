
import java.util.HashMap; //HashMap coleccion   busca materiales por codigo
import java.util.Map;
import java.util.ArrayList;  // ArrayList mantiene la fila de espera, mantener el orden de la fila
import java.util.List;
import java.util.HashSet;  // HashSet guarda miembros sin repetir, comprobar membresia
import java.util.Set;



public class SistemaBiblioteca {
    private Map<String, Material> catalogo = new HashMap<>();
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            entrada.getValue().mostrarInfo();
        }
    }

    public void agregarEspera(String codigoMaterial, String usuario) {

        if (!listaEspera.containsKey(codigoMaterial)) {
            listaEspera.put(codigoMaterial, new ArrayList<>());
        }

        listaEspera.get(codigoMaterial).add(usuario);  //agrega usuarios al final de la fila
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> lista = listaEspera.get(codigoMaterial);
        if (lista == null || lista.isEmpty()) {   //si la linea no existe o si la linea esta vacia
            return null;  //devuelve null
        }
        return lista.remove(0); //lista.remove(0) saca al primer usuario que llegó de la fila
    }

    private Map<String, List<String>> listaEspera = new HashMap<>();
    private Set<String> miembros = new HashSet<>();  //Set<String> no permite duplicados, osea que no se repitan los usuarios o miembros

    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);  //add() devuelve false si se intenta colocar un usuario que ya existe
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);  //contains() pregunta si el usuario esta dentro del conjunto, osea si un usuario tiene membresia y esta registrado devuelve true, de lo contrario devuelve false
    }
}
