package jp.yitt.mylibrary;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

/**
 * Created by genm1023 on 9/4/16.
 */
public class AutoScroller {
    public enum Direction{
        DOWN,
        UP
    }
    Direction direction;

    private static final int DEFAULT_SPEED = 100;
    private static final int INTERVAL = 50;
    private ListView listView;
    private RecyclerView recyclerView;
    private int distance;

    public AutoScroller(ListView listView){
        this(listView, DEFAULT_SPEED);
    }
    public AutoScroller(RecyclerView recyclerView){
        this(recyclerView, DEFAULT_SPEED);
    }
    public AutoScroller(ListView listView,int speed){
        this.listView = listView;
        this.distance = (int) ((double)speed * (double)INTERVAL / (double)1000);
    }
    public AutoScroller(RecyclerView recyclerView, int speed){
        this.recyclerView = recyclerView;
        this.distance = (int) ((double)speed * (double)INTERVAL / (double)1000);
    }

    public void start(Direction direction){
        this.direction = direction;
        autoScrollHandler.postDelayed(autoScrollRunnable,INTERVAL);
    }
    public void stop(){
        autoScrollHandler.removeCallbacksAndMessages(null);
    }
    private final Handler autoScrollHandler = new Handler();
    private final Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            if(direction == Direction.DOWN){
                listView.smoothScrollBy(distance, INTERVAL);
            }else{
                listView.smoothScrollBy(-distance, INTERVAL);
            }
        }
    };
}