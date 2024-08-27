import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button implements ActionListener {

    JLabel label;
    Button(){
        JFrame frame = new JFrame("Traffic Light Simulator");

        frame. setLayout(new FlowLayout());

        frame.setSize(220, 90);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        start.addActionListener(this);
        stop.addActionListener(this);

        frame.add(start);
        frame.add(stop);

        label = new JLabel("Press a button");

        frame.add(label);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TrafficLight tl = new TrafficLight(TrafficLightColor.GREEN);
        TrafficLight t2 = new TrafficLight(TrafficLightColor.GREEN);
        TrafficLight t3 = new TrafficLight(TrafficLightColor.GREEN);

        if(e.getActionCommand().equals("Start")){

            Thread thread = new Thread(tl);
            Thread thread2 = new Thread(t2);
            Thread thread3 = new Thread(t3);

            thread.start();
            thread2.start();
            thread3.start();

            for(int i = 0; i < 9; i++){
                System.out.print(tl.getColor() + " " + "Intersection 1" + " ");
                tl.waitForChange();

                System.out.println("\n");

                System.out.println(t2.getColor() + " " + "Intersection 2" + " ");
                t2.waitForChange();
            }

            if(e.getActionCommand().equals("Stop")){
                tl.cancel();
            }
        }
    }
}
