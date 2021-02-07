package io.github.lsposed.unittest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button_test);
        btn.setOnClickListener(l -> {
            int passed = Methods.runAll();
            Toast.makeText(this, String.format(Locale.ENGLISH, "%d of %d tests succeed.", passed, Methods.allTests), Toast.LENGTH_LONG).show();
        });
    }
}