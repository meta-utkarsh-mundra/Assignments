package shapes;

import java.util.Date;

public class Triangle implements Shape {
	public Date timestamp = null;
	double side1, side2, side3; //three sides of the triangle.
	Point origin; // podouble class object to take origin.
	Point p2, p3;
	double height; // height of the triangle
	/**
	 * @param side1, side2, side3 are sides of the triangle.
	 * @param x is the x coordinate of the origin of the triangle.
	 * @param y is the y coordinate of the origin of the triangle.
	 */
	public Triangle(double side1, double side2, double side3, double x , double y) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	    origin = new Point(x, y);
	}
	
	@Override
	public double getArea() {
		double s;
		s = (side1 + side2 + side3)/2;
		height = (2 * (double) Math.sqrt(s * (s - side1) * (s - side2) * (s - side3))) / (side1);
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	public void calculateOtherPoints() {
		getArea();
	    double x2, y2, x3, y3;
	    x2 = origin.getX() + side1;
	    y2 = origin.getY();
	    x3 = origin.getX() + height;
	    y3 = (double) Math.sqrt(((side3) * (side3)) - ((x3 - origin.getX()) * (x3 - origin.getX()))) + origin.getY();
	}
	@Override
	public double getPerimeter() {
		
		return side1 + side2 + side3;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		double totalArea = getArea();
		double area1 = p.getX() * (p3.getY() - origin.getY()) + p3.getX() * (origin.getY() - p.getY())
		               + origin.getX() * (p.getY() - p3.getY()) ;
		double area2 = p.getX() * (p2.getY() - origin.getY()) + p2.getX() * (origin.getY() - p.getY())
				       + origin.getX() * (p.getY() - p2.getY()) ;
		double area3 = p.getX() * (p3.getY() - p3.getY()) + p3.getX() * (p2.getY() - p.getY())
				       + p2.getX() * (p.getY() - p3.getY()) ;
		if((area1 + area2 + area3) == totalArea) {
			return true;
		}
		return false;
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.TRIANGLE;
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
