package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modelo.Estudiante;

public class PersistenciaEstudiante {
    public static void guardarEstudiantes(List<Estudiante> estudiantes, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Estudiante e : estudiantes) {
                bw.write(e.getMatricula() + "," + e.getNombre() + "," + e.getSemestre() + "," + e.getCorreo());
                bw.newLine();
            }
            System.out.println("Estudiantes guardados en " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al guardar estudiantes: " + ex.getMessage());
        }
    }

    public static List<Estudiante> cargarEstudiantes(String archivo) {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Estudiante e = new Estudiante(partes[1], "", partes[3], "", partes[0], "2023-01-01", Integer.parseInt(partes[2]));
                estudiantes.add(e);
            }
            System.out.println("Estudiantes cargados desde " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al cargar estudiantes: " + ex.getMessage());
        }
        return estudiantes;
    }
}