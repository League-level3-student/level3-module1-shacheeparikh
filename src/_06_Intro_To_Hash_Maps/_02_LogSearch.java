package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	JButton addEntry = new JButton();
	JButton searchById = new JButton();
	JButton viewList = new JButton();
	public static void main(String[] args) {
		
	_02_LogSearch log = new _02_LogSearch();
	
	log.GUI();
	
	
	
	
	}
	void GUI(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		
		addEntry.addActionListener(this);
		searchById.addActionListener(this);
		viewList.addActionListener(this);
		
		panel.add(addEntry);
		panel.add(searchById);
		panel.add(viewList);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	void addEntry(){
		String ask = JOptionPane.showInputDialog("enter an id number");
		int id = Integer.parseInt(ask);
		String name = JOptionPane.showInputDialog("enter a name");
		
		log.put(id, name);
	}
	void searchById(){
		boolean check =false;
		String ask = JOptionPane.showInputDialog("enter an id number");
		int id= Integer.parseInt(ask);
		for(Integer i: log.keySet()){
			if(id==i){
				check = true;
				JOptionPane.showMessageDialog(null, log.get(i));
			}
		}
		
		if(check==false){
			JOptionPane.showMessageDialog(null, "the entry doesn't exist");
		}
	}
	
	
	void viewList(){
		String list ="";
		for(Integer i: log.keySet()){
			list = list+ "ID: "+i+"   Name: "+log.get(i)+"\n";
			
		}
		
		JOptionPane.showMessageDialog(null, list);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==addEntry){
			addEntry();
		}
		if(e.getSource() ==searchById){
			searchById();
		}
		if(e.getSource()== viewList){
			viewList();
		}
	}
}
