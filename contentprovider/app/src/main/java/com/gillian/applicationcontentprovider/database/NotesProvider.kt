package com.gillian.applicationcontentprovider.database

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

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
        TODO("Implement this to handle requests to delete one or more rows")
    }

    // Retorna dados de imagem, arquivos...
    override fun getType(uri: Uri): String? {
        TODO(
            "Implement this to handle requests for the MIME type of the data" +
                    "at the given URI"
        )
    }

    // Insere dados na aplicação através do content privider
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Implement this to handle requests to insert a new row.")
    }

    // Seleciona arquivos dentro do sistema operacional, seleciona banco de dados...
    // Sempre retorna um cursor
    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        TODO("Implement this to handle query requests from clients.")
    }

    // Atualiza o ID do content provider
    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        TODO("Implement this to handle requests to update one or more rows.")
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