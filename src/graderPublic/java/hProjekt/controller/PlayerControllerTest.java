package hProjekt.controller;

import static hProjekt.Project_TestP.assertContainsAll;
import static hProjekt.Project_TestP.assertEqualsWithMatcher;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertNotNull;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.BasicMethodLink;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.Config;
import hProjekt.Project_TestP;
import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.NonHashMap;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;
import hProjekt.model.GameState;
import hProjekt.model.cards.CardType;
import hProjekt.model.cards.InAreaCard;
import hProjekt.model.cards.NextToCard;
import hProjekt.model.cards.PathCard;
import hProjekt.model.grid.Tile;
import hProjekt.model.grid.Types;
import javafx.scene.paint.Color;

@TestForSubmission
public class PlayerControllerTest {
    @ParameterizedTest
    @MethodSource("provideDrive_basic")
    public void testDrive_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("drive", hProjekt.model.grid.Tile.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> ReflectionUtilsP.setStaticFieldValue(Config.class, "DRIVE_LIMIT", 1);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                PlayerController expectedController = ((PlayerController) (expected));
                PlayerController actualController = ((PlayerController) (actual.invoked));
                assertEqualsWithMatcher(expectedController.getPlayer().getPosition(),
                        actualController.getPlayer().getPosition(), (e, a) -> {
                            if ((e == null) && (a == null)) {
                                return true;
                            }
                            if ((e == null) || (a == null)) {
                                return false;
                            }
                            return ReflectionUtilsP.equalsForMocks(e, a);
                        }, context);
                assertEquals(ReflectionUtilsP.getFieldValue(expectedController, "driveCount"),
                        ReflectionUtilsP.getFieldValue(actualController, "driveCount"), context,
                        r -> "driveCount was not set correctly.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDrive_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_drive_basic.json");
    }

    @ParameterizedTest
    @MethodSource("provideDrive_complete")
    public void testDrive_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("drive", hProjekt.model.grid.Tile.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> ReflectionUtilsP.setStaticFieldValue(Config.class, "DRIVE_LIMIT", 1);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .add("Exception class", actual.exception != null ? actual.exception.getClass() : "none")
                        .add("Exception message", actual.exception != null ? actual.exception.getMessage() : "none")
                        .add("Exception stacktrace",
                                actual.exception != null ? ReflectionUtilsP.formatStackTrace(actual.exception) : "none")

                        .build();

                if (expected instanceof Exception && !Exception.class.isAssignableFrom(
                        ReflectionUtilsP.stringToMethod(node.get("entryPoint").asText()).getReturnType())) {
                    assertNotNull(actual.exception, context, r -> "Drive() did not throw an exception!");
                    assertEquals(expected.getClass(), actual.exception.getClass(), context,
                            r -> "Drive() did not throw an exception of the expected Type");
                    return;
                }

                PlayerController expectedController = ((PlayerController) (expected));
                PlayerController actualController = ((PlayerController) (actual.invoked));
                assertEqualsWithMatcher(expectedController.getPlayer().getPosition(),
                        actualController.getPlayer().getPosition(), (e, a) -> {
                            if ((e == null) && (a == null)) {
                                return true;
                            }
                            if ((e == null) || (a == null)) {
                                return false;
                            }
                            return ReflectionUtilsP.equalsForMocks(e, a);
                        }, context);
                assertEquals(ReflectionUtilsP.getFieldValue(expectedController, "driveCount"),
                        ReflectionUtilsP.getFieldValue(actualController, "driveCount"), context,
                        r -> "driveCount was not set correctly.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDrive_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_drive_complete.json");
    }

