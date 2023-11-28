import javax.swing.*;
import java.awt.*;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {
    private JPanel filtersPanel; // Panel to place the filter fields
    private JPanel buttonsPanel; // Panel to place the buttons
    private JPanel logoPanel;

    private JTextField noOfFavourites;
    private JTextField keyword;
    private JTextField country;
    private JTextField noOfpage;
    private JTextField minPrice;
    private JTextField maxPrice;

    private JLabel vintedLogo;

    // Constructor method
    public MainFrame() {
        this.setSize(500, 500);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setBackground(new Color(190, 245, 255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Vinted");

        // Icon of the main frame
        ImageIcon vintedIcon = new javax.swing.ImageIcon("images/vinted_icon.png");
        Image vintedIconIcon = vintedIcon.getImage();
        this.setIconImage(vintedIconIcon);

        // Configure panel stuff
        filtersPanel = new JPanel();
        filtersPanel.setBackground(new Color(190, 245, 255));
        // filtersPanel.setLayout(new BorderLayout());
        buttonsPanel = new JPanel();
        filtersPanel.setBackground(new Color(190, 245, 255));
        logoPanel = new JPanel();

        // Text fields
        keyword = new JTextField("Keyword");
        noOfpage = new JTextField("Page");
        country = new JTextField("Country");
        minPrice = new JTextField("Mininum price");
        maxPrice = new JTextField("Maximum price");
        noOfFavourites = new JTextField("Minimum number of favourites");

        // Add logo to the label that will be on the top of the window
        ImageIcon logo = new ImageIcon("images/Vinted_Logo.png"); // Reemplaza con la ruta de tu imagen
        Image originalIcon = logo.getImage();
        Image escalatedLogo = originalIcon.getScaledInstance(200, 65, Image.SCALE_SMOOTH); // Ajusta el tamaño
        ImageIcon escalatedLogoDef = new ImageIcon(escalatedLogo);
        vintedLogo = new JLabel(escalatedLogoDef);
        logoPanel.add(vintedLogo);

        // Add stuff to the panels and main frame
        filtersPanel.add(keyword);
        filtersPanel.add(noOfpage);
        filtersPanel.add(country);
        filtersPanel.add(minPrice);
        filtersPanel.add(maxPrice);
        filtersPanel.add(noOfFavourites);

        this.add(logoPanel);
        this.add(filtersPanel);
        this.add(buttonsPanel);

        this.setVisible(true);
        filtersPanel.setVisible(true);
    }
}
