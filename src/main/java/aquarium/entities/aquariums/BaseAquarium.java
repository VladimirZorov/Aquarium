package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishes;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fishes = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (fishes.size() < capacity && fishes.contains(fish) ) {
            fishes.add(fish);
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        fishes.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        fishes.stream().forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:", name, name)).append(System.lineSeparator());
        sb.append(String.format("Fish: ")).append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", decorations.size())).append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", calculateComfort())).append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(fishes);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(decorations);
    }
}
