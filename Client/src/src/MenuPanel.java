package src;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    JPanel blackPanel;
    JLabel blackScore;
    JLabel blackInt;

    JPanel whitePanel;
    JLabel whiteScore;
    JLabel whiteInt;


    ImageIcon turnCheck = new ImageIcon("Client/assets/green.png");
    Image turnCheckResize;
    JLabel blackTurn = new JLabel();
    JLabel whiteTurn = new JLabel();

    JButton resetBtn;

    public MenuPanel()
    {
        setBounds(700, 0, 200, 700);
        setBackground(new Color(133, 129, 129));
        setLayout(null);
        getImage();

        addBlackScorePanel();
        addWhiteScorePanel();
    }

    void addBlackScorePanel()
    {
        blackPanel = new JPanel();
        blackScore = new JLabel("Black");
        blackInt = new JLabel("2");
        blackTurn = new JLabel(new ImageIcon(turnCheckResize));
        blackPanel.setLayout(null);

        add(blackPanel);
        blackPanel.add(blackScore);
        blackPanel.add(blackInt);
        blackPanel.add(blackTurn);

        blackPanel.setBorder(new LineBorder(Color.WHITE, 3, true));

        blackPanel.setBounds(30, 30, 140, 80);
        blackScore.setBounds(15, 5, 60, 35);
        blackInt.setBounds(15, 40, 60, 35);
        blackTurn.setBounds(80, 15, 40, 40);

        blackScore.setForeground(Color.WHITE);
        blackInt.setForeground(Color.WHITE);
        blackScore.setFont(blackScore.getFont().deriveFont(20.0f));
        blackInt.setFont(blackInt.getFont().deriveFont(20.0f));
        blackPanel.setBackground(Color.BLACK);

    }

    void addWhiteScorePanel()
    {
        whitePanel = new JPanel();
        whiteScore = new JLabel("White");
        whiteInt = new JLabel("2");
        whiteTurn = new JLabel(new ImageIcon(turnCheckResize));
        whitePanel.setLayout(null);

        add(whitePanel);
        whitePanel.add(whiteScore);
        whitePanel.add(whiteInt);
        whitePanel.add(whiteTurn);

        whitePanel.setBorder(new LineBorder(Color.BLACK, 3, true));

        whitePanel.setBounds(30, 150, 140, 80);
        whiteScore.setBounds(15, 5, 135, 35);
        whiteInt.setBounds(15, 40, 135, 35);
        whiteTurn.setBounds(80, 15, 40, 40);

        whiteScore.setFont(whiteScore.getFont().deriveFont(20.0f));
        whiteInt.setFont(whiteInt.getFont().deriveFont(20.0f));
        whitePanel.setBackground(Color.WHITE);

        whiteTurn.setVisible(false);
    }

    void getImage()
    {
        Image turnImage = turnCheck.getImage();

        turnCheckResize = turnImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    }
}
