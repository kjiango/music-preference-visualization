package project5;

public class Song {
    private String artist;
    private String title;
    private String genre;
    private String date; //int or string?
    
    /**
     * Constructor for Song class
     * @param artist is the name of the artist of song
     * @param title is the title of the song
     * @param genre is the genre of the song
     * @param date is the date song was released
     */
    public Song(String artist, String title, String genre, String date)
    {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.date = date;
    }
    /**
     * Gives the name of artist of song
     * @return artist name
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * Gives the title of the song
     * @return song title
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * Gives genre of song
     * @return genre of song
     */
    public String getGenre()
    {
        return genre;
    }
    /**
     * Gives release date of song
     * @return date of song
     */
    public String getDate()
    {
        return date;
    }
    
    public String toString()
    {
        //TODO
        return "";
    }
    
    public boolean equals(Object obj)
    {
        //TODO
        return true;
    }
    
    
    
}
