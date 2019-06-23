package com.example.mvpmodel.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpmodel.Model.entity.Gank;
import com.example.mvpmodel.Presenter.ChromeViewPresenter;
import com.example.mvpmodel.R;

import java.util.List;

import Utils.DateUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class mainRecycleViewAdapter extends RecyclerView.Adapter<mainRecycleViewAdapter.MainMainRecycleViewHolder> {
    List<Gank> gankList;
    static Context context;
    int lastPosition = 0;
    static ChromeViewPresenter presenter;

    public mainRecycleViewAdapter(ChromeViewPresenter presenter, List<Gank> gankList, Context context) {
        this.presenter = presenter;
        this.gankList = gankList;
        this.context = context;
    }

    @NonNull
    @Override
    public MainMainRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_fragment, parent, false);
        return new MainMainRecycleViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MainMainRecycleViewHolder holder, int position) {
        Gank gank = gankList.get(position);
        holder.tv_title.setTag(gank);
        holder.tv_date.setText(DateUtil.toDateTimeStr(gank.publishedAt));
        holder.tv_title.setText(gank.desc);
        holder.tv_author.setText(gank.who);
        showItemAnimation(holder, position);
    }

    private void showItemAnimation(MainMainRecycleViewHolder holder, int position) {
        if (position > lastPosition) {
            lastPosition = position;
            ObjectAnimator.ofFloat(holder.card, "translationY", 1f * holder.card.getHeight(), 0f)
                    .setDuration(500)
                    .start();
        }
    }

    @Override
    public int getItemCount() {
        return gankList.size();
    }

    static class MainMainRecycleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_main_fragment_item_date)
        TextView tv_date;
        @BindView(R.id.tv_main_frgment_item_title)
        TextView tv_title;
        @BindView(R.id.tv_main_frgment_item_author)
        TextView tv_author;

        @OnClick(R.id.main_fragment_card_view)
        void cardClick() {
            presenter.openWebView((Gank) tv_title.getTag());
        }

        View card;

        public MainMainRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView;
            ButterKnife.bind(this, itemView);
        }
    }
}





