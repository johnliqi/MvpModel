package com.example.mvpmodel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpmodel.Activity.base.Base.BaseFragment;
import com.example.mvpmodel.Adapter.mainRecycleViewAdapter;
import com.example.mvpmodel.Model.entity.Gank;
import com.example.mvpmodel.Presenter.ChromeViewPresenter;
import com.example.mvpmodel.Presenter.MainFragmentPresenter;
import com.example.mvpmodel.Presenter.MainPresenter;
import com.example.mvpmodel.views.IMainFragmentView;
import com.example.mvpmodel.widget.AutoRecyclerView;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import Utils.SnackBarUtil;
import butterknife.BindView;

public class MainFragment extends BaseFragment<MainFragmentPresenter> implements IMainFragmentView, PullToRefreshView.OnRefreshListener, AutoRecyclerView.LoadMoreListener {
    MainFragment mainFragment;
    private static ChromeViewPresenter chromeViewPresenter;
    static String Type = "Type";
    String mType;
    private int page = 1;
    private boolean isRefresh = true;
    List gankList;
    @BindView(R.id.mAutoRecycleView)
    AutoRecyclerView recyclerView;
    @BindView(R.id.pull_to_refresh)
    PullToRefreshView pullToRefreshView;
    private boolean canLoading = true;
    mainRecycleViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getString(Type);
        }
    }

    public static MainFragment newInstance(String mType, ChromeViewPresenter mchromeViewPresenter) {
        MainFragment mainFragment = new MainFragment();
        chromeViewPresenter = mchromeViewPresenter;
        Bundle bundle = new Bundle();
        bundle.putString(Type, mType);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int provideViewLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initPresenter() {
        presenter = new MainFragmentPresenter(getContext(), this);
        presenter.init();
    }

    @Override
    public void showProgress() {
        if (!pullToRefreshView.isShown()) {
            pullToRefreshView.setRefreshing(true);
        }
    }

    @Override
    public void hideProgress() {
        if (pullToRefreshView.isShown()) {
            pullToRefreshView.setRefreshing(false);
        }
    }

    @Override
    public void showErrorView() {
        canLoading = true;
        SnackBarUtil.showTipWithAction(recyclerView, getString(R.string.load_fail), getString(R.string.retry), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadGank(mType, page);
            }
        });
    }

    @Override
    public void showNoMoreData() {
        canLoading = false;
        SnackBarUtil.showTipWithoutAction(recyclerView, getString(R.string.load_finished));
    }

    @Override
    public void showListView(List<Gank> gankList) {
        canLoading = true;
        page++;
        if (isRefresh) {
            //下拉刷新
            this.gankList.clear();
            this.gankList.addAll(gankList);
            adapter.notifyDataSetChanged();
            isRefresh = false;
        } else {
            //上拉刷新
            this.gankList.addAll(gankList);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void init() {
        gankList = new ArrayList();
        adapter = new mainRecycleViewAdapter(chromeViewPresenter, gankList, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadMoreListener(this);
        recyclerView.applyFloatingActionButton(MainActivity.fab);
        pullToRefreshView.setOnRefreshListener(this);
        pullToRefreshView.post(new Runnable() {
            @Override
            public void run() {
                pullToRefreshView.setRefreshing(true);
                presenter.loadGank(mType, page);
            }
        });
        MainActivity.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void onRefresh() {
        isRefresh = true;
        page = 1;
        presenter.loadGank(mType, page);
    }

    @Override
    public void loadMore() {
        if (canLoading) {
            presenter.loadGank(mType, page);
            canLoading = false;
        }
    }
}
