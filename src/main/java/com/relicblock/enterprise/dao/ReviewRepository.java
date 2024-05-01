public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByBookId(@RequestParam("book_id") Long bookId,
                              Pageable pageable);

    Review findByUserEmailAndBookId(String userEmail, Long bookId);
}