    @ParameterizedTest
    @MethodSource("provideGetValidPathCards_basic")
    public void testGetValidPathCards_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("getValidPathCards");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = invoked -> {
            PlayerController controller = ((PlayerController) (invoked));
            controller.getPlayer().getPathCards().forEach(pc -> {
                if (pc.getType() == CardType.IN_AREA) {
                    try {
                        ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                BasicMethodLink.of(
                                        InAreaCard.class.getDeclaredMethod("filterTileByType", Types.class)).invoke(
                                                null, pc.getFilterType()));
                    } catch (Throwable e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                } else if (pc.getType() == CardType.NEXT_TO) {
                    try {
                        ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                BasicMethodLink.of(
                                        NextToCard.class.getDeclaredMethod("filterByTile", Tile.Type.class)).invoke(
                                                null, ((Tile.Type) (pc.getFilterType()))));
                    } catch (Throwable e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            });
            ((GameController) (ReflectionUtilsP.getFieldValue(controller, "gameController"))).getState()
                    .getTreasureTrails().values().forEach(trail -> trail.forEach(pc -> {
                        if (pc.getType() == CardType.IN_AREA) {
                            try {
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                        BasicMethodLink.of(
                                                InAreaCard.class.getDeclaredMethod("filterTileByType",
                                                        Types.class))
                                                .invoke(
                                                        null, pc.getFilterType()));
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (pc.getType() == CardType.NEXT_TO) {
                            try {
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                        BasicMethodLink.of(
                                                NextToCard.class.getDeclaredMethod("filterByTile",
                                                        Tile.Type.class))
                                                .invoke(
                                                        null, ((Tile.Type) (pc.getFilterType()))));
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (pc.getType() == CardType.NOT_IN_AREA) {
                            try {
                                Predicate<Tile> filter = (Tile tile) -> {
                                    try {
                                        return !((Predicate<Tile>) (BasicMethodLink.of(
                                                InAreaCard.class.getDeclaredMethod(
                                                        "filterTileByType",
                                                        Types.class))
                                                .invoke(
                                                        null, pc.getFilterType())))
                                                .test(tile);
                                    } catch (Throwable e) {
                                        e.printStackTrace();
                                        throw new RuntimeException(e);
                                    }
                                };
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction", filter);
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }));
        };
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                assertEqualsWithMatcher(
                        ((Map<Color, List<PathCard>>) (expected)),
                        ((Map<Color, List<PathCard>>) (actual.call.returnValue())), (e, a) -> {
                            if ((e == null) && (a == null)) {
                                return true;
                            }
                            if ((e == null) || (a == null)) {
                                return false;
                            }
                            return ReflectionUtilsP.equalsForMocks(e, new NonHashMap<>(a));
                        },
                        context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetValidPathCards_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_getValidPathCards_basic.json");
    }

    @ParameterizedTest
    @MethodSource("provideGetValidPathCards_complete")
    public void testGetValidPathCards_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("getValidPathCards");
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = invoked -> {
            PlayerController controller = ((PlayerController) (invoked));
            controller.getPlayer().getPathCards().forEach(pc -> {
                if (pc.getType() == CardType.IN_AREA) {
                    try {
                        ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                BasicMethodLink.of(
                                        InAreaCard.class.getDeclaredMethod("filterTileByType", Types.class)).invoke(
                                                null, pc.getFilterType()));
                    } catch (Throwable e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                } else if (pc.getType() == CardType.NEXT_TO) {
                    try {
                        ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                BasicMethodLink.of(
                                        NextToCard.class.getDeclaredMethod("filterByTile", Tile.Type.class)).invoke(
                                                null, ((Tile.Type) (pc.getFilterType()))));
                    } catch (Throwable e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                }
            });
            ((GameController) (ReflectionUtilsP.getFieldValue(controller, "gameController"))).getState()
                    .getTreasureTrails().values().forEach(trail -> trail.forEach(pc -> {
                        if (pc.getType() == CardType.IN_AREA) {
                            try {
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                        BasicMethodLink.of(
                                                InAreaCard.class.getDeclaredMethod("filterTileByType",
                                                        Types.class))
                                                .invoke(
                                                        null, pc.getFilterType()));
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (pc.getType() == CardType.NEXT_TO) {
                            try {
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction",
                                        BasicMethodLink.of(
                                                NextToCard.class.getDeclaredMethod("filterByTile",
                                                        Tile.Type.class))
                                                .invoke(
                                                        null, ((Tile.Type) (pc.getFilterType()))));
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (pc.getType() == CardType.NOT_IN_AREA) {
                            try {
                                Predicate<Tile> filter = (Tile tile) -> {
                                    try {
                                        return !((Predicate<Tile>) (BasicMethodLink.of(
                                                InAreaCard.class.getDeclaredMethod(
                                                        "filterTileByType",
                                                        Types.class))
                                                .invoke(
                                                        null, pc.getFilterType())))
                                                .test(tile);
                                    } catch (Throwable e) {
                                        e.printStackTrace();
                                        throw new RuntimeException(e);
                                    }
                                };
                                ReflectionUtilsP.setFieldValue(pc, "tileFilterFunction", filter);
                            } catch (Throwable e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }));
        };
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                assertEqualsWithMatcher(
                        ((Map<Color, List<PathCard>>) (expected)),
                        ((Map<Color, List<PathCard>>) (actual.call.returnValue())), (e, a) -> {
                            if ((e == null) && (a == null)) {
                                return true;
                            }
                            if ((e == null) || (a == null)) {
                                return false;
                            }
                            return ReflectionUtilsP.equalsForMocks(e, new NonHashMap<>(a));
                        },
                        context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideGetValidPathCards_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_getValidPathCards_complete.json");
    }

    @ParameterizedTest
    @MethodSource("providePlayCard_basic")
    public void testPlayCard_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("playCard", hProjekt.model.cards.PathCard.class,
                javafx.scene.paint.Color.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(69420);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        if (results.stream().allMatch(it -> it.exception != null)) {
            ReflectionUtilsP.getUnsafe().throwException(results.getLast().exception);
        }

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .build();

                PlayerController expectedController = ((PlayerController) (expected));
                PlayerController actualController = ((PlayerController) (actual.invoked));
                GameState expectedState = ((GameController) (ReflectionUtilsP.getFieldValue(expectedController,
                        "gameController"))).getState();
                GameState actualState = ((GameController) (ReflectionUtilsP.getFieldValue(actualController,
                        "gameController"))).getState();
                assertContainsAll(
                        ((Map<Color, List<PathCard>>) (ReflectionUtilsP.getFieldValue(expectedState,
                                "treasureTrails"))),
                        ((Map<Color, List<PathCard>>) (ReflectionUtilsP.getFieldValue(actualState, "treasureTrails"))),
                        context);
                assertContainsAll(
                        ((Map<Color, Set<Tile>>) (ReflectionUtilsP.getFieldValue(expectedState, "treasurePositions"))),
                        ((Map<Color, Set<Tile>>) (ReflectionUtilsP.getFieldValue(actualState, "treasurePositions"))),
                        context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> providePlayCard_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_playCard_basic.json");
    }

    @ParameterizedTest
    @MethodSource("providePlayCard_complete")
    public void testPlayCard_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.PlayerController.class.getDeclaredMethod("playCard", hProjekt.model.cards.PathCard.class,
                javafx.scene.paint.Color.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(69420);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

        Throwable lastCall = null;
        for (StudentMethodCall actual : results) {
            if (actual.call == null) {
                lastCall = actual.exception;
                continue;
            }
            try {
                Context context = contextBuilder()
                        .add("invoked", actual.invoked != null ? actual.invoked : "unknown")
                        .add("parameters", actual.call != null ? actual.call.arguments() : "unknown")
                        .add("Exception class", actual.exception != null ? actual.exception.getClass() : "none")
                        .add("Exception message", actual.exception != null ? actual.exception.getMessage() : "none")
                        .add("Exception stacktrace",
                                actual.exception != null ? ReflectionUtilsP.formatStackTrace(actual.exception) : "none")

                        .build();

                if (expected instanceof Exception && !Exception.class.isAssignableFrom(
                        ReflectionUtilsP.stringToMethod(node.get("entryPoint").asText()).getReturnType())) {
                    assertNotNull(actual.exception, context, r -> "PlayCard() did not throw an exception!");
                    assertEquals(expected.getClass(), actual.exception.getClass(), context,
                            r -> "PlayCard() did not throw an exception of the expected Type");
                    return;
                }

                PlayerController expectedController = ((PlayerController) (expected));
                PlayerController actualController = ((PlayerController) (actual.invoked));
                GameState expectedState = ((GameController) (ReflectionUtilsP.getFieldValue(expectedController,
                        "gameController"))).getState();
                GameState actualState = ((GameController) (ReflectionUtilsP.getFieldValue(actualController,
                        "gameController"))).getState();
                assertContainsAll(
                        ((Map<Color, List<PathCard>>) (ReflectionUtilsP.getFieldValue(expectedState,
                                "treasureTrails"))),
                        ((Map<Color, List<PathCard>>) (ReflectionUtilsP.getFieldValue(actualState, "treasureTrails"))),
                        context);
                assertContainsAll(
                        ((Map<Color, Set<Tile>>) (ReflectionUtilsP.getFieldValue(expectedState, "treasurePositions"))),
                        ((Map<Color, Set<Tile>>) (ReflectionUtilsP.getFieldValue(actualState, "treasurePositions"))),
                        context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> providePlayCard_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/PlayerController_playCard_complete.json");
    }
}
