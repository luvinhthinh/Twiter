# Twiter

Java version : 17

To build : gradle build <br>
--> this should give you a ./build/libs/demo-0.0.1-SNAPSHOT.jar<br>
<br>
To run   : java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar<br>
<br>
There is a postman collection showing you how to call the api: <br>
- To "twit" new message<br>
    --> accept content and email address<br>
    --> return message id if success<br>
    --> return -1 if error due to : <br>
          . content is empty or length is more than 160 characters<br>
          . invalid email address format<br>
- To react to an existing message<br>
    --> accept email address, message id, and emoji<br>
    --> return reaction id if success<br>
    --> return -1 if error due to : <br>
          . message id does not exist<br>
- To get list of reaction by message id<br>
    --> accept message id<br>
    --> return list of reactions (including email address, message id, and emoji)<br>
    --> return empty list if message id does not exist<br>
