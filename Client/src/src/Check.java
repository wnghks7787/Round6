package src;

public class Check {

    int x, y;
    int color;

    public Check(int x, int y, int color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public boolean checking()
    {
        boolean check = false;
        boolean[] checkTmp = new boolean[8];

        checkTmp[0] = check_x_left(x, y);
        checkTmp[1] = check_x_right(x, y);
        checkTmp[2] = check_y_up(x, y);
        checkTmp[3] = check_y_down(x, y);
        checkTmp[4] = check_xy_upLeft(x, y);
        checkTmp[5] = check_xy_upRight(x, y);
        checkTmp[6] = check_xy_downLeft(x, y);
        checkTmp[7] = check_xy_downRight(x, y);

        for(int i = 0 ; i < 8 ; i++)
            if(checkTmp[i])
                check = true;

        if(checkTmp[0])
            reverse_x_left();
        if(checkTmp[1])
            reverse_x_right();
        if(checkTmp[2])
            reverse_y_up();
        if(checkTmp[3])
            reverse_y_down();
        if(checkTmp[4])
            reverse_xy_upLeft();
        if(checkTmp[5])
            reverse_xy_upRight();
        if(checkTmp[6])
            reverse_xy_downLeft();
        if(checkTmp[7])
            reverse_xy_downRight();

        return check;
    }

    public boolean check_x_left(int x1, int y1)
    {
        for(int i = x1 - 1 ; i >= 0 ; i--)
        {
            if(GamePanel.stones[y1][i] == 0)
                return false;

            if(GamePanel.stones[y1][i] == color)
            {
                if(i == x1 - 1)
                    return false;
                else
                {
//                    System.out.println("x_left : true");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_x_right(int x1, int y1)
    {
        for(int i = x1 + 1 ; i < 8 ; i++)
        {
            if(GamePanel.stones[y1][i] == 0)
                return false;

            if(GamePanel.stones[y1][i] == color)
            {
                if(i == x1 + 1)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }

    public boolean check_y_up(int x1, int y1)
    {
        for(int i = y1 - 1 ; i >= 0 ; i--)
        {
            if(GamePanel.stones[i][x1] == 0)
                return false;

            if(GamePanel.stones[i][x1] == color)
            {
                if(i == y1 - 1)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }

    public boolean check_y_down(int x1, int y1)
    {
        for(int i = y1 + 1 ; i < 8 ; i++)
        {
            if (GamePanel.stones[i][x1] == 0)
                return false;

            if (GamePanel.stones[i][x1] == color) {
                if (i == y1 + 1)
                    return false;
                else {
//                    System.out.println("y_down : true");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_xy_upLeft(int x1, int y1)
    {
        int i, j;

        for(i = y1 - 1, j = x1 - 1 ; i >= 0 && j >= 0 ; i--, j--)
        {
            if(GamePanel.stones[i][j] == 0)
                return false;

            if(GamePanel.stones[i][j] == color) {
                if(i == y1 - 1 || j == x1 - 1)
                    return false;
                else
                {
//                    System.out.println("xy_upLeft : true");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_xy_upRight(int x1, int y1)
    {
        int i, j;

        for(i = y1 - 1, j = x1 + 1 ; i >= 0 && j < 8 ; i--, j++)
        {
            if(GamePanel.stones[i][j] == 0)
                return false;

            if(GamePanel.stones[i][j] == color) {
                if(i == y1 - 1 || j == x1 + 1)
                    return false;
                else
                {
//                    System.out.println("xy_upRight : true");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_xy_downLeft(int x1, int y1)
    {
        int i, j;

        for(i = y1 + 1, j = x1 - 1 ; i < 8 && j >= 0; i++, j--)
        {
            if(GamePanel.stones[i][j] == 0)
                return false;

            if(GamePanel.stones[i][j] == color)
            {
                if(i == y1 + 1 || y == x1 - 1)
                    return false;
                else
                {
//                    System.out.println("xy_downLeft : true");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check_xy_downRight(int x1, int y1)
    {
        int i, j;

        for(i = y1 + 1, j = x1 + 1 ; i < 8 && j < 8 ; i++, j++)
        {
            if(GamePanel.stones[i][j] == 0)
                return false;

            if(GamePanel.stones[i][j] == color)
            {
                if(i == y1 + 1 || j == x1 + 1)
                    return false;
                else
                {
//                    System.out.println("xy_downRight : true");
                    return true;
                }
            }
        }
        return false;
    }

    public void reverse_x_left()
    {
        for(int i = x - 1 ; i >= 0 ; i--)
        {
            if(GamePanel.stones[y][i] != color)
                GamePanel.stones[y][i] *= (-1);
            else
                return;
        }
    }

    public void reverse_x_right()
    {
        for(int i = x + 1 ; i < 8 ; i++)
        {
            if(GamePanel.stones[y][i] != color)
                GamePanel.stones[y][i] *= (-1);
            else
                return;
        }
    }

    public void reverse_y_up()
    {
        for(int i = y - 1 ; i >= 0 ; i--)
        {
            if(GamePanel.stones[i][x] != color)
                GamePanel.stones[i][x] *= (-1);
            else
                return;
        }
    }

    public void reverse_y_down()
    {
        for(int i = y + 1 ; i < 8 ; i++)
        {
            if(GamePanel.stones[i][x] != color)
                GamePanel.stones[i][x] *= (-1);
            else
                return;
        }
    }

    public void reverse_xy_upLeft()
    {
        int i, j;

        for(i = y - 1, j = x - 1 ; i >= 0 && j >= 0 ; i--, j--)
        {
            if(GamePanel.stones[i][j] != color)
                GamePanel.stones[i][j] *= (-1);
            else
                return;
        }
    }

    public void reverse_xy_upRight()
    {
        int i, j;

        for(i = y - 1, j = x + 1 ; i >= 0 && j < 8 ; i--, j++)
        {
            if(GamePanel.stones[i][j] != color)
                GamePanel.stones[i][j] *= (-1);
            else
                return;
        }
    }

    public void reverse_xy_downLeft()
    {
        int i, j;

        for(i = y + 1, j = x - 1 ; i < 8 && j >= 0 ; i++, j--)
        {
            if(GamePanel.stones[i][j] != color)
                GamePanel.stones[i][j] *= (-1);
            else
                return;
        }
    }

    public void reverse_xy_downRight()
    {
        int i, j;

        for(i = y + 1, j = x + 1 ; i < 8 && j < 8 ; i++, j++)
        {
            if(GamePanel.stones[i][j] != color)
                GamePanel.stones[i][j] *= (-1);
            else
                return;
        }
    }

    public boolean emptyCheck(int myColor)
    {
        boolean[] checkLocation = new boolean[8];
        this.color = myColor;

        for(int y1 = 0 ; y1 < 8 ; y1++)
        {
            for(int x1 = 0 ; x1 < 8 ; x1++)
            {
                if(GamePanel.stones[y1][x1] == 0) {
                    checkLocation[0] = check_x_left(x1, y1);
                    checkLocation[1] = check_x_right(x1, y1);
                    checkLocation[2] = check_y_up(x1, y1);
                    checkLocation[3] = check_y_down(x1, y1);
                    checkLocation[4] = check_xy_upLeft(x1, y1);
                    checkLocation[5] = check_xy_upRight(x1, y1);
                    checkLocation[6] = check_xy_downLeft(x1, y1);
                    checkLocation[7] = check_xy_downRight(x1, y1);

                    for (int i = 0; i < 8; i++) {
                        if (checkLocation[i]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
