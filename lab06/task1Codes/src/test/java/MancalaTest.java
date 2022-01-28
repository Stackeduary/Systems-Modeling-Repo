import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class MancalaTest {

    private static String sendGET(String path) throws IOException {
        URL obj = new URL("http://localhost:4567" + path);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine + "\n");
            }
            in.close();

            // print result
            return response.toString().substring(0, response.toString().length() - 1);
        } else {
            return "GET request not worked";
        }
    }

    public void createGame(String p1, String p2) throws IOException {
        sendGET("/newGame?p1="+p1+"&p2="+p2);
    }

    public void createLandOnEmpty() throws IOException {
        sendGET("/landOnEmpty");
    }
    public void createEmptyOneSideScenario() throws IOException {
        sendGET("/emptyOnOneSide");
    }

    public void play(String play) throws IOException {
        sendGET("/play?play="+play);
    }

    public String getTurnOf() throws IOException {
        return sendGET("/getTurnOf");
    }

    public String playerCount(int player) throws IOException {
        return sendGET("/getStoreCount?player=" + player);
    }

    public String gameStatus() throws IOException {
        return sendGET("/printGameStatus");
    }

    @Test
    public void playAgainAfterLandingInStore() throws IOException {
        //Initialize game
        createGame("Sarp", "Bill");
        //P1's turn
        System.out.println("Initial state");
        System.out.println(gameStatus());
        Assert.assertEquals("0", getTurnOf());
        play("4");
        //Still P1's turn
        System.out.println(gameStatus());
        Assert.assertEquals("0", getTurnOf());
    }

    @Test
    public void stealAfterLandingOnEmptyOnYourSide() throws IOException {
        //Initialize game
        createGame("Sarp", "Bill");
        //Create scenario
        createLandOnEmpty();
        //P1's turn
        System.out.println("Before");
        System.out.println(gameStatus());
        Assert.assertEquals("0", playerCount(0));
        play("1");
        Assert.assertEquals("7", playerCount(0));
        System.out.println("After");
        System.out.println(gameStatus());
    }

    public static int randMilli(int from, int to){
        return Integer.parseInt(String.valueOf(Math.round(Math.random() * (to - from) + from))) * 1000;
    }

    @Test
    public void twoRoundsOfPlay() throws IOException, InterruptedException {
        //Initialize game
        createGame("Sarp", "Bill");
        System.out.println(gameStatus());
        Assert.assertEquals("0", getTurnOf());
        Thread threadP1;
        Thread threadP2;


        threadP1 = new Thread(){
            public void run(){
                try {
                    Thread.sleep(randMilli(3,5));
                    play("1");
                    System.out.println(gameStatus());
                    Assert.assertEquals("1", getTurnOf());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };

        threadP2 = new Thread(){
            public void run(){
                try {
                    while (getTurnOf().equalsIgnoreCase("0")){
                        Thread.sleep(1000);
                        System.out.println(getTurnOf());
                    }
                    play("2");
                    System.out.println(gameStatus());
                    Assert.assertEquals("0", getTurnOf());
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        };

        threadP1.start();
        threadP1.join();
        threadP2.start();
        threadP2.join();

    }
}