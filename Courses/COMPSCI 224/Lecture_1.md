
_Can't sort with complexity less than O(nlogn), but we can_

> **Static Predecessor**
1. Contains set of elements
2. Support only one operation i.e., Query Predecessor; pred(z) = max{x belongs to S:x<z}
3. Expecting low space & faster query
4. Static - No Insertions
5. Use Binary Search Tree(Balanced), so we will have complexity of O(logn)

> **Word RAM Model**
1. Items are integers {0, 1, ... , 2<sup>w</sup>-1}
2. w = Word Size & universe u = 2<sup>w</sup>-1
3. Also assume that pointers fit in a word
1. Van Emde Boas Tree - Update/Query = O(logw) for time & O(u) for space; Space can be made O(n) using randomization
2. y-fast tries - Same Bounds
3. Fusion trees - Query = O(log<sub>w</sub>n); Sorting = O(n * SQRT(logn))
4. 