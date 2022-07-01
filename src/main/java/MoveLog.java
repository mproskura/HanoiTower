import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class MoveLog {
    private final byte diskNumber;
    private final byte sourceTowerNumber;
    private final byte targetTowerNumber;

    public MoveLog(Move move) {
        this.diskNumber = move.getDiskMoved().get().getNumber();
        this.sourceTowerNumber = move.getSourceTower().getTowerNumber();
        this.targetTowerNumber = move.getTargetTower().getTowerNumber();
    }


}
