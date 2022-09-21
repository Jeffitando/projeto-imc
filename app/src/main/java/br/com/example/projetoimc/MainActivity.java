package br.com.example.projetoimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private View btn_imc;
    private RecyclerView mainRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRv = findViewById(R.id.main_rv);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.ic_sunny_24, R.string.app_name, Color.GREEN));

        // 1 -> definir o comportamento de exibição do layout da recyclerview
        // tipo: mosaic , grid ou linear (horizontal ou vertical)
        mainRv.setLayoutManager(new LinearLayoutManager(this));
        //Estanciamos a classe Adapter
        MainAdapter adapter = new MainAdapter(mainItems);
        mainRv.setAdapter(adapter);



        /*btn_imc = findViewById(R.id.btn_imc);

        btn_imc.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ImcActivity.class);
            startActivity(intent);
        });*/
    }

    private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

        private  List<MainItem> mainItems;

        private MainAdapter(List<MainItem> mainItems){
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
          MainItem mainItemCurrent =  mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }
    }

    // Entenda como sendo o "View da celula" que esta dentro do recyclerView (as caixas são o viewHolder)

    private class MainViewHolder extends RecyclerView.ViewHolder {

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(MainItem item) {
            TextView txtName = itemView.findViewById(R.id.item_txt_name);
            ImageView imgIcon = itemView.findViewById(R.id.item_img_icon);
            LinearLayout container = (LinearLayout) itemView;
        }
    }


}
