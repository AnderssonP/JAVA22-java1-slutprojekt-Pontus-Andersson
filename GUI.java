package Kalender;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GUI {
	static int i;

	static void calender() {
		JFrame frame = new JFrame();
		frame.setSize(1480, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		JPanel weekContainer = new JPanel();
		weekContainer.setLayout(new BoxLayout(weekContainer, BoxLayout.LINE_AXIS));

		for (i = 0; i < 7; i++) {

			JPanel daypanels = new JPanel();
			daypanels.setPreferredSize(new Dimension(1,1));
			daypanels.setLayout(new BoxLayout(daypanels, BoxLayout.PAGE_AXIS));
			
			PanelMaker getDays = new PanelMaker(daypanels,days[i], i + 1);

			weekContainer.add(getDays.highlightDay(i, daypanels));
		}
		frame.add(weekContainer);
		frame.setVisible(true);
	}

}
