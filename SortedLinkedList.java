package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import bag.Node;

/**
 * Sorts lists of strings
 * 
 * @author Kevin Jiang
 * @author Jack Dong
 * @author Tam Phan
 * 
 * @version 4.19.2017
 */
public class SortedLinkedList implements Iterable<SongInfo> {
    private Node<SongInfo> head;
    private int size;
    private int sortType;


    /**
     * Constructor with sort as its parameter
     * 
     * @param sortType
     *            Determines which method to sort the list by
     */
    public SortedLinkedList(int sortType) {
        this.head = null;
        this.size = 0;
        this.sortType = sortType;
    }


    /**
     * Adds the the entry to the list based on the sort type
     * 
     * @param entry
     *            the data to be added to the list
     * @return true if adding is successful by sorting it by the sort
     *         by genre, title, artist, or year
     */
    public boolean add(SongInfo entry) {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty()) {
            head = new Node<SongInfo>(entry);
            size++;
            return true;
        }
        if (sortType == 0) {
            addByTitle(entry);
            return true;
        }
        if (sortType == 1) {
            addByArtist(entry);
            return true;
        }
        if (sortType == 2) {
            addByGenre(entry);
            return true;
        }
        else {
            addByDate(entry);
            return true;
        }
    }


    /**
     * adds entry by title
     * 
     * @param entry
     *            the item to be entered
     */
    private void addByTitle(SongInfo entry) {
        Node<SongInfo> curr = head;
        Node<SongInfo> prev = null;
        Node<SongInfo> node = new Node<SongInfo>(entry);
        if (curr.data().getSong().getTitle().compareTo(entry.getSong()
            .getTitle()) > 0) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        while (curr != null && curr.data().getSong().getTitle().compareTo(entry
            .getSong().getTitle()) < 0) {
            prev = curr;
            curr = curr.next();
        }
        if (curr == head) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        node.setNext(curr);
        prev.setNext(node);
        size++;
    }


    /**
     * adds entry by artist
     * 
     * @param entry
     *            the item to be entered
     */
    private void addByArtist(SongInfo entry) {
        Node<SongInfo> curr = head;
        Node<SongInfo> prev = null;
        Node<SongInfo> node = new Node<SongInfo>(entry);
        if (curr.data().getSong().getArtist().compareTo(entry.getSong()
            .getArtist()) > 0) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        while (curr != null && curr.data().getSong().getArtist().compareTo(entry
            .getSong().getArtist()) < 0) {
            prev = curr;
            curr = curr.next();
        }
        if (curr == head) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        node.setNext(curr);
        prev.setNext(node);
        size++;
    }


    /**
     * adds entry by genre
     * 
     * @param entry
     *            the item to be entered
     */
    private void addByGenre(SongInfo entry) {
        Node<SongInfo> curr = head;
        Node<SongInfo> prev = null;
        Node<SongInfo> node = new Node<SongInfo>(entry);
        if (curr.data().getSong().getGenre().compareTo(entry.getSong()
            .getGenre()) > 0) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        while (curr != null && curr.data().getSong().getGenre().compareTo(entry
            .getSong().getGenre()) < 0) {
            prev = curr;
            curr = curr.next();
        }
        if (curr == head) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        node.setNext(curr);
        prev.setNext(node);
        size++;
    }


    /**
     * Adds entry by date
     * 
     * @param entry
     *            the item to be entered
     */
    private void addByDate(SongInfo entry) {
        Node<SongInfo> curr = head;
        Node<SongInfo> prev = null;
        Node<SongInfo> node = new Node<SongInfo>(entry);
        if (curr.data().getSong().getDate().compareTo(entry.getSong()
            .getDate()) > 0) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        while (curr != null && curr.data().getSong().getDate().compareTo(entry
            .getSong().getDate()) < 0) {
            prev = curr;
            curr = curr.next();
        }
        if (curr == head) {
            node.setNext(curr);
            head = node;
            size++;
            return;
        }
        node.setNext(curr);
        prev.setNext(node);
        size++;
    }


    /**
     * @return a string with the entries in the list sorted
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[" + head.data().getSong()
            .toString());
        Node<SongInfo> curr = head;
        for (int i = 1; i < size(); i++) {
            curr = curr.next();
            str = str.append(", " + curr.data().getSong().toString());
        }
        str = str.append("]");
        return str.toString();
    }


    /**
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * @param index
     *            index of the entry in list
     * @return the entry at the given index in the list
     */
    public SongInfo get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<SongInfo> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr.data();
    }


    /**
     * @return the size of the list
     */
    public int size() {
        return size;
    }


    @Override
    public Iterator<SongInfo> iterator() {
        return (Iterator<SongInfo>)new SortedListIterator(this);
    }


    /**
     * Creates iterator for the SortedListIterator
     * 
     * @author Kevin Jiang
     * @version 4.19.2017
     * @param <T>
     *            This is the type of object that this class will store
     */
    private class SortedListIterator implements Iterator<SongInfo> {
        private SortedLinkedList list;
        private int index;


        /**
         * Constructor for the Iterator
         * 
         * @param list
         *            This is the type of object that this class will store
         */
        public SortedListIterator(SortedLinkedList list) {
            this.list = list;
            index = 0;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return True if there are more elements in the list, otherwise false
         */
        @Override
        public boolean hasNext() {
            return list.size() != index;
        }


        /**
         * Gets the next value in the list
         *
         * @return The next value
         * @throws NoSuchElementException
         */
        @Override
        public SongInfo next() {
            if (hasNext()) {
                return list.get(index++);
            }
            throw new NoSuchElementException();
        }
    }
}
