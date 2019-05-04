import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Clock {

	private int minutesLeft = 5;
	private int secondsLeft = 0;
	private Timer myTimer;
	private TimerTask task;
	private Label label;
	
	
	public Clock() {
		this.myTimer = new Timer();
		this.label = new Label("");
		
		task = new TimerTask() {
			public void run() {
				secondsLeft--;
				
				if(secondsLeft < 0) {
					minutesLeft--;
					secondsLeft = 59;
				}
				
				if(minutesLeft < 0) {
					myTimer.cancel();
					myTimer.purge();
					System.out.println("Timer stopped!!");
				} else if(secondsLeft >= 10) {
					// What does Platform.runLater() do?? Why did it work??
					Platform.runLater(() -> label.setText(minutesLeft + ":" + secondsLeft));
				} else {
					Platform.runLater(() -> label.setText(minutesLeft + ":0" + secondsLeft));
				}
			}
		};
	}
	
	public void start() {
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
	}
	
	
	/*** Accessor functions ***/
	
	public int getMinutesLeft() {
		return minutesLeft;
	}
	
	public int getSecondsLeft() {
		return secondsLeft;
	}
	
	public Label getLabel() {
		return this.label;
	}
	
	public String getText() {
		return label.getText();
	}
}
