// Description: Sorts a list of Movie objects based on different criterias

import java.io.*;
import java.util.*;

public class Sorts{
   public static void sorts(ArrayList<Movie> reviewList, Comparator<Movie> xComparator) {
      if (reviewList.size() == 1)
			return;
      Movie x, a, b;
      for(int i = 0;i < reviewList.size() - 1; i++){
         for(int j = i + 1; j < reviewList.size(); j++){
            a = reviewList.get(i);
            b = reviewList.get(j);
            if(xComparator.compare(b, a) < 0){
               Collections.swap(reviewList, i, j);
            }
         }
      }

   }
}
