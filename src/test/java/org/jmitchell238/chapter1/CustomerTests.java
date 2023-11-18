package org.jmitchell238.chapter1;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTests {

  private Movie newReleaseMovie;
  private Movie childrensMovie;
  private Movie regularMovie;
  private Rental newReleaseRental;
  private Rental childrensRental;
  private Rental regularRental;
  private Customer customer;

  @BeforeEach
  void setUp() {
    newReleaseMovie = new Movie("New Release Movie", 1);
    childrensMovie = new Movie("Children's Movie", 2);
    regularMovie = new Movie("Regular Movie", 0);
    newReleaseRental = new Rental(newReleaseMovie, 1);
    childrensRental = new Rental(childrensMovie, 1);
    regularRental = new Rental(regularMovie, 1);
    customer = new Customer("John Doe");
  }

  @Test
  void statement_calledWithNoRentals_printsCorrectStatement() {
    // Act & Assert
    assertThat(customer.statement(), is("""
        Rental Record for John Doe
        Amount owed is 0.0
        You earned 0 frequent renter points"""));
  }

  @Test
  void statement_calledWithOneNewReleaseRentalForOneDay_printsCorrectStatement() {
    // Arrange
    customer.addRental(newReleaseRental);

    // Act & Assert
    assertThat(customer.statement(), is("""
        Rental Record for John Doe
        \tNew Release Movie\t3.0
        Amount owed is 3.0
        You earned 1 frequent renter points"""));
  }

  @Test
  void statement_calledWithOneNewReleaseRentalForMoreThanOneDay_printsCorrectStatement() {
    // Arrange
    customer.addRental(new Rental(newReleaseMovie, 3));

    // Act & Assert
    assertThat(customer.statement(), is("""
        Rental Record for John Doe
        \tNew Release Movie\t9.0
        Amount owed is 9.0
        You earned 2 frequent renter points"""));
  }

  @Test
  void statement_calledWithMultipleDifferentRentals_printsCorrectStatement() {
    // Arrange
    customer.addRental(newReleaseRental);
    customer.addRental(childrensRental);
    customer.addRental(regularRental);

    // Act & Assert
    assertThat(customer.statement(),
        is("""
            Rental Record for John Doe
            \tNew Release Movie\t3.0
            \tChildren's Movie\t1.5
            \tRegular Movie\t2.0
            Amount owed is 6.5
            You earned 3 frequent renter points"""));
  }

  @Test
  void statement_calledWithMultipleRentalsMultipleDays_printsCorrectStatement() {
    // Arrange
    customer.addRental(new Rental(newReleaseMovie, 3));
    customer.addRental(new Rental(childrensMovie, 4));
    customer.addRental(regularRental);

    // Act & Assert
    assertThat(customer.statement(),
        is("""
            Rental Record for John Doe
            \tNew Release Movie\t9.0
            \tChildren's Movie\t3.0
            \tRegular Movie\t2.0
            Amount owed is 14.0
            You earned 4 frequent renter points"""));
  }

  @Test
  void statement_calledWithRegularRentalForMoreThanTwoDays_printsCorrectStatement() {
    // Arrange
    customer.addRental(new Rental(regularMovie, 3));

    // Act & Assert
    assertThat(customer.statement(),
        is("""
            Rental Record for John Doe
            \tRegular Movie\t3.5
            Amount owed is 3.5
            You earned 1 frequent renter points"""));
  }
}
