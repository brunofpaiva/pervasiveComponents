package development.master.com.pervasivecomponents.activities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import development.master.com.pervasivecomponents.R;

public class TemperatureActivity extends AppCompatActivity implements SensorEventListener {

    private TextView sensorData;

    private SensorManager mSensorManager;
    private Sensor mTemperature;
    private long lastUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        final TextView title = (TextView) findViewById(R.id.sensor_title);
        title.setText(getString(R.string.temperature_activity));
        sensorData = (TextView) findViewById(R.id.sensor_data);
        sensorData.setVisibility(View.VISIBLE);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);
        if(mTemperature == null) {
            Toast.makeText(this.getApplicationContext(),
                    "Sorry - your device doesn't have a temperature sensor!",
                    Toast.LENGTH_SHORT).show();
        } else {
            mSensorManager.registerListener(this, mTemperature, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mTemperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        final Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_TEMPERATURE) {
            float temp = sensorEvent.values[0];

            long curTime = System.currentTimeMillis();
            if ((curTime - lastUpdate) > 100) {
                sensorData.setText("Temperature of Phone is: " + temp);
                lastUpdate = curTime;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
