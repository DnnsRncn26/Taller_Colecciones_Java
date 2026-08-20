public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca(); //aqui se esta creando un objeto de la biblioteca


    Libro libro1 = new Libro(
            "BK-001",
            "Erase una vez",
            2026,
            false,  //false quiere decir que el libro no esta disponible, esta prestado
            "Shirley Lopez",
            "20142911"
    );

    Libro libro2 = new Libro(
            "BK-002",
            "Las aventuras de tintin",
            1997,
            true,
            "Yeimi Martinez",
            "20141111"
    );

    Revista revista1 = new Revista(
            "RV-001",
            "Las hermanas calle",
            2020,
            true,
            160,
            "Farándula"
    );

    Revista revista2 = new Revista(
            "RV-002",
            "Los chismes de hoy",
            2026,
            true,
            210,
            "Comedia"
    );

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);
        biblioteca.registrarMaterial(revista2);

        System.out.println("Catálogo");
        biblioteca.mostrarCatalogo();

        System.out.println("\n Buscar material");

        Material encontrado = biblioteca.buscarMaterial("BK-001");  //aqui quiere decir busca en HashMap el material que tenga este codigo

        if (encontrado != null) {  //se pregunta si encontro algo o no
            encontrado.mostrarInfo();
        } else {
            System.out.println("Material no encontrado");
        }

        Material noEncontrado = biblioteca.buscarMaterial("BK-12345");  //se pregumta si se encontro este codigo

        if (noEncontrado != null) {
            noEncontrado.mostrarInfo();
        } else {
            System.out.println("Material no encontrado");
        }

        System.out.println("\n Lista de espera");

        biblioteca.agregarEspera("BK-001", "Gloria"); //aqui Gloria esta en lista de espera para tomar el libro prestado
        biblioteca.agregarEspera("BK-001", "Nicolas"); //luego sigue Nicolas y de ultimas Robinson
        biblioteca.agregarEspera("BK-001", "Robinson");

        System.out.println(biblioteca.siguienteEnEspera("BK-001"));
        System.out.println(biblioteca.siguienteEnEspera("BK-001"));


        System.out.println("Membresías:");
        System.out.println(biblioteca.registrarMiembro("Gloria"));  //hashset no permite duplicados de usuarios
        System.out.println(biblioteca.registrarMiembro("Nicolas")); //este se registro correctamente
        System.out.println(biblioteca.registrarMiembro("SilvaMarce"));
        System.out.println(biblioteca.registrarMiembro("Gloria"));  //intente registrar a Gloria de nuevo y me salio false
        System.out.println(biblioteca.tieneMembresia("Nicolas"));  //da true, porque si tiene membresia
        System.out.println(biblioteca.tieneMembresia("AngieFer")); //false porque AngieFer no tiene membresia
}
}