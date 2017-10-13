package compiindshift.prasad36.veggieskart2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class KothrudFarmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kothrud_farmer);
        TextView prev = (TextView)findViewById(R.id.Prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KothrudFarmer.this,ChooseLocation.class);
                startActivity(intent);
            }
        });
    }
}
