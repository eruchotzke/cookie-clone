package Model;

import java.util.ArrayList;

public class CakeModel {

    private double numCakes;  /* How many cakes have been produced? */
    public ArrayList<IProducer> cakeProducers;


    public CakeModel(){
        numCakes = 0;
        cakeProducers = new ArrayList<>();
        cakeProducers.add(new Producer("Hand Crank", .2, 10)); //0, Hand Crank
        cakeProducers.add(new Producer("Coal Generator", 1, 100)); //1, Coal Generator
    }

    /**
     * Get the number of cakes in storage.
     * @return
     */
    public double getNumCakes(){
        return numCakes;
    }

    /**
     * Produce a single cake.
     */
    public void addOneCake(){
        System.out.println("Adding one cake.");
        numCakes += 1;
    }

    /**
     * Get the number of cakes produced every second.
     * @return The decimal number of cakes per second.
     */
    public double getCakesPerSecond(){
        double total = 0;

        for(IProducer prod : cakeProducers){
            total += prod.getItemsPerSecond();
        }

        return total;
    }

    /**
     * Produce a number of cakes based on the
     * amount of time that has passed.
     * @param delta The change in time.
     */
    public void produceCakes(double delta){
        for(IProducer p : cakeProducers){
            numCakes += p.produceItems(delta);
        }
        //System.out.println(numCakes + " cakes total.");
    }

    /**
     * Remove a number of cakes from the stockpile.
     * @param numCakes The number of cakes to remove.
     */
    public void useCakes(double numCakes){
        this.numCakes -= numCakes;
        if(this.numCakes < 0) this.numCakes = 0;
    }
}
