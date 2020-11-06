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
 * @ClasssName TopBar
 * @Description 线性布局，宽全屏，高自适应。有左中右3个部分，每个部分占1/3布局。
 * 通过 addSubView() 添加
 * @UpdateDate 2020/10/12 5:44 PM
 */
public abstract class LMRGroup<LE extends View, MID extends View, RI extends View> extends LinearLayout {
    protected LE mLeft;
    protected MID mMid;
    protected RI mRight;
    protected final int wrapContent = -2;
    protected final int matchParent = -1;
    protected Context mContext;
    protected Resources res;
    protected LayoutParams lp;

    protected void init(Context context) {
        mContext = context;
        res = getResources();

        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.CENTER_VERTICAL);
        setStatus_default();
        addSubView();
    }

    protected int getPx(float dp) {
        return (int) FD.getDp2Px(mContext, dp);
    }

    public LMRGroup(Context context) {
        super(context);
        init(context);
    }

    public LMRGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LMRGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LMRGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    /**
     * 初始化 LMR
     */
    protected abstract void setStatus_default();

    private void addSubView() {
        if (mLeft == null || mMid == null || mRight == null) {
            throw new NullPointerException("Null Point");
        }
        if(mLeft.getLayoutParams()==null){
            lp = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            mLeft.setLayoutParams(lp);
        }
        if(mMid.getLayoutParams()==null){
            lp = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2);
            mMid.setLayoutParams(lp);
        }
        if(mRight.getLayoutParams()==null){
            lp = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            mRight.setLayoutParams(lp);
        }
        addView(mLeft);
        addView(mMid);
        addView(mRight);
    }
}
