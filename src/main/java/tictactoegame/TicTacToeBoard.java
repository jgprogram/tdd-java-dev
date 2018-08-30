package tictactoegame;

public class TicTacToeBoard {

    private final TicTacToeMark[][] marks;

    public TicTacToeBoard() {
        marks = new TicTacToeMark[2][2];
    }

    public void markSpace(TicTacToeMark mark, int x, int y) {
        checkAxisX(x);
        checkAxisY(y);

        insertMark(mark, x, y);
    }

    private void insertMark(TicTacToeMark mark, int x, int y) {
        if (marks[x - 1][y - 1] != null) {
            throw new RuntimeException(String.format("Space %s x %s is occupied.", x, y));
        }

        marks[x - 1][y - 1] = mark;
    }

    private void checkAxisY(int y) {
        if (y < 1 || marks[0].length < y) {
            throw new RuntimeException("Mark is out of Y axis");
        }
    }

    private void checkAxisX(int x) {
        if (x < 1 || marks[0].length < x) {
            throw new RuntimeException("Mark is out of X axis");
        }
    }
}
