package br.com.jetpack.di

import androidx.room.Room
import br.com.jetpack.data.local.database.DataBase
import br.com.jetpack.data.repository.ProductRepository
import br.com.jetpack.domain.ProductUseCase
import br.com.jetpack.viewmodel.ProductListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/**
 *Created by humbertokalex
 */

object Modules {
    private val dataModule = module {
        single {
            Room.databaseBuilder(get(), DataBase::class.java, "product-db")
                .fallbackToDestructiveMigration()
                .build()
        }
        factory { ProductRepository(get()) }
    }

    private val domainModule = module {
        factory { ProductUseCase(get()) }
    }

    private val viewModule = module {
        viewModel {

            ProductListViewModel(
                get()
            )
        }
    }

    fun loadModules() {
        loadKoinModules(listOf(dataModule, domainModule, viewModule))
    }
}