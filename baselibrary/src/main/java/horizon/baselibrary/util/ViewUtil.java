package horizon.baselibrary.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import horizon.baselibrary.util.FD;

/**
 * @Author Horizon
 * @ClasssName ViewUtil
 * @Description
 * @UpdateDate 2020/10/29 2:58 PM
 */
public class ViewUtil {
    public static ScrollView addScrollView(View child) {
        ScrollView scrollView = new ScrollView(child.getContext());
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(FD.matchParent, FD.matchParent));
        scrollView.addView(child);
        return scrollView;
    }

    public static HorizontalScrollView addHorizonScrollView(View child) {
        HorizontalScrollView sv = new HorizontalScrollView(child.getContext());
        sv.setLayoutParams(new FrameLayout.LayoutParams(FD.matchParent, FD.matchParent));
        sv.addView(child);
        return sv;
    }

    public static LinearLayout addVerticalLinear(View child) {
        LinearLayout ll = new LinearLayout(child.getContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(new FrameLayout.LayoutParams(FD.wrapContent, FD.wrapContent));
        ll.addView(child);
        return ll;
    }

    public static TextView  createLine(Context context, int color){
        TextView view = new TextView(context);
        view.setBackgroundColor(color);
        return view;
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        //显示软键盘
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        //如果上面的代码没有弹出软键盘 可以使用下面另一种方式
        //InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        // imm.showSoftInput(editText, 0);
    }
}
