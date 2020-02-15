package DaliyPractice;

import jdk.jfr.BooleanFlag;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Jukebox3 {
    FileReader fileReader;
    BufferedReader reader;
    File file;
    Song songs;
    ArrayList<Song> list = new ArrayList<>();


    public static void main(String[] args) {
        Jukebox3 jukebox3 = new Jukebox3();
        jukebox3.go();
    }

    public void go() {
        getSongs();
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public void getSongs() {
        try {
            file = new File("/Users/mac/Desktop/歌曲2.txt");
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String inf_of_song = null;
            while ((inf_of_song = reader.readLine()) != null) {
                addinf(inf_of_song);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addinf(String song) {
        String[] takens = song.split("/");
        songs = new Song(takens[0], takens[1], takens[2], takens[3]);
        list.add(songs);
    }
}

