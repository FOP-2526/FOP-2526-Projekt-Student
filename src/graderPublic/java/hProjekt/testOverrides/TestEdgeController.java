package hProjekt.testOverrides;

import java.util.Arrays;
import java.util.function.Consumer;

import hProjekt.DoNotMock;
import hProjekt.controller.gui.grid.EdgeController;
import hProjekt.model.grid.Edge;
import javafx.scene.input.MouseEvent;

public class TestEdgeController extends EdgeController {
    private Edge edge;
    public Consumer<MouseEvent> highlightHandler;
    public boolean highlighted = false;
    public Consumer<MouseEvent> selected;
    public String label = "";

    public TestEdgeController(Edge edge) {
        super();
        this.edge = edge;
    }

    @Override
    public Edge getEdge() {
        return edge;
    }

    @DoNotMock
    @Override
    public void highlight(Consumer<MouseEvent> handler) {
        highlightHandler = handler;
        this.highlight();
    }

    @DoNotMock
    @Override
    public void selected(Consumer<MouseEvent> deselectHandler) {
        selected = deselectHandler;
    }

    @DoNotMock
    @Override
    public void highlight() {
        highlighted = true;
    }

    @DoNotMock
    @Override
    public void setLabel(String text) {
        label = text;
    }

    @DoNotMock
    @Override
    public void setCostLabel(Integer... costs) {
        label = Arrays.toString(costs);
    }

    @DoNotMock
    @Override
    public void hideLabel() {
        label = "";
    }

    @Override
    @DoNotMock
    public void unhighlight() {
        selected = null;
        highlighted = false;
        highlightHandler = null;
    }

    @Override
    public String toString() {
        return "TestEdgeController [edge=" + edge + ", highlightHandler=" + highlightHandler + ", highlighted="
                + highlighted + ", selected=" + selected + ", label=" + label + "]";
    }
}
