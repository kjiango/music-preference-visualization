package project5;

public class DataCategory {

    private String hobby;
    private String major;
    private String region;
    private Song song; // do we need this for each person? they can like
                       // multiple songs
    private boolean heard;
    private boolean liked;

    public DataCategory(
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


    public String getHobby() {
        return hobby;
    }


    public String getMajor() {
        return major;
    }


    public String getRegion() {
        return region;
    }


    public Song getSong() {
        return song;
    }


    public boolean getHeard() {
        return heard;
    }


    public boolean getLiked() {
        return liked;
    }
}
