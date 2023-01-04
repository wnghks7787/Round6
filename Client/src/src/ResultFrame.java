package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrame extends JFrame {

    MainFrame mainFrame;
    JLabel textLabel;
    JButton restartBtn;
    JButton endBtn;

    public ResultFrame(MainFrame mainFrame)
    {
        setSize(300, 200);
        setVisible(false);
        setLayout(null);
        setLocationRelativeTo(null);

        this.mainFrame = mainFrame;

        addTextLabel();
        addRestartButton();
        addEndButton();
    }

    public void addTextLabel()
    {
        textLabel = new JLabel();

        add(textLabel);

        textLabel.setBounds(0, 30, 300, 30);
        textLabel.setFont(textLabel.getFont().deriveFont(20.0f));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    public void addRestartButton()
    {
        restartBtn = new JButton("Restart");

        add(restartBtn);

        restartBtn.setBounds(40, 80, 100, 50);

        restartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.reset();
                setVisible(false);
            }
        });
    }

    public void addEndButton()
    {
        endBtn = new JButton("End");

        add(endBtn);

        endBtn.setBounds(160, 80, 100, 50);

        endBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
