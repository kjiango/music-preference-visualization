package prj5;

import student.TestCase;

/**
 * Test cases for SortedLinkedList
 * 
 * @author Kevin Jiang <kjiang>
 * @author Jack Dong <jack3664>
 * @author Tam Phan <tphan25>
 * 
 * @version 04/21/2017
 */
public class SortedLinkedListTest extends TestCase {
    private SortedLinkedList list1;
    private SortedLinkedList list2;
    private SortedLinkedList list3;
    private SortedLinkedList list4;
    private SongInfo info;
    private SongInfo info1;
    private SongInfo info2;


    /**
     * Sets up the variables
     */
    public void setUp() {
        list1 = new SortedLinkedList(2);
        list2 = new SortedLinkedList(0);
        list3 = new SortedLinkedList(1);
        list4 = new SortedLinkedList(3);
        info = new SongInfo(new Song("All You Need Is Love", "The Beatles",
            "1967", "pop rock"), "Hobby", new DataList("SongList.csv",
                "MusicSurveyData.csv"));
        info1 = new SongInfo(new Song("Coolio", "Stuff", "1999", "jazz"),
            "Hobby", new DataList("SongList.csv", "MusicSurveyData.csv"));
        info2 = new SongInfo(new Song("Coolio", "Stuff", "1999", "shit"),
            "Hobby", new DataList("SongList.csv", "MusicSurveyData.csv"));
    }


    /**
     * Tests addByGenre()
     */
    public void testAddByGenre() {
        Exception testnull = null;
        try {
            list1.add(null);
        }
        catch (Exception e) {
            testnull = e;
        }
        assertTrue(testnull instanceof IllegalArgumentException);

        assertEquals(list1.toString(), "[]");
        list1.add(info);
        list1.add(info1);
        list1.add(info2);
        assertEquals(list1.toString(),
            "[[Artist: Stuff Title: Coolio Genre: jazz Date: 1999], "
                + "[Artist: The Beatles Title: All You Need Is "
                + "Love Genre: pop rock Date: 1967],"
                + " [Artist: Stuff Title: Coolio Genre: shit Date: 1999]]");
        assertEquals(list1.get(0).toString(), "song title Coolio"
            + "\nsong artist Stuff" + "\nsong genre jazz" + "\nsong year 1999"
            + "\nheard" + "\nreading0 art0 sports0 music0" + "\nlikes"
            + "\nreading0 art0 sports0 music0");

        Exception testnull1 = null;
        try {
            list1.get(200);
        }
        catch (Exception e) {
            testnull1 = e;
        }
        assertTrue(testnull1 instanceof IndexOutOfBoundsException);

        assertEquals(list1.get(1).toString(), "song title All You Need Is Love"
            + "\nsong artist The Beatles" + "\nsong genre pop rock"
            + "\nsong year 1967" + "\nheard" + "\nreading0 art0 sports0 music0"
            + "\nlikes" + "\nreading0 art0 sports0 music0");
    }


    /**
     * Tests addByTitle()
     */
    public void testAddByTitle() {
        list2.add(info);
        list2.add(info1);
        list2.add(info2);
        assertEquals(list2.toString(),
            "[[Artist: The Beatles Title: All You Need Is Love "
                + "Genre: pop rock Date: 1967], "
                + "[Artist: Stuff Title: Coolio Genre: shit Date: 1999], "
                + "[Artist: Stuff Title: Coolio Genre: jazz Date: 1999]]");
    }


    /**
     * Tests addByArtist()
     */
    public void testAddByArtist() {
        list3.add(info);
        list3.add(info1);
        list3.add(info2);
        assertEquals(list3.toString(),
            "[[Artist: Stuff Title: Coolio Genre: shit Date: 1999],"
                + " [Artist: Stuff Title: Coolio Genre: jazz Date: 1999],"
                + " [Artist: The Beatles Title: All You Need Is "
                + "Love Genre: pop rock Date: 1967]]");
    }


    /**
     * Tests addByDate()
     */
    public void testAddByDate() {
        list4.add(info);
        list4.add(info1);
        list4.add(info2);
        assertEquals(list4.toString(),
            "[[Artist: The Beatles Title: All You Need Is Love"
                + " Genre: pop rock Date: 1967], "
                + "[Artist: Stuff Title: Coolio Genre: shit Date: 1999], "
                + "[Artist: Stuff Title: Coolio Genre: jazz Date: 1999]]");
    }
}
