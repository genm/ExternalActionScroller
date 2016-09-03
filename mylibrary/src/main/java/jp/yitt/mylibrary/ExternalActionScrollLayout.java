package jp.yitt.mylibrary;

import android.view.KeyEvent;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by genm1023 on 9/3/16.
 */
public class ExternalActionScrollLayout implements ScrollDirectionLister{
    private ListView listView;
    private KeyEvent upScrollKey;
    private KeyEvent downScrollKey;

    public static class Builder{
        private ListView listView;

        private KeyEvent upScrollKey;
        private KeyEvent downScrollKey;


        Builder(ListView listView){
            this.listView = listView;
        }
        Builder scrollKey(KeyEvent upScrollKey,KeyEvent downScrollKey){
            this.upScrollKey = upScrollKey;
            this.downScrollKey = downScrollKey;
            return this;
        }
        ExternalActionScrollLayout build(){
            if(listView == null){
                throw new NullPointerException();
            }
            return new ExternalActionScrollLayout(this);
        }

    }

    private ExternalActionScrollLayout(Builder builder){
        this.listView = builder.listView;
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
