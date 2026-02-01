    import java.util.Scanner;

public class Nim {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int roundNumber = 1;
        int numberOfSticks = 0;
        while (numberOfSticks <= 0){
        System.out.println("Let us play a game of Nim! How many sticks are we playing with today?");
        numberOfSticks = in.nextInt();
            if (numberOfSticks <= 0){
                System.out.println("We can't play a game with " + numberOfSticks + " sticks! Try again.");
            }
        }
        while (numberOfSticks > 0){ 
            boolean humansTurn = true;
            if (humansTurn){ //Human's turn
                System.out.println("Round " + roundNumber +". There's " + numberOfSticks + " stick(s) remaining.");
                System.out.println("You're up! How many sticks will you take: one, or two?");
                int sticksTakenByHuman = in.nextInt();
                if ((sticksTakenByHuman == 1 || sticksTakenByHuman == 2) && !(sticksTakenByHuman > numberOfSticks)){ //Legal move
                    numberOfSticks = numberOfSticks - sticksTakenByHuman;
                    System.out.println("You took " + sticksTakenByHuman + " stick(s).");
                    if (numberOfSticks == 0){
                    System.out.println("You took the last stick. You win!");
                } else{
                    roundNumber ++;
                    humansTurn = false;
                }
                }
                if (((sticksTakenByHuman != 1 && sticksTakenByHuman != 2) || ((sticksTakenByHuman == 2)) && (numberOfSticks == 1))){ //Illegal move
                    //This line is pretty messy, so I'll try to explain it. This code will trigger when:
                    //1. The human entered a number that is not 1 or 2 
                    //OR 
                    //2. if the human tried to take 2 sticks when only 1 stick remains
                    //1 is self explanitory. 2 is the only situation where a 'valid' number (2) results in an illegal move, so we need a specific edge case for it.
                    //Thus, this handles all illegal moves possible in Nim.
                    System.out.println("That number is invalid. Please try again.");
                } 
            if (!humansTurn){ //Computer's turn
                System.out.println("Round " + roundNumber +". There's " + numberOfSticks + " stick(s) remaining.");
                if (numberOfSticks == 1){ //This is not strategy. If there is only one stick remaining, there is only one valid move.
                    numberOfSticks--;
                    System.out.println("The computer takes 1 stick.");
                    System.out.println("The computer took the last stick. The computer wins!");
                }
                else {
                    double randomNumber = Math.random(); //(This is also not strategy)
                    if (randomNumber < 0.5){
                        numberOfSticks--;
                        roundNumber++;
                        System.out.println("The computer takes 1 stick."); //The computer cannot win if it must randomly select between 1 and 2 and picks 1.
                    }
                    else {
                        numberOfSticks-=2;
                        roundNumber++;
                        System.out.println("The computer takes 2 sticks.");
                        if (numberOfSticks == 0){
                            System.out.println("The computer took the last stick. The computer wins!");
                        }
                    }
                }
                }
            }
                
            }
        }

    }



