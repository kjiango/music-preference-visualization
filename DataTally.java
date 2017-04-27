/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Creates the class which sorts the lists
 * 
 * @author Kevin Jiang <kjiang>
 * @author Jack Dong <jack3664>
 * @author Tam Phan <tphan25>
 * 
 * @version 04/21/2017
 */
public class DataTally {
    private DataList survey;
    private SortedLinkedList hobbyList;
    private SortedLinkedList stateList;
    private SortedLinkedList majorList;


    /**
     * A constructor that populates the summary lists with the
     * information from the survey
     * 
     * @param songListFile
     *            is the file containing the list of songs
     * @param surveyResponseFile
     *            is the file containing the student
     *            survey responses
     */
    public DataTally(String songListFile, String surveyResponseFile) {
        survey = new DataList(songListFile, surveyResponseFile);
        hobbyList = new SortedLinkedList(0);
        majorList = new SortedLinkedList(0);
        stateList = new SortedLinkedList(0);
        occupy();
    }


    /**
     * Populates the Song Info
     */
    private void occupy() {
        LinkedList<Song> data = survey.getSongList();
        Iterator<Song> iter = data.iterator();
        while (iter.hasNext()) {
            Song song = iter.next();
            SongInfo hobbySummary = new SongInfo(song, "Hobby", survey);
            SongInfo majorSummary = new SongInfo(song, "Major", survey);
            SongInfo stateSummary = new SongInfo(song, "State", survey);

            hobbySummary.tallyUp();
            hobbyList.add(hobbySummary);

            majorSummary.tallyUp();
            majorList.add(majorSummary);

            stateSummary.tallyUp();
            stateList.add(stateSummary);
        }
    }


    /**
     * Retrieves the list of hobbies
     * 
     * @return the list of hobby summaries of each song
     */
    public SortedLinkedList getHobbyList() {
        return hobbyList;
    }


    /**
     * Retrieves the list of states
     * 
     * @return the list of state summaries of each song
     */
    public SortedLinkedList getStateList() {
        return stateList;
    }


    /**
     * Retrieves the list of majors
     * 
     * @return the list of major summaries of each song
     */
    public SortedLinkedList getMajorList() {
        return majorList;
    }


    /**
     * sorts the hobbies, majors, and states by title
     */
    public void sortByTitle() {
        SortedLinkedList list = new SortedLinkedList(0);
        Iterator<SongInfo> iter = hobbyList.iterator();

        while (iter.hasNext()) {
            list.add(iter.next());
        }
        hobbyList = list;

        list = new SortedLinkedList(0);
        iter = majorList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        majorList = list;

        list = new SortedLinkedList(0);
        iter = stateList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        stateList = list;
    }


    /**
     * sorts the hobbies, majors, and states by artists
     */
    public void sortByArtist() {
        SortedLinkedList list = new SortedLinkedList(1);
        Iterator<SongInfo> iter = hobbyList.iterator();

        while (iter.hasNext()) {
            list.add(iter.next());
        }
        hobbyList = list;

        list = new SortedLinkedList(1);
        iter = majorList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        majorList = list;

        list = new SortedLinkedList(1);
        iter = stateList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        stateList = list;
    }


    /**
     * sorts the hobbies, majors, and states by genre
     */
    public void sortByGenre() {
        SortedLinkedList list = new SortedLinkedList(2);
        Iterator<SongInfo> iter = hobbyList.iterator();

        while (iter.hasNext()) {
            list.add(iter.next());
        }
        hobbyList = list;

        list = new SortedLinkedList(2);
        iter = majorList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        majorList = list;

        list = new SortedLinkedList(2);
        iter = stateList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        stateList = list;
    }


    /**
     * sorts the hobbies, majors, and states by date
     */
    public void sortByDate() {
        SortedLinkedList list = new SortedLinkedList(3);
        Iterator<SongInfo> iter = hobbyList.iterator();

        while (iter.hasNext()) {
            list.add(iter.next());
        }
        hobbyList = list;

        list = new SortedLinkedList(3);
        iter = majorList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        majorList = list;

        list = new SortedLinkedList(3);
        iter = stateList.iterator();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        stateList = list;
    }
}
