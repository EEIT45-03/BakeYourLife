package eeit45.group3.bakeyourlife.order.service;

import eeit45.group3.bakeyourlife.order.dao.SalesRecordRepository;
import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SalesRecordServiceImpl implements SalesRecordService{

    private SalesRecordRepository salesRecordRepository;

    @Autowired
    public SalesRecordServiceImpl(SalesRecordRepository salesRecordRepository) {
        this.salesRecordRepository = salesRecordRepository;
    }

    @Override
    @Transactional
    public void createSalesRecord(SalesRecord salesRecord) {
        salesRecordRepository.save(salesRecord);
    }
}
