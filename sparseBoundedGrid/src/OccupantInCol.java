

public class OccupantInCol
{
    private Object occupant;
    private int col;
    public OccupantInCol() {
    	occupant = null;
    	col = -1;
	}
    public OccupantInCol(Object occupant, int col) {
    	this.occupant = occupant;
    	this.col = col;
	}
    public void setCol(int col) {
		this.col = col;
	}
    public int getCol() {
		return this.col;
	}
    public void setOccupant(Object occupant) {
		this.occupant = occupant;
	}
    public Object getOccupant() {
		return this.occupant;
	}
}