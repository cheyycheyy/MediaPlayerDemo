package com.inesadt.tv.activity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.inesadt.tv.R;
import com.inesadt.tv.utils.LogUtils;

/**
 * 主界面
 */
public class SmartActivity extends FragmentActivity {

    private static final String TAG = "SmartTv_SmartActivity";

    private MediaPlayer mPlayer;
    private String mVideoName="SongjiangPropagandaFilm_StandardClear.mp4";
    private String mAssetsPath = "file:///android_asset/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_smart);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SurfaceView sv = (SurfaceView) findViewById(R.id.sv_main);
        mPlayer = new MediaPlayer();
        setupSurfaceHolder(sv);
        setupMediaPlayer();
    }


    /**
     * 设置SurfaceHolder
     */
    private void setupSurfaceHolder(SurfaceView sv) {
        sv.setZOrderOnTop(true);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(837, 624);
        lp.setMargins(97, 229, 0, 0);  // set position
        sv.setLayoutParams(lp);
        SurfaceHolder holder = sv.getHolder();
        SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    mPlayer.setDisplay(holder);
                } catch (IllegalStateException e) {
                    finish();
                }
            }

            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            public void surfaceDestroyed(SurfaceHolder holder) {
                releaseMediaPlayer();
            }
        };
        holder.addCallback(callback);
    }

    /**
     * 设置MediaPlayer
     */
    private void setupMediaPlayer() {
        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor fileDescriptor = assetManager.openFd(mVideoName);
            mPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(),
                    fileDescriptor.getLength());
            mPlayer.prepareAsync();
        } catch (Exception e) {
            LogUtils.e(TAG, "error:: " + e.getMessage());
        }
        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
    }

    /**
     * 释放MediaPlayer
     */
    private void releaseMediaPlayer() {
//        mController.removeHandlerCallback();
        if (mPlayer != null) {
            try {
                mPlayer.stop();
            } catch (IllegalStateException e) {
                LogUtils.e(TAG, "error:: " + e.getMessage());
//                e.printStackTrace();
                finish();
            } finally {
                mPlayer.release();
                mPlayer = null;
            }
        }
    }

    @Override
    protected void onPause() {
        try {
            mPlayer.pause();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            finish();
        }

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        releaseMediaPlayer();
        super.onDestroy();
    }



}
