# Text File encryptor

### Abilities
- Able to work with I/O in Java.
- Able to process strings in Java.

### Short description
Your domain area is catalogue of car owners. You should implement following logic in your task:

- Read information about car owners from file.
- Encode information using defined algorithms (to mask sensitive data).
- Write result of encoding to a different file.

Please see readme.md  file in skeleton repository for detailed instructions.

### Detailed instructions
In this task, you need to implement the `SimpleEncryptor.java`.
`SimpleEncryptor` uses `FileDataSource.java` for reading-writing actions. This class also should be implemented.
Input data(inputEndpoint) laid in `src/test/resources/encryptorData/input/inputText.txt`. It is the file with data for encryptor.
outputEndpoint - it should be path to encryptor output. In this file should be placed encrypted results.
The encoder should only encrypt the data, i.e.

___THE FIRST LINE OF THE FILE DOES NOT NEED TO BE ENCRYPTED AND SHOULD NOT BE THE PART OF RESULT FILE!___

The encoder can encrypt data using three algorithms:

### void changeLetters(char oldChar, char newChar);
this method can change letters

_Example:_

input: `I'm 1 of the bEst!`

output: `"I'm 1 of th@ bEst!"`


### void byteEncryption();
this method encodes the specified byte array into a String using the Base64 encoding scheme.(Hint: use `java.util.Base64`)

_Example:_

input: `I'm 1 of the bEst!`

output: `SSdtIDEgb2YgdGhlIGJFc3Qh`


### void rot1();
each letter is replaced with the next one in the alphabet and each number is replaced with the next one after it. All special characters remain unchanged.

_Example:_

rule: `a->b; B->C, z->a, Z->A, 0->1, 9->0`

input: `I'm 1 of the best!`

output: `J'n 2 pg uif cftu!`
