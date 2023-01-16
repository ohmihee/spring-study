1. BasEquipmentResource.java 파일
basEquipmentSeek을 사용할 때 생성자 함수 없이 어떻게 의존성 주입을 할 수 있는 것인가?
-> @RequiredArgsConstructor 어노테이션을 해당 클래스에 사용시 final이 붙은 필드의 경우에 자동으로 생성자를 만들어준다.

2. SaveBasEquipmentListCommand.java 파일
ProjectValidator는 필드 선언과 의존성 주입을 해주지 않았는데 어떻게 사용이 가능한가? 
-> 해당 클래스에서 사용하는 함수가 static으로 선언되었기 때문이다.

3. String... 은 무엇인가?
[타입]... 해당 변수가 몇 개로 오는지 모르는 경우에 사용된다. 즉 String...은 해당 매개변수를 1개로 받을 수 도 있고, 2개 이상으로 받을 수 도 있음을 의미한다. 

기본 개념 ===========================================================
static을 사용한 메서드는 사용하려는 클래스에서 필드를 선언하고, 생성자를 통해 의존성을 주입해주지 않아도 된다.
해당 클래스명 자체를 통해 접근할 수 있다. static으로 선언한 함수는 프로그램 전체에서 공유된다. 
단 static으로 선언한 메서드는 new를 통해 생성한 인스턴스를 통해서는 접근할 수 없다.

**** 메모리 공간 (heap, static, stack) ****
자바에\는 heap, static, stack 세 종류의 메모리 구조로 되어있다.

[ heap 메모리 공간 ]
참조형(Referencd Type)의 데이터 타입으로 선언한 변수는 Heap 메모리 공간에 할당된다. heap메모리에 저장된 값의 참조값은 stack 메모리에 저장된다.
예를 들어 new를 통해 생성한 객체의 경우 heap 메모리에 할당되고, 해당 객체를 할당한 변수에는 heap 메모리의 참조값이 저장되는 것이다.
ex) Test test = new Test();
    heap 영역에 할당되는 new를 통해 생성한 Test()객체의 참조값(주소값)  실제 객체가 할당되는 heap 영역.
heap 영역의 메모리는 가비지 컬렉터를 통해(Garbage Collector)를 통해 관리되어 참조되지 않는 경우에는 해당 공간에 할당된 메모리가 해제된다. 

[ static 메모리 공간 ]
전역 변수와 static이 붙은 변수의 경우 static 메모리에 할당되어 프로그램의 시작부터 종료까지 메모리에 유지되며, 프로그램이 종료되는 때에 메모리에서 해제된다.
Application을 실행하는 main함수에 static이 붙는 이유는 위와 같다.
static 메모리가 차지하는 공간은 프로그램 로드시에 결정되며, 프로그램 컴파일 시간에 많은 영향을 주는 것이 static 메모리이다.
static 메모리에 할당된 것은 프로그램 전체에서 공유된다. 

[ stack 메모리 공간 ]
지역 변수(스코프 내에 선언된 변수라고 할 수 있다.)와 일반 메서드가 저장되는 공간이다.
지역 변수에 값을 할당 시, stack 메모리 공간에 실질적으로 할당되는 것은 heap 메모리 공간에 저장된 값의 참조값(=주소값)이다.
메서드가 호출될 때 메모리에 할당되고, 종료되면 메모리가 해제된다.
stack 영역은 LIFO(Last In First Out)구조이다. 


**** ThreadLocal ****
ThreadLocal 타입의 static으로 선언된 필드를 갖는 클래스를 생성한다.

[ 사용법 ]
public class TestContext {
	public static ThreadLocal<TestType> testThreadLocal = new ThreadLocal<TestType>();

	public static void setTest(TestType test) {
		testThreadLocal.set(test);
	}
	
	public static void getTest() {
		testThreadLocal.get();
	}

	public static void remove() {
		testThreadLocal.remove();
	}
}
 


어노테이션 =========================================================================
@bean

@Document
어노테이션 정보가 javadoc으로 작성된 문서에 포함되도록 해준다.
 - toDomain

@Value()
property 값을 읽을 수 있다. (application.properties 또는 application.yml 파일에 설정해 둔 내용을 읽을 수 있다.)
@Value로 가져온 값은 변수에 할당하여 사용할 수 있다.
ex)
@Value("${spring.database.source.url}")
private String dbUrl;

