package my.test.samples;

import java.util.HashMap;
import java.util.Map;

public class SampleJavaProject {

  public static void main(String[] args) {

//     =================== Accessing HashMap  ===================
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
    
//  =================== Posting callers method to callee  ===================
    IMethodHolder privateMethodHolder = new IMethodHolder() {
      
      @Override
      public void privateMethodWrapper() {
        new SampleJavaProject().printingMessage();
        
      }
    };
    
    PrivateMethodUser privateMethodUser = new PrivateMethodUser(privateMethodHolder);
    privateMethodUser.privateMethodPrinter();
    /*
    Note : When an class needs to use a method (probably for re-usability or cyclic dependency elimination) an interface can be used to envelop a method and
    post to a class as a parameter. On this occasion PrivateMethodUser will pass the private method printingMessage() a a parameter wrap in a interface IMethodHolder.
    Hence enabling the PrivateMethodUser to obtain access to the callers method by triggering a call privateMethodPrinter();
    */
  }
  
  private void printingMessage(){
    System.out.println("Hello From Main Class");
  }

}
