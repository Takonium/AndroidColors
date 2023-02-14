package hu.attila_takacs.androidcolors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ConstraintLayout display;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = rnd.nextInt(256);
                int green = rnd.nextInt(256);
                int blue = rnd.nextInt(256);
                display.setBackgroundColor(Color.rgb(red, green, blue));

                if (3 * 127 > 3 * red + green + blue) textView.setTextColor(Color.WHITE);
                else textView.setTextColor(Color.BLACK);

                String text = "(" + red + ", " + green + ", " + blue + ")";
                textView.setText(text);

                //textView.setTextColor(Color.rgb(255-red, 255-green, 255-green));
            }
        });

    }

    void init() {
        textView = findViewById(R.id.textView);
        display = findViewById(R.id.display);
        rnd = new Random();
    }
}