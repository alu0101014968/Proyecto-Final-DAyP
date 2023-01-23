package View.CriptoView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;
import java.net.URL;

public abstract class CriptoView extends JFrame {
    private JPanel contentPane;
    public JLabel lblFlag;
    public JPanel panel;
    public JTextPane countryTextfield;
    public JButton findButton;
    public JButton barButton;
    public JButton linebutton;
    public JButton helpButton;
    public JLabel lbUpdate;
    public JPanel panel_1;
    public JLabel lbCoin;
    public JLabel lbmarketrankVlaue;
    public JLabel lbdeveloperValue;
    public JLabel lbCoinpricevalue;
    public JButton updateButton;
    public JPanel graphic1;

    public CriptoView() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Diseño y Patrones 22-23\\Proyecto Final\\src" +
                "\\Images\\logo.png"));
        setTitle("Criptocoin Dashboard");
        this.setLocationRelativeTo(null);
    }

    public abstract void viewType();

    public void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1158, 683);
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.setBackground(SystemColor.textHighlight);
        panel.setBounds(-14, -30, 304, 700);
        contentPane.add(panel);
        panel.setLayout(null);

        countryTextfield = new JTextPane();
        countryTextfield.setBounds(65, 207, 164, 30);
        countryTextfield.setFont(new Font("Roboto", Font.BOLD, 16));
        countryTextfield.setText("Country");
        countryTextfield.setContentType("Country");
        panel.add(countryTextfield);

        findButton = new JButton();
        findButton.setBounds(226, 207, 30, 30);
        findButton.setBackground(SystemColor.textHighlight);

        findButton.setIcon(new ImageIcon("C:\\Users\\crist\\Desktop\\iconos\\ui.png"));
        panel.add(findButton);

        JLabel lblNewLabel = new JLabel("CRIPTO");
        lblNewLabel.setBounds(32, 37, 262, 94);
        lblNewLabel.setForeground(SystemColor.text);
        lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNewLabel.setIcon(new ImageIcon("D:\\logos\\cripto.png"));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
        lblNewLabel_1.setBounds(104, 70, 163, 87);
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 25));
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Choose a coin id to show data");
        lblNewLabel_2.setBounds(32, 152, 262, 56);
        lblNewLabel_2.setForeground(SystemColor.text);
        lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
        panel.add(lblNewLabel_2);

        barButton = new JButton("Bar Diagram");
        barButton.setBounds(42, 398, 235, 38);
        barButton.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(barButton);

        linebutton = new JButton("Line Diagram");
        linebutton.setBounds(42, 317, 235, 38);
        linebutton.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(linebutton);

        helpButton = new JButton("Help");
        helpButton.setBounds(42, 474, 235, 38);
        helpButton.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(helpButton);

        panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.textHighlight);
        panel_1.setBounds(213, 0, 941, 56);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        lbUpdate = new JLabel("Last Update: ");
        lbUpdate.setForeground(SystemColor.text);
        lbUpdate.setFont(new Font("Roboto", Font.BOLD, 14));
        lbUpdate.setBackground(SystemColor.textHighlight);
        lbUpdate.setBounds(77, 10, 300, 47);
        panel_1.add(lbUpdate);

        updateButton = new JButton("");
        updateButton.setIcon(new ImageIcon("D:\\logos\\update2.png"));
        updateButton.setBounds(847, 23, 49, 21);
        panel_1.add(updateButton);

        JLabel lblNewLabel_3_1 = new JLabel("Click to update");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Roboto", Font.BOLD, 14));
        lblNewLabel_3_1.setBackground(SystemColor.textHighlight);
        lblNewLabel_3_1.setBounds(740, 10, 97, 47);
        panel_1.add(lblNewLabel_3_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.text);
        panel_2.setBounds(256, 48, 898, 598);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        graphic1 = new JPanel();
        graphic1.setLayout(null);
        graphic1.setBounds(58, 213, 810, 382);
        panel_2.add(graphic1);

        viewType();

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.text);
        panel_3.setBounds(33, 0, 855, 191);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        lbCoin = new JLabel("Coin");
        lbCoin.setForeground(Color.BLACK);
        lbCoin.setFont(new Font("Roboto", Font.BOLD, 36));
        lbCoin.setBounds(110, 26, 655, 91);
        panel_3.add(lbCoin);

        JLabel lbmarket = new JLabel("Market rank");
        lbmarket.setForeground(Color.BLACK);
        lbmarket.setFont(new Font("Roboto", Font.BOLD, 18));
        lbmarket.setBounds(344, 94, 155, 61);
        panel_3.add(lbmarket);

        lblFlag = new JLabel("");
        lblFlag.setBounds(34, 45, 60, 48);
        panel_3.add(lblFlag);

        lbmarketrankVlaue = new JLabel("New label");
        lbmarketrankVlaue.setFont(new Font("Roboto", Font.BOLD, 14));
        lbmarketrankVlaue.setBounds(344, 151, 89, 31);
        panel_3.add(lbmarketrankVlaue);

        JLabel lbDeveloper = new JLabel("Developer Score");
        lbDeveloper.setForeground(Color.BLACK);
        lbDeveloper.setFont(new Font("Roboto", Font.BOLD, 18));
        lbDeveloper.setBounds(655, 94, 155, 69);
        panel_3.add(lbDeveloper);

        lbdeveloperValue = new JLabel("New label");
        lbdeveloperValue.setFont(new Font("Roboto", Font.BOLD, 14));
        lbdeveloperValue.setBounds(655, 159, 82, 22);
        panel_3.add(lbdeveloperValue);

        JLabel lbcoinprice = new JLabel("Value (euros)");
        lbcoinprice.setForeground(Color.BLACK);
        lbcoinprice.setFont(new Font("Roboto", Font.BOLD, 18));
        lbcoinprice.setBounds(51, 94, 155, 61);
        panel_3.add(lbcoinprice);

        lbCoinpricevalue = new JLabel("New label");
        lbCoinpricevalue.setFont(new Font("Roboto", Font.BOLD, 14));
        lbCoinpricevalue.setBounds(51, 151, 89, 31);
        panel_3.add(lbCoinpricevalue);
    }

    public void setImage(String nameUrl) throws IOException {
        URL url = new URL(nameUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        FileOutputStream fos = new FileOutputStream("D:\\Diseño y Patrones 22-23\\Proyecto Final\\src\\Images\\coin.png");
        fos.write(response);
        fos.close();
        setScaleImage(lblFlag, "D:\\Diseño y Patrones 22-23\\Proyecto Final\\src\\Images\\coin.png");
    }


    private void setScaleImage(JLabel label, String pathImage) {
        ImageIcon image = new ImageIcon(pathImage);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), 1));
        label.setIcon(icon);
    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CriptoView frame = new LightCriptoView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
