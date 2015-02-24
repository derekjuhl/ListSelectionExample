package com.spconger.JListSelection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryForm {
	private JFrame frame;
	private JPanel panel;
	private JTextField txtName;
	private JTextField txtPrice;
	private JButton button;
	private JButton viewButton;
	
	Stuff stuff = new Stuff();
	
	public EntryForm()
	{
		createFrame();
	}
	
	private void createFrame(){
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 300);
		frame.add(createPanel());
		frame.setVisible(true);
		
	}
	
	private JPanel createPanel(){
		panel=new JPanel();
		panel.setLayout(new FlowLayout());
		txtName = new JTextField(50);
		txtPrice = new JTextField(20);
		button = new JButton("Save");
		button.addActionListener(new ButtonListener());
		viewButton = new JButton("View Recipes");
		viewButton.addActionListener(new ViewButtonListener());
		
		panel.add(txtName);
		panel.add(txtPrice);
		panel.add(button);
		panel.add(viewButton);
		
		return panel;
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Item i = new Item();
			i.setName(txtName.getText());
			i.setPrice(Double.parseDouble(txtPrice.getText()));
			stuff.AddItem(i);
			txtName.setText("");
			txtPrice.setText("");
			
		}	
		
	}
	private class ViewButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayStuff ds = new DisplayStuff(stuff);
			
		}
		
	}
}
