import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiskTest {

    @org.junit.jupiter.api.Test
    void canGoOnTop() {
        Disk disk1= new Disk((byte)1);
        Disk disk3 = new Disk((byte)3);
        assertFalse(disk3.canGoOnTop(disk1));
        assertTrue(disk1.canGoOnTop(disk3));
    }
}