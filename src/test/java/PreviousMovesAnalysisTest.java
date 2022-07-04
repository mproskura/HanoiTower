import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PreviousMovesAnalysisTest {
    static Disk disk1 = new Disk((byte) 1);
    static Disk disk2 = new Disk((byte) 2);
    static Disk disk3 = new Disk((byte) 3);
    static Disk disk4 = new Disk((byte) 4);
    static Disk disk5 = new Disk((byte) 5);

    static Tower tower1A = new Tower((byte) 1);
    static Tower tower1B = new Tower((byte) 1);
    static Tower tower2A = new Tower((byte) 2);
    static Tower tower2B = new Tower((byte) 2);
    static Tower tower1C = new Tower((byte) 1);
    static Tower tower2C = new Tower((byte) 2);

    static List<Tower> towerList1 = new ArrayList<>();
    static List<Tower> towerList2 = new ArrayList<>();
    static List<Tower> towerList3 = new ArrayList<>();

    static List<List<Tower>> towerStates1 = new ArrayList<>();
    static List<List<Tower>> towerStates2 = new ArrayList<>();
    static List<List<Tower>> towerStates3 = new ArrayList<>();

    @BeforeAll
    static void objectsSetup() {
        tower1A.putDisk(disk5);
        tower1A.putDisk(disk4);
        tower1A.putDisk(disk3);
        towerList1.add(tower1A);
        tower2A.putDisk(disk2);
        tower2A.putDisk(disk1);
        towerList1.add(tower2A);

        tower1B.putDisk(disk5);
        tower1B.putDisk(disk4);
        towerList2.add(tower1B);
        tower2B.putDisk(disk3);
        tower2B.putDisk(disk2);
        tower2B.putDisk(disk1);
        towerList2.add(tower2B);

        tower1C.putDisk(disk5);
        tower1C.putDisk(disk4);
        towerList3.add(tower1C);
        tower2C.putDisk(disk4);
        tower2C.putDisk(disk3);
        tower2C.putDisk(disk2);
        tower2C.putDisk(disk1);
        towerList3.add(tower2C);


        towerStates1.addAll(List.of(towerList1, towerList2));
        towerStates2.addAll(List.of(towerList1,towerList2,towerList1));
        towerStates3.addAll(List.of(towerList1,towerList2,towerList3));
    }


    @Test
    void isPreviousStackStateRepeatedHappyPath() {
        assertFalse(PreviousMovesAnalysis.isPreviousStackStateRepeated(towerStates1));
    }

    @Test
    void isPreviousStackStateRepeatedAnotherHappyPath() {
        assertFalse(PreviousMovesAnalysis.isPreviousStackStateRepeated(towerStates3));
    }

    @Test
    void isPreviousStackStateRepeatedNonHappyPath() {
        assertTrue(PreviousMovesAnalysis.isPreviousStackStateRepeated(towerStates2));
    }
}