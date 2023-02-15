package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{

    private static final int SIZE = 3;
    private  int size;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size = SIZE;
    }


    @Override
    public void eat() {
        size += 3;
    }
}
