package prj5;

/**
 * The song class that stores information about the song
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * @version 04/19/2017
 *
 */
public class Song {
    private String artist;
    private String title;
    private String genre;
    private String date;
    private int[] blankLikedHobbyCount;
    private int[] blankHeardHobbyCount;
    private int[] blankLikedRegionCount;
    private int[] blankHeardRegionCount;
    private int[] blankLikedMajorCount;
    private int[] blankHeardMajorCount;


    /**
     * Constructor for Song class
     * 
     * @param artist
     *            is the name of the artist of song
     * @param title
     *            is the title of the song
     * @param genre
     *            is the genre of the song
     * @param date
     *            is the date song was released
     */
    public Song(String title, String artist, String date, String genre) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;
        blankLikedHobbyCount = new int[4];
        blankLikedRegionCount = new int[4];
        blankLikedMajorCount = new int[4];
        blankHeardRegionCount = new int[4];
        blankHeardHobbyCount = new int[4];
        blankHeardMajorCount = new int[4];
    }


    /**
     * Increments the heard array based on specific hobbies
     * 
     * @param hobby
     *            the hobby associated with the array
     */
    public void hobbyIncrementBlankLiked(String hobby) {
        if (hobby.equals("art")) {
            blankLikedHobbyCount[0]++;
        }
        if (hobby.equals("music")) {
            blankLikedHobbyCount[1]++;
        }
        if (hobby.equals("reading")) {
            blankLikedHobbyCount[2]++;
        }
        if (hobby.equals("sports")) {
            blankLikedHobbyCount[3]++;
        }
    }


    /**
     * Increments the heard array based on specific region
     * 
     * @param region
     *            the region associated with the array
     */
    public void regionIncrementBlankHeard(String region) {
        if (region.equals("Southeast")) {
            blankHeardRegionCount[0]++;
        }
        if (region.equals("Northeast")) {
            blankHeardRegionCount[1]++;
        }
        if (region.equals(
            "United States (other than Southeast or Northwest)")) {
            blankHeardRegionCount[2]++;
        }
        if (region.equals("Outside of United States")) {
            blankHeardRegionCount[3]++;
        }
    }


    /**
     * Increments the Liked array based on specific region
     * 
     * @param region
     *            the region associated with the array
     */
    public void regionIncrementBlankLiked(String region) {
        if (region.equals("Southeast")) {
            blankLikedRegionCount[0]++;
        }
        if (region.equals("Northeast")) {
            blankLikedRegionCount[1]++;
        }
        if (region.equals(
            "United States (other than Southeast or Northwest)")) {
            blankLikedRegionCount[2]++;
        }
        if (region.equals("Outside of United States")) {
            blankLikedRegionCount[3]++;
        }
    }


    /**
     * Increments the heard array based on specific major
     * 
     * @param major
     *            the major associated with the array
     */
    public void majorIncrementBlankHeard(String major) {
        if (major.equals("Computer Science")) {
            blankHeardMajorCount[0]++;
        }
        if (major.equals("Math or CMDA")) {
            blankHeardMajorCount[1]++;
        }
        if (major.equals("Other")) {
            blankHeardMajorCount[2]++;
        }
        if (major.equals("Other Engineering")) {
            blankHeardMajorCount[3]++;
        }
    }


    /**
     * Increments the liked array based on specific major
     * 
     * @param major
     *            the major associated with the array
     */
    public void majorIncrementBlankLiked(String major) {
        if (major.equals("Computer Science")) {
            blankLikedMajorCount[0]++;
        }
        if (major.equals("Math or CMDA")) {
            blankLikedMajorCount[1]++;
        }
        if (major.equals("Other")) {
            blankLikedMajorCount[2]++;
        }
        if (major.equals("Other Engineering")) {
            blankLikedMajorCount[3]++;
        }
    }


    /**
     * Increments the heard array based on specific hobbies
     * 
     * @param hobby
     *            the hobby associated with the array
     */
    public void hobbyIncrementBlankHeard(String hobby) {
        if (hobby.equals("art")) {
            blankHeardHobbyCount[0]++;
        }
        if (hobby.equals("music")) {
            blankHeardHobbyCount[1]++;
        }
        if (hobby.equals("reading")) {
            blankHeardHobbyCount[2]++;
        }
        if (hobby.equals("sports")) {
            blankHeardHobbyCount[3]++;
        }
    }


    /**
     * Returns blankLikedHobbyCount array
     * 
     * @return returns blankLikedHobbyCount
     */
    public int[] getBlankLiked() {
        return blankLikedHobbyCount;
    }


    /**
     * Returns blankHeardHobbyCount array
     * 
     * @return returns blankHeardHobbyCount
     */
    public int[] getBlankHeard() {
        return blankHeardHobbyCount;
    }


    /**
     * Returns blankHeardRegionCount array
     * 
     * @return returns blankHeardRegionCount
     */
    public int[] getRegionBlankHeard() {
        return blankHeardRegionCount;
    }


    /**
     * Returns blankLikedRegionCount array
     * 
     * @return returns blankLikedRegionCount
     */
    public int[] getRegionBlankLiked() {
        return blankLikedRegionCount;
    }


    /**
     * Returns blankHeardMajorCount array
     * 
     * @return return blankHeardMajorCount
     */
    public int[] getMajorBlankHeard() {
        return blankHeardMajorCount;
    }


    /**
     * Returns blankLikedMajorCount array
     * 
     * @return return blankLikedMajorCount
     */
    public int[] getMajorBlankLiked() {
        return blankLikedMajorCount;
    }


    /**
     * Gives the name of artist of song
     * 
     * @return artist name
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Gives the title of the song
     * 
     * @return song title
     */
    public String getTitle() {
        return title;
    }


    /**
     * Gives genre of song
     * 
     * @return genre of song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Gives release date of song
     * 
     * @return date of song
     */
    public String getDate() {
        return date;
    }


    /**
     * Returns the song class as a string with it's artist, title,
     * genre, and date fields
     * 
     * @return returns the string of the class
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("Artist: ");
        builder.append(artist);
        builder.append(" Title: ");
        builder.append(title);
        builder.append(" Genre: ");
        builder.append(genre);
        builder.append(" Date: ");
        builder.append(date);
        builder.append("]");
        return builder.toString();
    }


    /**
     * Checks if the two objects are the same
     * 
     * @return returns true if they have the
     *         same artist, title, genre, and date
     * @param obj
     *            the object to be compared
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        else if (this == obj) {
            return true;
        }
        else {
            return this.toString().equals(((Song)obj).toString());
        }
    }

}
