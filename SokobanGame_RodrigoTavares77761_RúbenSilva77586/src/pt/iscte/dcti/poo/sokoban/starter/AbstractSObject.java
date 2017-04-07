package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Position;

public abstract class AbstractSObject implements ImageTile {

	protected Position position;
	protected int level;
	protected String imageName;

	public AbstractSObject(Position position, int level, String imageName) {

		this.position = position;
		this.level = level;
		this.imageName = imageName;
	}

	// GETTERS
	public Position getPosition() {
		return position;
	}

	public int getLevel() {
		return level;
	}

	public String getImageName() {
		return imageName;
	}

	
	// THIS METHOD RETURNS TRUE IF THE USER CAN MOVE TOWARDS THE OBJECT
	public boolean isTransposable() {
		return true;
	}

}
