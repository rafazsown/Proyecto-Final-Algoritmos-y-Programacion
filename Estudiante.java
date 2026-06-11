    package Modelo;

    import Interfaces.Promediable;
    import java.util.ArrayList;
    import java.util.List;

    public class Estudiante extends Persona implements Promediable{
        private String matricula;
        private String fechaIngreso;
        private int semestre;
        private List<Materia> materias;
        private List<Double> calificaciones;

        public Estudiante(String nombre, String curp, String correo, String telefono, String matricula, String fechaIngreso, int semestre) {
            super(nombre, curp, correo, telefono);
            this.matricula = matricula;
            this.fechaIngreso = fechaIngreso;
            this.semestre = semestre;
            this.materias = new ArrayList<>();
            this.calificaciones = new ArrayList<>();
        }

        public void agregarMateria(Materia materia) {
            this.materias.add(materia);
            calificaciones.add(null);
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getFechaIngreso() {
            return fechaIngreso;
        }

        public void setFechaIngreso(String fechaIngreso) {
            this.fechaIngreso = fechaIngreso;
        }

        public int getSemestre() {
            return semestre;
        }

        public void setSemestre(int semestre) {
            this.semestre = semestre;
        }

        public List<Materia> getMaterias() {
            return materias;
        }

        public void setMaterias(List<Materia> materias) {
            this.materias = materias;
        }

        public void actualizarCalificacion(Materia materia, double nota) {
            int index = materias.indexOf(materia);
            if (index != -1) {
                calificaciones.set(index, nota);
            }
        }

        public Double obtenerCalificacion(Materia materia) {
            int index = materias.indexOf(materia);
            return (index != -1) ? calificaciones.get(index) : null;
        }

        @Override
        public double calcularPromedio() {
            double suma = 0;
            int contador = 0;
            for (Double nota : calificaciones) {
                if (nota != null) {
                    suma += nota;
                    contador++;
                }
            }
            return (contador > 0) ? suma / contador : 0;
        }
    }