package com.code.mvvm.core.vm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.code.mvvm.core.data.BaseRepository;
import com.code.mvvm.util.TUtil;

/**
 * @author：tqzhang on 18/7/26 16:15
 */
public class BaseViewModel<T extends BaseRepository> extends AndroidViewModel {

    public MutableLiveData<String> loadState;

    public T mRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        loadState = new MutableLiveData<>();
        mRepository = TUtil.getNewInstance(this, 0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mRepository != null) {
            mRepository.unSubscribe();
        }

    }
}
