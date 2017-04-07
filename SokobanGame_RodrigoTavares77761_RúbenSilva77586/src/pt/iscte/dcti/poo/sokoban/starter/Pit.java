package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Pit extends AbstractSObject {

	public Pit(Position position) {
		super(position, 1, "Buraco");
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

}
