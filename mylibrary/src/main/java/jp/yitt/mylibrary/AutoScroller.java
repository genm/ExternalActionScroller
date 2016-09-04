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

    private static final int DEFAULT_SPEED = 1000;
    private static final int INTERVAL = 25;
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
        autoScrollHandler.post(autoScrollRunnable);
    }
    public void stop(){
        autoScrollHandler.removeCallbacksAndMessages(null);
    }
    private final Handler autoScrollHandler = new Handler();
    private final Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            if(listView != null){
                if(direction == Direction.DOWN){
                    listView.smoothScrollBy(distance, INTERVAL);
                }else{
                    listView.smoothScrollBy(-distance, INTERVAL);
                }
                autoScrollHandler.post(this);
            }else if(recyclerView != null){
                if(direction == Direction.DOWN){
                    recyclerView.scrollBy(0, distance);
                }else{
                    recyclerView.scrollBy(0, -distance);
                }
                autoScrollHandler.post(this);

            }
        }
    };
}
