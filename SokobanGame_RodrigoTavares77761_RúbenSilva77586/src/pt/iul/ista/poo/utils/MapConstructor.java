package pt.iul.ista.poo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import pt.iscte.dcti.poo.sokoban.starter.AbstractSObject;
import pt.iscte.dcti.poo.sokoban.starter.Battery;
import pt.iscte.dcti.poo.sokoban.starter.Box;
import pt.iscte.dcti.poo.sokoban.starter.Floor;
import pt.iscte.dcti.poo.sokoban.starter.Pit;
import pt.iscte.dcti.poo.sokoban.starter.Player;
import pt.iscte.dcti.poo.sokoban.starter.SokobanGame;
import pt.iscte.dcti.poo.sokoban.starter.Target;
import pt.iscte.dcti.poo.sokoban.starter.Wall;

public class MapConstructor {

	public static String level = "levels/level0.txt";

	// Scanner level and build map
	public static LinkedList<AbstractSObject> buildMap(SokobanGame sokobanGame) {

		LinkedList<AbstractSObject> mapObjectList = new LinkedList<AbstractSObject>();

		// Build layer_0 (10x10 floor tiles)
		for (int y = 0; y != 10; y++)
			for (int x = 0; x != 10; x++)
				mapObjectList.add(new Floor(new Position(x, y)));

		// Scan and build layer_1
		try (Scanner scan = new Scanner(new File(level))) {

			int y = 0;
			while (scan.hasNextLine() && y != 10) {

				String line = scan.nextLine();

				for (int x = 0; x != 10; x++) {
					if (line.charAt(x) == 'E') {
						sokobanGame.player = new Player(new Position(x, y), sokobanGame);
					}
					if (line.charAt(x) == '#') {
						mapObjectList.add(new Wall(new Position(x, y)));
					}
					if (line.charAt(x) == 'C') {
						mapObjectList.add(new Box(new Position(x, y),sokobanGame));
					}
					if (line.charAt(x) == 'X') {
						mapObjectList.add(new Target(new Position(x, y)));
					}
					if (line.charAt(x) == 'O') {
						mapObjectList.add(new Pit(new Position(x, y)));
					}
					if (line.charAt(x) == 'b') {
						mapObjectList.add(new Battery(new Position(x, y)));
					}
				}
				y++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return mapObjectList;

	}

}
