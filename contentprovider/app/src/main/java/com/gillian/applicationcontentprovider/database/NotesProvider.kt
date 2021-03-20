package com.gillian.applicationcontentprovider.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import android.provider.BaseColumns._ID
import com.gillian.applicationcontentprovider.database.NotesDatabaseHelper.Companion.TABLE_NOTES
import java.lang.UnsupportedOperationException

class NotesProvider : ContentProvider() {

    // OnCreate() Inicia tudo. Faz a instância dos bancos de dados, URLs...
    private lateinit var mUriMatcher: UriMatcher //valida a Url de requisição do content provider
    private  lateinit var dbHelper: NotesDatabaseHelper
    override fun onCreate(): Boolean {
        mUriMatcher = UriMatcher(UriMatcher.NO_MATCH) // instância do content privider
        // identificações do content provider
        mUriMatcher.addURI(AUTORITY, "notes", NOTES)
        mUriMatcher.addURI(AUTORITY,"notes/#", NOTES_BY_ID) // # indica que tem uma query string

        if(context != null){dbHelper = NotesDatabaseHelper(context as Context)} // Esse contexto jamais poderá ser nulo para criação do BD.
        return true
    }

    // Deleta os dados do provider
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        if(mUriMatcher.match(uri) == NOTES_BY_ID){
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val linesAffect = db.delete(TABLE_NOTES, "$_ID=?", arrayOf(uri.lastPathSegment))
            db.close()
            context?.contentResolver?.notifyChange(uri, null) // Notifica tudo o que foi alterado no bd
            return linesAffect
        }else{
            throw UnsupportedOperationException("Uri inválida para exclusão!")
        }
    }

    // Retorna dados de imagem, arquivos...
    // Não será utilizada neste projeto e por conta disso receberá tratamento de erros
    override fun getType(uri: Uri): String? = throw UnsupportedOperationException ("Não implementada")

    // Insere dados na aplicação através do content privider
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        if(mUriMatcher.match(uri) == NOTES){
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val id:Long = db.insert(TABLE_NOTES, null, values)
            val insertUri = Uri.withAppendedPath(BASE_URI, id.toString())
            db.close()
            context?.contentResolver?.notifyChange(uri, null)
            return insertUri
        }else{
            throw UnsupportedOperationException("Uri inválida para inserção!")
        }
    }

    // Seleciona arquivos dentro do sistema operacional, seleciona banco de dados...
    // Sempre retorna um cursor
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return when{
            mUriMatcher.match(uri) == NOTES -> {
                val db: SQLiteDatabase = dbHelper.writableDatabase
                val cursor =
                    db.query(TABLE_NOTES, projection, selection, selectionArgs, null, null, sortOrder)
                cursor.setNotificationUri(context?.contentResolver, uri)
                cursor
            }
            mUriMatcher.match(uri) == NOTES_BY_ID -> {
                val db: SQLiteDatabase = dbHelper.writableDatabase
                val cursor = db.query(TABLE_NOTES, projection, "$_ID = ?", arrayOf(uri.lastPathSegment), null, null, sortOrder)
                cursor.setNotificationUri((context as Context).contentResolver, uri)
                cursor
            }
            else -> {
                throw UnsupportedOperationException("Uri nao implementada!")
            }
        }
    }

    // Atualiza o ID do content provider
    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        if(mUriMatcher.match(uri) == NOTES_BY_ID){
            val db: SQLiteDatabase = dbHelper.writableDatabase
            val linesAffect = db.update(TABLE_NOTES, "$_ID=?", arrayOf(uri.lastPathSegment))
            db.close()
            context?.contentResolver?.notifyChange(uri, null)
            return linesAffect
        }else{
            throw UnsupportedOperationException("Uri não implementada")
        }
    }

    companion object{
        // Copiar o endereço da AUTORITY do Manifest
        // Define o endereço do provider
        const val AUTORITY = "com.gillian.applicationcontentprovider.provider"
        val BASE_URI = Uri.parse("content://$AUTORITY") // Requisita o content provider em qualquer app
        val URI_NOTES = Uri.withAppendedPath(BASE_URI, "notes")  //"content:com.gillian.applicationcontentprovider.provider/notes

        const val NOTES = 1
        const val NOTES_BY_ID = 2

    }
}