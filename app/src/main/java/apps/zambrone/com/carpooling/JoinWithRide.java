package apps.zambrone.com.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



import apps.zambrone.com.carpooling.component.ButtonEffects;

public class JoinWithRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_with_ride);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // ButtonEffects.buttonEffect(findViewById(R.id.btn_join_ride));

        findViewById(R.id.btn_join_ride).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinWithRide.this,JoinWithRideAwaiting.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
