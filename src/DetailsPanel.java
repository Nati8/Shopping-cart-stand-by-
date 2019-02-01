import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DetailsPanel extends JPanel {
    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.width = 600;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Foodland"));

        JLabel productsLabel = new JLabel("Products:");
        JLabel basketLabel = new JLabel("Basket:");
        JLabel youOweLabel = new JLabel("You owe:");

        final String[] productsString = {"Select product", "Apple - 2.5", "Banana - 3.5", "Cucumber - 1.5", "Potato - 2.3",
                "Strawberry - 5.4", "Tomato - 2.5", "Watermelon - 6.7"};

        JComboBox products = new JComboBox(productsString);

        DefaultListModel modelSelectedProducts = new DefaultListModel();
        JList selectedProducts = new JList(modelSelectedProducts);

        selectedProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedProducts.setLayoutOrientation(JList.VERTICAL);
        selectedProducts.setVisibleRowCount(-1);

        JLabel billLabel = new JLabel("0.0");

        JButton addProducts = new JButton("Add");
        DecimalFormat formatBill = new DecimalFormat("#.##");
        final double[] bill = {0};
        addProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenProduct = (String) products.getSelectedItem();

                switch (chosenProduct) {
                    case "Apple - 2.5":
                        modelSelectedProducts.addElement("Apple");
                        break;
                    case "Banana - 3.5":
                        modelSelectedProducts.addElement("Banana");
                        break;
                    case "Cucumber - 1.5":
                        modelSelectedProducts.addElement("Cucumber");
                        break;
                    case "Potato - 2.3":
                        modelSelectedProducts.addElement("Potato");
                        break;
                    case "Strawberry - 5.4":
                        modelSelectedProducts.addElement("Strawberry");
                        break;
                    case "Tomato - 2.5":
                        modelSelectedProducts.addElement("Tomato");
                        break;
                    case "Watermelon - 6.7":
                        modelSelectedProducts.addElement("Watermelon");
                        break;
                }

                switch (chosenProduct) {
                    case "Apple - 2.5":
                        bill[0] = bill[0] + 2.5;
                        break;
                    case "Banana - 3.5":
                        bill[0] = bill[0] + 3.5;
                        break;
                    case "Cucumber - 1.5":
                        bill[0] = bill[0] + 1.5;
                        break;
                    case "Potato - 2.3":
                        bill[0] = bill[0] + 2.3;
                        break;
                    case "Strawberry - 5.4":
                        bill[0] = bill[0] + 5.4;
                        break;
                    case "Tomato - 2.5":
                        bill[0] = bill[0] + 2.5;
                        break;
                    case "Watermelon - 6.7":
                        bill[0] = bill[0] + 6.7;
                        break;
                }
                billLabel.setText(String.valueOf(formatBill.format(bill[0])));
            }
        });

        JButton removeProducts = new JButton("Remove");

        removeProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProduct = (String) selectedProducts.getSelectedValue();
                int selectedProductIndex = selectedProducts.getSelectedIndex();
                if (selectedProductIndex >= 0) {
                    switch (selectedProduct) {
                        case "Apple":
                            modelSelectedProducts.removeElement("Apple");
                            break;
                        case "Banana":
                            modelSelectedProducts.removeElement("Banana");
                            break;
                        case "Cucumber":
                            modelSelectedProducts.removeElement("Cucumber");
                            break;
                        case "Potato":
                            modelSelectedProducts.removeElement("Potato");
                            break;
                        case "Strawberry":
                            modelSelectedProducts.removeElement("Strawberry");
                            break;
                        case "Tomato":
                            modelSelectedProducts.removeElement("Tomato");
                            break;
                        case "Watermelon":
                            modelSelectedProducts.removeElement("Watermelon");
                            break;
                    }

                    switch (selectedProduct) {
                        case "Apple":
                            bill[0] = bill[0] - 2.5;
                            break;
                        case "Banana":
                            bill[0] = bill[0] - 3.5;
                            break;
                        case "Cucumber":
                            bill[0] = bill[0] - 1.5;
                            break;
                        case "Potato":
                            bill[0] = bill[0] - 2.3;
                            break;
                        case "Strawberry":
                            bill[0] = bill[0] - 5.4;
                            break;
                        case "Tomato":
                            bill[0] = bill[0] - 2.5;
                            break;
                        case "Watermelon":
                            bill[0] = bill[0] - 6.7;
                            break;
                    }
                }
                billLabel.setText(String.valueOf(formatBill.format(bill[0])));
            }
        });

        JButton finishPurchase = new JButton("Finish");

        finishPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelSelectedProducts.removeAllElements();
                bill[0] = 0.0;
                billLabel.setText(String.valueOf(0.0));
                JOptionPane.showMessageDialog(null, "Thank you for your purchase!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
                products.setSelectedIndex(0);
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        //First row
        gc.gridx = 0;
        gc.gridy = 0;
        add(productsLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(basketLabel, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        add(youOweLabel, gc);

        //Second row
        gc.gridx = 0;
        gc.gridy = 1;
        add(products, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(selectedProducts, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(billLabel, gc);

        //Third row
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 2;
        add(addProducts, gc);

        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy = 2;
        add(removeProducts, gc);

        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 2;
        gc.gridy = 2;
        add(finishPurchase, gc);

    }
}
