package dataStructures.graph;

/**
 * This class is an implementation of the {@link Weight} interface.
 */
public class WeightImpl implements Weight {

	private double weight;

	public WeightImpl(double weight) {
		this.weight = weight;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Weight) {
			var c = (Weight) obj;
			return this.getWeight() == c.getWeight();
		}

		return false;
	}

	@Override
	public int hashCode() {
		return Double.hashCode(weight);
	}
}