package com.cos.review.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.review.MainActivity;
import com.cos.review.R;
import com.cos.review.databinding.ContainerItemBinding;
import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private static final String TAG = "ProductAdapter";
    private List<Product> products = new ArrayList<>();
    private MainActivity mContext;

    public ProductAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    // 데이터 한번에 넣어주는 함수
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // 1. 내부 클래스 생성하기
    class ProductHolder extends RecyclerView.ViewHolder {

        private ContainerItemBinding containerItemBinding;

        public ProductHolder(@NonNull ContainerItemBinding containerItemBinding) {
            super(containerItemBinding.getRoot());
            this.containerItemBinding = containerItemBinding;
        }
    }

    // 그림 만드는 역할
    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContainerItemBinding containerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.container_item,
                parent,
                false
        );
        return new ProductHolder(containerItemBinding);
    }

    // 데이터 바인딩 역할
    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);
        holder.containerItemBinding.setProduct(product);
        holder.containerItemBinding.setMainActivity(mContext);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
