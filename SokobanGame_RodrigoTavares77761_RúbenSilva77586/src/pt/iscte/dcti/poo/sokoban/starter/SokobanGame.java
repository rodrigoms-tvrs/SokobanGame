package pt.iscte.dcti.poo.sokoban.starter;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.MapConstructor;
import pt.iul.ista.poo.utils.Position;

public class SokobanGame implements Observer {

	public Player player;

	private LinkedList<AbstractSObject> objectList;

	public SokobanGame() {

		// Create an ImageTile list
		LinkedList<ImageTile> tiles = new LinkedList<ImageTile>();

		objectList = MapConstructor.buildMap(this);
		tiles.addAll(objectList);

		tiles.add(player);

		ImageMatrixGUI.getInstance().addImages(tiles);

	}

	public AbstractSObject getAbstractSObject(Position position) {
		AbstractSObject abstractSObject = null;;
		for (int i = 0; i != objectList.size(); i++) {
			if (objectList.get(i).getPosition().equals(position))
				abstractSObject = objectList.get(i);
			else if (objectList.get(i).getPosition().equals(position) && objectList.get(i).getLevel() == 1)
				abstractSObject = objectList.get(i);
		}
		return abstractSObject;
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		int lastKeyPressed = (Integer) arg1;
		System.out.println("Key pressed " + lastKeyPressed);
		if (player != null) {
			player.move(Direction.directionFor(lastKeyPressed));
			switch (Direction.directionFor(lastKeyPressed)) {
			case DOWN:
				player.imageName = "Empilhadora_D";
				break;
			case UP:
				player.imageName = "Empilhadora_U";
				break;
			case LEFT:
				player.imageName = "Empilhadora_L";
				break;
			case RIGHT:
				player.imageName = "Empilhadora_R";
				break;
			}

		} else {
			throw new IllegalStateException();
		}
	}
}
