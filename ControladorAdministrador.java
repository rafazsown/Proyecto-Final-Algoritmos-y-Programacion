package Control;

import Excepciones.ReglaDeNegocio;
import Modelo.Estudiante;
import Modelo.Materia;
import java.util.List;

public class ControladorAdministrador {
    private GestorDeDatos bd;

    public ControladorAdministrador(GestorDeDatos bd) {
        this.bd = bd;
    }

    public void altaEstudiante(Estudiante est) {
        bd.estudiantes.add(est);
        System.out.println("Estudiante " + est.getNombre() + " registrado en el sistema.");
    }

    public void bajaEstudiante(String matricula) {
        bd.estudiantes.removeIf(e -> e.getMatricula().equals(matricula));
        System.out.println("Estudiante eliminado.");
    }

    public void cambiarEstudiante(String matricula, String nuevoNombre, int nuevoSemestre) {
        for (Estudiante e : bd.estudiantes) {
            if (e.getMatricula().equals(matricula)) {
                e.setNombre(nuevoNombre);
                e.setSemestre(nuevoSemestre);
                System.out.println("Estudiante " + matricula + " actualizado.");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }



    public void asignarMateriasAEstudiante(String matricula, List<Materia> materiasAAsignar) throws ReglaDeNegocio {
        Estudiante estudianteEncontrado = null;
        for (Estudiante e : bd.estudiantes) {
            if (e.getMatricula().equals(matricula)) {
                estudianteEncontrado = e;
                break;
            }
        }

        if (estudianteEncontrado != null) {
            if (materiasAAsignar.size() >= 5) {
                for (Materia m : materiasAAsignar) {
                    estudianteEncontrado.agregarMateria(m);
                }
                System.out.println("Materias asignadas correctamente al estudiante " + matricula);
            } else {
                throw new ReglaDeNegocio("El estudiante DEBE tener al menos 5 materias asignadas.");
            }
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
}