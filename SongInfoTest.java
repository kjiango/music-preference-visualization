package prj5;

import student.TestCase;

/**
 * Tests the methods in the SongInfo class
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * @version 04/19/2017
 *
 */
public class SongInfoTest extends TestCase {

    private SongInfo info;


    /**
     * Sets up each method before they are called
     */
    public void setUp() {
        info = new SongInfo(new Song("All You Need Is Love", "The Beatles",
            "1967", "pop rock"), "Hobby", new DataList("SongList2017S.csv",
                "MusicSurveyData2017S.csv"));
    }


    // Methods -----------------------------------------------

    /**
     * Tests the getSong() method
     */
    public void testGetSong() {
        Song song = new Song("All You Need Is Love", "The Beatles", "1967",
            "pop rock");
        assertEquals(song.toString(), info.getSong().toString());
    }


    /**
     * Tests the getClassification() method
     */
    public void testGetClassification() {
        assertEquals("Hobby", info.getClassification());
    }


    /**
     * Tests the getHeard() method
     */
    public void testGetHeard() {
        int[] heard = info.getHeard();
        assertEquals(0, heard[0]);
        assertEquals(0, heard[1]);
        assertEquals(0, heard[2]);
        assertEquals(0, heard[3]);
    }


    /**
     * Tests the getLiked() method
     */
    public void testGetLiked() {
        int[] heard = info.getLiked();
        assertEquals(0, heard[0]);
        assertEquals(0, heard[1]);
        assertEquals(0, heard[2]);
        assertEquals(0, heard[3]);
    }


    /**
     * Tests the tallyUp() method
     */
    public void testTallyUp() {
        info.tallyUp();
        int[] heard = info.getHeard();
        int[] heardRatio = info.getHeardRatio();
        int[] likedRatio = info.getLikedRatio();
        assertEquals(25, heard[0]);
        assertEquals(10, heard[1]);
        assertEquals(64, heard[2]);
        assertEquals(55, heard[3]);
        
        info = new SongInfo(new Song("All You Need Is Love", "The Beatles",
            "1967", "pop rock"), "Major", new DataList("SongList2017S.csv",
                "MusicSurveyData2017S.csv"));
        info.tallyUp();
        heard = info.getHeard();
        heardRatio = info.getHeardRatio();
        likedRatio = info.getLikedRatio();
        assertEquals(78, heard[0]);
        assertEquals(22, heard[1]);
        assertEquals(39, heard[2]);
        assertEquals(15, heard[3]);
        info = new SongInfo(new Song("All You Need Is Love", "The Beatles",
            "1967", "pop rock"), "State", new DataList("SongList2017S.csv",
                "MusicSurveyData2017S.csv"));
        info.tallyUp();
        heard = info.getHeard();
        heardRatio = info.getHeardRatio();
        likedRatio = info.getLikedRatio();
        assertEquals(60, heard[0]);
        assertEquals(74, heard[1]);
        assertEquals(11, heard[2]);
        assertEquals(9, heard[3]);

    }


    /**
     * Tests the toString() method
     */
    public void testToString() {
        info.tallyUp();
        assertEquals("song title All You Need Is Love\n"
            + "song artist The Beatles\n" + "song genre pop rock\n"
            + "song year 1967\nheard\nreading67 art67 sports67 music76\n"
            + "likes\nreading58 art59 sports54 music76", info.toString());
    }
}
