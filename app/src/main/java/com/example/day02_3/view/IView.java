package com.example.day02_3.view;



import com.example.day02_3.User;

import java.util.List;

public interface IView {
    void onSuccess(List<User.ResultsBean> success);
    void onError(String error);
}
