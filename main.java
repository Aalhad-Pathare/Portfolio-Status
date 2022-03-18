package com.twilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendSms {

    public static final String ACCOUNT_sid   = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    public static void main(String[] args) throws IOException{
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR, 19);
        date.set(Calendar.MINUTE, 30);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        timer.schedule(
                new TimerTask() {
                    SendMessage(CreateMessage());
                },
                date.getTime(),
                1000 * 60 * 60 * 24
        );
        SendMessage(CreateMessage());
    }  




    public static String CreateMessage(){
        StringBuilder text_body = new StringBuilder();

        final String[] SYM = System.getenv("SYMBOLS");
        final int[] COUNT = System.getenv("STOCK_COUNTS");
        final float[] BUY = System.getenv("BUY_PRICE");
        
        text_body.append("Current Stock Positions: \n");
        
        float totalVal = 0.0;

        for(int i = 0; i < SYM.lenght; i++){
            String ticker = SYM[i];
            float price =YahooFinance.get(ticker);
            float value = COUNT[i] * price;
            float percentgain = ((value - BUY[i]) / BUY[i]) * 100;
            totalVal += value;

            text_body.append("Ticker: " + ticker + "\n" + "Price: " + price + "\nValue: " + value + "\nPercent Gain: " + percentgain + "\n\n");
            
        }
        text_body.append("Total Value: " + totalVal + "\n");

        return text_body.toString();


    }




    public static void SendMessage(String s){
        Twilio.init(ACCOUNT_sid, AUTH_TOKEN);

        


        Message message = Message.Creator(
            new PhoneNumber(System.getenv("MY_NUMBER")), 
            new PhoneNumber(System.getenv("SENDING_NUMBER")),
            s;
        ).create();

        System.out.println(message.getSid());
    }
    


}
