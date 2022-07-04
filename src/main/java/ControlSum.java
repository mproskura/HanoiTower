import java.util.List;

public class ControlSum {

    public static int getControlNumber(List<Tower> towerList) {
        int controlNumber = 0;
        for (Tower tower : towerList) {
            double towerMultiplier = Math.pow(10, tower.getTowerNumber());
            for (Disk disk : tower.getDiskStack()) {
                controlNumber += (disk.getNumber() + 1) * towerMultiplier;
            }
        }
        return controlNumber;
    }
}
