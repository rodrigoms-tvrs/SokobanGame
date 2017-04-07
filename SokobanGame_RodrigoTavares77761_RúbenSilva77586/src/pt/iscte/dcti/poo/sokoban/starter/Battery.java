package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Battery extends AbstractSObject {

	public Battery(Position position) {
		super(position, 1, "Bateria");
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
