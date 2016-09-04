package jp.yitt.genm.externalactionscroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.yitt.mylibrary.ExternalActionScroller;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<String> list = new ArrayList<>();
        for (int i=1; i<=100; i++){
            list.add("Item"+i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        ExternalActionScroller easl = new ExternalActionScroller.Builder(listView).key(KeyEvent.KEYCODE_VOLUME_UP, KeyEvent.KEYCODE_VOLUME_DOWN).build();

        easl.start();


    }
}
