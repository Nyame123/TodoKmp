package com.example.todo.database.factory
import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.todo.cache.CacheDatabase
import com.example.todo.database.room.AppRoomDatabase

actual class DatabaseFactory(private val context: Context) {
    actual fun createRoomDatabase(): RoomDatabase.Builder<AppRoomDatabase> {
        val dbFile = context.getDatabasePath("room_todo.db")
        return Room.databaseBuilder<AppRoomDatabase>(
            context = context,
            name = dbFile.absolutePath
        )
    }

    actual fun createSqlDelightDriver(): SqlDriver {
        return AndroidSqliteDriver(CacheDatabase.Schema, context, "sqldelight_cache.db")
    }
}
