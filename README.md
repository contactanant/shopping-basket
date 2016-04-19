README
======

##shopping-basket

program that takes a basket of items and outputs its total cost.
The basket can contain one or more of the following items: Bananas, Oranges, Apples, Lemons, Peaches

pricingService  can be a cached pricing service,  implementation of pricing service is deemed to be out of scope for the purpose of this test
Mock for pricing service is used for test purpose.

Assumptions
===========
I have chosen to create Enum of various fruits (to keep the solution simple) instead of class hierarchy 
as for the given requirement enum seems to fit for purpose.

Solution is limited to given requirement and no extra feature has been added.  
 
Run test
========

Please use Java 8 

from project root directory 
mvn clean test

Technologies Used
===============
Java 8
Junit 4.12
Mockito 1.9.5
Hamcrest 1.3
Apache Maven 3.3.1

