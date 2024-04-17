package Sprint3.GameOfFifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    public Game() {
        JFrame frame = new JFrame("Game of 15");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        GamePanel gamePanel = new GamePanel();

        frame.add(mainPanel);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        JButton button = new JButton("Nytt spel");
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.resetGame();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
