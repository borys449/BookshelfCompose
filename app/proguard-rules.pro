# Retrofit 2 rules
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature, InnerClasses, EnclosingMethod

# Gson rules
-keepattributes *Annotation*
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

# Domain & Model classes
-keep class com.example.bookshelf.model.** { *; }
-keepclassmembers class com.example.bookshelf.model.** { *; }
