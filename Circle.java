package shapes;

import java.util.Date;

public class Circle implements Shape {
	public Date timestamp = null;
	private double radius; //for the radius of the circle.
	Point obj; //for the origin of the circle.
	double c1, c2;//center coordinates of the circle.
	Point C;//center podouble, c1 and c2  are pssed in podouble constructor later.
	
	
	/**
	 * @param radius to take the radius of the circle
	 * @param x, its the x coordinate of the origin of the circle
	 * @param y, its the y coordinate of the origin of the circle
	 */
	public Circle(double radius, double x , double y) {
	    this.radius = radius;
	    obj = new Point(x, y);
	    c1 = (double) ((double) (((Math.sqrt(obj.getX()*obj.getX() + obj.getY()*obj.getY())) + radius)*obj.getX())
				   /(Math.sqrt(obj.getX()*obj.getX() + obj.getY()*obj.getY())));
	    c2 = (double) ((double) (((Math.sqrt(obj.getX()*obj.getX() + obj.getY()*obj.getY())) + radius)*obj.getY())
				   /(Math.sqrt(obj.getX()*obj.getX() + obj.getY()*obj.getY())));
	    C = new Point(c1, c2);
	}
	
	/**
	 * @return center of the circle
	 */
	private Point getCenter() {
	    return C;
	}
	
	/* 
	 * returns the area of the circle
	 */
	@Override
	public double getArea() {
            return Math.PI*(radius*radius);
	}

	/* returns the perimeter of the circle
	 */
	@Override
	public double getPerimeter() {
	     return 2*Math.PI*(radius);
	}

	/* @param Point p is an arbitrary podouble.
	 * this function checks whether the podouble passed as 
	 * parameter is inside the circle
	 * or not.
	 */
	@Override
	public boolean isPointEnclosed(Point p) {
	    if((double) Math.sqrt((p.getX()-c1)*(p.getX()-c1) + (p.getY()-c2)*(p.getY()-c2)) > radius) {
	       	return false;
		}
		return true;
	}

	/* it returns the origin of the circle
	 */
	@Override
	public Point getOrigin() {
		return obj;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.CIRCLE;
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
