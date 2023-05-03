package com.antsrl.formazione.jpademo;

import com.antsrl.formazione.jpademo.domain.Book;
import com.antsrl.formazione.jpademo.domain.Category;
import com.antsrl.formazione.jpademo.domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {

        try (EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("simple_jpa_demo");
             EntityManager entityManager = entityManagerFactory.createEntityManager()) {

            try{

                entityManager.getTransaction().begin();

                doPersistenceStuff(entityManager);

                entityManager.getTransaction().commit();

            } catch(Exception e){

                entityManager.getTransaction().rollback();

                e.printStackTrace();
            }

        } catch (Exception e){

            e.printStackTrace();
        }

    }

    private static void doPersistenceStuff(EntityManager entityManager) {

        entityManager.persist(
                Book.builder()
                        .title("bel libro")
                        .anything("ciao1")
                        .publishingDate(
                                LocalDateTime.of(2023, 3, 23, 13, 13))
                        .category(Category.ESSAY)
                .build());

        entityManager.persist(
                Book.builder()
                        .title("libro fantastico")
                        .anything("ciao2")
                        .publishingDate(
                                LocalDateTime.of(2020, 10, 12, 10, 9))
                        .category(Category.HORROR)
                        .build());

        entityManager.persist(
                Book.builder()
                        .title("bel libro 2")
                        .anything("ciao3")
                        .publishingDate(
                                LocalDateTime.of(1970, 9, 21, 8, 8))
                        .category(Category.ROMANCE)
                        .build());


        Book mioLibroBello = Book.builder()
                .title("mio libro bello")
                .anything("ciao4")
                .publishingDate(
                        LocalDateTime.of(1970, 9, 21, 8, 8))
                .category(Category.ROMANCE)
                .build();



        entityManager.persist(mioLibroBello);

        Book book = entityManager.find(Book.class, 3L);
        System.out.format("recuperato libro: %s\n", book.getTitle());

        Review review = new Review();
        review.setContent("il libro è fanstastico! ve lo consiglio vivamente");
        review.setBook(book);

        entityManager.persist(review);




        book = Book.builder()
                .title("libro")
                .anything("any")
                .publishingDate(
                        LocalDateTime.of(1970, 9, 21, 8, 8))
                .category(Category.ROMANCE)
                .build();

        review.setBook(book);

        entityManager.persist(book);
        entityManager.persist(review);


        entityManager.remove(review);
        entityManager.remove(book);
    }
}
