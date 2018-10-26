public class Item {
    private String name;
    private int weight;

    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }
}
