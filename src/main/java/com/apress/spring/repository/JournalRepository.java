//package com.apress.spring.repository;
//
//import com.apress.spring.domain.JournalEntry;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.util.Date;
//import java.util.List;
//
//public interface JournalRepository extends JpaRepository<JournalEntry, Long> {
//    List<JournalEntry> findByCreatedAfter(@Param("after") @DateTimeFormat(iso =
//            DateTimeFormat.ISO.DATE) Date date);
//
//    List<JournalEntry> findByCreatedBetween(@Param("after") @DateTimeFormat(iso =
//            DateTimeFormat.ISO.DATE) Date after, @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);
//
//    List<JournalEntry> findByTitleContaining(@Param("word") String word);
//
//    List<JournalEntry> findBySummaryContaining(@Param("word") String word);
//}