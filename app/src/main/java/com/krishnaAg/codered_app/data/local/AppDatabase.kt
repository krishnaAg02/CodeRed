package com.krishnaAg.codered_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.krishnaAg.codered_app.data.local.dao.BloodRequestDao
import com.krishnaAg.codered_app.data.local.dao.DonorDao
import com.krishnaAg.codered_app.data.local.dao.EventDao
import com.krishnaAg.codered_app.data.local.dao.UserDao
import com.krishnaAg.codered_app.data.local.dao.VolunteerDao
import com.krishnaAg.codered_app.data.local.entity.BloodRequestEntity
import com.krishnaAg.codered_app.data.local.entity.DonorEntity
import com.krishnaAg.codered_app.data.local.entity.EventEntity
import com.krishnaAg.codered_app.data.local.entity.UserEntity
import com.krishnaAg.codered_app.data.local.entity.VolunteerEntity

@Database(
    entities = [
        BloodRequestEntity::class,
        UserEntity::class,
        VolunteerEntity::class,
        EventEntity::class,
        DonorEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bloodRequestDao(): BloodRequestDao
    abstract fun userDao(): UserDao
    abstract fun volunteerDao(): VolunteerDao
    abstract fun eventDao(): EventDao
    abstract fun donorDao(): DonorDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "codered_db"
                ).fallbackToDestructiveMigration().build().also { INSTANCE = it }
            }
        }
    }
}
