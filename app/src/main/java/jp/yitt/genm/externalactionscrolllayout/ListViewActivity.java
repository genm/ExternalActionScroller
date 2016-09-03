package jp.yitt.genm.externalactionscrolllayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import jp.yitt.mylibrary.ExternalActionScrollLayout;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = {"Cat","Dog","Mouse","Elephant","Lion","Penguin","Turtle","Dolphin","Crocodile","Monkey","Gorilla"};

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

        ExternalActionScrollLayout easl = new ExternalActionScrollLayout.Builder(listView).scrollKey(KeyEvent.KEYCODE_VOLUME_UP, KeyEvent.KEYCODE_VOLUME_DOWN).build();
        easl.start();


    }
}
