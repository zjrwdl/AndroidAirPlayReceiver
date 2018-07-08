package com.beatofthedrum.alacdecoder.airplay.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.crypto.Cipher;

import nz.co.iswe.android.airplay.AirPlayServer;

/**
 * Created by Administrator on 2018/6/29.
 */

public class AirplayActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String transformation = "RSA/None/OAEPWithSHA1AndMGF1Padding";
        try {
            Cipher rsaPkCS1OaepCipher = Cipher
                    .getInstance(transformation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AirPlayServer airPlayServer = AirPlayServer.getIstance();
        airPlayServer.setRtspPort(5000);
        Thread thread = new Thread(airPlayServer);
        thread.start();
    }
}
