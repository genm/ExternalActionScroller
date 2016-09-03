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
    private int upScrollKey;
    private int downScrollKey;

    public static class Builder{
        private ListView listView;
        private int upScrollKey;
        private int downScrollKey;


        public Builder(ListView listView){
            this.listView = listView;
        }
        public Builder scrollKey(int upScrollKey,int downScrollKey){
            this.upScrollKey = upScrollKey;
            this.downScrollKey = downScrollKey;
            return this;
        }
        public ExternalActionScrollLayout build(){
            if(listView == null){
                throw new NullPointerException();
            }
            return new ExternalActionScrollLayout(this);
        }

    }

    public ExternalActionScrollLayout(Builder builder){
        if(listView != null)this.listView = builder.listView;
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
