package org.jmitchell238;

import org.jmitchell238.chapter1.Customer;
import org.jmitchell238.chapter1.Movie;
import org.jmitchell238.chapter1.Rental;

public class Main {

  public static void main(String[] args) {


    System.out.println("Welcome to the Video Store");

    Movie movieOne = new Movie("New Release Movie", 1);
    Rental rentalOne = new Rental(movieOne, 3);

    Customer customerOne = new Customer("John Doe");

    customerOne.addRental(rentalOne);

    System.out.println(customerOne.statement());
  }
}