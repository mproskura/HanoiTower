import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Scenario {
    List<Tower> towers;
    List<Move> moveList;
    Move nextMove;

    public Scenario(List<Tower> towers) {
        this.towers = towers;
        this.moveList = new ArrayList<>();
    }

    public Scenario(Scenario oldScenario, Move nextMove) {
        this.moveList = cloneMoveList(oldScenario.getMoveList());
        this.towers = Tower.cloneList(oldScenario.getTowers());
        this.nextMove = nextMove;
        moveList.add(nextMove);
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
            Move currentMove = moveList.get(i);
            System.out.println();
            System.out.println("-------------------------------------------------------");
            System.out.println("Move " + (i + 1) + ": moving disk " + currentMove.getDiskMoved().get().getNumber() +
                    " from tower " + currentMove.getSourceTower().getTowerNumber() + " to tower "
                    + currentMove.getTargetTower().getTowerNumber());
            currentMove.getSourceTower().print();
            currentMove.getTargetTower().print();
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

}
