import java.util.ArrayList;

public class Trees {
	
	public static ArrayList<Trees> TreeList = new ArrayList<Trees>();
	public static int TemplateX = 100, TemplateY = 100, TemplateW = 25, TemplateH = 50;
	
	private int x, y, w, h;
	
	public Trees(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public static void MakeTree(int x, int y, int w, int h){
		TreeList.add(new Trees(x, y, w, h));
	}
	
	public static void MakeForest(int x, int y, int w, int h){
		MakeTree(x, y, w, h);
		MakeTree(x+w*3/2, y+h*1/8, w, h);
		MakeTree(x+w, y+h*1/2, w, h);
		MakeTree(x+w*2, y+h*1/4, w, h);
		MakeTree(x+w*1/5, y+h*3/4, w, h);
		MakeTree(x+w*3/2, y+h, w, h);
	}
	//TODO CAN REST AND RESTORE HAPPINESS UNDER TREES
	public int[] DrawTree(){
		return new int[] {x, y, w, h};
	}
}
