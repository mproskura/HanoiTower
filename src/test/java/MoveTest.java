import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void makeTheMove() {
        Tower sourceTower = new Tower(1);
        Tower targetTower = new Tower(2);
        Disk testDisk = new Disk(1);
        sourceTower.putDisk(testDisk);

        Move move = new Move(sourceTower,targetTower);
        move.makeTheMove();

        assertEquals(testDisk.getNumber(), move.getTargetTower().getTopDisk().get().getNumber());
        assertTrue(move.getSourceTower().isEmpty());
    }

    @Test
    void makeTheMove2() {
        Tower sourceTower = new Tower(1);
        Tower targetTower = new Tower(2);
        Disk testDisk1 = new Disk(1);
        Disk testDisk2 = new Disk(2);
        Disk testDisk3 = new Disk(3);
        sourceTower.putDisk(testDisk1);
        sourceTower.putDisk(testDisk2);
        sourceTower.putDisk(testDisk3);

        Move move = new Move(sourceTower,targetTower);
        move.makeTheMove();

        assertEquals(testDisk3, move.getTargetTower().getTopDisk().get());
        assertEquals(testDisk2, move.getSourceTower().getTopDisk().get());
    }
}