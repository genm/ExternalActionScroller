package jp.yitt.mylibrary;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by genm1023 on 9/3/16.
 */
public class ExternalActionScrollLayout implements ScrollDirectionLister{
    private ListView listView;
    private RecyclerView recyclerView;
    private KeyEvent upScrollKey;
    private KeyEvent downScrollKey;

    public static class Builder{
        private ListView listView;
        private RecyclerView recyclerView;

        private KeyEvent upScrollKey;
        private KeyEvent downScrollKey;


        Builder(ListView listView){
            this.listView = listView;
        }
        Builder(RecyclerView recyclerView){
            this.recyclerView = recyclerView;
        }
        Builder scrollKey(KeyEvent upScrollKey,KeyEvent downScrollKey){
            this.upScrollKey = upScrollKey;
            this.downScrollKey = downScrollKey;
            return this;
        }
        ExternalActionScrollLayout build(){
            if(listView == null && recyclerView == null){
                throw new NullPointerException();
            }
            return new ExternalActionScrollLayout(this);
        }

    }

    private ExternalActionScrollLayout(Builder builder){
        if(listView != null)this.listView = builder.listView;
        if(recyclerView != null)this.recyclerView = builder.recyclerView;
        this.upScrollKey = builder.upScrollKey;
        this.downScrollKey = builder.downScrollKey;

    }

    @Override
    public void onScrollDown() {

    }

    @Override
    public void onScrollUp() {
        //smoothScrollToPosition()
    }




}
