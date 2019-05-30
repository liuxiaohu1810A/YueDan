package com.example.day02_3.model;



import com.example.day02_3.User;

import java.util.List;

public interface ICallBask {
    void onSuccess(List<User.ResultsBean> success);
    void onError(String error);
}
