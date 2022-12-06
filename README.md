# 310-Calendar-Project

-------------------------------
# Individual Project - Cris Grace 18768812

### List Of API's used and Their Function

In this Individual project section of this course I have decided to implement 2 features that were not previously present. They are: 

Java Mail - Java Mail is an API that connects to email servers to send and recieve emails. In the case of our project, I used it to implement a notification system which alerts the user of any 'fixed-events' or events that have a fixed spot on the schedule and won't automatically reschedule. It works by connecting to an SMTP server and the program sends mails with messages using this.

API sports - the 'API-sports' API provides the program with data about sports such as team information and game data. In the case of our project we are using it to add sporting events of the user's favorite team(currently only the NFL) directly to the schedule as fixed events and builds the schedule around it. It works by connecting to the API server, reciving a JSON which is then accessed using JSON libraries on Java and the information is assigned to an event object.

