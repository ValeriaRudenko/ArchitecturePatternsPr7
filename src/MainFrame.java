import javax.swing.*;
import java.awt.*;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
    private JPanel filtersPanel; // Panel to place the filter fields
    private JPanel buttonsPanel; // Panel to place the buttons
    private JPanel logoPanel;

    private JLabel noOfFavouritesLabel;
    private JLabel keywordLabel;
    private JLabel countryLabel;
    private JLabel noOfpageLabel;
    private JLabel minPriceLabel;
    private JLabel maxPriceLabel;

    private JTextField noOfFavourites;
    private JTextField keyword;
    private JTextField country;
    private JTextField noOfpage;
    private JTextField minPrice;
    private JTextField maxPrice;

    private JLabel vintedLogo;

    private JButton searchButton;

    // Constructor method
    public MainFrame() {
        this.setSize(500, 500);
        this.getContentPane().setLayout(new BorderLayout());
        // this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setBackground(new Color(190, 245, 255));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("DAP - Practise 7 - Observer Pattern");

        // Icon of the main frame
        ImageIcon vintedIcon = new javax.swing.ImageIcon("images/vinted_icon.png");
        Image vintedIconIcon = vintedIcon.getImage();
        this.setIconImage(vintedIconIcon);

        // Configure panel stuff
        filtersPanel = new JPanel();
        filtersPanel.setBackground(new Color(190, 245, 255));
        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(190, 245, 255));
        logoPanel = new JPanel();
        logoPanel.setSize(150, 100);
        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBackground(new Color(190, 245, 255));

        // Add logo to the label that will be on the top of the window
        ImageIcon logo = new ImageIcon("images/Vinted_Logo.png");
        Image originalIcon = logo.getImage();
        Image escalatedLogo = originalIcon.getScaledInstance(150, 50, Image.SCALE_SMOOTH);
        logo = new ImageIcon(escalatedLogo);
        vintedLogo = new JLabel(logo);
        logoPanel.add(vintedLogo, BorderLayout.CENTER);

        // Search labels
        keywordLabel = new JLabel("Keyword: ");
        noOfpageLabel = new JLabel("No. of page: ");
        countryLabel = new JLabel("Country: ");
        minPriceLabel = new JLabel("Min. price: ");
        maxPriceLabel = new JLabel("Max. price: ");
        noOfFavouritesLabel = new JLabel("No. of favourites: ");

        // Search text fields
        keyword = new JTextField(20);
        noOfpage = new JTextField(20);
        country = new JTextField(20);
        minPrice = new JTextField(10);
        maxPrice = new JTextField(10);
        noOfFavourites = new JTextField(20);

        // Search button
        // When pressed, the program will use the Vinted API
        searchButton = new JButton("Search items");

        // Add stuff to the panels and main frame
        filtersPanel.add(keywordLabel);
        filtersPanel.add(keyword);
        filtersPanel.add(noOfpageLabel);
        filtersPanel.add(noOfpage);
        filtersPanel.add(countryLabel);
        filtersPanel.add(country);
        filtersPanel.add(minPriceLabel);
        filtersPanel.add(minPrice);
        filtersPanel.add(maxPriceLabel);
        filtersPanel.add(maxPrice);
        filtersPanel.add(noOfFavouritesLabel);
        filtersPanel.add(noOfFavourites);

        buttonsPanel.add(searchButton);

        this.add(logoPanel, BorderLayout.NORTH);
        this.add(filtersPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.setVisible(true);
        filtersPanel.setVisible(true);
    }
}
