package Control;

import Modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDeDatos implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Administrador> administradores = new ArrayList<>();
    public List<Profesor> profesores = new ArrayList<>();
    public List<Estudiante> estudiantes = new ArrayList<>();
    public List<Materia> materiasDisponibles = new ArrayList<>();

    public GestorDeDatos() {
    }

    public static void guardarDatos(GestorDeDatos bd, String rutaArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(bd);
            System.out.println("Base de datos guardada exitosamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la base de datos: " + e.getMessage());
        }
    }

    public static GestorDeDatos cargarDatos(String rutaArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            GestorDeDatos bdCargada = (GestorDeDatos) ois.readObject();
            System.out.println("Base de datos cargada correctamente.");
            return bdCargada;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se encontró archivo previo. Se iniciará una base de datos limpia.");
            return new GestorDeDatos();
        }
    }
}