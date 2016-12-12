/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Account;
import wad.domain.Log;
import wad.repository.LogRepository;

/**
 *
 * @author ottomaki
 */
@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void addLog(String text, Account account) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Log log = new Log(dtf.format(now)+ " : " + text, account);

    }
}
