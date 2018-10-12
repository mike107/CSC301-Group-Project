import javax.swing.JButton;

public class JButtonTag extends JButton {

	int tag = 0;
	
	
	public JButtonTag(String title, int tag) {
		super(title);
		this.tag = tag;
		
	}
	
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	public int getTag() {
		return tag;
	}
	
	
}
