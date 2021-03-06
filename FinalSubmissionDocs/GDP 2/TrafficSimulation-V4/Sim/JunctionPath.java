import java.awt.Graphics2D;
import java.util.Iterator;

import Utils.scale.sc;

public class JunctionPath extends CarContainer {

	private JunctionModel parent;
	private int endLaneID;

	//iD = ID of lane that ends to become this
	//endLaneID = ID of lane that starts when this ends.

	public JunctionPath(int startiD,int endID,JunctionModel parent,
											int startX,int startY,int endX,int endY) {

		super(startiD,startX,startY,endX,endY);
		this.parent = parent;
		endLaneID = endID;
	}

	public boolean isLastOne() {
		return false;
	} 

	public void drawAllGhostCars(Graphics2D g2d, sc scaleManager) {
		final Iterator iterator = cars.iterator();
		while (iterator.hasNext()) {
	    final Car tempcar =(Car)iterator.next();
	    tempcar.drawGhostCar(g2d,scaleManager);
		}
	}

	public CarContainer onToNext() {
		//System.out.println("onToNext() in JunctionPath "+iD);
		return parent.getnextLane(endLaneID);
	}

	public int getEndLaneID() { return endLaneID; }

	public int getParentID() { return parent.getID(); }
}













