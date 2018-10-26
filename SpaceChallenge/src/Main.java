import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        int partialBudget;
        int budget;
        String filePhase1 = "data/phase-1.txt";
        String filePhase2 = "data/phase-2.txt";

        try {

            System.out.println("Running for phase 1 with U1 fleet...");
            partialBudget = simulateWithU1(simulation, filePhase1);
            System.out.println("Budget for phase 1 with U1 fleet: " + partialBudget);
            budget = partialBudget;

            System.out.println("Running for phase 2 with U1 fleet...");
            partialBudget = simulateWithU1(simulation, filePhase2);
            System.out.println("Budget for phase 2 with U1 fleet: " + partialBudget);
            budget += partialBudget;

            System.out.println("Total budget with U1 fleet: " + budget);

            System.out.println("Running for phase 1 with U2 fleet...");
            partialBudget = simulateWithU2(simulation, filePhase1);
            System.out.println("Budget for phase 1 with U2 fleet: " + partialBudget);
            budget = partialBudget;

            System.out.println("Running for phase 2 with U2 fleet...");
            partialBudget = simulateWithU2(simulation, filePhase2);
            System.out.println("Budget for phase 2 with U2 fleet: " + partialBudget);
            budget += partialBudget;

            System.out.println("Total budget with U2 fleet: " + budget);

        } catch(FileNotFoundException e) {

            System.out.println("Items file not found. Halting execution.");

        }

    }

    private static int simulateWithU1(Simulation simulation, String fileName) throws FileNotFoundException {
        ArrayList<Item> phase1Items = simulation.loadItems(fileName);
        ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);
        return simulation.runSimulation(fleet);
    }

    private static int simulateWithU2(Simulation simulation, String fileName) throws FileNotFoundException {
        ArrayList<Item> phase1Items = simulation.loadItems(fileName);
        ArrayList<Rocket> fleet = simulation.loadU2(phase1Items);
        return simulation.runSimulation(fleet);
    }

}
