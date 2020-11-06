package horizon.baselibrary.util.group;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import horizon.baselibrary.util.FD;

/**
 * @Author Horizon
 * @ClasssName LRGroup
 * @Description
 * @UpdateDate 2020/10/30 2:37 PM
 */
public abstract class LRGroup<Left extends View, Right extends View> extends LinearLayout {
    protected Left mLeft;
    protected Right mRight;
    protected final int wrapContent = -2;
    protected final int matchParent = -1;
    private float dpUnit;
    protected Context mContext;
    protected Resources res;
    protected LayoutParams lp;

    public LRGroup(Context context) {
        super(context);
        init(context);
    }

    public LRGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LRGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LRGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        res = getResources();
        dpUnit = FD.getDp2Px(context, 1);
        setGravity(Gravity.CENTER_VERTICAL);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setStatus_default();
        addSubView();
    }

    protected int getPx(int dp) {
        return (int) (dpUnit * dp);
    }

    /**
     * 设置默认状态值，一般用于测试，也用于默认状态
     */
    protected abstract void setStatus_default();

    private void addSubView(){
        if (mLeft == null || mRight == null) {
            throw new NullPointerException("Null Point");
        }
        addView(mLeft);
        addView(mRight);
    }
}
