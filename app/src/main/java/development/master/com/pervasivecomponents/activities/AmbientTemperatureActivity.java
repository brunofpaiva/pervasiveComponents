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

public class AmbientTemperatureActivity extends AppCompatActivity implements SensorEventListener {

    /**
     * TextView which will update all sensor information.
     */
    private TextView sensorData;

    private SensorManager mSensorManager;
    private Sensor mAmbientTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        final TextView title = (TextView) findViewById(R.id.sensor_title);
        title.setText(getString(R.string.ambient_temperature_activity));
        sensorData = (TextView) findViewById(R.id.sensor_data);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAmbientTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if(mAmbientTemperature == null) {
            Toast.makeText(this.getApplicationContext(),
                    "Sorry - your device doesn't have an ambient temperature sensor!",
                    Toast.LENGTH_SHORT).show();
        } else {
            mSensorManager.registerListener(this, mAmbientTemperature, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float sensorValue = event.values[0];

        String envInfo = "";

        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            envInfo = sensorValue + " degrees Celsius";
        }

        sensorData.setVisibility(View.VISIBLE);
        sensorData.setText(envInfo);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        String accuracyMsg = "";
        switch(accuracy){
            case SensorManager.SENSOR_STATUS_ACCURACY_HIGH:
                accuracyMsg="Sensor has high accuracy";
                break;
            case SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM:
                accuracyMsg="Sensor has medium accuracy";
                break;
            case SensorManager.SENSOR_STATUS_ACCURACY_LOW:
                accuracyMsg="Sensor has low accuracy";
                break;
            case SensorManager.SENSOR_STATUS_UNRELIABLE:
                accuracyMsg="Sensor has unreliable accuracy";
                break;
            default:
                break;
        }

        Toast.makeText(this.getApplicationContext(), accuracyMsg, Toast.LENGTH_SHORT).show();
    }
}
