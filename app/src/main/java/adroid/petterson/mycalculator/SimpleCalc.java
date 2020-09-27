package adroid.petterson.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SimpleCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operacao(View v) {
        Double d = new Double("6.35");
        final EditText ed1 = (EditText) findViewById(R.id.ed1);
        final EditText ed2 = (EditText) findViewById(R.id.ed2);
        final TextView result = (TextView) findViewById(R.id.result);

        String str_result = "O Resultado é: ";
        String v1 = ed1.getText().toString();
        String v2 = ed2.getText().toString();

        double d1 = d.parseDouble(v1);
        double d2 = d.parseDouble(v2);

        String tag = v.getTag().toString();

        if(tag.equals("somar")) {
            double op = d1 + d2;
            String str = str_result + String.format("%.2f", op);
            result.setText(str);
        } else if (tag.equals("subtrair")) {
            double op = d1 - d2;
            String str = str_result + String.format("%.2f", op);
            result.setText(str);
        } else if (tag.equals("multiplicar")) {
            double op = d1 * d2;
            String str = str_result + String.format("%.2f", op);
            result.setText(str);
        } else if (tag.equals("dividir")) {
            double op = d1 / d2;
            String str = str_result + String.format("%.2f", op);
            result.setText(str);
        }

    }
}