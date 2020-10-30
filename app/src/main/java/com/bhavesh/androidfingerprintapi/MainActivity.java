package com.bhavesh.androidfingerprintapi;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    FingerprintManagerCompat managerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    private void showFingerPrintDialog() {

        FingerprintDialog fragment = new FingerprintDialog();
        fragment.setContext(this);
        fragment.show(getSupportFragmentManager(), "");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                managerCompat = FingerprintManagerCompat.from(MainActivity.this);

                if (managerCompat.isHardwareDetected() && managerCompat.hasEnrolledFingerprints()) {
                    showFingerPrintDialog();
                } else {
                    Toast.makeText(getApplicationContext(), "Fingerprint not supported", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
