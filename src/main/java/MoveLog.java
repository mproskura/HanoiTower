import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MoveLog {
    private final byte diskNumber;
    private final byte sourceTowerNumber;
    private final byte targetTowerNumber;
    private final List<Tower> towersBeforeMove;

    public MoveLog(Move move, List<Tower> towersBeforeMove) {
        this.diskNumber = move.getDiskMoved().get().getNumber();
        this.sourceTowerNumber = move.getSourceTower().getTowerNumber();
        this.targetTowerNumber = move.getTargetTower().getTowerNumber();
        this.towersBeforeMove = towersBeforeMove;
    }


}
