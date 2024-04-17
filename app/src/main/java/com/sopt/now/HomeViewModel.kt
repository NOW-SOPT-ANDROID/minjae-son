package com.sopt.now

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    val mockFriendList = listOf<Friend>(
        Friend(
            profileImage = R.drawable.ic_person_black_24,
            name = "이의경",
            selfDescription = "다들 빨리 끝내고 뒤풀이 가고 싶지? ㅎㅎ 아직 반도 안왔어 ^&^",
        ),
        Friend(
            profileImage = R.drawable.ic_person_black_24,
            name = "우상욱",
            selfDescription = "나보다 안드 잘하는 사람 있으면 나와봐",
        ),
        Friend(
            profileImage = R.drawable.ic_person_black_24,
            name = "배지현",
            selfDescription = "표정 풀자 ^^",
        ),
    )
}