package com.example.apicalling.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.apicalling.viewmodel.ProductViewModel
import androidx.compose.ui.unit.sp

@Composable
fun ProductScreen(
    viewModel: ProductViewModel = viewModel()
) {

    val products by viewModel.products.collectAsState()

    LazyColumn {

        item {
            Text(
                text = "Fake Store Products",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(
                    top = 48.dp,
                    start = 16.dp,
                    bottom = 16.dp
                )
            )
        }

        items(products) { product ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(12.dp)
                ) {

                    AsyncImage(
                        model = product.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "ID : ${product.id}",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = product.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text(
                        text = "Price : ₹${product.price}",
                        fontSize = 16.sp
                    )

                    Text(
                        text = "Category : ${product.category}"
                    )

                    Text(
                        text = "Rating : ⭐ ${product.rating.rate}"
                    )

                    Text(
                        text = "Reviews : ${product.rating.count}"
                    )
                }
            }
        }
    }
}

