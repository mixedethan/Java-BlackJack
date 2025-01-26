import java.sql.SQLOutput;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


// TODO: Add visual cards that displays as you draw them.
// TODO: Clean up code and make it even more efficient
// TODO: Add cleaner transition between games
// TODO: Make visual cards display side by side rather than up and down


public class Blackjack {

    public static void main(String[] args){
        P1Random rng = new P1Random();
        Scanner scnr = new Scanner(System.in);

        int userWins = 0;
        int dealerWins = 0;
        int tieGames = 0;

        // The rank of the card (e.g., "A", "2", "10", "K")
        // The suit of the card (e.g., "♠", "♥", "♣", "♦").

        for (int numGames = 1; numGames < 10; numGames += 1) {
            System.out.println("Welcome to Ethan's Poker Hall!\n");
            System.out.println("START GAME #" + numGames);//Begins the game and adds one once numGame is set to 101. THIS IS THE ENTIRE GAME.
            System.out.println();

            List<String> playerHand = new ArrayList<>();
            int gameOver = 0;
            int dealerHand = 0;
            int userHand = 0;

            while(gameOver == 0) { //Decides if game is over.
                int cardValue = rng.nextInt(13) + 1; // 1 to 13
                int suitValue = rng.nextInt(4) + 1; // 1 to 4

                String newCard = CardArt.getCardArt(Card.getCard(cardValue), Card.getSuit(suitValue));

                playerHand.add(newCard);

                userHand += cardValue;


                System.out.println("Your hand:");
                for (String card : playerHand) {
                    System.out.print(card);
                }

                System.out.println();

                    while (gameOver == 0) { //This is the menu.
                        System.out.println("1. Hit me");
                        System.out.println("2. Stand");
                        System.out.println("3. Print statistics");
                        System.out.println("4. Exit");
                        System.out.print("Choose an option: ");
                        int userChoice = scnr.nextInt();

                        // If the user hits
                        if (userChoice == 1) {
                            cardValue = rng.nextInt(13) + 1; // 1 to 13
                            suitValue = rng.nextInt(4) + 1; // 1 to 4

                            newCard = CardArt.getCardArt(Card.getCard(cardValue), Card.getSuit(suitValue));
                            playerHand.add(newCard);
                            userHand += cardValue;

                            System.out.println("Your hand:");
                            for (String card : playerHand) {
                                System.out.print(card);
                            }
                        }
                        // If the user stands
                        else if (userChoice == 2) {
                            dealerHand = rng.nextInt(11)+16;
                            System.out.println("Dealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + userHand);
                            System.out.println();
                            if (userHand > dealerHand){
                                if (userHand <=21){
                                    System.out.println("You win!");
                                    userHand = 0;
                                    dealerHand = 0;
                                    gameOver = 1;
                                    dealerWins += 1;
                                    System.out.println();
                                }
                                else {
                                    System.out.println("Dealer wins!");
                                    userHand = 0;
                                    dealerHand = 0;
                                    gameOver = 1;
                                    userWins += 1;
                                    System.out.println();
                                }
                            }

                            else if (dealerHand > userHand){
                                if (dealerHand <=21){
                                    System.out.println("Dealer wins!");
                                    userHand = 0;
                                    dealerHand = 0;
                                    gameOver = 1;
                                    dealerWins += 1;
                                    System.out.println();
                                }
                                else {
                                    System.out.println("You win!");
                                    userHand = 0;
                                    dealerHand = 0;
                                    gameOver = 1;
                                    userWins += 1;
                                    System.out.println();
                                }
                            }

                            // System.out.println("Would you like to continue? ");


                        }

                        // if the user asks for stats
                        else if (userChoice == 3) {
                            System.out.println("Number of Player wins: " + userWins);
                            System.out.println("Number of Dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + tieGames);
                            System.out.println("Total # of games played is: " + (numGames - 1));
                            System.out.println("Percentage of Player wins: " + (((double)userWins / ((double)numGames - 1) * 100) + "%"));
                        }
                        // if the user exits
                        else if (userChoice == 4) {
                            gameOver = 1;
                            numGames =10;
                            break;
                        }

                        else {
                            System.out.println("Invalid input!");
                            System.out.print("Please enter an integer value between 1 and 4.");

                        }
                        if(userHand == 21){
                            System.out.println("BLACKJACK! You win!");
                            userHand = 0;
                            dealerHand = 0;
                            gameOver = 1;
                            userWins += 1;
                            System.out.println();
                        }


                        else if (dealerHand == 21){
                            System.out.println("Dealer wins!");
                            userHand = 0;
                            dealerHand = 0;
                            gameOver = 1;
                            dealerWins += 1;
                            System.out.println();
                        }
                        else if (dealerHand == userHand){
                            System.out.println("It's a tie! No one wins!");
                            userHand = 0;
                            dealerHand = 0;
                            gameOver = 1;
                            tieGames += 1;
                            System.out.println();
                        }
                        else if (dealerHand > 21){
                            System.out.println("You win!");
                            userHand = 0;
                            dealerHand = 0;
                            gameOver = 1;
                            userWins += 1;
                            System.out.println();
                        }
                        else if (userHand > 21){
                            System.out.println("You exceeded 21! You lose.");
                            userHand = 0;
                            dealerHand = 0;
                            gameOver = 1;
                            dealerWins += 1;
                            System.out.println();
                        }
                        else {
                            System.out.println();
                        }

                    }

                }
            }
        }
    }


