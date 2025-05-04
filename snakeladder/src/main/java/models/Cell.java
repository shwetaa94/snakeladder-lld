package models;


public class Cell {
    private int position;
    private Jump jump; // Snake or Ladder (if any)

    public Cell(int position) {
        this.position = position;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public Jump getJump() {
        return jump;
    }

    public int getPosition() {
        return position;
    }
}
