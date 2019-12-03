package com.example.tabtest.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

//탭에 사용되는 문구 및 링크 내용
public class PageViewModel extends ViewModel {

    private String[] content = new String[]{"슬기의 첫번째 탭 내용입니다ㅋㅋㅋ","안드로이드 어렵네요ㅠㅠ","그래도 재밌네요^^;;","그럼 20000 안뇽>.<"};

    private String[] link = new String[]{"https://naver.com","https://google.com","https://kakao.com","https://daum.net"};
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return content[input - 1];
        }
    });

    private LiveData<String> mLink = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return link[input - 1];
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getLink() {
        return mLink;
    }
}