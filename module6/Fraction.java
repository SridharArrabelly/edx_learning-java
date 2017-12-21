/*
 Objected Oriented Programming in Java
 Title: Module 2 Project - Fraction Calculator
 File: Fraction.java
 Author: Claudio Castello
 GitHub: http://github.com/claudiocastello
 email: floggio.dev@gmail.com
 */

/*** Class Declaration ***/

public class Fraction {
  // Class State
  private int numerator;
  private int denominator;

  // Class Constructors
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator can't be zero.");
    }
    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction(int numerator) {
    this.numerator = numerator;
    this.denominator = 1;
  }

  public Fraction() {
    this.numerator = 0;
    this.denominator = 1;
  }

  // Class Behavior
  public int getNumerator() {
    return this.numerator;
  }

  public int getDenominator() {
    return this.denominator;
  }

  public String toString() {
    if (this.denominator == 1) {
      return Integer.toString(this.numerator);
    }
    return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
  }

  public double toDouble() {
    double result = (double)this.getNumerator() / (double)this.getDenominator();
    return result;
  }

  /** Helper **/
  // Return the Greater Common Factor of two ints
  public static int GCF(int a, int b) {
    if (b == 0) {
      return a;
    }
    else {
      return GCF(b, a % b);
    }
  }
  // Return the Least Common Multiple of two ints
  public static int LCM(int a, int b) {
    return (a * b) / GCF(a, b);
  }
  /** Helper **/


  public Fraction add(Fraction other) {
    int newDenominator, newNumerator, newNumerator1, newNumerator2;
    newDenominator = LCM(this.getDenominator(), other.getDenominator());
    newNumerator1 = newDenominator / this.getDenominator() * this.getNumerator();
    newNumerator2 = newDenominator / other.getDenominator() * other.getNumerator();
    newNumerator = newNumerator1 + newNumerator2;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction subtraction(Fraction other) {
    int newDenominator, newNumerator, newNumerator1, newNumerator2;
    newDenominator = LCM(this.getDenominator(), other.getDenominator());
    newNumerator1 = (newDenominator / this.getDenominator()) * this.getNumerator();
    newNumerator2 = (newDenominator / other.getDenominator()) * other.getNumerator();
    newNumerator = newNumerator1 - newNumerator2;
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction multiply(Fraction other) {
    int newNumerator, newDenominator;
    newNumerator = this.getNumerator() * other.getNumerator();
    newDenominator = this.getDenominator() * other.getDenominator();
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public Fraction divide(Fraction other) {
    int newNumerator, newDenominator;
    newNumerator = this.getNumerator() * other.getDenominator();
    newDenominator = this.getDenominator() * other.getNumerator();
    Fraction newFraction = new Fraction(newNumerator, newDenominator);
    return newFraction;
  }

  public boolean equals(Object other) {
    if (other instanceof Fraction) {
      // Downcasting or Narrowing Reference Conversion
      Fraction toTest = (Fraction)other;
      if (this.toDouble() == toTest.toDouble()) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      return false;
    }
  }

  public void toLowestTerms() {
    int gcf = GCF(this.getNumerator(), getDenominator());
    this.numerator = this.getNumerator() / gcf;
    this.denominator = this.getDenominator() / gcf;
    if (this.denominator < 0) {
      this.numerator *= -1;
      this.denominator *= -1;
    }
  }
}
