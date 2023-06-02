/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameMain;


public class Hand {
    int position;
    //add card from deck
    public void addCard(Card c);
    //remove a single card
    public void removeCard(int position);
    //get a card from a specific position
    public void getCard(int position);
    //remove all cards from the hand
    public void clearHand();
    //how many cards are in hand?
    public int getCardCount();
    
    //sort by suit
    public int sortCardsBySuit();
    //sort by numbers
    public int sortCardsByNumber();
    
   
}
