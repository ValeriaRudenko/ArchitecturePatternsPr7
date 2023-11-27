import javax.swing.*;
import java.awt.*;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {
    // Attributes declaration
    private JFrame mainFrame;
    private JPanel filtersPanel; // Panel to place the filter fields
    private JPanel buttonsPanel; // Panel to place the buttons

    private JTextField noOfFavourites;
    private JTextField keyword;
    private JTextField country;
    private JTextField noOfpage;
    private JTextField minPrice;
    private JTextField maxPrice;

    private JLabel vintedLogo;

    // Constructor method
    public MainFrame() {
        mainFrame = new JFrame();
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout());
        mainFrame.setBackground(new Color(190, 245, 255));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon vintedIcon = new javax.swing.ImageIcon("images/vinted_icon.png");
        Image vintedIconIcon = vintedIcon.getImage();
        mainFrame.setIconImage(vintedIconIcon);

        filtersPanel = new JPanel();
        filtersPanel.setBackground(new Color(190, 245, 255));

        buttonsPanel = new JPanel();
        filtersPanel.setBackground(new Color(190, 245, 255));


        keyword = new JTextField("Keyword");
        noOfpage = new JTextField("Page");
        country = new JTextField("Country");
        minPrice = new JTextField("Mininum price");
        maxPrice = new JTextField("Maximum price");
        noOfFavourites = new JTextField("Minimum number of favourites");

        ImageIcon icono = new javax.swing.ImageIcon("../images/Vinted_Logo.png");
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(100,100,Image.SCALE_SMOOTH));
        vintedLogo = new JLabel(iconoEscalado);

        filtersPanel.add(keyword);
        filtersPanel.add(noOfpage);
        filtersPanel.add(country);
        filtersPanel.add(minPrice);
        filtersPanel.add(maxPrice);
        filtersPanel.add(noOfFavourites);

        mainFrame.add(vintedLogo);
        mainFrame.add(filtersPanel);
        mainFrame.add(buttonsPanel);

        mainFrame.setVisible(true);
        filtersPanel.setVisible(true);
    }
}
