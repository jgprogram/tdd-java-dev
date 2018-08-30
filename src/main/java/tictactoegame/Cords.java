package tictactoegame;

import java.util.Objects;

public class Cords {
    private final Integer x;
    private final Integer y;

    public Cords(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cords cords = (Cords) o;
        return Objects.equals(x, cords.x) &&
                Objects.equals(y, cords.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
