## All Armstrong numbers calculator

Briefly, an [Armstrong number](https://en.wikipedia.org/wiki/Narcissistic_number) *"is a number that 
is the sum of its own digits each raised to the power of the number of digits"*.

For example `8208` is an Armstrong number because `8208 = 8^4 + 2^4 + 0^4 + 8^4`. We will say that 
`8208` is a **level-4** A-number and call the power sum of its digits, an **aSum**. Single digit 
numbers are obviously (level-1) Armstrong numbers , all the A-numbers up to level 4 are:
```
    1 2 3 4 5 6 7 8 9 
    153 370 371 407 
    1634 8208 9474
```
There is a finite number of A-numbers, this is because the magnitude of a number grows quicker then 
it's `aSum` so that after certain point, the `aSum` falls behind its number. The largest A-number is 
a level-39ner

The code calculates **all** A-numbers up to level-39 with the following timings:

```
  Level-15 0  sec.   41 numbers
  Level-18 2  sec.   46 numbers
  Level-20 6  sec.   51 numbers
  Level-21 11 sec.   53 numbers
  Level-22 15 sec    53 numbers
  Level-23 21 sec.   58 numbers
  Level-25 46 sec    66 numbers
  Level-39 3518 sec. (58 min) 88 numbers

* On i7-4790K CPU @ 4.00GHz
* Run as:  java -Xmx5g -Xms5g -cp target/armstrong-1.0-SNAPSHOT.jar armstrong.Runner <LEVEL> 
```

#### Optimization

The following optimizations, listed in the order of their impact, are used.

1. A neat insight from this [stackoverflow discussion]( http://stackoverflow.com/questions/35487030/java-fast-way-to-check-if-digits-in-int-are-in-ascending-order), is best demonstrated by an example. 
Looking at `8208 = aSum(8208) = 8^4 + 2^4 + 0^4 + 8^4`, it is clear that the value of `aSum` doesn't
depend on the order of the digits. In other words, all numbers comprised of the digits {0,2,8,8}
will have the same `aSum`. For any **representative** N from the set of numbers comprised of digits 
{0,2,8,8}, N is A-number if and only if `aSum(N) = aSum(aSum(N))`. Therefore, generally, we don't need to 
examine all numbers up to a given `level` but only one representative from every multiset of digits. 
This reduces the search space from `10^39` to about `10^10`.

2. It doesn't really matter which representative we pick, the one with digits in descending order is
reasonably easy to work with, e.g. the representative of `{0,2,8,8}` is `8820`. Instead of filtering
all `10^39` values for representatives, the code builds and discards the representatives dynamically 
so that only relevant values are examined with modest memory requirement ( [a bit more about that tree](TREE.md) ).

3. Obviously the problem can be broken down into parts that can be executed in parallel.

4. Datatypes. The representatives are modeled as byte arrays so that `8820` is `byte[] {8,8,2,0}`
( `BigInteger`s are used to calculate `aSum`s ).

5. Various. For the calculation of `aSums` the powers of `{1..9}` are precomputed and cached.
Instead of checking that `aSum(N) = aSum(aSum(N))` it is cheaper to verify that `aSum(N)` is a permutation 
of the digits of `N` which saves us an extra call to `aSum`. 



