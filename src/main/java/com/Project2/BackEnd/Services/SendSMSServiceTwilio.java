package com.Project2.BackEnd.Services;

import com.Project2.BackEnd.Config.TwilioConfig;
import com.Project2.BackEnd.Dto.SMSDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendSMSServiceTwilio {

    @Autowired
    private TwilioConfig twilioConfig;

    public void sendSMS(SMSDto request){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        Message.creator(
                new com.twilio.type.PhoneNumber(request.getTo()),
                new com.twilio.type.PhoneNumber(request.getFrom()),
                request.getBody()
        ).create();

    }

}
