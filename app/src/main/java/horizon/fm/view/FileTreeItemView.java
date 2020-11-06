package horizon.fm.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import horizon.baselibrary.listener.BaseAlterNativeClickListener;
import horizon.baselibrary.util.TypefaceUtil;
import horizon.baselibrary.util.group.HorizonGroup;
import horizon.fm.R;

/**
 * @Author Horizon
 * @ClasssName FIleItem
 * @Description 文件树节点View
 * @UpdateDate 2020/11/6 9:43 AM
 */
public class FileTreeItemView extends HorizonGroup {
    private View mView;
    private FileTreeItem mFileTreeItem;

    private File mCurFile;
    private TextView mFileName;
    private TextView mExtendIcon;
    private TextView mTypeIcon;

    private OnClickListener mExtendListener;

    public FileTreeItemView(Context context) {
        super(context);
    }

    @Override
    protected void setStatus_default() {
        setOrientation(VERTICAL);

        //单个视图
        mView = new HorizonGroup(mContext) {
            @Override
            protected void setStatus_default() {
                mExtendIcon = new TextView(mContext);
                mExtendIcon.setTypeface(TypefaceUtil.getTypeface(mContext));
                mExtendIcon.setTextSize(20);
                mExtendIcon.setText(R.string.arrow_up);
                lp = new LayoutParams(getPx(20), wrapContent);
                mExtendIcon.setLayoutParams(lp);
                addView(mExtendIcon);

                mTypeIcon = new TextView(mContext);
                mTypeIcon.setTypeface(TypefaceUtil.getTypeface(mContext));
                mTypeIcon.setTextSize(20);
                lp = new LayoutParams(wrapContent, wrapContent);
                mTypeIcon.setLayoutParams(lp);
                addView(mTypeIcon);

                setGravity(Gravity.CENTER_VERTICAL);
                mFileName = new TextView(mContext);
                mFileName.setTextSize(20);
                lp = new LayoutParams(wrapContent, wrapContent);
                mFileName.setLayoutParams(lp);
                addView(mFileName);
            }
        };
        addView(mView);

        //子节点视图
        mFileTreeItem = new FileTreeItem(mContext);
        lp = new LayoutParams(matchParent, matchParent);
        lp.leftMargin = getPx(20);
        mFileTreeItem.setLayoutParams(lp);
        addView(mFileTreeItem);
    }

    public TextView getFileName() {
        return mFileName;
    }

    /**
     * 点击后收起或者显示
     */
    public void setClickListener(File curFile) {
        mCurFile = curFile;
        if(mCurFile.isDirectory()) {
            mTypeIcon.setText(R.string.folder);
            mTypeIcon.setTextColor(Color.parseColor("#d0d000"));
            if(mCurFile.listFiles().length==0){
                mExtendIcon.setTextColor(Color.parseColor("#800000"));
            }
        }else{
            mTypeIcon.setText(R.string.file);
            mTypeIcon.setTextColor(Color.parseColor("#d300d3"));
            mExtendIcon.setText("");
        }
        //设置点击监听，用来是否打开子视图
        mExtendListener = new BaseAlterNativeClickListener() {
            boolean isFirst = true;

            @Override
            protected void firstDoThing(View v) {
                //展开树节点下面的文件
                if (mCurFile.isDirectory() && isFirst) {
                    mFileTreeItem.init(mCurFile);
                    isFirst = false;
                }
                if(mCurFile.isDirectory()) {
                    mExtendIcon.setText(R.string.arrow_down);
                }
                mFileTreeItem.setVisibility(VISIBLE);
            }

            @Override
            protected void thenDoThing(View v) {
                if(mCurFile.isDirectory()) {
                    mExtendIcon.setText(R.string.arrow_up);
                }
                //收起树节点下面的文件
                mFileTreeItem.setVisibility(GONE);
            }
        };
        mView.setOnClickListener(mExtendListener);
    }
}
