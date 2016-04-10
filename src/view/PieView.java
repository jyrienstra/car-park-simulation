package src.view;
import src.model.CarParkModel;

import java.awt.*;
import javax.swing.*;

/**
 * Created by jouke on 4/4/16.
 */
public class PieView extends AbstractView {
    private Dimension size;
    private Image carParkImage;

    public PieView(CarParkModel carParkModel) {
        super(carParkModel);
    }

    /**
     * Overridden. Tell the GUI manager how big we would like to be.
     */
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    /**
     * Paint the pie
     * @param g
     */
    public void paintComponent(Graphics g) {
        int maxAmount=(carParkModel.getNumberOfPlaces()*carParkModel.getNumberOfFloors()*carParkModel.getNumberOfRows()); //maximum amount
        int currentAmount = carParkModel.getAmountOfCarsInThePark(); //get the current amount of cars in the park
        int arc = currentAmount * 360 / maxAmount;
        g.setColor(super.getBackground()); //set the background the same as super
        g.fillRect(0, 0, this.getWidth(), this.getHeight()); //set the width and height to whole panel
        g.setColor(Color.BLUE); //draw it with the color blue
        g.fillArc(10, 10, 360, 360, 0, arc); //fil the arc
    }
}