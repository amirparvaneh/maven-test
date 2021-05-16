
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        ParkingManager pm = new ParkingManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                printMenu();
                String userInput = scanner.nextLine();
                switch(userInput.hashCode()) {
                    case 49:
                        if (userInput.equals("1")) {
                            int id = pm.add(scanner);
                            System.out.println("ID: " + id);
                            continue;
                        }
                        break;
                    case 50:
                        if (userInput.equals("2")) {
                            pm.remove(scanner);
                            continue;
                        }
                        break;
                    case 113:
                        if (userInput.equals("q")) {
                            return;
                        }
                }

                System.out.println("default: " + userInput + "!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("**************************");
        System.out.println("  Parking System Program  ");
        System.out.println("**************************");
        System.out.println("1. Add vehicle");
        System.out.println("2. Remove vehicle");
        System.out.println("q. Quit");
        System.out.print(">>>");
    }
}
