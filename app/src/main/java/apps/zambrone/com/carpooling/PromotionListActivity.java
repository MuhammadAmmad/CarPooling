package apps.zambrone.com.carpooling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class PromotionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Promotion List");


        

    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
