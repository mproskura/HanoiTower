import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {
    Tower tower1;
    Tower tower2;
    Disk disk1;
    Disk disk2;
    Disk disk3;

    @BeforeEach
    void createTowers() {
        tower1 = new Tower((byte) 1);
        tower2 = new Tower((byte) 2);

        disk1 = new Disk((byte) 1);
        disk2 = new Disk((byte) 2);
        disk3 = new Disk((byte) 3);
    }

    @Test
    void testEqualsExpectedTrue() {
        tower1.putDisk(disk1);
        tower1.putDisk(disk2);
        tower1.putDisk(disk3);

        tower2.putDisk(disk1);
        tower2.putDisk(disk2);
        tower2.putDisk(disk3);

        assertTrue(tower1.equals(tower2));
    }

    @Test
    void testEqualsDifferentNumberOfDisks() {
        tower1.putDisk(disk1);
        tower1.putDisk(disk2);
        tower1.putDisk(disk3);

        tower2.putDisk(disk1);
        tower2.putDisk(disk2);

        assertFalse(tower1.equals(tower2));
    }

    @Test
    void testEqualsDifferentDisksNumbersOnStack() {
        tower1.putDisk(disk1);
        tower1.putDisk(disk3);

        tower2.putDisk(disk1);
        tower2.putDisk(disk2);

        assertFalse(tower1.equals(tower2));
    }
}