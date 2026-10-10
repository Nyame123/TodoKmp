package com.example.todo.database.room
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.ConstructedBy
import androidx.room3.RoomDatabaseConstructor

@Database(entities = [RoomTodo::class], version = 1)
@ConstructedBy(AppRoomDatabaseConstructor::class)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}

@Suppress("KotlinNoActualForExpect") // Suppresses IDE warning; Room generates the actuals automatically
expect object AppRoomDatabaseConstructor : RoomDatabaseConstructor<AppRoomDatabase> {
    override fun initialize(): AppRoomDatabase
}
