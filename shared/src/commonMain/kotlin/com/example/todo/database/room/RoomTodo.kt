package com.example.todo.database.room// shared/src/commonMain/kotlin/com/example/todo/room/RoomTodo.kt
import androidx.room3.Dao
import androidx.room3.Entity
import androidx.room3.Insert
import androidx.room3.PrimaryKey
import androidx.room3.Query

@Entity
data class RoomTodo(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val isCompleted: Boolean
)

@Dao
interface TodoDao {
    @Query("SELECT * FROM RoomTodo")
    suspend fun getAllTodos(): List<RoomTodo>

    @Insert
    suspend fun insertTodo(todo: RoomTodo)
}
