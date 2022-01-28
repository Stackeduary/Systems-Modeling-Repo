public class Game {
    public static final int POCKET_SIZE = 14; //
    private int turnOf;
    private Player[] players;
    private static Game game;
    private Pocket[] pockets;



    private Game(String p1Name, String p2Name){
        this.turnOf = 0;
        this.players = new Player[2];
        this.players[0] = new Player(p1Name);
        this.players[1] = new Player(p2Name);
        this.pockets = new Pocket[POCKET_SIZE];
        for (int i =0; i < POCKET_SIZE; i++)
            pockets[i] = new Pocket();
    }

    public void setTurnOf(int turnOf) {
        this.turnOf = turnOf;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPockets(Pocket[] pockets) {
        this.pockets = pockets;
    }

    public int getTurnOf() {
        return turnOf;
    }

    //Get the only object available
    public static Game getInstance(String p1Name, String p2Name){
        if (game != null)
            return game;
        return new Game(p1Name, p2Name);
    }

    public int getOppositeOf(int index){
        return POCKET_SIZE - index;
    }

    public boolean isGameOver(){
        int sum=0;
        for (Pocket pocket : pockets) {
            sum += pocket.getStones();
        }
        return sum == 0;
    }

    public boolean checkIfPlayersSide(int index){
        if (index < 7 && turnOf == 0)
            return true;
        return false;
    }

    public void moveAllToStore(int index){
        Player p = players[turnOf];
        p.setStoreCount( p.getStoreCount() + pockets[index].getStones() );
        pockets[index].setStones(0);
    }

    public void turnRound(){
        if (turnOf == 0)
            turnOf = 1;
        else
            turnOf = 0;
    }



    public void playPocket(int choice){
        int pocketInd;

        if (turnOf == 0)
            pocketInd = choice;
        else
            pocketInd = POCKET_SIZE - choice;


        Pocket p = this.pockets[pocketInd];
        int timesToRun = p.getStones();
        if (timesToRun == 0)
            System.out.println("Choose a non-empty pocket");
        else{
            p.setStones(0);
            int startIndex = (pocketInd + 1) % POCKET_SIZE;
            int indexCounter = 0;

            for(int i = 0; i < timesToRun; i++){
                indexCounter = (i + startIndex) % POCKET_SIZE;
                //Check if store
                if(indexCounter == 7 && turnOf == 0)
                    players[turnOf].addStone();
                else if(indexCounter == 0 && turnOf == 1)
                    players[turnOf].addStone();
                else
                    pockets[indexCounter].addStone();
            }

            //Check opposite
            if(checkIfPlayersSide(indexCounter) && pockets[indexCounter].getStones() == 1){
                moveAllToStore(indexCounter);
                moveAllToStore(getOppositeOf(indexCounter));
            }

            //Check if one side empty
            int sum = 0;
            for (int i = 1; i < 7; i++)
                sum +=pockets[i].getStones();
            if (sum == 0){
                for (int i = 8; i < 13; i++){
                    sum +=pockets[i].getStones();
                    pockets[i].setStones(0);
                }
                players[turnOf].setStoreCount( players[turnOf].getStoreCount() + sum );
            }
            else{
                sum = 0;
                for (int i = 8; i < 13; i++)
                    sum +=pockets[i].getStones();
                if (sum == 0){
                    for (int i = 1; i < 7; i++){
                        sum +=pockets[i].getStones();
                        pockets[i].setStones(0);
                    }
                    players[turnOf].setStoreCount( players[turnOf].getStoreCount() + sum );
                }
            }
            if(indexCounter == 7 && turnOf == 0)
                System.out.println("Play again");
            else if (indexCounter == 0 && turnOf == 1)
                System.out.println("Play again");
            else
                turnRound();
        }


    }

    public String printGameStatus(){
        String res = "";
        res += pockets[13].getStones() + "|" + pockets[12].getStones() + "|" + pockets[11].getStones() + "|" + pockets[10].getStones() + "|" + pockets[9].getStones() + "|" + pockets[8].getStones() + "\n";
        res += pockets[1].getStones() + "|" + pockets[2].getStones() + "|" + pockets[3].getStones() + "|" + pockets[4].getStones() + "|" + pockets[5].getStones() + "|" + pockets[6].getStones() + "\n";
        res += "Round of Player " + (turnOf + 1) + "\n";
        res += players[0].getName()+": " + players[0].getStoreCount() + " --- " + players[1].getName()+": " + players[1].getStoreCount() + "\n\n";
        return res;
    }



}
