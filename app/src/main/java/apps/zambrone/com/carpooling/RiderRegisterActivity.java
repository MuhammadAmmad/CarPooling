package apps.zambrone.com.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import apps.zambrone.com.carpooling.component.ButtonEffects;

public class RiderRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Register Rider");


        //ButtonEffects.buttonEffect(findViewById(R.id.rider_register_activity_btn_register_as_next));

        findViewById(R.id.rider_register_activity_btn_register_as_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RiderRegisterActivity.this,SharerRegisterActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
