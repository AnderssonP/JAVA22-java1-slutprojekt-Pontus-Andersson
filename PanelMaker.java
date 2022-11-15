package Kalender;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelMaker implements ActionListener {

	JLabel labelDays;
	JLabel dateText;
	JPanel activityPanel;
	JTextField addActivity;
	JCheckBox activity;
	JLabel counterLabel;
	private int counter = 0;
	JButton button;
	JPanel panel;

	PanelMaker(JPanel groupPanel, String days, int date) {

		labelDays = new JLabel(days);
		dateText = new JLabel(Date.dateGetter(date));
		activityPanel = new JPanel();
		activityPanel.setBackground(Color.LIGHT_GRAY);
		activityPanel.setPreferredSize(new Dimension(100, 400));
		addActivity = new JTextField("", 5);
		counterLabel = new JLabel();
		button = new JButton("ADD");
		button.addActionListener(this);
		panel = new JPanel();

		groupPanel.add(labelDays);
		groupPanel.add(dateText);
		groupPanel.add(activityPanel);
		groupPanel.add(addActivity);
		groupPanel.add(counterLabel);
		groupPanel.add(button);
		groupPanel.add(panel);

	}

	public void actionPerformed(ActionEvent e) {

		String wordAdd = e.getActionCommand();

		if (wordAdd.equals("ADD")) {
			String getActivity = addActivity.getText();
			addActivity.setText("");
			activity = new JCheckBox(getActivity);
			activity.setBackground(Color.LIGHT_GRAY);
			addCheckBoxListener(activity);
			activityPanel.add(activity);
			counter++;
		}

		counterLabel.setText("Kvar: " + counter);

	}

	void addCheckBoxListener(JCheckBox box) {
		ActionListener boxSelecter = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (box.isSelected() == true) {
					counter--;
					if (counter == 0) {
						JOptionPane.showMessageDialog(null, "Slut på aktiviteter");
					}
				} else {
					counter++;
				}
				counterLabel.setText("Aktivitet: " + counter);
			}

		};
		box.addActionListener(boxSelecter);
	}

	JPanel highlightDay(int i, JPanel jP) {
		Calendar Hday = Calendar.getInstance();
		int today = Hday.get(Calendar.DAY_OF_WEEK);

		if (i == today - 2) {
			jP.setBackground(Color.yellow);

		}
		return jP;
	}

}
