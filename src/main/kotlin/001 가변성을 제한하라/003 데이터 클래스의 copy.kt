package `001 가변성을 제한하라`

import java.util.*

// immutable 객체의 장점
// 1. 한 번 정의된 상태가 유지되므로, 코드를 이해하기 쉽다.
// 2. immutable 객체는 공유했을 때도 출돌이 따러 이루어 지지 않으므로, 병렬처리를 안전하게 할 수 있다.
// 3. immutable 객체에 대한 참조는 변경되지 않으므로, 쉽게 캐시할 수 있다.
// 4. immutable 객체는 방어적 복사본을 만들 필요가 없다.
// 5. 다른 객체 (mutable, immutable)를 만들 때 활용하기 좋다, 실행을 더 쉽게 예측 할 수 있다.
// 6. 세트 또는 맵의 키로 사용 할 수 있다. (mutable 객체는 사용 할 수 없음)


fun main() {

    /*val names: SortedSet<FullName> = TreeSet()
    val person = FullName("AAA","AAA")

    names.add(person)
    names.add(FullName("Jordan","Hansen"))
    names.add(FullName("David","Blanc"))

    println(names)
    print(person in names)

    //person.name = "ZZZ"
    print(names)
    print(person in names)*/

    var user = User("Maja", "Markiewicz")
    user = user.withSurname("Moskala")
    print(user)
}

class FullName(val name: String,
               val surname: String) {
}

class User(
    private val name: String,
    val surname: String
){
    fun withSurname (surname: String) = User(name, surname)
}

