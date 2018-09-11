package tictactoegame;

public enum Player {

    X(Mark.X), O(Mark.O);

    private final Mark mark;

    Player(Mark mark) {
        this.mark = mark;
    }

    public Mark mark() {
        return mark;
    }
}
