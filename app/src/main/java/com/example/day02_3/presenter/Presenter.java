package com.example.day02_3.presenter;



import com.example.day02_3.User;
import com.example.day02_3.model.ICallBask;
import com.example.day02_3.model.Modelmap;
import com.example.day02_3.view.IView;

import java.util.List;

public class Presenter implements IPresenter{
    private final Modelmap modelmap;
    private IView iView;

    public Presenter(IView iView) {
        modelmap = new Modelmap();
        this.iView = iView;
    }

    @Override
    public void getDataP() {
        if (modelmap!=null){
            modelmap.getDataM(new ICallBask() {
                @Override
                public void onSuccess(List<User.ResultsBean> success) {
                    iView.onSuccess(success);
                }

                @Override
                public void onError(String error) {
                    iView.onError(error);
                }
            });
        }
    }
}
