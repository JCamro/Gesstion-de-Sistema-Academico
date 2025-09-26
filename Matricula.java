import java.util.ArrayList;

public class Matricula {
    private Alumno alumno;
    private Cursos curso;
    private ArrayList<Double> notas = new ArrayList<>();
    private double promedio;

    public Matricula(Alumno alumno, Cursos curso) {
        this.alumno=alumno;
        this.curso=curso;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public Cursos getCurso() {
        return curso;
    }
    public void agregarNota(double nota) {
        notas.add(nota);
    }
    public double calcularPromedio(){
        if (notas.isEmpty()) {
            promedio=0;
            return promedio;
        }

        double notasAcumuladas = 0;
        for (Double double1 : notas) {
            notasAcumuladas+=double1;
        }

        promedio = notasAcumuladas/notas.size(); 
        return promedio;
    }

    public double getPromedio() {
        return promedio;
    }

    public String toString() {
        return "Alumno: "+alumno.getNombre()+
                ", Apellidos: "+alumno.getApellidos()+
                ", Promedio: "+promedio;
    }
}