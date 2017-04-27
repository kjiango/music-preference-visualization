package prj5;

import student.TestCase;

/**
 * Tests the methods in the PersonData class
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * @version 04/19/2017
 *
 */

public class PersonDataTest extends TestCase {

    private PersonData data;


    /**
     * Sets up each method before they are called
     */
    public void setUp() {
        data = new PersonData("read", "Computer Science", "Northeast US",
            new Song("Spring Day", "BTS", "02/12/2017", "Kpop"), true, false);
    }


    // Methods -------------------------------------------------

    /**
     * Tests the getHobby() method
     */
    public void testGetHobby() {
        assertEquals("read", data.getHobby());
    }


    /**
     * Tests the getMajor() method
     */
    public void testGetMajor() {
        assertEquals("Computer Science", data.getMajor());
    }


    /**
     * Tests the getRegion() method
     */
    public void testGetRegion() {
        assertEquals("Northeast US", data.getRegion());
    }


    /**
     * Tests the getSong() method
     */
    public void testGetSong() {
        Song song = new Song("Spring Day", "BTS", "02/12/2017", "Kpop");
        assertTrue(song.equals(data.getSong()));
    }


    /**
     * Tests the getHeard() method
     */
    public void testGetHeard() {
        assertTrue(data.getHeard());
    }


    /**
     * Tests the getLiked() method
     */
    public void testGetLiked() {
        assertFalse(data.getLiked());
    }


    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        assertEquals("[Hobby: read Major: Computer Science Region: "
            + "Northeast US Song: [Artist: "
            + "BTS Title: Spring Day Genre: Kpop Date: "
            + "02/12/2017]]", data.toString());
    }

}
