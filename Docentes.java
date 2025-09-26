public class Docentes {
    private String nombres;
    private String apellidos;
    private String especialidad;
    private int DNI;
    private int añosExperiencia;
    
    public Docentes(String nombres, String apellidos, int DNI, String especialidad, int añosExperiencia) {
        setApellidos(apellidos);
        setNombre(nombres);
        setDNI(DNI);
        setAñosExperiencia(añosExperiencia);
        setEspecialidad(especialidad);
    } 

    public void setNombre(String nombres) {
        this.nombres=nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos=apellidos;
    }
    public void setDNI(int DNI) {
        this.DNI=DNI;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad=especialidad;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia=añosExperiencia;
    }


    public String getNombre() {
        return nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getDNI() {
        return DNI;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public int getAñosExperiencia() {
        return añosExperiencia;
    }
}
