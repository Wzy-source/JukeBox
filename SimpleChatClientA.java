package DaliyPractice;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//大致步骤：面板（网络+监视器）--
public class SimpleChatClientA {
    JFrame frame;
    JButton button;
    Socket socket;
    JTextField textField;
    PrintWriter writer;
    JPanel panel;


    public static void main(String[] args) {
        SimpleChatClientA simpleChatClientA = new SimpleChatClientA();
        simpleChatClientA.go();
    }

    public void go() {
        frame = new JFrame("Ludicrously Simple Chat Client");
        panel = new JPanel();
        textField = new JTextField(20);     //参数是代表20个字宽
        button = new JButton("send");
        button.addActionListener(new SendButtonListener());
        panel.add(textField);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
        frame.setSize(400, 500);
        setUpNetworking();
    }

    public void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("Network Established");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                writer.println(textField.getText());
                writer.flush();                               //很能说明问题PrintWriter会有一个指定的缓冲区，
            } catch (Exception ex) {                          //每一次try时就都要清空缓冲区并完成写入！！！
                ex.printStackTrace();
            }
            textField.setText("");
            textField.requestFocus();


        }
    }
}