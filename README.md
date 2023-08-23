# WW_DistanceCalculator
This is a java test.

Step 1 
-will be start to create a git repo

Step 2 
-will start to develope calculator by using java spring boot with REST Api.
-one api to calculate by add up 2 distance (yard and meter). The result will show dynamically.

Step 3
-will implement simple exception handling 

Step 4 
-will do simple junit testing.


**Technolody stack use in this module**

Framework: Spring-boot

Java version: 17

Database: Postgres


**Sample Api**

1. URL : localhost:8081/api/ww/calculate

Sample req:
{
  "unit1": "yards",
  "value1": "3",
  "unit2": "meters",
  "value2": "5",
  "sumInUnit": "meters"
}

Sample res:

SUCCESS scenario:

{
    "timestamp": "2023-08-23T14:42:06.4265954",
    "status": "OK",
    "data": {
        "total": "7.74"
    }
}

FAILED scenario:
{
    "timestamp": "2023-08-23T14:42:15.6804267",
    "status": "INTERNAL_SERVER_ERROR",
    "data": "An error occurred: calculateSum.calculateDistanceReqDto.unit1: must not be blank"
}


**Future Improvement**

1. Add more apis with funtion to get the list of formula from db , all CRUD function to handle the formula store in db.
2. Expand the functionality for calculation to accept subtract, multiply and divide.
3. Implement spring security to handle the api filtering.
4. Add table to record the calculation have been make by particular user in order for them to trace back.
5. More complete and detail exception handling.

