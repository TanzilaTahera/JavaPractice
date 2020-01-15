package taxpayertest;

/**
 * Name: Tanzila Tahera
 * ID: 12120827
 * Unit: Introduction to Programming
 * Unit code: COIT20245 
 * Tutor: Aries Tao
 * file name: Taxpayer.java
 */
public class Taxpayer {

    String employeeName;
    int age, taxGroup;
    double taxableIncome;
    double totalTax;
    
    //constructor of this class
    Taxpayer(String employeeName, int age, double taxableIncome, double totalTax, int taxGroup) {
        this.employeeName = employeeName;
        this.age = age;
        this.taxableIncome = taxableIncome;
        this.totalTax = totalTax;
        this.taxGroup = taxGroup;
    }

    //method for calculating total tax amount
    public double calculateTax(double taxableIncome) {
          if (taxableIncome >= 0 && taxableIncome <= 18200) totalTax = 0;
          else if (taxableIncome <= 37000) totalTax = ((taxableIncome - 18200) * (0.19));
          else if (taxableIncome <= 87000) totalTax = (3572 + (taxableIncome - 37000) * (0.325));
          else if (taxableIncome <= 180000) totalTax = (19822 + (taxableIncome - 87000) * (0.37));
          else totalTax = (54097 + (taxableIncome - 180000) * (0.45));
               
          return totalTax;
    }

    //methd to calculate tax group 
    public int getGroupNumber(double taxableIncome) {

        int groupCount = 0;
        
        if (taxableIncome <= 18200) groupCount = 1;
        else if (taxableIncome <= 37000) groupCount = 2;
        else if (taxableIncome <= 87000) groupCount = 3;
        else if (taxableIncome <= 180000) groupCount = 4;
        else groupCount = 5;
        
        return groupCount;
    }

    public String getTestName() {
        return employeeName;
    }

    public int getAge() {
        return age;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public double getTax() {
        return totalTax;
    }

    public int getGroup() {
        return taxGroup;
    }

    public void setName(String sortedName) {
        employeeName = sortedName;
    }

    //this method is used to set values in arraylist after sorting 
    public void setValues(int sortedAge, double sortedTaxableIncome, double sortedTax, int sortedTaxGroup) {
        age = sortedAge;
        taxableIncome = sortedTaxableIncome;
        totalTax = sortedTax;
        taxGroup = sortedTaxGroup;

    }
}
