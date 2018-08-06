package shapes;

import java.util.Date;

public class Polygon implements Shape {
	public Date timestamp = null;
	Point origin; // it is the origin of the polygon
	double apothem; // it is the perpendicular from the centre to one of the sides
	double side, number_of_sides;/* side is the length of each side and number_of_sides
                               *    is the number of sides of the polygon.*/	
	
	/**
	 * @param side is the length of a side
	 * @param numberOfSides is the total number of sides
	 * @param x is the x coordinate of the origin.
	 * @param y is the y coordinate of the origin.
	 */
	public Polygon(double side, double numberOfSides, double x, double y) {
		origin = new Point(x, y);
		this.side = side;
		this.number_of_sides = numberOfSides;
	}
	//it calculates the area of the polygon.
	@Override
	public double getArea() {
		apothem	= side/2* Math.tan(180/number_of_sides);
		double area = number_of_sides * side  * apothem/ 2;
		return area;
	}

	/* it calculates the perimeter of the polygon
	 */
	@Override
	public double getPerimeter() {
		
		return number_of_sides * side;
	}
    // it check whether a podouble is enclosed or not.
	@Override
	public boolean isPointEnclosed(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
    // it returns the origin of the polygon.
	@Override
	public Point getOrigin() {
		return origin;
	}
	@Override
	public ShapeType getShapeType() {
		return ShapeType.POLYGON;
	}
	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
		
	}
	
}
