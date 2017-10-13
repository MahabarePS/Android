package compiindshift.prasad36.veggieskart2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 12/10/2017.
 */

public class GridViewAdapter extends ArrayAdapter<Product> {
    public GridViewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if(null==v)
        {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.grid_item,null);
        }
        Product product = getItem(position);
        ImageView img1 = (ImageView) v.findViewById(R.id.imageView1);
        TextView txtTitle1 = (TextView) v.findViewById(R.id.txtTitle1);
        TextView txtDesc1 = (TextView) v.findViewById(R.id.txtDesc1);

        /* ImageView img2 = (ImageView) v.findViewById(R.id.imageView2);
        TextView txtTitle2 = (TextView) v.findViewById(R.id.txtTitle2);
        TextView txtDesc2 = (TextView) v.findViewById(R.id.txtDesc2);

        ImageView img3 = (ImageView) v.findViewById(R.id.imageView3);
        TextView txtTitle3 = (TextView) v.findViewById(R.id.txtTitle3);
        TextView txtDesc3 = (TextView) v.findViewById(R.id.txtDesc3);

        ImageView img4 = (ImageView) v.findViewById(R.id.imageView4);
        TextView txtTitle4 = (TextView) v.findViewById(R.id.txtTitle4);
        TextView txtDesc4 = (TextView) v.findViewById(R.id.txtDesc4);

        ImageView img5 = (ImageView) v.findViewById(R.id.imageView5);
        TextView txtTitle5 = (TextView) v.findViewById(R.id.txtTitle5);
        TextView txtDesc5 = (TextView) v.findViewById(R.id.txtDesc5);

        ImageView img6 = (ImageView) v.findViewById(R.id.imageView6);
        TextView txtTitle6 = (TextView) v.findViewById(R.id.txtTitle6);
        TextView txtDesc6 = (TextView) v.findViewById(R.id.txtDesc6);

        ImageView img7 = (ImageView) v.findViewById(R.id.imageView7);
        TextView txtTitle7 = (TextView) v.findViewById(R.id.txtTitle7);
        TextView txtDesc7 = (TextView) v.findViewById(R.id.txtDesc7);*/

        img1.setImageResource(product.getImageId());
        txtTitle1.setText(product.getTitle());
        txtDesc1.setText(product.getDescription());

        /*img2.setImageResource(product.getImageId());
        txtTitle2.setText(product.getTitle());
        txtDesc2.setText(product.getDescription());

        img3.setImageResource(product.getImageId());
        txtTitle3.setText(product.getTitle());
        txtDesc3.setText(product.getDescription());

        img4.setImageResource(product.getImageId());
        txtTitle4.setText(product.getTitle());
        txtDesc4.setText(product.getDescription());

        img5.setImageResource(product.getImageId());
        txtTitle5.setText(product.getTitle());
        txtDesc5.setText(product.getDescription());

        img6.setImageResource(product.getImageId());
        txtTitle6.setText(product.getTitle());
        txtDesc6.setText(product.getDescription());

        img7.setImageResource(product.getImageId());
        txtTitle7.setText(product.getTitle());
        txtDesc7.setText(product.getDescription());*/

        return v;
    }
}
