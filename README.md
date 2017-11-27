# Gilded Rose Kata

This is a 'solution' to the [Gilded Rose Kata](GildedRoseRequirements.txt).

The approach was:

* Add a TextTest as a golden master (this worked really well)
* Add unit tests to understand logic better (didn't make the code safer, could've skipped but felt weird not doing it)
* Refactor to make no nested if statements all with one predicate
* Break code into `Rules` that are constructed by factories
* Add new 'conjured' requirement (TDD style)

This is a fun kata. With a proper nasty starting point.