package stopwatch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StopWAtch {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Stopwatch");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel panel = new JPanel();

        panel.setLayout(null);

        JButton Startbtn = new JButton("START");
        JButton Stopbtn = new JButton("STOP");
        JButton Reset = new JButton("RESET");
        JLabel time = new JLabel("Time shows here");
        panel.add(Startbtn);
        panel.add(Stopbtn);
        panel.add(Reset);
        panel.add(time);
        Startbtn.setBounds(50, 150, 100, 35);
        Stopbtn.setBounds(50, 200, 100, 35);
        Reset.setBounds(50, 250, 100, 35);
        time.setBounds(50, 350, 100, 35);
        Startbtn.setBackground(Color.pink);
        time.setForeground(Color.red);
        frame.add(panel);

        Startbtn.addActionListener(new ActionListener() {
            Instant start;

            @Override
            public void actionPerformed(ActionEvent e) {
                start = Instant.now();

                Timer timer = new Timer(1, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        time.setText(Duration.between(start, Instant.now()).getSeconds() + ":" + Duration.between(start, Instant.now()).getNano());
                    }
                });
                timer.start();
            }
        });

        Reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer1 = new Timer(1, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        time.setText("test");
                    }
                });
                timer1.stop();
            }
        });
    }
}


