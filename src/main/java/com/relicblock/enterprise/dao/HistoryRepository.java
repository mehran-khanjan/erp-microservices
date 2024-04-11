package com.relicblock.enterprise.dao;

public class HistoryRepository extends JpaRepository<History, Long>{
    Page<History> findBooksByUserEmail(@RequestParam("email") String userEmail, Pageable pageable);
}
