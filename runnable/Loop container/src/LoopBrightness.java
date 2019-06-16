

import java.io.IOException;
import java.io.PrintWriter;

public class LoopBrightness {

	public static void main(String[] args) {
		LoopBrightness loop = new LoopBrightness();
		loop.putMessage();

	} //END OF MAIN
	
	
	
	public synchronized void putMessage(){
		// SET BRIGHTNESS
		 String[] command =
	    {
	        "cmd",
	    };
	    Process p = null;
		try {
			p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	    PrintWriter stdin = new PrintWriter(p.getOutputStream());
	    
	    stdin.println("cd /");
	    stdin.println("cd \\_SEMESTRE 2_\\IHM\\ihm\\runnable");
	    for (int i=0; i!=-1; i++) {
		    Integer btni = 20*i%100;
		    String btn = btni.toString();
		    stdin.println("nircmd.exe setbrightness " + btn);
		    stdin.flush();
		    //wait some time
		    try {
				wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
	    }
	    stdin.close();
	}

}
