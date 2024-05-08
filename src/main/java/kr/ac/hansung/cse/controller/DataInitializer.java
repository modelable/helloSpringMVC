package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.dao.OfferDao;
import kr.ac.hansung.cse.model.Offer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Spring Container에 Bean으로 등록
public class DataInitializer implements InitializingBean {

    @Autowired
    private OfferDao offerDao;

    /*
    DataInitializer 빈이 생성되고
    빈에 대한 속성(Properties, 여기서는 OfferDao)이 다 설정된 이후 호출되는 메소드이다.
    테이블이 생성되면(hbm2ddl.auto = create) 데이터베이스 테이블을 초기화하는 역할을 한다.
    */
    /*
    InitializingBean 인터페이스를 구현한 클래스는 스프링 컨테이너에서 빈으로 생성될 때,
    빈의 생명주기(lifecycle)에 따라 초기화(initialization) 메서드를 실행합니다.
    이 때문에 InitializingBean 인터페이스를 구현한 클래스의 객체는 빈이 생성될 때
    afterPropertiesSet() 메서드가 호출되어 초기화가 진행됩니다.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        Offer offer1 = new Offer("Alice", "alice@hansung.ac.kr", "스프링이 참 재미있네요");
        Offer offer2 = new Offer("Bob", "bob@hansung.ac.kr", "JPA/Hibernate는 참 편리하네요");
        Offer offer3 = new Offer("Charlie", "charlie@hansung.ac.kr", "Rest API를 구현합니다.");

        offerDao.insert(offer1);
        offerDao.insert(offer2);
        offerDao.insert(offer3);
    }
}
