package hProjekt.controller;

import static hProjekt.Project_TestP.assertContainsAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import hProjekt.*;
import hProjekt.model.*;
import hProjekt.model.cards.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.mocking.MockConverterP;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.mocking.StudentMethodCall;
import org.tudalgo.algoutils.tutor.general.assertions.*;

@TestForSubmission
public class GameControllerTest {
    @ParameterizedTest
    @MethodSource("provideCurse_basic")
    public void testCurse_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("curse", java.util.List.class);
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

                GameController expectedController = ((GameController) (expected));
                GameController actualController = ((GameController) (actual.invoked));
                Arrays.stream(actual.call.arguments()).filter(arg -> arg instanceof List).forEach(arg -> {
                    List<Player> players = ((List<Player>) (arg)).stream().distinct().toList();
                    Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                    if (players.isEmpty()) {
                        verify(actualController, never()).withActivePlayer(any(), any());
                    } else {
                        players.forEach(player -> {
                            PlayerController playerController = playerControllers.get(player);
                            verify(actualController, times(1)).withActivePlayer(eq(playerController), any());
                            verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_CURSE);
                        });
                    }
                });
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCurse_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_curse_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideCurse_complete")
    public void testCurse_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("curse", java.util.List.class);
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

                GameController expectedController = ((GameController) (expected));
                GameController actualController = ((GameController) (actual.invoked));
                Arrays.stream(actual.call.arguments()).filter(arg -> arg instanceof List).forEach(arg -> {
                    List<Player> players = ((List<Player>) (arg)).stream().distinct().toList();
                    Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                    if (players.isEmpty()) {
                        verify(actualController, never()).withActivePlayer(any(), any());
                    } else {
                        players.forEach(player -> {
                            PlayerController playerController = playerControllers.get(player);
                            verify(actualController, times(1)).withActivePlayer(eq(playerController), any());
                            verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_CURSE);
                        });
                    }
                });
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCurse_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_curse_complete.json");
    }

    @ParameterizedTest
    @MethodSource("provideOfferTreasure_basic")
    public void testOfferTreasure_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("offerTreasure", hProjekt.model.cards.GoldCard.class, java.util.List.class);
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

                GameController actualController = ((GameController) (actual.invoked));
                List<Player> players = actualController.getState().getPlayers();
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                if (players.isEmpty()) {
                    verify(actualController, never()).withActivePlayer(any(), any());
                } else {
                    players.forEach(player -> {
                        PlayerController playerController = playerControllers.get(player);
                        if (player.getID() == 4) {
                            verify(actualController, never()).withActivePlayer(eq(playerController), any());
                            return;
                        }
                        verify(actualController, times(1)).withActivePlayer(eq(playerController), any());
                        verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_TREASURE);
                    });
                };
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "offerTreasure did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideOfferTreasure_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_offerTreasure_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideOfferTreasure_complete")
    public void testOfferTreasure_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("offerTreasure", hProjekt.model.cards.GoldCard.class, java.util.List.class);
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

                GameController actualController = ((GameController) (actual.invoked));
                List<Player> players = actualController.getState().getPlayers();
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                if (players.isEmpty()) {
                    verify(actualController, never()).withActivePlayer(any(), any());
                } else {
                    players.forEach(player -> {
                        PlayerController playerController = playerControllers.get(player);
                        if (player.getID() == 4) {
                            verify(actualController, never()).withActivePlayer(eq(playerController), any());
                            return;
                        }
                        verify(actualController, times(1)).withActivePlayer(eq(playerController), any());
                        verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_TREASURE);
                    });
                };
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "offerTreasure did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideOfferTreasure_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_offerTreasure_complete.json");
    }


    @ParameterizedTest
    @MethodSource("provideOfferTreasure_mid")
    public void testOfferTreasure_mid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("offerTreasure", hProjekt.model.cards.GoldCard.class, java.util.List.class);
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

                GameController actualController = ((GameController) (actual.invoked));
                List<Player> players = actualController.getState().getPlayers();
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                if (players.isEmpty()) {
                    verify(actualController, never()).withActivePlayer(any(), any());
                } else {
                    players.forEach(player -> {
                        PlayerController playerController = playerControllers.get(player);
                        if (player.getID() == 4) {
                            verify(actualController, never()).withActivePlayer(eq(playerController), any());
                            return;
                        }
                        verify(actualController, times(1)).withActivePlayer(eq(playerController), any());
                        verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_TREASURE);
                    });
                };
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "offerTreasure did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideOfferTreasure_mid() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_offerTreasure_mid.json");
    }

    @ParameterizedTest
    @MethodSource("provideDrawAndShuffleTreasureCards_basic")
    public void testDrawAndShuffleTreasureCards_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("drawAndShuffleTreasureCards", java.util.List.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                assertContainsAll((List<Object>) expected, (List<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDrawAndShuffleTreasureCards_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_drawAndShuffleTreasureCards_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideDrawAndShuffleTreasureCards_complete")
    public void testDrawAndShuffleTreasureCards_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("drawAndShuffleTreasureCards", java.util.List.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                assertContainsAll((List<Object>) expected, (List<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDrawAndShuffleTreasureCards_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_drawAndShuffleTreasureCards_complete.json");
    }


    @ParameterizedTest
    @MethodSource("provideDrawAndShuffleTreasureCards_mid")
    public void testDrawAndShuffleTreasureCards_mid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("drawAndShuffleTreasureCards", java.util.List.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                assertContainsAll((List<Object>) expected, (List<Object>) actual.call.returnValue(), context);
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDrawAndShuffleTreasureCards_mid() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_drawAndShuffleTreasureCards_mid.json");
    }

    @ParameterizedTest
    @MethodSource("provideDistributeTreasureCards_basic")
    public void testDistributeTreasureCards_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("distributeTreasureCards", java.util.List.class, java.util.Stack.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController actualController = ((GameController) (actual.invoked));
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                Arrays.stream(actual.call.arguments()).filter(arg -> (arg instanceof List) && (!(arg instanceof Stack))).forEach(arg ->
                {
                    List<PathCard> trail = ((List<PathCard>) (arg));
                    List<Player> players = trail.stream().map(PathCard::getPlayer).distinct().toList();
                    if (Arrays.stream(actual.call.arguments()).filter(arg1 -> arg1 instanceof Stack).flatMap(arg1 ->
                        ((Stack<TreasureCard>) (arg1)).stream()).anyMatch(card ->
                        card instanceof CurseCard)) {
                        players.forEach(player -> {
                            PlayerController playerController = playerControllers.get(player);
                            verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_CURSE);
                        });
                    }
                });
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "distributeTreasureCards did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDistributeTreasureCards_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_distributeTreasureCards_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideDistributeTreasureCards_complete")
    public void testDistributeTreasureCards_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("distributeTreasureCards", java.util.List.class, java.util.Stack.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController actualController = ((GameController) (actual.invoked));
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                Arrays.stream(actual.call.arguments()).filter(arg -> (arg instanceof List) && (!(arg instanceof Stack))).forEach(arg ->
                {
                    List<PathCard> trail = ((List<PathCard>) (arg));
                    List<Player> players = trail.stream().map(PathCard::getPlayer).distinct().toList();
                    if (Arrays.stream(actual.call.arguments()).filter(arg1 -> arg1 instanceof Stack).flatMap(arg1 ->
                        ((Stack<TreasureCard>) (arg1)).stream()).anyMatch(card ->
                        card instanceof CurseCard)) {
                        players.forEach(player -> {
                            PlayerController playerController = playerControllers.get(player);
                            verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_CURSE);
                        });
                    }
                });
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "distributeTreasureCards did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDistributeTreasureCards_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_distributeTreasureCards_complete.json");
    }


    @ParameterizedTest
    @MethodSource("provideDistributeTreasureCards_mid")
    public void testDistributeTreasureCards_mid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("distributeTreasureCards", java.util.List.class, java.util.Stack.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController actualController = ((GameController) (actual.invoked));
                Map<Player, PlayerController> playerControllers = actualController.getPlayerControllers();
                Arrays.stream(actual.call.arguments()).filter(arg -> (arg instanceof List) && (!(arg instanceof Stack))).forEach(arg ->
                {
                    List<PathCard> trail = ((List<PathCard>) (arg));
                    List<Player> players = trail.stream().map(PathCard::getPlayer).distinct().toList();
                    if (Arrays.stream(actual.call.arguments()).filter(arg1 -> arg1 instanceof Stack).flatMap(arg1 ->
                        ((Stack<TreasureCard>) (arg1)).stream()).anyMatch(card ->
                        card instanceof CurseCard)) {
                        players.forEach(player -> {
                            PlayerController playerController = playerControllers.get(player);
                            verify(playerController, times(1)).waitForNextAction(PlayerObjective.ACCEPT_CURSE);
                        });
                    }
                });
                assertEquals(expected, actual.call.returnValue(), context, r ->
                    "distributeTreasureCards did not return the expected value.");
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideDistributeTreasureCards_mid() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_distributeTreasureCards_mid.json");
    }

    @ParameterizedTest
    @MethodSource("provideCollectTreasure_basic")
    public void testCollectTreasure_basic(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("collectTreasure", javafx.scene.paint.Color.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController expectedController = ((GameController) (expected));
                GameController actualController = ((GameController) (actual.invoked));
                assertContainsAll(expectedController.getState().getGrid().getTiles(),
                    actualController.getState().getGrid().getTiles(),
                    context);
                assertContainsAll(expectedController.getState().getTreasureTrails(),
                    actualController.getState().getTreasureTrails(), context);
                verify(actualController.getState().getGrid(), times(1)).spawnAmulets();
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_basic() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_collectTreasure_basic.json");
    }


    @ParameterizedTest
    @MethodSource("provideCollectTreasure_complete")
    public void testCollectTreasure_complete(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("collectTreasure", javafx.scene.paint.Color.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController expectedController = ((GameController) (expected));
                GameController actualController = ((GameController) (actual.invoked));
                assertContainsAll(expectedController.getState().getGrid().getTiles(),
                    actualController.getState().getGrid().getTiles(),
                    context);
                assertContainsAll(expectedController.getState().getTreasureTrails(),
                    actualController.getState().getTreasureTrails(), context);
                verify(actualController.getState().getGrid(), times(1)).spawnAmulets();
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_complete() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_collectTreasure_complete.json");
    }


    @ParameterizedTest
    @MethodSource("provideCollectTreasure_mid")
    public void testCollectTreasure_mid(ObjectNode node) throws NoSuchMethodException {
        hProjekt.controller.GameController.class.getDeclaredMethod("collectTreasure", javafx.scene.paint.Color.class);
        Object expected = new MockConverterP().fromJsonNodeWithBackfill((ObjectNode) node.get("expected"), null);
        Consumer<Object> beforeEach = o -> Config.RANDOM.setSeed(67);
        List<StudentMethodCall> results = MockConverterP.recreateCallAndInvoke(node, beforeEach);

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

                GameController expectedController = ((GameController) (expected));
                GameController actualController = ((GameController) (actual.invoked));
                assertContainsAll(expectedController.getState().getGrid().getTiles(),
                    actualController.getState().getGrid().getTiles(),
                    context);
                assertContainsAll(expectedController.getState().getTreasureTrails(),
                    actualController.getState().getTreasureTrails(), context);
                verify(actualController.getState().getGrid(), times(1)).spawnAmulets();
                return;
            } catch (Throwable e) {
                lastCall = e;
            }
        }
        ReflectionUtilsP.getUnsafe().throwException(lastCall);
    }

    private static Stream<Arguments> provideCollectTreasure_mid() {
        return Project_TestP.parseJsonFile("hProjekt/controller/GameController_collectTreasure_mid.json");
    }
}
