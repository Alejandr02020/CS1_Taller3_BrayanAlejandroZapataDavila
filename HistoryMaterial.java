public class HistoryMaterial implements Material {
    public String idMaterial;
    public String title;
    public String registrationDate;
    public int quantity;
    public int currentQuantity;

    public HistoryMaterial(String idMaterial, String title, String registrationDate, int quantity, int currentQuantity) {
        this.idMaterial = idMaterial;
        this.title = title;
        this.registrationDate = registrationDate;
        this.quantity = quantity;
        this.currentQuantity = currentQuantity;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    @Override
    public void reserveMaterial() {
    }

    @Override
    public void renewMaterial() {
    }

    @Override
    public void returnMaterial() {
    }

    @Override
    public void registerMaterial() {
    }

}
