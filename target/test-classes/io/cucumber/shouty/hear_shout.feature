Feature: Shout



  Shouty allows users to "hear" as long as they are enough close each other

  To do:
  - only shout to people within a certain range




# Rule: Shouts could be heard by another people
  Scenario: Listener hears a message
    Given a person named Sean
    And a person named Lucy
    When Sean shouts "free bagels at Sean's"
    Then Lucy hears Sean's message



# Rule: Shouts should only be heard if listener is within range

  Scenario: Listener is within range
    Given the range is 100
    And people are located at
      | name     | Sean | Lucy |
      | location | 0    | 50   |
    When Sean shouts
    Then Lucy hears a shout

# Rule: Listener Should be heard if it is in range
  Scenario: Listener is out of range
    Given the range is 100
    And people are located at
      | name     | Sean | Larry |
      | location | 0    | 150   |
    When Sean shouts
    Then Lucy shouldn't hear a shout


  Scenario: Two shouts
    Given a person named Sean
    And a person named Lucy
    When Sean shouts "free bagels!"
    And Sean shouts "free toast!"
    Then Lucy hears the following message:
      | free bagels! |
      | free toast!  |


# Rule: Maximum length of word is 180 character

  Scenario: Message is too long
    Given a person named Sean
    And a person named Lucy
    When Sean shouts the following
        """
        It's easy to love someone when things
        are wonderful and everything's perfect.
        But to love someone when things are being difficult,
        they aren't perfect, when they are messing up,
        flaws are seen, mistakes are made, I think that what allows you to see how much love is there. anyone can love someone who is doing all right things, being everything you wanted and you need, when they have got all together, but to love someone at their worst when they are broken, when you are willing to stand by them no matter how challenging or difficult things may be. I think that kind of love is more beautiful and meaningful. Thank you for being with me both the times. Thank you for helping me to become better person. I love you Darshan.
        """
    Then Lucy shouldn't hear a shout