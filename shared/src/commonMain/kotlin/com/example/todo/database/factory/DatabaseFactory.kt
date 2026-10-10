package com.example.todo.database.factory
import androidx.room3.RoomDatabase
import com.example.todo.database.room.AppRoomDatabase

expect class DatabaseFactory {
    fun createRoomDatabase(): RoomDatabase.Builder<AppRoomDatabase>
    fun createSqlDelightDriver(): app.cash.sqldelight.db.SqlDriver
}
