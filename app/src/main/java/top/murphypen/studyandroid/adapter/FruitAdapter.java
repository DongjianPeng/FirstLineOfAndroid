package top.murphypen.studyandroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.view03.listview.Fruit;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private static final String TAG = "FruitAdapter";

    private int resourceId;

    public FruitAdapter(@NonNull Context context,
                        int textViewResourceId, @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d(TAG, "getView: " + position);
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            //使用convertView避免每次都加载
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder(view);
            //使用view的tag属性保存内容避免重复获取控件实例
            viewHolder.imageView = view.findViewById(R.id.fruit_image);
            viewHolder.textView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName() + ":" + position);
        return view;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "imageView=" + imageView +
                    ", textView=" + textView +
                    '}';
        }
    }
}
