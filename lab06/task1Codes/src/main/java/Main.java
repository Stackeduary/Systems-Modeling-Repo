import spark.Request;

import static spark.Spark.*;

public class Main {
    static Game game;
    static int play;

    public static String createGame(String p1, String p2){
        game = Game.getInstance(p1, p2);
        game.printGameStatus();
        return "Game created - " + p1 + " v. " + p2;
    }

    public static String playGame(String play){
        game.playPocket(Integer.parseInt(play));
        game.printGameStatus();
        return "Played";
    }

    public static String getTurnOf(){
        return String.valueOf(game.getTurnOf());
    }

    public static String printGameStatus(){
        return game.printGameStatus();
    }

    public static String createLandOnEmpty (){
        Pocket[] p = new Pocket[14];
        p[1] = new Pocket(1);
        p[2] = new Pocket(0);
        p[3] = new Pocket(3);
        p[4] = new Pocket(0);
        p[5] = new Pocket(0);
        p[6] = new Pocket(1);
        p[8] = new Pocket(4);
        p[9] = new Pocket(1);
        p[10] = new Pocket(5);
        p[11] = new Pocket(1);
        p[12] = new Pocket(6);
        p[13] = new Pocket(1);
        game.setPockets(p);
        game.printGameStatus();
        return "Scenario for last pebble landing in empty pocket created";
    }

    public static String getPlayerStoreCount (String player){
        return String.valueOf(game.getPlayers()[Integer.parseInt(player)].getStoreCount());
    }

    public static String createEmptyOneSideScenario(){
        Pocket[] p = new Pocket[14];
        p[1] = new Pocket(0);
        p[2] = new Pocket(0);
        p[3] = new Pocket(0);
        p[4] = new Pocket(0);
        p[5] = new Pocket(0);
        p[6] = new Pocket(1);
        p[8] = new Pocket(4);
        p[9] = new Pocket(1);
        p[10] = new Pocket(5);
        p[11] = new Pocket(1);
        p[12] = new Pocket(6);
        p[13] = new Pocket(1);
        game.setPockets(p);
        game.printGameStatus();
        return "Scenario for one side empty created";
    }

    public static void main(String[] args) {
        get("/newGame", (req, res) -> createGame(req.queryMap().get("p1").value(), req.queryMap().get("p2").value()));
        get("/getTurnOf", (req, res) -> getTurnOf());
        get("/play", (req, res) -> playGame(req.queryMap().get("play").value()));
        get("/printGameStatus", (req, res) -> printGameStatus());
        get("/getStoreCount", (req, res) -> getPlayerStoreCount(req.queryMap().get("player").value()));
        get("/landOnEmpty", (req, res) -> {
            createGame(req.queryMap().get("p1").value(), req.queryMap().get("p2").value());
            return createLandOnEmpty();
        }); get("/emptyOnOneSide", (req, res) -> {
            createGame(req.queryMap().get("p1").value(), req.queryMap().get("p2").value());
            return createEmptyOneSideScenario();
        });
    }
}