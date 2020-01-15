package taxpayertest;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Name: Tanzila Tahera ID: 12120827 Unit: Introduction to Programming 
 * Unit code: COIT20245 Tutor: Aries Tao
 * File name: TaxpayerTest.java
 */
public class TaxpayerTest {
    
    public static void main(String[] args) {

        final int N = 9; //used to take 9 inputs from user
        String employeeName = null; //variable to store employee name as input
        int age = 0, groupNumber = 0; // age is storing employee age input
        double taxableIncome = 0, totalTax = 0;

        //switchCase: storing switch case input,taxGroupCounter: counting group 1 employee members in case 4
        int switchCase = 0, taxGroupCounter;

        //ageSearch:storing age in case 5; ageCounter:counting same age employees in case 5 
        int ageSearch, ageCounter;

        //Declaration of arrayList variable 'taxPayerData'
        ArrayList<Taxpayer> taxPayerData = new ArrayList<>(5);

        //initializing scanner for input 
        Scanner input = new Scanner(System.in);

        //Deeclaring taxPayer class object
        Taxpayer taxPayerObject = new Taxpayer(employeeName, age, taxableIncome, totalTax, groupNumber);

        //welcome message
        System.out.println("\t***Welcome to this employee information program!***");
        
        //This loop will take infinity switch case inputs 
        while (true) {

            System.out.println("Press 1 to: Read, validate and store data for 9 taxpayers");
            System.out.println("Press 2 to: Calculate and store tax and tax group for all taxpayers");
            System.out.println("Press 3 to: Display all taxpayers");
            System.out.println("Press 4 to: Display the name and age of all taxpayers from tax group 1");
            System.out.println("Press 5 to: Search a taxpayer by age");
            System.out.println("Press 6 to: Sort and display taxpayers");
            System.out.println("Press 7 to: Exit from the application");
            System.out.print("Please enter switch case number : ");

            switchCase = input.nextInt();
            switch (switchCase) {
                case 1:
                    if(taxPayerData.size() != 0) taxPayerData.clear();
                    //this loop is taking N employee details from users
                    for (int k = 0; k < N; k++) {

                        Scanner input2 = new Scanner(System.in);
                        System.out.println("Please type employee's name: ");
                        employeeName = input2.nextLine();
                        System.out.println("Please type employee's age: ");
                        age = input2.nextInt();
                        //this loop will ask for age until the user gives expected age
                        while (age < 18 || age > 64) {
                            System.out.println("Please enter age between 18 to 64");
                            age = input2.nextInt();
                        }
                        System.out.println("Please type employee's total taxable income: ");
                        taxableIncome = input2.nextDouble();
                        //this loop will ask for income until the income is between $1-$999000
                        while (taxableIncome < 1 || taxableIncome > 999000) {
                            System.out.println("Please enter income between $1 to $999000");
                            taxableIncome = input2.nextDouble();
                        }
                        //passing user input to the object 'taxPayerObject'
                        taxPayerObject = new Taxpayer(employeeName, age, taxableIncome, totalTax, groupNumber);

                        //sending user data to arraylist as an object
                        taxPayerData.add(taxPayerObject);
                    }
                    break;

                case 2:
                    //thsicondition will be true if switch 2 is pressed before switch 1
                    if (taxPayerData.size() == 0) {
                        System.out.println("Please enter 1 first");
                    } else {
                        System.out.println("Tax calculaion is done");

                        //for loop to access 'taxPayerData' arraylist 
                        for (Taxpayer obj : taxPayerData) {

                            //calculated tax is storing in arraylist, calculateTax method is being used
                            obj.totalTax = taxPayerObject.calculateTax(obj.taxableIncome);

                            //tax group calculation is done using geGroupNumber method & stored in arraylist
                            obj.taxGroup = taxPayerObject.getGroupNumber(obj.taxableIncome);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Here is the employee details:\n");
                    //for each loop to print arraylist data
                    for (Taxpayer obj : taxPayerData) 
                        System.out.println("\tName: " + obj.employeeName + " Age: " + obj.age + " Income: " + obj.taxableIncome + " Total Tax: " + obj.totalTax + " Tax Group: " + obj.taxGroup + "\n");                   
                    break;
                    
                case 4:
                    System.out.println("Name and age of taxpayers from group 1:");
                    taxGroupCounter = 0;
                    for (Taxpayer obj : taxPayerData) {
                        //linear searching for Group 1 members
                        if (obj.taxGroup == 1) {
                            taxGroupCounter++;
                            System.out.println("Name: " + obj.employeeName + " Age: " + obj.age);
                        }
                    }
                    //this condition will be true if there is no member in group 1
                    if (taxGroupCounter == 0) System.out.println("No member in group 1");
                    break;
                    
                case 5:
                    System.out.println("Please enter an age to search: ");
                    ageCounter = 0;
                    ageSearch = input.nextInt();
                    System.out.println("Searching for employees of age " + ageSearch + "\n");
                    for (Taxpayer obj : taxPayerData) {
                        //linear serching for employee with given age in arraylist 
                        if (obj.age == ageSearch) {
                            ageCounter++;
                            System.out.println("\tName: " + obj.employeeName + " Age: " + obj.age + " Income: " + obj.taxableIncome + " Total Tax: " + obj.totalTax + " Tax Group: " + obj.taxGroup + "\n");
                        }
                    }
                    //thiscondition will be true if there is no employee of given age
                    if (ageCounter == 0) System.out.println("Taxpayer with given age is not found");
                    
                    break;

                case 6:
                    int compare,tempTaxGroup,tempAge; //temp variables are used in bubble sort to store temporary data
                    double tempIncome,tempTax;
                    String temp,temp2;

                    //using Bubble Sort algorithm to sort arraylist names in descending order
                    for (int m = 0; m < taxPayerData.size() - 1; m++) {
                        for (int n = 0; n < taxPayerData.size() - m - 1; n++) {
                            temp = taxPayerData.get(n).getTestName();
                            temp2 = taxPayerData.get(n + 1).getTestName();
                            //comparing two names 
                            compare = temp.compareTo(temp2);

                            if (compare < 0) {
                                //using temporary variables to swap data in arraylist
                                tempAge = taxPayerData.get(n).getAge();
                                tempIncome = taxPayerData.get(n).getTaxableIncome();
                                tempTax = taxPayerData.get(n).getTax();
                                tempTaxGroup = taxPayerData.get(n).getGroup();
                                taxPayerData.get(n).setName(temp2);
                                taxPayerData.get(n + 1).setName(temp);
                                //storing exchanged employee information in arraylist
                                taxPayerData.get(n).setValues(taxPayerData.get(n + 1).getAge(), taxPayerData.get(n + 1).getTaxableIncome(), taxPayerData.get(n + 1).getTax(), taxPayerData.get(n + 1).getGroup());
                                taxPayerData.get(n + 1).setValues(tempAge, tempIncome, tempTax, tempTaxGroup);
                            }
                        }
                    }
                    System.out.println("Employee data is sorted in descending order: ");
                    for (Taxpayer obj : taxPayerData)
                        System.out.println("\tName: " + obj.employeeName + " Age: " + obj.age + " Income: " + obj.taxableIncome + " Total Tax: " + obj.totalTax + " Tax Group: " + obj.taxGroup + "\n");
                    break;
                    
                case 7:
                    //ending message
                    System.out.println("\t~~~Thank you from Tanzila Tahera~~~\n\t\tID: 12120827");
                    System.exit(0);
            }
        }
    }
}
