SET ANDROID_ADB=%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe

SET APK_FILE=app\build\outputs\apk\debug\app-debug.apk

%ANDROID_ADB% install %APK_FILE%

pause