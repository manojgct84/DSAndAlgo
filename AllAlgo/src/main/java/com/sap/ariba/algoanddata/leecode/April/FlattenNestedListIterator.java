package com.sap.ariba.algoanddata.leecode.April;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 * <p>
 * Implement the NestedIterator class:
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 */

public class FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> nestedStack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        nestedStack = new Stack<>();
        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            nestedStack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? nestedStack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while (!nestedStack.isEmpty()) {
            if (nestedStack.peek().isInteger()) {
                return true;
            } else {
                flattenList(nestedStack.pop().getList());
            }
        }
        return false;
    }
}

