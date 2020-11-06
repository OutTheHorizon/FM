package horizon.baselibrary.util;

import android.app.Activity;
import android.content.Intent;

/**
 * @Author Horizon
 * @ClasssName AnimalUtil
 * @Description
 * @UpdateDate 2020/10/30 3:28 PM
 */
public class AnimalUtil {
    public static void slideL2R(Activity context, Class<? extends Activity> c) {
        context.startActivity(new Intent(context, c));
        context.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public static void slideR2L(Activity context, Class<? extends Activity> c) {
        context.startActivity(new Intent(context, c));
        context.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
    }

    public static void slideL2R(Activity context) {
        context.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public static void slideR2L(Activity context) {
        context.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
    }

    public static void fadeIn(Activity activity){
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public static void fadeOut(Activity activity){
        activity.overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
    }
}
