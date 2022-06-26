import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Disk {
    private final byte number;

    public boolean canGoOnTop(Disk disk){
        if (this.number < disk.number){
            return true;
        } else {
            return false;
        }
    }
}
