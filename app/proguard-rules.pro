-keep class * extends com.example.agendamedica.** { *; }
-keep interface com.example.agendamedica.** { *; }
-keep enum com.example.agendamedica.** { *; }

# Kotlin
-keep class kotlin.** { *; }
-keep interface kotlin.** { *; }
-dontwarn kotlin.**

# AndroidX
-keep class androidx.** { *; }
-keep interface androidx.** { *; }

# Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keep @androidx.room.Dao class *
