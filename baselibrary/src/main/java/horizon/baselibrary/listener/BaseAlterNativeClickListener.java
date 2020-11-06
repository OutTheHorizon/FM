package horizon.baselibrary.listener;


import android.view.View;

/**
 * @author Horizon
 * 二选一的点击监听。
 */
public abstract class BaseAlterNativeClickListener implements View.OnClickListener {
    private boolean mIsFirst = true;

    @Override
    public void onClick(View v) {
        doWhat(v);
        mIsFirst = !mIsFirst;
    }

    private void doWhat(View v) {
        if (mIsFirst) {
            firstDoThing(v);
        } else {
            thenDoThing(v);
        }
    }

    /**
     * 点击后第一次会做的事
     */
    protected abstract void firstDoThing(View v);

    /**
     * 第二次会做的事
     */
    protected abstract void thenDoThing(View v);
}