/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameMain;

/** 
 * 
 * This card has no jokers
 */
public class Card {
    //set a value for the suits
    public final static int SPADES = 0;
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;
    
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    private final int value;
    private final int suit;
    
    
    public Card(){
        //default card is always an ace spade
        suit = SPADES;
        value = ACE;
    }
    
    public Card(int cSuit, int cValue){
        
        if(cSuit != SPADES && cSuit != HEARTS && cSuit != DIAMONDS && cSuit != CLUBS){
            throw new IllegalArgumentException("Illegal card suit");
        }
        else{
            suit = cSuit;
        }
        if(cValue < 1 || cValue > 13){
            throw new IllegalArgumentException("Ilegal card Value");
        }
        else{
            value = cValue;
        }
    }
    
    public int getSuit(){
        return suit;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getSuitAsString(){
        switch(suit){
            case 0: return "Spades";
            case 1: return "Hearts";
            case 2: return "Diamonds";
            case 3: return "Clubs";
            default: return "idk";
        }
    }
    
    public String getValueAsString(){
        switch(value){
            case 1: return "ACE";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "idk what that is";
        }
    }
        
            
    public String toString(){
        return getValue() + " of " + getSuit();
    }
}
