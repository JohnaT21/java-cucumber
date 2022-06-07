package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final List<Person> listener = new ArrayList<>();
    private final int range;

    public Network(Integer rangeV){
        range = rangeV;
    }

    public void subscribe(Person person){listener.add(person);}

    public void broadcast(String message, int shouterLocaion){
        for (Person listener:listener){
            boolean withinRange= (Math.abs(listener.getLocation- shouterLocaion)<=range);
            boolean shortEnough = message.length()<=180;
               if (withinRange && shortEnough){
                   listener.hear(message);
               }

        }
    }

}
