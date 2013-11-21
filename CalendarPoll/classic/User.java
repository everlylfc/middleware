package classic;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class User {

	static final String[] clients = {"alice", "tom", "everly", "zirui"};
	
	static String user;
	static Client client;
	static MessageHandler mHandler;
	static UserInterface ui;
	
	public static void main(String[] args) throws IOException {
		
		// Fetch the clients list
		List<String> clientsList = Arrays.asList(clients);
		
		// Fetch username
		user = null;
		while (user == null) {
			System.out.print("Please enter a name: ");
			
			char ch = (char) System.in.read();
			user = "";
			
			while (ch != '\n') {
				user += ch;
				ch = (char) System.in.read();
			}
			if (!user.isEmpty()) {
				user = user.substring(0, user.length()-1);
			}
			
			System.out.println(user);
			user = user.toLowerCase();
			if (!clientsList.contains(user.toLowerCase())) {
				System.err.println(user + " is not a registered name!");
				user = null;
			}
		}
		
		// Create client object
		client = new MyClient(user, clientsList);
		
		 //Schedule a job for the event dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		UserInterface.createAndShowGUI();
            }
        });
		mHandler = new MyMessageHandler();
		
	}

}