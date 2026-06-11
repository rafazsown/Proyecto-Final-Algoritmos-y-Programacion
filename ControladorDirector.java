package Control;


import Modelo.Administrador;
import Modelo.Profesor;
import Modelo.Materia;
import Modelo.Estudiante;
import Modelo.PilaCalificaciones;
import Modelo.RegistroCalificacion;
import java.util.ArrayList;
import java.util.List;

public class ControladorDirector {
    private GestorDeDatos bd;

    public ControladorDirector(GestorDeDatos bd) {
        this.bd = bd;
    }


    public void altaAdministrador(Administrador admin) {
        bd.administradores.add(admin);
        System.out.println("Administrador " + admin.getNombre() + " registrado con éxito.");
    }

    public void bajaAdministrador(String noPersonal) {
        bd.administradores.removeIf(a -> a.getNoPersonal().equals(noPersonal));
        System.out.println("Administrador eliminado.");
    }

    public void cambiarAdministrador(String noPersonal, Administrador nuevoAdmin) {
    for (int i = 0; i < bd.administradores.size(); i++) {
        if (bd.administradores.get(i).getNoPersonal().equals(noPersonal)) {
            bd.administradores.set(i, nuevoAdmin);
            System.out.println("Administrador actualizado.");
            return;
        }
    }
    System.out.println("Administrador no encontrado.");
    }

    public void altaProfesor(Profesor profe) {
        bd.profesores.add(profe);
        System.out.println("Profesor " + profe.getNombre() + " registrado con éxito.");
    }

    public void bajaProfesor(String noPersonal) {
        bd.profesores.removeIf(p -> p.getNoPersonal().equals(noPersonal));
        System.out.println("Profesor eliminado.");
    }

    public void cambiarProfesor(String noPersonal, Profesor nuevoProfe) {
    for (int i = 0; i < bd.profesores.size(); i++) {
        if (bd.profesores.get(i).getNoPersonal().equals(noPersonal)) {
            bd.profesores.set(i, nuevoProfe);
            System.out.println("Profesor actualizado.");
            return;
        }
    }
    System.out.println("Profesor no encontrado.");
    }

    public Modelo.PilaCalificaciones obtenerPilaCalificacionesPorMateria(Modelo.Materia materia) {
        Modelo.PilaCalificaciones pila = new Modelo.PilaCalificaciones();
        List<Modelo.Estudiante> alumnosCalificados = new ArrayList<>();

        for (Modelo.Estudiante est : bd.estudiantes) {
            if (est.getMaterias().contains(materia)) {
                Double nota = est.obtenerCalificacion(materia);
                if (nota != null) {
                    alumnosCalificados.add(est);
                }
            }
        }

        alumnosCalificados.sort((e1, e2) -> Double.compare(e1.obtenerCalificacion(materia), e2.obtenerCalificacion(materia)));

        for (Modelo.Estudiante est : alumnosCalificados) {
            Double nota = est.obtenerCalificacion(materia);
            if (nota != null) {
                Modelo.RegistroCalificacion registro = new Modelo.RegistroCalificacion(est, materia, nota);
                pila.agregarCalificacion(registro);
            }
        }

        return pila;
    }
}