package src;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // 각종 상수들
    static final int CHECK_SIZE = 75;
    static final int STONE_SIZE = 55;
    static final int BLACK = 1;
    static final int WHITE = -1;

    Color squareColor = new Color(176, 176, 176);

    // 돌 저장하는 배열
    static int[][] stones = new int[8][8];     // [y][x]

    // 흑백 플레이 순서
    static boolean myTurn = false;      // black == false, white == true

    // 이미지 이쁘게 출력하기
    ImageIcon whiteIcon = new ImageIcon("Client/assets/white.png");
    ImageIcon blackIcon = new ImageIcon("Client/assets/black.png");
    Image whiteImageResize, blackImageResize;

    // Press 할 때 사용할 위치좌표
    Point clickPoint = new Point();

    public GamePanel()
    {
        // 이미지 불러오기
        getImage();

        setBounds(50, 50, 600, 600);
        setBackground(new Color(133, 69, 49));

        setLayout(null);

        for(int y = 0 ; y < 8 ; y++)
        {
            for(int x = 0 ; x < 8 ; x++)
            {
                if((x == 3 && y == 3) || (x == 4 && y == 4))
                    stones[y][x] = WHITE;
                else if((x == 4 && y == 3) || (x == 3 && y == 4))
                    stones[y][x] = BLACK;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 게임 판 그리기
        for(int i = 0 ; i < 8 ; i++)
        {
            for(int j = 0 ; j < 8 ; j++)
            {
                g.setColor(squareColor);
                if(i % 2 == 0 && j % 2 != 0)
                    g.fillRect(i * CHECK_SIZE, j * CHECK_SIZE, CHECK_SIZE, CHECK_SIZE);
                else if(i % 2 != 0 && j % 2 == 0)
                    g.fillRect(i * CHECK_SIZE, j * CHECK_SIZE, CHECK_SIZE, CHECK_SIZE);
            }
        }

        // 돌 그리기
        for(int y = 0 ; y < 8 ; y++)
        {
            for(int x = 0 ; x < 8 ; x++)
            {
                switch (stones[y][x]) {
                    case 1 -> g.drawImage(blackImageResize, x * CHECK_SIZE + 10, y * CHECK_SIZE + 10, this);
                    case -1 -> g.drawImage(whiteImageResize, x * CHECK_SIZE + 10, y * CHECK_SIZE + 10, this);
                    default -> {
                    }
                }
            }
        }

    }

    void getImage()
    {
        Image whiteImage = whiteIcon.getImage();
        Image blackImage = blackIcon.getImage();

        whiteImageResize = whiteImage.getScaledInstance(STONE_SIZE, STONE_SIZE, Image.SCALE_SMOOTH);
        blackImageResize = blackImage.getScaledInstance(STONE_SIZE, STONE_SIZE, Image.SCALE_SMOOTH);

        whiteIcon = new ImageIcon(whiteImageResize);
        blackIcon = new ImageIcon(blackImageResize);
    }

}
