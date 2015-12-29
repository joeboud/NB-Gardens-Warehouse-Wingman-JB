
public class Location {

	public enum Sector{ A,B,C }
	
	Sector section = Sector.A;
	int row;
	int stack;
	int shelf;
	
	public Location(){
		this.section = section;
		this.row = row;
		this.stack = stack;
		this.shelf = shelf;
	}
	
}
