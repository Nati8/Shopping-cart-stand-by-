import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;

    public MainFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        detailsPanel = new DetailsPanel();

        Container cont = getContentPane();
        cont.add(detailsPanel);

    }
}
