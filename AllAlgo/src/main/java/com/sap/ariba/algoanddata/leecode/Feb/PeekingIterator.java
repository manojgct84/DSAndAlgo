package com.sap.ariba.algoanddata.leecode.Feb;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer peek;
    private boolean hasNext;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        advanceIterator();
    }

    private void advanceIterator() {
        if (iterator.hasNext()) {
            peek = iterator.next();
        } else {
            hasNext = false;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = peek;
        advanceIterator();
        return next;
    }
}
