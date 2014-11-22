package cn.ls.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.ls.activity.R;

public class PageWidgetAdapter extends BaseAdapter {

    private Activity context;
    private List<String> list;
    private String eimage;
    private LayoutInflater inflater;
    private Bitmap image = null;

    public PageWidgetAdapter(Activity context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewGroup layout;
        if (convertView == null) {
            layout = (ViewGroup) inflater.inflate(R.layout.item_layout, null);
        } else {
            layout = (ViewGroup) convertView;
        }
        setViewContent(layout, position);
        return layout;
    }

    private void setViewContent(ViewGroup group, int position) {

        String path = "images/" + list.get(position);

        System.out.println("PageAdapter" + list.get(position));
        // back ----
        TextView back = (TextView) group.findViewById(R.id.item_layout_back);
        back.setTextColor(Color.WHITE);
        back.setTextSize(12);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                context.finish();
            }
        });
        // explain ----
        TextView explain = (TextView) group
                .findViewById(R.id.item_layout_centerText);
        explain.setText(eimage);
        explain.setTextColor(Color.WHITE);
        explain.setTextSize(16);
        // number ----
        TextView number = (TextView) group
                .findViewById(R.id.item_layout_rightText);
        number.setText(String.valueOf(position + 1) + "/" + list.size());
        number.setTextColor(Color.WHITE);
        number.setTextSize(16);

        // ��ʾͼƬ
        ImageView image = (ImageView) group
                .findViewById(R.id.item_layout_leftImage);
        image.setImageBitmap(getImageFromAssetsFile(path));

    }

    /**
     * ��Assets�ж�ȡͼƬ
     */
    private Bitmap getImageFromAssetsFile(String fileName) {
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inPreferredConfig = Bitmap.Config.RGB_565;
            opts.inPurgeable = true;
            opts.inInputShareable = true;
            image = BitmapFactory.decodeStream(is, null, opts);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
