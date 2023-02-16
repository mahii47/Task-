import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int playerScore = 0;
        int computerScore = 0;
        int highestScore = 0;


        while (true) {
            System.out.println("Rock, paper, scissors or Quit ? \n Enter your choice:");
            String playerChoice = input.next().toLowerCase();
            if (playerChoice.equals("quit")) {
                System.out.println("Final scores:");
                System.out.println("Player: " + playerScore);
                System.out.println("Computer: " + computerScore);
                System.out.println("Highest score: " + highestScore);
                break;
            }
            String computerChoice = generateComputerChoice();
            System.out.println("Computer chose " + computerChoice);
            String result = getWinner(playerChoice, computerChoice);
            if (result.equals("player")) {
                System.out.println("You win!");
                playerScore++;
            } else if (result.equals("computer")) {
                System.out.println("Computer wins!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }
            if (playerScore > highestScore) {
                highestScore = playerScore;
                System.out.println("New highest score: " + highestScore);
            }
            if (computerScore > highestScore) {
                highestScore = computerScore;
                System.out.println("New highest score: " + highestScore);
            }
        }
    }


    public static String generateComputerChoice() {
        int choice = (int) (Math.random() * 3);
        if (choice == 0) {
            return "rock";
        } else if (choice == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }


    public static String getWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "tie";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors"))
                || (playerChoice.equals("paper") && computerChoice.equals("rock"))
                || (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "player";
        } else {
            return "computer";
        }
    }
}
