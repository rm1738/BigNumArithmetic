import java.util.NoSuchElementException;

// On my honor:

// - I have not used source code obtained from another student,

// or any other unauthorized source, either modified or

// unmodified.

// - All source code and documentation used in my program is

// either my original work, or was derived by me from the

// source code published in the textbook for this course.

// - I have not discussed coding details about this project

// with anyone other than my partner (in the case of a joint

// submission), instructor, ACM/UPE tutors or the TAs assigned

// to this course. I understand that I may discuss the concepts

// of this program with other students, and that another student

// may help me debug my program so long as neither of us writes

// anything during the discussion or modifies any computer file

// during the discussion. I have violated neither the spirit nor

// letter of this restriction

/**
 * 
 * 
 * 
 * @author abdurrehmannauman
 * @author rahulmenon
 *
 * 
 * 
 */
public class LinkedList<N>

{
    private int length;
    private Node<N> head;
    private Node<N> curr;

    @SuppressWarnings("hiding")
    public class Node<N> {
        private N data;
        private Node<N> next;

        /**
         * 
         * @param n
         */
        public Node(N n) {
            data = n;
        }


        /**
         * 
         * @param n
         */
        public void setN(Node<N> n) {
            next = n;
        }


        /**
         * 
         * @return
         */
        public Node<N> next() {
            return next;
        }


        /**
         * 
         * @return
         */
        public N getData() {
            return data;
        }
    }

    /**
     * 
     */
    public LinkedList() {
        head = null;
        length = 0;
    }


    /**
     * 
     * 
     * 
     * @return
     * 
     */
    public int size() {
        return length;
    }


    /**
     * 
     * @return
     */
    public boolean isEmpty() {
        return (length == 0);
    }


    /**
     * 
     * 
     * 
     * @param item
     * 
     */
    public void insert(N item) {
        Node<N> thisone = head;
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.isEmpty()) {
            head = new Node<N>(item);
        }

        else {
            while (thisone.next != null) {
                thisone = thisone.next;
            }
            thisone.setN(new Node<N>(item));
        }
        length++;
    }


    /**
     * 
     */
    public String toString() {
        String end = "{";

        Node<N> current = head;
        while (current != null) {
            end += "" + current.data;
            current = current.next;
            if (current != null) {
                end += ", ";
            }
        }
        end += "}";
        return end;
    }


    /**
     * 
     * 
     * 
     * @param i
     * 
     * @return
     * 
     */
    public N getObjectAtIndex(int i)

    {
        Node<N> thisone = head;
        int indexrightnow = 0;
        N data = null;

        while (thisone != null) {
            if (indexrightnow == i) {
                data = thisone.data;
            }
            indexrightnow++;
            thisone = thisone.next;
        }

        if (data == null) {
            return null;
        }
        return data;
    }


    /**
     * @return head node
     */
    public Node<N> head() {
        return head;
    }


    /**
     * 
     * 
     * 
     * @param check
     * 
     * @return
     * 
     */
    public boolean exists(N check) {
        Node<N> thisone = head;
        while (thisone != null) {
            if (check.equals(thisone.data)) {
                return true;
            }
            thisone = thisone.next;
        }
        return false;
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<N> other = ((LinkedList<N>)obj);
            if (other.size() == this.size()) {
                Node<N> current = head;
                Node<N> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    public void clear() {

        head = null;
        length = 0;

    }


    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<N> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    public void moveToStart() {
        curr = head.next();
    } // Set curr at list start

}
