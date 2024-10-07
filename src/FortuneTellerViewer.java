import javax.swing.SwingUtilities;

public class FortuneTellerViewer {
    public static void main(String[] args) {
        // Run the GUI
        SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setVisible(true);
        });
    }
}