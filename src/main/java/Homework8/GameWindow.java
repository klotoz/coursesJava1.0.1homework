package Homework8;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 300;
    static final int WINDOW_Y = 200;
    static final int WINDOW_WIDTH = 555;
    static final int WINDOW_HEIGHT = 555;
    Color o = new Color(243, 132, 0);


    private SettingWindow settingWindow;
    private BattleField battleField;

    public GameWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);



        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        settingWindow = new SettingWindow(this);
        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStartGame = new JButton("Start new game");

        panel.add(buttonStartGame);
        buttonStartGame.setBackground(Color.black);
        buttonStartGame.setForeground(Color.WHITE);

        buttonStartGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });



        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        buttonExit.setBackground(o);
        buttonExit.addActionListener(e -> {
            System.exit(0);
        });

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void startNewGame(int gameMode, int fieldSize, int winningLength){
        battleField.startNewGame(gameMode, fieldSize, winningLength);
    }
}
