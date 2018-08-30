package tictactoegame;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenMarkSpaceOutsideOfAxisXThenRuntimeException() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        TicTacToeMark mark = new TicTacToeMark();
        exception.expect(RuntimeException.class);

        ticTacToeBoard.markSpace(mark, 5, 3);
    }

    @Test
    public void whenMarkSpaceOutsideOfAxisYThenRuntimeException() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        TicTacToeMark mark = new TicTacToeMark();
        exception.expect(RuntimeException.class);

        ticTacToeBoard.markSpace(mark, 1, 5);
    }

    @Test
    public void whenMarkMarkedSpaceThenRuntimeException() {
        TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
        TicTacToeMark mark = new TicTacToeMark();

        ticTacToeBoard.markSpace(mark, 1, 1);
        exception.expect(RuntimeException.class);
        ticTacToeBoard.markSpace(mark, 1, 1);
    }
}