@JsonInclude()
- @JsonInclude(JsonInclude.Include.NON_NULL) :  null인 데이터를 제외하고 json 데이터를 생성하여 준다.
- @JsonInclude(JsonInclude.Include.Always) : 기본값으로 모든 데이터를 json데이터로 변환하여 준다.
- @JsonInclude(JsonInclude.Include.NON_EMPTY) : null 제외, map의 isEmpty가 true이면 제외, 배열이 비어있으면 제외, 빈 문자열 ""이면 제외
- @JsonPeroperty : key를 매핑시켜줄 때 사용된다.

@RequiredArgsConstructor
클래스 위에 해당 어노테이션을 붙여줄 경우에, 클래스 내에서 생성자 함수나, @Autowired 등을 사용하여 별도로 의존성 주입을 해주지 않아도 된다.

Assert =================================================================
.hasText([검증할필드명], "[해당 필드가 text를 가지고 있지 않을 경우 표시할 메시지]")
.notEmpty([검증할 필드], "[검증할 필드가 빈 값일 경우 표시할 메시지]")


함수 ==================================================================
BeanUtils.copyProperties(Object [원본객체], [복사할 객체])
JsonUtil.fromJson(json, 클래스명.class ) : json형식을 자바 객체로 만들어 준다.
String.format("%s, %s",error1, error2) : 문자열에 인자로 준 변수를 차례대로 넣어 새로운 문자열로 생성하여 준다. 에러 메시지 등을 만들 때 유용하다.

에러 ==================================================================
throw new NoSuchElementException("error message when no exist item");
throw new IllegalStateException("error message when incorrect type")
logic - store구현체 - mongoRepository 상속받은 인터페이스

기타 개념 ===============================================================
타입 비교?
(원본값).equals(비교값)
unix time?
System.currentTimeMillis();



custom annotaion
java reflaction


[application/vnd.ms-excel]
Excel 파일의 Content-Type이다.
질문?




Q) static / final / static final   https://gobae.tistory.com/3
- static으로 선언한 필드나 메서드는 this를 사용하지 않고, 해당 필드명 자체로 접근한다.
- final은 더 이상의 값 변경이 없는 경우에 사용된다. 즉 final을 사용하여 선언된 필드는 수정이 불가능하다.
final 필드의 경우, 선언과 동시에 값을 할당하여 줄 수 도 있고, 객체 생성시 생성자 함수를 통해 값을 할당하여 줄 수 있다.
- static final의 경우 상수 선언 시 사용되어, 즉 static final로 선언된 필드의 경우 프로그램 전역에서 고정된 값으로 사용됨을 의미한다.


@Getter @Setter가 클래스 위에 준 상태에서 getter함수 setter함수를 생성하면 어떤 함수가 실행되는가




커스튬 어노테이션 생성
1. 인터페이스 앞에 @를 붙여서 생성한다.
ex) public @interface CustomAnnoncation { }



리엑트 라이프 사이클 (= 생명주기)
컴포넌트가 생성, 업데이트, 소멸되는 주기.
| mount : 컴포넌트가 브라우저에 나타날 때  
- constructor() ~ state 초기 설정 등을 한다.
- getDrivedStatefromPropes
- componentDidMount : 차트 라이브러리 등을 사용할 때 특정 돔에 특정 크림을 그려주세요, ajax 처리 등을 한다. 또한 컴포넌트 생성 후 몇 초뒤에 다른 작업을 하도록 하게 하고 싶을 때 사용된다.

렌더 함수가 호출되는데 실제 돔상에서는 바뀌지제

- updating : 
- suouldPropsComponet : 
- suouldComponentUpdate : props나 state에 따라 렌더링 할 지 말지 여부를 결정할 수 있다.
- getSnapshapBeforeUpdate: 렌더링 후 업데이트 전에 스크린 위치, 돔의 크기 등을 가져오고 싶을 때 사용.
- componentDidUpdate

- unMount
- unMount




[서블릿]

기본적으로 서블릿은 javax.servlet.http.HttpServlet을 상속한다.
MyServlet extends HttpServletservice() -> javax.servlet.http.HttpServlet -> javax.servlet.GenericServlet


[스프링부트]

스프링부트는 웹서버를 손쉽게 구축할 수 있도록 여러 편리한 기능을 제공해주는 프레임워크이다.

* application.properties 또는 application.yml 파일은 데이터베이스 설정 등 프로젝트 환경 관련 설정을 담당하는 파일이다. 

* build.gradle : gradle은 Groovy를 기반으로 한 빌드 도구로써, build.gradle은 라이브러리 파일 등 빌드 관련 설정을 해주는 파일이다.
- runtimeOnly
- compileOnly

