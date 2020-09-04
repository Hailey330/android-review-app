package com.cos.review;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.cos.review.adapter.ProductAdapter;
import com.cos.review.adapter.SearchKeywordAdapter;
import com.cos.review.model.Product;
import com.cos.review.model.SearchKeyword;
import com.cos.review.viewmodel.SearchKeywordViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivity mContext = MainActivity.this;
    private RecyclerView rvMenu, rvContainer;
    private SearchKeywordAdapter searchKeywordAdapter;
    private ProductAdapter productAdapter;
    private SearchKeywordViewModel searchKeywordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();
        initSetting();
        // sampleData();
        initData();
    }

    private void initObject() {
        rvMenu = findViewById(R.id.rv_menu);
        rvContainer = findViewById(R.id.rv_container);

        searchKeywordAdapter = new SearchKeywordAdapter();
        productAdapter = new ProductAdapter();

        searchKeywordViewModel = ViewModelProviders.of(mContext).get(SearchKeywordViewModel.class);
    }

    private void initSetting() {
        rvMenu.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        rvContainer.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));

        rvMenu.setAdapter(searchKeywordAdapter);
        rvContainer.setAdapter(productAdapter);
    }

    private void initData() {
        searchKeywordViewModel.데이터등록();
        searchKeywordViewModel.구독().observe(mContext, new Observer<List<SearchKeyword>>() {
            @Override
            public void onChanged(List<SearchKeyword> searchKeywords) {
                searchKeywordAdapter.setSearchKeywords(searchKeywords);
                searchKeywordAdapter.notifyDataSetChanged();
            }
        });
    }

    // 테스트용
    private void sampleData() {
        List<SearchKeyword> searchKeywords = new ArrayList<>();
        searchKeywords.add(new SearchKeyword(1, "갤럭시20"));
        searchKeywords.add(new SearchKeyword(2, "아이폰12"));
        searchKeywords.add(new SearchKeyword(3, "맥북프로"));
        searchKeywords.add(new SearchKeyword(4, "애플워치"));
        searchKeywordAdapter.setSearchKeywords(searchKeywords);

        List<Product> products = new ArrayList<>();
        products.add(Product.builder().title("제목1").day("1일전").thumnail("https://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg").build());
        products.add(Product.builder().title("제목2").day("2일전").thumnail("https://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg").build());
        products.add(Product.builder().title("제목3").day("3일전").thumnail("https://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg").build());
        productAdapter.setProducts(products);
    }
}