import java.util.ArrayList;
import java.util.List;

public class ScenarioAnalysis {
    Scenario scenario;

    public ScenarioAnalysis(Scenario scenario) {
        this.scenario = scenario;
    }

    public List<Scenario> analyze() {
        List<Scenario> newScenarios = new ArrayList<>();
        List<Move> legalAndNonRevertingMoves = getLegalAndNonRevertingMoves(getPossibleMoves());
        for (Move move : legalAndNonRevertingMoves) {
            Scenario scenario = new Scenario(this.scenario, move);
            scenario.makeTheMove();
            newScenarios.add(scenario);
        }
        return newScenarios;
    }

    private List<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for (Tower sourceTower : scenario.getTowers()) {
            if (!sourceTower.isEmpty()) {
                for (Tower targetTower : scenario.getTowers()) {
                    if (sourceTower.getTowerNumber()!= targetTower.getTowerNumber()) {
                        possibleMoves.add(new Move(sourceTower, targetTower));
                    }
                }
            }
        }
        return possibleMoves;
    }

    private List<Move> getLegalAndNonRevertingMoves(List<Move> possibleMoves) {
        List<MoveLog> moveList = scenario.getMoveList();
        List<Move> result = new ArrayList<>();
        for (Move move : possibleMoves) {
            if (moveList.size() == 0) {
                if (move.isMoveLegal()) {
                    result.add(move);
                }
            } else {
                MoveLog lastMove = moveList.get(moveList.size() - 1
                );
                if (move.isMoveLegal() && !move.reversesPreviousMove(lastMove)) {
                    result.add(move);
                }
            }
        }
        return result;
    }

    public void print() {
        System.out.println("Scenario towers before move: ");
        for (Tower tower : scenario.getTowers()) {
            tower.print();
        }
    }
}