package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

/**
 * @author artrayme
 * 12/5/21
 */
public class StopWatchPanel extends JPanel {
    JLabel time;
    JButton pause;
    JButton start;
    volatile boolean shouldCount = false;
    int int_sec = 0;
    int int_min = 0;
    int int_mil = 0;

    public StopWatchPanel() {

        time = new JLabel("Time goes here", JLabel.CENTER);
        pause = new JButton("Pause");
        start = new JButton("Start");

        start.addActionListener(new StartButtonAction());
        pause.addActionListener(new StartButtonAction());
        add(time);
        add(start);
        add(pause);

        java.util.Timer updateTimer = new java.util.Timer();
        updateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update(int_sec, int_min, int_mil);
            }
        }, 0, 100);
    }

    public void update(int s, int minute, int m) {
        String sec = Integer.toString(s);
        String min = Integer.toString(minute);
        String mil = Integer.toString(m);
        if (s <= 10) {
            sec = "0" + sec;
        }

        //        System.out.println(min + ":" + sec + "," + mil);
        time.setText(min + ":" + sec + "," + mil);
    }

    public void count() {
        Thread thread = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (true) {
                if (shouldCount) {
                    if (System.currentTimeMillis() - now >= 100) {
                        now = System.currentTimeMillis();
                        int_mil++;
                        if (int_mil > 9) {
                            int_mil = 0;
                            int_sec++;
                            if (int_sec >= 60) {
                                int_sec = 1;
                                int_min++;
                            }
                        }
                    }
                }
            }
        });
        thread.start();
    }

    public class StartButtonAction implements ActionListener {
        boolean firstTime = true;

        public void actionPerformed(ActionEvent event) {
            if (firstTime) {
                count();
                firstTime = false;
            }
            shouldCount = event.getSource() == start;
        }
    }

}