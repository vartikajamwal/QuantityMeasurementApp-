import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.FEET);
        assertTrue(result.equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.INCHES);
        assertTrue(result.equals(new Length(24.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.YARDS);
        assertEquals(0.67, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.CENTIMETERS);
        assertEquals(5.08, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_Commutativity() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length r1 = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.YARDS);
        Length r2 = QuantityMeasurementApp.demonstrateLengthAddition(l2, l1, Length.LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), 0.01);
    }

    @Test
    public void testAddition_WithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.YARDS);
        assertEquals(1.67, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_NegativeValues() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, Length.LengthUnit.INCHES);
        assertEquals(36.0, result.getValue(), 0.01);
    }

    @Test
    public void testAddition_NullTargetUnit() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.demonstrateLengthAddition(l1, l2, null));
    }
}