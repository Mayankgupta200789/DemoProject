package companies.axon;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int left = 0,right = s.length() - 1;

        int chance = 0;
        boolean isValid = true;

        while( left < right ) {

            if(s.charAt(left) != s.charAt(right)) {
                chance++;
                right--;
            }else {
                left++;
                right--;
            }

            if(chance > 1 ){
                isValid = false;
            }
        }
        if(isValid) return isValid;
        chance = 0;
        left = 0;right = s.length() - 1;
        isValid = true;
        while( left < right ) {

            if(s.charAt(left) != s.charAt(right)) {
                chance++;
                left++;
            }else {
                left++;
                right--;
            }

            if(chance > 1 ){
                isValid = false;
            }
        }


        return isValid;
    }
}
