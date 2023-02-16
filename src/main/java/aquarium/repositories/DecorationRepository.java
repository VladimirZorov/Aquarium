package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{

    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        for (Decoration decoration1 : decorations) {
            if (decoration1.equals(decoration)) {
                decorations.remove(decoration1);
                return true;
            }
        }
        return false;
    }

    @Override
    public Decoration findByType(String type) {
        return decorations.stream()
                .filter(decoration -> decoration.getClass().getSimpleName().equals(type))
                .findFirst().orElse(null);
    }
}
