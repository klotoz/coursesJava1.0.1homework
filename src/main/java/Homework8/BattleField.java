package Homework8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int gameMode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;
    BufferedImage image = null;
    BufferedImage imageX = null;
    BufferedImage imageO = null;



    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.finishedGame) {
                    Logic.humanTurn(cellX, cellY);
                    //проверить поледил кто нить или нет
                }

                repaint();
            }
        });

    }

    public void startNewGame(int gameMode, int fieldSize, int winningLength) {
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();


        try {
            image = ImageIO.read(new File("C:\\Users\\Workstation\\java2020\\coursesJava1.0.1homework\\src\\main\\java\\Homework8\\fon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, 0, 0, panelWidth, panelHeight, this);

        try {
            imageX = ImageIO.read(new File("C:\\Users\\Workstation\\java2020\\coursesJava1.0.1homework\\src\\main\\java\\Homework8\\krest.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            imageO = ImageIO.read(new File("C:\\Users\\Workstation\\java2020\\coursesJava1.0.1homework\\src\\main\\java\\Homework8\\nol.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }




        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }







        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);

                }
            }
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);

                }
            }
        }



    }

    void drawX(Graphics g, int x, int y) {
        //g.setColor(Color.BLUE);
        //((Graphics2D) g).setStroke(new BasicStroke(5));

        g.drawImage(imageX, x * cellWidth, y * cellHeight, 1 + cellWidth, 1 +cellHeight, null);
        //g.drawLine(x * cellWidth, y * cellHeight,
        //        (x + 1) * cellWidth, (y + 1) * cellHeight);
        //g.drawLine(x * cellWidth, (y + 1) * cellHeight,
        //        (x + 1) * cellWidth, y * cellHeight);

    }

    void drawO(Graphics g, int x, int y) {
        //g.setColor(Color.RED);
        //((Graphics2D) g).setStroke(new BasicStroke(5));
        //g.drawOval(x * cellWidth, y * cellHeight,
        //        cellWidth, cellHeight);

        g.drawImage(imageO, x * cellWidth, y * cellHeight, 1 + cellWidth, 1 +cellHeight, null);
    }



}
