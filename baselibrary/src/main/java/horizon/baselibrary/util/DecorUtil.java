package horizon.baselibrary.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

/**
 * @Author Horizon
 * @ClasssName DecorUtil
 * @Description
 * @UpdateDate 2020/10/29 3:41 PM
 */
public class DecorUtil {
    public static void setDecorFullWhite(Context context){
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | SYSTEM_UI_FLAG_LAYOUT_STABLE);
        //黑色 View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                SYSTEM_UI_FLAG_FULLSCREEN
    }

    public static void setDecorWhite(Context context){
        int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(option);
    }

    public static void setDecorFullBlack(Context context){
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(option);
    }

    public static void setDecorBlack(Context context){
        int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        ((Activity)context).getWindow().getDecorView().setSystemUiVisibility(option);
    }

    public static void setColorTransparent(Context context){
        ((Activity)context).getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    public static void setColor(Context context, int color){
        ((Activity)context).getWindow().setStatusBarColor(color);
    }

    public static int getDecorBarHeight(Context context) {
        Activity activity = (Activity) context;
        int id = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources()
                .getDimensionPixelSize(id);
    }
}
