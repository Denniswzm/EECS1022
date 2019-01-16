package ca.yorku.eecs.mcalcpro;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ca.roumani.i2c.MPro;



public class MCalcProActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, SensorEventListener {


    private TextToSpeech tts;


    public void buttonClicked(View v) {

        try {
            String principle = ((EditText) findViewById(R.id.pBox)).getText().toString();
            String amortization = ((EditText) findViewById(R.id.aBox)).getText().toString();
            String interest = ((EditText) findViewById(R.id.iBox)).getText().toString();


            MPro mp = new MPro();
            mp.setPrinciple(principle);
            mp.setAmortization(amortization);
            mp.setInterest(interest);

            int years = Integer.parseInt(amortization);

            String s = " Monthly Payment = $" + mp.computePayment("%,.2f");
            s += "\n\n";
            s += " By making this payments monthly for " + amortization +
                    " years, the mortgage will be paid in full. But if you terminate the mortgage on its n th anniversary, " +
                    "the balance still owing depends on n as shown below:";
            s += "\n\n";
            s += String.format("%8s %15s", "n", "Balance");
            s += "\n\n";

            for (int i = 1; i <= years; i++) {

                if (i < 5) {
                    s += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                    s += "\n\n";
                    ((TextView) findViewById(R.id.output)).setText(s);
                } else if (i == 10) {
                    s += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                    s += "\n\n";
                    ((TextView) findViewById(R.id.output)).setText(s);
                } else if (i == 15) {
                    s += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                    s += "\n\n";
                    ((TextView) findViewById(R.id.output)).setText(s);
                } else if (i == 20) {
                    s += String.format("%8d", i) + mp.outstandingAfter(i, "%,16.0f");
                    s += "\n\n";
                    ((TextView) findViewById(R.id.output)).setText(s);
                }

                tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);
            }

        } catch (Exception e) {
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.tts = new TextToSpeech(this, this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcalc_pro);

        SensorManager mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);


    }

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1)
        {

        }

        public void onSensorChanged(SensorEvent event)
        {
            double ax = event.values[0];
            double ay = event.values[1];
            double az = event.values[2];
            double a = Math.sqrt(ax * ax + ay * ay + az * az);
            if (a > 15)
            {
                ((EditText) findViewById(R.id.pBox)).setText("");
                ((EditText) findViewById(R.id.aBox)).setText("");
                ((EditText) findViewById(R.id.iBox)).setText("");
                ((TextView) findViewById(R.id.output)).setText("");
            }
        }




    public void onInit(int initStatus) {
        this.tts.setLanguage(Locale.US);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}
