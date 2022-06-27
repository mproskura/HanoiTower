import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoveLog {
    private final int diskNumber;
    private final int sourceTowerNumber;
    private final int targetTowerNumber;

    public MoveLog(Move move) {
        this.diskNumber = move.getDiskMoved().get().getNumber();
        this.sourceTowerNumber = move.getSourceTower().getTowerNumber();
        this.targetTowerNumber = move.getTargetTower().getTowerNumber();
    }
}
