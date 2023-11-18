package org.jmitchell238;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MainTests {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  void main_ShouldPrintExpectedOutput() {
    // Arrange
    String expectedOutput = """
        Welcome to the Video Store
        Rental Record for John Doe
        \tNew Release Movie\t9.0
        Amount owed is 9.0
        You earned 2 frequent renter points""";

    // Act
    Main.main(new String[]{});
    String actualOutput = outputStreamCaptor.toString().trim();

    // Assert
    assertThat(actualOutput, is(expectedOutput));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }
}