package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Creates the class to read the files
 * 
 * @author Jack Dong <jack3664>
 * @author Kevin Jiang <kjiang>
 * @author Tam Phan <tphan25>
 * 
 * @version 04/19/2017
 */
public class DataList {
    private LinkedList<Song> songList;
    private LinkedList<PersonData> surveyList;
    private int[] hobbyCount = new int[4]; // art, music, reading, sport
    private int[] majorCount = new int[4]; // cs, math, other, othereng
    private int[] regionCount = new int[4]; // se, ne, us, outside


    /**
     * Creates a new DataList object
     * 
     * @param songListFile
     *            the file containing the songs
     * @param musicSurveyFile
     *            the file containing the survey responses
     */
    public DataList(String songListFile, String musicSurveyFile) {
        songList = new LinkedList<Song>();
        surveyList = new LinkedList<PersonData>();
        readSongFile(songListFile);
        readSurveyFile(musicSurveyFile);
    }


    /**
     * Reads the inputed surveyFile
     * 
     * @param fileName
     *            the name of the file
     */
    private void readSurveyFile(String fileName) {
        try {
            Scanner surveyFile = new Scanner(new File(fileName));
            @SuppressWarnings("unused")
            String nextLineT = surveyFile.nextLine();
            if (surveyFile.hasNextLine()) {
                String nextLine = surveyFile.nextLine();
                while (surveyFile.hasNextLine()) {
                    nextLine = surveyFile.nextLine();
                    int index = nextLine.indexOf(",");
                    nextLine = nextLine.substring(index + 1);
                    index = nextLine.indexOf(",");
                    nextLine = nextLine.substring(index + 1);
                    index = nextLine.indexOf(",");
                    String major = nextLine.substring(0, index);
                    nextLine = nextLine.substring(index + 1);
                    index = nextLine.indexOf(",");
                    String region = nextLine.substring(0, index);
                    nextLine = nextLine.substring(index + 1);
                    index = nextLine.indexOf(",");
                    String hobby = nextLine.substring(0, index);
                    nextLine = nextLine.substring(index + 1);
                    int songCount = 0;
                    while (nextLine.length() > 0) {
                        index = nextLine.indexOf(",");
                        String heard = nextLine.substring(0, index);
                        nextLine = nextLine.substring(index + 1);
                        index = nextLine.indexOf(",");
                        String liked;
                        if (index == -1) {
                            liked = nextLine;
                            nextLine = "";
                        }
                        else {
                            liked = nextLine.substring(0, index);
                            nextLine = nextLine.substring(index + 1);
                        }

                        if (heard.length() >= 0) {
                            boolean heardSong = false;
                            boolean likedSong = false;
                            if (heard.equals("Yes")) {
                                heardSong = true;
                            }
                            if (liked.equals("Yes")) {
                                likedSong = true;
                            }
                            if (liked.equals("")) {
                                Song song = songList.get(songCount);
                                song.hobbyIncrementBlankLiked(hobby);
                                song.regionIncrementBlankLiked(region);
                                song.majorIncrementBlankLiked(major);
                            }
                            if (heard.equals("")) {
                                Song song = songList.get(songCount);
                                song.hobbyIncrementBlankHeard(hobby);
                                song.regionIncrementBlankHeard(region);
                                song.majorIncrementBlankHeard(major);
                            }
                            PersonData person = new PersonData(hobby, major,
                                region, songList.get(songCount), heardSong,
                                likedSong);
                            surveyList.add(person);
                        }
                        songCount++;
                    }
                    // if here

                    if (hobby.equals("reading")) {
                        hobbyCount[0]++;
                    }
                    if (hobby.equals("art")) {
                        hobbyCount[1]++;
                    }
                    if (hobby.equals("sports")) {
                        hobbyCount[2]++;
                    }
                    if (hobby.equals("music")) {
                        hobbyCount[3]++;
                    }
                    if (region.equals("Southeast")) {
                        regionCount[0]++;
                    }
                    if (region.equals("Northeast")) {
                        regionCount[1]++;
                    }
                    if (region.equals("United States (other than Southeast "
                        + "or Northwest)")) {
                        regionCount[2]++;
                    }
                    if (region.equals("Outside of United States")) {
                        regionCount[3]++;
                    }
                    if (major.equals("Computer Science")) {
                        majorCount[0]++;
                    }
                    if (major.equals("Other Engineering")) {
                        majorCount[1]++;
                    }
                    if (major.equals("Math or CMDA")) {
                        majorCount[2]++;
                    }
                    if (major.equals("Other")) {
                        majorCount[3]++;
                    }
                }
                surveyFile.close();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Reads the inputed song file
     * 
     * @param fileName
     *            the name of the file to be read
     */
    private void readSongFile(String fileName) {
        try {
            Scanner songFile = new Scanner(new File(fileName));
            if (songFile.hasNextLine()) {
                String line = songFile.nextLine();
                while (songFile.hasNextLine()) {
                    line = songFile.nextLine();
                    String[] lineArray = line.split(",");
                    Song temp = new Song(lineArray[0], lineArray[1],
                        lineArray[2], lineArray[3]);
                    songList.add(temp);
                }
                songFile.close();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Returns the songList
     * 
     * @return returns the songList
     */
    public LinkedList<Song> getSongList() {
        return songList;
    }


    /**
     * Returns the surveyList
     * 
     * @return returns the surveyList
     */
    public LinkedList<PersonData> getSurveyList() {
        return surveyList;
    }


    /**
     * Returns hobby counting array
     * 
     * @return hobbyCount array
     */
    public int[] getHobbyCount() {
        return hobbyCount;
    }


    /**
     * Returns region counting array
     * 
     * @return regionCount array
     */
    public int[] getRegionCount() {
        return regionCount;
    }


    /**
     * Returns major counting array
     * 
     * @return majorCount array
     */
    public int[] getMajorCount() {
        return majorCount;
    }

}
