import java.util.List;

public class PreviousMovesAnalysis {

    public static boolean isPreviousStackStateRepeated(List<List<Tower>> towerStates) {

        if (towerStates.size() == 0) return false;
        List<Tower> lastTowerState = towerStates.get(towerStates.size() - 1);
        for (int i = 0; i < towerStates.size() - 1; i++) {
            List<Tower> previousTowerState = towerStates.get(i);
            if (compareTowerStates(lastTowerState, previousTowerState)) {
                return true;
            }
        }
        return false;
    }

    private static boolean compareTowerStates(List<Tower> towerList1, List<Tower> towerList2) {
        for (Tower tower1 : towerList1) {
            Tower tower2;
            for (Tower tower : towerList2) {
                if (tower.getTowerNumber() == tower1.getTowerNumber()) {
                    tower2 = tower;
                    if (!tower1.equals(tower2)) return false;
                }
            }
        }
        return true;
    }
}