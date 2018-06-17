# SNOMED CT Description search API

The API provides the following endpoints and functionality.

* GET /descriptions/search
  * Search and return SNOMED CT descriptions with all RF2 properties
  * Query parameters:
    * term : filter descriptions by their term
    * typeId (optional) : filter descriptions by their typeId

* POST /descriptions/search
  * Same as the GET equivalent, but using HTTP POST and request body (need to provide term and typeId in JSON)


API specifications:
* API filter descriptions by term using the term query parameter
* If the term filter exactly or partially matches a SNOMED CT Description's term, then that is a hit and description gets returned
* When using the term, API returns the score for each response item and orders them in descending order by score
* Exact term matches gets a higher score than partial matches


To demonstrate the functionality, SNOMED CT Descriptions are persisted in the underlying repository before starting the application.

Technologies:
- Java 8
- Spring Boot
- Elasticsearch
- Swagger2

* Running at: http://localhost:8080/
* Swagger - http://localhost:8080/swagger-ui.html#/

API links:
* POST - http://localhost:8080/descriptions/search
* GET - http://localhost:8080/descriptions/search?term=fever&typeId=900000000000003001
