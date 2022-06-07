package `001 가변성을 제한하라`

// 읽기 전용 - Iterable, Collection, Set, List
// 읽기, 쓰기 가능 - MutableIterable, MutableCollection, MutableSet, MutableList

// 리스트를 읽기 전용으로 리턴하면 읽기 전용으로만 사용해야한다.
// 컬렉션 다운캐스팅은 이러한 계약을 위반하고, 추상화를 무시하는 행위
// 안전하지 않고, 예측하지 못한 결과를 초래함
fun main() {
    val list = listOf(0, 1, 2)
    // 읽기 전용 컬렉션을 mutable 컬렉션으로 다운캐스팅 하면 안됨
    /*if(list is MutableList){
        list.add(4)
    }*/

    // 읽기 전용에서 mutable로 변경해야 한다면, 복제를 통해 새로운 mutable 컬렉션을 만드는 list.toMutableList()를 활용해야함
    val mutableList = list.toMutableList()
    mutableList.add(4)
}

