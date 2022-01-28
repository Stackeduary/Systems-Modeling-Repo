public class Pocket {
    int stones;

    public Pocket() {
        this.stones = 3;
    }

    public Pocket(int stones) {
        this.stones = stones;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public void addStone() {
        this.stones = this.stones + 1;
    }
}
