public class Rocket implements SpaceShip {

    private int cost;
    private int weight;
    private int maxWeight;

    Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public final boolean canCarry(Item item) {
        return (weight + item.getWeight() <= maxWeight);
    }

    public final void carry(Item item) {
        weight += item.getWeight();
    }

    final int getCost() { return cost;}

}
