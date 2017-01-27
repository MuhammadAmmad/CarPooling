package apps.zambrone.com.carpooling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import apps.zambrone.com.carpooling.component.ButtonEffects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.car);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



       // ButtonEffects.buttonEffect(findViewById(R.id.btnFirstSignIn));
        findViewById(R.id.btnFirstSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
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
