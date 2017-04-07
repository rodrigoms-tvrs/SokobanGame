package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Wall extends AbstractSObject {

	public Wall(Position position) {
		super(position, 1, "Parede");
	}

	// GETTERS
	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public int getLevel() {
		return 1;
	}
	
	@Override
	public String getName() {
		return imageName;
	}

	@Override
	public boolean isTransposable() {
		return false;
	}

}
