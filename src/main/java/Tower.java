import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.SQLOutput;
import java.util.*;

@Data
public class Tower {
    private final byte towerNumber;
    private Stack<Disk> diskStack;

    public Tower(byte towerNumber) {
        this.towerNumber = towerNumber;
        diskStack = new Stack<>();
    }

    public void putDisk(Disk disk) {
        diskStack.push(disk);
    }

    public Disk popDisk() throws EmptyStackException {
        return diskStack.pop();
    }

    public boolean isEmpty() {
        return diskStack.empty();
    }

    public Optional<Disk> getTopDisk() {
        if (!diskStack.empty()) {
            return Optional.of(diskStack.peek());
        } else {
            return Optional.empty();
        }
    }

    public boolean equals(Tower diskStack) {
        if (this.towerNumber == diskStack.getTowerNumber()) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumberOfDisks() {
        return diskStack.size();
    }

    public void print() {
        System.out.println("Content of tower " + towerNumber + ": ");
        for (Disk disk : diskStack) {
            System.out.println(disk.getNumber());
        }
    }

    public Tower clone() {
        Tower towerClone = new Tower(this.getTowerNumber());
        if (!this.diskStack.isEmpty()) {
            for (Disk disk : this.getDiskStack()) {
                towerClone.diskStack.push(disk);
            }
        }
        return towerClone;
    }

    public static List<Tower> cloneList(List<Tower> originalList) {
        List<Tower> clonedList = new ArrayList<>();
        for (Tower tower : originalList) {
            clonedList.add(tower.clone());
        }
        return clonedList;
    }
}
