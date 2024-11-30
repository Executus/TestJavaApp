#include "testnativelib.h"
#include <string>
#include <iostream>
#include <thread>
#include <chrono>

// JNI function for Java function:
// void nativeProcessIntAsync(int x);
void JNICALL Java_com_example_testnativelib_NativeLib_nativeProcessIntAsync
(JNIEnv* env, jobject javaObject, jint x)
{
    // Get the native callback function that we'll need to call when we're done
    jclass javaClass = env->GetObjectClass(javaObject);
    jmethodID callbackMethod = env->GetMethodID(javaClass, "nativeProcessIntCallback", "(I)V");

    if (callbackMethod == nullptr)
    {
        std::cout << "Could not find method getIntegerCallback." << std::endl;
        return;
    }

    // Sleep for 10 seconds. This is running on a background thread so not blocking UI.
    std::this_thread::sleep_for(std::chrono::seconds(10));

    // Invoke the native callback
    env->CallVoidMethod(javaObject, callbackMethod, x);
}