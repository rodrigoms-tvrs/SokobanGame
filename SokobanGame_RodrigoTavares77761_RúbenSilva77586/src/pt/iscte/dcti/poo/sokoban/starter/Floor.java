package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Floor extends AbstractSObject {

	public Floor(Position position) {
		super(position, 0, "Chao");
	}

	// GETTERS
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public String getName() {
		return imageName;
	}

}
