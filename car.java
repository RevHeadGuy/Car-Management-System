import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String made;
    private String model;
    private int year;
    private String numberPlate;

    public Car(String make, String model, int year, String numberPlate) {
        this.made = made;
        this.model = model;
        this.year = year;
        this.numberPlate = numberPlate;
    }

    public String getMade() {
        return made;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getnumberPlate() {
        return numberPlate;
    }

    @Override
    public String toString() {
        return year + " " + made + " " + model + " (number Plate: " + numberPlate + ")";
    }
}

public class car {
    private static ArrayList<Car> carList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    listCars();
                    break;
                case 3:
                    searchCar();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nCar Management System");
        System.out.println("1. Add Car");
        System.out.println("2. List Cars");
        System.out.println("3. Search Car");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCar() {
        System.out.print("Enter car made: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter car number plate: ");
        String numberPlate = scanner.nextLine();

        Car car = new Car(make, model, year, numberPlate);
        carList.add(car);
        System.out.println("Car added: " + car.toString());
    }

    private static void listCars() {
        System.out.println("\nCar List:");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(i + ". " + carList.get(i).toString());
        }
    }

    private static void searchCar() {
        System.out.print("Enter number plate to search for: ");
        String searchPlate = scanner.nextLine();

        System.out.println("\nSearch Results:");
        boolean found = false;
        for (Car car : carList) {
            if (car.getnumberPlate().equalsIgnoreCase(searchPlate)) {
                System.out.println(car.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching car found.");
        }
    }
}
