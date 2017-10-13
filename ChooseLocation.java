package compiindshift.prasad36.veggieskart2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChooseLocation extends AppCompatActivity {
    TextView pune,kothrud,camp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        pune = (TextView)findViewById(R.id.pune);
        pune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLocation.this,PuneFarmer.class);
                startActivity(intent);
            }
        });
        kothrud = (TextView)findViewById(R.id.kothrud);
        kothrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLocation.this,KothrudFarmer.class);
                startActivity(intent);
            }
        });
        camp = (TextView)findViewById(R.id.camp);
        camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseLocation.this,CampFarmer.class);
                startActivity(intent);
            }
        });
    }
}
