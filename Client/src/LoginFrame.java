import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    static final int BTN_SIZE_W = 70;
    static final int BTN_SIZE_H = 25;

    private String inputName = "";
    private String inputIP = "";

    JButton loginBtn;

    JLabel nameLabel;
    JLabel ipLabel;
    JTextField nameField;
    JTextField ipField;

    public LoginFrame()
    {
        setSize(350, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addLoginButton();
        addLoginField();
    }

    void addLoginButton()
    {
        loginBtn = new JButton("Log In");
        add(loginBtn);

        loginBtn.setBounds(250, 30, 80, 70);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputName = nameField.getText();
                inputIP = ipField.getText();

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

        nameField = new JTextField();
        ipField = new JTextField();

        add(nameLabel);
        add(nameField);
        add(ipLabel);
        add(ipField);

        nameLabel.setBounds(30, 30, 80, 30);
        ipLabel.setBounds(30, 65, 80, 30);
        nameField.setBounds(110, 30, 120, 30);
        ipField.setBounds(110, 65, 120, 30);
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
}
