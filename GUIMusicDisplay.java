package prj5;

import java.awt.Color;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Creates the MusicDisplay window for the project
 *
 * @author Kevin Jiang <kjiang>
 * @author Jack Dong <jack3664>
 * @author Tam Phan <tphan25>
 * 
 * @version 04.25.2017
 */

public class GUIMusicDisplay {
    public SortedLinkedList list;
    private int songCount = 0;
    private String current;
    private Window window;
    private Button sortByArtist;
    private Button sortBySongTitle;
    private Button sortByReleaseYear;
    private Button sortByGenre;
    private Button prev;
    private Button next;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button quit;
    private TextShape legendText;
    private TextShape legendTitle;
    private TextShape legendLabel;
    private TextShape start;
    private TextShape dTitle;
    private TextShape subtitle;
    private Shape divider;
    private Shape legend;
    private Shape firstHeard;
    private Shape secondHeard;
    private Shape thirdHeard;
    private Shape fourthHeard;
    private Shape firstLiked;
    private Shape secondLiked;
    private Shape thirdLiked;
    private Shape fourthLiked;
    private DataTally data;


    /**
     * Constructor, creates a new GUI display
     * 
     * @param data
     *            the data to be added into the display
     */
    public GUIMusicDisplay(DataTally data) {
        window = new Window("Music Display");
        this.data = data;
        list = data.getHobbyList();
        start = new TextShape(250, 250, "Select how to represent songs",
            Color.BLUE);
        start.setBackgroundColor(Color.WHITE);

        prev = new Button("<- Prev");
        next = new Button("Next ->");

        sortByArtist = new Button("Sort By Artist");
        sortBySongTitle = new Button("Sort By Song Title");
        sortByReleaseYear = new Button("Sort By Release Year");
        sortByGenre = new Button("Sort By Genre");

        representHobby = new Button("Represent Hobby");
        representMajor = new Button("Represent Major");
        representRegion = new Button("Represent Region");

        quit = new Button("Quit");
        prev.onClick(this, "clickedPrev");
        next.onClick(this, "clickedNext");

        sortByArtist.onClick(this, "clickedSortByArtist");
        sortBySongTitle.onClick(this, "clickedSortBySongTitle");
        sortByReleaseYear.onClick(this, "clickedSortByReleaseYear");
        sortByGenre.onClick(this, "clickedSortByGenre");

        representHobby.onClick(this, "clickedRepresentHobby");
        representMajor.onClick(this, "clickedRepresentMajor");
        representRegion.onClick(this, "clickedRepresentRegion");

        quit.onClick(this, "clickedQuit");

        window.addButton(prev, WindowSide.NORTH);
        window.addButton(sortByArtist, WindowSide.NORTH);
        window.addButton(sortBySongTitle, WindowSide.NORTH);
        window.addButton(sortByReleaseYear, WindowSide.NORTH);
        window.addButton(sortByGenre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.addButton(representHobby, WindowSide.SOUTH);
        window.addButton(representMajor, WindowSide.SOUTH);
        window.addButton(representRegion, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);

        window.addShape(start);
        displayHobbyLegend();
        prev.disable();
        current = "by";
    }


    /**
     * Creates the legend
     * 
     * @param s1
     *            first string
     * @param s2
     *            second string
     * @param s3
     *            third string
     * @param s4
     *            fourth string
     * @param s5
     *            fifth string
     */
    private void drawLegend(
        String s1,
        String s2,
        String s3,
        String s4,
        String s5) {
        legendText = new TextShape(590, 80, s1, Color.PINK);
        legendText.setBackgroundColor(Color.WHITE);
        window.addShape(legendText);
        legendText = new TextShape(590, 100, s2, Color.BLUE);
        legendText.setBackgroundColor(Color.WHITE);
        window.addShape(legendText);
        legendText = new TextShape(590, 120, s3, Color.YELLOW);
        legendText.setBackgroundColor(Color.WHITE);
        window.addShape(legendText);
        legendText = new TextShape(590, 140, s4, Color.GREEN);
        legendText.setBackgroundColor(Color.WHITE);
        window.addShape(legendText);
        legendTitle = new TextShape(600, 170, "Song Title", Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendTitle);
        legendTitle = new TextShape(588, 60, s5);
        legendTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendTitle);
        divider = new Shape(632, 197, 5, 40, Color.BLACK);
        window.addShape(divider);
        legendLabel = new TextShape(590, 210, "Liked", Color.BLACK);
        legendLabel.setBackgroundColor(Color.WHITE);
        window.addShape(legendLabel);
        legendLabel = new TextShape(640, 210, "Heard", Color.BLACK);
        legendLabel.setBackgroundColor(Color.WHITE);
        window.addShape(legendLabel);
        legend = new Shape(580, 40, 110, 200, Color.WHITE);
        window.addShape(legend);
        legend = new Shape(579, 39, 112, 202, Color.BLACK);
        window.addShape(legend);
    }


