package hProjekt;

import static org.tudalgo.algoutils.tutor.general.jagr.RubricUtils.criterion;
import static org.tudalgo.algoutils.tutor.general.jagr.RubricUtils.graderPrivateOnly;

import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;
import org.tudalgo.algoutils.tutor.general.jagr.RubricUtils;
import org.tudalgo.algoutils.tutor.general.json.JsonParameterSet;

import com.fasterxml.jackson.databind.node.ObjectNode;

import hProjekt.controller.LeaderboardControllerTests;
import hProjekt.controller.PlayerControllerTest;
import hProjekt.model.grid.GameStateTest;
import hProjekt.model.grid.HexGridImplTest;
import hProjekt.model.grid.PlayerImplTest;
import hProjekt.model.grid.StatueTest;
import hProjekt.model.grid.TileImplTest;

public class HProjekt_RubricProviderPublic implements RubricProvider {

    // --- P1: Implementierung des Modells ---

    // P1.1 (1 Point)
    private static final Criterion HProjekt_1_1 = Criterion.builder()
            .shortDescription("P1.1 | Datenkraken")
            .maxPoints(1)
            .minPoints(0)
            .addChildCriteria(
                    criterion(
                            "Die Methoden getHexGrid, getName, getID, getColor und isAi sind korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testGetHexGrid",
                                            ObjectNode.class)),
                            JUnitTestRef.ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testGetName",
                                    ObjectNode.class)),
                            JUnitTestRef.ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testGetID",
                                    ObjectNode.class)),
                            JUnitTestRef.ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testGetColor",
                                    ObjectNode.class)),
                            JUnitTestRef.ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testIsAi",
                                    ObjectNode.class))))
            .build();

    // P1.2 (2 Points)
    private static final Criterion HProjekt_1_2 = Criterion.builder()
            .shortDescription("P1.2 | Geld regiert die Welt")
            .maxPoints(2)
            .minPoints(0)
            .addChildCriteria(
                    criterion("Die Methoden getAmulets und addAmulets sind korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> PlayerImplTest.class.getDeclaredMethod("testGetAmulets",
                                            ObjectNode.class)),
                            JUnitTestRef.ofMethod(
                                    () -> PlayerImplTest.class.getDeclaredMethod("testAddAmulets", ObjectNode.class))),
                    criterion("Die Methode removeAmulets ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerImplTest.class.getDeclaredMethod("testRemoveAmulets",
                                            ObjectNode.class))))
            .build();

    // P1.3 (6 Points)
    private static final Criterion HProjekt_1_3 = Criterion.builder()
            .shortDescription("P1.3 | Mehr als nur Stein ...")
            .maxPoints(6)
            .minPoints(0)
            .addChildCriteria(
                    criterion("Statue: Die Methode turn ist teilweise korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> StatueTest.class.getDeclaredMethod("testTurn_basic",
                                            ObjectNode.class))),
                    criterion("Statue: Die Methode turn ist vollständig korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> StatueTest.class.getDeclaredMethod("testTurn_complete",
                                            ObjectNode.class))),
                    criterion("Statue: Die Methode spawnAmulet ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> StatueTest.class.getDeclaredMethod("testSpawnAmulet_basic",
                                            ObjectNode.class))),
                    criterion("Statue: Die Methode spawnAmulet ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> StatueTest.class.getDeclaredMethod("testSpawnAmulet_complete",
                                            ObjectNode.class))),
                    criterion("HexGridImpl: Die Methode spawnAmulets ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> HexGridImplTest.class.getDeclaredMethod("testSpawnAmulets_basic",
                                            ObjectNode.class))),
                    criterion("HexGridImpl: Die Methode spawnAmulets ist vollständig korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> HexGridImplTest.class.getDeclaredMethod("testSpawnAmulets_complete",
                                            ObjectNode.class))))
            .build();

    // P1.4 (3 Points)
    private static final Criterion HProjekt_1_4 = Criterion.builder()
            .shortDescription("P1.4 | Bestagons")
            .maxPoints(3)
            .minPoints(0)
            .addChildCriteria(
                    criterion("TileImpl: Die Methode getNeighbours ist korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> TileImplTest.class.getDeclaredMethod("testGetNeighbours", ObjectNode.class))),
                    criterion("TileImpl: Die Methode isNear ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> TileImplTest.class.getDeclaredMethod("testIsNear_basic", ObjectNode.class))),
                    criterion("TileImpl: Die Methode isNear ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> TileImplTest.class.getDeclaredMethod("testIsNear_complete",
                                            ObjectNode.class))))
            .build();

    // P1.5 (6 Points)
    private static final Criterion HProjekt_1_5 = Criterion.builder()
            .shortDescription("P1.5 | Mein Schatz!")
            .maxPoints(6)
            .minPoints(0)
            .addChildCriteria(
                    criterion("GameState: Die Methode getTreasureTrail ist korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> GameStateTest.class.getDeclaredMethod("testGetTreasureTrail",
                                            ObjectNode.class))),
                    criterion(
                            "GameState: Die Methode evaluateTreasureTrail ist grundlegend korrekt implementiert.",
                            JUnitTestRef
                                    .ofMethod(() -> GameStateTest.class.getDeclaredMethod(
                                            "testEvaluateTreasureTrail_basic",
                                            ObjectNode.class))),
                    criterion("GameState: Die Methode evaluateTreasureTrail ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> GameStateTest.class.getDeclaredMethod(
                                            "testEvaluateTreasureTrail_mid",
                                            ObjectNode.class))),
                    criterion("GameState: Die Methode evaluateTreasureTrail ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> GameStateTest.class.getDeclaredMethod("testEvaluateTreasureTrail_complete",
                                            ObjectNode.class))),
                    criterion(
                            "GameState: Die Methode canAddCardToTreasureTrail ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> GameStateTest.class.getDeclaredMethod("testCanAddCardToTreasureTrail_basic",
                                            ObjectNode.class))),
                    criterion(
                            "GameState: Die Methode canAddCardToTreasureTrail ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> GameStateTest.class.getDeclaredMethod(
                                            "testCanAddCardToTreasureTrail_complete",
                                            ObjectNode.class))))
            .build();

    private static final Criterion HProjekt_1 = Criterion.builder()
            .shortDescription("P1 | Implementierung des Modells")
            .minPoints(0)
            .addChildCriteria(
                    HProjekt_1_1,
                    HProjekt_1_2,
                    HProjekt_1_3,
                    HProjekt_1_4,
                    HProjekt_1_5)
            .build();

    // --- P2: Flow Control! ---

    // P2.1 (4 Points)
    private static final Criterion HProjekt_2_1 = Criterion.builder()
            .shortDescription("P2.1 | Vollgas!")
            .maxPoints(4)
            .minPoints(0)
            .addChildCriteria(
                    criterion("PlayerController: getDrivableTiles ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testGetDrivableTiles_basic",
                                            ObjectNode.class))),
                    criterion("PlayerController: getDrivableTiles ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testGetDrivableTiles_complete",
                                            ObjectNode.class))),
                    criterion("PlayerController: drive ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(() -> PlayerControllerTest.class.getMethod("testDrive_basic",
                                    ObjectNode.class))),
                    criterion("PlayerController: drive ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(() -> PlayerControllerTest.class.getMethod("testDrive_complete",
                                    ObjectNode.class))))
            .build();

    // P2.2 (5 Points)
    private static final Criterion HProjekt_2_2 = Criterion.builder()
            .shortDescription("P2.2 | Gezinkte Karten")
            .maxPoints(5)
            .minPoints(0)
            .addChildCriteria(
                    criterion("PlayerController: getValidPathCards ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testGetValidPathCards_basic",
                                            ObjectNode.class))),
                    criterion("PlayerController: getValidPathCards ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testGetValidPathCards_complete",
                                            ObjectNode.class))),
                    criterion("PlayerController: playCard ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testPlayCard_basic",
                                            ObjectNode.class))),
                    criterion("PlayerController: playCard ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testPlayCard_complete",
                                            ObjectNode.class))),
                    criterion("PlayerController: drawTreasureCards ist korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testDrawTreasureCards",
                                            ObjectNode.class))))
            .build();

    // P2.3 (4 Points)
    private static final Criterion HProjekt_2_3 = Criterion.builder()
            .shortDescription("P2.3 | Hochmut kommt vor dem Fall")
            .maxPoints(4)
            .minPoints(0)
            .addChildCriteria(
                    criterion("PlayerController: collectTreasure ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testCollectTreasure_basic",
                                            ObjectNode.class))),
                    criterion("PlayerController: collectTreasure ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testCollectTreasure_complete",
                                            ObjectNode.class))),
                    criterion("PlayerController: acceptCurse ist teilweise korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testAcceptCurse_basic",
                                            ObjectNode.class))),
                    criterion("PlayerController: acceptCurse ist vollständig korrekt implementiert.",
                            JUnitTestRef.ofMethod(
                                    () -> PlayerControllerTest.class.getMethod("testAcceptCurse_complete",
                                            ObjectNode.class))))
            .build();

    // P2.4 (7 Points)
    private static final Criterion HProjekt_2_4 = Criterion.builder()
            .shortDescription("P2.4 | Amulette sind Macht")
            .maxPoints(7)
            .minPoints(0)
            .addChildCriteria(
                    privateCriterion("PlayerController: collectAmulet ist teilweise korrekt implementiert."),
                    privateCriterion("PlayerController: collectAmulet ist vollständig korrekt implementiert."),
                    privateCriterion("PlayerController: selectTileToRemove ist teilweise korrekt implementiert."),
                    privateCriterion("PlayerController: selectTileToRemove ist vollständig korrekt implementiert."),
                    privateCriterion("PlayerController: useAmulet ist grundlegend implementiert."),
                    privateCriterion("PlayerController: useAmulet ist teilweise korrekt implementiert."),
                    privateCriterion("PlayerController: useAmulet ist vollständig korrekt implementiert."))
            .build();

    // P2.5 (2 Points)
    private static final Criterion HProjekt_2_5 = Criterion.builder()
            .shortDescription("P2.5 | Oh nein, ein Fluch!")
            .maxPoints(2)
            .minPoints(0)
            .addChildCriteria(
                    privateCriterion("GameController: curse ist teilweise korrekt implementiert."),
                    privateCriterion("GameController: curse ist vollständig korrekt implementiert."))
            .build();

    // P2.6 (12 Points)
    private static final Criterion HProjekt_2_6 = Criterion.builder()
            .shortDescription("P2.6 | Gold fließt in die Schatzkammer!")
            .maxPoints(12)
            .minPoints(0)
            .addChildCriteria(
                    // offerTreasure (3)
                    privateCriterion("offerTreasure ist grundlegend implementiert."),
                    privateCriterion("offerTreasure ist teilweise korrekt implementiert."),
                    privateCriterion("offerTreasure ist vollständig korrekt implementiert."),
                    // drawAndShuffleTreasureCards (3)
                    privateCriterion("drawAndShuffleTreasureCards ist grundlegend implementiert."),
                    privateCriterion("drawAndShuffleTreasureCards ist teilweise korrekt implementiert."),
                    privateCriterion("drawAndShuffleTreasureCards ist vollständig korrekt implementiert."),
                    // distributeTreasureCards (3)
                    privateCriterion("distributeTreasureCards ist grundlegend implementiert."),
                    privateCriterion("distributeTreasureCards ist teilweise korrekt implementiert."),
                    privateCriterion("distributeTreasureCards ist vollständig korrekt implementiert."),
                    // collectTreasure (3)
                    privateCriterion("GameController: collectTreasure ist grundlegend implementiert."),
                    privateCriterion("GameController: collectTreasure ist teilweise korrekt implementiert."),
                    privateCriterion("GameController: collectTreasure ist vollständig korrekt implementiert."))
            .build();

    // P2.7 (2 Points)
    private static final Criterion HProjekt_2_7 = Criterion.builder()
            .shortDescription("P2.7 | Bin ich hier richtig?")
            .maxPoints(2)
            .minPoints(0)
            .addChildCriteria(
                    privateCriterion(
                            "PlayerController: updateCollectableTreasure ist teilweise korrekt implementiert."),
                    privateCriterion(
                            "PlayerController: updateCollectableTreasure ist vollständig korrekt implementiert."))
            .build();

    private static final Criterion HProjekt_2 = Criterion.builder()
            .shortDescription("P2 | Flow Control!")
            .minPoints(0)
            .addChildCriteria(
                    HProjekt_2_1,
                    HProjekt_2_2,
                    HProjekt_2_3,
                    HProjekt_2_4,
                    HProjekt_2_5,
                    HProjekt_2_6,
                    HProjekt_2_7)
            .build();

    // --- P3: Dem User Interface etwas Leben einhauchen ---

    // P3.1 (4 Points)
    private static final Criterion HProjekt_3_1 = Criterion.builder()
            .shortDescription("P3.1 | Hier bin ich richtig!")
            .maxPoints(4)
            .minPoints(0)
            .addChildCriteria(
                    privateCriterion("GUI: collectTreasure ist grundlegend implementiert."),
                    privateCriterion("GUI: collectTreasure ist teilweise korrekt implementiert."),
                    privateCriterion("GUI: collectTreasure ist fast vollständig korrekt implementiert."),
                    privateCriterion("GUI: collectTreasure ist vollständig korrekt implementiert."))
            .build();

    // P3.2 (6 Points)
    private static final Criterion HProjekt_3_2 = Criterion.builder()
            .shortDescription("P3.2 | Vielleicht bin ich doch nicht richtig?")
            .maxPoints(6)
            .minPoints(0)
            .addChildCriteria(
                    // useAmulet (3)
                    privateCriterion("GUI: useAmulet ist grundlegend implementiert."),
                    privateCriterion("GUI: useAmulet ist teilweise korrekt implementiert."),
                    privateCriterion("GUI: useAmulet ist vollständig korrekt implementiert."),
                    // selectTileToRemove (3)
                    privateCriterion("GUI: selectTileToRemove ist grundlegend implementiert."),
                    privateCriterion("GUI: selectTileToRemove ist teilweise korrekt implementiert."),
                    privateCriterion("GUI: selectTileToRemove ist vollständig korrekt implementiert."))
            .build();

    private static final Criterion HProjekt_3 = Criterion.builder()
            .shortDescription("P3 | Dem User Interface etwas Leben einhauchen")
            .minPoints(0)
            .addChildCriteria(
                    HProjekt_3_1,
                    HProjekt_3_2)
            .build();

    // --- P4: Highscore! ---

    // P4.1 (3 Points)
    private static final Criterion HProjekt_4_1 = Criterion.builder()
            .shortDescription("P4.1 | Leaderboard-Daten speichern")
            .maxPoints(3)
            .minPoints(0)
            .addChildCriteria(
                    criterion(
                            "Die Methode savePlayerData verwendet das richtige CSV-Format.",
                            JUnitTestRef.ofMethod(() -> LeaderboardControllerTests.class
                                    .getDeclaredMethod("testSavePlayerData_csvFormat", JsonParameterSet.class))),
                    criterion(
                            "Die Methode savePlayerData speichert den Namen, die Punkte und den Spielertyp korrekt in einer CSV-Datei.",
                            JUnitTestRef.ofMethod(() -> LeaderboardControllerTests.class
                                    .getDeclaredMethod("testSavePlayerData_dataCorrect", JsonParameterSet.class))),
                    criterion(
                            "Die aktuelle Zeit wird korrekt formatiert.",
                            JUnitTestRef.ofMethod(() -> LeaderboardControllerTests.class
                                    .getDeclaredMethod("testSavePlayerData_timestampFormat", JsonParameterSet.class))))
            .build();

    // P4.2 (3 Points)
    private static final Criterion HProjekt_4_2 = Criterion.builder()
            .shortDescription("P4.2 | Leaderboard-Daten laden")
            .maxPoints(3)
            .minPoints(0)
            .addChildCriteria(
                    criterion(
                            "Die Methode loadLeaderboardData ignoriert die Kopfzeile der CSV-Datei und modifiziert die Datei nicht.",
                            JUnitTestRef.ofMethod(() -> LeaderboardControllerTests.class
                                    .getDeclaredMethod("testLoadLeaderboardData_noMod", JsonParameterSet.class))),
                    criterion(
                            "Die Methode loadLeaderboardData liest alle gültigen Einträge aus der CSV-Datei und gibt sie als Liste von LeaderBoardEntry zurück.",
                            2,
                            JUnitTestRef.ofMethod(() -> LeaderboardControllerTests.class
                                    .getDeclaredMethod("testLoadLeaderboardData_dataCorrect", JsonParameterSet.class))))
            .build();

    private static final Criterion HProjekt_4 = Criterion.builder()
            .shortDescription("P4 | Highscore!")
            .minPoints(0)
            .addChildCriteria(
                    HProjekt_4_1,
                    HProjekt_4_2)
            .build();

    // --- P5: Weiterführende Aufgaben ---

    private static final Criterion HProjekt_5_1 = Criterion.builder()
            .shortDescription("P5.1 | Neue Spielmechaniken")
            .maxPoints(15)
            .minPoints(0)
            .addChildCriteria(
                    manualCriterion(
                            "Die erste neue Spielmechanik wurde in das Spiel integriert und ist verständlich dokumentiert.",
                            1),
                    manualCriterion(
                            "Die zweite neue Spielmechanik wurde in das Spiel integriert und ist verständlich dokumentiert.",
                            1),
                    manualCriterion(
                            "Die erste neue Spielmechanik bereichert das Spiel und ist nicht zu stark oder zu schwach.",
                            1),
                    manualCriterion(
                            "Die zweite neue Spielmechanik bereichert das Spiel und ist nicht zu stark oder zu schwach.",
                            1),
                    manualCriterion(
                            "Je nach Komplexität der ersten Mechanik können hier noch bis zu fünf weitere Punkte vergeben werden.",
                            5),
                    manualCriterion(
                            "Je nach Komplexität der zweiten Mechanik können hier noch bis zu fünf weitere Punkte vergeben werden.",
                            5),
                    manualCriterion(
                            "Es wurden 2 Spielmechaniken implementiert.",
                            1))
            .build();

    private static final Criterion HProjekt_5_2 = Criterion.builder()
            .shortDescription("P5.2 | KI als Gegner?")
            .maxPoints(15)
            .minPoints(0)
            .addChildCriteria(
                    manualCriterion(
                            "Die Strategie des Computergegners ist gut dokumentiert und sinnvoll.", 7),
                    manualCriterion(
                            "Die Strategie des Computergegners ist komplexer, als die der vorgegebenen KI.",
                            1),
                    manualCriterion(
                            "Der Computergegner ist implementiert und kann über das Menü ausgewählt werden.",
                            1),
                    manualCriterion(
                            "Der Computergegner kann alle Aktionen sinnvoll ausführen.",
                            3),
                    manualCriterion(
                            "Der Computergegner führt nur erlaubte Aktionen aus",
                            1),
                    manualCriterion(
                            "Wenn man zwei Computergegner gegeneinander spielen lässt, gewinnt einer der beiden.",
                            2))
            .build();

    private static final Criterion HProjekt_5 = Criterion.builder()
            .shortDescription("P5 | Weiterführende Aufgaben")
            .minPoints(0)
            .addChildCriteria(
                    HProjekt_5_1,
                    HProjekt_5_2)
            .build();

    public static final Rubric RUBRIC = Rubric.builder()
            .title("Projekt | Tobago")
            .addChildCriteria(
                    HProjekt_1,
                    HProjekt_2,
                    HProjekt_3,
                    HProjekt_4,
                    HProjekt_5)
            .build();

    public static Criterion privateCriterion(String message) {
        return privateCriterion(message, 0, 1);
    }

    public static Criterion privateCriterion(String message, int max) {
        return privateCriterion(message, 0, max);
    }

    public static Criterion privateCriterion(String message, int min, int max) {
        return Criterion.builder()
                .shortDescription(message)
                .grader(graderPrivateOnly(max))
                .minPoints(min)
                .maxPoints(max)
                .build();
    }

    public static Criterion manualCriterion(String message) {
        return manualCriterion(message, 0, 1);
    }

    public static Criterion manualCriterion(String message, int max) {
        return manualCriterion(message, 0, max);
    }

    public static Criterion manualCriterion(String message, int min, int max) {
        return Criterion.builder()
                .shortDescription(message)
                .grader(RubricUtils
                        .manualGrader(max))
                .minPoints(min)
                .maxPoints(max)
                .build();
    }

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
