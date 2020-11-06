package horizon.baselibrary.util;

import android.content.Context;

/**
 * @Author Horizon
 * @ClasssName FD
 * @Description fixed Data
 * @UpdateDate 2020/10/29 3:09 PM
 */
public class FD {
    public static final int matchParent = -1;
    public static final int wrapContent = -2;
    public static final int standWidth = 375;

    public static float getDp2Px(Context context, float unitDp) {
        int relWidth = context.getResources().getDisplayMetrics().widthPixels;
        return relWidth * (unitDp / standWidth);
    }

    public static int getRealWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getRealHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
