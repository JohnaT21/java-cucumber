package io.cucumber.shouty;


import static org.junit.Assert.assertEquals;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;


public class StepDefinitions {
     private Person lucy;
     private Person sean;
    private String messageFromSean;
    private static  final  int defualtLocation = 100;
    private Network network = new Network(defualtLocation);
    private HashMap<String,Person> people = new HashMap<>();
    ArrayList<String> cars = new ArrayList<String>();


    static  class Whereabouts {
        public String name;
        public Integer location;

        public Whereabouts(String name, int location){
            this.location = location;
            this.name = name;
        }
    }

    public Whereabouts define_Where_bouts(Map<String,String> entry){
      return new Whereabouts(entry.get("name"),Integer.parseInt(entry.get("location")));
    }


    @Before
    public void createNetwork(){

        people = new HashMap<>();

    }
    @Given("^the range is (\\d+)$")
    public void lucy_is_located_meters_from_sean( Integer distance) throws  Throwable{
        Network network = new Network(distance);
//         lucy = new Person(network);
//         sean = new Person(network);
//        lucy.moveTo(distance);
//        throw new PendingException(String.format("lucy is  centimeters from Sean ",distance*100));

    }
    @Given("a person named (\\w+)")
    public void a_person_named_lucy(String name){



        people.put(name,new Person(network,0));




    }
    @Given("^people are located at$")
    public void people_are_located_at(@Transpose List<Whereabouts> whereabouts){


        for (Whereabouts whereabout:whereabouts) {
            people.put(whereabout.name, new Person(network, whereabout.location));
        }


    }

    @When("^Sean shouts$")
    public void sean_shouts() {

        people.get("Sean").shout("Hello, World");


    }


    @When("Sean shouts \\\"([^\"]*)\\\"$")
    public  void sean_shouts(String message) throws  Throwable{
        people.get("Lucy").shout(message);
        messageFromSean = message;
        System.out.println(messageFromSean);
        cars.add(messageFromSean);


        System.out.println(cars);

    }

    @When("^Sean shouts the following$")
    public void sean_shouts_the_following(String message) throws Throwable{
        people.get("Sean").shout(message);
        messageFromSean = message;
        System.out.println(messageFromSean);
    }
    @Then("^Lucy hears a shout$")
    public void Lucy_should_hear_a_shout() throws Exception{



        assertEquals(1, people.get("Sean").getMessagesHeardSean(messageFromSean).size());
//        System.out.println(messageFromSean);



    }

    @Then("Lucy shouldn't hear a shout")
    public void Lucy_should_not_hear_a_shout() {



        assertEquals(0, people.get("Sean").getMessagesHeard().size());


    }

    @Then("Lucy hears Sean's message")
    public void lucy_hears_Sean_s_message() throws Throwable {

        assertEquals(messageFromSean, people.get("Lucy").getMessagesHeardLucy(messageFromSean));
        System.out.println("messageFromSean");

        System.out.println(messageFromSean);


    }
    @Then("^Lucy shouldn't hear Sean's message$")
    public void lucy_does_not_hear_Sean_s_message() throws Throwable {

        List<String> headrdByLucy = people.get("Lucy").getMessagesHeard();
        assertThat(headrdByLucy, IsNot.not(messageFromSean));


    }
    private void assertThat(List<String> headrdByLucy, Matcher<String> not) {
    }


    @Then("^Lucy hears the following message:$")

    public void lucy_hears_the_following_message(DataTable expectedMessage){

        String heardv = "";

        int val = cars.size();
        List<List<String>> actualMessage = new ArrayList<List<String>>();
        List<String> heard = people.get("Lucy").getMessagesHeard();
        for (int i=0; i<val;i++) {
            heardv = cars.get(i);
            actualMessage.add(Collections.singletonList(heardv));
            System.out.println(actualMessage);


        }


        expectedMessage.diff(DataTable.create(actualMessage));








    }


}
