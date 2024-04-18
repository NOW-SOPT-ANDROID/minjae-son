package com.sopt.now

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val mockFriendList = listOf<Friend>(
        Friend(
            profileImage = R.drawable.michaeljordan_profile,
            name = "Michael jordan",
            place = "USA, Chicago",
            selfDescription = "I'm the GOAT",
        ),
        Friend(
            profileImage = R.drawable.stephcurry_profile,
            name = "Steph Curry",
            place = "USA, San Francisco",
            selfDescription = "I can shoot with ma eyes closed",
        ),
        Friend(
            profileImage = R.drawable.nikolajokic_profile,
            name = "Nikola Jokic",
            place = "USA, Denver",
            selfDescription = "Basketball? It's EEEEEasy",
        ),
        Friend(
            profileImage = R.drawable.lukadoncic_profile,
            name = "Luka Doncic",
            place = "USA, Dallas",
            selfDescription = "Love you, Kyle"
        ),
        Friend(
            profileImage = R.drawable.lebronjames_profile,
            name = "Lebron James",
            place = "USA, Los Angeles",
            selfDescription = "I'm the real GOAT"
        ),
        Friend(
            profileImage = R.drawable.kevindurant_profile,
            name = "Kevin Durant",
            place = "USA, Phoenix",
            selfDescription = "2 CHAMPS, 2 MVP. That's it"
        ),
        Friend(
            profileImage = R.drawable.jimmybutler_profile,
            name = "Jimmy Butler",
            place = "USA, Miami",
            selfDescription = "I NEED RINGS"
        ),
        Friend(
            profileImage = R.drawable.dirknowitzki_profile,
            name = "Dirk Nowitzki",
            place = "USA, Dallas",
            selfDescription = "Have you heard about German Wunderkind?"
        ),
        Friend(
            profileImage = R.drawable.demianlillard_profile,
            name = "Demian Lillard",
            place = "USA, Portland",
            selfDescription = "It's DAME TIME."
        ),
        Friend(
            profileImage = R.drawable.charlesbarkley_profile,
            name = "Charles Barkley",
            place = "USA, Philadelphia",
            selfDescription = "CHUCK CHUCK"
        )
    )
}