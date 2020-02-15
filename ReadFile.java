package DaliyPractice;
import java.io.*;
public class ReadFile {
    public static void main(String[] args) {
        try{
            File myFile = new File("DailyPracticce.txt");
            FileReader fileReader = new FileReader(myFile);         //"文件"的输入用FileReader
            BufferedReader reader = new BufferedReader(fileReader); //用BufferedReader加强读入速度

            String line = null;                                    //重要！以下是最常见的数据读取方式！
            while ((line = reader.readLine()) != null){            //用while一行一行读，直到没有为止
                System.out.println(line);
            }
            reader.close(); //把数据读取完毕后，别忘了关闭字符流！
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}











