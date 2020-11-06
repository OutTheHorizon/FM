package horizon.fm.data;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;

/**
 * @Author Horizon
 * @ClasssName FileData
 * @Description 文件管理器
 * @UpdateDate 2020/11/6 11:14 AM
 */
public class FileData {
    public static void requestPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
            //1 requestCode 可以在 Activity 里的 onRequestPermissionsResult 找到结果
        }
    }

    /**
     * 获得根目录
     */
    public static void getRootFile(){

    }

    /**
     * 获得手机内置存储（我最希望获得的地方）
     */
    public static File getInterStorage(){
        File interStorage = Environment.getExternalStorageDirectory();
        return interStorage;
    }

    /**
     * 获得子文件名称
     * @param par 父文件
     * @return 所有的子文件
     */
    public static File[] getFileItemName(File par){
        return par.listFiles();
    }
}
