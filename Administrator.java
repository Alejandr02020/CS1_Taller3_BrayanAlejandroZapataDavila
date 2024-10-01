import java.util.Scanner;

public class Administrator extends Person{

    public Administrator(String id, String names, String lastNames, String rol, int numberLoans, int numberRenewals, String idMaterial, String title, String registrationDate, int quantity, int currentQuantity) {
        super(id, names, lastNames, rol, numberLoans, numberRenewals, idMaterial, title, registrationDate, quantity, currentQuantity);
    }

    public void registerPerson() {
        Scanner scanner = new Scanner(System.in);
        String next = "S";

        while (!next.equals("N")) {
            System.out.println("Ingrese la cédula: ");
            setId(scanner.nextLine());

            while (userExist(getId())) {
                System.out.println("La cédula ingresada ya existe, por favor ingrese otra: ");
                setId(scanner.nextLine());
            }
    
            System.out.println("Ingrese los nombres: ");
            setNames(scanner.nextLine());
    
            System.out.println("Ingrese los apellidos: ");
            setLastNames(scanner.nextLine());
    
            System.out.println("Ingrese el rol: ");
            setRol(scanner.nextLine().toUpperCase());

            if(getRol().equals("ESTUDIANTE")) {
                setNumberLoans(5);
            } else if (getRol().equals("PROFESOR")) {
                setNumberLoans(3);
            } else {
                setNumberLoans(2);
            }

            setNumberRenewals(3);
    
            Person person = new Person(getId(), getNames(), getLastNames(), getRol(), getNumberLoans(), getNumberRenewals(), null, null, null, 0, 0);
            personList[count] = person;
            count++;

            System.out.println("Desea registrar otra persona? (S/N)");
            next = scanner.nextLine().toUpperCase();
        }
    }

    public void updatePerson()
    {
        if (count == 0) {
            System.out.println("No hay personas registradas");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la cédula de la persona a editar: ");
            String id = scanner.nextLine();
    
            for (int i = 0; i < count; i++) {
                if (personList[i].getId().equals(id)) {
                    System.out.println("Ingrese los nombres: ");
                    personList[i].setNames(scanner.nextLine());
            
                    System.out.println("Ingrese los apellidos: ");
                    personList[i].setLastNames(scanner.nextLine());
            
                    System.out.println("Ingrese el rol: ");
                    personList[i].setRol(scanner.nextLine());
                } else {
                    System.out.println("No se encontró la persona con la cédula ingresada");
                }
            }
        }
    }

    public void deletePerson()
    {
        if (count == 0) {
            System.out.println("No hay personas registradas");
            
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la cédula de la persona a eliminar: ");
            String id = scanner.nextLine();
    
            for (int i = 0; i < count; i++) {
                if (personList[i].getId().equals(id)) {
                    personList[i] = null;
                    count--;
                } else {
                    System.out.println("No se encontró la persona con la cédula ingresada");
                }
            }
        }
    }

    public void printInformation() {
        if (count == 0) {
            System.out.println("No hay personas registradas");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("Cédula: " + personList[i].getId());
                System.out.println("Nombres: " + personList[i].getNames());
                System.out.println("Apellidos: " + personList[i].getLastNames());
                System.out.println("Rol: " + personList[i].getRol());
                System.out.println("Cantidad de préstamos: " + personList[i].getNumberLoans());
                System.out.println("Cantidad de renovaciones: " + personList[i].getNumberRenewals());
                System.out.println("------------------------------");
            }
        }
    }

    public boolean userExist(String id)
    {
        for (int i = 0; i < count; i++) {
            System.out.print(materialList[i].getId());
            if (personList[i].getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
    
}
