public class U2 extends Rocket {

    private int weight;
    private int maxWeight;
    private int emptyWeight;

    U2() {
        super(120, 18, 29);
        emptyWeight = 18;
    }

    public boolean launch() {
        float cargoRatio = (float) (weight - emptyWeight) / (maxWeight - emptyWeight);
        double probExplosion = 0.04 * cargoRatio;
        return (Math.random() > probExplosion);
    }

    public boolean land() {
        float cargoRatio = (float) (weight - emptyWeight) / (maxWeight - emptyWeight);
        double probExplosion = 0.08 * cargoRatio;
        return (Math.random() > probExplosion);
    }
}
