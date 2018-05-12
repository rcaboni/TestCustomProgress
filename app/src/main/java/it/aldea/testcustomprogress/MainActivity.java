package it.aldea.testcustomprogress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout lProgress = findViewById(R.id.lProgress);
        final TextView tvTitle = findViewById(R.id.tvProgressTitle);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int level = lProgress.getBackground().getLevel(); // from 0 to 10000 = 100%
                if (level > 10000) {
                    level = 0;
                }

                if (level >= 8500) {
                    //((ClipDrawable) lProgress.getBackground()).setDrawable(getDrawable(R.drawable.green_shape));
                    //Drawable d = ((ClipDrawable) lProgress.getBackground()).getCurrent();
                    setProgressColor(lProgress, R.drawable.red_level);
                } else if (level >= 6500) {
                    setProgressColor(lProgress, R.drawable.yellow_level);
                } else {
                    setProgressColor(lProgress, R.drawable.green_level);
                }
                //lProgress.getBackground().setLevel(level + 1000);
                level = level + 1000;
                setProgressValue(lProgress, tvTitle, level / 100);
            }
        });
    }

    private void setProgressColor(LinearLayout lProgress, int drawableResourceId) {
        if (lProgress != null) {
            lProgress.setBackgroundResource(drawableResourceId);
        }
    }

    private void setProgressValue(LinearLayout lProgress, TextView progressTitle, int perc) {
        if (lProgress != null) {
            lProgress.getBackground().setLevel(perc * 100);
            progressTitle.setText(String.format("%2d°", perc));
        }
    }
}
