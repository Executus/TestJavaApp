#include <jni.h>

#ifndef _testnativelib_jni
#define _testnativelib_jni

#ifdef __cplusplus
extern "C" {
#endif // __cplusplus

JNIEXPORT void JNICALL Java_com_example_testnativelib_NativeLib_nativeProcessIntAsync(JNIEnv* env, jobject, jint x);

#ifdef __cplusplus
}
#endif // __cplusplus

#endif // _testnativelib_jni