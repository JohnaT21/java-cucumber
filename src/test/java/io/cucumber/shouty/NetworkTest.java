package io.cucumber.shouty;


import org.junit.Test;

import java.util.Arrays;

public class NetworkTest {

    private int range = 100;
    private Network network = new Network(range);
    private String message = "Free bagels";

    @Test
    public void broadcasts_a_message_to_a_listener_within_range(){
        int seanLocation = 0;

    }

    @Test
    public void does_not_broadcast_a_message_over_180_character_even_if_listener_is_in_range(){

        int seanLocation =0;
        char[] chars = new char[181];
        Arrays.fill(chars,'x');
        String longMessage = String.valueOf(chars);


//        Person laura = (Person) mock(Person.class);
//        network.subscribe(laura);
//        network.broadcast(longMessage,seanLocation);;

    }

    private Object mock(Class<Person> personClass) {
        return personClass;
    }




}
