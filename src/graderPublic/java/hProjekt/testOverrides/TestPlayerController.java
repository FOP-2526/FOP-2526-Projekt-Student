package hProjekt.testOverrides;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hProjekt.DoNotMock;
import hProjekt.controller.GameController;
import hProjekt.controller.PlayerController;
import hProjekt.controller.PlayerObjective;
import hProjekt.controller.actions.AcceptCurse;
import hProjekt.controller.actions.AcceptTreasure;
import hProjekt.controller.actions.CollectAmulet;
import hProjekt.controller.actions.DrawTreasureCards;
import hProjekt.controller.actions.IllegalActionException;
import hProjekt.controller.actions.PlayerAction;
import hProjekt.mocking.ReflectionUtilsP;
import hProjekt.model.Player;
import hProjekt.model.cards.TreasureCard;

public class TestPlayerController extends PlayerController {
    private boolean acceptTreasure = false;
    private final GameController localGameController;
    private int treasureCardsToDraw = 0;

    public TestPlayerController(GameController gameController, Player player) {
        super(gameController, player);
        localGameController = gameController;
    }

    public TestPlayerController(GameController gameController, Player player, boolean acceptTreasure) {
        this(gameController, player);
        this.acceptTreasure = acceptTreasure;
    }

    @Override
    @DoNotMock
    public void setPlayerObjective(final PlayerObjective nextObjective) {
        ReflectionUtilsP.setFieldValue(this, "playerObjective", nextObjective);
    }

    @Override
    @DoNotMock
    public PlayerAction waitForNextAction(final PlayerObjective nextObjective) {
        setPlayerObjective(nextObjective);
        return waitForNextAction();
    }

    @Override
    @DoNotMock
    public PlayerAction waitForNextAction() {
        PlayerAction action = null;
        final Set<Class<? extends PlayerAction>> allowedActions = getPlayerObjective()
                .getAllowedActions();

        if (allowedActions.contains(AcceptCurse.class)) {
            action = new AcceptCurse();
        }
        if (allowedActions.contains(AcceptTreasure.class)) {
            action = new AcceptTreasure(acceptTreasure);
        }
        if (allowedActions.contains(CollectAmulet.class)) {
            action = new CollectAmulet();
        }
        if (allowedActions.contains(DrawTreasureCards.class)) {
            List<TreasureCard> drawnTreasureCards = new ArrayList<>();
            for (int i = 0; i < treasureCardsToDraw; i++) {
                drawnTreasureCards.add(localGameController.getState().drawTreasureCard());
            }
            ReflectionUtilsP.setFieldValue(this, "drawnTreasureCards",
                    drawnTreasureCards);
        }
        if (action != null) {
            try {
                action.execute(this);
            } catch (IllegalActionException e) {
                // We do not care
            }
        }
        return action;
    }

    @Override
    @DoNotMock
    public void setTreasureCardsToDraw(final int treasureCardsToDraw) {
        this.treasureCardsToDraw = treasureCardsToDraw;
        super.setTreasureCardsToDraw(treasureCardsToDraw);
    }

}
