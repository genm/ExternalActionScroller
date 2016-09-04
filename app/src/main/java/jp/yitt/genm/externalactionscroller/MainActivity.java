package jp.yitt.genm.externalactionscroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lvButton = (Button)findViewById(R.id.list_example_button);
        Button rvButton = (Button) findViewById(R.id.recycler_example_button);

        lvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ListViewActivity.class);
                startActivity(intent);
            }
        });

        rvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplication(),)
            }
        });

    }
}
