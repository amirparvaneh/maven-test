
public class Car extends Vehicle {
    Car(int id) {
        super(id);
    }

    protected int getEntrancePrice() {
        return 50000;
    }

    protected int getHourPrice() {
        return 20000;
    }
}
