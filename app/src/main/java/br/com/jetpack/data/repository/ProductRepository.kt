package br.com.jetpack.data.repository

import br.com.jetpack.data.local.database.DataBase
import br.com.jetpack.data.local.database.entity.ProductEntity
import br.com.jetpack.data.local.database.entity.SavedProductEntity

/**
 *Created by humbertokalex
 */

class ProductRepository(
    private val dataBase: DataBase
) {

    suspend fun getProducts() = dataBase.productDao().getAllProducts()

    suspend fun getSavedProducts() = dataBase.productDao().getAllSaved()

    suspend fun saveProduct(savedProductEntity: SavedProductEntity) =
        dataBase.productDao().insertSavedProduct(savedProductEntity)

    suspend fun removeProduct(savedProductEntity: SavedProductEntity) =
        dataBase.productDao().removeSavedProduct(savedProductEntity.id)

    suspend fun saveMockProduct(productEntity: List<ProductEntity>) =
        dataBase.productDao().insertMock(productEntity)
}