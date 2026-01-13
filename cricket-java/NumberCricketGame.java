import java.util.Random;
import java.util.Scanner;

public class NumberCricketGame {

    static final int TOTAL_BALLS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("============================================================");
        System.out.println("                 NUMBER CRICKET GAME");
        System.out.println("============================================================");

        System.out.println("Call your toss: (1) Heads  (2) Tails");
        int userToss = scanner.nextInt();
        int systemToss = random.nextInt(2) + 1;

        if (userToss == systemToss) {
            System.out.println("?? YOU WON THE TOSS!");
            System.out.println("Choose your play: 1. Batting  2. Bowling");
            int choice = scanner.nextInt();

            if (choice == 1) {
                int userScore = userBatting(scanner, random);
                systemBatting(scanner, random, userScore);
            } else {
                int systemScore = systemBatting(scanner, random, -1);
                userBatting(scanner, random, systemScore);
            }
        } else {
            System.out.println("? OPPONENT WON THE TOSS");
            int opponentChoice = random.nextInt(2) + 1;

            if (opponentChoice == 1) {
                System.out.println("Opponent chooses to BAT first");
                int systemScore = systemBatting(scanner, random, -1);
                userBatting(scanner, random, systemScore);
            } else {
                System.out.println("Opponent chooses to BOWL first");
                int userScore = userBatting(scanner, random);
                systemBatting(scanner, random, userScore);
            }
        }

        scanner.close();
    }

    // User Batting Logic
    static int userBatting(Scanner scanner, Random random) {
        int score = 0;
        int balls = TOTAL_BALLS;

        System.out.println("\n--- YOU ARE BATTING ---");

        while (balls > 0) {
            System.out.print("Enter your play (1–6): ");
            int userPlay = scanner.nextInt();
            int systemBall = random.nextInt(6) + 1;

            if (userPlay != systemBall) {
                score += userPlay;
                System.out.println("Runs scored: " + userPlay);
            } else {
                System.out.println("OUT!");
            }

            balls--;
            System.out.println("Balls remaining: " + balls);
        }

        System.out.println("Your Total Score: " + score);
        return score;
    }

    // System Batting Logic
    static int systemBatting(Scanner scanner, Random random, int target) {
        int score = 0;
        int balls = TOTAL_BALLS;

        System.out.println("\n--- YOU ARE BOWLING ---");

        while (balls > 0) {
            System.out.print("Enter your delivery (1–6): ");
            int userBall = scanner.nextInt();
            int systemPlay = random.nextInt(6) + 1;

            if (userBall != systemPlay) {
                score += systemPlay;
                System.out.println("Runs conceded: " + systemPlay);
            } else {
                System.out.println("WICKET!");
            }

            balls--;
            System.out.println("Balls remaining: " + balls);
        }

        System.out.println("Opponent Total Score: " + score);

        if (target != -1) {
            if (score > target) {
                System.out.println(" YOU LOST THE MATCH");
            } else {
                System.out.println(" YOU WON THE MATCH");
            }
        }

        return score;
    }
}
