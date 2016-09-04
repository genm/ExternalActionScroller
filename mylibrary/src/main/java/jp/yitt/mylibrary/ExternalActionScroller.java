package jp.yitt.mylibrary;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by genm1023 on 9/3/16.
 */
public class ExternalActionScroller implements ScrollDirectionLister {

    private final int DEFAULT_DURATION = 1000;
    private final int DEFAULT_DISTANCE = 300;
    private ListView listView;
    private RecyclerView recyclerView;
    private int upScrollKey;
    private int downScrollKey;
    private int speed;
    private int scrollDuration;
    private int scrollDistance;

    private AutoScroller autoScroller;
    private boolean auto = false;

    public static class Builder {
        private ListView listView;
        private RecyclerView recyclerView;
        private int upScrollKey;
        private int downScrollKey;
        private int speed;
        private int scrollDuration;
        private int scrollDistance;


        public Builder(ListView listView) {
            this.listView = listView;
        }
        public Builder(RecyclerView recyclerView){
            this.recyclerView = recyclerView;
        }

        public Builder key(int upScrollKey, int downScrollKey) {
            this.upScrollKey = upScrollKey;
            this.downScrollKey = downScrollKey;

            return this;
        }

        public Builder duration(int ms) {
            this.scrollDuration = ms;
            return this;
        }

        public Builder distance(int ms) {
            this.scrollDistance = ms;
            return this;
        }
        public Builder autoSpeed(int dpps){
            this.speed = dpps;
            return this;
        }

        public ExternalActionScroller build() {
            if (listView == null && recyclerView == null) {
                throw new NullPointerException();
            }
            return new ExternalActionScroller(this);
        }
    }

    public ExternalActionScroller(Builder builder) {
        this.upScrollKey = builder.upScrollKey;
        this.downScrollKey = builder.downScrollKey;
        this.speed = builder.speed;
        this.scrollDistance = builder.scrollDistance == 0? DEFAULT_DISTANCE : builder.scrollDistance;
        this.scrollDuration = builder.scrollDuration == 0? DEFAULT_DURATION : builder.scrollDuration;

        if(builder.listView != null){
            this.listView = builder.listView;
            if(speed == 0){
                autoScroller = new AutoScroller(listView);
            }else{
                autoScroller = new AutoScroller(listView,speed);
            }
            setListViewKeyEvent();

        }else if(builder.recyclerView != null){
            this.recyclerView = builder.recyclerView;
            if(speed == 0){
                autoScroller = new AutoScroller(recyclerView);
            }else{
                autoScroller = new AutoScroller(recyclerView,speed);
            }
            setRecyclerViewKeyEvent();
        }

    }


    private void setRecyclerViewKeyEvent(){

    }
    private void setListViewKeyEvent() {
        listView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d("KEY:",String.valueOf(event.getAction()));
                switch (event.getAction()) {
                    case KeyEvent.ACTION_UP:

                        if (keyCode == upScrollKey) {
                            if(!auto){
                                listView.smoothScrollBy(-scrollDistance, scrollDuration);
                            }
                            auto = false;
                            autoScroller.stop();
                            return true;
                        }
                        if (keyCode == downScrollKey) {
                            if(!auto){
                                listView.smoothScrollBy(scrollDistance, scrollDuration);
                            }
                            auto = false;
                            autoScroller.stop();
                            return true;
                        }

                    case KeyEvent.ACTION_DOWN:

                        if (keyCode == upScrollKey) {
                            if (event.isLongPress()) {
                                if(!auto){
                                    autoScroller.start(AutoScroller.Direction.UP);
                                    auto = true;
                                }
                            }
                            return true;
                        }
                        if (keyCode == downScrollKey) {
                            if (event.isLongPress()) {
                                if(!auto){
                                    autoScroller.start(AutoScroller.Direction.DOWN);
                                    auto = true;
                                }
                            }
                            return true;
                        }
                }
                return false;
            }

        });

    }

    @Override
    public void onScrollDown() {
        //listView.smoo
    }

    @Override
    public void onScrollUp() {

    }


}

