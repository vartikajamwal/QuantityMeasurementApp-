import java.util.Objects;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;
    private static final double EPSILON = 1e-6;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException();
        if (Double.isNaN(value) || Double.isInfinite(value)) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException();
        double base = toBase();
        double converted = targetUnit.convertFromBaseUnit(base);
        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) throw new IllegalArgumentException();
        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityWeight that = (QuantityWeight) obj;
        return Math.abs(this.toBase() - that.toBase()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBase() / EPSILON));
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}