   public class Card
   {
      public static String getCard(int x)
      {
         return "[" + getSuit(x) + " " + getSymbol(x) + "]";
      } 
      private static String getSuit(int y)
      {
      
         if(y <= 13)
         {
            return "o8<";
         }
         else if (y <= 26)
         {
            return "<> ";
         }
         else if ( y <= 39)
         {
            return "<3<";
         }
         else
         {
            return "<3 ";
         }
      }
      private static String getSymbol(int y)
      {
         while(y > 13)
            y = y -13;
            
         if( y >= 2 && y <= 9)
         {
            return y + " ";
         }
         else if (y == 10)
         {
            return "" + y;
         }
         else
         {
            switch(y)
            {
               case 11:
                  return "J ";
               case 12:
                  return "Q ";
               case 13:
                  return "K ";
            } 
            return "A "; 
         }
      }
   }