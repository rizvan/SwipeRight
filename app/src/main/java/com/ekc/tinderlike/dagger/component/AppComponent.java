package com.ekc.tinderlike.dagger.component;

import android.app.Application;
import android.content.res.Resources;
import com.ekc.tinderlike.dagger.module.AppModule;
import com.ekc.tinderlike.dagger.module.DataModule;
import com.ekc.tinderlike.dagger.module.MainActivityModule;
import com.ekc.tinderlike.dagger.qualifier.PerApp;
import com.ekc.tinderlike.dagger.qualifier.Qualifiers;
import com.ekc.tinderlike.dagger.qualifier.Qualifiers.Token;
import com.ekc.tinderlike.data.StringPreference;
import com.ekc.tinderlike.data.TinderApi;
import com.ekc.tinderlike.ui.main.MainActivity;
import dagger.Component;

@PerApp
@Component(modules = { AppModule.class, DataModule.class })
public interface AppComponent extends BaseComponent {
  TinderApi tinderApi();
  Resources resources();
  @Token StringPreference token();

  final class Initializer {
    private Initializer() {
      // no-op
    }

    public static AppComponent init(Application app) {
      return DaggerAppComponent.builder()
          .appModule(new AppModule(app))
          .dataModule(new DataModule())
          .build();
    }
  }
}