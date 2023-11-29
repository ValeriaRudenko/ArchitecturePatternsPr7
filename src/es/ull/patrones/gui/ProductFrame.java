package es.ull.patrones.gui;

import es.ull.patrones.api.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProductFrame extends JFrame {
    private JPanel panel;

    public ProductFrame(List<Product> productList) {
        initializeFrame();
        displayProducts(productList);
    }

    private void initializeFrame() {
        this.setTitle("Results");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(190, 245, 255));

        JScrollPane scrollPane = new JScrollPane(panel);
        this.add(scrollPane);
    }

    private void displayProducts(List<Product> productList) {
        panel.removeAll();  // Limpiar el panel antes de mostrar nuevos productos

        if (productList.isEmpty()) {
            panel.add(new JLabel("No results were found."));
        } else {
            for (Product product : productList) {
                // Construir etiquetas con detalles del producto
                JLabel imageLabel;
                // product.
                JLabel titleLabel = createCopyableLabel("Title: " + product.getTitle());
                JLabel urlLabel = createCopyableLabel("URL: " + product.getUrl());
                JLabel favouritesLabel = createCopyableLabel("Favourites: " + product.getFavourites());
                JLabel totalAmountLabel = createCopyableLabel("Price (including taxes): " + product.getTotalAmount() + " " + product.getCurrency());
                JLabel separator = new JLabel("-------------------------");

                // Añadir etiquetas al panel
                panel.add(titleLabel);
                panel.add(urlLabel);
                panel.add(favouritesLabel);
                panel.add(totalAmountLabel);
                panel.add(separator);
            }
        }

        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    private JLabel createCopyableLabel(String text) {
        JLabel label = new JLabel(text);
        label.setOpaque(true);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringSelection stringSelection = new StringSelection(label.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(null, "Copied to clipboard!");
            }
        });
        return label;
    }

    public void closeFrame() {
        this.dispose();
    }
}
