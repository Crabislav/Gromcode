package gromcode.main.lesson9;

import gromcode.main.lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        Company company = new Company("IBM", "USA");
        //System.out.println(company.countryFounded);
        System.out.println(company.getName());



      //  company.name = "IBM";

        Checker checker = new Checker();
       // System.out.println(checker.checkCompanyName(company.name));
        //System.out.println(checker.companyNameValidatedCount);
    }

}
