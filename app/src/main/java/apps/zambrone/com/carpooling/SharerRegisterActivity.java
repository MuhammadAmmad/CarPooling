package apps.zambrone.com.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class SharerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharer_register);
        getSupportActionBar().setTitle("Add Vehicle");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //  ButtonEffects.buttonEffect(findViewById(R.id.activity_sharer_register_btn_next));

        findViewById(R.id.activity_sharer_register_btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SharerRegisterActivity.this, SaveRouteActivity.class);
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
