package `001 가변성을 제한하라`

/**
 * 가변성 제한하기
 * - 읽기전용 프로퍼티 val
 * - 가변 컬렉션과 읽기 전용 컬렉션 구분하기
 * - 데이터 클래스의 copy
 */

// 읽기 전용 프로퍼티는 다른 프로퍼티를 활용하는 사용자 정의 게터로도 정의 할 수 있다.
// var 프로퍼티를 사용하는 val 프로퍼티는 var 프로퍼티가 변할 때 변할 수 있다.
var name: String = "Marcin"
var surname: String = "Moskala"
val fullName get() = "$name $surname"

// 값을 추출할 때마다 사용자 저으이 게터가 호출되므로 이러한 코드를 사용 할 수 있다.
fun calculate(): Int{
    print("calculate...")
    return 42
}
// 코틀린 프로퍼티는 기본적으로 캡슐화되어 있고, 추가적으로 사용자 정의 접근자 (게터, 세터)를 가질 수 잇다.
// var은 게터와 세터를 모두 제공하지만, val은 변경이 불가능하므로 게터만 제공
val fizz = calculate()
val buzz
    get() = calculate()

// val을 var로 오버라이드할 수 있다.
// 읽기 전용 프로퍼티 val의 값은 변경될 수 있지만, 프로퍼티 래퍼런스 자체를 변경할 수 없으므로 동기화 문제 등을 줄일 수 있다.
// 일반적으로 var 보다 val을 많이 사용함
interface Element{
    val active: Boolean
}
class ActualElement: Element {
    override val active: Boolean = false
}


// 게터 또는 델리게이트로 정의 할 수 있다.
// 완전히 변경할 필요가 없다면, final 프로퍼티를 사용 하는 것이 좋다.
// val은 정의 옆에 상태가 바로 적히므로, 코드의 실행을 에측하는 것이 훨씬 간단함, 스마트 캐스트등의 추가적인 긴능을 활용할 수 있다.
val name1: String? = "Marton"
val surname1: String? = "Braun"

val fullName1: String?
    get() = name1?.let { "$it $surname1" }
val fullName2: String? = name1?.let { "$it $surname1" }

fun main(){
    // 읽기 전용 프로퍼티 val
    val a = 10
    // a = 20 오류

    // 읽기 전용 프로퍼티가 완전히 변경 불가능한 것은 아니다.
    // 읽기 전용 프로퍼티가 mutable 객체를 담고 있다면, 내부적으로 변할 수 있다.
    val list = mutableListOf(1,2,3)
    list.add(4)
    println(list)   //[1, 2, 3, 4]

    println(fullName)   //Marcin Moskala
    name = "Maja"
    println(fullName)   //Maja Moskala

    println(fizz)
    println(fizz)
    println(buzz)
    println(buzz)

    // fullName1은 게터로 정의했으므로 스마트 캐스트 할 수 없음
    // 값을 사용하는 시점의 name1에 따라서 다른 결과가 나올 수 있기 때문
    if(fullName1 != null){
        // println(fullName1.length) //오류
    }

    // fullName2 처럼 지역변수가 아닌 프로퍼티가 final이고, 게터를 갖지 않을 경우 스마트 캐스트할 수 있다.
    if(fullName2 != null){
        println(fullName2.length)
    }
}
