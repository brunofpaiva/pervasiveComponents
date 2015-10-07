package development.master.com.pervasivecomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import development.master.com.pervasivecomponents.activities.AccelerometerActivity;
import development.master.com.pervasivecomponents.activities.AmbientTemperatureActivity;
import development.master.com.pervasivecomponents.activities.LightActivity;
import development.master.com.pervasivecomponents.activities.PressureActivity;
import development.master.com.pervasivecomponents.activities.RelativeHumidityActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textAccelerometer = (TextView) findViewById(R.id.sensorAccelerometer);
        textAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.ACCELEROMETER_SENSOR);
            }
        });

        TextView textAmbientTemperature = (TextView) findViewById(R.id.sensorAmbientTemperature);
        textAmbientTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.AMBIENTE_TEMPERATURE_SENSOR);
            }
        });

        TextView textGravity = (TextView) findViewById(R.id.sensorGravity);
        textGravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.GRAVITY_SENSOR);
            }
        });

        TextView textGyroscope = (TextView) findViewById(R.id.sensorGyroscope);
        textGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.GYROSCOPE_SENSOR);
            }
        });

        TextView textLight = (TextView) findViewById(R.id.sensorLight);
        textLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.LIGHT_SENSOR);
            }
        });

        TextView textLinearAcceleration = (TextView) findViewById(R.id.sensorLinearAcceleration);
        textLinearAcceleration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.LINEAR_ACCELERATION_SENSOR);
            }
        });

        TextView textMagneticField = (TextView) findViewById(R.id.sensorMagneticField);
        textMagneticField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.MAGNETIC_FIELD_SENSOR);
            }
        });

        TextView textOrientation = (TextView) findViewById(R.id.sensorOrientation);
        textOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.ORIENTATION_SENSOR);
            }
        });

        TextView textPressure = (TextView) findViewById(R.id.sensorPressure);
        textPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.PRESSURE_SENSOR);
            }
        });

        TextView textProximity = (TextView) findViewById(R.id.sensorProximity);
        textProximity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.PROXIMITY_SENSOR);
            }
        });

        TextView textRelativeHumidity = (TextView) findViewById(R.id.sensorRelativeHumidity);
        textRelativeHumidity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.RELATIVE_HUMIDITY_SENSOR);
            }
        });

        TextView textRotationVector = (TextView) findViewById(R.id.sensorRotationVector);
        textRotationVector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.ROTATION_VECTOR_SENSOR);
            }
        });

        TextView textTemperature = (TextView) findViewById(R.id.sensorTemperature);
        textTemperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                activateSensor(SensorType.TEMPERATURE_SENSOR);
            }
        });

    }

    /**
     * Activates a sensor that is received.
     *
     * @param sensor The SensorType that indicates wich sensor will be used.
     */
    public void activateSensor(final SensorType sensor) {
        Intent intent = null;

        switch (sensor) {
            case ACCELEROMETER_SENSOR:

                intent = new Intent(this, AccelerometerActivity.class);
                break;

            case AMBIENTE_TEMPERATURE_SENSOR:

                intent = new Intent(this, AmbientTemperatureActivity.class);
                break;

            case GRAVITY_SENSOR:

//                intent = new Intent(this, GravityActivity.class);
                break;

            case GYROSCOPE_SENSOR:

//                intent = new Intent(this, GyroscopeActivity.class);
                break;

            case LIGHT_SENSOR:

                intent = new Intent(this, LightActivity.class);
                break;

            case LINEAR_ACCELERATION_SENSOR:
//                intent = new Intent(this, LinearAccelerationActivity.class);
                break;

            case MAGNETIC_FIELD_SENSOR:
                break;

            case ORIENTATION_SENSOR:
                break;

            case PRESSURE_SENSOR:

                intent = new Intent(this, PressureActivity.class);
                break;

            case PROXIMITY_SENSOR:
                break;

            case RELATIVE_HUMIDITY_SENSOR:
                intent = new Intent(this, RelativeHumidityActivity.class);
                break;

            case ROTATION_VECTOR_SENSOR:
                break;

            case TEMPERATURE_SENSOR:
                break;

        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}
