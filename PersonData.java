package prj5;

/**
 * Stores information about each person's data based
 * on each song
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * @version 04/19/2017
 *
 */
public class PersonData {
    private String hobby;
    private String major;
    private String region;
    private Song song;
    private boolean heard;
    private boolean liked;


    /**
     * Creates a new PersonData object with params from the survey
     * 
     * @param hobby
     *            the hobby from the survey
     * @param major
     *            the major from the survey
     * @param region
     *            the region from the survey
     * @param song
     *            the song from the survey
     * @param heard
     *            whether or not the PersonData has heard the song
     * @param liked
     *            whether or not the PersonData liked the song
     */
    public PersonData(
        String hobby,
        String major,
        String region,
        Song song,
        boolean heard,
        boolean liked) {
        this.hobby = hobby;
        this.major = major;
        this.region = region;
        this.song = song;
        this.heard = heard;
        this.liked = liked;
    }


    /**
     * Returns the hobby
     * 
     * @return returns hobby
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * Returns the major
     * 
     * @return returns major
     */
    public String getMajor() {
        return major;
    }


    /**
     * Returns the region
     * 
     * @return returns region
     */
    public String getRegion() {
        return region;
    }


    /**
     * Returns the song
     * 
     * @return returns song
     */
    public Song getSong() {
        return song;
    }


    /**
     * Returns whether or not this PersonData has heard the song
     * 
     * @return returns true if the PersonData has heard the song
     */
    public boolean getHeard() {
        return heard;
    }


    /**
     * Returns whether or not this PersonData liked the song
     * 
     * @return returns true if the PersonData liked the song
     */
    public boolean getLiked() {
        return liked;
    }


    /**
     * Returns the string form of this PersonData
     * 
     * @return returns hobby, major, region, and song of this PersonData
     *          in string form
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append("Hobby: ");
        builder.append(hobby);
        builder.append(" Major: ");
        builder.append(major);
        builder.append(" Region: ");
        builder.append(region);
        builder.append(" Song: ");
        builder.append(song.toString());
        builder.append("]");
        return builder.toString();
    }
}
