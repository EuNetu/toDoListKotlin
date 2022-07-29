package tads.eaj.ufrn.todolistkotlin.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.todolistkotlin.R
import tads.eaj.ufrn.todolistkotlin.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos : List<Produto>
): RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
            val title = itemView.findViewById<TextView>(R.id.title)
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            val valor = itemView.findViewById<TextView>(R.id.valor)

            title.text = produto.title
            descricao.text = produto.descricao
            valor.text = produto.valor.toPlainString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
}
