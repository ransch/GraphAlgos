package dataStructures.graph;

/**
 * This class is an implementation of the {@link Color} interface.
 */
public class ColorImpl implements Color {

	private int color;

	public ColorImpl(int color) {
		assert (color >= 0);
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public void setColor(int color) {
		assert (color >= 0);
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Color) {
			var c = (Color) obj;
			return this.getColor() == c.getColor();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return color;
	}
}