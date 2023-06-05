/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cardgameMain;
import java.util.*;

public class CardGame {
    Scanner scan = new Scanner(System.in);
    //try playing it in terminal
    public static void main(String[] args) {
       
        
        
    }
    
    
    public static int play(){
        Deck gameDeck = new Deck();
        Card firstCard, secondCard;
        Card nextCard;
        
        int correctGuesses = 0;
        char guess;
        gameDeck.shuffleDeck();
        firstCard = gameDeck.dealCard();
        secondCard = gameDeck.dealCard();
        nextCard = gameDeck.dealCard();
        
        int firstValue = firstCard.getCardValue();
        int secondValue = secondCard.getCardValue();
        
        while(firstValue == secondValue){
            firstCard = gameDeck.dealCard();
            secondCard = gameDeck.dealCard();
            firstValue = firstCard.getCardValue();
            secondValue = secondCard.getCardValue();  
        }
        
        int high, low;
        
        if(firstValue > secondValue){
            high = firstValue;
            low = secondValue;
        } else{
            high = secondValue;
            low = firstValue;
        }
        
        while(true){
            int nextCardValue = nextCard.getCardValue();
            if(nextCardValue < high && nextCardValue > low){
                
            }
        }
    }
}
