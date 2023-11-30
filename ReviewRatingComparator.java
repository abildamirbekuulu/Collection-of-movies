// Description: Returns an integer based on if one of the two Movies has a stars that less than other.

import java.util.*;

public class ReviewRatingComparator implements Comparator<Movie>{
   public int compare(Movie a, Movie b){
      int res;
      if((a.getStars() - b.getStars()) != 0){
         res = a.getStars() - b.getStars();
      }
      else{
         res = a.getMovieName().compareTo(b.getMovieName());
      }
      return res;
   }
}
