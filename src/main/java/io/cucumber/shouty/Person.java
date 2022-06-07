package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public int getLocation;
    private Network name;
   private Integer locations;

 public Person(
         Network network, Integer location) {
     network = name;
     locations = location;
 }

    public Person(Network network) {
    }


//    public Person(String name) {
//
//    }

    public void moveTo(Integer distance){

    }

    public String shout(String message){

        return message;
    }
    public List<String> getMessagesHeard(){
    List<String> result = new ArrayList<String>();
//    result.add();
        return  result;
    }
    public List<String> getMessagesHeardSean(String message){
        List<String> result = new ArrayList<String>();
    result.add(message);
        return  result;
    }
    public String getMessagesHeardLucy(String message){
        List<String> result = new ArrayList<String>();
        result.add(message);
        return  message;
    }



    public int getLocation() {
     return 3;
    }

    public String hear(String message) {
        return message;
    }

    public String never() {
        return null;
    }
}
