package com.code.mvvm.core.view.material;

import android.os.Bundle;

import com.code.mvvm.R;
import com.code.mvvm.base.BaseFragment;
import com.code.mvvm.base.BaseViewPagerFragment;
import com.code.mvvm.core.data.pojo.material.MaterialTypeVo;
import com.code.mvvm.core.vm.MaterialViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：tqzhang on 18/7/2 14:24
 */
public class MaterialFragment extends BaseViewPagerFragment<MaterialViewModel> {
    private List<MaterialTypeVo.TypeListEntity> titleName;

    public static MaterialFragment newInstance() {
        return new MaterialFragment();
    }

    @Override
    public void initView(Bundle state) {
        super.initView(state);
        titleName = new ArrayList<>();
        getTabData();
    }

    @Override
    protected void dataObserver() {
        mViewModel.getMaterialType().observe(this, materialTypeVo -> {
            if (materialTypeVo != null) {
                setData(materialTypeVo);
            }
        });
    }


    @Override
    protected void onStateRefresh() {
        super.onStateRefresh();
        getTabData();
    }

    @Override
    protected String[] createPageTitle() {
        return mArrTitles;
    }

    @Override
    protected List<BaseFragment> createFragments() {
        return mFragments;
    }


    private void getTabData() {
        mViewModel.getMaterialTypeData();
    }


    public void setData(MaterialTypeVo materialTypeVo) {
        mArrTitles = new String[materialTypeVo.data.typelist.size() + 1];
        titleName.clear();
        MaterialTypeVo.TypeListEntity dataBean = new MaterialTypeVo.TypeListEntity();
        dataBean.name = getResources().getString(R.string.special_tab_name);
        mArrTitles[0] = getResources().getString(R.string.special_tab_name);
        titleName.add(dataBean);
        for (int j = 0; j < materialTypeVo.data.typelist.size(); j++) {
            titleName.add(materialTypeVo.data.typelist.get(j));
            mArrTitles[j + 1] = (materialTypeVo.data.typelist.get(j).name);
        }
        initFragment();
        setAdapter();
    }

    private void initFragment() {
        for (int i = 0; i < titleName.size(); i++) {
            if (i == 0) {
                MaterialRecommendFragment materialRecommendFragment = MaterialRecommendFragment.newInstance();
                mFragments.add(materialRecommendFragment);
            } else {
                MaterialListFragment materialListFragment = MaterialListFragment.newInstance();
                Bundle bundle = new Bundle();
                bundle.putString("sub_id", titleName.get(i).subid);
                materialListFragment.setArguments(bundle);
                mFragments.add(materialListFragment);
            }

        }
    }
}
