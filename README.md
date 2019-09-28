# Basic Pair for Java
**A fast and lightweight Pair class for java with no dependencies.**

## Usage
### Template compatible
You can insert whatever classes you want, except for primitive types.

``` Java
Pair<K,V> = new Pair<>();
```

### Sorting
Pair implements the <a href="https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/Comparable.html">Comparable</a> interface, thus enabling sorting. Pair will sort in an ascending order by default.

``` Java
// Initialize an ArrayList of Pairs.
ArrayList<Character, Integer> al = new ArrayList<>(Arrays.asList(
    new Pair<>().put('A', -1),
    new Pair<>().put('B', 101),
    new Pair<>().put('C', 12),
    new Pair<>().put('D', 0)
));

// Easily sort the Pair array.
Collections.sort(al);
```