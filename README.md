# ExternalActionScroller

ExternalActionScroller is Android library for scrollable view component(Ex. ListView RecyclerView) can be scrolled by pressing the Hardware key on the you're Android smartphone :)


## Support Component
* ListView
* RecyclerView


# How do I use it?
## Setup
Gradle

```

```
## Functions


## Available Keycode
### Hardware Key

### KeyEvent Macro


### 

[KeyEvent AndroidDevelop](https://developer.android.com/reference/android/view/KeyEvent.html)


## ListView
```
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

        ExternalActionScroller eas = new ExternalActionScroller.Builder(listView).key(KeyEvent.KEYCODE_VOLUME_UP, KeyEvent.KEYCODE_VOLUME_DOWN).build();

    }
}


```

## RecyclerView
```
public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        List<String> list = new ArrayList<>();
        for (int i=1; i<=100; i++){
            list.add("Item"+i);
        }

        RecyclerAdapter adapter = new RecyclerAdapter(list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ExternalActionScroller eas = new ExternalActionScroller.Builder(recyclerView).key(KeyEvent.KEYCODE_VOLUME_UP, KeyEvent.KEYCODE_VOLUME_DOWN).build();


    }
}
```

## Options
* ```key(int upScrollKey, int downScrollKey)``` 
* ```duration(Int ms)``` 
* ```distance(Int dp)```
* ```autoSpeed(Int dpps)```  display point per second


# Use Case
## Twitter Client


## Ranking Board