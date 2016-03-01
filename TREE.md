## Notes on the representatives tree


We can think of a "number" of length N as a node in a tree. Its children of length N+1 are given by
```java
for (int k = lastDigit(number); k >= 0; k--) {
    String child = number + k; // '+' is append
}
```

A level-2 tree for numbers 1 and 2. looks like this:

![level-2 tree](Tree.png)


Let `S(k,n)` denote the number of nodes in a tree of level-`n` with the root `k`, for example `S(1,3) = 6`
and `S(2,3) = 10`. 

From our example we see that `S(2,3) = S(2,2) + S(1,3)` (the sum of the tree rooted in 22 and the rest
of the the tree). This holds in general so that: 

``` 
S(k,n) = S(k, n-1) + S(k-1,n)
S(0, n) = n
S(k, 1) = 1
```

We have `S(1, 10^39) + ... + S(9, 10^39) = 8_217_822_496`