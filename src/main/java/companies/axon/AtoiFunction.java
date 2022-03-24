package companies.axon;

public class AtoiFunction {

    public int myAtoi(String s) {
        s = s.trim();
        if(s == null || s.length() == 0  ) return 0;
        long num = 0;
        int k = 0;

        boolean negativeFlag = false;
        if(s.length() == 1 && ((int)s.charAt(k) < 48 || (int)s.charAt(k) > 57)) return 0;

        if(s.charAt(0) == '-') {
            k = 1;
            negativeFlag = true;
        }

        if(s.charAt(0) == '+') {
            k = 1;
        }

        if((int)s.charAt(k) < 48 || (int)s.charAt(k) > 57 ) return 0;

        for(int i = k ; i < s.length(); i++ ) {



            if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57) {
                num *= 10;
                num += (int)s.charAt(i) - 48;
            } else {
                return !negativeFlag ? (int)num : (int)-num;
            }
            if(num > Integer.MAX_VALUE ) return !negativeFlag ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        }

        return negativeFlag ? (int)-num : (int)num;
    }
}
