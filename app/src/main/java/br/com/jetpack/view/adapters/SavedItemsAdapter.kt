package br.com.jetpack.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.jetpack.data.local.ProductModel
import br.com.jetpack.databinding.ViewSavedItemBinding
import br.com.jetpack.extentions.setPromoSpannableText
import br.com.jetpack.viewmodel.ProductListViewModel


/**
 *Created by humbertokalex
 */

class SavedItemsAdapter(
    private val viewModelProduct: ProductListViewModel,
    private var items: List<ProductModel>
) : RecyclerView.Adapter<SavedItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewSavedItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productModel = items[position]
        holder.bind(productModel)
    }

    inner class ViewHolder(
        private val binding: ViewSavedItemBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productModel: ProductModel) {
            with(binding) {
                viewModel = viewModelProduct
                this.productModel = productModel

                imageProduct.setImageDrawable(ContextCompat.getDrawable(context, productModel.img))

                if (productModel.promoPrice.isNotEmpty())
                    price.setPromoSpannableText(productModel.price, productModel.promoPrice)
                else
                    price.text = productModel.price

            }
        }
    }

}
