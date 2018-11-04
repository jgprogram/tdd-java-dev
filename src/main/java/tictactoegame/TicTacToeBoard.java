package tictactoegame;

public class TicTacToeBoard {

    private static final int BOARD_SIZE = 3;

    private final Mark[][] marks;
    private Player nextPlayer = Player.X;
    private Player winner;
    private boolean gameOver = false;

    public TicTacToeBoard() {
        marks = new Mark[BOARD_SIZE][BOARD_SIZE];
    }

    public Player nextPlayer() {
        return nextPlayer;
    }

    public Player winner() {
        return winner;
    }

    public boolean play(Player player, int x, int y) {
        if (!player.equals(nextPlayer)) {
            throw new RuntimeException("Next player should be " + nextPlayer.toString());
        }

        markSpace(player.mark(), x, y);
        nextPlayer = player.equals(Player.O) ? Player.X : Player.O;

        if (isWinningFigureOnBoard()) {
            winner = player;
            gameOver = true;
        } else if (isDraw()) {
            winner = null;
            gameOver = true;
        }

        return gameOver;
    }

    private boolean isWinningFigureOnBoard() {
        return isWinningFigureInColumn()
                || isWinningFigureInRow()
                || isWinningFigureInDiagonalRow1()
                || isWinningFigureInDiagonalRow2();
    }

    private boolean isDraw() {
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (marks[i][j] == null) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isWinningFigureInDiagonalRow1() {
        Mark firstMark = marks[0][0];
        if (firstMark != null
                && firstMark == marks[1][1]
                && firstMark == marks[2][2]) {
            return true;
        }
        return false;
    }

    private boolean isWinningFigureInDiagonalRow2() {
        Mark firstMark = marks[2][0];
        if (firstMark != null
                && firstMark == marks[1][1]
                && firstMark == marks[0][2]) {
            return true;
        }
        return false;
    }

    private boolean isWinningFigureInRow() {
        for (int v = 0; v < BOARD_SIZE; v++) {
            Mark firstMark = marks[0][v];
            if (firstMark != null
                    && firstMark == marks[1][v]
                    && firstMark == marks[2][v]) {
                return true;
            }
        }
        return false;
    }

    private boolean isWinningFigureInColumn() {
        for (int h = 0; h < BOARD_SIZE; h++) {
            Mark firstMark = marks[h][0];
            if (firstMark != null
                    && firstMark == marks[h][1]
                    && firstMark == marks[h][2]) {
                return true;
            }
        }
        return false;
    }

    private void markSpace(Mark mark, int x, int y) {
        checkAxisX(x);
        checkAxisY(y);

        insertMark(mark, x, y);
    }

    private void insertMark(Mark mark, int x, int y) {
        if (marks[x - 1][y - 1] != null) {
            throw new RuntimeException(String.format("Space %s x %s is occupied.", x, y));
        }

        marks[x - 1][y - 1] = mark;
    }

    private void checkAxisY(int y) {
        if (y < 1 || BOARD_SIZE < y) {
            throw new RuntimeException("Mark is out of Y axis");
        }
    }

    private void checkAxisX(int x) {
        if (x < 1 || BOARD_SIZE < x) {
            throw new RuntimeException("Mark is out of X axis");
        }
    }
}
