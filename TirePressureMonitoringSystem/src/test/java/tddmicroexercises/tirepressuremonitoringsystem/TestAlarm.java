package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestAlarm {
    private Alarm alarm;
    private ISensor sensor = mock(ISensor.class);

    @Before
    public void setUp() {
        alarm = new Alarm(sensor);
    }

    @Test
    public void alarmShouldBeOffOnStartup() {
        alarm = new Alarm();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmShouldBeOffAfterCheckOnPressureBetweenThresholds() {
        when(sensor.popNextPressurePsiValue()).thenReturn(19.);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void alarmShouldBeOnAfterCheckOnPressureBelowLowerThreshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(15.);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void alarmShouldBeOnAfterCheckOnPressureAboveHigherThreshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(25.);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    public void pressureThresholdsShouldBeCustomizable() {
        when(sensor.popNextPressurePsiValue()).thenReturn(100.);
        alarm = new Alarm(sensor, 99, 101);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }
}
