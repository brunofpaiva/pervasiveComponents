package development.master.com.pervasivecomponents.activities;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import development.master.com.pervasivecomponents.R;

public class GravityActivity extends AppCompatActivity implements SensorEventListener {

    /**
     * TextView which will update all sensor information.
     */
    private TextView sensorData;

    private SensorManager senseManage;
    private Sensor envSense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        final TextView title = (TextView) findViewById(R.id.sensor_title);
        title.setText(getString(R.string.ambient_temperature_activity));
        sensorData = (TextView) findViewById(R.id.sensor_data);

        senseManage = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        envSense = senseManage.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if(envSense == null) {
            Toast.makeText(this.getApplicationContext(),
                    "Sorry - your device doesn't have a gravity sensor!",
                    Toast.LENGTH_SHORT).show();
        } else {
            senseManage.registerListener(this, envSense, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        senseManage.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
