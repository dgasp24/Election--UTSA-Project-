
import java.util.Scanner;
public class Election {

    public static void main(String[] args){
        //Declaring the variables
        Scanner scnr = new Scanner(System.in);
        int i;
        int j;
        int numDay = 0;
        int count = 0;
        double totalWeek = 0;
        double totalMonth = 0;


        //Asking User for the percentages
        System.out.println("Fall 2024 - CS1083 - Section 005 - Project 1 – Election - Dominic Gasper");
        System.out.println("Please, input the initial percent: ");
        double initialPercent = scnr.nextDouble();
        System.out.println("Please, input the daily percent increase: ");
        double percentIncrease = scnr.nextDouble();
        System.out.println("Please, input the weekend percent increase: ");
        double percentWeekend = scnr.nextDouble();
        System.out.println("Last day of the month (A-28, B-30, C-31)");
        char day = scnr.next().charAt(0);
        System.out.println("Please, input the percent that increases when there is rally in the state:");
        double rallyPercent = scnr.nextDouble();
        System.out.println("First Rally (day of the month)");
        int firstRally = scnr.nextInt();
        System.out.println("Second Rally (day of the month)");
        int secondRally = scnr.nextInt();
        System.out.println("Third Rally (day of the month)");
        int thirdRally = scnr.nextInt();

        //For End of The Month
        if(day == 'A'){
            numDay = 28;
        }else if(day == 'B'){
            numDay = 30;
        }else if(day == 'C'){
            numDay = 31;
        }

        //PRINTING WEEKS
        for(i = 1; i <= 5; i++){

            //Header
            if(i == 1){
                System.out.println(String.format("%-8s %-11s %-11s %-11s %-11s %-11s %-11s %-11s %-1s", "Week", "Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday","Total/Week"));
            }
            System.out.printf("%-9s", i);


            //PRINTING DAYS
            for(j = 1; j <= 7; j++){
                count++;

                //Printing the info in the days
                if(i == 1 && j == 1){
                    //For the first day
                    System.out.printf("%-12s", count + "-" + String.format("%.3f", (initialPercent + percentIncrease)));
                    totalWeek = totalWeek + (initialPercent + percentIncrease);
                }else if(count > numDay){
                    //For Days past the end of the month
                    System.out.printf("%-12s", "0" + "-0.000");
                }else if(count == firstRally || count == secondRally || count == thirdRally){
                    //FOR RALLY DAYS
                    if(j == 6 || j == 7) {
                        System.out.printf("%-12s", count + "-" + String.format("%.3f",(rallyPercent + percentWeekend)));
                        totalWeek = totalWeek + (rallyPercent+percentWeekend);
                    }else {
                        System.out.printf("%-12s", count + "-" + String.format("%.3f",(rallyPercent + percentIncrease)));
                        totalWeek = totalWeek + (rallyPercent+percentIncrease);
                    }
                }else if(j == 6 || j == 7){
                    //Saturday and Sunday
                    System.out.printf("%-12s", count + "-" + String.format("%.3f", percentWeekend));
                    totalWeek = totalWeek + percentWeekend;
                }else {
                    System.out.printf("%-12s", count + "-" + String.format("%.3f",percentIncrease));
                    totalWeek = totalWeek + percentIncrease;
                }

            }

            //Prints total for the week and calculates the sum for the month before totalWeek resets
            System.out.printf("%-12s", "W"+ i + "-" + String.format("%.3f", totalWeek));
            totalMonth = totalMonth + totalWeek;

            //Add Calculation for end of week here
            System.out.println();
            totalWeek = 0;
        }

        System.out.printf("End of Month Percent: %.3f \n", totalMonth);

    }
}
