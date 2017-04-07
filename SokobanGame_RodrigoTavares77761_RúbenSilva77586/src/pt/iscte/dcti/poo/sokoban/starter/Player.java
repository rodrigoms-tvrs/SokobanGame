package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Position;

public class Player extends AbstractSObject implements ActiveObject {

	public SokobanGame sokobanGame; //NOT SURE IF IT IS PUBLIC OR PRIVATE
	
	public Player(Position initialPosition, SokobanGame sokobanGame) {
		super(initialPosition, 1, "Empilhadora_U");
		this.sokobanGame = sokobanGame;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public void move(Direction nextDirection) { // In development

		Position newPosition = position.plus(nextDirection.asVector());
		
		// The player can only move forward if
		if (newPosition.getX() >= 0 && newPosition.getX() < 10 && newPosition.getY() >= 0 && newPosition.getY() < 10
				&& ( sokobanGame.getAbstractSObject(newPosition).isTransposable() ) ) {
			position = newPosition;
			
		}else{ //IF THE OBJECT IS NOT TRANSPOSABLE
			
			// IF THE OBJECT IS A BOX
			if( sokobanGame.getAbstractSObject(newPosition).getName() == "Caixote" ){
				
				Box box = (Box) sokobanGame.getAbstractSObject(newPosition);
				
				if(box.canMoveTo(nextDirection)){
					box.move(nextDirection);
					position = newPosition;
				}
					
			}
				
		}

		ImageMatrixGUI.getInstance().update();
	}

}
