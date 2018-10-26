import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {

    ArrayList<Item> loadItems(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> allItems = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String[] itemDescription = scanner.nextLine().split("=");
            String itemName = itemDescription[0];
            int itemWeight = Integer.valueOf(itemDescription[1]);
            Item item = new Item(itemName, itemWeight / 1000);
            allItems.add(item);
        }
        return allItems;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> allItems) throws RuntimeException {
        ArrayList<Rocket> rockets = new ArrayList<>();
        U1 rocket = new U1();
        for(Item item : allItems) {
            if(rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U1();
                if(rocket.canCarry(item)) {
                    rocket.carry(item);
                } else {
                    throw new RuntimeException("Found uncarriable item! Name: " + item.getName());
                }
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> allItems) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        U2 rocket = new U2();
        for(Item item : allItems) {
            if(rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rockets.add(rocket);
                rocket = new U2();
                if(rocket.canCarry(item)) {
                    rocket.carry(item);
                } else {
                    throw new RuntimeException("Found uncarriable item! Name: " + item.getName());
                }
            }
        }
        rockets.add(rocket);
        return rockets;
    }

    int runSimulation(ArrayList<Rocket> rockets) {
        int totalBudget = 0;
        for(Rocket rocket : rockets) {
            int trials = 1;
            while(!(rocket.launch() & rocket.land())) {
                System.out.println("    failed " + trials + " time(s)...");
                trials += 1;
            }
            totalBudget += trials * rocket.getCost();
        }
        return totalBudget;
    }

}
