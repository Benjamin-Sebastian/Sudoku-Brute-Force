package Sudoku;

public class Cell {
    private int val;

    private boolean isMutable;

    public Cell(int val, boolean isMutable) {
        this.val = val;
        this.isMutable = isMutable;
    }

    public Cell() {
        this(0, true);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public boolean isMutable() {
        return isMutable;
    }

}
