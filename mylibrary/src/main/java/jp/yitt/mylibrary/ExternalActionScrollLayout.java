package jp.yitt.mylibrary;

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
    private boolean reverceEnabled = false;
    private int scrollDuration = 1200;
    private int scrollDistance = 250;

    public static class Builder{
        private ListView listView;
        private int upScrollKey;
        private int downScrollKey;
        private int scrollDuration = 1200;
        private int scrollDistance = 250;


        public Builder(ListView listView){
            this.listView = listView;

        }
        public Builder key(int upScrollKey,int downScrollKey){
            this.upScrollKey = upScrollKey;
            this.downScrollKey = downScrollKey;

            return this;
        }
        public Builder duration(int ms){
            this.scrollDuration = ms;
            return this;
        }
        public Builder distance(int ms){
            this.scrollDistance = ms;
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
    public void setKey(int upScrollKey, int downScrollKey){
        this.upScrollKey = upScrollKey;
        this.downScrollKey = downScrollKey;
    }

    public void start(){
        if (listView != null){
            setListViewKeyEvent();
        }


    }
    public void setReverseEnabled(boolean state){
        this.reverceEnabled = state;
    }

    private void setListViewKeyEvent(){
        listView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch (event.getAction()) {
                    case KeyEvent.ACTION_UP:
                        if (keyCode == upScrollKey) {

                            if (reverceEnabled) {
                                listView.smoothScrollBy(scrollDistance, scrollDuration);
                            } else {
                                listView.smoothScrollBy(-scrollDistance, scrollDuration);
                            }
                            return true;
                        }
                        if (keyCode == downScrollKey) {
                            if (reverceEnabled) {
                                listView.smoothScrollBy(-scrollDistance, scrollDuration);
                            } else {
                                listView.smoothScrollBy(scrollDistance, scrollDuration);
                            }
                            return true;
                        }

                    case KeyEvent.ACTION_DOWN:
                        if (keyCode == upScrollKey) {
                            if (event.isLongPress()) {
                            } else {

                            }
                            return true;
                        }
                        if (keyCode == downScrollKey) {
                            if (event.isLongPress()) {

                            } else {

                            }
                            return true;

                        }
                }

                return false;
            }

        });

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

