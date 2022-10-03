
import java.util.EmptyStackException;

/**
 * Array Based Stack
 * 
 * @param <T>
 * 
 * @author Rahul Menon (rahulmenon)
 * @version 2022.02.21
 */

public class ArrayBasedStack<T> implements StackADT<T> {
    // ~ Fields ................................................................
    private T[] stackArray;
    private int size;
    private int capacity;

    /**
     * 
     * The @SuppressWarnings("unchecked") annotation prevents Eclipse from
     * displaying a warning about the type cast being potentially unsafe.
     * We know that our cast is safe since Object is the root type of the Java
     * class hierarchy,
     * and any Object[] can be used to store instances of any other class.
     * The@SuppressWarnings("unchecked") annotation can be placed above types,
     * fields, constructors, methods, parameters, and local variables.
     * 
     * @param length
     *            length of array
     */

    @SuppressWarnings("unchecked")

    public ArrayBasedStack(int length) {
        this.capacity = length;
        stackArray = (T[])new Object[capacity];
        size = 0;
    }


    /**
     * constructor
     */

    public ArrayBasedStack() {
        this(100);
    }


    /**
     * is Empty Method
     */

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * push method
     */

    public void push(T item) {

        if (size == capacity) {
            this.expandCapacity();
        }

        stackArray[size] = item;
        size++;

    }


    /**
     * contains method
     */

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (stackArray[i].equals(item)) {
                return true;
            }
        }
        return false;

    }


    /**
     * @return size
     * 
     */

    @Override
    public int size() {

        return size;
    }


    /**
     * clear method
     * 
     */

    @Override
    public void clear() {
        int oSize = size;
        for (int i = 0; i < oSize; i++) {
            this.pop();
        }

    }


    /**
     * peek method
     * 
     * 
     */

    @Override
    public T peek() {

        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return stackArray[size - 1];
        }
    }


    /**
     * pop method
     * 
     * @return result
     * 
     */

    @Override
    public T pop() {

        if (this.isEmpty()) {
            throw new EmptyStackException();
        }

        size--;
        return stackArray[size];

    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    /**
     * to Array method
     * 
     * @return copy
     * 
     */

    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }

}
