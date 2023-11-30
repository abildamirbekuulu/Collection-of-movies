
// Description:  Creates a Movie object with getters, and a tostring method, including a set Adrress method.

import java.io.*;

public class Movie implements Serializable {
   private static final long serialVersionUID = 205L;
   private String movieName;
   private int stars;
   private String review;
   private int totalCollection;
   private String director;
   private MovieGenre movieGenre;
   //constructor
   public Movie(String movieName, int stars, String review, int totalCollection, String director, MovieGenre movieGenre){
      this.movieName = movieName;
      this.stars = stars;
      this.review = review;
      this.totalCollection = totalCollection;
      this.director = director;
      this.movieGenre = movieGenre;
   }
   //getters
   public String getMovieName(){
      return movieName;
   }
   
   public int getStars(){
      return stars;
   }
   
   public int getTotalCollection(){
      return totalCollection;
   }
   
   public String getDirector(){
      return director;
   }
   
   public String getReview(){
      return review;
   }
   
   public MovieGenre getMovieGenre(){
      return movieGenre;
   }
   
   public String toString(){
      String star = "";
      for(int i = 0; i < stars; i++){
         star += "*";
      }
      String total = "";
      for(int i = 0; i < totalCollection; i++){
         total += "$";
      }
      String result = "";
      result = movieName + " Movie\n" + 
               star + "\n" +
               "Total Collection earned: " + total + "\n" +
               movieGenre.toString() + 
               "Director: " + director + "\n" +
               "Review:\t" + review + "\n\n";
      return result;
   }
   
   
}
