/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameMain;

import java.util.*;

public class Hand {
    private ArrayList<Card> hand;
    int position;
    
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    //clear cards from hand
    public void clear(){
        hand.clear();
    }
    
    public void addCard(Card c){
        if(c == null)
            throw new NullPointerException("Can't add a null card here");
        hand.add(c);
        
    }
    
    //add card from deck
    public void addCard(Card c, Card d){
        if(c == null)
            throw new NullPointerException("Can't add a null card here");
        hand.add(c);
        hand.add(d);
    }
    
    //remove a single card
    public void removeCard(Card c){
        hand.remove(c);
    }
    
    //remove 2
    public void removeCard(Card c, Card d){
        hand.remove(c);
        hand.remove(d);
    }
    
    //remove card from a specific position
    public void removeCard(int pos){
        if(pos < 0 || pos >= hand.size())
            throw new IllegalArgumentException("Position is not valid" + pos);
        hand.remove(pos);
    }
    
    //get a card from a specific position
    public Card getCard(int pos){
        if(pos < 0 || pos >= hand.size())
            throw new IllegalArgumentException("Position is not valid" + pos);
        return hand.get(pos);
    }
    
    public int getCardCount(){
        return hand.size();
    }
    
    //sort by suit
    public void sortCardsBySuit(){
        ArrayList<Card> newHand = new ArrayList<>();
        while(hand.size() > 0){
            int pos = 0;
            Card c = hand.get(0);
            for(int i = 0; i < hand.size(); i++){
                Card cC = hand.get(i);
                if(cC.getSuit() < c.getSuit() || cC.getSuit() == c.getSuit() && cC.getCardValue() < c.getCardValue()){
                    pos = i;
                    c = cC;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
        
    //sort by numbers
    public void sortCardsByNumber(){
        ArrayList<Card> newHand = new ArrayList<>();
        while(hand.size() > 0){
            int pos = 0;
            Card c = hand.get(0);
            for(int i = 0; i < hand.size(); i++){
                Card cC = hand.get(i);
                if(cC.getCardValue() < c.getCardValue() || cC.getCardValue() == c.getCardValue() && cC.getSuit() < c.getSuit()){
                    pos = i;
                    c = cC;
                }
            }
            hand.remove(pos);
            newHand.add(c);
        }
        hand = newHand;
    }
    
   
}
