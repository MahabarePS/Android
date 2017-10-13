package compiindshift.prasad36.veggieskart2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CampFarmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp_farmer);
        TextView prev = (TextView)findViewById(R.id.Prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampFarmer.this,ChooseLocation.class);
                startActivity(intent);
            }
        });
    }
}
