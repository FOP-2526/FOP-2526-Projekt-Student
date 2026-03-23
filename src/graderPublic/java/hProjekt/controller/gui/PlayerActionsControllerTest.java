package hProjekt.controller.gui;

import static hProjekt.Project_TestP.assertContainsAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

import java.util.List;
import java.util.stream.Stream;

import hProjekt.controller.actions.*;
import hProjekt.model.*;
import hProjekt.testOverrides.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Context;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.Project_TestP;
import hProjekt.controller.PlayerController;
import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;
import javafx.beans.property.Property;

@TestForSubmission
public class PlayerActionsControllerTest {
    @ParameterizedTest
    @MethodSource("provideCollectTreasure_part_1")
    public void testCollectTreasure_part_1(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("collectTreasure");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                if (((Property<PlayerState>) (ReflectionUtilsP.getFieldValue(expectedController, "playerStateProperty"))).getValue().collectableTreasures().isEmpty())
                {
                    verify(actualGameBoardController, never()).setAvailableColors(any());
                    verify(actualGameBoardController, never()).showColorSelectionOverlay();
                } else if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(expectedGameBoardController.availableColors,
                        actualGameBoardController.availableColors, context);
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualGameBoardController, times(1)).setOnColorSelected(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                    assertContainsAll(expectedPlayerController.triggeredActions, actualPlayerController.triggeredActions,
                        context);
                } else if (expectedGameBoardController.stage == 4) {
                    verify(actualGameBoardController, times(1)).showColorSelectionOverlay();
                    verify(actualGameBoardController, times(1)).setOnColorSelectionCancelled(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_part_1() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_collectTreasure_part_1.json");
    }


    @ParameterizedTest
    @MethodSource("provideCollectTreasure_part_2")
    public void testCollectTreasure_part_2(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("collectTreasure");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                if (((Property<PlayerState>) (ReflectionUtilsP.getFieldValue(expectedController, "playerStateProperty"))).getValue().collectableTreasures().isEmpty())
                {
                    verify(actualGameBoardController, never()).setAvailableColors(any());
                    verify(actualGameBoardController, never()).showColorSelectionOverlay();
                } else if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(expectedGameBoardController.availableColors,
                        actualGameBoardController.availableColors, context);
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualGameBoardController, times(1)).setOnColorSelected(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                    assertContainsAll(expectedPlayerController.triggeredActions, actualPlayerController.triggeredActions,
                        context);
                } else if (expectedGameBoardController.stage == 4) {
                    verify(actualGameBoardController, times(1)).showColorSelectionOverlay();
                    verify(actualGameBoardController, times(1)).setOnColorSelectionCancelled(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_part_2() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_collectTreasure_part_2.json");
    }


    @ParameterizedTest
    @MethodSource("provideCollectTreasure_part_3")
    public void testCollectTreasure_part_3(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("collectTreasure");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                if (((Property<PlayerState>) (ReflectionUtilsP.getFieldValue(expectedController, "playerStateProperty"))).getValue().collectableTreasures().isEmpty())
                {
                    verify(actualGameBoardController, never()).setAvailableColors(any());
                    verify(actualGameBoardController, never()).showColorSelectionOverlay();
                } else if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(expectedGameBoardController.availableColors,
                        actualGameBoardController.availableColors, context);
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualGameBoardController, times(1)).setOnColorSelected(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                    assertContainsAll(expectedPlayerController.triggeredActions, actualPlayerController.triggeredActions,
                        context);
                } else if (expectedGameBoardController.stage == 4) {
                    verify(actualGameBoardController, times(1)).showColorSelectionOverlay();
                    verify(actualGameBoardController, times(1)).setOnColorSelectionCancelled(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_part_3() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_collectTreasure_part_3.json");
    }


    @ParameterizedTest
    @MethodSource("provideCollectTreasure_part_4")
    public void testCollectTreasure_part_4(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("collectTreasure");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                if (((Property<PlayerState>) (ReflectionUtilsP.getFieldValue(expectedController, "playerStateProperty"))).getValue().collectableTreasures().isEmpty())
                {
                    verify(actualGameBoardController, never()).setAvailableColors(any());
                    verify(actualGameBoardController, never()).showColorSelectionOverlay();
                } else if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(expectedGameBoardController.availableColors,
                        actualGameBoardController.availableColors, context);
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualGameBoardController, times(1)).setOnColorSelected(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                    assertContainsAll(expectedPlayerController.triggeredActions, actualPlayerController.triggeredActions,
                        context);
                } else if (expectedGameBoardController.stage == 4) {
                    verify(actualGameBoardController, times(1)).showColorSelectionOverlay();
                    verify(actualGameBoardController, times(1)).setOnColorSelectionCancelled(any());
                    verify(actualGameBoardController, times(1)).hideColorSelectionOverlay();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_part_4() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_collectTreasure_part_4.json");
    }

    @ParameterizedTest
    @MethodSource("provideSelectTileToRemove_part_1")
    public void testSelectTileToRemove_part_1(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("selectTileToRemove");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                TestHexGridController expectedHexGridController = ((TestHexGridController) (expectedGameBoardController.getHexGridController()));
                TestHexGridController actualHexGridController = ((TestHexGridController) (actualGameBoardController.getHexGridController()));
                if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(
                        expectedHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        context);
                } else if (expectedGameBoardController.stage == 2) {
                    verify(actualHexGridController.getTileControllersMap().get(actualGameBoardController.highlightedTile),
                        times(1)).highlight(any());
                    actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                        tc.highlighted != null).forEach(tc -> {
                        verify(tc, times(1)).unhighlight();
                    });
                    verify(actualPlayerController, times(1)).triggerAction(
                        refEq(new SelectTileToRemove(actualGameBoardController.highlightedTile.getPosition(),
                            actualGameBoardController.getSelectedTrail().getValue())));
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualPlayerController, never()).triggerAction(any());
                    verify(actualHexGridController, never()).unhighlightTiles();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSelectTileToRemove_part_1() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_selectTileToRemove_part_1.json");
    }


    @ParameterizedTest
    @MethodSource("provideSelectTileToRemove_part_2")
    public void testSelectTileToRemove_part_2(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("selectTileToRemove");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                TestHexGridController expectedHexGridController = ((TestHexGridController) (expectedGameBoardController.getHexGridController()));
                TestHexGridController actualHexGridController = ((TestHexGridController) (actualGameBoardController.getHexGridController()));
                if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(
                        expectedHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        context);
                } else if (expectedGameBoardController.stage == 2) {
                    verify(actualHexGridController.getTileControllersMap().get(actualGameBoardController.highlightedTile),
                        times(1)).highlight(any());
                    actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                        tc.highlighted != null).forEach(tc -> {
                        verify(tc, times(1)).unhighlight();
                    });
                    verify(actualPlayerController, times(1)).triggerAction(
                        refEq(new SelectTileToRemove(actualGameBoardController.highlightedTile.getPosition(),
                            actualGameBoardController.getSelectedTrail().getValue())));
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualPlayerController, never()).triggerAction(any());
                    verify(actualHexGridController, never()).unhighlightTiles();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSelectTileToRemove_part_2() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_selectTileToRemove_part_2.json");
    }


    @ParameterizedTest
    @MethodSource("provideSelectTileToRemove_part_3")
    public void testSelectTileToRemove_part_3(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.gui.PlayerActionsController.class.getDeclaredMethod("selectTileToRemove");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }


        Throwable lastCall = null;
        for (StudentMethodCall actual: results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                    .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                    .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                    .build();

                PlayerActionsController expectedController = ((PlayerActionsController) (expected));
                PlayerActionsController actualController = ((PlayerActionsController) (actual.invoked));
                TestPlayerController expectedPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    expectedController, "playerControllerProperty"))).getValue()));
                TestPlayerController actualPlayerController = ((TestPlayerController) (((Property<PlayerController>) (ReflectionUtilsP.getFieldValue(
                    actualController, "playerControllerProperty"))).getValue()));
                TestGameBoardController expectedGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    expectedController, "gameBoardController")));
                TestGameBoardController actualGameBoardController = ((TestGameBoardController) (ReflectionUtilsP.getFieldValue(
                    actualController, "gameBoardController")));
                TestHexGridController expectedHexGridController = ((TestHexGridController) (expectedGameBoardController.getHexGridController()));
                TestHexGridController actualHexGridController = ((TestHexGridController) (actualGameBoardController.getHexGridController()));
                if (expectedGameBoardController.stage == 1) {
                    assertContainsAll(
                        expectedHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                            tc.highlighted != null).toList(),
                        context);
                } else if (expectedGameBoardController.stage == 2) {
                    verify(actualHexGridController.getTileControllersMap().get(actualGameBoardController.highlightedTile),
                        times(1)).highlight(any());
                    actualHexGridController.getTileControllers().stream().map(tc -> ((TestTileController) (tc))).filter(tc ->
                        tc.highlighted != null).forEach(tc -> {
                        verify(tc, times(1)).unhighlight();
                    });
                    verify(actualPlayerController, times(1)).triggerAction(
                        refEq(new SelectTileToRemove(actualGameBoardController.highlightedTile.getPosition(),
                            actualGameBoardController.getSelectedTrail().getValue())));
                } else if (expectedGameBoardController.stage == 3) {
                    verify(actualPlayerController, never()).triggerAction(any());
                    verify(actualHexGridController, never()).unhighlightTiles();
                };
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideSelectTileToRemove_part_3() {
        return Project_TestP.parseJsonFile("hProjekt/controller/gui/PlayerActionsController_selectTileToRemove_part_3.json");
    }
}
