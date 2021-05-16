
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingManager {
    List<Object> vehicles = new ArrayList();
    int lastId = 0;

    public ParkingManager() {
    }

    public int add(Scanner in) {
        this.showAddMenu();
        String userInput = in.nextLine();
        Object vehicle;
        switch(userInput.hashCode()) {
            case 49:
                if (!userInput.equals("1")) {
                    return 0;
                }

                vehicle = new Car(++this.lastId);
                break;
            case 50:
                if (userInput.equals("2")) {
                    vehicle = new Bike(++this.lastId);
                    break;
                }

                return 0;
            default:
                return 0;
        }

        System.out.println("Please, Enter entry hour:");
        userInput = in.nextLine();
        boolean var5 = false;

        int entryHour;
        try {
            entryHour = Integer.parseInt(userInput);
        } catch (NumberFormatException var7) {
            return 0;
        }

        if (entryHour >= 0 && entryHour <= 23) {
            ((Vehicle)vehicle).setEntryHour(entryHour);
            this.vehicles.add(vehicle);
            return this.lastId;
        } else {
            return 0;
        }
    }

    public void remove(Scanner in) {
        if (this.vehicles != null && !this.vehicles.isEmpty()) {
            System.out.println("Please, Enter ID:");
            String userInput = in.nextLine();
            int id = Integer.parseInt(userInput);
            int i = 0;

            while(true) {
                if (i < this.vehicles.size()) {
                    Vehicle vehicle = (Vehicle)this.vehicles.get(i);
                    if (vehicle.getId() != id) {
                        ++i;
                        continue;
                    }

                    System.out.println("Please, Enter exit hour:");
                    userInput = in.nextLine();
                    int exitHour = Integer.parseInt(userInput);
                    if (exitHour < 0 || exitHour > 23) {
                        return;
                    }

                    vehicle.setExitHour(exitHour);
                    this.printBill(vehicle);
                    this.vehicles.remove(i);
                }

                return;
            }
        } else {
            System.out.println("Parking is empty!");
        }
    }

    private void showAddMenu() {
        System.out.println("******************************");
        System.out.println("Add Vehicle");
        System.out.println("******************************");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.print(">>>");
    }

    private void printBill(Vehicle vehicle) {
        System.out.println("----------------------------------");
        System.out.println("               BILL");
        System.out.println("----------------------------------");
        System.out.println("Entry Hour: " + vehicle.getEntryHour());
        System.out.println("Exit Hour: " + vehicle.getExitHour());
        System.out.println("Total price: " + vehicle.getCost());
    }
}
