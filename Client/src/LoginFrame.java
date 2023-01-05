import src.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    static final int BTN_SIZE_W = 70;
    static final int BTN_SIZE_H = 25;

    static int myColor = 1;

    private String inputName = "";
    private String inputIP = "";
    private String inputRoom = "";

    JButton loginBtn;

    JLabel nameLabel;
    JLabel ipLabel;
    JLabel roomLabel;
    JTextField nameField;
    JTextField ipField;
    JTextField roomField;

    ButtonGroup colorBtn;
    JRadioButton blackBtn;
    JRadioButton whiteBtn;

    public LoginFrame()
    {
        setSize(350, 220);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addLoginButton();
        addLoginField();
        addColorButton();
    }

    void addLoginButton()
    {
        loginBtn = new JButton("Log In");
        add(loginBtn);

        loginBtn.setBounds(250, 30, 80, 100);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputName = nameField.getText();
                inputIP = ipField.getText();
                inputRoom = roomField.getText();

                setVisible(false);
                ClientRunner clientRunner = new ClientRunner();
                clientRunner.mainRunner();
            }
        });
    }

    void addLoginField()
    {
        nameLabel = new JLabel("Name : ");
        ipLabel = new JLabel("IP : ");
        roomLabel = new JLabel("Room NO : ");

        nameField = new JTextField();
        ipField = new JTextField();
        roomField = new JTextField();

        add(nameLabel);
        add(nameField);
        add(ipLabel);
        add(ipField);
        add(roomLabel);
        add(roomField);

        nameLabel.setBounds(30, 30, 80, 30);
        nameField.setBounds(110, 30, 120, 30);
        ipLabel.setBounds(30, 65, 80, 30);
        ipField.setBounds(110, 65, 120, 30);
        roomLabel.setBounds(30, 100, 80, 30);
        roomField.setBounds(110, 100, 120, 30);
    }

    void addColorButton()
    {
        colorBtn = new ButtonGroup();

        blackBtn = new JRadioButton("Black");
        whiteBtn = new JRadioButton("White");

        colorBtn.add(blackBtn);
        colorBtn.add(whiteBtn);
        add(blackBtn);
        add(whiteBtn);

        blackBtn.setBounds(70, 135, 70, 30);
        whiteBtn.setBounds(180, 135, 70, 30);

        blackBtn.setSelected(true);
        whiteBtn.setSelected(false);

        blackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myColor = 1;
            }
        });
        whiteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myColor = -1;
            }
        });
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputIP() {
        return inputIP;
    }

    public void setInputIP(String inputIP) {
        this.inputIP = inputIP;
    }

    public String getInputRoom() {
        return inputRoom;
    }

    public void setInputRoom(String inputRoom) {
        this.inputRoom = inputRoom;
    }
}
