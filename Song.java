package DaliyPractice;

public class Song implements Comparable<Song> {     //响应Sort（）要求，要让Song这个类实现Comparable
    String title;
    String artist;
    String rating;
    String bpm;

    public int compareTo(Song s) {
        return title.compareTo(s.getTittle());       //Comparable这个类很单纯，只有一个方法要覆盖
    }

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTittle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {         //??????
        return artist;
    }
}
