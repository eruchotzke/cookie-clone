package Model;

public interface IProducer {

    /**
     * Get the number of items produced in a chunk of time.
     * @param delta The chunk of time to run.
     * @return The number of items produced in delta time.
     */
    double produceItems(double delta);

    /**
     * Get the number of items this unit can generate in one second.
     * @return A double number of
     */
    double getItemsPerSecond();

    /**
     * Get the number of producers represented.
     * @return The number of producers of this type producing.
     */
    int getNumProducers();

    /**
     * Get the cost of this item in items.
     * @return A double cost of this item.
     */
    double getCost();

    /**
     * Purchase one producer.
     */
    void buyProducer();

    /**
     * Get the name of this producer.
     * @return the name of the producer.
     */
    String getName();

}
