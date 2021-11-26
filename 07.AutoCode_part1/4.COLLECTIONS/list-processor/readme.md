# List processor

### Abilities
- Able to work with collections in Java.
- Able to work with Java Stream API.

### Short description
Implement functions to process collection. All methods must work with list of String. To facilitate work all string can contain
numbers and letters of the English alphabet in upper or lower case (no special symbols).
In case of incorrect input values or inability to perform an action, the method should throw exception.

Please see readme.md  file in skeleton repository for detailed instructions.


### Detailed instructions
In case of incorrect input values or inability to perform an action, the method should throw the `ListProcessorException.java`
exception.

## String getSecondStringByLength(List<String> list);
Find the second by length string in a list.

*Example*

input:`{"a", "aa", "aaaaa", "aaaa", "aaa"}`

output:`"aaaa"`

## List<String> getSortedListByLength(List<String> list);
Sort list by string length starting from smallest to largest.

*Example*

input:`{"aa", "a", "a3a", "ba1",  "aa33", "Aa3", "aa"}`

output:`{"a", "aa", "aa", "a3a", "ba1", "Aa3", "aa33"}`

## List<String> getSortedListByCountOfVowels(List<String> list);
Sort list by count of vowels in string starting from smallest to largest.
If the number of vowels in several words is the same, the order is alphabetical.
It should also be remembered that 123... < ABC... < abc... accordingly to encoding tables.
Also words with the same alphabetical order should be sorted by length.

*Example #1*

input: `{"Puma1", "Puma"}`

output: `{"Puma", "Puma1"}`

*Example #2*

input: `{"Puma", "Nike", "Timberland", "Adidas"}`

output: `{"Nike", "Puma", "Adidas", "Timberland"}`

## List<String> getSortedListByCountOfConsonants(List<String> list);
Sort list by count of consonants in string.
If the number of consonants in several words is the same, the order is alphabetical.

*Example*

input: `{"Puma", "Nike", "Timberland", "Adidas"}`

output: `{"Nike", "Puma", "Adidas", "Timberland"}`

## List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list);
Change by places first and last symbols in each second string of list.
Note: if the word length is <2, you don't need to do anything with this word. Also you don't need to throw an exception.

*Example*

input: `{"Puma", "Nike", "Timberland", "Adidas"}`

output: `{"Puma", "eikN", "Timberland", "sdidaA"}`

## List<String> reverseStringsOfList(List<String> list);
Reverse strings of list.

*Example*

input: `{"Puma", "Nike", "Timberland", "Adidas"}`

output: `{"amuP", "ekiN", "dnalrebmiT", "sadidA"}`
