/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgameMain;
import java.io.IOException;
import java.util.*;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;

public class CardGame extends Application {
    

    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CardFXML.fxml"));
            Parent root = loader.load();
            
            // Set the fixed width and height of the Stage
            primaryStage.setWidth(666);
            primaryStage.setHeight(466);
            primaryStage.setResizable(false);
            primaryStage.setTitle("In Between");
            
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
        
    
    /*
    
    
    //text version of the game below
    //to run, remove extends Application
    
     HERE
    static Scanner scan = new Scanner(System.in);
    //try playing it in terminal
    public static void main(String[] args) {
       System.out.println("Welcome to the game of In Between. You will be given two cards "
               + "during each round, and guess whether the next card will fall between the pairs"
               + "you have in hand. ");
       
       int gamesPlayed = 0;
       int numOfScores = 0;
       
       boolean playAgain = true;
       
       do{
           int scoreThisGame;
           scoreThisGame = play();
           numOfScores += scoreThisGame;
           gamesPlayed++;
           System.out.println("Would you like to play again? Y / N");
           char inp = scan.next().charAt(0);
           
           if(inp != 'Y'){
               playAgain = false;
           }
           
        }while (playAgain);
        
        System.out.println("You played " + gamesPlayed + " games");
        if(numOfScores > 0){
            System.out.println("Congrats! You scored "+ numOfScores);
        } else{
            System.out.println("Too bad! You scored " + numOfScores);
        }
        
    }
    
    
    public static int play(){
        Deck gameDeck = new Deck();
        Card firstCard, secondCard;
        Card nextCard;
        
        int correctGuesses = 0;
        char guess;
        gameDeck.shuffleDeck();
        
        int high, low;
        
        
        while(true){
            //get cards from deck
            firstCard = gameDeck.dealCard();
            secondCard = gameDeck.dealCard();
            nextCard = gameDeck.dealCard();
            //get card values
            int firstValue = firstCard.getCardValue();
            int secondValue = secondCard.getCardValue();
            //check if both cards are equal. if so, deal new ones.
            while(firstValue == secondValue){
                firstCard = gameDeck.dealCard();
                secondCard = gameDeck.dealCard();
                firstValue = firstCard.getCardValue();
                secondValue = secondCard.getCardValue();  
            }
            //determine which is higher
            if(firstValue > secondValue){
                high = firstValue;
                low = secondValue;
            } else{
                high = secondValue;
                low = firstValue;
            }
            //Start game here
            System.out.println("The value of your cards are: " + high + " and " + low);
            System.out.println("Will the next card be in between? Y / N   ");
            char inp = scan.next().charAt(0);
            inp = Character.toUpperCase(inp);
            
            int nextCardValue = nextCard.getCardValue();
            if(inp == 'Y'){
                if(nextCardValue < high && nextCardValue > low){
                    System.out.println("The value of the next card was: " + nextCardValue);
                    System.out.println("Correct answer!");
                    correctGuesses++;
                }
                else{
                    System.out.println("Wrong guess. The card value is: " + nextCardValue);
                    break;
                }
            }
            else if(inp == 'N'){
                System.out.println("Alright. will exit round.");
                System.out.println("The value of the card was: " + nextCardValue);
                break;
            }
            else{
                System.out.println("Invalid choice. Will exit round");
                break;
            }

        }
        System.out.println("Your total score for this round was: " + correctGuesses);
        return correctGuesses; 
    }
    */
}