public class Main {
    public static void main(String[] args) {

        Gestion gestion1 = new Gestion();

        // DOCENTES
        gestion1.agregarDocente(12345678, "Carlos", "Ramirez", "Matematica"); // válido
        gestion1.agregarDocente(1234, "Pedro", "Diaz", "Historia");           // DNI inválido
        gestion1.agregarDocente(12345678, "Ana", "Lopez", "Programacion");    // repetido

        // ALUMNOS
        gestion1.agregarAlumno("Luis", "Gomez", 1001);   // válido
        gestion1.agregarAlumno("Maria1", "Perez", 1002); // nombre inválido
        gestion1.agregarAlumno("Raul", "Torres", 1001);  // código repetido

        // CURSOS
        gestion1.agregarCurso(2001, "Algebra", 12345678); // válido
        gestion1.agregarCurso(2002, "Fisica1", 12345678); // nombre inválido
        gestion1.agregarCurso(2001, "Duplicado", 12345678); // repetido
        gestion1.agregarCurso(2003, "Calculo", 99999999);   // docente inexistente

        // MATRICULA
        gestion1.matricularAlumno(1001, 2001); // válido
        gestion1.matricularAlumno(1002, 2001); // alumno inexistente
        gestion1.matricularAlumno(1001, 2001); // repetido

        // NOTAS
        gestion1.registrarNotas(1001, 2001, 15, 18, 12); // válido
        gestion1.registrarNotas(1001, 2001, 25, 10, 15); // nota inválida

        // REPORTES
        gestion1.calcularPromedio(1001, 2001);
        gestion1.alumnoMayorPromedio(2001);
        gestion1.mostrarAprobados(2001);
        gestion1.mostrarDesaprobados(2001);
    }
}

