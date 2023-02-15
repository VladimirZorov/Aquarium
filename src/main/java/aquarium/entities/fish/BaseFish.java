package aquarium.entities.fish;

public abstract class BaseFish implements Fish{

    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        this.name = name;
        this.species = species;
        this.size = size;
        this.price = price;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
