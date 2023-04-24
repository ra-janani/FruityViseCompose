package com.example.fruityvisecompose.ui.fruits

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fruityvisecompose.data.FruitsItemModel

@Composable
fun FruitsScreen() {
    val fruitsViewModel = viewModel(modelClass = FruitsViewModel::class.java)
    val state by fruitsViewModel.fruits.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }

        }

        items(state) { fruits: FruitsItemModel ->
            FruitsCard(fruits=fruits)
        }


    }

}

@Composable
fun FruitsCard(fruits: FruitsItemModel) {

    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Box {


            Surface(
                color=MaterialTheme.colorScheme.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(text = "Fruit: ${fruits.name}")
                    Text(text = "Family: ${fruits.family}")
                    Text(text = "Genus: ${fruits.genus}")
                    Text(text = "Order: ${fruits.order}")

                }
            }


        }


    }


}
