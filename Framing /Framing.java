
import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComponent;

@SuppressWarnings("serial") public class Problem2
{  
	public static void draw(Graphics g)
	{  
		
		boolean bError = true;
		while (bError == true){
			try {
				//in = new Scanner(System.in);
				Scanner in = new Scanner(System.in);
				System.out.println("Enter Grid Dimension:");
				int GridDimension;
				GridDimension = in.nextInt();
				if (GridDimension < 0) {
				     // this gets caught in the catch block
				     throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!"); 
				}  
				
				for (int row = 0;row<GridDimension;row++)
				{
					for (int column = 0;column<GridDimension;column++)
					{
						g.setColor(Color.BLACK);
						g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
					}
				}
				for (int row = 0;row<GridDimension/2;row++)
				{
					for (int column = 0;column<GridDimension/2;column++)
					{
						g.setColor(Color.GREEN);
						g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
					}
				}
				for (int row = GridDimension/2;row<GridDimension;row++)
				{
					for (int column = GridDimension/2;column<GridDimension;column++)
					{
						g.setColor(Color.RED);
						g.fillOval(row*60 + 50,column*60 + 50, 50,50);	
					}
				}
			bError = false ; 
			}
			
			catch (Exception e)
			{
				System.out.println("Character Input and negative number input not acceptable");
				
			}
		} 
	}

		public static void main(String[] args)
		{
			JFrame frame = new JFrame();

			final int FRAME_WIDTH = 800;
			final int FRAME_HEIGHT = 800;

			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JComponent component = new JComponent()
			{
				public void paintComponent(Graphics graph)
				{
					draw(graph);
				}
			};   
			frame.add(component);
			frame.setVisible(true);
		}  


	}


