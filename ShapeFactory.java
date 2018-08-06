package shapes;

import java.util.ArrayList;

import shapes.Shape.ShapeType;

/**
 * this class creates objects of various shape types
 */
public class ShapeFactory {
	/**
	 * method to create the object of specified shape type
	 * 
	 * @param shapeType
	 * @param origin
	 * @param parameters
	 *            , list of parameters vary according to shape type
	 */
	public static Shape createShape(Point origin, ShapeType shapeType,
			ArrayList<Double> parameterList) {
		switch (shapeType) {
		// parameters contains radius
		case CIRCLE:
			return new Circle(parameterList.get(0), origin.getX(), origin.getY());

			// parameters contains length, width
		case RECTANGLE:
			return new Rectangle(parameterList.get(0),
					parameterList.get(1), origin.getX(), origin.getY());

			// parameters contains side
		case SQUARE:
			return new Square(parameterList.get(0), origin.getX(), origin.getY());

			// parameters contains length of firstSide, length of secondSide,
			// length of thirdSide
		case TRIANGLE:
			return new Triangle(parameterList.get(0),
					parameterList.get(1), parameterList.get(2), origin.getX(), origin.getY());

			// parameters contains length of side, number of sides
		case POLYGON:
			return new Polygon(parameterList.get(0),
					parameterList.get(1), origin.getX(), origin.getY());

		default:
			throw new AssertionError("No such shape found");
		}
	}
}

