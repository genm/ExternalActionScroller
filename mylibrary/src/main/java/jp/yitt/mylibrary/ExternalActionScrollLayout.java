package jp.yitt.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
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
            this.listView = builder.listView;
            this.upScrollKey = builder.upScrollKey;
            this.downScrollKey = builder.downScrollKey;

    }
    public void setScrollKey(int upScrollKey, int downScrollKey){
        this.upScrollKey = upScrollKey;
        this.downScrollKey = downScrollKey;
    }

    public void start(){

        listView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch (event.getAction()){
                    case KeyEvent.ACTION_UP:
                        if (keyCode == upScrollKey){

                            return true;
                        }
                        if (keyCode == downScrollKey){

                            return true;
                        }

                        break;
                    case KeyEvent.ACTION_DOWN:
                        if (keyCode == upScrollKey)return true;
                        if (keyCode == downScrollKey)return true;


                        break;
                }
                
                return false;
            }

        });


    }
    private void setListViewKeyEvent(){

    }

    public void setDuration(int duration){
        //
    }

    @Override
    public void onScrollDown() {
        //listView.smoo
    }

    @Override
    public void onScrollUp() {

    }




}

