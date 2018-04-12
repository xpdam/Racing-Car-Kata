package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private double LowPressureThreshold;
    private double HighPressureThreshold;

    private ISensor sensor;
    private boolean alarmOn = false;

    Alarm() {
        this(new Sensor());
    }

    Alarm(ISensor sensor) {
        this(sensor, 17., 21.);
    }

    Alarm(ISensor sensor, double lowPressureThreshold, double highPressureThreshold) {
        this.sensor = sensor;
        LowPressureThreshold = lowPressureThreshold;
        HighPressureThreshold = highPressureThreshold;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
