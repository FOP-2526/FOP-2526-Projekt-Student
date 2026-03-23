package hProjekt.testOverrides;

import java.util.function.Consumer;

import hProjekt.DoNotMock;
import hProjekt.controller.gui.grid.TileController;
import hProjekt.model.grid.Tile;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class TestTileController extends TileController {
    private Consumer<MouseEvent> enteredHandler;
    private Consumer<MouseEvent> clickedHandler;
    public Consumer<Tile> highlighted;
    private Tile tile;
    private Color treasureColor;
    public boolean callHighlight = false;

    public TestTileController(Tile tile) {
        super();
        this.tile = tile;
    }

    @Override
    public Tile getTile() {
        return tile;
    }

    @Override
    @DoNotMock
    public void highlight(Consumer<Tile> handler) {
        highlighted = handler;
        if (callHighlight) {
            handler.accept(tile);
        }
    }

    @Override
    @DoNotMock
    public void unhighlight() {

    }

    @Override
    @DoNotMock
    public void setMouseEnteredHandler(Consumer<MouseEvent> handler) {
        enteredHandler = handler;
    }

    @Override
    @DoNotMock
    public void removeMouseEnteredHandler() {
        enteredHandler = null;
    }

    @Override
    @DoNotMock
    public void setMouseClickedHandler(Consumer<MouseEvent> handler) {
        clickedHandler = handler;
    }

    @Override
    @DoNotMock
    public void removeMouseClickedHandler() {
        clickedHandler = null;
    }

    @Override
    @DoNotMock
    public boolean hasMouseClickedHandler() {
        return clickedHandler != null;
    }

    @Override
    public void markTreasure(Color color) {
        treasureColor = color;
    }

    @Override
    public void unmarkTreasure() {
        treasureColor = null;
    }

    @Override
    public String toString() {
        return "TestTileController{" +
                "tile=" + tile +
                ", callHighlight=" + callHighlight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        TestTileController that = (TestTileController) o;

        return tile.equals(that.tile);
    }
}
