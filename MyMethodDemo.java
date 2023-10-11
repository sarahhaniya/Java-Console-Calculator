package Lab6Q;

import java.util.Scanner;

public class MyMethodDemo {//public class cont
    public static void main(String[] args) {
        char choice, a, b, c, d, e;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("==================\n" +
                    "a: Power Function\n" +
                    "b: Factorial Function\n" +
                    "c: Sine Function\n" +
                    "d: Cosine Function\n" +
                    "e: exit\n" +
                    "==================\n" +
                    "Please enter an option from the menu: ");
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
            if (choice == 'e')
                break;
            switch (choice) {
                case 'a':
                    double base, power;
                    System.out.println("Please enter the base and exponent:" );
                    System.out.print("Base: ");
                    base = input.nextDouble();
                    System.out.print("Exponent: ");
                    power = input.nextDouble();
                    System.out.println("The result of "+base+" to the power of " + power + " is " +myPow(base, power) );
                    break;

                case 'b':
                    int n1;
                    System.out.println("Please enter the number you would like to find the factorial of :" );
                    n1 = input.nextInt();
                    System.out.println("The factorial of " + n1 +" is " + myFactorial(n1) );
                    break;
                case 'c':
                    double angle;
                    char angleChoice;
                    System.out.print("Enter r if your angle is in radians. Enter d if your angle is in degrees: ");
                    angleChoice = input.next().charAt(0);
                    switch (angleChoice){
                        case 'r':
                            System.out.print("Please enter your angle in radians : ");
                            angle = input.nextDouble();
                            System.out.println("The sin of the angle entered is " +mySin(angle) );
                            break;
                        case 'd':
                            System.out.print("Please enter your angle in degrees : ");
                            angle = input.nextDouble();
                            angle = myDegreeToRadian(angle);
                            System.out.println("The sin of the angle entered is " +mySin(angle) );
                            break;
                    }
                    break;


                case 'd':
                    double angle2;
                    System.out.print("Enter r if your angle is in radians. Enter d if your angle is in degrees: ");
                    char angleChoice2 = input.next().charAt(0);
                    switch (angleChoice2){
                        case 'r':
                            System.out.print("Please enter your angle in radians : ");
                            angle2 = input.nextDouble();
                            System.out.println("The cos of the angle entered is " +myCos(angle2) );
                            break;
                        case 'd':
                            System.out.print("Please enter your angle in degrees : ");
                            angle2 = input.nextDouble();
                            angle2 = myDegreeToRadian(angle2);
                            System.out.println("The cos of the angle entered is " +myCos(angle2) );
                            break;
                    }
                    break;


                default:
                    System.out.println("Invalid Entry");
                    break;

            }



        }
    }

    public static double myDegreeToRadian ( double degrees){
        double x = degrees;
        degrees = x * Math.PI / 180;


        return degrees;
    }


    //COSINE METHOD **************************************************
    public static double myCos ( double x){
        double numerator, denominator, exponent, n = 0;
        double result = 0;
        int N = 20;
        for (n = 0; n <= N; n++) {
            numerator = myPow(-1, n);
            denominator = myFactorial((2 * n));
            exponent = myPow(x, (2 * n));
            result += (numerator * exponent) / denominator;
        }

        return result;
    }
    //SIN METHOD **************************************************
    public static double mySin ( double x){
        double numerator, denominator, exponent, n = 0;
        double result = 0;
        int N = 20;
        for (n = 0; n <= N; n++) {
            numerator = myPow(-1, n);
            denominator = myFactorial((2 * n + 1));
            exponent = myPow(x, (2 * n + 1));
            result += (numerator * exponent) / denominator;
        }
        return result;

    }


    //FACTORIAL METHOD **************************************************
    public static double myFactorial ( double n){
        int i;
        double result = 1;
        for (i = 1; i <= n; i++)
            result = result * i;
        return result;
    }


    //POWER METHOD **************************************************
    public static double myPow ( double base, double power){
        double result = 1;
        if (power == 0) {
            return 1;
        }

        if (power < 0) {
            while (power < 0) {
                result = result / base;
                power++;
            }
        }


        if (power > 0) {
            while (power > 0) {
                result = result * base;
                --power;
            }
        }


        return result;
    }



}






