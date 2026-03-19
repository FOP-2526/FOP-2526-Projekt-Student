package hProjekt;

import java.util.function.BiFunction;

import javafx.util.Pair;

public class TerminateFunction implements BiFunction<Pair<Integer, Integer>, Integer, Boolean> {
    boolean returnTrue = false;
    boolean returnFalse = false;
    int distance = 999999;
    int buildingBudget = 9999999;
    int parallelBudget = 9999999;

    public TerminateFunction(boolean returnTrue, boolean returnFalse, int distance, int buildingBudget,
            int parallelBudget) {
        this.returnTrue = returnTrue;
        this.returnFalse = returnFalse;
        this.distance = distance;
        this.buildingBudget = buildingBudget;
        this.parallelBudget = parallelBudget;
    }

    @Override
    public Boolean apply(Pair<Integer, Integer> arg0, Integer arg1) {
        if (returnTrue) {
            return true;
        }
        if (returnFalse) {
            return false;
        }
        if (arg0.getKey() > buildingBudget) {
            return true;
        }
        if (arg0.getValue() > parallelBudget) {
            return true;
        }
        if (arg1 > distance) {
            return true;
        }
        return false;
    }

}
