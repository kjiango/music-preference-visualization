/**
 * 
 */
package prj5;

/**
 * @author Kevin Jiang <kjiang>
 * @author Jack Dong <jack3664>
 * @author Tam Phan <tphan25>
 * 
 * @version 4.25.2017
 */
public class GUIRunner {
    /**
     * Initializes the data
     * 
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        GUIMusicDisplay display = new GUIMusicDisplay(new DataTally(
            "SongList2017S.csv", "MusicSurveyData2017S.csv"));
    }
}
