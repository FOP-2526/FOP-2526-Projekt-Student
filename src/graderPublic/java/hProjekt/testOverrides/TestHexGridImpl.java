package hProjekt.testOverrides;

import java.util.Map;

import hProjekt.model.grid.HexGridImpl;
import hProjekt.model.grid.Structure;
import hProjekt.model.grid.Tile;
import hProjekt.model.grid.TilePosition;

public class TestHexGridImpl extends HexGridImpl {
    public TestHexGridImpl(final Map<TilePosition, Tile.Type> tile_types,
            final Map<TilePosition, Structure.Type> structure_types) {
        super(tile_types, structure_types);
    }

    @Override
    public Map<TilePosition, Structure> getStructures() {
        return structures;
    }

    @Override
    public Map<TilePosition, Tile> getTiles() {
        return tiles;
    }

    @Override
    public void addTile(final TilePosition position, final Tile.Type type) {
        super.addTile(position, type);
    }
}
