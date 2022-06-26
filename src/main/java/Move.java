import lombok.Data;
import lombok.ToString;

import java.util.Optional;

@Data
@ToString
public class Move {
    private Optional<Disk> diskMoved;
    private Tower sourceTower;
    private Tower targetTower;

    public Move(Tower sourceTower, Tower targetTower) {
        this.sourceTower = sourceTower.clone();
        this.targetTower = targetTower.clone();
        diskMoved = sourceTower.getTopDisk();
    }

    public boolean isMoveLegal() {
        if (diskMoved.isEmpty()) return false;
        if (targetTower.isEmpty()) return true;
        if (diskMoved.get().getNumber() > targetTower.getTopDisk().get().getNumber()) return false;
        return true;
    }

    public boolean reversesPreviousMove(Move previousMove) {
        if (previousMove.sourceTower.equals(targetTower) && previousMove.targetTower.equals(sourceTower)) {
            return true;
        } else {
            return false;
        }
    }

    public void makeTheMove() {
        targetTower.putDisk(sourceTower.popDisk());
    }

    public void print() {
        System.out.println("Moving disk " + diskMoved.get().getNumber() + " from tower " + sourceTower.getTowerNumber()
                + " to tower " + targetTower.getTowerNumber());
    }
}
