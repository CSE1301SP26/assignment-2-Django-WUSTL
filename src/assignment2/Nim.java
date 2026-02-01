    import java.util.Scanner;

public class Nim {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int roundNumber = 1;
        System.out.println("Let us play a game of Nim! How many sticks are we playing with today?");
        int numberOfSticks = in.nextInt();
        if (numberOfSticks <= 0){
            System.out.println("That simply won't do. Please run this program again.");
        } else while (numberOfSticks > 0){ 
            boolean humansTurn = true;
            if (humansTurn){ //Human's turn
                System.out.println("Round " + roundNumber +". There are " + numberOfSticks + " stick(s) remaining.");
                System.out.println("You're up! How many sticks will you take: one, or two?");
                int sticksTakenByHuman = in.nextInt();
                if (sticksTakenByHuman == 1 || sticksTakenByHuman == 2){
                    numberOfSticks = numberOfSticks - sticksTakenByHuman;
                    System.out.println("You took " + sticksTakenByHuman + " stick(s).");
                    if (numberOfSticks == 0){
                    System.out.println("You took the last stick. You win!");
                } else{
                    roundNumber ++;
                    humansTurn = false;
                }
                }
                while ((sticksTakenByHuman != 1 && sticksTakenByHuman != 2) || ((sticksTakenByHuman > numberOfSticks)) && (numberOfSticks != 0)){
                    System.out.println("That number is invalid. Please try again.");
                    sticksTakenByHuman = 1; //This is required so the program does not get stuck into an infinite loop.
                    //If I try to take 4 sticks, and this code gets tripped, I would never get a chance to reinput a number unless this gets cleared.
                } 
            if (!humansTurn){ //Computer's turn
                System.out.println("Round " + roundNumber +". There are " + numberOfSticks + " stick(s) remaining.");
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
                        System.out.println("The computer takes 1 stick.");
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



