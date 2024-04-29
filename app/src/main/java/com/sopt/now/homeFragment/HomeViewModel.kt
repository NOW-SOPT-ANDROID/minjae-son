package com.sopt.now.homeFragment

import androidx.lifecycle.ViewModel
import com.sopt.now.R

class HomeViewModel : ViewModel() {

    val mockMyProfile = HomeViewObject.MyProfile(
        profileImage = R.drawable.sonminjae_profile,
        name = "Son minjae",
        phoneNumber = "Korea, Seoul",
        selfDescription = "i can win",
        enable = true,
    )
    val mockFriendProfileList = listOf(
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.michaeljordan_profile,
            name = "Michael jordan",
            phoneNumber = "USA, Chicago",
            selfDescription = "I'm the GOAT",
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.stephcurry_profile,
            name = "Steph Curry",
            phoneNumber = "USA, San Francisco",
            selfDescription = "I can shoot with ma eyes closed",
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.nikolajokic_profile,
            name = "Nikola Jokic",
            phoneNumber = "USA, Denver",
            selfDescription = "Basketball? It's EEEEEasy",
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.lukadoncic_profile,
            name = "Luka Doncic",
            phoneNumber = "USA, Dallas",
            selfDescription = "Love you, Kyle"
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.lebronjames_profile,
            name = "Lebron James",
            phoneNumber = "USA, Los Angeles",
            selfDescription = "I'm the real GOAT"
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.kevindurant_profile,
            name = "Kevin Durant",
            phoneNumber = "USA, Phoenix",
            selfDescription = "2 CHAMPS, 2 MVP. That's it"
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.jimmybutler_profile,
            name = "Jimmy Butler",
            phoneNumber = "USA, Miami",
            selfDescription = "I NEED RINGS"
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.dirknowitzki_profile,
            name = "Dirk Nowitzki",
            phoneNumber = "USA, Dallas",
            selfDescription = "Have you heard about German Wunderkind?"
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.demianlillard_profile,
            name = "Demian Lillard",
            phoneNumber = "USA, Portland",
            selfDescription = "It's DAME TIME."
        ),
        HomeViewObject.FriendProfile(
            profileImage = R.drawable.charlesbarkley_profile,
            name = "Charles Barkley",
            phoneNumber = "USA, Philadelphia",
            selfDescription = "CHUCK CHUCK"
        )
    )
}
