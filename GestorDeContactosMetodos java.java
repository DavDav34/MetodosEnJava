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
        