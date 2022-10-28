package Kalender;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GUI {
	static int i;

	static void calender() {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.LINE_AXIS));

		for (i = 0; i < 7; i++) {

			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(1,1));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
			PanelMaker getDays = new PanelMaker(panel,days[i], i + 1);

			container.add(getDays.highlight(i, panel));
		}
		frame.add(container);
		frame.setVisible(true);
	}

}
