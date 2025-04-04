#  Métodos Estaticos y Diferencias
##### Los métodos estáticos son funciones que no necesitan una instancia de la clase para ser usados, ya que no acceden a los atributos del objeto. Convertir los métodos de un programa a estáticos simplifica el código, lo hace más reutilizable y elimina la necesidad de crear objetos innecesarios. El objetivo es refactorizar programas anteriores para usar este tipo de métodos, mejorando su organización y mantenimiento.

------------
###  ¬ Gestor de Contactos
En esta práctica, los estudiantes diseñarán y desarrollarán un sistema de gestión de contactos que permita a los usuarios administrar su lista de contactos de manera eficiente.

| Cambios Significativos | Lenguaje C | Lenguaje Java |
| ------------ | ------------ | ------------ |
|  Estructuras vs. Clases | Utiliza estructuras (struct) para definir tipos de datos personalizados. | Utiliza clases para definir tipos de datos personalizados. En este caso, se define una clase interna estática Contacto.|
| Gestión de Memoria | La memoria se gestiona manualmente mediante funciones como malloc y free. | La memoria se gestiona automáticamente mediante el recolector de basura (Garbage Collector).|
| Arrays y Arreglos | Los arreglos se declaran con un tamaño fijo y se pueden utilizar como matrices. | Los arreglos también se declaran con un tamaño fijo, pero se tratan como objetos. |
| Entrada/Salida | Utiliza scanf y printf para entrada y salida estándar.  | Utiliza Scanner para la entrada y System.out.println para la salida.  |
|  Archivos | Utiliza fopen, fread, fwrite, fclose para manejar archivos.  | Utiliza BufferedReader y BufferedWriter para leer y escribir archivos.  |
| Métodos Estáticos  | No tiene métodos estáticos como tal, pero se pueden emular con funciones globales.  | Los métodos estáticos se declaran dentro de una clase y se pueden llamar sin instanciar la clase.  |
| Tipos de Datos  | Utiliza tipos de datos primitivos como int, char, etc., y tipos definidos por el usuario como estructuras.  | Utiliza tipos de datos primitivos como int, char, etc., y tipos de datos de referencia como objetos y arreglos.   |
| Programación Orientada a Objetos (POO)  | No es un lenguaje orientado a objetos.   | Es un lenguaje orientado a objetos que soporta encapsulación, herencia y polimorfismo.  |
|  Subprocesos y Hilos | No tiene soporte nativo para subprocesos o hilos.  | Tiene soporte nativo para hilos mediante la clase Thread.  |
| Sobrecarga de Métodos | No admite sobrecarga de funciones. | Admite sobrecarga de métodos, lo que permite definir varios métodos con el mismo nombre pero diferentes parámetros. |

------------

###  ¬ Registro de Estudiantes
El propósito de esta práctica es desarrollar un programa en Java que permita registrar y gestionar estudiantes de manera eficiente. Para lograrlo, se utilizarán estructuras de control básicas como if-else, switch y bucles (for, while) para gestionar las decisiones y el flujo del programa. 

##### Cambios en el programa de sistema de estudiantes
En el programa original, toda la lógica del sistema de registro de estudiantes se encontraba directamente dentro del método main, lo que hacía que el código fuera menos modular, más difícil de mantener y poco reutilizable. Para mejorar su estructura y legibilidad, se realizaron los siguientes cambios:

° Modularización mediante métodos estáticos
Se separó la lógica de cada operación (registrar, mostrar, buscar y eliminar estudiantes) en métodos estáticos dentro de la clase principal. Esto mejora la organización del código, facilita la reutilización de funciones y permite mantener la lógica de cada funcionalidad de manera aislada, lo que favorece la mantenibilidad y la comprensión del programa.

° Uso de variables estáticas compartidas
Las variables estudiantes, numEstudiantes y scanner se declararon como estáticas, ya que son utilizadas por todos los métodos sin requerir instancias de la clase con esto logramos que todos los métodos estáticos accedan directamente a estas variables sin necesidad de pasar parámetros.

------------
###  ¬ Juego de la Adivinanza
El objetivo de la práctica es desarrollar un programa en Java que implemente un juego de adivinanza de números, utilizando ciclos como for, while y do-while.

| Aspectos Significativos | Sin métodos Estáticos | Con métodos Estáticos | Implicaciones |
| ------------ | ------------ | ------------ | ------------ |
| Generación de números aleatorios | Se realiza mediante el "main()" | Se realiza mediante el método "generarNumeroAleatorio()" | Aisla las posibilidades, hace el código más limpio y permite reusar la lógica en otros contextos. |
| Configuración de intentos | Variable "intentosMaximos" se define directamente en "main()" |Se obtiene desde un método "(getIntentosMaximos)" | Facilita modificar el valor desde un solo lugar y permite la reutilización en futuros cambios. |
| Puntos de entrada "main)" | Maneja toda la lógica del juego. | Solo llama a "jugarJuego()" | El "main()" se vvuelve un punto de entrada claro, manteniendo el principio de responsabilidad única. |
