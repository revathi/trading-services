package net.springboot.ipotrading.service;

import net.springboot.ipotrading.model.Ipo;
import net.springboot.ipotrading.repository.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class IpoServiceImpl implements IpoService {

    @Autowired
    private IpoRepository ipoRepository;

    @Override
    public void save(Ipo ipo) {
        DecimalFormat df2 = new DecimalFormat("#.##");
        double result=generateDoubleForIssuePrice();
        ipo.setIssuePrice(Double.parseDouble(df2.format(result)));
        long issueSize=generatingRandomLongForIssueSize();
        ipo.setIssueSize(issueSize);
        long lotSize=generatingRandomLongForLotSize();
        ipo.setLotSize(lotSize);
        LocalDate issueDate=createRandomIssueDate();
        LocalDate closingDate=issueDate.plusDays(20);
        String formattedDate = issueDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        String formattedClosingDate = closingDate.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
        ipo.setIssueDate(formattedDate);
        ipo.setClosingDate(formattedClosingDate);
        String des=ipo.getCompanyName().concat(" issues shares as on ").concat(formattedDate);
        ipo.setDescription(des);
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
        long leftLimit = 2000L;
        long rightLimit = 5000L;
        return (leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
    }
    public long generatingRandomLongForLotSize() {
        long leftLimit = 600L;
        long rightLimit = 1000L;
        return (leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));
    }
    public double generateDoubleForIssuePrice() {
        double start = 5000;
        double end = 100000;
        double random = new Random().nextDouble();
        return (start + (random * (end - start)));
    }

    public int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public LocalDate createRandomIssueDate() {
        LocalDate today = LocalDate.now();
        int d=today.getDayOfMonth();
        int mon = today.getMonthValue();
        int y=today.getYear();
        int day = createRandomIntBetween(d, 28);
        int month = createRandomIntBetween(mon, 12);
        int year = createRandomIntBetween(y,y+1);
        return LocalDate.of(year, month, day);
    }
}

