#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Contacto {
    char nombre[50];
    char telefono[15];
    char email[50];
};

void agregarContacto(struct Contacto contactos[], int *num_contactos) {
    if (*num_contactos < 100) {
        printf("\ningresa tu nombre (sin espacios): ");
        scanf("%s", contactos[*num_contactos].nombre);
        printf("ingresa tu telefono: ");
        scanf("%s", contactos[*num_contactos].telefono);
        printf("ingresa tu correo: ");
        scanf("%s", contactos[*num_contactos].email);
        (*num_contactos)++;
        printf("---contacto agregado exitosamente---.\n");
    } else {
        printf("gestor lleno.\n");
    }
}

void mostrarContactos(struct Contacto contactos[], int num_contactos) {
    if (num_contactos == 0) {
        printf("\naun no hay contactos guardados.\n");
    } else {
        printf("\n---Lista de contactos:---\n");
        int i;
        for (i = 0; i < num_contactos; i++) {
            printf("%d. Nombre: %s, Telefono: %s, Email: %s\n", i + 1, contactos[i].nombre, contactos[i].telefono, contactos[i].email);
        }
    }
}

void buscarContacto(struct Contacto contactos[], int num_contactos) {
    char nombre[50];
    printf("\ningresa el nombre a buscar: ");
    scanf("%s", nombre);
    int i;
    for (i = 0; i < num_contactos; i++) {
        if (strcmp(contactos[i].nombre, nombre) == 0) {
            printf("Contacto encontrado: Nombre: %s, Telefono: %s, Email: %s\n", contactos[i].nombre, contactos[i].telefono, contactos[i].email);
            return;
        }
    }
    printf("\n---Contacto no encontrado.---\n");
}

void eliminarContacto(struct Contacto contactos[], int *num_contactos) {
    char nombre[50];
    printf("\ningresar el nombre del contacto a eliminar: ");
    scanf("%s", nombre);
    int i;
    for (i = 0; i < *num_contactos; i++) {
        if (strcmp(contactos[i].nombre, nombre) == 0) {
        	int j;
            for (j = i; j < *num_contactos - 1; j++) {
                contactos[j] = contactos[j + 1];
            }
            (*num_contactos)--;
            printf("se elimino el contcto\n");
            return;
        }
    }
    printf("\nno hay un contacto con ese nombre, intenta de nuevo\n");
}

void guardarContactos(struct Contacto contactos[], int num_contactos) {
    FILE *archivo = fopen("contactos.txt", "w");
    if (!archivo) {
        printf("\nError al abrir el archivo.\n");
        return;
    }
    int i;
    for (i = 0; i < num_contactos; i++) {
        fprintf(archivo, "%s %s %s\n", contactos[i].nombre, contactos[i].telefono, contactos[i].email);
    }
    fclose(archivo);
    printf("\nse guardaron correctamente.\n");
}

void cargarContactos(struct Contacto contactos[], int *num_contactos) {
    FILE *archivo = fopen("contactos.txt", "r");
    if (!archivo) {
        printf("\nNo hay contactos guardados\n");
        return;
    }
    *num_contactos = 0;
    char linea[120];
    while (fgets(linea, sizeof(linea), archivo)) {
        sscanf(linea, "%s %s %s", contactos[*num_contactos].nombre, contactos[*num_contactos].telefono, contactos[*num_contactos].email);
        (*num_contactos)++;
        if (*num_contactos >= 100) break;
    }
    fclose(archivo);
    printf("contactos cargados correctamente.\n");
}

int main() {
    struct Contacto contactos[100];
    int num_contactos = 0;
	cargarContactos(contactos, &num_contactos);
    int opcion;
    do {
        printf("\n--- Gestor de Contactos ---\n");
        printf("1. Agregar Contacto\n");
        printf("2. Mostrar Contactos\n");
        printf("3. Buscar Contacto\n");
        printf("4. Eliminar Contacto\n");
        printf("5. Guardar Contactos\n");
        printf("6. Cargar Contactos\n");
        printf("0. Salir\n");
        printf("porfavor selecciona una opcion y da enter: ");
        scanf("%d", &opcion);

        switch (opcion) {
            case 1: agregarContacto(contactos, &num_contactos); break;
            case 2: mostrarContactos(contactos, num_contactos); break;
            case 3: buscarContacto(contactos, num_contactos); break;
            case 4: eliminarContacto(contactos, &num_contactos); break;
            case 5: guardarContactos(contactos, num_contactos); break;
            case 6: cargarContactos(contactos, &num_contactos); break;
            case 0: printf("\nsaliendo del programita...\n"); break;
            default: printf("\nseleccina una opcion valida.\n");
        }
    } while (opcion != 0);
    return 0;
}

