package com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.model.MBook
import com.example.udemy_androidjetpackcompose_thecomprehensivebootcamp.capstonereaderapp.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ReaderHomeScreen(navController: NavController) {
    Scaffold(
        topBar = { ReaderAppBar(title = "A. Reader", navController = navController) },
        floatingActionButton = {
            FabContent {

            }
        }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeContent(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(
    title: String,
    showProfile: Boolean = true,
    navController: NavController
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (showProfile) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Logo Icon",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .scale(0.6f)
                    )
                }
                Text(
                    text = title,
                    color = Color.Red.copy(alpha = 0.7f),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
                Spacer(modifier = Modifier.width(150.dp))
            }
        },
        actions = {
            IconButton(onClick = {
                FirebaseAuth.getInstance().signOut().run {
                    navController.navigate(ReaderScreens.LoginScreen.name)
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Logout,
                    contentDescription = "Logout",
                    tint = Color.Green.copy(alpha = 0.4f)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = Color.Black,
            navigationIconContentColor = Color.Black,
            scrolledContainerColor = Color.Transparent
        )
    )
}

@Composable
fun HomeContent(navController: NavController) {
    val currentUserName = if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty())
        FirebaseAuth.getInstance().currentUser?.email?.split("@")?.get(0) else "N/A"

    Column(Modifier.padding(2.dp), verticalArrangement = Arrangement.Top) {
        Row(modifier = Modifier.align(alignment = Alignment.Start)) {
            TitleSection(label = "Your reading \n" + "activity right now...")
            Spacer(modifier = Modifier.fillMaxWidth(0.7f))

            Column {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(ReaderScreens.ReaderStatsScreen.name)
                        }
                        .size(45.dp),
                    tint = MaterialTheme.colorScheme.secondaryContainer
                )
                Text(
                    text = currentUserName!!,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )
                Divider()
            }
        }
    }
}

@Composable
fun TitleSection(modifier: Modifier = Modifier, label: String) {
    Surface(modifier = Modifier.padding(start = 5.dp, top = 1.dp)) {
        Column() {
            Text(
                text = label,
                fontSize = 19.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Left
            )
        }
    }
}

@Composable
fun ReadingRightNowArea(books: List<MBook>, navController: NavController) {

}

@Composable
fun FabContent(onTap: (String) -> Unit) {
    FloatingActionButton(
        onClick = { onTap("") },
        shape = RoundedCornerShape(50.dp),
        containerColor = Color(0xff92cbdf)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a Book",
            tint = Color.White
        )
    }
}

@Composable
fun ListCard(book: MBook, onPressDetails: (String) -> Unit) {
    val context = LocalContext.current
    val resources = context.resources
    val displayMetrics = resources.displayMetrics
    val screenWidth = displayMetrics.widthPixels / displayMetrics.density
    val spacing = 10.dp

    Card(
        shape = RoundedCornerShape(29.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .padding(16.dp)
            .height((242.dp))
            .width(202.dp)
            .clickable {
                onPressDetails.invoke(
                    book.title.toString()
                )
            }
    ) {
        Column(
            modifier = Modifier.width(screenWidth.dp - (spacing * 2)),
            horizontalAlignment = Alignment.Start
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = rememberImagePainter(data = ""),
                    contentDescription = null,
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(50.dp))

                Column(
                    modifier = Modifier.padding(top = 25.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Rounded.FavoriteBorder,
                        contentDescription = "Fav Icon",
                        modifier = Modifier.padding(bottom = 1.dp)
                    )
                    BookRating(score = 3.4)
                }
            }
            Text(
                text = "Book Title",
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Authors: All...",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun BookRating(score: Double = 4.5) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(56.dp),
        tonalElevation = 6.dp,
        shadowElevation = 6.dp,
        color = Color.White
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Icon(
                imageVector = Icons.Filled.StarBorder,
                contentDescription = "Start",
                modifier = Modifier.padding(3.dp)
            )
            Text(text = score.toString(), style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun RoundedButton(){

}