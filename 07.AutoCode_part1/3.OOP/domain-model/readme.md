# Domain model

### Abilities
- Able to create objects in Java.
- Able to work with Java packages.
- Able to work with interfaces.
- Able to refactor code based on specification.

### Short description
Your domain area is Gift Box with candies. You should update code to match specification. After that you should implement required methods in domain area.

Please see readme.md  file in skeleton repository for detailed instructions.


### Detailed instructions

**1. You should put the following classes into package `com.epam.tat.domainmodel.candies`:**
- Candy.
- CandyBase.

**2. You should extend the class `Candy` from `CandyBase`.**

**3. You should implement the following methods in class `Candy`:**
- constructor `Candy` with two parameters `name` as `String`, `weight` as `int`,
- method `getWeight()` which returns class variable 'weight',
- method `setWeight()` which assigns parameter `weight` to class variable `weight`.

**4. You should implement the following interfaces to class `GiftBox`:**
- Finding.
- Sorting.

**5. You should implement the following methods in `GiftBox`:**
- sortCandiesByNameAsc,
- sortCandiesByWeightAsc,
- findCandiesByNameStartedWith,
- findCandiesByWeightInRange.

##### Also read instructions in code attentively.
