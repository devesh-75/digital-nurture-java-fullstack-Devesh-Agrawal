package com.cognizant.ormlearn.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // all stock rows for a code within a date range, e.g. FB in September 2019
    List<Stock> findByCodeAndDateBetweenOrderByDateAsc(String code, LocalDate start, LocalDate end);

    // rows for a code whose closing price was greater than the given value
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

    // top 3 dates with the highest volume, across all stocks
    List<Stock> findTop3ByOrderByVolumeDesc();

    // top 3 lowest-closing-price dates for a given stock code
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
