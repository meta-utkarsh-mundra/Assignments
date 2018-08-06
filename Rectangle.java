package shapes;

import java.util.Date;

public class Rectangle implements Shape {
	public Date timestamp = null;
	private double width, length; // rectangle's sides.
	Point obj; // for origin of rectangle
	
	/**
	 * @param width is the width of the rectangle.
	 * @param length is the length of the rectangle
	 * @param x is the x coordinate of the origin of the rectangle
	 * @param y is the y coordinate of the origin of the rectangle
	 */
	public Rectangle(double width, double length, double x , double y) {
		this.width = width;
		this.length = length;
	    obj = new Point(x, y);
	}
	// it returns the area of the rectangle.
	@Override
	public double getArea() {
		return width*length;
	}
    // it returns the perimeter of the rectangle.
	@Override
	public double getPerimeter() {
		return 2*(width + length);
		
	}
    // it checks if a podouble is enclosed in a circle or not
	@Override
	public boolean isPointEnclosed(Point p) {
		if((p.getX() > obj.getX() && p.getX() < obj.getX() + length) && 
				(p.getY() > obj.getY() && p.getY() < obj.getY() + width)) {
			return true;
		}
		return false;
	}
    // it returns the origin of the rectangle.
	@Override
	public Point getOrigin() {
		return obj;
	}
	@Override
	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
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
