package com.techelevator;

public class MovieRental {




        String title;
        String format;
        boolean isPremiumMovie;
        double rentalPrice;

        public MovieRental(String title, String format, double rentalPrice ){
            this.title = title;
            this.format = format;
            this.rentalPrice = rentalPrice;
        }


        public String toString() {
            return "MOVIE :" + this.title +  ", FORMAT" + this.format + ", PRICE"  + this.rentalPrice;
        }

}
