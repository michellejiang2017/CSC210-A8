# A8 DIY SpellChecker

Each student should complete this README individually, even when pair programming.

## Basic Information

Your name: Michelle Jiang

Programming partner name, if any:

Other collaborators, including TAs:

If anyone was particularly helpful, please give them a shout-out here:

## References

Any references or resources used besides JavaDoc and course materials:

https://stackoverflow.com/questions/12940663/does-adding-a-duplicate-value-to-a-hashset-hashmap-replace-the-previous-value

If you used generative AI, how did you use it? What role did it play in your learning?

## Assignment Reflection

Please reflect on your experience with this assignment. Include:

- the benchmark output `Timer.java` reported when benchmarking the `ArrayList`-backed dictionary against the `HashSet`-backed dictionary

contains() benchmark using 99168 words
ListDictionary: 42373601200 ns
HashSetDictionary: 16636900 ns

- what you observed in that benchmark

    - How does `ArrayList.contains(...)` work? How does this affect runtime?

    contains() works by interating through the items in the list and checking if the parameter is equal to the item at that index, then returning true if so and false otherwise. This results in a O(n) runtime. 

    - How does `HashSet.contains(...)` work? How does this affect runtime?

    contains() works by using hashing to go directly to the location where the word should be stored, rather than scanning every element. This results in a O(1) runtime.

    - Why is the runtime of these `contains` tests important for the overall efficiency of a spellchecker?

    A spellchecker will always compare each word with the dictionary using contains, aka it frequently runs the contains() method so the runtime should be fast so that it can be efficient. 

    - Which dictionary implementation will you choose to implement Phase 2?
    I will choose the HashSet implementation! 


- which data structures you chose for the dictionary and near-miss suggestions, and why

    I chose the HashSet implementation for the dictionary because it has a much faster runtime for the contains() method, using constant runtime compared to list's linear runtime. 

- any other important design choices you made

I decided to use silence mode for spellchecker because I didn't like writing more code lmao and I thought it would be good at modularity for the code. 

- what was most challenging or most interesting about the assignment?

I really like file reading and I really liked the validations, even though I found them really challenging. 