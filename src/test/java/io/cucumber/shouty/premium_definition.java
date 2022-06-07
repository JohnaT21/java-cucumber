package io.cucumber.shouty;

import static org.junit.Assert.assertEquals;

class IsItFriday {
    static String isItFriday(String today) {
        return null;
    }
}

public class premium_definition {
    private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_sunday(){
        today = "Sunday";
    }
    @When("^I ask whether it is a friday$")
    public void i_ask_whether_it_is_a_friday(){
       actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer){
        assertEquals(expectedAnswer,actualAnswer);
    }
}
