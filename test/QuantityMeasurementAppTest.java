import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void kilogramEquals1000Grams() {
        assertTrue(new QuantityWeight(1, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000, WeightUnit.GRAM)));
    }

    @Test
    public void poundEquals453Point592Grams() {
        assertTrue(new QuantityWeight(1, WeightUnit.POUND)
                .equals(new QuantityWeight(453.592, WeightUnit.GRAM)));
    }

    @Test
    public void kilogramNotEqualToPound() {
        assertFalse(new QuantityWeight(1, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1, WeightUnit.POUND)));
    }

    @Test
    public void conversionKilogramToGram() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);
        assertEquals(1000, result.getValue(), 1e-6);
    }

    @Test
    public void conversionPoundToKilogram() {
        QuantityWeight result = new QuantityWeight(2.20462, WeightUnit.POUND)
                .convertTo(WeightUnit.KILOGRAM);
        assertEquals(1, result.getValue(), 1e-3);
    }

    @Test
    public void additionSameUnit() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(2, WeightUnit.KILOGRAM));
        assertEquals(3, result.getValue(), 1e-6);
    }

    @Test
    public void additionCrossUnit() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000, WeightUnit.GRAM));
        assertEquals(2, result.getValue(), 1e-6);
    }

    @Test
    public void additionWithTargetUnit() {
        QuantityWeight result = new QuantityWeight(1, WeightUnit.KILOGRAM)
                .add(new QuantityWeight(1000, WeightUnit.GRAM), WeightUnit.GRAM);
        assertEquals(2000, result.getValue(), 1e-6);
    }

    @Test
    public void zeroValueEquality() {
        assertTrue(new QuantityWeight(0, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(0, WeightUnit.GRAM)));
    }

    @Test
    public void negativeValueEquality() {
        assertTrue(new QuantityWeight(-1, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(-1000, WeightUnit.GRAM)));
    }
}