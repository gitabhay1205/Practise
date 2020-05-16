package AwsADFS;

import java.util.Map;
import java.util.TreeMap;

public class awsV4AuthTest {
    public static void main(String[] args) {
        String url = "xxxxx-yyyyy-r6nvlhpscgdwms5.ap-northeast-1.es.amazonaws.com/inventory/simple/123";
        
        /**
         * Add host without http or https protocol.
         * You can also add other parameters based on your amazon service requirement.
         * For temporary security credentials we need to include x-amz-security-token in canonical headers
         */
        TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
        awsHeaders.put("host", "xxxxx-yyyyy-r6nvlhpscgdwms5.ap-northeast-1.es.amazonaws.com");
        
        awsV4Auth aWSV4Auth = new awsV4Auth.Builder("exampleKey", "exampleSecret")
                                           .regionName("xx-yy-zzz")
                                           .serviceName("es") // es - elastic search. use your service name
                                           .httpMethodName("GET") //GET, PUT, POST, DELETE, etc...
                                           .canonicalURI("/inventory/simple/123") //end point
                                           .queryParametes(null) //query parameters if any
                                           .awsHeaders(awsHeaders) //aws header parameters
                                           .payload(null) // payload if any
                                           .debug() // turn on the debug mode
                                           .build();
        
        /* Get header calculated for request */
        Map<String, String> header = aWSV4Auth.getHeaders();
        for (Map.Entry<String, String> entrySet : header.entrySet()) {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            
            /* Attach header in your request */
            /* Simple get request */
            //HttpGet httpGet = new HttpGet(url);
            //httpGet.addHeader(key, value);
        }
        // execute httpGet
    }
}
