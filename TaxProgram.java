import java.util.Scanner;
public class TaxProgram {
    public static void main(String args[]) {
        double income, fedTax, provTax, base, deductions, totaltax;
        int dependents;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your taxable income: ");
        income = input.nextDouble();
        System.out.println();
        System.out.print("Please enter your number of dependents: ");
        dependents = input.nextInt();
        System.out.println();
        fedTax = 0.0;
        provTax = 0.0;

        //if statements for different income brackets

        if (income <= 29590){
            fedTax = income*0.17;
        }
        else if (income>=29590.01 && income <= 59179.99){
            fedTax = (29590 * 0.17) + (income-29590)*0.26;
        }
        else if (income >= 59180){
            fedTax = 29590*0.17 + 29590*0.26 + ((income-59180)*0.29);
        }

        //setting base and deduction variable
        base = fedTax*0.425;
        deductions = 160.50+(328*dependents);

        if(base < deductions){
            provTax = 0;
        } else {
            provTax = base - deductions;
        }

        totaltax = fedTax + provTax;

        //had to use two string.format functions to put the dollar sign beside each other
        System.out.println("Here is your breakdown:");
        System.out.println(" ");
        System.out.println(String.format("%-14s %13s","Income", (String.format("$%,.2f", income))));
        System.out.println(String.format("%-14s %13d" , "Dependants" ,dependents));
        System.out.println("----------------------------");
        System.out.println(String.format("%-14s %13s","Federal Tax", (String.format("$%,.2f", fedTax))));
        System.out.println(String.format("%-14s %13s","Provincial Tax", (String.format("$%,.2f", provTax))));
        System.out.println("============================");
        System.out.println(String.format("%-14s %13s","Total Tax", (String.format("$%,.2f", totaltax))));
    }
}
