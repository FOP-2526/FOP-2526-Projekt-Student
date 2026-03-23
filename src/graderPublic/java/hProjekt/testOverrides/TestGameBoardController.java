package hProjekt.testOverrides;

import java.util.List;
import java.util.function.Consumer;

import hProjekt.DoNotMock;
import hProjekt.controller.gui.GameBoardController;
import hProjekt.controller.gui.PlayerAnimationController;
import hProjekt.controller.gui.overlays.PlayerActionsOverlayController;
import hProjekt.controller.gui.overlays.SelectionOverlayController;
import hProjekt.model.GameState;
import hProjekt.model.Player;
import hProjekt.model.cards.PathCard;
import hProjekt.model.grid.Tile;
import hProjekt.view.overlays.ConfirmationOverlay;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

public class TestGameBoardController extends GameBoardController {
    private final Property<Color> selectedTrail = new SimpleObjectProperty<>(null);
    public List<Color> availableColors = List.of();
    private Color colorToAccpet;
    public final int stage;
    public Tile highlightedTile;
    private boolean cancel = false;

    public TestGameBoardController(GameState gameState, Color colorToAccept, int stage, boolean cancel) {
        super(gameState, new TestHexGridController(gameState.getGrid()), null);
        this.colorToAccpet = colorToAccept;
        this.stage = stage;
        this.cancel = cancel;
        highlightedTile = null;
    }

    public TestGameBoardController(GameState gameState, int stage, Tile highlightedTile) {
        this(gameState, null, stage, false);
        this.highlightedTile = highlightedTile;
        if (highlightedTile != null) {
            ((TestTileController) getHexGridController().getTileControllersMap()
                    .get(highlightedTile)).callHighlight = true;
        }
    }

    @Override
    public void addSelectionOverlay(SelectionOverlayController<?> overlay) {

    }

    @Override
    public ConfirmationOverlay getConfirmationOverlay() {
        return null;
    }

    @Override
    public PlayerActionsOverlayController getPlayerActionsOverlayController() {
        return null;
    }

    @Override
    public PlayerAnimationController getPlayerAnimationController(Player player) {
        return null;
    }

    @Override
    @DoNotMock
    public Property<Color> getSelectedTrail() {
        return selectedTrail;
    }

    @Override
    public void hideColorSelectionOverlay() {

    }

    @Override
    public void hideConfirmationOverlay() {

    }

    @Override
    public void hideSelectionOverlay() {

    }

    @Override
    public void highlightPathCards(Consumer<PathCard> action) {

    }

    @Override
    public void markTreasureTrail(Color color) {

    }

    @Override
    @DoNotMock
    public void setAvailableColors(List<Color> colors) {
        availableColors = colors;
    }

    @Override
    public void setColorError(String text) {

    }

    @Override
    @DoNotMock
    public void setOnColorSelected(Consumer<Color> action) {
        if (colorToAccpet != null) {
            action.accept(colorToAccpet);
        }
    }

    @Override
    @DoNotMock
    public void setOnColorSelectionCancelled(Runnable action) {
        if (cancel) {
            action.run();
        }
    }

    @Override
    public void showColorSelectionOverlay() {

    }

    @Override
    public void showConfirmationOverlay() {

    }

    @Override
    public void unhighlightPathCards() {

    }

    @Override
    public String toString() {
        return "TestGameBoardController{" +
                "availableColors=" + availableColors +
                ", colorToAccpet=" + colorToAccpet +
                ", stage=" + stage +
                ", highlightedTile=" + highlightedTile +
                ", cancel=" + cancel +
                ", HexGridController=" + getHexGridController() +
                '}';
    }
}
