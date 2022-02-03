# LSN DEV-TEST

## Task1
### Description
The input is a long list of integers. Each number is read as a string - seperated by whitespace `" "`. Next these numbers are added to ArrayList `numbersList` as integers, in order to perform quick operations on them. List `distinctList` contains disctinct elements sorted in ascending order. 
The code output is:
* list of distinct elements sorted in ascending order
* the number of elements in the source
* number of distinct elements
* min and max value

## Task2
### Description
The input is a list of integers. Each number is read as a string - seperated by whitespace `" "`. Next these numbers are added to ArrayList `numbersList` as integers, in order to perform useful operations on them like `add` and `distinct` elements. Having sorted in ascending order list `numbersList`, a dependence can be seen that maximum values in pair can be `6 7`. The searching pairs which sum up to 13 can be limmited to finding matching pairs for numbers not exceeding value of 6. Next number of occurrences each number (up to 6 inclusive) are counted in `occurrences`. Then the existence of pairs for the above numbers is checked.
Output: first number not greater than the second one and lines are sorted in an ascending order.

## Task3                                                                                    
### Description
Input: first line - positive number `n`, next `n` lines contains pairs of positive integers, where each pair identifies a connection between two vertices in a graph. Code checks if numbers are positive (greater than 0). Numbers in each pair are compared with each other and placed in ascending order into nested array  `pairs[num_pair][vertex1, vertex2]`, where `num_pair` is each subsequent pair up to `n`.
Then pairs in array are sorted in ascending order based on the lower (first) value of each pair e.g. before sort: `[[2, 3], [1, 2], [5, 6]]` after sort: `[[1, 2], [2, 3], [5, 6]]`. Having the above array, all vertices are added to lists `vertices1` and `vertices2` (example: vertices1[0] and vertices2[0] is a connection). Next, new graphs are detected. Starting from first pair, if there is connection with another vertex, current graph is enlarge and connection is removed from the lists `vertices1` and `vertices2`. If there is no new connections, but above lists are not empty, `numOfSeparatedGraphs` is incremented and new graph is checked.
Output: answer for the following questions - how many separated graphs are in the input.