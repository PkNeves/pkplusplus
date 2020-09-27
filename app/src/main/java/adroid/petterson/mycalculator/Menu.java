package adroid.petterson.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void simpleCalc(View view) {
        Intent it = new Intent(getBaseContext(), SimpleCalc.class);
        startActivity(it);
    }
    public void commonCalc(View view) {
        Intent it = new Intent(getBaseContext(), CommonCalc.class);
        startActivity(it);
    }
}