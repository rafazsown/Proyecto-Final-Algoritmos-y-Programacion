package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Modelo.Materia;
import Modelo.Estudiante;
import Modelo.PilaCalificaciones;

import Modelo.Administrador;

public class PersistenciaAdministrador {
     public static void guardarAdministradores(List<Administrador> admins, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Administrador a : admins) {
                bw.write(a.getNoPersonal() + "," + a.getNombre() + "," + a.getCarreraAsignada());
                bw.newLine();
            }
            System.out.println("Administradores guardados en " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al guardar administradores: " + ex.getMessage());
        }
    }

    public static List<Administrador> cargarAdministradores(String archivo) {
        List<Administrador> admins = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                Administrador a = new Administrador(partes[1], "", "", "", partes[0], "2023-01-01", partes[2]);
                admins.add(a);
            }
            System.out.println("Administradores cargados desde " + archivo);
        } catch (IOException ex) {
            System.out.println("Error al cargar administradores: " + ex.getMessage());
        }
        return admins;
    }
}