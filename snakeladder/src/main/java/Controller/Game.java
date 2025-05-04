package Controller;

import models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Queue<Player> players;
    private Player winner;
    private Board board;
    private Dice dice;

    public Game(int boardSize, int snakes, int ladders, int numberOfdice){
        this.board = new Board(boardSize, snakes, ladders);
        this.dice = new Dice(numberOfdice);
        this.players = new LinkedList<>();
        this.winner = null;
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    public void startGame(){
        while(winner == null){
            Player currentPlayer = players.poll();
            System.out.println(currentPlayer.getName() + "'s turn");

            int diceValue = dice.roll();
            System.out.println("Dice rolled: " + diceValue);

            int newPosition = currentPlayer.getPosition() + diceValue;

            if(newPosition > board.getSize()) {
                System.out.println("Invalid move. Try again next turn.");
                players.add(currentPlayer);
                continue;
            }

            if(newPosition == board.getSize()) {
                winner = currentPlayer;
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }
            Cell cell = board.getCell(newPosition);
            if(cell.getJump() != null) {
                Jump jump = cell.getJump();
                newPosition = jump.getEnd();

                if(jump.getStart() > jump.getEnd()) {
                    System.out.println("Oops! Snake bite. Go down to " + newPosition);
                } else {
                    System.out.println("Yay! Ladder climb. Go up to " + newPosition);
                }
            }

            currentPlayer.setPosition(newPosition);
            System.out.println(currentPlayer.getName() + " moved to " + newPosition);
            players.add(currentPlayer);

        }
    }
}
