import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorDeContactosMetodos {

static class Contacto {
        String nombre;
        String telefono;
        String email;

        public Contacto(String nombre, String telefono, String email) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
        }
    }

    static Contacto[] contactos = new Contacto[100];
    static int numContactos = 0;

    // este es el metodo estatico para agregar un contacto
    public static void agregarContacto() {
        if (numContactos < 100) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIngresa tu nombre (sin espacios): ");
            String nombre = scanner.next();
            System.out.print("Ingrese tu telefono: ");
            String telefono = scanner.next();
            System.out.print("Ingrese tu correo: ");
            String email = scanner.next();
            contactos[numContactos] = new Contacto(nombre, telefono, email);
            numContactos++;
            System.out.println("---Contacto agregado exitosamente---.");
        } else {
            System.out.println("Gestor lleno.");
        }
    }

    // mostrar contactos
    public static void mostrarContactos() {
        if (numContactos == 0) {
            System.out.println("\ntodavia no hay contactos guardados.");
        } else {
            System.out.println("\n---Lista de contactos:---");
            for (int i = 0; i < numContactos; i++) {
                System.out.println((i + 1) + ". Nombre: " + contactos[i].nombre + ", Telefono: " + contactos[i].telefono + ", Email: " + contactos[i].email);
            }
        }
    }

    
    public static void buscarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa el nombre a buscar: ");
        String nombre = scanner.next();
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].nombre.equals(nombre)) {
                System.out.println("Contacto encontrado: Nombre: " + contactos[i].nombre + ", Telefono: " + contactos[i].telefono + ", Email: " + contactos[i].email);
                return;
            }
        }
        System.out.println("\n---Contacto no encontrado.---");
    }

   
    public static void eliminarContacto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa el nombre del cotacto a eliminar: ");
        String nombre = scanner.next();
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i].nombre.equals(nombre)) {
                for (int j = i; j < numContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                numContactos--;
                System.out.println("Se elimino el contacto.");
                return;
            }
        }
        System.out.println("\nNo hay un contacto con ese nombre, intentalo de nuevo.");
    }

    // metodo para guardar contactoos en un archivo
    public static void guardarContactos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contactos.txt"))) {
            for (int i = 0; i < numContactos; i++) {
                writer.write(contactos[i].nombre + " " + contactos[i].telefono + " " + contactos[i].email + "\n");
            }
            System.out.println("\nSe guardaron correctamente.");
        } catch (IOException e) {
            System.out.println("\nError al guardar los contactos.");
        }
    }

    // se cargan los contactos desde el archivo creado en caso de que los haya
    public static void cargarContactos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contactos.txt"))) {
            String linea;
            numContactos = 0;
            while ((linea = reader.readLine()) != null && numContactos < 100) {
                String[] partes = linea.split(" ");
                contactos[numContactos] = new Contacto(partes[0], partes[1], partes[2]);
                numContactos++;
            }
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("\nNo hay contactos guardados.");
        }
    }

    public static void main(String[] args) {
        cargarContactos();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Gestor de Contactos En Java Usando Metodos ---");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Mostrar Contactos");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Guardar Contactos");
            System.out.println("6. Cargar Contactos");
            System.out.println("0. Salir");
            System.out.print("selecciona una opcion:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    eliminarContacto();
                    break;
                case 5:
                    guardarContactos();
                    break;
                case 6:
                    cargarContactos();
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("\nSelecciona una opcion valida.");
            }
        } while (opcion != 0);
    }
}