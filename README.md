# ExternalActionScroller

ExternalActionScroller is Android library for scrollable view component(Ex. ListView RecyclerView) can be scrolled by pressing the external button on the you're Android smartphone.

# How do I use it?
## Setup

## Functions

## Simple
```
public class MyActivity extends Activity{
  public void onCreate(){
    super.onCreate();
    setContentView(R.layout.activity_list_view);

    ///////////////////
    /* Create Adapter*/
    ///////////////////
    
    ListView listView = (ListView)findViewById(R.id.listView);
    listView.setAdapter(adapter);
    
    
        
  }


}

```


## Options
* 