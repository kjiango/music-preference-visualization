package prj5;

import java.util.Iterator;

/**
 * Class that stores all the likes/heard of each song
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * 
 * @version 04/19/2017
 */
public class SongInfo {
    private int[] heard;
    private int[] liked;
    private Song song;
    private String classification;
    private DataList list;
    private int[] hobbyHeardRatio = new int[4]; // art, music, reading, sport
    private int[] majorHeardRatio = new int[4]; // cs, math, other, othereng
    private int[] regionHeardRatio = new int[4]; // se, ne, us, outside
    private int[] hobbyLikedRatio = new int[4]; // art, music, reading, sport
    private int[] majorLikedRatio = new int[4]; // cs, math, other, othereng
    private int[] regionLikedRatio = new int[4]; // se, ne, us, outside


    /**
     * Creates a new SongInfo object
     * 
     * @param song
     *            the song in which heard and liked should be counted
     * @param classification
     *            the category of the user (hobby, major, or state)
     * @param data
     *            the data to be inserted
     */
    public SongInfo(Song song, String classification, DataList data) {
        this.song = song;
        this.classification = classification;
        heard = new int[4];
        liked = new int[4];
        for (int i = 0; i < heard.length; i++) {
            heard[i] = 0;
            liked[i] = 0;
        }
        this.list = data;
    }


    /**
     * Tallies up the heard/likes from the files read in
     * other classes.
     */
    public void tallyUp() {
        Iterator<PersonData> it = list.getSurveyList().iterator();
        if (classification.equals("Hobby")) {
            while (it.hasNext()) {
                PersonData person = it.next();
                switch (person.getHobby()) {
                    case "reading":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[0]++;
                            }
                            if (person.getLiked()) {
                                liked[0]++;
                            }
                        }
                        break;
                    case "art":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[1]++;
                            }

                            if (person.getLiked()) {
                                liked[1]++;
                            }
                        }
                        break;
                    case "sports":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[2]++;
                            }

                            if (person.getLiked()) {
                                liked[2]++;
                            }
                        }
                        break;
                    case "music":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[3]++;
                            }

                            if (person.getLiked()) {
                                liked[3]++;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (classification.equals("Major")) {
            while (it.hasNext()) {
                PersonData person = it.next();
                switch (person.getMajor()) {
                    case "Computer Science":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[0]++;
                            }
                            if (person.getLiked()) {
                                liked[0]++;
                            }
                        }
                        break;
                    case "Other Engineering":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[1]++;
                            }
                            if (person.getLiked()) {
                                liked[1]++;
                            }
                        }
                        break;
                    case "Math or CMDA":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[2]++;
                            }
                            if (person.getLiked()) {
                                liked[2]++;
                            }
                        }
                        break;
                    case "Other":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[3]++;
                            }
                            if (person.getLiked()) {
                                liked[3]++;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if (classification.equals("State")) {
            while (it.hasNext()) {
                PersonData person = it.next();
                switch (person.getRegion()) {
                    case "Southeast":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[0]++;
                            }
                            if (person.getLiked()) {
                                liked[0]++;
                            }
                        }
                        break;
                    case "Northeast":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[1]++;
                            }
                            if (person.getLiked()) {
                                liked[1]++;
                            }
                        }
                        break;
                    case "United States (other than Southeast or Northwest)":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[2]++;
                            }
                            if (person.getLiked()) {
                                liked[2]++;
                            }
                        }
                        break;
                    case "Outside of United States":
                        if (person.getSong().equals(song)) {
                            if (person.getHeard()) {
                                heard[3]++;
                            }
                            if (person.getLiked()) {
                                liked[3]++;
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        for (int x = 0; x <= 3; x++) {
            if (list.getHobbyCount()[x] != 0) {
                hobbyHeardRatio[x] = 100 * heard[x] / (list.getHobbyCount()[x]
                    - song.getBlankHeard()[x]);
                hobbyLikedRatio[x] = 100 * liked[x] / (list.getHobbyCount()[x]
                    - song.getBlankLiked()[x]);
            }
            else {
                hobbyHeardRatio[x] = 0;
                hobbyLikedRatio[x] = 0;
            }
            if (list.getRegionCount()[x] != 0) {
                regionHeardRatio[x] = 100 * heard[x] / (list.getRegionCount()[x]
                    - song.getRegionBlankHeard()[x]);
                regionLikedRatio[x] = 100 * liked[x] / (list.getRegionCount()[x]
                    - song.getRegionBlankLiked()[x]);
            }
            else {
                regionHeardRatio[x] = 0;
                regionLikedRatio[x] = 0;
            }
            if (list.getMajorCount()[x] != 0) {
                majorHeardRatio[x] = 100 * heard[x] / (list.getMajorCount()[x]
                    - song.getMajorBlankHeard()[x]);
                majorLikedRatio[x] = 100 * liked[x] / (list.getMajorCount()[x]
                    - song.getMajorBlankLiked()[x]);
            }
            else {
                majorHeardRatio[x] = 0;
                majorLikedRatio[x] = 0;
            }
        }
    }


    /**
     * Clears up SongInfo when reset is needed.
     */
    public void clear() {
        heard = new int[4];
        liked = new int[4];
        for (int i = 0; i < heard.length; i++) {
            heard[i] = 0;
            liked[i] = 0;
        }
    }


    /**
     * Returns the heard array
     * 
     * @return returns the heard array
     */
    public int[] getHeard() {
        return heard;
    }


    /**
     * Returns the liked array
     * 
     * @return returns the liked array
     */
    public int[] getLiked() {
        return liked;
    }


    /**
     * Returns the song associated with this
     * 
     * @return returns the song
     */
    public Song getSong() {
        return song;
    }


    /**
     * Returns the main classification associated with this
     * 
     * @return returns the classification
     */
    public String getClassification() {
        return classification;
    }


    /**
     * Gives the ratio for the ratio of people hearing out of total
     * 
     * @return People hearing a song ratio
     */
    public int[] getHeardRatio() {
        if (classification.equals("Hobby")) {
            return hobbyHeardRatio;
        }

        if (classification.equals("Major")) {
            return majorHeardRatio;
        }

        return regionHeardRatio;

    }


    /**
     * Gives the ratio for the ratio of people liking out of total
     * 
     * @return People liking a song ratio
     */
    public int[] getLikedRatio() {
        if (classification.equals("Hobby")) {
            return hobbyLikedRatio;
        }

        if (classification.equals("Major")) {
            return majorLikedRatio;
        }

        return regionLikedRatio;

    }


    /**
     * Returns string formatted version of SongInfo counts depending on
     * classification
     * 
     * @return string format of SongInfo's tallyup counts
     */
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("song title " + this.getSong().getTitle() + "\n");
        build.append("song artist " + this.getSong().getArtist() + "\n");
        build.append("song genre " + this.getSong().getGenre() + "\n");
        build.append("song year " + this.getSong().getDate() + "\n");
        if (classification.equals("Hobby")) {
            build.append("heard\n");
            build.append("reading" + hobbyHeardRatio[2] + " art"
                + hobbyHeardRatio[0] + " sports" + hobbyHeardRatio[3] + " music"
                + hobbyHeardRatio[1] + "\n");
            build.append("likes\n");
            build.append("reading" + hobbyLikedRatio[2] + " art"
                + hobbyLikedRatio[0] + " sports" + hobbyLikedRatio[3] + " music"
                + hobbyLikedRatio[1]);
        }
        this.clear();
        return build.toString();

    }

}
