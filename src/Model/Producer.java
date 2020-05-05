package Model;

public class Producer implements IProducer {

    /**
     * The number of current producers of this type.
     */
    protected int numProducers;

    /**
     * What is the cost of this item.
     */
    protected double cost;

    /**
     * The name of this producer.
     */
    protected String name;

    /**
     * How many items are produced every second?
     */
    protected double itemsPerSecond;

    /**
     * Generate a new producer.
     * @param name The name of this producer.
     * @param itemsPerSecond How many items are produced every second.
     * @param cost The cost to purchase one item.
     */
    public Producer(String name, double itemsPerSecond, double cost){
        numProducers = 0;
        this.cost = cost;
        this.name = name;
        this.itemsPerSecond = itemsPerSecond;
    }

    @Override
    public double produceItems(double delta){
//        System.out.println("ips: " + itemsPerSecond + ", numProducers: " + numProducers + ", delta: " + delta);
        return itemsPerSecond * numProducers * delta;
    }

    @Override
    public double getItemsPerSecond(){
        return itemsPerSecond * numProducers;
    }

    @Override
    public int getNumProducers() {
        return numProducers;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void buyProducer(){
        numProducers += 1;
    }

    @Override
    public String getName(){
        return name;
    }

}
