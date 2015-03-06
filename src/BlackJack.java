
  /*
   .------..------..------..------..------.
   |B.--. ||L.--. ||A.--. ||C.--. ||K.--. |
   | :(): || :/\: || (\/) || :/\: || :/\: |
   | ()() || (__) || :\/: || :\/: || :\/: |
   | '--'B|| '--'L|| '--'A|| '--'C|| '--'K|
   `------'`------'`------'`------'`------'
   .------..------..------..------..------.
   |J.--. ||A.--. ||C.--. ||K.--. ||!.--. |
   | :(): || (\/) || :/\: || :/\: || (\/) |
   | ()() || :\/: || :\/: || :\/: || :\/: |
   | '--'J|| '--'A|| '--'C|| '--'K|| '--'!|
   `------'`------'`------'`------'`------'
   */

//   import javax.swing.JOptionPane;

   public class BlackJack
   {
 
      public static int[] playerHand;
      public static int[] dealerHand;
      public static int playerWin =0;
      public static int dealerWin =0;
    
      public static void main(String[] args)
      {
         playerHand = new int[11];
         dealerHand = new int[11];
      
         boolean wannaPlay = true;
      
         while(wannaPlay)
         {
         
         //round start
         
            int playerScore = 0;
            int dealerScore = 0;
            int playerActive = 1;
            int dealerActive = 1;  
         
            setHands();       
          
            boolean playerStand = false;
            boolean playerBust = false; 
         
         //print first deck        
            System.out.println("");
            System.out.println("[XXXXXX] " + Card.getCard(dealerHand[1]));
            System.out.println(Card.getCard(playerHand[0])+" "+ Card.getCard(playerHand[1]));
            System.out.println("");
            System.out.println("");  
         //print first deck
         
         
         //player's turn
               
            while(!playerStand && !playerBust)
            {
               System.out.println("Hit or Stand?");
               System.out.println("");
               
               String blah = "stand";
               
               if(blah.equals("stand"))
               {
                  playerStand = true;
               }
               else if(blah.equals("hit"))
               {
                  playerActive++;
               
               //print second deck
                  System.out.println("[XXXXXX] " + Card.getCard(dealerHand[1]));
                  for(int q = 0; q <= playerActive ; q++)
                  {  
                     System.out.print(Card.getCard(playerHand[q]));
                     if(q !=playerActive)
                        System.out.print(" ");
                  }
                  System.out.println("");
                  System.out.println("");
               //print second deck
               
                  playerScore = Scoring.getScore(playerHand, playerActive);
                
               //automatically abort if player busts
                  if(playerScore>21)
                     playerBust = true;
               }
            }
         //player's turn end
         
         
         //dealer's turn begin
            if(playerBust)
            {
               dealerWin++;
               printDeck(playerActive, dealerActive);
               printWinner();
            }
            else
            {
               playerScore = Scoring.getScore(playerHand, playerActive);
               dealerScore = Scoring.getScore(dealerHand, dealerActive);
                
               boolean dealerBust = false;
               boolean dealerLose = false;
            	
            	
            }
            //dealer's turn end
         	//round end
         }
      }
   	
      public static void setHands()
      {
         for(int x = 0; x <= 10; x++)
         {
            playerHand[x] = (int)(Math.random()*52+1);
            dealerHand[x] = (int)(Math.random()*52+1);
         }    
      }
    
            //dealer's image(s)
      public static void printDeck(int players, int dealers)
      {
      ////print dealers
         for(int q = 0; q <= dealers ; q++)
         {  
            System.out.print(Card.getCard(dealerHand[q]));
            if(q !=dealers)
               System.out.print(" ");
         }
         System.out.println("");
         ////print players
         for(int q = 0; q <= players ; q++)
         {  
            System.out.print(Card.getCard(playerHand[q]));
            if(q !=dealers)
               System.out.print(" ");
         }
         System.out.println("");
         System.out.println("");
      }
      public static void printWinner()
      {
         System.out.println("Player Wins: " + playerWin);
         System.out.println("Dealer Wins: " + dealerWin);
         System.out.println("");
      }
   }
