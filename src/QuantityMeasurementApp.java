public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1, double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return demonstrateLengthEquality(l1, l2);
    }

    public static Length demonstrateLengthConversion(double value, Length.LengthUnit from, Length.LengthUnit to) {
        Length length = new Length(value, from);
        return length.convertTo(to);
    }

    public static Length demonstrateLengthConversion(Length length, Length.LengthUnit toUnit) {
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length demonstrateLengthAddition(Length l1, Length l2, Length.LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {
        System.out.println(demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.FEET));

        System.out.println(demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES));

        System.out.println(demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS));
    }
}