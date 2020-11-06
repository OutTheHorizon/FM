package horizon.fm.view;

import android.content.Context;
import android.view.View;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import horizon.baselibrary.util.group.HorizonGroup;
import horizon.fm.data.FileData;

/**
 * @Author Horizon
 * @ClasssName FileTree
 * @Description
 * @UpdateDate 2020/11/6 10:44 AM
 */
public class FileTreeItem extends HorizonGroup {
    private List<FileTreeItemView> mFileTreeItems = new ArrayList<>();

    public FileTreeItem(Context context) {
        super(context);
    }

    @Override
    protected void setStatus_default() {
        lp = new LayoutParams(wrapContent, wrapContent);
        setLayoutParams(lp);
        setOrientation(VERTICAL);
        FileData.requestPermission(mContext);
    }

    /**
     * 初始化进入,显示存储目录
     */
    public void init(File f) {
        final File[] chi = f.listFiles();
        if (chi == null) {
            return;
        }
        setExtendFile(new Item() {
            @Override
            public int getCount() {
                return chi.length;
            }

            @Override
            public <T extends View> T getItemTree(T vt, int pos) {
                FileTreeItemView v = (FileTreeItemView) vt;
                if (v == null) {
                    v = createItem(mContext);
                }
                v.setClickListener(chi[pos]);
                v.getFileName().setText(chi[pos].getName());
                return (T) v;
            }
        });
    }

    /**
     * 创建列表里的一个视图
     *
     * @param context 上下文
     * @return 返回一个 View 视图
     */
    private static FileTreeItemView createItem(Context context) {
        FileTreeItemView demo = new FileTreeItemView(context);
        LayoutParams lp = new LayoutParams(matchParent, wrapContent);
        demo.setLayoutParams(lp);
        return demo;
    }

    /**
     * 加载子节点视图
     */
    public void setExtendFile(Item it) {
        int N = it.getCount();
        FileTreeItemView demo;
        for (int i = 0; i < N; i++) {
            if (i < mFileTreeItems.size()) {
                demo = it.getItemTree(mFileTreeItems.get(i), i);
            } else {
                demo = it.getItemTree(null, i);
            }
            mFileTreeItems.add(demo);
            addView(demo);
        }
    }

    /**
     * 展开树节点下(相当于 Content)
     */
    public interface Item {
        int getCount();

        /**
         * 获得子节点
         *
         * @param item 当前子节点，如果为空就创建，如果不为空就直接修改数据
         * @param pos  当前子节点位置
         * @return 写好的子节点
         */
        <T extends View> T getItemTree(T item, int pos);
    }
}
