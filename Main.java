public class Main {
    public static void main(String[] args) {
        

        Gestion gestion1 = new Gestion();

        gestion1.agregarAlumno("Oscar", "Meza", 1);
        gestion1.agregarAlumno("Manuel", "Saire",2);
        gestion1.agregarAlumno("Ana", "Saire",2);

        gestion1.agregarDocente(61217911, "Mario", "Meza", "Matematico");
        gestion1.agregarDocente(61217911, "Mario", "Meza", "Matematico");
        
        gestion1.agregarCurso(1, "Matematica", 61217911);
        gestion1.agregarCurso(2, "Matematica", 61217911);


        gestion1.matricularAlumno(1, 1);
        gestion1.matricularAlumno(2, 1);

        gestion1.registrarNotas(1, 1, 12, 13, 14);
        gestion1.registrarNotas(2, 1, 8, 9, 10);

        gestion1.calcularPromedio(1, 1);
        gestion1.calcularPromedio(2, 1);

        gestion1.alumnoMayorPromedio(1);
        gestion1.mostrarAprobados(1);
        gestion1.mostrarDesaprobados(1);                
    }
}
