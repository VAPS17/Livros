package pt.ipg.livros

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.loader.app.LoaderManager
import androidx.navigation.fragment.findNavController
import pt.ipg.livros.databinding.FragmentListaLivrosBinding
import android.database.Cursor
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListaLivrosFragment : Fragment(), LoaderManager.LoaderCallbacks<Cursor> {

    private var _binding: FragmentListaLivrosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaLivrosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loaderManager = LoaderManager.getInstance(this)

        loaderManager.initLoader(ID_LOADER_MANAGER_LIVROS, null,this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        return CursorLoader(
            requireContext(),
            ContentProviderLivros.ENDERECO_LIVROS,
            TabelaLivros.TODAS_COLUNAS,
            null, null,
            TabelaLivros.CAMPO_TITULO
        )
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        TODO("Not yet implemented")
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }

    companion object {
        const val ID_LOADER_MANAGER_LIVROS = 0
    }
}