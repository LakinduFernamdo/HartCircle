package com.Project2.BackEnd.Controller;

import com.Project2.BackEnd.Dto.SMSDto;
import com.Project2.BackEnd.Services.SendSMSServiceTwilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/sms")
public class SMSController {

    @Autowired
    private SendSMSServiceTwilio sendSMSServiceTwilio;

    @PostMapping("/send")
    public ResponseEntity<String> sendSMS(@RequestBody SMSDto smsDto){
        try {
            sendSMSServiceTwilio.sendSMS(smsDto);
            return ResponseEntity.ok("SMS sent successfully!");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send SMS: " + e.getMessage());
        }

    }

}
