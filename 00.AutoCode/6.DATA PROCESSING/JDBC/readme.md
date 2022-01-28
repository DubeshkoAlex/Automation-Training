# JDBC

### Abilities
- Able to connect to databases in Java using JDBC
- Able to create simple SQL queries.
- Able to read/write from/to database.

### Short description
Your domain area is travel agency. You should implement reading/writing from/to Database. You should throw required exceptions based on specification.

Please see readme.md  file in skeleton repository for detailed instructions.

### Detailed instructions
You will have following types of tours:

- Excursion tour.
- Leisure tour.
- Shopping tour.

**1. You are requested to implement reading/writing from/to Database.**

**2. You are requested to use following types of exceptions:**
- `DatabaseConnectionException.java` - in case of error during connection to database. (e.g. wrong jdbc URL is used).
- `DatabaseReadException.java` - in case of any error during reading. (e.g. no required table in database)
- `DatabaseWriteException.java` - in case of any exception during writing. (e.g. trying to write NULL object).
---

###### You are allowed:

- Create new classes.
- Modify classes which are designed for your implementation (marked with throw new `UnsupportedOperationException("You need to implement this logic");`)

###### You are NOT allowed:

- Delete existing classes.
- Delete existing dependencies in `pom.xml`.
- Move existing classes to another package.
---

###### Testing flow:
##### Read
Test will generate test `TravelAgency` and write it into database. Then it will create database reader (your implementation) and read data from DB. Following info will be passed in constructor:
- jdbc URL.

Finally test will compare initial TravelAgency and the agency that was read from database

##### Write
Test will generate test `TravelAgency` object to write into database. Then it will create database writer (your implementation) and write test object into DB. Following info will be passed in constructor:
- jdbc URL.

Then it will read back data from database. Finally test will compare test object with object that was read back from DB.

---
##### Database description
Name of the table to work with is _"tours"_.

Id INT NOT NULL| Price INT | TourDuration INT | TourType VARCHAR(255) |TransportType VARCHAR(255) | MealType VARCHAR(255)
------------ | -------------| -------------| -------------| -------------| -------------| 

To intialize DB driver please use
```
Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
```
