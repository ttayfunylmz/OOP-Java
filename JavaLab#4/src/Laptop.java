public class Laptop {

    private String laptopModel;
    private String ramCapacity;
    private Wireless wireless;


    public Laptop() {

    }

    public Laptop(String laptopModel, String ramCapacity, boolean connectionStatus) {
        this.setLaptopModel(laptopModel);
        this.setRamCapacity(ramCapacity);
    }

    public Wireless getWireless() {
        return wireless;
    }

    public void setWireless(Wireless wireless) {
        this.wireless = wireless;
    }

    public String getLaptopModel() {
        return laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this.laptopModel = laptopModel;
    }

    public String getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(String ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public void connect() {
        getWireless().setConnectionStatus(true);
        System.out.println("Laptop is connected to the wireless successfully.");
    }


}
