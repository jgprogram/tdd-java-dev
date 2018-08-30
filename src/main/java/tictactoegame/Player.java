package tictactoegame;

public enum Player {

    X(TicTacToeMark.x()), O(TicTacToeMark.o());

    private final TicTacToeMark mark;

    Player(TicTacToeMark mark) {
        this.mark = mark;
    }

    public TicTacToeMark mark() {
        return mark;
    }
}
