/*
Author: Claudio Castello
http://github.com/claudiocastello

edX Learn Programming with Java
Module 1 Project - Trip Planner

The programm asks for users some info about an international trip
and make some conversions to help the users to plan their trip.

Part 1 - Greetings
Part 2 - Travel time and budget
Part 3 - Time difference
Part 4 - Country area
Part 5 - Rounding numbers
Extra - Calculating distances

The solution used only basic statements, without any kind
of control structure. Two functions where created, even not being
subject of the first module of the course.
*/


import java.util.Scanner;
import java.lang.Math;

public class TripPlanner {
  /*
  Declaring the input static variable to be used whenever an
  user input is necessary.
  */
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // Ask for initial input from user (name, destination)
    user_id();

    // Call currency method for currency conversions and budget
    currency();

    // Call time method for time difference calculations
    time();

    // Call the country_area method to convert between km^2 to mile^2
    country_area();

    Call distance method to calculate distance between home and destination.
    distance_calc();
  }

  public static void user_id() {
    System.out.println("Welcome to Vacation Planner");
    System.out.print("What is your name? ");
    String name = input.nextLine();
    System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
    String city = input.nextLine();
    System.out.println("Great! " + city + " sounds like a great trip");
    System.out.println("***********");
    System.out.println("");
  }

  public static void currency() {
    // User input related to travel days and money.
    System.out.print("How many days are you going to spend travelling? ");
    int days = input.nextInt();
    System.out.print("What is your total budget for the trip in USD? ");
    double money_USD = input.nextDouble();
    System.out.print("What is the currency symbol for your destination? ");
    String currency_symbol = input.next();
    System.out.print("How many " + currency_symbol + " there in 1 USD? ");
    double convert_curr = input.nextDouble();
    System.out.println("");

    // Convert travelling days to hours
    System.out.println(days + " of travelling equals to " + (days * 24 )+ " hours.");

    // Show user the budget per day in USD; rounding to two decimal places.
    double money_per_day = (((double)money_USD / days) * 100);
    money_per_day = (int)money_per_day;
    money_per_day /= 100.0;
    System.out.println("With $" + money_USD + " USD you can spend up to $" + money_per_day + " USD per day");

    // Conversion to destination currency and budget per day.
    // Rounding to two decimal places.
    double local_curr_budget = money_USD * convert_curr;
    double local_curr_budget_per_day = money_per_day * convert_curr * 100;
    local_curr_budget_per_day = (int)local_curr_budget_per_day;
    local_curr_budget_per_day /= 100.0;
    System.out.println("Your total budget in " + currency_symbol + " is " + local_curr_budget + " " + currency_symbol + ", which per day is " + local_curr_budget_per_day + " " + currency_symbol);
    System.out.println("***********");
    System.out.println("");
  }

  public static void time() {
    // User input reagrding time difference between home and destination.
    System.out.print("What is the time difference, in hours, between your home and your destination? ");
    int hours_diff = input.nextInt();

    // Calculates time at destination.
    int noon_at_dest = (12 + hours_diff) % 24;
    int midnight_at_dest = (24 + hours_diff) % 24;

    // Show calculated times at destination to the user.
    System.out.println("When it is midnight at home it will be " + midnight_at_dest + ":00 at your destination");
    System.out.println("When it is noon at home it will be " + noon_at_dest + ":00 at your destination");
    System.out.println("***********");
    System.out.println("");
  }

  public static void country_area() {
      // Request destination country area in squared kilometers.
      System.out.print("What is the square area, in km^2, of your destination country? ");
      int area_in_km = input.nextInt();

      // Calculates the country area in squared miles with two decimal places.
      double area_in_miles = area_in_km * 0.386102 * 10;
      area_in_miles = (int)area_in_miles;
      area_in_miles /= 10.0;

      // Show calculated area to the user.
      System.out.println("In miles^2 that is " + area_in_miles);
      System.out.println("***********");
      System.out.println("");
  }

  public static void distance_calc() {
    // Calculates distance between home and destination.

    // Get input from user of latitudes and longitudes
    // Converts degree to radians in each input.
    System.out.print("Insert your latitude: ");
    double lat_home = input.nextDouble();
    lat_home = lat_home * (Math.PI / 180);
    System.out.print("Insert your longitude: ");
    double long_home = input.nextDouble();
    long_home = long_home * (Math.PI / 180);
    System.out.print("Insert the latitude of your destination: ");
    double lat_dest = input.nextDouble();
    lat_dest = lat_dest * (Math.PI / 180);
    System.out.print("Insert the longitude of you r destination: ");
    double long_dest = input.nextDouble();
    long_dest = long_dest * (Math.PI / 180);

    // Use inputs from user in dist_formula Function and prints
    // the approximated distance in km.
    double calculated_distance;
    calculated_distance = dist_formula(lat_home, long_home, lat_dest, long_dest);
    System.out.println("The approximated distance between home and destination is " + (int)calculated_distance + "km");
  }

  public static double hav(double angle) {
    // Simple method to calculate the haversine of an angle in randians
    return (1 - Math.cos(angle)) / 2;
  }

  public static double dist_formula(double lat1, double lon1,
                                    double lat2, double lon2) {
    // Method to calculated the distance between two points in the
    // globe given its coordinates in radians. Use the haversine method.
    double d;
    int r = 6371; // Approximated radius of the Earth in km.
    d = 2 * r * Math.asin(Math.sqrt(hav(lat2 - lat1) + Math.cos(lat1) * Math.cos(lat2) * hav(lon2 - lon1)));
    return d;
  }
}
