Project Title: Barbering shop (Java)

Task: 

Based on your knowledge in loops, conditionals, classes and data structure in Java, create a
program to simulate the barbering shop. Your program will display in the console, the state of the
shop whenever an event is triggered. The user will press the keyboard to trigger an event.


Each time the space key is pressed, your program will generate a random number 'x'
between 0 and 3 inclusive.

If x = 0 : the event is ( -- clientName ), meaning the barber is done trimming the hair
of the current client ( ORDi or VIPi ) seated in the main chair.
If x = 1 : the event is ( ++ VIPi ) meaning a VIP number 'i' has come into the shop and is
seated.

If x = 2 or x = 3 : the event is ( ++ ORDi ) meaning an ordinary client number 'i' has
come into the shop and is seated.

If all the seats are occupied and x > 0 , the event is ( +- clientName ) meaning the
client has come and is gone back.

upon a new simulation, the program will display a new line following this format:
x ---> ( event ) [ sitting order of clients in the shop ]

If the user presses any other character different from the space ' ' , Your program will end.
