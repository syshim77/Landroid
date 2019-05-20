# 안드로이드 앱 프로그래밍 Day 11
다양한 위젯 활용

## 40강
이벤트처리

###### 버튼을 클릭했을때 어떻게 출력하는가?  
+ sol1  
  - 버튼 tag가 추가되었을때 onClick 속성을 추가한다.  
  - 동일한 메소드를 java src에 추가  
+ sol2  
  - 이벤트 리스너 등록  
  - OnClickListener  

## 40강
?? android:layout_below="@+id/textView" 없음
---> margin_bottom

## 41강
?? unknown error - log
~~~
2019-05-13 21:47:50.148 1886-2018/? E/WifiMetrics: Unknown link probe status: 0
2019-05-13 21:47:50.148 1886-2018/? E/WifiMetrics: Unknown link probe status: 0
2019-05-13 21:47:50.188 4769-4826/? I/NativeLibraryUtils: Extraction to /data/user_de/0/com.google.android.gms/app_extracted_libs/x86/libpredictor_jni.so false
2019-05-13 21:47:50.213 4769-4826/? I/NativeLibraryUtils: Extraction to /data/user_de/0/com.google.android.gms/app_extracted_libs/x86/libsslwrapper_jni.so false
2019-05-13 21:47:50.229 2406-4779/? W/DynamiteModule: Local module descriptor class for providerinstaller not found.
2019-05-13 21:47:50.230 2406-4779/? I/DynamiteModule: Considering local module providerinstaller:0 and remote module providerinstaller:0
2019-05-13 21:47:50.230 2406-4779/? W/ProviderInstaller: Failed to load providerinstaller module: No acceptable module found. Local version is 0 and remote version is 0.
2019-05-13 21:47:50.329 2406-4775/? I/MobileDataHub: Scheduling periodic tasks
2019-05-13 21:47:50.376 4769-4826/? I/NativeLibraryUtils: Extraction to /data/user_de/0/com.google.android.gms/app_extracted_libs/x86/libvcdiffjni.so false
2019-05-13 21:47:50.403 4769-4826/? I/NativeLibraryUtils: Extraction to /data/user_de/0/com.google.android.gms/app_extracted_libs/x86/libwearable-selector.so false
2019-05-13 21:47:50.451 2406-3029/? I/Icing: updateResources: need to parse abiz{com.google.android.videos}
2019-05-13 21:47:50.481 2406-3672/? I/Icing: IndexChimeraService.getServiceInterface callingPackage=com.google.android.gms componentName=AppsCorpus serviceId=SEARCH_QUERIES
2019-05-13 21:47:50.483 2406-4723/? I/Icing: IndexChimeraService.getServiceInterface callingPackage=com.google.android.gms componentName=AppsCorpus serviceId=SEARCH_CORPORA
2019-05-13 21:47:50.504 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
2019-05-13 21:47:50.547 1690-1690/? I/chatty: uid=1000(system) /system/bin/surfaceflinger identical 1 line
2019-05-13 21:47:50.574 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
2019-05-13 21:47:50.670 2406-4775/? W/MobileDataHub: [Service] appsupload-periodic periodic task disabled
2019-05-13 21:47:50.753 1886-3126/? I/ActivityManager: Killing 3916:com.ustwo.lwp/u0a43 (adj 985): empty #17
2019-05-13 21:47:50.759 1886-1908/? W/libprocessgroup: kill(-3916, 9) failed: No such process
2019-05-13 21:47:50.783 3289-3309/? W/d.process.medi: Suspending all threads took: 6.920ms
2019-05-13 21:47:50.792 1651-1651/? I/Zygote: Process 3916 exited due to signal (9)
2019-05-13 21:47:50.801 1886-1908/? W/libprocessgroup: kill(-3916, 9) failed: No such process
2019-05-13 21:47:50.802 1886-1908/? I/libprocessgroup: Successfully killed process cgroup uid 10043 pid 3916 in 42ms
2019-05-13 21:47:50.807 2848-2848/? W//system/bin/adbd: type=1400 audit(0.0:189): avc: denied { create } for comm=73657276657220736F636B6574 scontext=u:r:adbd:s0 tcontext=u:r:adbd:s0 tclass=socket permissive=0
2019-05-13 21:47:51.096 2406-2406/? I/gle.android.gm: IncrementDisableThreadFlip blocked for 11.706ms
2019-05-13 21:47:51.098 2406-3029/? I/gle.android.gm: IncrementDisableThreadFlip blocked for 13.601ms
2019-05-13 21:47:51.359 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
2019-05-13 21:47:51.397 1690-1690/? I/chatty: uid=1000(system) /system/bin/surfaceflinger identical 1 line
2019-05-13 21:47:51.437 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
2019-05-13 21:47:51.509 1886-1986/? E/ReportEncoder: No watchlist hash
2019-05-13 21:47:51.647 1886-1986/? I/WatchlistLoggingHandler: Milliseconds spent on tryAggregateRecords(): 523164646
2019-05-13 21:47:51.807 2848-2848/? W//system/bin/adbd: type=1400 audit(0.0:190): avc: denied { create } for comm=73657276657220736F636B6574 scontext=u:r:adbd:s0 tcontext=u:r:adbd:s0 tclass=socket permissive=0
2019-05-13 21:47:51.844 4105-4327/? I/Dialer: OmtpVvmCarrierCfgHlpr - OmtpEvent:CONFIG_STATUS_SMS_TIME_OUT
2019-05-13 21:47:51.865 4105-4105/? I/Dialer: RetryPolicy - discarding deferred status: configuration_state=4
2019-05-13 21:47:51.909 4105-4105/? I/Dialer: VvmTaskExecutor - no more tasks, stopping service if no task are added in 5000 millis
2019-05-13 21:47:52.175 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
2019-05-13 21:47:52.262 1690-1690/? E/EGL_emulation: tid 1690: eglDestroyImageKHR(2041): error 0x300c (EGL_BAD_PARAMETER)
~~~

## 42강
제스쳐 디텍터 - 스크롤/풀링등의 속도등을 체크할 수 있음

## 43강
?? Log.d가 제대로 작동되지 않음 에러 해결  
Logcat에 나와야하는것이 textView로 업데이트가 되다가 Back 기능을 추가하니 아예 textView가 보이지 않게됨  
--> 아래의 view를 제거하니 보임  

activity 단위로 화면을 회전시킬 수 있다.  
화면을 돌리기 위해서는 manifest에 등록해야한다.  
event로 받아서 MainActivity에서 이벤트 처리를 해준다.  
~~~java
<activity android:name=".MainActivity"
            android:configChanges="orientation|screenSize|keyboardHidden">
  // activity의 정보가 바뀌는 경우를 이벤트로 날려준다.
  // orientation : 방향이 전환되는 것
  // keyboardHidden : 커서가 가있는 포커스 이벤트가 가있어도 키보드를 띄우지않는다.
~~~
