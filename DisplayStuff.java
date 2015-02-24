package com.spconger.JListSelection;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DisplayStuff {
	
	private JFrame frame;
	private JList listStuff;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel borderPanel;
	private JButton button;
	private JLabel lblName;
	private JLabel lblPrice;
	
	private Stuff stuff;
	
	
	public DisplayStuff(Stuff s)
	{
		stuff=s;
		createFrame();
	}
	
	private void createFrame(){
		frame = new JFrame();
		frame.setBounds(100, 100, 400,500);
		frame.add(createBorderPanel());
		frame.setVisible(true);
	}
	
	private JPanel createBorderPanel(){
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		borderPanel.add(createScrollPane(),BorderLayout.WEST);
		borderPanel.add(createPanel(), BorderLayout.EAST);
		
		return borderPanel;
		
	}
	
	private JScrollPane createScrollPane(){
		listStuff = new JList<String>();
		//add the selection listener to the list
		listStuff.addListSelectionListener(new SelectionListener());
		scrollPane = new JScrollPane(listStuff);
		scrollPane.setBounds(20, 20, 100, 200);
		
			
		return scrollPane;
		
		
	}
	
	private JPanel createPanel(){
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		lblName = new JLabel();
		lblPrice=new JLabel();
		button = new JButton("Fill List");
		button.addActionListener(new ButtonListener());
	
		
		panel.add(lblName);
		panel.add(lblPrice);
		panel.add(button);
		
		return panel;
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Item>items=stuff.getItems();
			//set the default model for the list object
			//our list will contain Strings
			DefaultListModel<String> model = new DefaultListModel<String>();
			//loop through the arrayList
			for(Item i : items){
			//add the item names to the list
			model.addElement(i.getName());
			}
			listStuff.setModel(model);
			
		}
		
		
	}
	
	private class SelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			ArrayList<Item> items = stuff.getItems();
			for(Item i : items){
				String name = (String) listStuff.getSelectedValue();
				if(i.getName().equals(name)){
					lblName.setText(name);
					lblPrice.setText(Double.toString(i.getPrice()));
				}
			}
			
		}
		
	}

}
