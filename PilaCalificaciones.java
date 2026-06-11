package Modelo;

import java.util.Stack;

public class PilaCalificaciones {
    private Stack<RegistroCalificacion> calificaciones;

    public PilaCalificaciones() {
        calificaciones = new Stack<>();
    }

    public void agregarCalificacion(RegistroCalificacion registro) {
        calificaciones.push(registro);
    }

    public RegistroCalificacion quitarUltimaCalificacion() {
        if (!calificaciones.isEmpty()) {
            return calificaciones.pop();
        }
        return null;
    }

    public RegistroCalificacion verUltimaCalificacion() {
        if (!calificaciones.isEmpty()) {
            return calificaciones.peek();
        }
        return null;
    }

    public boolean estaVacia() {
        return calificaciones.isEmpty();
    }
}