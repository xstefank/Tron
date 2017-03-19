package cz.muni.fi.pv260;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import cz.muni.fi.pv260.Player;
import cz.muni.fi.pv260.Position;
import cz.muni.fi.pv260.Player.Direction;


public class yourclass extends Core implements KeyListener, MouseListener,
		MouseMotionListener {

	GameController gameController;
	PlayerController playerController;

	public void init() {
		super.init();

		Window w = sm.getFullScreenWindow();
		w.addKeyListener(this);
		w.addMouseListener(this);
		w.addMouseMotionListener(this);

		gameController = new GameController();
		playerController = new PlayerController(w);
	}

	public static void main(String[] args) {
		new yourclass().run();
	}

	public void draw(Graphics2D g) {

		for(Player player: gameController.getPlayers()){
			PlayerController.move(player);
		}

		if(!gameController.isInValidState()){
			System.exit(0);
		}

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());


		for(Player player: gameController.getPlayers()){
			for(Position position: player.getPath()){
			g.setColor(Color.green);
			g.fillRect(position.getCoordinateX(), position.getCoordinateY(), 10, 10);
		}}
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		Player player = gameController.findPlayerByKeyAction(keyCode);
		if(player != null){
			playerController.changeDirection(player, keyCode);
		}
	}
//		if (e.getKeyCode() == KeyEvent.VK_UP) {
//			if (currentDirection1 != 2){
//			currentDirection1 = 0;
//			}
//		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			if (currentDirection1 != 0){
//				currentDirection1 = 2;
//				}
//		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			if (currentDirection1 != 3){
//				currentDirection1 = 1;
//				}
//		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			if (currentDirection1 != 1){
//				currentDirection1 = 3;
//				}
//		}
//		if (e.getKeyCode() == KeyEvent.VK_W){
//			if (currentDirection2 != 2){
//			currentDirection2 = 0;
//			}
//		} else if (e.getKeyCode() == KeyEvent.VK_S) {
//			if (currentDirection2 != 0){
//				currentDirection2 = 2;
//				}
//		} else if (e.getKeyCode() == KeyEvent.VK_D) {
//			if (currentDirection2 != 3){
//				currentDirection2 = 1;
//				}
//		} else if (e.getKeyCode() == KeyEvent.VK_A) {
//			if (currentDirection2 != 1){
//				currentDirection2 = 3;
//				}
//		}
//	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {

	}
}
