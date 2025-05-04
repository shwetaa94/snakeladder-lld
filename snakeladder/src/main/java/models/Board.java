package models;

import java.util.*;

public class Board {
    private int size;
    private List<Cell> cells;
    private Map<Integer, Jump> jumps;

    public Board(int size, int snakes, int ladders){
        this.size = size;
        this.cells = new ArrayList<>();
        this.jumps = new HashMap<>();
        initializeCells();
        generateSnakeAndLadder(snakes, ladders);
    }
    private void initializeCells(){
        for(int i=0; i<size; i++){
            Cell cell = new Cell(i);
            cells.add(cell);
        }
    }
    private void generateSnakeAndLadder(int snakes, int ladders){
        Random random = new Random();
        while(snakes > 0){
            int start = random.nextInt(size -1)+1;
            int end = random.nextInt(start); //end always be < start
            if(!jumps.containsKey(start) && start!=end){
                Jump snake = new Jump(start,end);
                jumps.put(start,snake);
                cells.get(start).setJump(snake);
                snakes--;
            }
        }

        while(ladders > 0){
            int start = random.nextInt(size-1) + 1;
            int end = random.nextInt(size - start) + start + 1;

            if(!jumps.containsKey(start) && start != end && end <= size) {
                Jump ladder = new Jump(start, end);
                jumps.put(start, ladder);
                cells.get(start).setJump(ladder);
                ladders--;
            }
        }
    }
    public Cell getCell(int position) {
        if(position >=0 && position <= size) {
            return cells.get(position);
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
