package horizon.fm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import horizon.baselibrary.util.ViewUtil;
import horizon.fm.data.FileData;
import horizon.fm.view.FileTreeItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FileTreeItem fileTree = new FileTreeItem(this);

        File interStorage = FileData.getInterStorage();
        fileTree.init(interStorage);

        ScrollView sv = ViewUtil.addScrollView(fileTree);
        HorizontalScrollView hsv = ViewUtil.addHorizonScrollView(sv);
        setContentView(hsv);
    }

    @SuppressLint("ShowToast")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 1) {
            Toast.makeText(this, "未能获得权限", Toast.LENGTH_LONG);
            finish();
        }
    }
}