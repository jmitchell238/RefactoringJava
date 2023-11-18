package org.jmitchell238.chapter1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.jupiter.api.Test;

class MovieTests {
  @Test
  void getPriceCode_called_returnsPriceCode() {
    // Arrange
    Movie movie = new Movie("Movie Title", 1);
    Integer expectedPriceCode = 1;

    // Act
    Integer actualPriceCode = movie.getPriceCode();

    // Assert
    assertThat(actualPriceCode, equalTo(expectedPriceCode));
  }

  @Test
  void setPriceCode_called_priceCodeChanged() {
    // Arrange
    Movie movie = new Movie("Movie Title", 1);
    Integer expectedPriceCode = 0;

    // Act
    movie.setPriceCode(0);
    Integer actualPriceCode = movie.getPriceCode();

    // Assert
    assertThat(actualPriceCode, equalTo(expectedPriceCode));
  }

  // Test the getTitle method
  @Test
  void getTitle_called_returnsTitle() {
    // Arrange
    Movie movie = new Movie("Movie Title", 1);
    String expectedTitle = "Movie Title";

    // Act
    String actualTitle = movie.getTitle();

    // Assert
    assertThat(actualTitle, equalTo(expectedTitle));
  }
}
