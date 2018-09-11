package tictactoegame;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

    private TicTacToeBoard ticTacToeBoard;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void initTest() {
        ticTacToeBoard = new TicTacToeBoard();
    }

    @Test
    public void whenMarkSpaceOutsideOfAxisXThenRuntimeException() {
        exception.expect(RuntimeException.class);

        ticTacToeBoard.play(ticTacToeBoard.nextPlayer(), 5, 3);
    }

    @Test
    public void whenMarkSpaceOutsideOfAxisYThenRuntimeException() {
        exception.expect(RuntimeException.class);

        ticTacToeBoard.play(ticTacToeBoard.nextPlayer(), 1, 5);
    }

    @Test
    public void whenMarkMarkedSpaceThenRuntimeException() {
        ticTacToeBoard.play(ticTacToeBoard.nextPlayer(), 1, 1);
        exception.expect(RuntimeException.class);
        ticTacToeBoard.play(ticTacToeBoard.nextPlayer(), 1, 1);
    }

    @Test
    public void playerXShouldStartTheGame() {
        assertEquals(Player.X, ticTacToeBoard.nextPlayer());
    }

    @Test
    public void whenInPreviousTurnPlayerXMarkedSpaceThenPlayerOShouldPlay() {
        ticTacToeBoard.play(Player.X, 1, 1);
        assertEquals(Player.O, ticTacToeBoard.nextPlayer());
    }

    @Test
    public void whenInPreviousTurnPlayerOMarkedSpaceThenPlayerXShouldPlay() {
        ticTacToeBoard.play(Player.X, 1, 1);
        ticTacToeBoard.play(Player.O, 2, 2);

        assertEquals(Player.X, ticTacToeBoard.nextPlayer());
    }

    @Test
    public void whenPlayerXPlacedTheirMarksInOneRowThenHeWin() {
        ticTacToeBoard.play(Player.X, 1, 1);
        ticTacToeBoard.play(Player.O, 1, 2);
        ticTacToeBoard.play(Player.X, 2, 1);
        ticTacToeBoard.play(Player.O, 2, 2);

        boolean gameOver = ticTacToeBoard.play(Player.X, 3, 1);
        Player winner = ticTacToeBoard.winner();

        assertTrue(gameOver);
        assertEquals(winner, Player.X);
    }

    @Test
    public void whenPlayerOPlacedTheirMarksInOneColThenHeWin() {
        ticTacToeBoard.play(Player.X, 1, 1);
        ticTacToeBoard.play(Player.O, 2, 1);
        ticTacToeBoard.play(Player.X, 3, 2);
        ticTacToeBoard.play(Player.O, 2, 2);
        ticTacToeBoard.play(Player.X, 3, 3);

        boolean gameOver = ticTacToeBoard.play(Player.O, 2, 3);
        Player winner = ticTacToeBoard.winner();

        assertTrue(gameOver);
        assertEquals(winner, Player.O);
    }

    @Test
    public void whenPlayerXPlacedTheirMarksDiagonalThenHeWin() {
        ticTacToeBoard.play(Player.X, 1, 1);
        ticTacToeBoard.play(Player.O, 1, 2);
        ticTacToeBoard.play(Player.X, 2, 2);
        ticTacToeBoard.play(Player.O, 3, 2);

        boolean gameOver = ticTacToeBoard.play(Player.X, 3, 3);
        Player winner = ticTacToeBoard.winner();

        assertTrue(gameOver);
        assertEquals(winner, Player.X);
    }

    @Test
    public void whenThereIsNoWinnerGameIsNotOver() {
        ticTacToeBoard.play(Player.X, 2, 2);
        ticTacToeBoard.play(Player.O, 3, 2);

        boolean gameOver = ticTacToeBoard.play(Player.X, 3, 3);
        Player winner = ticTacToeBoard.winner();

        assertFalse(gameOver);
        assertNull(winner);
    }
}
