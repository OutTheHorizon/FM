package horizon.fm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import horizon.baselibrary.util.ViewUtil;
import horizon.baselibrary.util.group.HorizonGroup;
import horizon.fm.data.FileData;
import horizon.fm.view.FileTreeItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HorizontalScrollView hsv = createHSV( FileData.getInterStorage() );
        hsv.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(hsv);
    }

    private HorizontalScrollView createHSV(File rootFile) {
        FileTreeItem fileTree = new FileTreeItem(this);
        fileTree.init(rootFile);
        ScrollView sv = ViewUtil.addScrollView(fileTree);
        HorizontalScrollView hsv = ViewUtil.addHorizonScrollView(sv);
        hsv.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        return hsv;
    }

    private View addView() {
        HorizonGroup group = new HorizonGroup(this) {
            @Override
            protected void setStatus_default() {
                HorizontalScrollView hsv;
                hsv = createHSV(FileData.getRootFile());
                addView(hsv);
                hsv = createHSV(FileData.getInterStorage());
                addView(hsv);
            }
        };
        return group;
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