# Movie Rental

1. Create a new class that represents a *Movie Rental*. Follow good naming standards when naming the class.<br /><br />

2. Using good naming standards, add  *title*, *format*, *is premium movie*, and *rental price* properties to the Movie Rental class:
    * `title`: indicates the title of the movie.
    * `format`: indicates the format of the movie (VHS, DVD, or Blu-ray).
    * `is premium movie`: indicates if the movie is a premium movie. Premium movies cost more.
    * `rental price`: indicates the rental price (VHS $0.99, DVD $1.99, BluRay $2.99). Premium movies add an additional $1.00 to the rental price. (Hint: What could you call from outside of the object to return the appropriate rental price? How could you derive the appropriate price?)<br /><br />

3. Before moving to step 4, check in your in-progress code to your repository with a git commit message of 'step 1 and 2 complete'. Make sure all code compiles first.<br /><br />

4. Create a constructor in your movie rental class that accepts the following parameters: `title`, `format`, and `is premium movie`.<br /><br />

5. In the given Module1CodingAssessment class (your 'app' class), create/instantiate at least 3 movie rental objects. Populate each one with sample data. Then add them to an List.<br /><br />

6. Before moving to step 7, check in your in-progress code to your repository with a git commit message of 'step 4 and 5 complete'. Make sure all code compiles first.  <br /><br />

7. In your *Movie Rental* class, override the `toString()` method and have it return a string in the form of:  `"MOVIE: {title} - FORMAT: {format} PRICE: {rental price}"` where `{title}`, `{format}`, and `{rental price}` are the object's actual values. <br /><br />

8. Before moving to step 9, check in your in-progress code to your repository with a git commit message of 'step 7 complete'. Make sure all code compiles first. <br /><br />

9. Back in the Module1CodingAssessment class, create a private method called `printMovieList` that takes an ArrayList from the previous step and prints out each movie and it's data. (Hint: can you call `toString()`).  Note: You should be 'passing' the ArrayList into this private method from the run() method. Do not write this code in the run() method.<br /><br />

10. Before moving to step 11, check in your in-progress code to your repository with a git commit message of 'step 9 complete'. Make sure all code compiles first. <br /><br />

11. Create a new public method in the *Movie Rental* class that determines a movie's late fee by taking in an input parameter: `int daysLate` and calculating/returns the result as follows:
    * Return $0.00 if `daysLate` is equal to 0.
    * Return $1.99 if `daysLate` is equal to 1.
    * Return $3.99 if `daysLate` is equal to 2.
    * Return $19.99 if `daysLate` is equal to 3 or more.<br /><br />

12. Before moving to step 13, check in your in-progress code to your repository with a git commit message of 'step 11 complete'. Make sure all code compiles first.  <br /><br />

13. Build and implement a Unit test that tests your *Movie Rental* class, specifically the functionality of:
    * The rental price calculation 
    * The late fee calculation<br /><br />

14. Before moving to step 15, check in your in-progress code to your repository with a git commit message of 'step 13 complete'. Make sure all code compiles first. <br /><br />     

15. Create a new private method in your Module1CodingAssessment class to write out the movie data to a file. You can call this method at the end of your main method and reuse the toString() method to print the data to the file.<br /><br />

15. Check in your final code to your repository with a git commit message of 'assessment complete'. Make sure all code compiles first.  