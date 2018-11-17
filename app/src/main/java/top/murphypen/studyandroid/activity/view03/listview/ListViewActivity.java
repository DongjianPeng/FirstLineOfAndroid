package top.murphypen.studyandroid.activity.view03.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import top.murphypen.studyandroid.activity.R;
import top.murphypen.studyandroid.activity.base.BaseActivity;
import top.murphypen.studyandroid.adapter.FruitAdapter;
import top.murphypen.studyandroid.common.TestInitData;

public class ListViewActivity extends BaseActivity implements TestInitData {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits2);

        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
        initFruitList();
        FruitAdapter adapter1 = new FruitAdapter(this, R.layout.fruit_item, fruitList);
        listView.setAdapter(adapter1);


        //listView 点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);

                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(ListViewActivity.this, view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruitList() {
        if (fruitList != null) {
            fruitList.clear();
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Banana", R.drawable.banana_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
            fruitList.add(new Fruit("Apple", R.drawable.apple_pic));
        }
    }
}
