package View.CovidView;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;

public abstract class CovidView extends JFrame {
    public JLabel lblFlag;
    public JPanel contentPane;
    public JButton findButton;
    public JButton recoverButton;
    public JButton deathsButton;
    public JButton casesButton;
    public JTextPane countryTextfield;
    public JButton summaryButton;
    public JButton helpButton;
    public JLabel lbUpdate;
    public JButton updateButton;
    public JPanel graphic1;
    public JPanel graphic2;
    public JComboBox comboBox1;
    public JComboBox comboBox2;
    public JLabel lbCountry;
    public JLabel lblCasesValue;
    public JLabel lblDeathsValue;
    public JLabel lbRecovered;
    public JLabel lbVaccinated;
    public JLabel lbnewCasesToday;
    public JPanel panel_2;
    protected JPanel panel;
    protected String font;
    protected JPanel panel_1;

    public CovidView() throws IOException {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Diseño y Patrones 22-23\\Proyecto Final\\src" +
                "\\Images\\logo.png"));
        setTitle("Covid Dashboard");
        this.setLocationRelativeTo(null);
    }

    public abstract void viewType();

    public abstract void fontType();

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1158, 683);
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        fontType();
        panel = new JPanel();
        panel.setFont(new Font(font, Font.PLAIN, 14));
        panel.setBounds(-14, -30, 304, 700);
        contentPane.add(panel);
        panel.setLayout(null);

        countryTextfield = new JTextPane();
        countryTextfield.setBounds(65, 207, 164, 30);
        countryTextfield.setFont(new Font(font, Font.BOLD, 16));
        countryTextfield.setText("Country");
        countryTextfield.setContentType("Country");
        panel.add(countryTextfield);

        findButton = new JButton();
        findButton.setBounds(226, 207, 30, 30);
        findButton.setBackground(SystemColor.textHighlight);
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        findButton.setIcon(new ImageIcon("C:\\Users\\crist\\Desktop\\iconos\\ui.png"));
        panel.add(findButton);

        JLabel lblNewLabel = new JLabel("COVID 19 ");
        lblNewLabel.setBounds(32, 37, 262, 94);
        lblNewLabel.setForeground(SystemColor.text);
        lblNewLabel.setFont(new Font(font, Font.BOLD, 25));
        lblNewLabel.setIcon(new ImageIcon("D:\\logos\\icons8-coronavirus-pandemic-64.png"));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
        lblNewLabel_1.setBounds(104, 70, 163, 87);
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setFont(new Font(font, Font.BOLD, 25));
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Choose a country to show the data");
        lblNewLabel_2.setBounds(32, 152, 262, 56);
        lblNewLabel_2.setForeground(SystemColor.text);
        lblNewLabel_2.setFont(new Font(font, Font.BOLD, 16));
        panel.add(lblNewLabel_2);

        recoverButton = new JButton("Recovery Analisys");
        recoverButton.setBounds(42, 502, 235, 38);
        recoverButton.setFont(new Font(font, Font.BOLD, 18));
        panel.add(recoverButton);

        deathsButton = new JButton("Deaths Analisys");
        deathsButton.setBounds(42, 433, 235, 38);
        deathsButton.setFont(new Font(font, Font.BOLD, 18));
        panel.add(deathsButton);

        casesButton = new JButton("Cases Analisys");
        casesButton.setBounds(42, 360, 235, 38);
        casesButton.setFont(new Font(font, Font.BOLD, 18));
        panel.add(casesButton);

        summaryButton = new JButton("Summary");
        summaryButton.setBounds(42, 285, 235, 38);
        summaryButton.setFont(new Font(font, Font.BOLD, 18));
        panel.add(summaryButton);

        helpButton = new JButton("Help");
        helpButton.setBounds(42, 573, 235, 38);
        helpButton.setFont(new Font(font, Font.BOLD, 18));
        panel.add(helpButton);

        panel_1 = new JPanel();
        panel_1.setBounds(213, 0, 941, 56);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        lbUpdate = new JLabel("Last Update: ");
        lbUpdate.setForeground(SystemColor.text);
        lbUpdate.setFont(new Font(font, Font.BOLD, 14));
        lbUpdate.setBackground(SystemColor.textHighlight);
        lbUpdate.setBounds(77, 10, 310, 47);
        panel_1.add(lbUpdate);

        updateButton = new JButton("");
        updateButton.setIcon(new ImageIcon("D:\\logos\\update2.png"));
        updateButton.setBounds(847, 23, 49, 21);
        panel_1.add(updateButton);

        JLabel lblNewLabel_3_1 = new JLabel("Click to update");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font(font, Font.BOLD, 14));
        lblNewLabel_3_1.setBackground(SystemColor.textHighlight);
        lblNewLabel_3_1.setBounds(740, 10, 103, 47);
        panel_1.add(lblNewLabel_3_1);

        viewType();

        panel_2 = new JPanel();
        panel_2.setBackground(SystemColor.text);
        panel_2.setBounds(256, 48, 898, 598);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        graphic1 = new JPanel();
        graphic1.setLayout(null);
        graphic1.setBounds(58, 232, 810, 363);
        panel_2.add(graphic1);

        graphic2 = new JPanel();
        /*graphic2.setLayout(null);
        graphic2.setBounds(482, 247, 378, 311);
        panel_2.add(graphic2);*/

        JLabel diagramType = new JLabel("Diagram Type: ");
        diagramType.setForeground(Color.BLACK);
        diagramType.setFont(new Font(font, Font.BOLD, 14));
        diagramType.setBackground(SystemColor.textHighlight);
        diagramType.setBounds(90, 200, 100, 47);
        panel_2.add(diagramType);

        comboBox1 = new JComboBox();
        comboBox1.setBounds(210, 210, 127, 20);
        comboBox1.addItem("Bar Diagram");
        comboBox1.addItem("Line Diagram");
        panel_2.add(comboBox1);

        JLabel dateType = new JLabel("Date: ");
        dateType.setForeground(Color.BLACK);
        dateType.setFont(new Font(font, Font.BOLD, 14));
        dateType.setBackground(SystemColor.textHighlight);
        dateType.setBounds(620, 200, 100, 47);
        panel_2.add(dateType);

        comboBox2 = new JComboBox();
        comboBox2.setBounds(700, 210, 127, 20);
        comboBox2.addItem("All");
        comboBox2.addItem("2020");
        comboBox2.addItem("2021");
        comboBox2.addItem("2022");
        panel_2.add(comboBox2);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.text);
        panel_3.setBounds(33, 0, 855, 191);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        lbCountry = new JLabel();
        lbCountry.setForeground(Color.BLACK);
        lbCountry.setFont(new Font(font, Font.BOLD, 36));
        lbCountry.setBounds(133, 10, 655, 91);
        panel_3.add(lbCountry);

        JLabel lbCasesID = new JLabel("Cases");
        lbCasesID.setForeground(Color.BLACK);
        lbCasesID.setFont(new Font(font, Font.BOLD, 18));
        lbCasesID.setBounds(51, 92, 134, 61);
        panel_3.add(lbCasesID);

        lblFlag = new JLabel("");
        lblFlag.setBounds(41, 34, 82, 48);
        panel_3.add(lblFlag);

        lblCasesValue = new JLabel("New label");
        lblCasesValue.setFont(new Font(font, Font.PLAIN, 14));
        lblCasesValue.setBounds(51, 149, 89, 31);
        panel_3.add(lblCasesValue);

        JLabel lbDeathsID = new JLabel("Deaths");
        lbDeathsID.setForeground(Color.BLACK);
        lbDeathsID.setFont(new Font(font, Font.BOLD, 18));
        lbDeathsID.setBounds(197, 88, 134, 69);
        panel_3.add(lbDeathsID);

        lblDeathsValue = new JLabel("New label");
        lblDeathsValue.setFont(new Font(font, Font.PLAIN, 14));
        lblDeathsValue.setBounds(197, 153, 82, 22);
        panel_3.add(lblDeathsValue);

        JLabel lbRecoveredId = new JLabel("Recovered");
        lbRecoveredId.setForeground(Color.BLACK);
        lbRecoveredId.setFont(new Font(font, Font.BOLD, 18));
        lbRecoveredId.setBounds(347, 88, 134, 69);
        panel_3.add(lbRecoveredId);

        lbRecovered = new JLabel("New label");
        lbRecovered.setFont(new Font(font, Font.PLAIN, 14));
        lbRecovered.setBounds(357, 153, 89, 22);
        panel_3.add(lbRecovered);

        JLabel lbVaccinatedId = new JLabel("Vaccinated");
        lbVaccinatedId.setForeground(Color.BLACK);
        lbVaccinatedId.setFont(new Font(font, Font.BOLD, 18));
        lbVaccinatedId.setBounds(513, 88, 134, 69);
        panel_3.add(lbVaccinatedId);

        lbVaccinated = new JLabel("New label");
        lbVaccinated.setFont(new Font(font, Font.PLAIN, 14));
        lbVaccinated.setBounds(523, 153, 108, 22);
        panel_3.add(lbVaccinated);

        JLabel lblNewCasesTodayId = new JLabel("New cases today");
        lblNewCasesTodayId.setForeground(Color.BLACK);
        lblNewCasesTodayId.setFont(new Font(font, Font.BOLD, 18));
        lblNewCasesTodayId.setBounds(670, 88, 155, 69);
        panel_3.add(lblNewCasesTodayId);

        lbnewCasesToday = new JLabel("New label");
        lbnewCasesToday.setFont(new Font(font, Font.PLAIN, 14));
        lbnewCasesToday.setBounds(670, 153, 165, 22);
        panel_3.add(lbnewCasesToday);
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
        FileOutputStream fos = new FileOutputStream("D:\\Diseño y Patrones 22-23\\Proyecto Final\\src\\Images\\flag.png");
        fos.write(response);
        fos.close();
        setScaleImage(lblFlag, "D:\\Diseño y Patrones 22-23\\Proyecto Final\\src\\Images\\flag.png");
    }


    private void setScaleImage(JLabel label, String pathImage) {
        ImageIcon image = new ImageIcon(pathImage);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), 1));
        label.setIcon(icon);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CovidView frame = new LightCovidView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
