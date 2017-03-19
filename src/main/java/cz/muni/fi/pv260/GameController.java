package cz.muni.fi.pv260;
import cz.muni.fi.pv260.Player.Direction;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Marek on 19.3.2017.
 */
public class GameController {

    private ArrayList<Player> players;

    public GameController() {
        PlayerKeys player1Keys = new PlayerKeys(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT);
        PlayerKeys player2Keys = new PlayerKeys(KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A);

        Player player1 = new Player((new Position(40, 40)), Direction.DIRECTION_RIGHT, player1Keys);
        Player player2 = new Player((new Position(600, 440)), Direction.DIRECTION_LEFT, player2Keys);
        players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Boolean isInValidState() {
        return !isCollisionFoundBetweenPlayers();
    }

    private Boolean isCollisionFoundBetweenPlayers() {
        for (Player player : players) {
            for (Player otherPlayer : players) {
                if (isCollisionFoundInPaths(player, otherPlayer)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isCollisionFoundInPaths(Player player, Player otherPlayer) {
        Position playerCurrentPosition = player.getPosition();
            for (Position otherPosition : otherPlayer.getPath()) {
                if (playerCurrentPosition.equals(otherPosition)) {
                    return true;
                }
            }

        return false;
    }

    public Player findPlayerByKeyAction(int keyCode){
        for(Player player: players){
            if(player.getKeys().isPlayerKey(keyCode)){
                return player;
            }
        }
        return null;
    }
}
