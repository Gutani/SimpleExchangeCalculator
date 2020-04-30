package br.com.lamagie.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textEuro = findViewById(R.id.textview_euro);
        this.mViewHolder.textDolar = findViewById(R.id.textview_dolar);
        this.mViewHolder.buttonCalculator = findViewById(R.id.button_calc);

        this.mViewHolder.buttonCalculator.setOnClickListener(this);

        this.limpar();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calc){
            //Verificando se há valor adicionado
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)){
                //Mostra ao usuário que valor/estrada de dados está vazia
                Toast.makeText(this, R.string.informeValor, Toast.LENGTH_LONG).show();
            }else{
                Double real = Double.valueOf(value);
                this.mViewHolder.textEuro.setText(String.format("%.2f",real/6.01));
                this.mViewHolder.textDolar.setText(String.format("%.2f",real/5.2));

            }
        }
    }
    private void limpar(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textEuro;
        TextView textDolar;
        Button buttonCalculator;

    }
}