@Controller
@ResponseBody 해당 경로에 요청시 String형태로 결과값을 반환할 수 있도록 해주는 어노테이션이다. 
해당 어노테이션 없이 문자열을 반환하는 경우, 해당 문자여로가 일치하는 파일명의 템플릿 파일을 찾아 반환하는데, 해당 문자열과 동일한 이름의 템플릿 파일이 존재하지 않는 경우 에러를 발생시킨다.

@Autowired : final 필드에 해당 어노테이션을 사용할 경우 스프링이 자동으로 의존성 주입을 해준다.
@RequiredArgsConstrucotr : 해당 어노테이션은 final이 붙은 속성에 대해 자동으로 생성자를 만들어주는 기능을 한다.

@Service : 해당 클래스가 서비스 클래스임을 알리는 어노테이션이다.

@Configuration: 해당 파일이 스프링의 환경설정 파일임을 알리는 어노테이션이다.

@EableWebSecurity: 

ex)
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecrity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers(
			new AntPathRequestMatcher("/**")).permitAll()
			;
		return http.build();
	}
}


*Entity : 프로젝트에서 데이터베이스에 접근 시 테이블과 매핑을 위해 사용되는 자바 클래스 파일이다. entity 클래스의 경우에는 @Setter어노테이션을 설정해주기보다는 @Builder를 사용할 것이 권장된다.


*JPA: Java Persistence API 는 자바에서 데이터베이스로의 접근을 편리하게 도와주는 인터페이스 모음이다. ~Hibernate(하이버네이트)는 JPA를 구현한 대표적인 실제 클래스이다.
* h2 데이터베이스는 파일 기반의 경량 데이터베이스이다.
- repository는 데이터베이스 접속시 이용되는 메서드들의 정의한 인터페이스 파일이다.

Q) 서비스를 별도로 구분하여 두는 이유?
반복적으로 사용되는 기능에 대하여 컨트롤러가 아닌 별도의 서비스 파일을 생성하여 로직을 작성히고 모듈화하여 관리함으로써, 컨트롤러에서는 해당 서비스를 호출하여 사용함으로써 중복적인 코드가 작성되는 것을 방지하여 준다.
또한 보안적인 측면에서도 컨트롤러에서 데이터베이스에 직접 접근하도록 하는 것보다 서비스를 통해 접근하는 것이 더욱 안전한다.

* 웹사이트 공격방법
- SQL injection
- XSS(cross-site-scripting)
- CSRF(cross-site-request forgery)
: 웹 사이트 취약점 공격을 방지하기 위해 사용되는 기술이다. 
- 클릭재킹(clickjacking) 


[ 자바스크립트 ]
* 이벤트 버블링 막기
e.stopPropagation(); 부모 자식 엘리먼트로 이벤트가 전파되는 것을 막아준다.
e.preventDefault();
e.defaultPrevented();

  
  나라 관련 =============================================
resource에서 사용할 수 있는 것은 logic, seek, task, action
dao와 service는 인터페이스와 구현체인 클래스 파일로 구성된다.

- aggregate - nara studio - create aggregate entity creation -> 속성 정의(속성이 변경이 가능한 경우에는 Updatable 설정)
-> All Backend codes -> create All front codes



폴더 구조 ===================================
front -------------------------------------------------------------------
comp
L api 
	L aggregate
		L [각 폴더명]
			L api-model (나라스튜디오로 생성)
				L sdo : 서비스 데이터 객체 관련 파일들.
					- []Cdo.ts -> 생성 등
					- []Rdo.ts -> 조회 시 
					- []Udo.ts -> 업데이트 시
				L vo(value object) : enum 등 타입 객체
				- [].ts : entity 영역
			L command (나라스튜디오로 생성) : 등록이나 수정 등의 경우에 Command로 사용
				L command
					- []Command.ts : api 보낼 때 command 파일 생성
				L rest
					- []ApiStub.ts : 실질적인 api 작업과 관련된 파일
			L query (나라스튜디오로 생성) : 조회의 경우에 Query로 사용
				L query : 조회 api 요청 시 함께 보내는 Query 관련 파일
					- []DynamicQuery.ts :  단건 조회 
					- []sDynamicQuery.ts: 다건 조회
					- []Query.ts :  id로 조회하는 경우
				L rest
					- []QueryApiStub.ts :  실질적인 api 관련 작업 파일
	L feataure : aggregate와 구조 같고, 나라스튜디오로 자동 생성된 부분이 아니라 직접 코드 짜는 경우 사용하는 폴더
L envoy : 거의 사용되지 않음
L state : 
L view

흐름
container -> stateKeeper -> apiStub (command/query)
.by로 new 생성해서 보내는 이유, 백에서 get으로 꺼내기 위해.

