package mx.iteso.app;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import mx.iteso.app.beans.ItemProduct;

public class ActivityProduct extends AppCompatActivity {

    TextInputEditText title,store,location,phone;
    ImageView image;
    Button cancel,save;
    ItemProduct product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        image = findViewById(R.id.imageview);
        title = findViewById(R.id.textinputname);
        store = findViewById(R.id.textinputstore);
        location = findViewById(R.id.textinputlocation);
        phone = findViewById(R.id.textinputphone);
        cancel = findViewById(R.id.btn_cancel);
        save = findViewById(R.id.btn_save);

        if (getIntent().getExtras() != null){
            product = getIntent().getParcelableExtra("product");
                if (product != null){
                    image.setImageResource(product.getImage());
                    title.setText(product.getTitle());
                    store.setText(product.getStore());
                    location.setText(product.getLocation());
                    phone.setText(product.getPhone());
                }
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product.setTitle(title.getText().toString());
                product.setStore(store.getText().toString());
                product.setLocation(location.getText().toString());
                product.setPhone(phone.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("product",product);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
