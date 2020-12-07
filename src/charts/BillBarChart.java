package charts;

/**
 * 
 * @author Patricia Matsuda
 *
 */

import javax.swing.JFrame;
import java.awt.*;

public class BillBarChart extends JFrame
{
	//constants used for rendering the bar chart
	final int BAR_WIDTH = 25;		//width of the bar
	final int SPACE_BTW_BARS = 15;	//space between the bars in the chart
	final int LEFT_MARGIN = 100; 	//starting x value
	
	double electricBills[] = {28.64, 32.33, 28.21, 30.65, 31.76, 101.43, 
						135.87, 145.12, 115.11, 86.21, 56.32, 44.32};
	String months[] = {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug",
						"Sept", "Oct", "Nov", "Dec"};
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//starting values = x value for 1st bar, y value for data, y value for bar
		int startingX = LEFT_MARGIN;	
		int startingY = 240;			
		int startingBarY =210;			
				
		//title for bar chart
		Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);

		g.setFont(newFont);
		g.drawString("Monthly Expenses", 100, 60);  

		//set bar color to blue
		g.setColor(Color.BLUE);		

		//draw the bar representing the monthly expenses, change bar color to red if expenses greater than $120
		for (int i=0; i < electricBills.length; i++)
		{
			if (electricBills[i] > 120.0)
				g.setColor(Color.RED);
			
			g.fillRect(startingX, startingBarY - (int) electricBills[i], BAR_WIDTH, (int)electricBills[i]);
			g.drawString(months[i], startingX, startingY);
			
			startingX += BAR_WIDTH + SPACE_BTW_BARS;
			
			if (g.getColor() == Color.RED)
				g.setColor(Color.BLUE);
		}
	}
}
