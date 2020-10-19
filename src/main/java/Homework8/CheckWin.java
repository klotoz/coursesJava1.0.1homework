package Homework8;

import javax.swing.*;

public class CheckWin extends JDialog {

    static final int WINDOW_X = 555;
    static final int WINDOW_Y = 300;



    public static void checkH(){

        JFrame frame = new JFrame("Игра закончена");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WINDOW_X, WINDOW_Y);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Вы победитель!");

                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);

        frame.setVisible(true);
    }

    public static void checkAI(){

        JFrame frame = new JFrame("Игра закончена");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WINDOW_X, WINDOW_Y);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Компьютер победил!");

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);

        frame.setVisible(true);
    }

    public static void checkN(){

        JFrame frame = new JFrame("Игра закончена");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WINDOW_X, WINDOW_Y);
        frame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Ничья!");

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.add(label);

        frame.setVisible(true);
    }


}
