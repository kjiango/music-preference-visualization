package prj5;

import student.TestCase;

/**
 * Tests the methods in the DataTally Class
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * 
 * @version 4.26.2017
 */
public class DataTallyTest extends TestCase {

    private DataTally data;


    /**
     * Sets up each method before they are called
     */
    public void setUp() {
        data = new DataTally("SongList2017S.csv", "MusicSurveyData2017S.csv");
    }


    // Methods------------------------------------

    /**
     * Tests the getHobbyList() method
     */
    public void testGetHobbyList() {
        assertEquals(62, data.getHobbyList().size());
    }


    /**
     * Tests the getStateList() method
     */
    public void testGetStateList() {
        assertEquals(62, data.getStateList().size());
    }


    /**
     * Tests the getMajorList() method
     */
    public void testGetMajorList() {
        assertEquals(62, data.getMajorList().size());
    }


    /**
     * Tests the sortByTitle() method
     */
    public void testSortByTitle() {
        data.sortByTitle();
        assertEquals(
            "[Artist: The Beatles Title: All You Need Is Love "
            + "Genre: pop rock Date: 1967]",
            data.getHobbyList().get(0).getSong().toString());
    }


    /**
     * Tests the sortByArtist() method
     */
    public void testSortByArtist() {
        data.sortByArtist();
        assertEquals(
            "[Artist: ABBA Title: Dancing Queen Genre: disco Date: 1976]", data
                .getHobbyList().get(0).getSong().toString());
    }


    /**
     * Tests the sortByGenre() method
     */
    public void testSortByGenre() {
        data.sortByGenre();
        assertEquals(
            "[Artist: LMFAO Title: Party Rock Anthem Genre: EDM Date: 2011]",
            data.getHobbyList().get(0).getSong().toString());
    }


    /**
     * Tests the sortByData() method
     */
    public void testSortByDate() {
        data.sortByDate();
        assertEquals(
            "[Artist: The Doors Title: Light My Fire Genre: rock Date: 1966]",
            data.getHobbyList().get(0).getSong().toString());
    }
}
