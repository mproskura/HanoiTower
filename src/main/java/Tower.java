import lombok.Data;
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
        if (this.isEmpty() && diskStack.isEmpty()) return true;
        if (this.getNumberOfDisks() != diskStack.getNumberOfDisks()) return false;
        Stack<Disk> comparedStack = diskStack.diskStack;
        for (int i = 0; i < getTowerNumber(); i++) {
            if (this.diskStack.peek().getNumber() != comparedStack.peek().getNumber()) return false;
        }
        return true;
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

    public static List<List<Tower>> cloneListOfLists(List<List<Tower>> originalListOfLists){
        List<List<Tower>> clonedListOfLists = new ArrayList<>();
        for (List<Tower> list : originalListOfLists){
            clonedListOfLists.add(cloneList(list));
        }
        return clonedListOfLists;
    }

    public static List<Tower> cloneList(List<Tower> originalList) {
        List<Tower> clonedList = new ArrayList<>();
        for (Tower tower : originalList) {
            clonedList.add(tower.clone());
        }
        return clonedList;
    }
}
