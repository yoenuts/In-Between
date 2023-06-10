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
/**
 * FXML Controller class
 *
 * @author le bratte
 */
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
        
        inBetween.setOnAction( e -> play());
        newGame.setOnAction(e -> doNewGame());
        
        
        doNewGame();
    }
    
    private void play(){
        if(!gameInProgress){
            message = "Select \"New Game\" to start";
            drawBoard();
            return;
        }
        
        hand.addCard(deck.dealCard());
        int cardCt = hand.getCardCount();
        Card firstCard = hand.getCard( cardCt - 1);
        Card secondCard = hand.getCard( - 2);
        Card deckCard = hand.getCard(cardCt - 3);
        
        
        
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
    
    private void doNewGame(){
        if(gameInProgress){
            message = "Finish the game : )";
            drawBoard();
            return;
        }
        
        deck = new Deck();
        hand = new Hand();
        deck.shuffleDeck();
        hand.addCard(deck.dealCard());
        message = "Will the next card be in between?";
        gameInProgress = true;
        drawBoard();
        
    }
    
    /*
    @FXML
    private void inBeweenB(ActionEvent event) {
    }

    @FXML
    private void SkipB(ActionEvent event) {
    }

    @FXML
    private void newGameB(ActionEvent event) {
    }
    */
    
}
