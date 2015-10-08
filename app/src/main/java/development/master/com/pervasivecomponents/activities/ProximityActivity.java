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

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    /**
     * TextView which will update all sensor information.
     */
    private TextView sensorData;

    private SensorManager mSensorManager;
    private Sensor mProximity;
    private long lastUpdate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        final TextView title = (TextView) findViewById(R.id.sensor_title);
        title.setText(getString(R.string.proximity_activity));
        sensorData = (TextView) findViewById(R.id.sensor_data);
        sensorData.setVisibility(View.VISIBLE);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(mProximity == null) {
            Toast.makeText(this.getApplicationContext(),
                    "Sorry - your device doesn't have a proximity sensor!",
                    Toast.LENGTH_SHORT).show();
        } else {
            mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        final Sensor mySensor = sensorEvent.sensor;
        if (mySensor.getType() == Sensor.TYPE_PROXIMITY) {
            if (sensorEvent.values[0] == 0) {
                sensorData.setText("Near");
            } else {
                sensorData.setText("Far");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
