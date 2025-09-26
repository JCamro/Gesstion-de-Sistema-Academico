import java.util.ArrayList;

public class Alumno {
    private String nombres;
    private String apellidos;
    private int codigo;
    private ArrayList<Cursos> cursosQueLleva = new ArrayList<>(); 
    
    
    public Alumno(String nombres, String apellidos, int codigo) {
        setApellidos(apellidos);
        setNombre(nombres);
        setCodigo(codigo);
    } 

    public void setNombre(String nombres) {
        this.nombres=nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos=apellidos;
    }
    public void setCodigo(int codigo) {
        this.codigo=codigo;
    }

    public String getNombre() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getCodigo() {
        return codigo;
    }

    public void agregarCurso(Cursos curso) {
        cursosQueLleva.add(curso);
    }

}
