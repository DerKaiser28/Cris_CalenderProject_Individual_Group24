# 310-Calendar-Project

-------------------------------

## About the Project

The project we will be developing for Computer Science 310 is an automated scheduler. The program works by automatically scheduling events or assignments into your schedule. The program does this by taking into account multiple variables and then uses this data to compute and automatically schedule your day. The user also has the option to create a fixed block for events that cannot be moved like plans with friends or business meetings. We chose to make this app a web program to increase compatibility and to enable users across various product ecosystems to use this app. We chose the Waterfall Model, a plan-driven model, that would have separate and distinct phases of specification, development, validation and evolution. The requirements are defined early in the project, which will enable our team to define a project scope and create a complete schedule.

## Features

This application has many features which run individually but the main features are as listed below:

1. Log in: The primary purpose of this application is to help users schedule their week and based on theor to do list, thus we save each user as an indivisual user

2. Scheduling and showing  your weekly activities: The application has a main purpose to schedule your week based on the priority and difficulty. The input provided by the user and based on the patterns we can draw we try shceduling the users week

3. Rescheduling: This is an additional feature, keeping in mind human error or last minute appointments, there is a feature which serves the purpose of rescheduling. 

## Data Flow Diagram Level 0:

> ![Image](/images/DFDL0.png)

##  Data Flow Diagram Leve 1:

> ![Image](/images/DFDL1.png)

## Github Repository :

> Link: https://github.com/COSC310-Team27/310-Calendar-Project

> ![Image](/images/github.png)

### UML Design of the Project 

---------------------------------------------------------------
### Main Classes:
1. EventClass()
2. SchedulingClass()
3. UI/UXClass()
The UI/UXClass has all the user interface components that make the entire calendar scheduling app. It is wrapped into one function that is connected to the wrest on the main classes.
5. DatabaseClass()
6. LoginClass()
The login class is composed of the data query and signup form that will be sent to the database after the button is clicked. It references the main index html in a seperate webpage. 
--------------------------------------------------------
