package datastructures;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class FlashingText extends JApplet implements Runnable {
	private JLabel jText = new JLabel("Welcome", JLabel.CENTER);
	
	public FlashingText() {
		add(jText);
		new Thread(this).start();
	}
	
	// set the text on/off every 200 milli
	@Override
	public void run() {
		try {
			while(true) {
				if(jText.getText() == null) {
					jText.setText("Welcome");
				} else {
					jText.setText(null);
				}
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}
}
