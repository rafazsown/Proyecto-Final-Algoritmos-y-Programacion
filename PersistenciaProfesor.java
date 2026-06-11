package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Profesor;

public class PersistenciaProfesor {
    public static void guardarProfesores(List<Profesor> profesores, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Profesor p : profesores) {
                bw.write(p.getNoPersonal() + "," + p.getNombre() + "," + p.getFechaIngreso());
                bw.newLine();
            }
            System.out.println("Profesores guardados en " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al guardar profesores: " + ex.getMessage());
        }
    }

    public static List<Profesor> cargarProfesores(String archivo) {
        List<Profesor> profesores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Profesor p = new Profesor(partes[1], "", "", "", partes[0], partes[2]);
                profesores.add(p);
            }
            System.out.println("Profesores cargados desde " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al cargar profesores: " + ex.getMessage());
        }
        return profesores;
    }
}