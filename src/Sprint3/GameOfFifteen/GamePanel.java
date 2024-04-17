package Sprint3.GameOfFifteen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel {
    private JButton[][] board = new JButton[4][4];
    private int emptyRow;
    private int emptyCol;
    private boolean gameInProgress = false;

    public GamePanel() {
        setLayout(new GridLayout(4, 4));
        startGame();
    }

    private void startGame() {
        removeAll();
        revalidate();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    board[i][j] = new JButton("");
                    emptyRow = i;
                    emptyCol = j;
                } else {
                    board[i][j] = new JButton(String.valueOf(numbers.get(index)));
                    index++;
                }
                this.add(board[i][j]);
                addActionListener(board[i][j]);
            }
        }
        revalidate();

        gameInProgress = true;

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkWinner(board)) {
                    JOptionPane.showMessageDialog(null, "Grattis, du vann!");
                    gameInProgress = false;
                }
            }
        });
        timer.setRepeats(false);
        timer.setInitialDelay(200);
        timer.start();
    }

    public void resetGame() {
        startGame();
    }

    private void addActionListener(JButton button) {
        button.addActionListener(e -> {
            if (!gameInProgress) {
                return;
            }

            JButton clickedButton = (JButton) e.getSource();
            int buttonRow = 0;
            int buttonCol = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (board[i][j] == clickedButton) {
                        buttonRow = i;
                        buttonCol = j;
                        break;
                    }
                }
            }

            if ((Math.abs(buttonRow - emptyRow) == 1 && buttonCol == emptyCol) ||
                    (Math.abs(buttonCol - emptyCol) == 1 && buttonRow == emptyRow)) {
                String buttonText = clickedButton.getText();
                clickedButton.setText("");
                board[emptyRow][emptyCol].setText(buttonText);
                emptyRow = buttonRow;
                emptyCol = buttonCol;

                if (checkWinner(board)) {
                    JOptionPane.showMessageDialog(null, "Grattis, du vann!");
                    gameInProgress = false;
                }
            }
        });
    }

    private static boolean checkWinner(JButton[][] buttons) {
        int expectedNumber = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonText = buttons[i][j].getText();
                if (i == 3 && j == 3) {
                    if (!buttonText.isEmpty()) {
                        return false;
                    }
                } else if (buttonText.isEmpty()) {
                    return false;
                } else {
                    int number = Integer.parseInt(buttonText);
                    if (number != expectedNumber) {
                        return false;
                    }
                    expectedNumber++;
                }
            }
        }
        return true;
    }
}
