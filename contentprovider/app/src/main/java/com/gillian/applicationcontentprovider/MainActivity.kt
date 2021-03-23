package com.gillian.applicationcontentprovider

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns._ID
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
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

    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteAdd = findViewById(R.id.note_add)
        noteAdd.setOnClickListener{
           NotesDetailFragment().show(supportFragmentManager, "dialog")
        }

        adapter = NotesAdapter(object : NoteClickedListener{
            override fun noteClickedItem(cursor: Cursor){
                val id : Long = cursor.getLong(cursor.getColumnIndex(_ID))
                val fragment: NotesDetailFragment = NotesDetailFragment().newInstance(id)
                fragment.show(supportFragmentManager, "dialog")

            }

            override fun noteRemoveItem(cursor: Cursor?) {
                val id : Long? = cursor?.getLong(cursor.getColumnIndex(_ID))
                contentResolver.delete(Uri.withAppendedPath(URI_NOTES, id.toString()), null, null)
            }
        })
        adapter.setHasStableIds(true)
        noteRecyclerView = findViewById(R.id.notes_recycler)
        noteRecyclerView.layoutManager = LinearLayoutManager(this)
        noteRecyclerView.adapter = adapter
        LoaderManager.getInstance(this).initLoader(0, null, this)
    }
    // instancia o que será buscado (pesquisa no content provider)
    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> =
        CursorLoader(this, URI_NOTES, null, null, null, TITLE_NOTES)

    // permite a manipulação dos dados recebidos
    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
       if(data != null){ adapter.setCursor(data)}
    }

    // acaba com a pesquisa em segundo plano do loadmanager
    override fun onLoaderReset(loader: Loader<Cursor>) {
        adapter.setCursor(null)
    }
}