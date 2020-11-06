package horizon.baselibrary.util.group;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import horizon.baselibrary.util.FD;

/**
 * @Author Horizon
 * @ClasssName VerticalGroup
 * @Description
 * @UpdateDate 2020/10/30 4:20 PM
 */
public abstract class HorizonGroup extends LinearLayout {
    protected static final int matchParent = -1;
    protected static final int wrapContent = -2;
    protected Context mContext;
    protected Resources res;

    protected LayoutParams lp;

    public HorizonGroup(Context context) {
        super(context);
        init(context);
    }

    public HorizonGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HorizonGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public HorizonGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        res = getResources();
        setStatus_default();
    }

    protected int getPx(float dp) {
        return (int) FD.getDp2Px(mContext, dp);
    }

    protected abstract void setStatus_default();
}
