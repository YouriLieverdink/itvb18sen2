package nl.hanze.hive.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.hanze.hive.Hive.Player;
import nl.hanze.hive.Hive.Tile;
import nl.hanze.hive.models.Board;
import nl.hanze.hive.models.Position;
import nl.hanze.hive.models.Stone;

public class SoldierAntSpec {
	@Test
	void givenBoardAndFromPositionAndToPositionWhenAllowedThenTrue() {
		Board b1 = new Board();

		// Initialise the board.
		b1.add(new Position(0, 1), new Stone(Player.WHITE, Tile.SOLDIER_ANT));
		b1.add(new Position(0, 0), new Stone(Player.WHITE, Tile.QUEEN_BEE));
		b1.add(new Position(0, -1), new Stone(Player.BLACK, Tile.SOLDIER_ANT));
		b1.add(new Position(0, -2), new Stone(Player.BLACK, Tile.QUEEN_BEE));

		SoldierAnt rules = new SoldierAnt();

		assertTrue(rules.isAllowedToMove(b1, new Position(0, 1), new Position(0, -3)));
	}

	@Test
	void givenBoardAndFromPositionAndToPositionWhenNotAllowedThenFalse() {
		Board b1 = new Board();

		// Initialise the board.
		b1.add(new Position(0, 1), new Stone(Player.WHITE, Tile.SOLDIER_ANT));
		b1.add(new Position(0, 0), new Stone(Player.WHITE, Tile.QUEEN_BEE));
		b1.add(new Position(0, -1), new Stone(Player.BLACK, Tile.SOLDIER_ANT));
		b1.add(new Position(0, -2), new Stone(Player.BLACK, Tile.QUEEN_BEE));

		SoldierAnt rules = new SoldierAnt();

		assertFalse(rules.isAllowedToMove(b1, new Position(0, 1), new Position(0, 2)));
	}
}
