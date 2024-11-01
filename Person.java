public abstract class Person implements PersonInterface {
    public String id;
    public String names;
    public String lastNames;
    public String rol;
    public int numberLoans;
    public int numberRenewals;

    public static Person[] personList = new Person[10];
    public static HistoryMaterial[] materialList = new HistoryMaterial[10];

    public static int count = 0;
    public static int countMaterial = 0;

    public Person(String id, String names, String lastNames, String rol, int numberLoans, int numberRenewals) {
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

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getNumberLoans() {
        return numberLoans;
    }

    public void setNumberLoans(int numberLoans) {
        this.numberLoans = numberLoans;
    }

    public int getNumberRenewals() {
        return numberRenewals;
    }

    public void setNumberRenewals(int numberRenewals) {
        this.numberRenewals = numberRenewals;
    }

    @Override
    public abstract void reserveMaterial();

    @Override
    public abstract void renewMaterial();

    @Override
    public abstract void returnMaterial();

    @Override
    public abstract void printMaterial();

    @Override
    public abstract void registerPerson();

    @Override
    public abstract void updatePerson();

    @Override
    public abstract void deletePerson();

    @Override
    public abstract void printInformation();

    public boolean userExist(String id) {
        try {
            for (int i = 0; i < count; i++) {
                if (personList[i] != null && personList[i].getId().equals(id)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
        return false;
    }
}