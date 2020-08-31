package lesson17.homework4;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validate("https://sd.org//"));
        System.out.println(validate("http://sd.org"));
        System.out.println(validate("https://sd.org"));
        System.out.println(validate("sd.org"));
        System.out.println(validate("sd"));
    }

    //the 4th task
    public static boolean validate(String address) {
        if (address == null || address.isEmpty() || address.isBlank()) {
            return false;
        }

        String[] validProtocols = {"https://", "http://"};
        String[] validDomains = {".com", ".org", ".net"};

        boolean hasSpecChar = false;

        int protocolLength = calculateInputLength(validProtocols, address, true);

        if (protocolLength == -1) {
            return false;
        }

        int domainLength = calculateInputLength(validDomains, address, false);

        if (domainLength == -1) {
            return false;
        }

        //special char checking
        char[] addressChars = address.substring(protocolLength, address.length() - domainLength).toCharArray();
        for (char aChar : addressChars) {
            if (!Character.isLetterOrDigit(aChar)) {
                hasSpecChar = true;
            }
        }

        return !hasSpecChar;
    }

    //used at the fourth task
    private static int calculateInputLength(String[] validWords, String address, boolean isProtocol) {
        if (validWords == null || address == null) {
            return -1;
        }

        for (String validWord : validWords) {
            if (isProtocol && address.startsWith(validWord)) {
                return validWord.length();
            }

            if (!isProtocol && address.endsWith(validWord)) {
                return validWord.length();
            }

        }
        return -1;
    }
}
