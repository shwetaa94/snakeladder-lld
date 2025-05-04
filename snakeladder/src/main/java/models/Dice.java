package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Dice {
    private int diceCount;
    private Random random;

    public Dice(int diceCount){
        this.diceCount = diceCount;
        this.random = new Random();
        roll();
    }
    public int roll(){
        int total =0;
        for(int i=0; i<diceCount; i++){
            total += random.nextInt(6) + 1;
        }
        return total;
    }

    public int getDiceCount() {
        return diceCount;
    }
}
