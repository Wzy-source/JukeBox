package DaliyPractice;
import jdk.jfr.BooleanFlag;

import java.io.*;
import java.util.*;
public class Jukebox2 {
    FileReader fileReader;
    BufferedReader reader;
    ArrayList<String> list = new ArrayList<>();
    File file;

    public static void main(String[] args) {
        Jukebox2 jukebox2 = new Jukebox2();
        jukebox2.go();
    }
    public void go(){
        getSongs();
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public void getSongs(){
        try {
            file = new File("/Users/mac/Desktop/歌名.txt");
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String song = null;
            while ((song = reader.readLine()) != null) {
                addname(song);
            }
            reader.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void addname(String song){
        String [] name = song.split("/");  //注意：String [] name = new String[];是错误的！
        list.add(name[0]);                       //要在第二个[]后面指定数组大小: Dog[] dog = new Dog[7];

    }
}

