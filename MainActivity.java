package compiindshift.prasad36.veggieskart2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        //inflate ViewStub before get view
        stubList.inflate();
        stubGrid.inflate();

        listView =(ListView)findViewById(R.id.mylistview);
        gridView = (GridView)findViewById(R.id.mygridview);

        //get list of product
        getProductList();

        //get current view mode in share reference
        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode",MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode",VIEW_MODE_LISTVIEW);//Default View is ListView
        //Register item click
        listView.setOnItemClickListener(onTitemClick);
        gridView.setOnItemClickListener(onTitemClick);

        switchView();
    }
    private void switchView() {
        if(VIEW_MODE_LISTVIEW==currentViewMode)
        {   //Display ListView
            stubList.setVisibility(View.VISIBLE);
            //Hide GridView
            stubGrid.setVisibility(View.GONE);
        }
        else
        {   //Display GridView
            stubList.setVisibility(View.GONE);
            //Hide ListView
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapter();
    }
    private void setAdapter() {
        if(VIEW_MODE_LISTVIEW==currentViewMode)
        {
            listViewAdapter = new ListViewAdapter(this,R.layout.list_item,productList);
            listView.setAdapter(listViewAdapter);
        }
        else
        {
            gridViewAdapter = new GridViewAdapter(this,R.layout.grid_item,productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }


    public List<Product> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.potato,"Potatos","Available"));
        /*productList.add(new Product(R.drawable.tomatos,"Tomatos","Available"));
        productList.add(new Product(R.drawable.carrots,"Carrots","Available"));
        productList.add(new Product(R.drawable.bitter_gourd,"Bitter Gourd","Available"));
        productList.add(new Product(R.drawable.lady_finger,"Lady Finger","Available"));
        productList.add(new Product(R.drawable.green_peas,"Green Peas","Available"));
        productList.add(new Product(R.drawable.garlic,"Garlic","Available"));
        productList.add(new Product(R.drawable.cabbage,"Cabbage","Available"));
        productList.add(new Product(R.drawable.brinjal,"Brinjal","Available"));
        productList.add(new Product(R.drawable.broccoli,"Broccoli","Available"));
        productList.add(new Product(R.drawable.spinach,"Spinach","Available"));
        productList.add(new Product(R.drawable.swiss_chard,"Swiss Chard","Available"));*/
        return productList;
    }

    AdapterView.OnItemClickListener onTitemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Do anything when user click to item
            Intent intent = new Intent(MainActivity.this,ChooseLocation.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW==currentViewMode)
                {
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                }
                else
                {
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                //Switch View
                switchView();
                //Save view mode in shared preference
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode",currentViewMode);
                editor.commit();
                break;
        }
        return true;
    }
}
