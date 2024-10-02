import java.util.Scanner;

public class Person extends Material {
    public String id;
    public String names;
    public String lastNames;
    public String rol;
    public int numberLoans;
    public int numberRenewals;

    public static Person[] personList = new Person[10];
    public static int count = 0;

    public Person(String id, String names, String lastNames, String rol, int numberLoans, int numberRenewals, String idMaterial, String title, String registrationDate, int quantity, int currentQuantity) {
        super(idMaterial, title, registrationDate, quantity, currentQuantity);
        this.id = id;
        this.names = names;
        this.lastNames = lastNames;
        this.rol = rol;
        this.numberLoans = numberLoans;
        this.numberRenewals = numberRenewals;
    }

    public String getId() {
        return id;
    }

    public String getNames() {
        return names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public String getRol() {
        return rol;
    }

    public int getNumberLoans() {
        return numberLoans;
    }

    public int getNumberRenewals() {
        return numberRenewals;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setNumberLoans(int numberLoans) {
        this.numberLoans = numberLoans;
    }

    public void setNumberRenewals(int numberRenewals) {
        this.numberRenewals = numberRenewals;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", names='" + names + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", rol='" + rol + '\'' +
                ", numberLoans=" + numberLoans +
                '}';
    }

    public void reserveMaterial() {
        Scanner scannerIdUser = new Scanner(System.in);
        System.out.println("Ingrese su número de cédula: ");
        String idUser = scannerIdUser.nextLine();

        while (!userExist(idUser)) {
            System.out.println("Usuario no registrado");
            System.out.println("Ingrese su número de cédula: ");
            idUser = scannerIdUser.nextLine();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del material a reservar: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (materialList[i].getId().equals(id) && personList[i].getNumberLoans() > 0) {
                if (materialList[i].getCurrentQuantity() > 0) {
                    materialList[i].setCurrentQuantity(materialList[i].getCurrentQuantity() - 1);
                    personList[i].setNumberLoans(personList[i].getNumberLoans() - 1);
                    System.out.println("Material reservado");
                    System.out.println("Cantidad de préstamos restantes: " + personList[i].getNumberLoans());
                } else {
                    System.out.println("No hay material disponible o pasaste el límite de reservas");
                }
            } else {
                System.out.println("No se encontró el material con el id ingresado");
            }
        }
    }

    public void renewMaterial() {
        Scanner scannerIdUser = new Scanner(System.in);
        System.out.println("Ingrese su número de cédula: ");
        String idUser = scannerIdUser.nextLine();

        while (!userExist(idUser)) {
            System.out.println("Usuario no registrado");
            System.out.println("Ingrese su número de cédula: ");
            idUser = scannerIdUser.nextLine();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del material a renovar: ");
        String id = scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (materialList[i].getId().equals(id)) {
                if (materialList[i].getCurrentQuantity() > 0 && personList[i].getNumberRenewals() > 0) {
                    personList[i].setNumberRenewals(personList[i].getNumberRenewals() - 1);
                    System.out.println("Material renovado");
                    System.out.println("Cantidad de renovaciones restantes: " + personList[i].getNumberRenewals());
                } else {
                    System.out.println("No hay material disponible o pasaste el límite de renovaciones");

                }
            } else {
                System.out.println("No se encontró el material con el id ingresado");
            }
        }
    }

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

        for (int i = 0; i < count; i++) {
            if (materialList[i].getId().equals(id)) {
                materialList[i].setCurrentQuantity(materialList[i].getCurrentQuantity() + 1);
                personList[i].setNumberLoans(personList[i].getNumberLoans() + 1);
                System.out.println("Material devuelto");
            } else {
                System.out.println("No se encontró el material con el id ingresado");
            }
        }
    }

    public boolean userExist(String id) {
        for (int i = 0; i < count; i++) {
            if (personList[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}