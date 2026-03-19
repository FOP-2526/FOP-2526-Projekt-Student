package hProjekt.utils;

import java.util.Optional;
import java.util.function.Predicate;

import hProjekt.model.grid.Tile;

public class IsNearPredicate implements Predicate<Optional<Tile>> {
    private final Tile.Type type;

    public IsNearPredicate(Tile.Type type) {
        this.type = type;
    }

    @Override
    public boolean test(Optional<Tile> t) {
        return t.isPresent() && t.get().getType() == type;
    }

}
