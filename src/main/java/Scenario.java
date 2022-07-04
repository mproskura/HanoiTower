import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Scenario {
    List<Tower> towers;
    List<MoveLog> moveList;
    Move nextMove;
    List<Integer> controlSums;


    public Scenario(List<Tower> towers) {
        this.towers = towers;
        this.moveList = new ArrayList<>();
        this.controlSums = new ArrayList<>();
    }

    public Scenario(Scenario oldScenario, Move nextMove) {
        this.moveList = cloneMoveLog(oldScenario.getMoveList());
        this.towers = Tower.cloneList(oldScenario.getTowers());
        this.nextMove = nextMove;
        moveList.add(new MoveLog(nextMove, towers));
        controlSums = new ArrayList<>(oldScenario.controlSums);
    }

    public boolean isPreviousStateRepeated() {
        Set validationSet = new HashSet(controlSums);
        if (validationSet.size() != controlSums.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void makeTheMove() {
        nextMove.makeTheMove();
        //update towers after move
        for (int i = 0; i < towers.size(); i++) {
            Tower tower = towers.get(i);
            if (tower.getTowerNumber() == nextMove.getSourceTower().getTowerNumber()) {
                towers.remove(i);
                towers.add(i, nextMove.getSourceTower());
            }
            if (tower.getTowerNumber() == nextMove.getTargetTower().getTowerNumber()) {
                towers.remove(i);
                towers.add(i, nextMove.getTargetTower());
            }
        }
        controlSums.add(ControlSum.getControlNumber(towers));
    }

    public int numberOfMoves() {
        return moveList.size();
    }

    public boolean isGameWon() {
        for (int i = 0; i < towers.size() - 1; i++) {
            if (!towers.get(i).isEmpty()) return false;
        }
        return true;
    }


    public void print() {
        for (int i = 0; i < moveList.size(); i++) {
            MoveLog currentMove = moveList.get(i);
            System.out.println();
            System.out.println("-------------------------------------------------------");
            System.out.println("Move " + (i + 1) + ": moving disk " + currentMove.getDiskNumber() +
                    " from tower " + currentMove.getSourceTowerNumber() + " to tower "
                    + currentMove.getTargetTowerNumber());
            System.out.println("Towers state: " + controlSums.get(i));
        }
        System.out.println("-------------------------------------------------------");
    }

    public static List<Move> cloneMoveList(List<Move> originalList) {
        List<Move> clonedList = new ArrayList<>();
        for (Move move : originalList) {
            clonedList.add(move);
        }
        return clonedList;
    }

    public static List<MoveLog> cloneMoveLog(List<MoveLog> originalLog) {
        List<MoveLog> clonedList = new ArrayList<>();
        for (MoveLog move : originalLog) {
            clonedList.add(move);
        }
        return clonedList;
    }

}
