import java.util.ArrayList;

public class Player {
    String name;
    int storeCount;
    public Player(String name) {
        this.name = name;

        this.storeCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getStoreCount() {
        return this.storeCount;
    }

    public void setStoreCount(int storeCount) {
        this.storeCount = storeCount;
    }

    public void addStone(){
        this.storeCount = this.storeCount + 1;
    }
}
