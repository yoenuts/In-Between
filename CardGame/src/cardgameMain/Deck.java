/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameMain;

//this deck will not handle jokers. Card class is without

public class Deck {
    private int cardsUsed;
    //this is deck
    private Card[] deck;
    
    
    public Deck(){
        deck = new Card[52];
        int cardCrt = 0;
        
        for(int suit = 0; suit <= 3; suit++){
            for(int value = 1; value <= 13; value++){
                deck[cardCrt] = new Card(suit,value);
                cardCrt++;
            }
        }
        
        cardsUsed = 0;
    }
    
    //put all used cards back on deck then shuffle : )
    public void shuffleDeck(){
        for(int i = deck.length - 1; i > 0; i--){
            int rand = (int)(Math.random() * (i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
            
        }
        cardsUsed = 0;
    }
    
    public int cardsLeft(){
        return deck.length - cardsUsed;
    }
    
    public Card dealCard(){
        if(deck.length == cardsUsed)
            throw new IllegalStateException("Deck is empty.");
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
    
    
}
