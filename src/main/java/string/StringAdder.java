package string;

/**
 * @Author Mayank Gupta
 * @Date 11/11/16
 */
public class StringAdder {

    public String add(String first, String second ) {


        if( first == null && second == null ){
            return null;
        }
        if( first != null && first.equalsIgnoreCase("")) {
            return second;
        }
        if( second != null && second.equalsIgnoreCase("")){
            return first;
        }

        if((int)(first.charAt(0) - 48) < 0 && (int)(second.charAt(0) - 48) < 0 ) {
            first = first.substring(1,first.length() - 1);
            second = second.substring(1,second.length() - 1);

        } else if( (int)(first.charAt(0) - 48) < 0 || (int)(second.charAt(0) - 48) < 0) {

            if( first.length() > second.length() ) {

                doSubtract(first, second);

            } else {
                doSubtract(second,first);
            }
        }


        String sumString = "";

        if( first.length() >= second.length()) {

            sumString = doAdd(first, second);

        } else {
            sumString = doAdd(second, first);
        }

        if((int)(first.charAt(0) - 48) < 0 && (int)(second.charAt(0) - 48) < 0 ) {
            sumString = "-" + sumString;
        }

        return sumString;
    }

    private void doSubtract(String first, String second) {
        int firstIndex = first.length() - 1;
        int secondIndex = second.length() - 1;
        int result = 0;
        boolean carryFlag = false;

        while(firstIndex >= 0 ||secondIndex >= 0) {

            char firstChar = first.charAt(firstIndex);
            int firstInteger = (int) firstChar - 48;
            int secondInteger = 0;

            if( secondIndex >= 0) {
                char secondChar = second.charAt(secondIndex);
                secondInteger = (int) secondChar - 48;
            }

            if(carryFlag) {

                if (firstInteger > secondInteger) {
                    firstInteger = firstInteger - 1;
                    result = (firstInteger) - secondInteger;
                    carryFlag = false;
                } else {
                    if( firstInteger == 0) {
                        firstInteger = 9;
                    }
                    result = (firstInteger + 10) - secondInteger;
                    carryFlag = true;
                }
            } else {
                if (firstInteger > secondInteger) {

                    result = firstInteger - secondInteger;
                    carryFlag = false;
                } else {
                    result = (firstInteger + 10) - secondInteger;
                    carryFlag = true;
                }
            }

            //92 - 7



            firstIndex--;
            secondIndex--;
        }
    }

    private String doAdd(String first, String second) {

        int firstIndex = first.length() - 1;
        int secondIndex = second.length() - 1;
        int carry = 0;
        String summationString = "";
        while ( firstIndex >= 0 || secondIndex >= 0 ) {

            char firstChar = first.charAt(firstIndex);
            int firstInteger = (int) firstChar - 48;
            int secondInteger = 0;

            if(secondIndex >= 0 ) {
                char secondChar = second.charAt(secondIndex);
                secondInteger = (int) secondChar - 48;
            }

            int result = firstInteger + secondInteger + carry;


            char sum = (char)((result%10) + 48);
            carry = result/10;

            summationString = sum + summationString;
            firstIndex--;
            secondIndex--;

        }
        if( carry != 0 ) {
            summationString = (char)(carry + 48) + summationString;
        }
        return summationString;
    }
}
