   public class Scoring
   {
      public static int getScore(int[] ArrayX, int actives)
      { 
         int score = 0;
         int eleven = 0;
         for(int x = 0; x <= actives ; x++)
         {
            int g = getCardValue(ArrayX[x]);
            if(g != 11)
               score =score + g;
            else
               eleven++;
         }
         if(score>21 || eleven == 0)
            return score;
         if(eleven>1)
            score = score + (eleven-1);
         if(score+11<=21)
            return score+11;
         return score+1;
      }
      public static int getCardValue(int x)
      {
         while(x>13)
            x=x-13;
         if(x>= 2 && x<=10)
            return x;
         if(x != 1)
            return 10;
         return 11;
      }
   }