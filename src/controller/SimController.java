package src.controller;

import javax.swing.*;
import java.util.Hashtable;
import src.model.*;

/**
 * Controller subclass.
 * Created by Bas Haaksema on 05-Apr-16.
 */
public class SimController extends AbstractController {

    public SimController(CarParkModel carParkModel) {
        super(carParkModel);

        JButton startButton = new JButton("Start"); // Create Button
        startButton.addActionListener(e -> carParkModel.start()); // Add Listener
        add(startButton); // Add to JPanel

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> carParkModel.stop());
        add(stopButton);

        JButton plusOneButton = new JButton("+1 tick");
        plusOneButton.addActionListener(e -> carParkModel.run(1));
        add(plusOneButton);

        JButton plusHundredButton = new JButton("+100 ticks");
        plusHundredButton.addActionListener(e -> carParkModel.run(100));
        // TODO Secure threading
        add(plusHundredButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            // TODO Implement reset functionality
            // carParkModel.reset();
        });
        //add(resetButton);

        JSlider speedSlider = new JSlider(SwingConstants.HORIZONTAL);
        speedSlider.setMajorTickSpacing(5);
        speedSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                carParkModel.setTickPause(source.getMaximum() - source.getValue());
            }
        });
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(speedSlider.getMaximum()/10, new JLabel("Slow"));
        labelTable.put(speedSlider.getMaximum()/10*9, new JLabel("Fast"));
        speedSlider.setLabelTable(labelTable);
        speedSlider.setPaintLabels(true);
        add(speedSlider);

        setVisible(true);
    }
}
