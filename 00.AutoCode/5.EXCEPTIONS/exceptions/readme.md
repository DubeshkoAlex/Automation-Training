# Exceptions

### Abilities
- Able to handle exceptions.
- Able to implement own exceptions for domain area.

### Short description
Your domain area is Game Room with toys. You should implement methods of game room by specification. Each method should throw requested exceptions in case something goes wrong during execution.

Please see readme.md  file in skeleton repository for detailed instructions.

### Detailed instructions
You need to implement the methods of a client `PlayroomBaseClient.java` which knows how to work with a certain game room.
The client is able to:

- `List<Toy> getAllToys();` - return all toys;
- `List<Toy> getToysByParameter(String parameter, String value);` - return toys by parameter
- `boolean addToy(Toy toy);` - adds a toy and returns true if the action is successful
- `boolean removeToy(Toy toy);` - removes a toy and returns true if the action is successful
- `boolean updateToy(Long id, Toy toy);` - updates a toy and returns true if the action is successful

In case of an error, each of the methods must return a corresponding exception:
* `InitializationException` - an exception for the case when it is impossible to initialize the client.
  E.g. trying to create client with empty collection or with null.

* `GetToysByParameterException` for List<Toy> getToysByParameter(String parameter, String value); method -
  an exception for the case when it is impossible to return a toy;
  E.g. trying to find toys for invalid parameters


  *NOTE:* an exception should not be thrown if there is no such id in the collection. In this case, an empty collection should be returned.

* `AddToyException` for boolean addToy(Toy toy); method - an exception for the case when it is impossible to add a toy to the current data.
  E.g. trying to add a toy with an existing id;

* `UpdateToyException` for boolean updateToy(Long id, Toy toy); method -
  an exception for the case when it is impossible to update a toy.
  E.g. trying to find toy with absent id;

* `RemoveToyException` for boolean removeToy(Toy toy) -
  an exception for the case when it is impossible to remove a toy.
  E.g. trying to remove toy with absent id;

`boolean addToy(Toy toy);`, `boolean updateToy(Long id, Toy toy);` and `boolean removeToy(Toy toy)`
have to return false if we can't perform action due to invalid toy.
Valid toy - a toy with a unique identifier and all fields filled in.
