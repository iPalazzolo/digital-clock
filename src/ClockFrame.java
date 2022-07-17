import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String currentTime;
    String currentDay;
    String currentDate;


    ClockFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.black);
        this.setSize(350, 200);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("kk:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE d");
        dateFormat = new SimpleDateFormat("MMMM yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        dayLabel.setForeground(Color.white);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        dateLabel.setForeground(Color.white);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }

    private void setTime() {

        while(true) {
            currentTime = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(currentTime);

            currentDay = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(currentDay);

            currentDate = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(currentDate);

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.getCause();
                e.printStackTrace();
            }
        }
    }
}
