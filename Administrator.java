import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator extends Person implements Material{

    public Administrator(String id, String names, String lastNames, String rol, int numberLoans, int numberRenewals) {
        super(id, names, lastNames, rol, numberLoans, numberRenewals);
    }
    

    @Override
    public void printMaterial() {
        if (countMaterial == 0) {
            System.out.println("No hay materiales registrados");
        } else {

            for (int i = 0; i < countMaterial; i++) {
                System.out.println("id: " + materialList[i].getIdMaterial());
                System.out.println("Título: " + materialList[i].getTitle());
                System.out.println("Fecha de registro: " + materialList[i].getRegistrationDate());
                System.out.println("Cantidad: " + materialList[i].getQuantity());
                System.out.println("Cantidad actual: " + materialList[i].getCurrentQuantity());
                System.out.println("------------------------------");
            }
        }
    }

    @Override
    public void reserveMaterial() {
        System.out.println("Reserve Material");
    }

    @Override
    public void renewMaterial() {
        System.out.println("Renew Material");
    }

    @Override
    public void returnMaterial() {
        System.out.println("Return Material");
    }

    @Override
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

            System.out.println("Ingrese el rol (ESTUDIANTE/PROFESOR): ");
            setRol(scanner.nextLine().toUpperCase());

            switch (getRol()) {
                case "ESTUDIANTE":
                    setNumberLoans(5);
                    break;
                case "PROFESOR":
                    setNumberLoans(3);
                    break;
                default:
                    break;
            }

            setNumberRenewals(3);

            Person person;
            if (getRol().equals("ESTUDIANTE")) {
                person = new Student(getId(), getNames(), getLastNames(), getRol(), getNumberLoans(), getNumberRenewals());
            } else if (getRol().equals("PROFESOR")) {
                person = new Teacher(getId(), getNames(), getLastNames(), getRol(), getNumberLoans(), getNumberRenewals());
            } else {
                System.out.println("Rol no válido. No se puede registrar la persona.");
                continue;
            }

            personList[count++] = person;
            System.out.println("Persona registrada correctamente.");

            System.out.println("¿Desea registrar otra persona? (S/N)");
            next = scanner.nextLine().toUpperCase();
        }
    }


    @Override
    public void updatePerson() {
        if (count == 0) {
            System.out.println("No hay personas registradas");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula de la persona a editar: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (personList[i].getId().equals(id)) {
                System.out.println("Ingrese los nombres: ");
                personList[i].setNames(scanner.nextLine());

                System.out.println("Ingrese los apellidos: ");
                personList[i].setLastNames(scanner.nextLine());

                System.out.println("Ingrese el rol: ");
                personList[i].setRol(scanner.nextLine().toUpperCase());
                found = true;
                System.out.println("Persona actualizada correctamente.");
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró la persona con la cédula ingresada.");
        }
    }

    @Override
    public void deletePerson() {
        if (count == 0) {
            System.out.println("No hay personas registradas");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula de la persona a eliminar: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (personList[i].getId().equals(id)) {
                if ((personList[i].getRol().equals("ESTUDIANTE") && personList[i].getNumberLoans() == 5) ||
                    (personList[i].getRol().equals("PROFESOR") && personList[i].getNumberLoans() == 3)) {

                    for (int j = i; j < count - 1; j++) {
                        personList[j] = personList[j + 1];
                    }
                    personList[--count] = null;
                    System.out.println("Persona eliminada correctamente.");
                    found = true;
                } else {
                    System.out.println("La persona tiene préstamos pendientes o el rol no permite eliminación.");
                    found = true;
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró la persona con la cédula ingresada.");
        }
    }

    @Override
    public void printInformation() {
        try {
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
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        
    }

    @Override
    public void registerMaterial() {
        Scanner scanner = new Scanner(System.in);
        String next = "S";

        while (!next.equals("N")) {
            HistoryMaterial material = new HistoryMaterial("", "", "", 0, 0);

            System.out.println("Ingrese el id del material: ");
            String idMaterial = scanner.nextLine();

            while (validateMaterial(idMaterial) || !validateIdMaterial(idMaterial)) {
                if (validateMaterial(idMaterial)) {
                    System.out.println("El id ingresado ya existe, por favor ingrese otro: ");
                } else {
                    System.out.println("El id ingresado no cumple con el formato (dos letras y cinco números). Ingrese otro: ");
                }
                idMaterial = scanner.nextLine();
            }
            material.setIdMaterial(idMaterial);

            System.out.println("Ingrese el título del material: ");
            material.setTitle(scanner.nextLine());

            System.out.println("Ingrese la fecha de registro (dd/MM/aaaa): ");
            material.setRegistrationDate(scanner.nextLine());

            int quantity = 0;
            boolean validQuantity = false;
            while (!validQuantity) {
                System.out.println("Ingrese la cantidad de material: ");
                try {
                    quantity = scanner.nextInt();
                    validQuantity = true;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor ingrese un número válido para la cantidad.");
                    scanner.nextLine();
                }
            }
            material.setQuantity(quantity);
            material.setCurrentQuantity(quantity);

            scanner.nextLine();

            materialList[countMaterial++] = material;

            System.out.println("¿Desea registrar otro material? (S/N)");
            next = scanner.nextLine().toUpperCase();
        }
    }

    public boolean validateMaterial(String id) {
        for (int i = 0; i < countMaterial; i++) {
            if (materialList[i] != null && materialList[i].getIdMaterial().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateIdMaterial(String id) {
        String validate = "^[A-Za-z]{2}\\d{5}$";
        return id.matches(validate);
    }
}
