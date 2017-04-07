package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Position;

public class Box extends AbstractSObject implements ActiveObject {

	public SokobanGame sokobanGame; // NOT SURE IF IT IS PUBLIC OR PRIVATE

	public Box(Position position, SokobanGame sokobanGame) {
		super(position, 1, "Caixote");
		this.sokobanGame = sokobanGame;
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

	public boolean canBoxMove(Direction nextDirection) {
		Position newPosition = position.plus(nextDirection.asVector());
		if (newPosition.getX() >= 0 && newPosition.getX() < 10 && newPosition.getY() >= 0 && newPosition.getY() < 10
				&& (sokobanGame.getAbstractSObject(newPosition).isTransposable()))
			return true;
		return false;
	}

	public boolean canMoveTo(Direction nextDirection) {

		Position newPosition = position.plus(nextDirection.asVector());
		AbstractSObject obj = sokobanGame.getAbstractSObject(newPosition);

		if (newPosition.getX() >= 0 && newPosition.getX() < 10 && newPosition.getY() >= 0 && newPosition.getY() < 10
				&& (obj.isTransposable()))
			return true;
		return false;

	}

	@Override
	public void move(Direction nextDirection) {

		Position newPosition = position.plus(nextDirection.asVector());
		position = newPosition;

		ImageMatrixGUI.getInstance().update();

	}

}
