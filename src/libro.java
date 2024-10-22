import java.util.ArrayList;
import java.util.List;

class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;

    // Constructor, getters y setters
    public Libro(int id, String titulo, String autor, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
}

interface LibroDAO {
    void agregarLibro(Libro libro);
    Libro obtenerLibro(int id);
    void eliminarLibro(int id);
}

class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros = new ArrayList<>();

    @Override
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    @Override
    public Libro obtenerLibro(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void eliminarLibro(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }
}

public class libro {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        Libro libro1 = new Libro(1, "El Quijote", "Cervantes", 1605);
        libroDAO.agregarLibro(libro1);

        Libro libroRecuperado = libroDAO.obtenerLibro(1);
        System.out.println("Libro recuperado: " + libroRecuperado.getTitulo());

        libroDAO.eliminarLibro(1);
        System.out.println("Libro eliminado.");
    }
}
