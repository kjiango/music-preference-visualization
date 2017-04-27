package prj5;

import student.TestCase;

/**
 * Tests the methods in the song class to make sure
 * they work properly
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * @version 04/19/2017
 *
 */

public class SongTest extends TestCase {

    private Song song;


    /**
     * Sets up each method before they are called
     */
    public void setUp() {
        song = new Song("Spring Day", "BTS", "02/12/2017", "Kpop");
    }


    // Methods -----------------------------------

    /**
     * Tests the getArtist() method
     */
    public void testGetArtist() {
        assertEquals("BTS", song.getArtist());
    }


    /**
     * Tests the getTitle() method
     */
    public void testGetTitle() {
        assertEquals("Spring Day", song.getTitle());
    }


    /**
     * Tests the getGenre() method
     */
    public void testGetGenre() {
        assertEquals("Kpop", song.getGenre());
    }


    /**
     * Tests the getDate() method
     */
    public void testGetDate() {
        assertEquals("02/12/2017", song.getDate());
    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        assertEquals("[Artist: BTS Title: Spring Day Genre: "
            + "Kpop Date: 02/12/2017]", song.toString());
    }


    /**
     * Tests the equals() method
     */
    public void testEquals() {
        Song nullSong = null;
        int random = 0;
        Song sameSong = new Song("Spring Day", "BTS", "02/12/2017", "Kpop");
        Song diffSong = new Song("In Rainy Days", "Beast", "N/A", "Kpop");
        assertTrue(song.equals(song));
        assertFalse(song.equals(nullSong));
        assertFalse(song.equals(random));
        assertTrue(song.equals(sameSong));
        assertFalse(song.equals(diffSong));
    }


    /**
     * Tests all the increment methods
     */
    public void testIncrement() {
        song.hobbyIncrementBlankLiked("art");
        song.hobbyIncrementBlankLiked("music");
        song.hobbyIncrementBlankLiked("reading");
        song.hobbyIncrementBlankLiked("sports");
        song.hobbyIncrementBlankHeard("art");
        song.hobbyIncrementBlankHeard("music");
        song.hobbyIncrementBlankHeard("reading");
        song.hobbyIncrementBlankHeard("sports");
        song.regionIncrementBlankHeard("Southeast");
        song.regionIncrementBlankHeard("Northeast");
        song.regionIncrementBlankHeard(
            "United States (other than Southeast or Northwest)");
        song.regionIncrementBlankLiked("Outside of United States");
        song.regionIncrementBlankLiked("Southeast");
        song.regionIncrementBlankLiked("Northeast");
        song.regionIncrementBlankLiked(
            "United States (other than Southeast or Northwest)");
        song.regionIncrementBlankHeard("Outside of United States");
        song.majorIncrementBlankHeard("Computer Science");
        song.majorIncrementBlankHeard("Math or CMDA");
        song.majorIncrementBlankHeard("Other");
        song.majorIncrementBlankHeard("Other Engineering");
        song.majorIncrementBlankLiked("Computer Science");
        song.majorIncrementBlankLiked("Math or CMDA");
        song.majorIncrementBlankLiked("Other");
        song.majorIncrementBlankLiked("Other Engineering");
        for (int i = 0; i < 4; i++) {
            assertEquals(1, song.getBlankHeard()[i]);
            assertEquals(1, song.getBlankLiked()[i]);
            assertEquals(1, song.getRegionBlankHeard()[i]);
            assertEquals(1, song.getRegionBlankLiked()[i]);
            assertEquals(1, song.getMajorBlankHeard()[i]);
            assertEquals(1, song.getMajorBlankLiked()[i]);
        }
    }

}
