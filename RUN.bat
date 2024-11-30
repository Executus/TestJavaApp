SET ANDROID_ADB=%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe

%ANDROID_ADB% shell am start -n com.example.testjavaapp/com.example.testjavaapp.MainActivity

pause