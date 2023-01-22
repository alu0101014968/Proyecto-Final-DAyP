import Model.HttpUrlConnection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.text.DecimalFormat;

public class ui extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ui frame = new ui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   /* public static void main(String[] args) throws Exception {
        DefaultXYDataset dataset = new DefaultXYDataset();
        dataset.addSeries("firefox", new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017 }, { 25, 29.1, 32.1, 32.9, 31.9, 25.5, 20.1, 18.4, 15.3, 11.4, 9.5 }});
        dataset.addSeries("ie", new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017 }, { 67.7, 63.1, 60.2, 50.6, 41.1, 31.8, 27.6, 20.4, 17.3, 12.3, 8.1 }});
        dataset.addSeries("chrome", new double[][] {{ 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017 }, { 0.2, 6.4, 14.6, 25.3, 30.1, 34.3, 43.2, 47.3, 58.4 }});

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));

        JFreeChart chart = ChartFactory.createXYLineChart("Browser Quota", "Year", "Quota", dataset);
        chart.getXYPlot().getRangeAxis().setRange(0, 100);
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'%'"));
        chart.getXYPlot().setRenderer(renderer);

        BufferedImage image = chart.createBufferedImage(600, 400);
        ImageIO.write(image, "png", new File("D:\\logos\\xy-chart.png"));
    }*/

    /**
     * Create the frame.
     */
    public ui() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1158, 683);
        contentPane = new JPanel();
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.setBackground(SystemColor.textHighlight);
        panel.setBounds(-14, -30, 304, 700);
        contentPane.add(panel);
        panel.setLayout(null);

        JTextPane txtpnCountry = new JTextPane();
        txtpnCountry.setBounds(65, 207, 164, 30);
        txtpnCountry.setFont(new Font("Roboto", Font.BOLD, 16));
        txtpnCountry.setText("Country");
        txtpnCountry.setContentType("Country");
        panel.add(txtpnCountry);

        JButton btnNewButton = new JButton();
        btnNewButton.setBounds(226, 207, 30, 30);
        btnNewButton.setBackground(SystemColor.textHighlight);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\crist\\Desktop\\iconos\\ui.png"));
        panel.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("COVID 19 ");
        lblNewLabel.setBounds(32, 37, 262, 94);
        lblNewLabel.setForeground(SystemColor.text);
        lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 25));
        lblNewLabel.setIcon(new ImageIcon("D:\\logos\\icons8-coronavirus-pandemic-64.png"));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
        lblNewLabel_1.setBounds(104, 70, 163, 87);
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 25));
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Choose a country for show the data");
        lblNewLabel_2.setBounds(32, 152, 262, 56);
        lblNewLabel_2.setForeground(SystemColor.text);
        lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
        panel.add(lblNewLabel_2);

        JButton btnNewButton_5 = new JButton("Recovery Analisys");
        btnNewButton_5.setBounds(42, 502, 235, 38);
        btnNewButton_5.setFont(new Font("Roboto", Font.BOLD, 14));
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.add(btnNewButton_5);

        JButton btnNewButton_5_1 = new JButton("Deaths Analisys");
        btnNewButton_5_1.setBounds(42, 433, 235, 38);
        btnNewButton_5_1.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(btnNewButton_5_1);

        JButton btnNewButton_5_2 = new JButton("Cases Analisys");
        btnNewButton_5_2.setBounds(42, 360, 235, 38);
        btnNewButton_5_2.setForeground(SystemColor.text);
        btnNewButton_5_2.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(btnNewButton_5_2);

        JButton btnNewButton_5_3 = new JButton("Summary");
        btnNewButton_5_3.setBackground(SystemColor.control);
        btnNewButton_5_3.setBorder(null);
        btnNewButton_5_3.setBounds(10, 285, 294, 38);
        btnNewButton_5_3.setForeground(SystemColor.text);
        btnNewButton_5_3.setFont(new Font("Roboto", Font.BOLD, 20));
        panel.add(btnNewButton_5_3);

        JButton btnNewButton_5_4 = new JButton("Help");
        btnNewButton_5_4.setBounds(42, 573, 235, 38);
        btnNewButton_5_4.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(btnNewButton_5_4);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.textHighlight);
        panel_1.setBounds(213, 0, 941, 56);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Last Update: ");
        lblNewLabel_3.setForeground(SystemColor.text);
        lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 14));
        lblNewLabel_3.setBackground(SystemColor.textHighlight);
        lblNewLabel_3.setBounds(81, 10, 252, 47);
        panel_1.add(lblNewLabel_3);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setIcon(new ImageIcon("D:\\logos\\update2.png"));
        btnNewButton_1.setBounds(847, 23, 49, 21);
        panel_1.add(btnNewButton_1);

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

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBounds(76, 247, 378, 311);
        panel_2.add(panel_2_1);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(SystemColor.text);
        panel_3.setBounds(35, 0, 853, 199);
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Cases");
        lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 18));
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setBounds(49, 88, 134, 61);
        panel_3.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("Deaths");
        lblNewLabel_4_1.setForeground(Color.BLACK);
        lblNewLabel_4_1.setFont(new Font("Roboto", Font.BOLD, 18));
        lblNewLabel_4_1.setBounds(222, 84, 134, 69);
        panel_3.add(lblNewLabel_4_1);

        JLabel lblNewLabel_4_1_1 = new JLabel("Recovered");
        lblNewLabel_4_1_1.setForeground(Color.BLACK);
        lblNewLabel_4_1_1.setFont(new Font("Roboto", Font.BOLD, 18));
        lblNewLabel_4_1_1.setBounds(413, 84, 134, 69);
        panel_3.add(lblNewLabel_4_1_1);

        JLabel lblNewLabel_4_1_1_1 = new JLabel("Vaccinated");
        lblNewLabel_4_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_4_1_1_1.setFont(new Font("Roboto", Font.BOLD, 18));
        lblNewLabel_4_1_1_1.setBounds(623, 84, 134, 69);
        panel_3.add(lblNewLabel_4_1_1_1);

        JLabel lblNewLabel_4_2 = new JLabel("Country");
        lblNewLabel_4_2.setForeground(Color.BLACK);
        lblNewLabel_4_2.setFont(new Font("Roboto", Font.BOLD, 36));
        lblNewLabel_4_2.setBounds(133, 10, 134, 91);
        panel_3.add(lblNewLabel_4_2);

        JLabel lblNewLabel_5 = new JLabel("New label");
        lblNewLabel_5.setBounds(49, 158, 67, 31);
        panel_3.add(lblNewLabel_5);

        JLabel lblNewLabel_5_1 = new JLabel("New label");
        lblNewLabel_5_1.setBounds(222, 158, 45, 13);
        panel_3.add(lblNewLabel_5_1);

        JLabel lblNewLabel_5_2 = new JLabel("New label");
        lblNewLabel_5_2.setBounds(423, 158, 45, 13);
        panel_3.add(lblNewLabel_5_2);

        JLabel lblNewLabel_5_3 = new JLabel("New label");
        lblNewLabel_5_3.setBounds(649, 158, 45, 13);
        panel_3.add(lblNewLabel_5_3);

        JLabel lblFlag = new JLabel("");
        lblFlag.setBounds(34, 30, 82, 48);
        panel_3.add(lblFlag);

        JPanel panel_2_1_1 = new JPanel();
        panel_2_1_1.setLayout(null);
        panel_2_1_1.setBounds(482, 247, 378, 311);
        panel_2.add(panel_2_1_1);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(76, 216, 69, 21);
        panel_2.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(482, 216, 29, 21);
        panel_2.add(comboBox_1);

        setImage(lblFlag, "https://countryflagsapi.com/png/austria");
        //setScaleImage(lblNewLabel_6, "D:\\logos\\ull.png");
        this.setLocationRelativeTo(null);
    }

    public void setImage(JLabel label, String nameUrl) throws IOException {
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
        setScaleImage(label, "D:\\Diseño y Patrones 22-23\\Proyecto Final\\src\\Images\\flag.png");
    }

    private void setScaleImage(JLabel label, String pathImage) {
        ImageIcon image = new ImageIcon(pathImage);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), 1));
        label.setIcon(icon);
    }
}