back -------------------------------------------------------------------
L aggregate 
: 기본 crud / aggreagte로직은 프론트에서 직접적으로 호출x, feature를 통해서 이루어져야 한다. 프론트에서 필요한 정보는 facade/feature를 통해 이루어져야 한다.
: 도메인 객체와 객체의 변화 관련 로직이 위치, 서비스를 발생하고 엔티티를 저장, 도메인 엔티티를 위한 crud 로직을 담고 있는 모듈이다.

	L [폴더명]
		L domain
			L entity
			L logic
		L store
			L mongo
				L odm : 기본 속성 정의한 Doc 파일들 (mongorepository 연결시 사용)
				L repository : repository 실질적인 구현체 파일들
				- repository 인터페이스 파일들
L boot : main() 시작 부분 및, resource관련 application.yml파일 설정
L exception : 에러 관련 패키지
L facade : feature의 로직을 활용하여 rest api 구현
	L api : 
		L aggregate :
			L command : 
				L command
				L rest 
					- facade : Resource의 인터페이스
					- resource: facade의 실질적인 구현체 파일
			L query : 
				L query
				L rest
					-
		L feateure : 주로 로직을 담고 있으며, flow -> action -> task -> customStore 순서가 된다.
			L action
			L domain.entity
				L sdo : rdo(프론트에 전달할 객체 파일들)
				L vo
			L flow
				- seek : read 
				- flow : cud
			L task
			L customStore
	L event : 외부 공유용 도메인 이벤트 모듈
L feature : 비즈니스 로직 구현
L proxy



흐름
messagesubscriber가 메세지 수신하면 그 메세지를 처리하는 feature의 flow 로직으로 전달 -> aggregate

절차 ============================================================
- 도메인 모델 스케치 
- 엔티티 / vo / cdo 작성
- 도메인 모델 리뷰
- ( 나라스튜디오 사용해서 ) 코드 자동 생성
- api 기능, 목표 작성
- flow와 api 작성 : flow는 cud 관련
- seek과 api 작성 : seek은 read 관련
- 도메인 이벤트 작성
- rest api test










일반 개념 관련 =========================================
자바 타입 소문자 대문자 차이?
기본형 문자 타입은 소문자로 시작, 참조형 문자 타입은 클래스로써 대문자로 시작
소문자 타입은 해당 값 반드시 필수, 대문자 타입은 null가능



윈도우 명령어 (help [명령어])
- cd : 위치 변경 
- dir 하위 파일 목록 보여줌
- ipconfig 네트워크 설정상태 보기 / inconfig -all
- mkdir / md : 폴더 생성
- rd / rmdir : 폴더 삭제
- path : 환경변수 설정 보여줌
- cls :  현재 명령 프롬프트 창 초기화
- del : 파일 삭제
- copy [복사할 파일명] [복사할 경로]
- xcopy [복사할 파일명] [복사할 경로]  copy와의 차이점을 xcopy는 숨김파일도 복사 가능
- move [파일명] [이동할 위치 경로]
- rename [현재파일명] [변경후파일명]
- date : 현재 날짜 보여줌 
- tasklist : 현재 실행중인 프로세스를 모두 보여준다.
- exit : 현재 명령 프롬프트 창 종료
- echo %cd% : 현재 경로 보여줌


.tgz 압축풀기
tar -zxvf [압축풀기하는파일명] -C [압축풀려는위치]

kafka ==================================

zookeeper 실행 ----------------------------
C:\tool\kafka_2.13-3.2.0\bin\windows\zookeeper-server-start.bat C:\tool\kafka_2.13-3.2.0\config\zookeeper.properties
[경로]bin/windows/zookeeper-server-start.bat [경로]config/zookeeper.properties
- 2181 port


kafka 실행------------------------------
C:\tool\kafka_2.13-3.2.0\bin\windows\kafka-server-start.bat C:\tool\kafka_2.13-3.2.0\config\server.properties
[경로]bin/windows/kafka-server-start.bat [경로]/config/server.properties
- 9092 port

1) topic topic 생성
> [ 경로 ] / kafka_2.13.7-2.7.0/bin/windows에서
// 토픽 생성 ------------------------------------------------------------
kafka-topics.bat --create --bootstrap-server localhost:9092 --topic oing
kafka-topics.bat --create --bootstrap-server localhost:9092 --topic [생성할토픽명]

// 토픽 메세지 보내기 -----------------------------------------------------------
kafka-console-producer.bat --broker-list localhost:9092 --topic oing
kafka-console-producer.bat --broker-list localhost:9092 --topic [어떤토픽에서메세지보낼지해당토픽명]

