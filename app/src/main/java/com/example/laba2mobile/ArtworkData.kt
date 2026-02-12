package com.example.laba2mobile

data class Artwork(
    val imageRes: Int,
    val titleRes: Int,
    val descriptionRes: Int,
    val contentDescriptionRes: Int
)

val artworks = listOf(
    Artwork(R.drawable.img1, R.string.title1, R.string.desc1, R.string.talkBack1),
    Artwork(R.drawable.img2, R.string.title2, R.string.desc2, R.string.talkBack2),
    Artwork(R.drawable.img3, R.string.title3, R.string.desc3, R.string.talkBack3),
    Artwork(R.drawable.img4, R.string.title4, R.string.desc4, R.string.talkBack4),
    Artwork(R.drawable.img5, R.string.title5, R.string.desc5, R.string.talkBack5)
)