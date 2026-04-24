import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        INCHES(1.0),
        FEET(12.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    public Length(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException();
        if (unit == null) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBase() {
        return value * unit.getFactor();
    }

    private boolean compare(Length that) {
        double epsilon = 1e-6;
        return Math.abs(this.toBase() - that.toBase()) < epsilon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length that = (Length) o;
        return compare(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.round(toBase() * 1000));
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException();
        double base = toBase();
        double converted = base / targetUnit.getFactor();
        converted = Math.round(converted * 100.0) / 100.0;
        return new Length(converted, targetUnit);
    }

    private double fromBase(double base, LengthUnit targetUnit) {
        double result = base / targetUnit.getFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    public Length add(Length that) {
        if (that == null) throw new IllegalArgumentException();
        double sumBase = this.toBase() + that.toBase();
        double result = fromBase(sumBase, this.unit);
        return new Length(result, this.unit);
    }

    public Length add(Length that, LengthUnit targetUnit) {
        if (that == null || targetUnit == null) throw new IllegalArgumentException();
        double sumBase = this.toBase() + that.toBase();
        double result = fromBase(sumBase, targetUnit);
        return new Length(result, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}