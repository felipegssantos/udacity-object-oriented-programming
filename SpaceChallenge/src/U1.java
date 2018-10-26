public class U1 extends Rocket {

    private int weight;
    private int maxWeight;
    private int emptyWeight;

    U1() {
        super(100, 10, 18);
        emptyWeight = 10;
    }

    public boolean launch() {
        float cargoRatio = (float) (weight - emptyWeight) / (maxWeight - emptyWeight);
        double probExplosion = 0.05 * cargoRatio;
        return (Math.random() > probExplosion);
    }

    public boolean land() {
        float cargoRatio = (float) (weight - emptyWeight) / (maxWeight - emptyWeight);
        double probExplosion = 0.01 * cargoRatio;
        return (Math.random() > probExplosion);
    }

}
