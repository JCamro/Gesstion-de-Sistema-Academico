import java.util.ArrayList;

public class Gestion {
    ArrayList<Cursos> lista_cursos = new ArrayList<>();
    ArrayList<Alumno> lista_alumnos = new ArrayList<>();
    ArrayList<Docentes> lista_docentes = new ArrayList<>();


    //AGREGAR CURSO VALIDO---------------------------  (YA ESTA)
    public void agregarCurso(int codigo, String nombre, int DNIDOCENTE) {


        if (!VerificarTodoLetras(nombre)) {
            System.out.println("No se pueden incluir numeros en el nombre del curso, no se agrego curso");
            return;
        }

        if (buscarDocente(DNIDOCENTE)==null) {
            System.out.println("El docente no existe, no se agrego curso");
            return;
        }

        if (existeCurso(codigo)) {
            System.out.println("El curso ya existe, no se agrego curso");
            return;
        }

        lista_cursos.add(new Cursos(codigo, nombre, buscarDocente(DNIDOCENTE)));
        System.out.println("Se agrego correctamente el Curso "+nombre);
        
    }
    //----------------------------------------------------------------------------



    //AGREGAR ALUMNO VALIDO-------------------------------- (YA ESTA)
    public void agregarAlumno(String nombres, String apellidos, int codigo) {
        
        if (!VerificarTodoLetras(nombres) || !VerificarTodoLetras(apellidos)) {
            System.out.println("No se pueden incluir numeros en nombres o apellidos, no se agrego alumno");
            return;
        }

        if (validarCodigoAlumno(codigo)) {
            lista_alumnos.add(new Alumno(nombres, apellidos, codigo));
            System.out.println("Se agrego correctamente alumno "+nombres);
        }
        else {
            System.out.println("Codigo de Alumno ya existente no se agregaron cambios");
        }
    }
    //------------------------------------------------------------------------------------------



    //AGREGAR DOCENTE VALIDO-------------------------------------------------------------------(YA ESTA)
    public void agregarDocente(int DNI, String nombres, String apellidos, String especialidad) {
        
        if (!validarDNI(DNI)) {
            System.out.println("DNI invalido, debe tener 8 digitos");
            return;
        }
        if (!VerificarTodoLetras(nombres) || !VerificarTodoLetras(apellidos)) {
            System.out.println("No se pueden incluir numeros en nombres o apellidos, no se agrego Docente");
            return;
        }
        if (!VerificarTodoLetras(especialidad)) {
            System.out.println("No se pueden incluir numeros en la especialidad");
            return;
        }
        

        if (validarDocente(DNI)) {
            lista_docentes.add(new Docentes(nombres, apellidos, DNI, especialidad, DNI));
            System.out.println("Se agrego correctamente Docente "+nombres);
        }
        else {
            System.out.println("Docente ya registrado, no se agrego nada");
        }
    }
    //----------------------------------------------------------------------------------------



    //MATRICULAR ALUMNO EN CURSO---------------------------------------------------------------------------
    public void matricularAlumno(int codigoAlumno, int codigoCurso) {
        
        Cursos curso = buscarCurso(codigoCurso);
        Alumno alumno = buscarAlumno(codigoAlumno);

        if (curso==null) {
            System.out.println("Curso no registrado, no se realizo la matricula");
            return;
        }
        if (alumno==null) {
            System.out.println("Alumno no registrado, no se realizo la matricula");
            return;
        }
        if (estaMatriculado(codigoAlumno, codigoCurso)) {
            System.out.println("El alumno "+alumno.getNombre()+" ya esta matriculado en "+curso.getNombre());
            return;
        }

        curso.matricularAlumno(alumno);
        System.out.println("Se matriculo a "+alumno.getNombre()+" en "+curso.getNombre()+" correctamente");   
    }
    //---------------------------------------------------------------------------------------------------------



    //REGISTRAR NOTAS------------------------------------------------------------------------------------
    public void registrarNotas(int codigoAlumno, int codigoCurso, double nota1, double nota2, double nota3) {
        
        Cursos curso = buscarCurso(codigoCurso);
        if (curso==null) {
            System.out.println("El curso no existe");
            return;
        }

        if (buscarAlumno(codigoAlumno)==null) {
            System.out.println("El alumno no existe");
            return;
        }

        if (!estaMatriculado(codigoAlumno, codigoCurso)) {
            System.out.println("El alumno "+buscarAlumno(codigoAlumno).getNombre()+" no esta matriculado en "+ buscarCurso(codigoCurso).getNombre());
            return;
        }

    
        Matricula matricula = curso.buscarMatricula(codigoAlumno);

        if (esNotaValida(nota1) && esNotaValida(nota2) && esNotaValida(nota3)) {
            matricula.agregarNota(nota3);
            matricula.agregarNota(nota2);
            matricula.agregarNota(nota1);
            System.out.println("Se agregaron las notas correctamente");
        } 
        else {
            System.out.println("Una o más notas son inválidas (deben estar entre 0 y 20).");
        }        
    }
    //-----------------------------------------------------------------------------------------------------------------------------

