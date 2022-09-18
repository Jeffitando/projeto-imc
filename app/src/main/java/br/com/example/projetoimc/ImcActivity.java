package br.com.example.projetoimc;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImcActivity extends AppCompatActivity {

    private EditText edit_imc_height;
    private EditText edit_imc_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        edit_imc_height = findViewById(R.id.edit_imc_height);
        edit_imc_weight = findViewById(R.id.edit_imc_weight);

        Button btn_imc_send = findViewById(R.id.btn_imc_send);

        btn_imc_send.setOnClickListener(v -> {

            if (!validate()) {
                Toast.makeText(this, "Todos os campos devem ser maiores que zero", Toast.LENGTH_SHORT).show();
                return;
            }

            String sHeight = edit_imc_height.getText().toString();
            String sWeight = edit_imc_weight.getText().toString();

            int height = Integer.parseInt(sHeight);
            int weight = Integer.parseInt(sWeight);

            double result = calculateImc(height, weight);
            Log.d("TESTE", "RESULTADO: "+ result);

            int imcResponseId = imcResponse(result);

            //popup
            AlertDialog dialog = new AlertDialog.Builder(ImcActivity.this)
                    .setTitle(getString(R.string.imc_response, result))
                    .setMessage(imcResponseId)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //
                        }
                    })
                    .create();
            dialog.show();

            //Metodo que esconde o teclado apos cliclar em botão calcular
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(edit_imc_weight.getWindowToken(),0);
            inputMethodManager.hideSoftInputFromWindow(edit_imc_height.getWindowToken(),0);

           // Toast.makeText(ImcActivity.this,imcResponseId, Toast.LENGTH_SHORT).show();

        });

    }

    @StringRes
    private int imcResponse(double imc){
        if (imc < 15 )
            return R.string.imc_severely_low_weight;
        else if (imc<16)
            return R.string.imc_very_low_weight;
        else if (imc<18.5)
            return R.string.imc_low_weight;
        else if (imc<25)
            return R.string.normal;
        else if (imc<30)
            return R.string.imc_high_weight;
        else if (imc<35)
            return R.string.imc_so_high_weight;
        else if (imc<40)
            return R.string.imc_severely_high_weight;
        else
            return R.string.imc_extreme_Weight;
    }

    //metodo que vai calculcar imc = peso, dividido pela (altura, vezes a altura)
    private double calculateImc(int height, int weight) {
        return weight / (((double) height / 100) * ((double) height / 100));
    }

    //Método que valida formulario, não pode estar vazio E não pode começar com zero.
    private boolean validate() {
        if (!edit_imc_height.getText().toString().startsWith("0")
                && !edit_imc_weight.getText().toString().startsWith("0")
                && !edit_imc_height.getText().toString().isEmpty()
                && !edit_imc_weight.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}