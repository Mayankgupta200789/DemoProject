package companies.doordash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateOrderPath {

    public static void main(String[] args){

        ValidateOrderPath validateOrderPath = new ValidateOrderPath();
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "P2", "D1", "D2")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D1", "P2", "D2")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D2", "D1", "P2")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D2")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "P2")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D1", "D1")));
        System.out.println(validateOrderPath.validateOrders(List.of()));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "P1", "D1")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "P1", "D1", "D1")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D1", "P1")));
        System.out.println(validateOrderPath.validateOrders(Arrays.asList("P1", "D1", "P1", "D1")));

    }

    public boolean validateOrders(List<String> orders) {

        Map<String,Integer> pickUpSequence = new HashMap<>();
        int count = 0;

        for(String order : orders ) {


            if( order != null && order.length() == 2 ) {
                // Cannot have two same pickup orders
                if (order.charAt(0) == 'P' && pickUpSequence.containsKey(order)) {
                    return false;
                } else if (order.charAt(0) == 'P') {
                    pickUpSequence.put(order, pickUpSequence.getOrDefault(order, 0) + 1);
                    count++;
                } else {
                    String result = 'P' + (order.charAt(1) + "");

                    if(order.charAt(0) == 'D' && (!pickUpSequence.containsKey(result) || pickUpSequence.get(result) == 0 )) {
                        return false;
                    } else if( order.charAt(0) == 'D') {
                        pickUpSequence.put(result,pickUpSequence.getOrDefault(result,0) - 1);
                        count--;
                    }
                }
            }
        }

        return count == 0;

    }
}
