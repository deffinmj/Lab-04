import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;
    JButton quitBtn;

    int lastFortuneIndex = 0;

    public FortuneTellerFrame() {
        JPanel mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(middlePnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);


        add(mainPnl);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void createTopPanel()
    {
        topPnl = new JPanel();
        icon = new ImageIcon("FortuneTellerImg.jpg");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Serif", Font.PLAIN, 36));
        // Obscure code to align the text to the Icon!
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(titleLbl);
    }

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        displayTA = new JTextArea(10, 25);
        displayTA.setFont(new Font("Calibri", Font.PLAIN, 14));
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller);
    }

    private String fortunes[] =  {"Fortune 1",
            "Fortune 2",
            "Fortune 3",
            "Fortune 4",
            "Fortune 5",
            "Fortune 6",
            "Fortune 7",
            "Fortune 8",
            "Fortune 9",
            "Fortune 10",
            "Fortune 11",
            "Fortune 12"};

    private void createBottomPanel()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 4));

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            Random rnd = new Random();
            int generated = 0;
            do {
                generated = rnd.nextInt(12);
            } while (generated == lastFortuneIndex);
            lastFortuneIndex = generated;
            displayTA.append(fortunes[lastFortuneIndex] + "\n");
        });

        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);

    }
}