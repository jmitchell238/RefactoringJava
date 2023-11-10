package org.jmitchell238.chapter1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class RentalTests {
  @Test
  void getDaysRented_called_returnsDaysRented() {
    // Arrange
    Movie movie = new Movie("Movie Title", 1);
    Rental rental = new Rental(movie, 1);
    Integer expectedDaysRented = 1;

    // Acts
    Integer actualDaysRented = rental.getDaysRented();

    // Act & Assert
    assertThat(actualDaysRented, equalTo(expectedDaysRented));
  }

  @Test
  void getMovie_called_returnsMovie() {
    // Arrange
    Movie movie = new Movie("Movie Title", 1);
    Rental rental = new Rental(movie, 1);
    Movie expectedMovie = movie;

    // Acts
    Movie actualMovie = rental.getMovie();

    // Act & Assert
    assertThat(actualMovie, equalTo(expectedMovie));
  }
}
