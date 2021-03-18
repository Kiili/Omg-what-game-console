import java.util.Timer;
import java.util.TimerTask;

public class TheTimer {
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			if(Info.TimerUse){
				MainFrame.calculations();
			}
		}
	};
	
	public void TimerStart(){
		this.timer.scheduleAtFixedRate(task, 50, 50);
	}
	
}