package com.code.mvvm.core.view.activity.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.code.mvvm.App;
import com.code.mvvm.R;
import com.code.mvvm.core.data.pojo.activity.ActivityListVo;
import com.code.mvvm.util.DisplayUtil;
import com.trecyclerview.holder.AbsViewHolder;
import com.trecyclerview.holder.BaseHolder;

/**
 * @author：tqzhang  on 18/6/19 15:00
 */
public class ActivityItemHolder extends AbsViewHolder<ActivityListVo.DataBean, ActivityItemHolder.ViewHolder> {
    private int commonWidth;

    public ActivityItemHolder(Context context) {
        super(context);
        commonWidth = (int) ((float) DisplayUtil.getScreenWidth(App.instance())
                - 2 * App.instance().getResources()
                .getDimensionPixelSize(
                        R.dimen.concise_three_layout_margin));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_activity_list;
    }

    @Override
    public ViewHolder createViewHolder(View view) {
        return new ViewHolder(view);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ActivityListVo.DataBean dataBean) {
        double dv = 0.42;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, (int) (dv * commonWidth));
        params.setMargins(
               mContext.getResources()
                        .getDimensionPixelSize(
                                R.dimen.concise_three_layout_margin),
                mContext.getResources()
                        .getDimensionPixelSize(
                                R.dimen.concise_img_margin_top),
                mContext.getResources()
                        .getDimensionPixelSize(
                                R.dimen.concise_three_layout_margin),
                mContext.getResources()
                        .getDimensionPixelSize(
                                R.dimen.concise_img_margin_bottom));

        holder.ivActivityPic.setLayoutParams(params);
        if (dataBean.img != null
                && !TextUtils.isEmpty(dataBean.img.img)) {
            Glide.with(mContext).load(dataBean.img.img).centerCrop()
                    .placeholder(R.color.black_e8e8e8)
                    .into(holder.ivActivityPic);
        }
        holder.tvActivityTitle.setText(dataBean.title);
    }


    static class ViewHolder extends BaseHolder {
        ImageView ivActivityPic;
        TextView tvActivityTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ivActivityPic = getViewById(R.id.iv_activity_pic);
            tvActivityTitle = getViewById(R.id.tv_activity_title);
        }
    }

}
