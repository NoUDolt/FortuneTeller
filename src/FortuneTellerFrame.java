import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JLabel titleLabel;
    private JTextArea fortuneArea;
    private JButton readFortuneButton, quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1; // Keeps track of the last fortune shown

    public FortuneTellerFrame() {
        // Frame setup
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        initTopPanel();
        initMiddlePanel();
        initBottomPanel();

        // Initialize fortunes
        initFortunes();

        // Center frame and set size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize((int)(screenSize.width * 0.75), (int)(screenSize.height * 0.75));
        setLocationRelativeTo(null); // Center the frame
    }

    private void initTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        // Load image and set label
        ImageIcon icon = new ImageIcon("path_to_image/fortune_teller.png"); // Replace with your image path
        titleLabel = new JLabel("Fortune Teller", icon, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);
    }

    private void initMiddlePanel() {
        fortuneArea = new JTextArea(10, 30);
        fortuneArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        fortuneArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        // "Read My Fortune" Button
        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        readFortuneButton.addActionListener(this::readFortune);

        // "Quit" Button
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("A surprise is waiting for you around the corner.");
        fortunes.add("Fortune favors the bold.");
        fortunes.add("You will meet someone interesting today.");
        fortunes.add("An exciting opportunity is on its way.");
        fortunes.add("Success is in your future.");
        fortunes.add("A pleasant surprise will make your day.");
        fortunes.add("New adventures await you.");
        fortunes.add("You will soon embark on a journey.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("You will receive good news.");
        fortunes.add("Happiness is within your reach.");
    }

    private void readFortune(ActionEvent e) {
        Random random = new Random();
        int newIndex;

        do {
            newIndex = random.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);

        lastFortuneIndex = newIndex;
        fortuneArea.append(fortunes.get(newIndex) + "\n");
    }
}
