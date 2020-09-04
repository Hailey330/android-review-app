package com.cos.review.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.review.R;
import com.cos.review.databinding.MenuItemBinding;
import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;

import java.util.ArrayList;
import java.util.List;

public class SearchKeywordAdapter extends RecyclerView.Adapter<SearchKeywordAdapter.SearchKeywordHolder> {

    private List<SearchKeyword> searchKeywords = new ArrayList<>();

    // 데이터 한번에 넣어주는 함수
    public void setSearchKeywords(List<SearchKeyword> searchKeywords) {
        this.searchKeywords = searchKeywords;
    }

    // 1. 내부 클래스 생성하기
    class SearchKeywordHolder extends RecyclerView.ViewHolder {

        private MenuItemBinding menuItemBinding;

        public SearchKeywordHolder(@NonNull MenuItemBinding menuItemBinding) {
            super(menuItemBinding.getRoot()); // .getRoot() 걸면 View 타입으로 바뀜
            this.menuItemBinding = menuItemBinding;
        }
    }

    // 그림 만드는 역할
    @NonNull
    @Override
    public SearchKeywordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding menuItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.menu_item,
                parent,
                false
        );
        return new SearchKeywordHolder(menuItemBinding);
    }

    // 데이터 바인딩 역할
    @Override
    public void onBindViewHolder(@NonNull SearchKeywordHolder holder, int position) {
        SearchKeyword searchKeyword = searchKeywords.get(position);
        holder.menuItemBinding.setSearchKeyword(searchKeyword);
    }

    @Override
    public int getItemCount() {
        return searchKeywords.size();
    }


}
