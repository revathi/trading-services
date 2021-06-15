package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.Ipo;
import net.springboot.ipotrading.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class IpoServiceImpl implements IpoService {

    @Autowired
    private IpoRepository ipoRepository;

    @Override
    public void save(Ipo ipo) {
        double result=generateDoubleForIssuePrice();
        ipo.setIssuePrice(result);
        long issueSize=generatingRandomLongForIssueSize();
        ipo.setIssueSize(issueSize);
        long lotSize=generatingRandomLongForLotSize();
        ipo.setLotSize(lotSize);
        LocalDate issueDate=createRandomIssueDate(2021,2021);
        ipo.setIssueDate(issueDate);
        LocalDate closingDate=issueDate.plusDays(20);
        String des=ipo.getCompanyName().concat(" issues shares as on ").concat(issueDate.toString());
        ipo.setDescription(des);
        ipo.setClosingDate(closingDate);
        ipoRepository.save(ipo);
    }
    public List<Ipo> findAll() {
        return ipoRepository.findAll();
    }

    @Override
    public List<Ipo> findIpoByUserName(String userName) {
        return ipoRepository.findIpoByUserName(userName);
    }
    public  long generatingRandomLongForIssueSize() {
        long leftLimit = 2L;
        long rightLimit = 50L;
        return (leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
    }
    public long generatingRandomLongForLotSize() {
        long leftLimit = 200L;
        long rightLimit = 400L;
        return (leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
    }
    public double generateDoubleForIssuePrice() {
        double start = 100;
        double end = 1000;
        double random = new Random().nextDouble();
        return (start + (random * (end - start)));
    }

    public int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public LocalDate createRandomIssueDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}

