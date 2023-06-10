/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgameMain;
import java.util.*;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;

public class CardGame extends Application {
    
    //to practice drawing cards from cardsImg
    //need ko i code para maintindihan lmao
    static private Canvas canvas;
    static private Image cardImages;
    
    public static void main(String[] args){
        launch();
    }
    
    public void start(Stage thisStage){
        cardImages = new Image(getClass().getResource("cards.jpg").toExternalForm());
        
        canvas = new Canvas(5*79 + 120, 123 + 40); 
        //every card img is 79 by 123 pixels, 
        //so retrieve a card from row x in column x, the format would be (79*r, 123*c)
        //120 and 40 are just additional padding right and bottom of canvas so 
        //di sila siksikan
        
        Button redraw = new Button("Deal Again");
        redraw.setOnAction( e -> draw());
        
        StackPane bottom = new StackPane(redraw);
        bottom.setStyle("-fx-background-color: gray; -fx-padding: 5px; "
                + " -fx-border-color:blue; -fx-border-width: 2px 0 0 0");
        
        //yung root borderpane mismong window. BorderPane has 4 placeholders, left right top tds
        //tsaka bottom. yung canvas kasi plain lang na box yan, yung stackpane
        //din ata? basta yung stackpane used specifically for buttons ata, tas yung yung
        //l;alagay sa bottom nung border pane nga
        BorderPane root = new BorderPane(canvas);
        root.setBottom(bottom);
        root.setStyle("-fx-border-color: blue; -fx-border-width: 2px; -fx-background-color: lightblue");
        
        thisStage.setScene(new Scene(root, Color.BLACK));
        thisStage.setTitle("Practice random cards");
        thisStage.setResizable(false);
        thisStage.show();
        
        
    }
    
    private void draw(){
        
        GraphicsContext g = canvas.getGraphicsContext2D();
        
        Deck thisDeck = new Deck();
        thisDeck.shuffleDeck();
        
        
        double sx,sy; // top left corener dun sa picture mismo
        double dx,dy; //top left corener naman sa canvas
        
        
        for(int i = 0; i < 3;i++){
            Card card = thisDeck.dealCard();
            System.out.println(card);
            sx = 79 * (card.getCardValue() - 1);
            sy = 123 * (3 - card.getSuit());
            dx = 20 + (79 + 20) * i; //79 pixel yung width tas may 20 pixel gap sila, bali add mo lang yung 20 fropm
            //dulong dulo ng picture, tas add ka ulo ng 20 para dun sa gap per cards
            dy = 20;
            g.drawImage(cardImages, sx,sy,79,123,dx,dy,79,123);
        }
    }
    
    
    //text version of the game below
    //to run, remove extends Application
    
    /* HERE
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
