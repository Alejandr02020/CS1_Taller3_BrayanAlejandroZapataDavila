import java.util.Scanner;

public class Menu {

    public void showMenu() {
        System.out.println("Bienvenido a la Biblioteca");
        System.out.println("----------------------------");
        System.out.println("Que rol tienes?");
        System.out.println("1. Estudiante");
        System.out.println("2. Profesor");
        System.out.println("3. Administrativo");
        System.out.println("4. Salir");
    }

    public void showAdministrativeMenu(){
        System.out.println("Bienvenido Administrativo");
        System.out.println("----------------------------");
        System.out.println("1. Registrar persona");
        System.out.println("2. Editar persona");
        System.out.println("3. Eliminar persona");
        System.out.println("4. Listar personas");
        System.out.println("5. Registrar un material");
        System.out.println("6. Listar materiales");
        System.out.println("7. Salir");
    }

    public void showStudentMenu(){
        System.out.println("Bienvenido Estudiante");
        System.out.println("----------------------------");
        System.out.println("1. Reservar material");
        System.out.println("2. Renovar material");
        System.out.println("3. Devolver material");
        System.out.println("4. Salir");
    }

    public void showTeacherMenu(){
        System.out.println("Bienvenido Profesor");
        System.out.println("----------------------------");
        System.out.println("1. Reservar material");
        System.out.println("2. Renovar material");
        System.out.println("3. Devolver material");
        System.out.println("4. Salir");
    }

    public int readOption() {
        var scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
