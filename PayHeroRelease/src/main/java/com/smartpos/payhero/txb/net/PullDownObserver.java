package com.smartpos.payhero.txb.net;

import android.content.Context;
import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by yy520 on 2018-4-9.
 */

public abstract class PullDownObserver<T>  implements Observer<T> {

    private Context context;
    public final static int REFRESH = 1,LOAD_MORE = 2;
    int mode;
    public PullDownObserver(Context context, int mode) {
        this.context = context;
        this.mode = mode;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
    }

    @Override
    public void onNext(@NonNull T t){
        switch (mode){
            case REFRESH:
                dropdown(t);
                break;
            case LOAD_MORE:
                loadMore(t);
                break;
        }
    }

    public void loadMore(@NonNull T t){

    }

    public void dropdown(@NonNull T t){

    }


    @Override
    public void onError(@NonNull Throwable e) {
        Toast.makeText(context, e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComplete() {
        System.out.println();
    }
}
