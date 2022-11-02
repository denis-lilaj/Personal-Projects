import java.awt.Color;
import java.awt.Graphics;

public class PaintStrings {
	
	LinkList2String names=new LinkList2String();
	
	int posX=50;
	int posY=50;
	int border1=150;
	int border2=150;
	
	
    int j=0;
	
    public void paint (Graphics g)
	{
    	if (border2!=posX)
    	{
		g.drawString(names.names[j], posX+=100, posY+=100);
		j++;
    	}
    	
    	else if (border2==posX)
    	{
    	 g.drawString(names.names[j], posX-=100, posY+=200);
    	 j++;
    		
    	}
	}
    
    
  

}


