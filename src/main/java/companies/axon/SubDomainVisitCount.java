package companies.axon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisitCount {


    public static void main(String[] args) {


    }

    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String,Integer> domainCount = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String cpDomain : cpdomains ){

            int k = cpDomain.indexOf(' ');

            int initialN = Integer.parseInt(cpDomain.substring(0,k));

            String inputString = cpDomain.substring(k + 1);

            for(int i = 0; i < inputString.length(); i++ ) {

                if(inputString.charAt(i) == '.') {

                    String value = inputString.substring(i+1);

                    domainCount.put(value, domainCount.getOrDefault(value,0) + initialN);
                }
            }

            domainCount.put(inputString,domainCount.getOrDefault(inputString,0) + initialN);


        }

        for(Map.Entry<String,Integer> entry : domainCount.entrySet()) {

            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;



    }
}
