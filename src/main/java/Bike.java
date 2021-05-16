public class Bike extends Vehicle {
    public Bike(int id) {
        super(id);
    }

    protected int getEntrancePrice() {
        return 30000;
    }

    protected int getHourPrice() {
        return 10000;
    }
}
