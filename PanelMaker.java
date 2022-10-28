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

	JButton button;
	JLabel label;
	JLabel counterLabel;
	JPanel panel;
	JTextField textField;
	private int counter = 0;
	JLabel dateText;
	JCheckBox activity;
	JPanel activityPanel;

	PanelMaker(JPanel groupPanel, String days, int date) {

		label = new JLabel(days);
		dateText = new JLabel(Date.dateGetter(date));
		activityPanel = new JPanel();
		activityPanel.setBackground(Color.LIGHT_GRAY);
		activityPanel.setPreferredSize(new Dimension(100, 400));
		textField = new JTextField("", 5);
		counterLabel = new JLabel();
		button = new JButton("ADD");
		button.addActionListener(this);
		panel = new JPanel();

		groupPanel.add(label);
		groupPanel.add(dateText);
		groupPanel.add(activityPanel);
		groupPanel.add(textField);
		groupPanel.add(counterLabel);
		groupPanel.add(button);
		groupPanel.add(panel);

	}

	public void actionPerformed(ActionEvent e) {

		String word = e.getActionCommand();

		if (word.equals("ADD")) {
			String name = textField.getText();
			textField.setText("");
			activity = new JCheckBox(name);
			activity.setBackground(Color.LIGHT_GRAY);
			addCheckBoxListener(activity);
			activityPanel.add(activity);
			counter++;
		}

		counterLabel.setText("Aktiviteter kvar: " + counter);

	}

	void addCheckBoxListener(JCheckBox box) {
		ActionListener listener = new ActionListener() {

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
				counterLabel.setText("Aktiviteter kvar: " + counter);
			}

		};
		box.addActionListener(listener);
	}

	JPanel highlight(int i, JPanel jP) {
		Calendar c = Calendar.getInstance();
		int today = c.get(Calendar.DAY_OF_WEEK);

		if (i == today - 2) {
			jP.setBackground(Color.yellow);

		}
		return jP;
	}

}
