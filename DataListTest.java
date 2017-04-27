package prj5;


import java.util.LinkedList;
import student.TestCase;

/**
 * Tests all the methods in the DataList class
 * 
 * @author Jack Dong <jack3664>
 * @author Tam Phan <tphan25>
 * @author Kevin Jiang <kjiang>
 * @version 04/19/2017
 *
 */

public class DataListTest extends TestCase {
    
    private DataList list;
    private DataList list2;
    
    /**
     * Sets up each method before they are called
     */
    public void setUp()
    {
        list = new DataList("SongList.csv", "MusicSurveyData.csv");
        list2 = new DataList("SongListTest1.csv", "MusicSurveyDataTest1.csv");
    }
    
    //Methods ---------------------------
    
    /**
     * Tests getSongList() method
     */
    public void testGetSongList()
    {
        LinkedList<Song> newList = list.getSongList();
        assertEquals(59, newList.size());
        LinkedList<Song> newList2 = list2.getSongList();
        assertEquals(5, newList2.size());
    }
    
    /**
     * Tests the getSurveyList() method
     */
    public void testGetSurveyList()
    {
        LinkedList<PersonData> newList = list.getSurveyList();
        LinkedList<PersonData> newList2 = list2.getSurveyList();
        assertEquals(12272, newList.size());
        assertEquals(25, newList2.size());
    }
    
    /**
     * Tests the get count methods
     */
    public void testGetCounts()
    {
        int[] hobby = list.getHobbyCount();
        int[] region = list.getRegionCount();
        int[] major = list.getMajorCount();
        assertEquals(31, hobby[0]);
        assertEquals(157, region[0]);
        assertEquals(115, major[0]);
    }

}
