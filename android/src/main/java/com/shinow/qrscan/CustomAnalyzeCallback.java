package com.shinow.qrscan;

import android.content.Intent;
import android.graphics.Bitmap;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import io.flutter.plugin.common.MethodChannel.Result;

public class CustomAnalyzeCallback implements CodeUtils.AnalyzeCallback {
    private final Result result;
    private final Intent intent;

    public CustomAnalyzeCallback(Result result, Intent intent) {
        this.result = result;
        this.intent = intent;
    }

    @Override
    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
        this.result.success(result);
    }

    @Override
    public void onAnalyzeFailed() {
        String errorCode = this.intent.getStringExtra("ERROR_CODE");
        assert errorCode != null;
        this.result.error(errorCode, null, null);
    }
}