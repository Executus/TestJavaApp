package com.example.testnativelib;

import android.os.Handler;
import android.os.Looper;

public class NativeLib {

    // Used to load the 'testnativelib' library on application startup.
    static {
        System.loadLibrary("testnativelib");
    }

    // Interface for the game to supply a callback
    public interface ProcessIntCallback {
        void onComplete(int x);
    }

    // The game callback to call when complete
    private ProcessIntCallback processIntCallback;

    // Invokes the native lib function on a background thread so we don't block the main thread.
    public void processIntAsync(int x, ProcessIntCallback callback) {
        // Store the game callback for later
        processIntCallback = callback;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                nativeProcessIntAsync(x);
            }
        };

        // Invoke the native lib function on a new thread
        new Thread(runnable).start();
    }

    // This is called by the native lib when it's finished processing. Because the task was run on
    // a background thread, we need to invoke the game callback on the main thread.
    private void nativeProcessIntCallback(int x) {
        Handler mainHandler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // The game callback
                processIntCallback.onComplete(x);
            }
        };

        // Invoke the game callback on the main thread
        mainHandler.post(runnable);
    }

    // Native function (JNI) declaration
    private native void nativeProcessIntAsync(int x);
}