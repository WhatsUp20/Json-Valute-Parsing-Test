package com.example.appforfocus.database;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.appforfocus.Valutes;
import com.example.appforfocus.api.NetworkApi;
import com.example.appforfocus.api.NetworkService;
import com.example.appforfocus.focus.CurrencyResponce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ValutesViewModel extends AndroidViewModel {

    private static ValutesDatabase database;
    private LiveData<List<Valutes>> valutes;
    private CompositeDisposable compositeDisposable;
    private List<Valutes> list;
    private Collection<Valutes> collection;

    public ValutesViewModel(@NonNull Application application) {
        super(application);
        database = ValutesDatabase.getInstance(application);
        valutes = database.valutesDao().getAllValutes();
    }

    public LiveData<List<Valutes>> getValutes() {
        return valutes;
    }

    @SuppressWarnings("unchecked")
    void insertAllValutes(List<Valutes> valutes) {
        new InsertAllValutesTask().execute(valutes);
    }

    void removeAllValutes() {
        new RemoveAllValutesTask().execute();
    }

    private static class InsertAllValutesTask extends AsyncTask<List<Valutes>,Void,Void> {

        @SafeVarargs
        @Override
        protected final Void doInBackground(List<Valutes>... lists) {
            if (lists != null && lists.length > 0) {
                database.valutesDao().insertValute(lists[0]);
            }
            return null;
        }
    }

    private static class RemoveAllValutesTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            database.valutesDao().removeAllValutes();
            return null;
        }
    }

    public void loadData() {
        compositeDisposable = new CompositeDisposable();
        NetworkService service = NetworkService.getInstance();
        NetworkApi api = service.getAllApi();
        Disposable disposable = api.getAllResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrencyResponce>() {
                    @Override
                    public void accept(CurrencyResponce responce) throws Exception {
                        removeAllValutes();
                        collection = responce.getValute().values();
                        list = new ArrayList<>(collection);
                        insertAllValutes(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getApplication(), "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    public void disposeDisposable() {
        compositeDisposable.dispose();
    }


}
