package com.gillian.applicationcontentprovider.database

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class NotesProvider : ContentProvider() {

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

    // Inicia tudo. Faz a instância dos bancos de dados, URLs...
    override fun onCreate(): Boolean {
        TODO("Implement this to initialize your content provider on startup.")
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
}