package br.com.example.projetoimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    //private View btn_imc;
    private RecyclerView mainRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRv = findViewById(R.id.main_rv);

        // 1 -> definir o comportamento de exibição do layout da recyclerview
        // tipo: mosaic , grid ou linear (horizontal ou vertical)
        mainRv.setLayoutManager(new LinearLayoutManager(this));
        //Estanciamos a classe Adapter
        MainAdapter adapter = new MainAdapter();
        mainRv.setAdapter(adapter);



        /*btn_imc = findViewById(R.id.btn_imc);

        btn_imc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ImcActivity.class);
            startActivity(intent);
        });*/
    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }

    // Entenda como sendo o "View da celula" que esta dentro do recyclerView (as caixas são o viewHolder)

    private class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
