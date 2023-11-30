
// Description: Creates a ReviewManager object to manage the reviewList ArrayList<Movie>.

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;
    
    private ArrayList<Movie> reviewList;

    public ReviewManager() {
        reviewList = new ArrayList<>();
    }
    
    /**
     * Add a Movie object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two Movies are
     * considered duplicated if they have exactly the same movie name and genre.
     * 
     * @param  movieName          the name of the movie
     * @param  stars              the number of stars the movie recieved
     * @param  review             the movie review
     * @param  totalCollection    the integer total collection earned by the movie
     * @param  genre              the movie's genre
     * @param  director           the movie's director
     * @param  prodictionCompany  production comapny of the movie
     * @return                    true if the operation is successful; false otherwise
     */
    
    //Adds a movie review to the reviewList
    public boolean addReview(String movieName, int stars, String review, String totalCollection, String genre, String director, String productionCompany) {
        if (movieExists(movieName, director) == -1) {
            int collection = totalCollection.length();
            MovieGenre newGenre = new MovieGenre(genre, productionCompany);
            Movie newMovie = new Movie(movieName, stars, review, collection, director, newGenre);
            reviewList.add(newMovie);
            return true;
        }
        return false;
    }
    public int movieExists(String movieName, String director){
      int index = -1;
      for(int i = 0; i < reviewList.size(); i++){
         if(reviewList.get(i).getMovieName().equals(movieName) && reviewList.get(i).getDirector().equals(director)){
            index = i;
            break;
         } 
      }
      return index;
    }
    
    public String getReview(int x){
      return reviewList.get(x).getReview();
    }
    
    public ArrayList<Integer> movieGenreExists(String genre){
      ArrayList<Integer> x = new ArrayList<Integer>();
      for(int i = 0;i < reviewList.size(); i++){
         if(reviewList.get(i).getMovieGenre().getGenre().equals(genre)){
            x.add(i);
         }
      }
      return x;
    }
    
    public Movie getMovie(int index){
      return reviewList.get(index);
    }
    
    public boolean removeReview(String movieName, String director){
      int index = -1;
      for(int i = 0; i < reviewList.size(); i++){
         if(reviewList.get(i).getMovieName().equals(movieName) && reviewList.get(i).getDirector().equals(director)){
            index = i;
            break;
         } 
      }
      if(index == -1){
         return false;
      }
      else{
         reviewList.remove(index);
         return true;
      }
    }
    
    public void sortByRating(){
      Sorts.sorts(reviewList, new ReviewRatingComparator());
    }
    
    public void sortByMovieGenre(){
      Sorts.sorts(reviewList, new ReviewMovieGenreComparator());
    }
    
    
    public String listReviews(){
      String result = "";
      if(reviewList.size() == 0){
         result = "No Reviews available\n";
      }
      for(int i = 0; i < reviewList.size(); i++){
         result += reviewList.get(i).toString();
      }
      return result;
    }
    public String matchedMovies(int x){
      return reviewList.get(x).toString();
    }
    public void closeReviewManager(){
      reviewList.clear();
    }
    
}
