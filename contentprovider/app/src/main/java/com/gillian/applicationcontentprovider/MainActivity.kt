package com.gillian.applicationcontentprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.RecyclerView
import com.gillian.applicationcontentprovider.database.NotesDatabaseHelper.Companion.TITLE_NOTES
import com.gillian.applicationcontentprovider.database.NotesProvider.Companion.URI_NOTES
import com.google.android.material.floatingactionbutton.FloatingActionButton

// RecyclerView é responsável por receber todos os dados do ContentProvider
// Para trabalhar com o content provider é preciso instanciar o Loader Manager
// Loader manager faz a busca em segundo plano do cursor e por isso não dá erros de thred
class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {
    lateinit var noteRecyclerView: RecyclerView
    lateinit var noteAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.note_add)
        noteAdd.setOnClickListener{ }
        noteRecyclerView = findViewById(R.id.notes_recycler)
    }
    // instancia o que será buscado (pesquisa no content provider)
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)

    // permite a manipulação dos dados recebidos
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
       if(data != null){}
    }

    // acaba com a pesquisa em segundo plano do loadmanager
    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
}