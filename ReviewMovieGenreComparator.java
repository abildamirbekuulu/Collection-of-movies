// Description: Returns an integer based on if one of the two Movies has a genre that come before it in hierarchy order.

import java.util.*;

public class ReviewMovieGenreComparator implements Comparator<Movie>{
   public int compare(Movie a, Movie b){
      if(a.getMovieGenre().getGenre().compareTo(b.getMovieGenre().getGenre()) == 0){
          if(a.getTotalCollection() == b.getTotalCollection()){
              return a.getMovieName().compareTo(b.getMovieName());
          }
          else{
              return a.getTotalCollection() - b.getTotalCollection();
          }
      }
      else{
         return a.getMovieGenre().getGenre().compareTo(b.getMovieGenre().getGenre());
      }
   }
}
