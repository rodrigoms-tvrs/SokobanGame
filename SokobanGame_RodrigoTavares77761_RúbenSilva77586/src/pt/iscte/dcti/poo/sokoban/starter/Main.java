package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
public class Main {

	public static void main(String[] args) {
		SokobanGame s = new SokobanGame();
		ImageMatrixGUI.getInstance().addObserver(s);
		ImageMatrixGUI.getInstance().go();
	}

}
