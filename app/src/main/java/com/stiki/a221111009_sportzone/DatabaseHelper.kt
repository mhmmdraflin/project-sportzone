package com.stiki.a221111009_sportzone

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Booking.db"
        const val TABLE_NAME = "Bookings"

        const val COLUMN_ID = "_id"
        const val COLUMN_NAMA = "nama"
        const val COLUMN_TANGGAL = "tanggal"
        const val COLUMN_LAPANGAN = "lapangan"
        const val COLUMN_OLAHRAGA = "olahraga"
        const val COLUMN_DURASI = "durasi"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAMA TEXT, " +
                "$COLUMN_TANGGAL TEXT, " +
                "$COLUMN_LAPANGAN TEXT, " +
                "$COLUMN_OLAHRAGA TEXT, " +
                "$COLUMN_DURASI TEXT)")
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addBooking(nama: String, tanggal: String, lapangan: String, olahraga: String, durasi: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NAMA, nama)
            put(COLUMN_TANGGAL, tanggal)
            put(COLUMN_LAPANGAN, lapangan)
            put(COLUMN_OLAHRAGA, olahraga)
            put(COLUMN_DURASI, durasi)
        }
        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun getAllBookings(): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_NAME, null, null, null, null, null, null)
    }

    fun updateBooking(id: Int, nama: String, tanggal: String, lapangan: String, olahraga: String, durasi: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NAMA, nama)
            put(COLUMN_TANGGAL, tanggal)
            put(COLUMN_LAPANGAN, lapangan)
            put(COLUMN_OLAHRAGA, olahraga)
            put(COLUMN_DURASI, durasi)
        }
        return db.update(TABLE_NAME, contentValues, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }

    fun deleteBooking(id: Int): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
    }
}
