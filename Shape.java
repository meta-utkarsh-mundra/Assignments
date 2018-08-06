package shapes;
import java.util.Date;

public interface Shape {
	public double getArea();
	public double getPerimeter();
	public boolean isPointEnclosed(Point p);
	public Point getOrigin();
	public ShapeType getShapeType();
	public Date getTimestamp();
	public void setTimestamp(Date timestamp);
    public enum ShapeType {
    	SQUARE, TRIANGLE, POLYGON, CIRCLE, RECTANGLE;
    }
}
