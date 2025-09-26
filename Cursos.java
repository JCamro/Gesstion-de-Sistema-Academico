import java.util.ArrayList;

public class Cursos {
    private int codigo;
    private String nombre;
    private Docentes docente;
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    public Cursos(int codigo, String nombre, Docentes docente) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.docente=docente;
    } 


    //GETS
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public Docentes getDocente() {
        return docente;
    }

    //Se agregara a lista de matriculas del curso
    public void matricularAlumno(Alumno alumno) {
        Matricula matricula = new Matricula(alumno, this);
        matriculas.add(matricula);
    }

    public Matricula buscarMatricula(int codigoAlumno) {
        for (Matricula matricula : matriculas) {
            if (matricula.getAlumno().getCodigo() == codigoAlumno) {
                return matricula;
            }
        }
        return null; // Retorna null si no se encuentra la matrícula
    }

    public ArrayList<Matricula> getRegistroNotas() {
        return matriculas;
    }
}
