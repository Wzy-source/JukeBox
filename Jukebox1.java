package DaliyPractice;
import java.util.*;
import java.io.*;
public class Jukebox1 {
    FileReader fileReader;
    BufferedReader reader;
    ArrayList<String> list = new ArrayList<>();
    File file; //File这个类可不能忘


    public static void main(String[] args) {
        Jukebox1 jukebox1 = new Jukebox1();
        jukebox1.go();

    }
    public void go(){
        try {
            file = new File("/Users/mac/Desktop/歌名.txt");
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String name = null;
            while ((name = reader.readLine()) != null){
                addSong(name);

            }
            reader.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println(list);
    }
    void addSong(String name){
        String [] tokens = name.split("/") ;  //注意这个takens，数组的形式和C语言的数组不同！
        list.add(tokens[0]);
    }
}
