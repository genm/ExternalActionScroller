package jp.yitt.genm.externalactionscroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jp.yitt.mylibrary.ExternalActionScroller;

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
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<String> list = new ArrayList<>();

    public RecyclerAdapter(List<String> dataset) {
        list.addAll(dataset);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((TextView)holder.itemView.findViewById(android.R.id.text1)).setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }else{
            return 0;
        }

    }
}