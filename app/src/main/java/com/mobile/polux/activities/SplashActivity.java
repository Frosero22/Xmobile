package com.mobile.polux.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobile.polux.app.App;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkFinalizeInstall()) {
            goToFinish();
            return;
        }

        if (checkTokenAccess()) {
            goToLogin();
            return;
        }

        goToMain();
    }

    private boolean checkFinalizeInstall() {
        return !(App.getValueOfPreferencesUser(App.KEY_WS_COMPANY).isEmpty());
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void goToFinish() {
        Intent intent = new Intent(this, FinishInstallationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private boolean checkTokenAccess() {
        return (App.getValueOfPreferencesUser(App.KEY_USER_CODE, "").length()<2 || App.getValueOfPreferencesUser(App.KEY_SUB_COMPANY_CODE, 0) == 0);
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
