package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DataList<DataCategory> implements Iterable {

    private int size;
    private Node<DataCategory> headNode;


    public void readFile() {
        // TODO
        Scanner survey = new Scanner(new File("input.txt")); // change parameter
        while (survey.hasNextLine()) {
            String line = survey.nextLine();
            String[] lineSplit = line.split(",");
            LinkedList<Song> songList = readSongFile("input.txt1");
            Song [] songArray = (Song[])songList.toArray(); //questionable cast, just to make convenience for going through for loop later
            DataCategory person;
            boolean tempHeard;
            boolean tempLiked;
            int songListCount = 0;
            // check if attributes are blank
            if (lineSplit[3] == null || lineSplit[4] == null
                || lineSplit[5] == null) {
                line = survey.nextLine();
                lineSplit = line.split(",");
            }
            for (int x = 5; x < lineSplit.length - 1; x += 2) // is this
                                                              // right???
            {
                
                tempHeard = (lineSplit[x] == "Yes");
                tempLiked = (lineSplit[x + 1] == "No");
                // person = new DataCategory(lineSplit[3], lineSplit[4],
                // lineSplit[5], /*place song here*/, tempHeard, tempLiked);
                person = new DataCategory(lineSplit[3], lineSplit[4],
                    lineSplit[5], songArray[songListCount], tempHeard,
                    tempLiked);
                songListCount++;

            }
        }
    }


    public LinkedList<Song> readSongFile(String fileName) {
        LinkedList<Song> list = new LinkedList<Song>();
        Scanner songFile;
        try {
            songFile = new Scanner(new File(fileName));
            LinkedList<Song> list = new LinkedList<Song>();
            while (songFile.hasNextLine()) {
                String line = songFile.nextLine();
                String[] lineArray = line.split(",");
                Song temp = new Song(lineArray[0], lineArray[1], lineArray[2],
                    lineArray[3]);
                list.add(temp);
            }
            songFile.close();
            return list;
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }


    private class Node<T> {
        private T data;
        private Node<T> next;


        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }


        public Node getNext() {
            return this.next;
        }


        public T getData() {
            return this.data;
        }
    }

}
