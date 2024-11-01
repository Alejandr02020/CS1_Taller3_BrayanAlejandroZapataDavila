import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student extends Person implements Material{

    public Student(String id, String names, String lastNames, String rol, int numberLoans, int numberRenewals) {
        super(id, names, lastNames, rol, numberLoans, numberRenewals);
    }
    

    @Override
    public void printMaterial() {
    }

    @Override
    public void registerPerson() {
    }

    @Override
    public void updatePerson() {
    }

    @Override
    public void registerMaterial() {
    }

    @Override
    public void printInformation() {
    }

    @Override
    public void deletePerson() {
    }

    @Override
    public void reserveMaterial() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese su número de cédula: ");
        String idUser = scanner.nextLine();

        if (!userExist(idUser)) {
            System.out.println("Usuario no registrado");
            return;
        }
    
        System.out.println("Ingrese el id del material a reservar: ");
        String id = scanner.nextLine();
    
        int materialIndex = -1;
        int personIndex = -1;

        for (int i = 0; i < countMaterial; i++) {
            if (materialList[i].getIdMaterial().equals(id)) {
                materialIndex = i;
                break;
            }
        }

        for (int i = 0; i < personList.length; i++) {
            if (personList[i].getId().equals(idUser)) {
                personIndex = i;
                break;
            }
        }

        if (materialIndex == -1) {
            System.out.println("No se encontró el material con el id ingresado");
            return;
        }
        if (personIndex == -1) {
            System.out.println("No se encontró al usuario con el id ingresado");
            return;
        }

        if (materialList[materialIndex].getCurrentQuantity() > 0 && personList[personIndex].getNumberLoans() > 0) {
            materialList[materialIndex].setCurrentQuantity(materialList[materialIndex].getCurrentQuantity() - 1);
            personList[personIndex].setNumberLoans(personList[personIndex].getNumberLoans() - 1);
            System.out.println("Material reservado");
            System.out.println("Cantidad de préstamos restantes para el usuario: " + personList[personIndex].getNumberLoans());
            history(materialList[materialIndex].getIdMaterial(), materialList[materialIndex].getTitle());
        } else {
            System.out.println("No hay material disponible o pasaste el límite de reservas");
        }
    }
    

    @Override
    public void renewMaterial() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese su número de cédula: ");
        String idUser = scanner.nextLine();
    
        if (!userExist(idUser)) {
            System.out.println("Usuario no registrado");
            return;
        }
    
        System.out.println("Ingrese el id del material a renovar: ");
        String id = scanner.nextLine();
    
        int materialIndex = -1;
        int personIndex = -1;

        for (int i = 0; i < countMaterial; i++) {
            if (materialList[i].getIdMaterial().equals(id)) {
                materialIndex = i;
                break;
            }
        }
    
        for (int i = 0; i < personList.length; i++) {
            if (personList[i].getId().equals(idUser)) {
                personIndex = i;
                break;
            }
        }
    
        if (materialIndex == -1) {
            System.out.println("No se encontró el material con el id ingresado");
            return;
        }
        if (personIndex == -1) {
            System.out.println("No se encontró al usuario con el id ingresado");
            return;
        }
    
        if (personList[personIndex].getNumberRenewals() > 0) {
            personList[personIndex].setNumberRenewals(personList[personIndex].getNumberRenewals() - 1);
            System.out.println("Material renovado");
            System.out.println("Cantidad de renovaciones restantes: " + personList[personIndex].getNumberRenewals());
        } else {
            System.out.println("No hay renovaciones disponibles o pasaste el límite de renovaciones");
        }
    }
    

    @Override
    public void returnMaterial() {
        Scanner scannerIdUser = new Scanner(System.in);
        System.out.println("Ingrese su número de cédula: ");
        String idUser = scannerIdUser.nextLine();

        while (!userExist(idUser)) {
            System.out.println("Usuario no registrado");
            System.out.println("Ingrese su número de cédula: ");
            idUser = scannerIdUser.nextLine();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del material a devolver: ");
        String id = scanner.nextLine();

        int materialIndex = -1;
        for (int i = 0; i < countMaterial; i++) {
            if (materialList[i].getIdMaterial().equals(id)) {
                materialIndex = i;
                break;
            }
        }

        int personIndex = -1;
        for (int i = 0; i < count; i++) {
            if (personList[i].getId().equals(idUser)) {
                personIndex = i;
                break;
            }
        }

        if (materialIndex == -1) {
            System.out.println("No se encontró el material con el id ingresado");
            return;
        }
        if (personIndex == -1) {
            System.out.println("No se encontró al usuario con el id ingresado");
            return;
        }

        materialList[materialIndex].setCurrentQuantity(materialList[materialIndex].getCurrentQuantity() + 1);
        personList[personIndex].setNumberLoans(personList[personIndex].getNumberLoans() + 1);
        personList[personIndex].setNumberRenewals(3);
        System.out.println("Material devuelto");
        System.out.println("Cantidad de préstamos restantes para el usuario: " + personList[personIndex].getNumberLoans());
    }

    public static void history(String idMaterial, String title)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timesTamp = now.format(formatter);

        String historyString = "Fecha y hora: " + timesTamp + "\n" +
                "Id material: " + idMaterial + "\n" +
                "Título: " + title + "\n\n";
        
        try {
            File file = new File("history.txt");
            
            if (!file.exists()) {
                file.createNewFile();
            }

            try(FileWriter writer = new FileWriter(file, true)) {
                writer.write(historyString);
            }
        } catch (Exception e) {
            System.out.println("Error al guardar el historial de préstamos: " + e.getMessage());
        }
    }
}
