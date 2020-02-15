package DaliyPractice;

import java.io.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.net.Socket;
import java.util.*;

public class SimpleChatClient {
    JFrame frame;
    JPanel panel;
    JButton button;
    JTextArea textArea;
    JScrollPane scrollPane;
    JTextField textField;
    Socket socket;
    PrintWriter writer;
    InputStreamReader streamReader;
    BufferedReader reader;
    Thread thread;

    public static void main(String[] args) {
        SimpleChatClient simpleChatClient = new SimpleChatClient();
        simpleChatClient.go();
    }

    public void go() {
        frame = new JFrame("Simple Chat Client");
        panel = new JPanel();

        textArea = new JTextArea(15, 50);
        textArea.setLineWrap(true);         //自动换行
        textArea.setWrapStyleWord(true);    //沿单词边缘自动换行
        textArea.setEditable(false);        //不可编辑
        scrollPane = new JScrollPane(textArea);             //重要！别忘了将textArea作为参数赋值给滚动条！
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textField = new JTextField(20);      //别忘了传入参数，代表可输入字符长度

        button = new JButton("send");
        button.addActionListener(new sendbuttonListener());

        panel.add(textArea);
        panel.add(textField);
        panel.add(button);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 500);
        frame.setVisible(true);

        setUpNetworking();

        thread = new Thread(new Incomingreader());
        thread.start();
    }

    public void setUpNetworking() {
        try {                                                  // //这个要try
            socket = new Socket("127.0.0.1", 5000);  //线程的范围：0～65535（2的16次方）
            streamReader = new InputStreamReader(socket.getInputStream());  //
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Networking Established");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class sendbuttonListener implements ActionListener {  //注意，"监视器"需要放置在内部类中
        public void actionPerformed(ActionEvent actionEvent) {   //这个要try
            try {
                writer.println(textField.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            textField.setText("");
            textField.requestFocus();
        }
    }

    public class Incomingreader implements Runnable {             //注意，Thread的任务也要放在内部类中
        public void run() {
            String message;
            try {                                                //这个要try
                while ((message = reader.readLine()) != null) {
                    System.out.println("read" + message);
                    textArea.append(message + "\n");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
