package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //hello : persistence.xml에서 지정한 이름
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member = new Member(1L, "Jeong");
            em.persist(member);
        } catch (Exception e) {
            tx.rollback();
        } finally {
            //내부적으로 DB 커넥션을 가지고 동작하기 때문에 꼭 닫아줘야한다.
            em.close();
        }

        emf.close();
    }
}