// 토픽 구독 ------------------------------------------------------------
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic oing --from-beginning
kafka-console-consumer.bat --bootstarp-server localhost:9092 --topic [구독할 토픽명] --fron-beginning

// 토픽 정보 ---------------------------------------------------------
kafka-topics.bat --list --bootstrap-server localhost:9092
kafka-topics.bat --list --bootatrap-server localhost:[port]

// 토픽삭제 ------------------------------------------------------------
kafka-topics.bat --delete-topic ingdaddy --bootstrap-server localhost:9092


프로그램 설치 경로 관련 ===========================================

인텔리제이 경로-------------
C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.2.3

삼성 net-------------------------
http://kr3.samsung.net/portal/desktop/main.do

kafka--------------------------
kafka 경로 : C:\tool\kafka_2.13-3.2.0\bin\windows
kafka 설명 : https://ifuwanna.tistory.com/487?category=931933
kafka log-dirs 위치 : C:\tool\kafka_2.13-3.2.0\config






자바 ==============================================

[ init.gradle ] 
빌드시에 가장 먼저 실행되는 파일, 프로젝트 실행 환경 설정과, 사용자 정보의 내용을 담고 있다.
[ settings.gradle ] 
빌드 대상 프로젝트를 설정하는 파일이다. 예를 들어 한 폴더에 여러개의 프로젝트가 존재하는 경우에 실제 빌드의 
대상이 될 프로젝트를 설정하여 주는 파일이다.
[ gradle.properties ] 
proxy나 데이터베이스 환경 설정 등의 내용을 담고 있는 파일이다.
[ build.gradle ]
프로젝트 의존 관계 등, 해당 파일 만으로도 build가 가능한다.
해당 파일은 plugins, dependencies, repositories 등에 대한 정보를 담고 있다.


.classpath 파일-----------------------------------------------------
https://effectivesquid.tistory.com/entry/자바-클래스패스classpath란
클래스를 찾기 위한 경로를 설정해두는 파일이다. 즉 JVM이 프로그램을 실행할 때
클래스파일을 찾는데 기준이 되는 파일 경로를 의미한다. :를 기준으로 나뉘게 된다.
클래스경로는 프로젝트에서 자바 빌더가 고려한 자바 소스 파일 및 자원 파일을 지정하고, 프로젝트 외부에서 유형을 찾는 방법을 지정한다.

* classpath는 환경변수를 통한 방법과, java runtime에 -classpath 플래그를 사용하는
두 가지 방법이 존재한다.

* classpath 로 지정 가능한 목록
- /export/home/username/java/classes와 같은 디렉토리
- myclasses.zip과 같은 zip 파일
- myclasses.jar와 같은 jar(자바 아카이브)파일

https://jjjwodls.github.io/etc/2020/01/07/01-Kafka-Setup.html
https://bada744.tistory.com/59




프로젝트 관련 질문
[ColumnProcessRevisionUnitCdo.java]


- 백엔드
1. intellij의 기능을 사용하여 gradle 프로젝트 생성
2. 각 기능별 모듈 생성
board-api  // 화면과 직접 연동 및 서버 실행 역할
board-core // entity와 데이터베이스 연동 관련 파일 위치한 디렉토리
board-exception // 에러 관련 처리 
board-service // 실질적인 service로직 및 공통 기능 위주의 메서드 제공하는 파일 관리하는 디렉토리
3. setting.gradle 파일 확인
4. 최상위 디렉토리의 build.gradle 파일 내용 변경
build.gradle 설정 관련 기본 내용 공식 문서와 기타 블로그 참고
build.gradle 학습 내용을 바탕으로 해당 파일 내용 적용 및 변경
5. 데이터베이스 mongoRepository 연동 관련 기본 예제 파일 생성
-- 적용 시 에러 나는 부분 별도 정리
// 해당 작업 내용 github에 올라갈 예정이며, 별도로 개념 관련 내용 블로그에 정리

[ uml 관련 개념 학습 및 uml 설계 ] -------------------------------------------------------------
- uml 관련 개념 학습
-- uml이란 무엇인가에 대한 기본 개념 습득
-- uml 유형 학습
-- nextree 공식 블로그에 올라온 uml 관련 글 참고
-- 학습 내용을 바탕으로 최소한의 uml 설계

[ uml 설계를 바탕으로 기본 entity 및 vo 실제 코드 구현]---------------------------------------
- 기존 uml 설계 기반 entity와 vo 코드 구현 
-- 구현 과정에서 uml 설계 수정 작업 가능
- 데이터 베이스 연동
- 테스트용 컨트롤러 파일 생성 후 insomnia 활용하여 데이터 베이스 연동 테스트 