    /**
     * Displays the hobby legend
     */
    private void displayHobbyLegend() {
        drawLegend("Read", "Art", "Sports", "Music", "Hobby Legend");
    }


    /**
     * Displays the region legend
     */
    private void displayRegionLegend() {
        drawLegend("SE", "NE", "US Other", "Not US", "Region Legend");
    }


    /**
     * Displays the major legend
     */
    private void displayMajorLegend() {
        drawLegend("Comp Sci", "Other Eng", "Math/CMDA", "Other",
            "Major Legend");
    }


    /**
     * Resets the window
     */
    public void clear() {
        window.removeAllShapes();
    }


    /**
     * Exits the program when the exit button is clicked
     * 
     * @param button1
     *            the button associated with clickedQuit
     */
    public void clickedQuit(Button button1) {
        System.exit(0);
    }


    /**
     * Sorts the pages by artist name when clicked
     */
    public void clickedSortByArtist(Button sortByArtist) {
        String legend = legendTitle.getText();
        data.sortByArtist();

        songCount = 0;
        current = "by";
        prev.disable();
        next.enable();
        clear();

        if (legend.equals("Hobby Legend")) {
            list = data.getHobbyList();
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            list = data.getStateList();
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            list = data.getMajorList();
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Sorts the pages by song title when clicked
     */
    public void clickedSortBySongTitle(Button sortBySongTitle) {
        String legend = legendTitle.getText();
        data.sortByTitle();

        songCount = 0;
        current = "by";
        prev.disable();
        next.enable();
        clear();

        if (legend.equals("Hobby Legend")) {
            list = data.getHobbyList();
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            list = data.getStateList();
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            list = data.getMajorList();
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Sorts the pages by release year when clicked
     */
    public void clickedSortByReleaseYear(Button sortByReleaseYear) {
        String legend = legendTitle.getText();
        data.sortByDate();

        songCount = 0;
        current = "year:";
        prev.disable();
        next.enable();
        clear();

        if (legend.equals("Hobby Legend")) {
            list = data.getHobbyList();
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            list = data.getStateList();
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            list = data.getMajorList();
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Sorts the pages by genre when clicked
     */
    public void clickedSortByGenre(Button sortByGenre) {
        String legend = legendTitle.getText();
        data.sortByGenre();

        songCount = 0;
        current = "genre:";
        prev.disable();
        next.enable();
        clear();

        if (legend.equals("Hobby Legend")) {
            list = data.getHobbyList();
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            list = data.getStateList();
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            list = data.getMajorList();
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Creates the window glyphs
     * 
     * @param title
     *            the given title retrieved
     */
    private void drawGraph(String title) {
        int i = songCount;
        int width = 0;
        int height = 0;
        int dividerW = 87;
        int dividerH = 50;
        int heard1 = 0;
        int heard2 = 0;
        int heard3 = 0;
        int heard4 = 0;
        int liked1 = 0;
        int liked2 = 0;
        int liked3 = 0;
        int liked4 = 0;

        while (i < (songCount + 6) && i < list.size()) {
            if (i == (songCount + 3)) {
                height += 150;
                width = 0;
            }
            heard1 = list.get(i).getHeardRatio()[0];
            heard2 = list.get(i).getHeardRatio()[1];
            heard3 = list.get(i).getHeardRatio()[2];
            heard4 = list.get(i).getHeardRatio()[3];
            
            liked1 = list.get(i).getLikedRatio()[0];
            liked2 = list.get(i).getLikedRatio()[1];
            liked3 = list.get(i).getLikedRatio()[2];
            liked4 = list.get(i).getLikedRatio()[3];
            
            divider = new Shape(dividerW + width, dividerH + height, 5, 40,
                Color.BLACK);

            firstHeard = new Shape(dividerW + width + 5, 50 + height, heard1, 10,
                Color.PINK);
            secondHeard = new Shape(dividerW + width + 5, 60 + height, heard2, 10,
                Color.BLUE);
            thirdHeard = new Shape(dividerW + width + 5, 70 + height, heard3, 10,
                Color.YELLOW);
            fourthHeard = new Shape(dividerW + width + 5, 80 + height, heard4, 10,
                Color.GREEN);

            firstLiked = new Shape((dividerW - liked1) + width, 50 + height, liked1, 10,
                Color.PINK);
            secondLiked = new Shape((dividerW - liked2) + width, 60 + height, liked2, 10,
                Color.BLUE);
            thirdLiked = new Shape((dividerW - liked3) + width, 70 + height, liked3, 10,
                Color.YELLOW);
            fourthLiked = new Shape((dividerW - liked4) + width, 80 + height, liked4, 10,
                Color.GREEN);

            String tempTitle = list.get(i).getSong().getTitle();
            dTitle = new TextShape(50 + width, 10 + height, tempTitle);
            dTitle.setBackgroundColor(Color.WHITE);

            if (title.equals("by")) {
                String tempSubtitle = title + " " + list.get(i).getSong()
                    .getArtist();
                subtitle = new TextShape(50 + width, 100 + height,
                    tempSubtitle);
                subtitle.setBackgroundColor(Color.WHITE);
            }
            if (title.equals("genre:")) {
                String tempSubtitle = title + " " + list.get(i).getSong()
                    .getGenre();
                subtitle = new TextShape(50 + width, 100 + height,
                    tempSubtitle);
                subtitle.setBackgroundColor(Color.WHITE);
            }
            if (title.equals("year:")) {
                String tempSubtitle = title + " " + list.get(i).getSong()
                    .getDate();
                subtitle = new TextShape(50 + width, 100 + height,
                    tempSubtitle);
                subtitle.setBackgroundColor(Color.WHITE);
            }
            window.addShape(divider);
            window.addShape(firstHeard);
            window.addShape(secondHeard);
            window.addShape(thirdHeard);
            window.addShape(fourthHeard);
            window.addShape(firstLiked);
            window.addShape(secondLiked);
            window.addShape(thirdLiked);
            window.addShape(fourthLiked);
            window.addShape(dTitle);
            window.addShape(subtitle);

            width += 190;
            i++;
        }
    }


    /**
     * Goes to the next page when next button is clicked
     */
    public void clickedNext(Button next) {
        prev.enable();
        this.clear();

        String legend = legendTitle.getText();

        if (songCount > list.size() - 12) {
            next.disable();
        }
        songCount += 6;

        if (legend.equals("Hobby Legend")) {
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Goes to the previous page when prev button is clicked
     */
    public void clickedPrev(Button prev) {
        String legend = legendTitle.getText();

        next.enable();
        this.clear();

        songCount -= 6;

        if (songCount < 5) {
            prev.disable();
        }
        if (legend.equals("Hobby Legend")) {
            drawGraph(current);
            displayHobbyLegend();
        }
        if (legend.equals("Region Legend")) {
            drawGraph(current);
            displayRegionLegend();
        }
        if (legend.equals("Major Legend")) {
            drawGraph(current);
            displayMajorLegend();
        }
    }


    /**
     * Represents the likes/heard of people by hobbies
     */
    public void clickedRepresentHobby(Button representRegion) {
        this.clear();
        list = data.getHobbyList();
        drawGraph(current);
        displayHobbyLegend();
    }


    /**
     * Represents the likes/heard of people by major
     */
    public void clickedRepresentMajor(Button representMajor) {
        this.clear();
        list = data.getMajorList();
        drawGraph(current);
        displayMajorLegend();
    }


    /**
     * Represents the likes/heard of people by region
     */
    public void clickedRepresentRegion(Button representRegion) {
        this.clear();
        list = data.getStateList();
        drawGraph(current);
        displayRegionLegend();
    }
}
