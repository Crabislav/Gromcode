package gromcode.main.lesson9.utils;

public class Checker {
    //private
    //default (package-private)
    //protected
    //public
    int companyNameValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
        if (companyNameValidatedCount > 10) {
            return false;
        }
        companyNameValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
