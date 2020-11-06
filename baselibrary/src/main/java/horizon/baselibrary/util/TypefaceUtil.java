package horizon.baselibrary.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * @Author Horizon
 * @ClasssName TypefaceUtil
 * @Description
 * @UpdateDate 2020/9/14 3:41 PM
 */
public class TypefaceUtil {
    public static Typeface getTypeface(Context context){
        return Typeface.createFromAsset(context.getAssets(), "icon_font.ttf");
    }
}
