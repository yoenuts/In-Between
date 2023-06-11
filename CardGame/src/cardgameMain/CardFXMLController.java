/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cardgameMain;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;

public class CardFXMLController implements Initializable {

    @FXML
    private BorderPane deckTable;
    @FXML
    private Canvas deckCanvas;
    
    ////////////////////
    
    private static boolean gameInProgress = false;
    private static String message;
    private static Hand hand;
    private static Deck deck;
    private static Image cardImages;
    private static Card firstCard;
    private static Card secondCard;
    private static Card deckCard;
    private static int winCounter = 0;
    private static int cardCt = 0;
    
    /////////////////////
    @FXML
    private HBox ButtonBar;
    @FXML
    private Button inBetween;
    @FXML
    private Button skip;
    @FXML
    private Button newGame;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cardImages = new Image(getClass().getResource("cards.jpg").toExternalForm());
        doNewGame(); //set up for first game
        inBetween.setOnAction( e -> play());
        newGame.setOnAction(e -> doNewGame());
        skip.setOnAction(e -> skipTurn());
        
    }
    
    private void play(){
        if(!gameInProgress){
            message = "Oops. This round is over. Select \"New Game\" to start.";
            drawBoard();
            return;
        }
        
        gameInProgress = false;
        //this one, galing na sa deck
        hand.addCard(deck.dealCard());
        cardCt = hand.getCardCount();
        System.out.println(cardCt);
        
        //get cards in hand
        deckCard = hand.getCard(cardCt - 1);
        secondCard = hand.getCard(cardCt - 2);
        firstCard = hand.getCard(cardCt - 3);
        drawBoard();
        
        gameInProgress = true;
        System.out.println("Play Method: " + deckCard);
        
        if((deckCard.getCardValue() < firstCard.getCardValue() && deckCard.getCardValue() > secondCard.getCardValue()) || 
            (deckCard.getCardValue() > firstCard.getCardValue() && deckCard.getCardValue() < secondCard.getCardValue())){
            winCounter++;
            message = (String.format("Your guess was correct! Your current points: %d", winCounter));
            JOptionPane.showMessageDialog(null, message);
               
        } else{
            message = "Guess was incorrect. Select \"New Game\" to start." ;
            winCounter = 0;
            JOptionPane.showMessageDialog(null, message);
        }
        
        if(winCounter == 3){
            message = "Congrats, you won!";
            gameInProgress = false;
            JOptionPane.showMessageDialog(null, message);
            winCounter = 0;
            //doNewGame();
        }
        
        
    }
    
    private void drawCard(GraphicsContext g, Card card, int x, int y){
        int cRow, cCol;
        if(card == null){
            //coordinates of the face down card in cards.jpg
            cRow = 4;
            cCol = 2;
        }
        else{
            cRow = 3 - card.getSuit();
            cCol = card.getCardValue() - 1;
        }
        double sx,sy;
        sx = 79 * cCol;
        sy = 123 * cRow;
        g.drawImage(cardImages, sx, sy, 79,123, x, y,79,123);
    }
    
    private void drawBoard(){
        GraphicsContext g = deckCanvas.getGraphicsContext2D();
        g.setFill(Color.DARKGREEN);
        g.fillRect(0, 0, deckCanvas.getWidth(), deckCanvas.getHeight());
        g.setFill(Color.rgb(220, 255, 220));
        g.fillText(message, 20, 180);
        int cardCt = hand.getCardCount();
        for(int i = 0; i < cardCt; i++){
            drawCard(g, hand.getCard(i), 20 + i * 99, 20); //whats 99
        }
        
        
        if(gameInProgress){
            drawCard(g,null, 20 + cardCt * 99, 20);
        }
        
        
    }
    
    private void skipTurn(){
        gameInProgress = false;
        doNewGame();
    }
    
    private void doNewGame(){
        if(gameInProgress){
            message = "Finish the game : )";
            drawBoard();
            return;
        }
        
        deck = new Deck();
        hand = new Hand();
        deck.shuffleDeck();
        hand.addCard(deck.dealCard(), deck.dealCard());

        cardCt = hand.getCardCount();
        System.out.println("new game method: " + cardCt);
        Card secondCard = hand.getCard(cardCt - 1);
        Card firstCard = hand.getCard(cardCt - 2);
        
        // in case both cards are equal to each other, remove the ones in hand, draw a new card from 
        //deck na din
        while(firstCard.getCardValue() == secondCard.getCardValue()){
            doNewGame();
        }
        
        
        message = "Will the next card be in between?";
        gameInProgress = true;
        drawBoard();
        
    }
    

    @FXML
    private void inBeweenB(ActionEvent event) {
    }

    @FXML
    private void SkipB(ActionEvent event) {
    }

    @FXML
    private void newGameB(ActionEvent event) {
    }
    
}
