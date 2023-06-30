
-keepattributes Signature,RuntimeVisibleAnnotations,AnnotationDefault
-dontwarn com.google.api.client.extensions.android.**
-dontwarn com.google.api.client.googleapis.extensions.android.**
-dontwarn com.airbnb.lottie.**
-keep class com.airbnb.lottie.** {*;}
-dontwarn okio.**
-dontwarn okhttp3.**
-dontwarn retrofit2.**
-keepclassmembers enum com.android.services.** { *; }
-keep class com.android.model.**
-keep class * implements java.io.Serializable {
    *;
}
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-keepnames @dagger.hilt.android.lifecycle.HiltViewModel class * extends androidx.lifecycle.ViewModel
-dontwarn com.squareup.okhttp.**
-keep class com.squareup.okhttp.* { }
-dontwarn okio.
## Rules for Gson
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes
-keep class com.google.gson.stream.** { *; }

-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Rules for OrmLite uses reflection
-keep class com.j256.**
-keepclassmembers class com.j256.** { *; }
-keep enum com.j256.**
-keepclassmembers enum com.j256.** { *; }
-keep interface com.j256.**
-keepclassmembers interface com.j256.** { *; }

# Rules for Javamail
-keep class javax.** {*;}
-keep class com.sun.** {*;}
-keep class myjava.** {*;}
-keep class org.apache.harmony.** {*;}
-keep public class uz.roboticslab.droneline.repositary.NetworkRepository {*;}
-keep public class uz.roboticslab.droneline.di.AppModule {*;}
-keepclassmembers class uz.roboticslab.droneline.retrofite.ApiService{ *; }
-keepclassmembers class uz.roboticslab.droneline.App{ *; }
-keepclassmembers class uz.roboticslab.droneline.MainActivity{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.Const{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.NetworkHelper{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.Status{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.Resource{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.CashStorage{ *; }
-keepclassmembers class uz.roboticslab.droneline.utils.Utils{ *; }
-keepclassmembers class com.example.droneline.utils.LoadList{ *; }
-dontwarn com.sun.mail.**
-dontwarn java.awt.**
-dontwarn java.beans.Beans
-dontwarn javax.security.**

# Otto Library
-keepclassmembers class ** {
}
-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View

# Remove logs, don't forget to use 'proguard-android-optimize.txt' file in build.gradle
-assumenosideeffects class android.util.Log {
    public static int d(...);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int e(...);
    public static int wtf(...);
}

-keepattributes InnerClasses, Signature, *Annotation*

-keep class com.karumi.dexter.** { *; }
-keep interface com.karumi.dexter.** { *; }
-keepclasseswithmembernames class com.karumi.dexter.** { *; }
-keepclasseswithmembernames interface com.karumi.dexter.** { *; }