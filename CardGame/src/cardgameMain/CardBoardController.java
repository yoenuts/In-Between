/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cardgameMain;

import static cardgameMain.CardGame.scan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author le bratte
 */
public class CardBoardController implements Initializable {

    @FXML
    private Button inBetween;
    @FXML
    private Button forfeit;
    @FXML
    private Button exit;
    @FXML
    private TextField message;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        play();
    }    

    @FXML
    private void inBetweenB(ActionEvent event) {
    }

    @FXML
    private void forfeitB(ActionEvent event) {
    }

    @FXML
    private void exitB(ActionEvent event) {
    }

    @FXML
    private void messageTF(ActionEvent event) {
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
        } 
    }

    /*//determine which is higher
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
    */
}
