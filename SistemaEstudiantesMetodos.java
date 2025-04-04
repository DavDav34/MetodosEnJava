import java.util.Scanner;

class Estudiante {
    String nombre;
    int edad;
    String matricula;
    String carrera;

    public Estudiante(String nombre, int edad, String matricula, String carrera) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Matricula: " + matricula);
        System.out.println("Carrera: " + carrera);
    }
}

public class Estudiantes {
static Estudiante[] estudiantes = new Estudiante[100];
    static int numEstudiantes = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- Sistema de Registro de Estudiantes Con Metodo Estaticos ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante por matrícula");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    public static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Carrera: ");
        String carrera = scanner.nextLine();

        if (matriculaExiste(matricula)) {
            System.out.println("La matrícula ya esta registrada");
            return;
        }

        estudiantes[numEstudiantes++] = new Estudiante(nombre, edad, matricula, carrera);
        System.out.println("Estudiante registrado");
    }

    public static void mostrarEstudiantes() {
        if (numEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        System.out.println("\n--- Lista de Estudiantes ---");
        for (int i = 0; i < numEstudiantes; i++) {
            estudiantes[i].mostrarInfo();
            System.out.println("-----------------------------");
        }
    }

    public static void buscarEstudiante() {
        System.out.print("Ingresa la matrícula a buscar: ");
        String matriculaBuscar = scanner.nextLine();

        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matriculaBuscar)) {
                estudiantes[i].mostrarInfo();
                return;
            }
        }

        System.out.println(" no se a encontrado");
    }

    public static void eliminarEstudiante() {
        System.out.print("ingresa la matrícula del estudiante a eliminar: ");
        String matriculaEliminar = scanner.nextLine();

        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matriculaEliminar)) {
                for (int j = i; j < numEstudiantes - 1; j++) {
                    estudiantes[j] = estudiantes[j + 1];
                }
                numEstudiantes--;
                System.out.println("Estudiante eliminado");
                return;
            }
        }

        System.out.println("no se ha encontrado");
    }

    public static boolean matriculaExiste(String matricula) {
        for (int i = 0; i < numEstudiantes; i++) {
            if (estudiantes[i].matricula.equals(matricula)) {
                return true;
            }
        }
        return false;
    }
    
}