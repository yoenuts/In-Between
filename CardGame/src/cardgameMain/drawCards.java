/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cardgameMain;

/**
 *
 * @author le bratte
 */
public class drawCards {
    /*
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
    */
}
