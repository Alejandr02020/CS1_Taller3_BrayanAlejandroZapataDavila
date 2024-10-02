import java.util.Scanner;

public class Material {
    public String idMaterial;
    public String title;
    public String registrationDate;
    public int quantity;
    public int currentQuantity;

    public static Material[] materialList = new Material[100];
    public static int count = 0;

    public Material(String idMaterial, String title, String registrationDate, int quantity, int currentQuantity) {
        this.idMaterial = idMaterial;
        this.title = title;
        this.registrationDate = registrationDate;
        this.quantity = quantity;
        this.currentQuantity = currentQuantity;
    }

    public String getId() {
        return idMaterial;
    }

    public String getTitle() {
        return title;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setId(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "idMaterial='" + idMaterial + '\'' +
                ", title='" + title + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", quantity=" + quantity +
                ", currentQuantity=" + currentQuantity +
                '}';
    }

    

    public void registerMaterial() {
        Scanner scanner = new Scanner(System.in);
        String next = "S";

        while (!next.equals("N")) {
            System.out.println("Ingrese el id del material: ");
            setId(scanner.nextLine());

            while (validateMaterial(getId())) {
                System.out.println("El id ingresado ya existe, por favor ingrese otro: ");
                setId(scanner.nextLine());
            }

            while (!validateIdMaterial(getId())) {
                System.out.println("El id ingresado no cumple con el formato, el formato debe de ser dos letras y 5 números. Por favor ingrese otro: ");
                setId(scanner.nextLine());
            }

            System.out.println("Ingrese el título del material: ");
            setTitle(scanner.nextLine());

            System.out.println("Ingrese la fecha de registro (dd/MM/aaaa): ");
            setRegistrationDate(scanner.nextLine());

            System.out.println("Ingrese la cantidad de material: ");
            setQuantity(scanner.nextInt());

            scanner.nextLine();

            setCurrentQuantity(getQuantity());

            Material material = new Material(getId(), getTitle(), getRegistrationDate(), getQuantity(),
                    getCurrentQuantity());
            materialList[count] = material;
            count++;

            System.out.println("Desea registrar otro material? (S/N)");
            next = scanner.nextLine().toUpperCase();
        }
    }

    public void printMaterial() {
        if (count == 0) {
            System.out.println("No hay materiales registrados");
        } else {

            for (int i = 0; i < count; i++) {
                System.out.println("id: " + materialList[i].getId());
                System.out.println("Título: " + materialList[i].getTitle());
                System.out.println("Fecha de registro: " + materialList[i].getRegistrationDate());
                System.out.println("Cantidad: " + materialList[i].getQuantity());
                System.out.println("Cantidad actual: " + materialList[i].getCurrentQuantity());
                System.out.println("------------------------------");
            }
        }
    }

    public boolean validateMaterial(String id) {
        for (int i = 0; i < count; i++) {
            if (materialList[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateIdMaterial(String id) {
        String validate = "^[A-Za-z]{2}\\d{5}$";

        if (id.matches(validate)) {
            return true;
        }
        return false;
    }

}
