public class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    private double convertFromBaseToTargetUnit(double baseValue, LengthUnit targetUnit) {
        return targetUnit.convertFromBaseUnit(baseValue);
    }

    private boolean compare(Length thatLength) {
        return Math.abs(this.convertToBaseUnit() - thatLength.convertToBaseUnit()) < 0.01;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Length)) return false;
        Length that = (Length) o;
        return compare(that);
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException();
        double base = convertToBaseUnit();
        double converted = convertFromBaseToTargetUnit(base, targetUnit);
        return new Length(converted, targetUnit);
    }

    public Length add(Length thatLength) {
        return addAndConvert(thatLength, this.unit);
    }

    public Length add(Length thatLength, LengthUnit targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException();
        return addAndConvert(thatLength, targetUnit);
    }

    private Length addAndConvert(Length length, LengthUnit targetUnit) {
        double base1 = this.convertToBaseUnit();
        double base2 = length.convertToBaseUnit();
        double sum = base1 + base2;
        double result = convertFromBaseToTargetUnit(sum, targetUnit);
        return new Length(result, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}