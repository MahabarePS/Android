package compiindshift.prasad36.veggieskart2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class PuneFarmer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pune_farmer);
        TextView prev = (TextView)findViewById(R.id.Prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuneFarmer.this,ChooseLocation.class);
                startActivity(intent);
            }
        });
    }
}