    //CALCULAR PROMEDIO--------------------------------------------------------------------------------
    public double calcularPromedio(int codigoAlumno, int codigoCurso) {
        Cursos curso = buscarCurso(codigoCurso);

        if (curso==null) {
            System.out.println("Curso no registrado");
            return -1;
        }

        if (curso.buscarMatricula(codigoAlumno)==null) {
            System.out.println("Alumno no matriculado en "+curso.getNombre());
            return -1;
        }

        return curso.buscarMatricula(codigoAlumno).calcularPromedio();
    }
    //-----------------------------------------------------------------------------------------------


    //MUESTRA EL ALUMNO CON MAYOR PROMEDIO EN UN CURSO-------------------------------------------------------
    public void alumnoMayorPromedio(int codigoCurso) {
        Cursos curso = buscarCurso(codigoCurso);

        if (curso==null) {
            System.out.println("Curso no registrado");
        }

        ArrayList<Matricula> registro = curso.getRegistroNotas();

        Matricula matriculaMayorPromedio = registro.get(0);    
        for (int i = 0; i < curso.getRegistroNotas().size(); i++) {
            if (registro.get(i).getPromedio()>matriculaMayorPromedio.getPromedio()) {
                matriculaMayorPromedio = registro.get(i);
            }    
        }
        System.out.println(matriculaMayorPromedio);
    }
    //-----------------------------------------------------------------------------------------------

    //MUESTRA ALUMNOS APROBADOS Y DESAPROBADOS EN UN CURSO
    public void mostrarAprobados(int codigoCurso) {
        Cursos curso = buscarCurso(codigoCurso);

        if (curso==null) {
            System.out.println("Curso no registrado");
            return;
        }

        ArrayList<Matricula> registro = curso.getRegistroNotas();
        if (curso.getRegistroNotas().isEmpty()) {
            System.out.println("No hay alumnos matriculados en el curso");
            return;
        }

        System.out.println("<<<<Alumnos aprobados en el curso "+curso.getNombre()+":>>>>");
        for (int i = 0; i < curso.getRegistroNotas().size(); i++) {
            if (registro.get(i).getPromedio()>=11) {
                System.out.println(registro.get(i));
            }    
        }
    }

    public void mostrarDesaprobados(int codigoCurso) {
        Cursos curso = buscarCurso(codigoCurso);

        if (curso==null) {
            System.out.println("Curso no registrado");
            return;
        }

        ArrayList<Matricula> registro = curso.getRegistroNotas();

        System.out.println("<<<<Alumnos desaprobados en el curso "+curso.getNombre()+">>>>:");
        for (int i = 0; i < curso.getRegistroNotas().size(); i++) {
            if (registro.get(i).getPromedio()<11) {
                System.out.println(registro.get(i));
            }    
        }
    }
    //-----------------------------------------------------------------------------------------------

    //METODOS UTILIZADOS--------------------------------------------------------------
    private boolean esNotaValida(double nota) {
        return nota >= 0 && nota <= 20;
    }
    
    public Alumno buscarAlumno(int codigo) {
        for (Alumno alumno : lista_alumnos) {
            if (alumno.getCodigo()==codigo) {
                return alumno;
            }
        }
        return null;
    }

    public Docentes buscarDocente(int DNI) {
        for (Docentes docente : lista_docentes) {
            if (docente.getDNI()==DNI) {
                return docente;
            }
        }
        return null;
    }

    public Cursos buscarCurso(int codigo) {
        for (Cursos curso : lista_cursos) {
            if (curso.getCodigo()==codigo) {
                return curso;
            }
        }
        return null;
    }

    public boolean VerificarTodoLetras(String nombre) {
        if (nombre == null) return false;

        // TRIM --> Eliminar espacios en blanco al inicio y al final
        String trimmed = nombre.trim();
        if (trimmed.isEmpty()) return false; // no aceptamos solo espacios

        // Regex: ^[\p{L} ]+$ -> cualquier letra unicode y espacios
        return trimmed.matches("^[\\p{L} ]+$");
    }

    public boolean validarDocente(int DNI) {
        for (Docentes docente : lista_docentes) {
            if (docente.getDNI()==DNI) {
                return false;
            }
        }
        return true;
    }

    public boolean estaMatriculado(int codigoAlumno, int codigoCurso) {
        
        Cursos curso = buscarCurso(codigoCurso); //Busca el curso por su codigo
        if (curso != null) {

            Matricula matricula = curso.buscarMatricula(codigoAlumno);

            if (matricula!=null) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean validarCodigoAlumno(int codigo) {
        for (Alumno alumno : lista_alumnos) {
            if (alumno.getCodigo()==codigo) {
                return false;
            }
        }
        return true;
    }

    public boolean existeCurso(int codigo) {
        for (Cursos curso : lista_cursos) {
            if (curso.getCodigo()==codigo) {
                return true;
            }
        }
        return false;
    }

    public boolean validarDNI(int DNI) {
        if (DNI < 10000000 || DNI > 99999999) {
            return false;
        }
        return true;
    }
}
