package adroid.petterson.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static java.lang.Double.parseDouble;

public class CommonCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_calc);
    }

    public boolean pontoVazio(String text) {
        int tam = text.length();
        if (tam == 0) return true;
        else if (text.substring(tam - 1, tam).equals(" ")) return true;

        return false;
    }

    public boolean podePonto(String text) {
        //Log.v("array", String.valueOf(array.length));
        int tam = text.length();
        if (tam == 0) return true;
        String[] array = text.split(" ");
        if (array.length == 1) {
            if(array[0].indexOf(".") == -1) {
                return true;
            } else {
                return false;
            }
        } else if (array.length == 2) {
            return true;
        } else {
            if(array[2].indexOf(".") == -1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean temOperando(String text) {
        if(text.length() == 0) return true;
        char[] operacoes = {'x', '-', '/', '+'};
        for(int i = 0; i < operacoes.length; i++) {
            if(text.indexOf(operacoes[i]) != (-1)) {
                return true;
            }
        }
        return false;
    }

    public void insereElemento(View view) {
        EditText display = (EditText) findViewById(R.id.display);
        String text = display.getText().toString();
        int tam = text.length();

        String tag = view.getTag().toString();
        if(tag.equals(" x ") || tag.equals(" - ") || tag.equals(" / ") || tag.equals(" + ")) {
            boolean limit = this.temOperando(text); //Não consegui colocar dentro do if
            if (!limit) {
                display.setText(text+tag);
            }
        } else if (tag.equals(".")){
            if(podePonto(text)) {
                if (pontoVazio(text)) {
                    display.setText(text+"0"+tag);
                } else {
                    display.setText(text+tag);
                }
            } else {
                return;
            }
        } else {
            display.setText(text+tag);
        }
    }

    public void clear(View view) {
        EditText display = (EditText) findViewById(R.id.display);
        display.setText("");
    }

    public void apaga(View view) {
        EditText display = (EditText) findViewById(R.id.display);
        String text = display.getText().toString();

        int tam = text.length();
        if(tam <= 1) {
            display.setText("");
            return;
        }
        // operando tem espaços antes e depois " x ", logo deve ser retirado 3 caracteres
        else if (text.substring((tam-1), tam).equals(" ")) tam = tam - 3;
        // demais numeros, retira-se apenas 1 caracter
        else tam = tam - 1;
        String novo = text.substring(0, tam);
        display.setText(novo);
    }

    public void igual(View view) {
        EditText display = (EditText) findViewById(R.id.display);
        String text = display.getText().toString();
        int tam = text.length();

        if(!temOperando(text)) return;
        // verifica se o ultimo caractere é um operando
        else if (text.substring((tam-1), tam).equals(" ")) {
            return;
        } else {
            String[] array = new String[3];
            array = text.split(" ");
            double n1 = parseDouble(array[0]);
            double n2 = parseDouble(array[2]);
            double result = 0;
            String op = array[1];
            if (op.equals("+")) {
                result = n1 + n2;
            } else if (op.equals("-")) {
                result = n1 - n2;
            } else if (op.equals("x")) {
                result = n1 * n2;
            } else if (op.equals("/")) {
                result = n1 / n2;
            }

            String novo = String.format("%.2f", result);
            display.setText(novo);
        }

    }

}