package shapes;

import java.util.Date;

public class Square implements Shape {
	public Date timestamp = null;
	private double width;
	Point obj;
	public Square(double width, double x , double y) {
		this.width = width;
	    obj = new Point(x, y);
	}

	@Override
	public double getArea() {
		return width*width;
	}

	@Override
	public double getPerimeter() {
		return 4*width;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		if((p.getX() > obj.getX() && p.getX() < obj.getX() + width) && 
				(p.getY() > obj.getY() && p.getY() < obj.getY() + width)) {
			return true;
		}
		return false;
	}

	@Override
	public Point getOrigin() {
		return obj;
	}

	@Override
	public ShapeType getShapeType() {
		return ShapeType.SQUARE;
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
