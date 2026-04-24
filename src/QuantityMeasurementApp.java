public class QuantityMeasurementApp {

    public static boolean demonstrateWeightEquality(QuantityWeight w1, QuantityWeight w2) {
        return w1.equals(w2);
    }

    public static boolean demonstrateWeightComparison(double v1, WeightUnit u1, double v2, WeightUnit u2) {
        return new QuantityWeight(v1, u1).equals(new QuantityWeight(v2, u2));
    }

    public static QuantityWeight demonstrateWeightConversion(double value, WeightUnit from, WeightUnit to) {
        return new QuantityWeight(value, from).convertTo(to);
    }

    public static QuantityWeight demonstrateWeightConversion(QuantityWeight weight, WeightUnit to) {
        return weight.convertTo(to);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight w1, QuantityWeight w2) {
        return w1.add(w2);
    }

    public static QuantityWeight demonstrateWeightAddition(QuantityWeight w1, QuantityWeight w2, WeightUnit target) {
        return w1.add(w2, target);
    }

    public static void main(String[] args) {
        QuantityWeight w1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000, WeightUnit.GRAM);

        System.out.println(demonstrateWeightEquality(w1, w2));

        QuantityWeight converted = demonstrateWeightConversion(2, WeightUnit.POUND, WeightUnit.KILOGRAM);
        System.out.println(converted);

        QuantityWeight sum = demonstrateWeightAddition(w1, w2);
        System.out.println(sum);
    }
}