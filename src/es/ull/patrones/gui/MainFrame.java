package es.ull.patrones.gui;

import javax.swing.*;
import java.awt.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
    // Panels
    private JPanel filtersPanel; // Panel to place the filter fields
    private JPanel buttonsPanel; // Panel to place the buttons
    private JPanel logoPanel;

    // Labels
    private JLabel noOfFavouritesLabel;
    private JLabel keywordLabel;
    private JLabel countryLabel;
    private JLabel noOfpageLabel;
    private JLabel minPriceLabel;
    private JLabel maxPriceLabel;
    private JLabel message;
    private JLabel vintedLogo;

    // Input fields
    private JTextField keyword;
    private JComboBox<String> country;
    private JComboBox<Integer> noOfpage;
    private JComboBox<String> minPrice;
    private JComboBox<String> maxPrice;
    private JComboBox<Integer> noOfFavourites;

    // Buttons
    private JButton searchButton;

    // Constructor method
    public MainFrame() {
        // Configuration of the main frame
        this.setSize(400, 300);
        this.getContentPane().setLayout(new BorderLayout());
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
        filtersPanel.setLayout(new GridLayout(7, 2));
        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(190, 245, 255));
        logoPanel = new JPanel();
        logoPanel.setSize(150, 100);
        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBackground(new Color(190, 245, 255));

        // Add logo to the label that will be on the top of the window
        ImageIcon logo = new ImageIcon("images/Vinted_Logo.png");
        Image originalIcon = logo.getImage();
        Image escalatedLogo = originalIcon.getScaledInstance(75, 25, Image.SCALE_SMOOTH);
        logo = new ImageIcon(escalatedLogo);
        vintedLogo = new JLabel(logo);
        logoPanel.add(vintedLogo, BorderLayout.CENTER);

        // Search labels
        message = new JLabel("Please enter the search criteria:");
        keywordLabel = new JLabel("Keyword");
        noOfpageLabel = new JLabel("No. of page");
        countryLabel = new JLabel("Country");
        minPriceLabel = new JLabel("Min. price (€)");
        maxPriceLabel = new JLabel("Max. price (€)");
        noOfFavouritesLabel = new JLabel("Min. no. of favourites");

        // Combo boxes values
        Integer[] pages = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                26, 27, 28, 29, 30, 31, 32}; // You can only select 1-32 page
        String[] countryOptions = {"France", "Belgium", "Spain", "Luxembourg", "Netherlands", "Lithuania", "Germany",
                "Austria", "Italy", "United Kingdom", "Portugal", "United States", "Czech Republic", "Slovakia",
                "Poland", "Sweden", "Romania", "Hungary", "Denmark"};
        String[] prices = {"0", "1", "2", "3", "4", "5", "6", "8", "10", "15", "20", "25", "30", "35", "40",
                "45", "50", "60", "70", "80", "90", "100", "150", "200", "250", "300", "400", "500", "750", "1000",
                "1500", "2000", "2500", "3000", "4000", "5000", "7500", "10000", "15000", "20000"};
        Integer[] favourites = {0, 5, 10, 15, 20, 25, 30, 40, 50, 100};

        // Search text fields
        keyword = new JTextField(20);
        noOfpage = new JComboBox<>(pages);
        country = new JComboBox<>(countryOptions);
        minPrice = new JComboBox<String>(prices);
        maxPrice = new JComboBox<String>(prices);
        noOfFavourites = new JComboBox<Integer>(favourites);

        // Search button
        // When pressed, the program will use the Vinted API
        searchButton = new JButton("Search items");
        // Action listener should be defined here
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // We declare the variables
                String countryValue;
                int pageValue;
                String itemValue;
                int minPriceValue = -1;
                int maxPriceValue = -1;
                int favourites = -1;

                // We give values to the variables
                switch(country.getSelectedItem().toString()) {
                    case "France":
                        countryValue = "fr";
                        break;
                    case "Belgium":
                        countryValue = "be";
                        break;
                    case "Spain":
                        countryValue = "es";
                        break;
                    case "Luxembourg":
                        countryValue = "lu";
                        break;
                    case "Netherlands":
                        countryValue = "nl";
                        break;
                    case "Lithuania":
                        countryValue = "lt";
                        break;
                    case "Germany":
                        countryValue = "de";
                        break;
                    case "Austria":
                        countryValue = "at";
                        break;
                    case "Italy":
                        countryValue = "it";
                        break;
                    case "United Kingdom":
                        countryValue = "gb";
                        break;
                    case "Portugal":
                        countryValue = "pt";
                        break;
                    case "United States":
                        countryValue = "us";
                        break;
                    case "Czech Republic":
                        countryValue = "cz";
                        break;
                    case "Slovakia":
                        countryValue = "sk";
                        break;
                    case "Poland":
                        countryValue = "pl";
                        break;
                    case "Sweden":
                        countryValue = "se";
                        break;
                    case "Romania":
                        countryValue = "ro";
                        break;
                    case "Hungary":
                        countryValue = "hu";
                        break;
                    case "Denmark":
                        countryValue = "dk";
                        break;
                    default:
                        countryValue = "es";
                        break;
                }
                pageValue = Integer.parseInt(noOfpage.getSelectedItem().toString());
                itemValue = keyword.getText();
                minPriceValue = Integer.parseInt(minPrice.getSelectedItem().toString());
                maxPriceValue = Integer.parseInt(maxPrice.getSelectedItem().toString());
                favourites = Integer.parseInt(noOfFavourites.getSelectedItem().toString());

                // Printing to test if everything is going well
                // System.out.print(countryValue + " " + pageValue + " " + itemValue + " " + minPriceValue + " " + maxPriceValue + " " + favourites + '\n');

                // VintedApiSubject search = new VintedApiSubject(favourites, page, item, minPrice, maxPrice);
            }
        });

        // Add stuff to the panels and main frame
        // Filters panel
        filtersPanel.add(message);
        filtersPanel.add(new JLabel());
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
        // Buttons panel
        buttonsPanel.add(searchButton);
        // Main frame
        this.add(logoPanel, BorderLayout.NORTH);
        this.add(filtersPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        // We assure the main frame is visible
        this.setVisible(true);
    }
}
