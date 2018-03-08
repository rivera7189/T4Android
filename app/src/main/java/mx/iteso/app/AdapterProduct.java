package mx.iteso.app;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


import mx.iteso.app.beans.ItemProduct;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>   {
    private final ArrayList<ItemProduct> products;

    public AdapterProduct (ArrayList<ItemProduct> products) {
        this.products =  products;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Title;
        TextView Store;
        TextView Location;
        TextView Phone;
        ImageView Image;
        RelativeLayout Layout;
        ItemProduct product;

        ViewHolder(View v) {
            super(v);
            Title = v.findViewById(R.id.item_product_title);
            Store = v.findViewById(R.id.item_product_store);
            Location = v.findViewById(R.id.item_product_location);
            Phone = v.findViewById(R.id.item_product_phone);
            Image = v.findViewById(R.id.item_product_image);
            Layout = v.findViewById(R.id.item_product_layout);
            Phone.setOnClickListener(this);
            Layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_product_phone:
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("num:"+getString(Phone)));
                    v.getContext().startActivity(intent);
                    break;
                case R.id.item_product_layout:
                    Intent intento = new Intent(v.getContext(),ActivityProduct.class);
                    intento.putExtra("product",product);
                    Activity_main main = (Activity_main) v.getContext();
                    main.startActivityForResult(intento,7189);

                    break;
            }
        }

        private String getString(TextView textView) {
            return textView.getText().toString();
        }

        void bind(ItemProduct itemProduct) {
            this.product = itemProduct;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemProduct item = products.get(position);
        holder.Title.setText(item.getTitle());
        holder.Store.setText(item.getStore());
        holder.Location.setText(item.getLocation());
        holder.Phone.setText(item.getPhone());
        holder.Image.setImageResource(item.getImage());
        holder.product = products.get(position);
        holder.bind(item);
    }



    @Override
    public int getItemCount() {
        return products.size();
    }
}
