package hProjekt.testOverrides;

import java.util.stream.Collectors;

import hProjekt.controller.gui.grid.HexGridController;
import hProjekt.model.grid.HexGrid;

public class TestHexGridController extends HexGridController {

    public TestHexGridController(HexGrid hexGrid) {
        super(hexGrid, hexGrid.getEdges().values().stream().map(TestEdgeController::new)
                .collect(Collectors.toMap(TestEdgeController::getEdge, c -> c)),
                hexGrid.getTiles().values().stream().map(TestTileController::new)
                        .collect(Collectors.toMap(TestTileController::getTile, controller -> controller)));
    }

    @Override
    public void drawEdges() {

    }

    @Override
    public void drawTiles() {

    }

    @Override
    public String toString() {
        return "TestHexGridController{" +
                "tileControllers=" + getTileControllers() +
                '}';
    }
}
