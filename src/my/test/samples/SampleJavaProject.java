package my.test.samples;

import java.util.HashMap;
import java.util.Map;

public class SampleJavaProject {

  public static void main(String[] args) {

//     ------------------- Accessing HashMap -------------------
    Map<String,String> dataMap = new HashMap<>();

//    Old Way
    for (String key : dataMap.keySet()) {
      System.out.println(key +" --> " + dataMap.get(key));
    }
    
//    New Way
    for (Map.Entry<String,String> element : dataMap.entrySet()) {
      System.out.println(element.getKey() +" --> " + element.getValue());
    }
//    Note: The new way is much faster in accessing a map
  }

}
