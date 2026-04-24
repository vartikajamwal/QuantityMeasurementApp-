
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(0, Length.LengthUnit.FEET).equals(new Length(0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(0, Length.LengthUnit.INCHES).equals(new Length(0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1, Length.LengthUnit.FEET).equals(new Length(12, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1, Length.LengthUnit.FEET).equals(new Length(2, Length.LengthUnit.FEET)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(new Length(1, Length.LengthUnit.INCHES).equals(new Length(2, Length.LengthUnit.INCHES)));
    }

    @Test
    public void yardEquals36Inches() {
        assertTrue(new Length(1, Length.LengthUnit.YARDS).equals(new Length(36, Length.LengthUnit.INCHES)));
    }

    @Test
    public void centimeterEqualsInches() {
        assertTrue(new Length(2.54, Length.LengthUnit.CENTIMETERS).equals(new Length(1, Length.LengthUnit.INCHES)));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        assertTrue(new Length(3, Length.LengthUnit.FEET).equals(new Length(1, Length.LengthUnit.YARDS)));
    }

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        assertTrue(result.equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length lengthInYards = new Length(2.0, Length.LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, Length.LengthUnit.INCHES);
        assertTrue(result.equals(new Length(72.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }

    @Test
    public void testNaNValue() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, Length.LengthUnit.FEET));
    }
}