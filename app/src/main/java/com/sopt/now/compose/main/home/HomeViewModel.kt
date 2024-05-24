package com.sopt.now.compose.main.home

import com.sopt.now.compose.R

// 서버 통신 로직으로 대체

val myProfile = Profiles.MyProfile(
    profileImage = R.drawable.sonminjae_profile,
    name = "Son Minjae",
    place = "Korea, Seoul",
    selfDescription = "I can do it",
    enable = true
)

val friendProfileList = listOf(
    Profiles.FriendProfile(
        profileImage = R.drawable.michaeljordan_profile,
        name = "Michael jordan",
        place = "USA, Chicago",
        selfDescription = "I'm the GOAT",
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.stephcurry_profile,
        name = "Steph Curry",
        place = "USA, San Francisco",
        selfDescription = "I can shoot with ma eyes closed",
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.nikolajokic_profile,
        name = "Nikola Jokic",
        place = "USA, Denver",
        selfDescription = "Basketball? It's EEEEEasy",
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.lukadoncic_profile,
        name = "Luka Doncic",
        place = "USA, Dallas",
        selfDescription = "Love you, Kyle"
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.lebronjames_profile,
        name = "Lebron James",
        place = "USA, Los Angeles",
        selfDescription = "I'm the real GOAT"
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.kevindurant_profile,
        name = "Kevin Durant",
        place = "USA, Phoenix",
        selfDescription = "2 CHAMPS, 2 MVP. That's it"
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.jimmybutler_profile,
        name = "Jimmy Butler",
        place = "USA, Miami",
        selfDescription = "I NEED RINGS"
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.dirknowitzki_profile,
        name = "Dirk Nowitzki",
        place = "USA, Dallas",
        selfDescription = "Have you heard about German Wunderkind?"
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.demianlillard_profile,
        name = "Demian Lillard",
        place = "USA, Portland",
        selfDescription = "It's DAME TIME."
    ),
    Profiles.FriendProfile(
        profileImage = R.drawable.charlesbarkley_profile,
        name = "Charles Barkley",
        place = "USA, Philadelphia",
        selfDescription = "CHUCK CHUCK"
    )
)
